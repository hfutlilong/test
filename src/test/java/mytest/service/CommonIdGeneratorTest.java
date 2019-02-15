package mytest.service;

import mytest.base.BaseTest;
import org.testng.annotations.Test;
import service.guid.CommonIdGenerator;

import javax.annotation.Resource;

public class CommonIdGeneratorTest extends BaseTest {
    @Resource
    private CommonIdGenerator commonIdGenerator;

    @Test
    public void testGenerateId() {
        long guid = commonIdGenerator.generateId();
        System.out.println("############## guid:" + guid);
    }
}
