package service.guid;

import com.alibaba.fastjson.JSON;
import common.constants.LogConstant;
import common.enums.KeyValueBizTypeEnum;
import dao.gen.mapper.KeyValuePOMapperExt;
import dao.gen.po.KeyValuePO;
import dao.gen.po.KeyValuePOExample;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utils.NetwokUtils;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 *
 * 基于数据库的workId配置方式。
 */
@Service("dbWorkIdResolver")
public class DbWorkIdResolver implements WorkIdResolver {

    private static final String KEY = "GUID_WORK_ID";

    private static final long WORKER_ID_MAX_VALUE = 1L << 10;

    private static final String IP;

    private volatile Long workId;

    private CountDownLatch countDownLatch = new CountDownLatch(1);

    @Autowired
    private KeyValuePOMapperExt keyValuePOMapper;

    static {
        IP = NetwokUtils.getLocalhost();
    }

    /**
     * 返回0 ~ 1023之间的workId，最大支持1024台机器
     *
     * @return
     */
    @Override
    public long resolveWorkId() {
        if (null == workId) {
            try {
                countDownLatch.await();
            } catch (Exception e) {
                LogConstant.BUS.error("DbWorkIdResolver resolveWorkId error", e);
            }
        }
        return workId;
    }

    @PostConstruct
    private void init() {
        try {
            /*
             * 如果没有获取到IP，使用 200 ~ 1023 之间的随机数（降级）
             */
            if (NetwokUtils.ANYHOST.equals(IP) || NetwokUtils.LOCALHOST.equals(IP)) {
                workId = genRandomWorkId();
                return;
            }

            /*
             * 根据IP从数据库中获取workId，最多尝试5次获取workId（防止乐观锁冲突）
             */
            String ipKey = IP.replaceAll("\\.", "_");
            int retryCount = 5;
            while (retryCount-- > 0) {
                try {
                    KeyValuePOExample keyValuePOExample = new KeyValuePOExample();
                    keyValuePOExample.createCriteria().andKeyEqualTo(KEY).andBizTypeEqualTo(KeyValueBizTypeEnum.DEFAULT);
                    List<KeyValuePO> keyValuePOList = keyValuePOMapper.selectByExample(keyValuePOExample);

                    if (CollectionUtils.isNotEmpty(keyValuePOList)) {
                        KeyValuePO keyValuePO = keyValuePOList.get(0);
                        WorkIdData workIdData =  JSON.parseObject(keyValuePO.getValue(), WorkIdData.class);
                        Map<String, Long> workIdsMap = workIdData.getWorkIdsMap();

                        if (null != workIdsMap.get(ipKey)) {
                            workId = workIdsMap.get(ipKey);
                            break;
                        } else {
                            workIdData.setLastWorkId(workIdData.getLastWorkId() + 1);
                            checkWorkerId(workIdData.getLastWorkId());
                            workIdsMap.put(ipKey, workIdData.getLastWorkId());
                            //根据DbUpdateTime字段使用乐观锁
                            keyValuePOExample.getOredCriteria().get(0).andDbUpdateTimeEqualTo(keyValuePO.getDbUpdateTime());
                            KeyValuePO updatePO = new KeyValuePO();
                            updatePO.setValue(JSON.toJSONString(workIdData));
                            int updateCount = keyValuePOMapper.updateByExampleSelective(updatePO, keyValuePOExample);
                            if (updateCount == 1) {
                                workId = workIdsMap.get(ipKey);
                                break;
                            }
                        }
                    } else {
                        WorkIdData workIdData = new WorkIdData();
                        Map<String, Long> workIdsMap = new HashMap<>(1);
                        workIdsMap.put(ipKey, 0L);
                        workIdData.setWorkIdsMap(workIdsMap);
                        workIdData.setLastWorkId(0L);

                        KeyValuePO insertPO = new KeyValuePO();
                        insertPO.setKey(KEY);
                        insertPO.setBizType(KeyValueBizTypeEnum.DEFAULT);
                        insertPO.setValue(JSON.toJSONString(workIdData));
                        int insertCount = keyValuePOMapper.insertSelective(insertPO);
                        if (insertCount == 1) {
                            workId = workIdsMap.get(ipKey);
                            break;
                        }
                    }
                } catch (Exception e) {
                    LogConstant.BUS.error("try resolve workId from db fail, remaining " + retryCount, e);
                }
            }

            if (null == workId) { // 降级为随机workId
                workId = DbWorkIdResolver.genRandomWorkId();
            }
            LogConstant.BUS.info("try resolve workId from db success, workId=" + workId);
        } finally {
            countDownLatch.countDown();
        }
    }

    private void checkWorkerId(long workId) {
        if (workId >= 0L && workId < WORKER_ID_MAX_VALUE) {
            return;
        }

        throw new RuntimeException("workerId is overflow, attempt " + workId + " but max is " + WORKER_ID_MAX_VALUE);
    }

    /**
     * 产生 200 ~ 999 之间的随机数
     *
     * @return
     */
    private static Long genRandomWorkId() {
        return Long.valueOf(new Random().nextInt(800) + 200);
    }

    /**
     * <p>
     * 存放所有的workId和最近被使用的workdId。workIdsMap: key is IP, value is workId。lastWorkId: 最近被使用的workId数值
     */
    private static class WorkIdData implements Serializable {
        private static final long serialVersionUID = 539380365387371853L;

        private Map<String, Long> workIdsMap;

        private long lastWorkId;

        public Map<String, Long> getWorkIdsMap() {
            return workIdsMap;
        }

        public void setWorkIdsMap(Map<String, Long> workIdsMap) {
            this.workIdsMap = workIdsMap;
        }

        public long getLastWorkId() {
            return lastWorkId;
        }

        public void setLastWorkId(long lastWorkId) {
            this.lastWorkId = lastWorkId;
        }

        @Override
        public String toString() {
            return "WorkIdData{" + "workIdsMap=" + workIdsMap + ", lastWorkId=" + lastWorkId + '}';
        }
    }

    @Override
    public String parseWorkerIp(Long workId) {
        if (workId == null) {
            return null;
        }

        KeyValuePOExample keyValuePOExample = new KeyValuePOExample();
        keyValuePOExample.createCriteria().andKeyEqualTo(KEY).andBizTypeEqualTo(KeyValueBizTypeEnum.DEFAULT);
        List<KeyValuePO> keyValuePOList = keyValuePOMapper.selectByExample(keyValuePOExample);

        if (CollectionUtils.isEmpty(keyValuePOList)) {
            return null;
        }

        KeyValuePO keyValuePO = keyValuePOList.get(0);
        WorkIdData workIdData =  JSON.parseObject(keyValuePO.getValue(), WorkIdData.class);
        Map<String, Long> workIdsMap = workIdData.getWorkIdsMap();

        for (Map.Entry<String, Long> entry : workIdsMap.entrySet()) {
            String key = entry.getKey();
            Long value = entry.getValue();

            if (workId.equals(value)) {
                return key.replaceAll("_", "\\.");
            }
        }

        return null;
    }

}

