package service.impl;

import common.annotation.RunInTransactional;
import common.constants.LogConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * @Description 测试事务id
 * @Author lilong
 * @Date 2019-03-11 16:19
 */
@Service
public class TestTransactional {
    @Autowired
    private TestTransactionalPropagation testTransactionalPropagation;

    @RunInTransactional
    public void testTransactionalName() {
        String txName = TransactionSynchronizationManager.getCurrentTransactionName();
        LogConstant.BUS.info("\n  ############ main transaction name is:{}.", txName);

        testTransactionalPropagation.testNested();
        testTransactionalPropagation.testRequired();
        testTransactionalPropagation.testRequiresNew();
    }
}
