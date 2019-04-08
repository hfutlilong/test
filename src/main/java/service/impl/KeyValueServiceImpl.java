package service.impl;

import dao.gen.mapper.KeyValueJsonPOMapperExt;
import dao.gen.po.KeyValueJsonPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.KeyValueService;
import utils.distributed.annotation.ZkLock;

/**
 * @Description key-value
 * @Author lilong
 * @Date 2019-04-03 16:45
 */
@Service
public class KeyValueServiceImpl implements KeyValueService {
    @Autowired
    private KeyValueJsonPOMapperExt keyValueJsonPOMapper;

    @Override
//    @ZkLock(zkHost = "192.168.160.128:2181", bizType = "test", lockKey = "queryKeyValue", timeout = 3000)
    public KeyValueJsonPO queryKeyValue(String bizType, String key) {
        return keyValueJsonPOMapper.queryKeyValue(bizType, key);
    }

    @Override
    public int updateKeyValue(KeyValueJsonPO keyValueJsonPO) {
        return keyValueJsonPOMapper.updateKeyValue(keyValueJsonPO);
    }

    @Override
    public int insertKeyValue(KeyValueJsonPO keyValueJsonPO) {
        return keyValueJsonPOMapper.insertKeyValue(keyValueJsonPO);
    }
}
