package mytest.others.other;

import com.alibaba.fastjson.JSON;
import common.enums.KeyValueBizTypeEnum;
import dao.gen.mapper.KeyValuePOMapper;
import dao.gen.mapper.KeyValuePOMapperExt;
import dao.gen.po.KeyValuePO;
import dao.gen.po.KeyValuePOExample;
import mytest.base.BaseTest;
import org.testng.annotations.Test;
import utils.SpringContextUtil;

import java.util.List;

/**
 * @Description TODO
 * @Author lilong
 * @Date 2019-02-18 15:07
 */
public class SpringContextTest extends BaseTest {
    private static final long SEQUENCE_BITS = 12L; // 12位序列号

    private static final long WORKER_ID_BITS = 10L; // 10位workId号

    private static final long SEQUENCE_MASK = (1 << SEQUENCE_BITS) - 1;

    private static final long WORKER_ID_LEFT_SHIFT_BITS = SEQUENCE_BITS;

    private static final long TIMESTAMP_LEFT_SHIFT_BITS = WORKER_ID_LEFT_SHIFT_BITS + WORKER_ID_BITS;

    @Test
    public void test() {
        KeyValuePOMapper keyValuePOMapper = SpringContextUtil.getBean("keyValuePOMapperExt", KeyValuePOMapperExt.class);
        KeyValuePOExample keyValuePOExample = new KeyValuePOExample();
        keyValuePOExample.createCriteria().andKeyEqualTo("GUID_WORK_ID").andBizTypeEqualTo(KeyValueBizTypeEnum.DEFAULT);
        List<KeyValuePO> keyValuePOList = keyValuePOMapper.selectByExample(keyValuePOExample);
        System.out.println("####" + JSON.toJSONString(keyValuePOList) + "####");
    }

}
