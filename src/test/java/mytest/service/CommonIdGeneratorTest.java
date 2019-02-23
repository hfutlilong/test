package mytest.service;

import com.alibaba.fastjson.JSON;
import mytest.base.BaseTest;
import org.testng.annotations.Test;
import service.guid.CommonIdGenerator;
import service.guid.GuidBO;

import javax.annotation.Resource;

public class CommonIdGeneratorTest extends BaseTest {
    @Resource
    private CommonIdGenerator commonIdGenerator;

    @Test
    public void testGenerateId() {
        long guid = commonIdGenerator.generateId();
        System.out.println("############## guid:" + guid);

        GuidBO guidBO = commonIdGenerator.parseGUID(guid);
        System.out.println("############## guidBO:" + JSON.toJSONString(guidBO));
    }
}
