package test.commontest;

import org.springframework.beans.factory.annotation.Autowired;
import service.TestService;

/**
 * @Description TODO
 * @Author lilong
 * @Date 2019-01-17 20:39
 */
public class SpringTest {
    private static TestService testService;

    public static void test() {
        testService.test();
    }

    @Autowired
    public static TestService getTestService() {
        return testService;
    }

    public static void setTestService(TestService testService) {
        SpringTest.testService = testService;
    }
}
