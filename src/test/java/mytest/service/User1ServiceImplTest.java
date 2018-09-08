package mytest.service;

import mytest.base.BaseTest;
import org.testng.annotations.Test;
import transcational.UserTransational;

import javax.annotation.Resource;

public class User1ServiceImplTest extends BaseTest {
    @Resource
    private UserTransational userTransational;

    @Test
    public void testTransational(){
        userTransational.transaction_required_requiresNew_requiresNew_exception_try();
    }
}
