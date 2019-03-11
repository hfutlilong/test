package service.impl;

import common.annotation.RunInTransactional;
import common.constants.LogConstant;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * @Description 测试事务传播机制
 * @Author lilong
 * @Date 2019-03-11 10:13
 */
@Service
public class TestTransactionalPropagation {
    /**
     * 嵌入式事务
     */
    @RunInTransactional(propagation = Propagation.NESTED)
    public void testNested() {
        String txName = TransactionSynchronizationManager.getCurrentTransactionName();
        LogConstant.BUS.info("\n  ############## sub testNested transaction name is: {}.", txName);
    }

    /**
     * REQUIRED
     */
    @RunInTransactional(propagation = Propagation.REQUIRED)
    public void testRequired() {
        String txName = TransactionSynchronizationManager.getCurrentTransactionName();
        LogConstant.BUS.info("\n  ############## sub testRequired transaction name is: {}.", txName);
    }

    /**
     * REQUIRES_NEW
     */
    @RunInTransactional(propagation = Propagation.REQUIRES_NEW)
    public void testRequiresNew() {
        String txName = TransactionSynchronizationManager.getCurrentTransactionName();
        LogConstant.BUS.info("\n  ############## sub testRequiresNew transaction name is: {}.", txName);
    }
}
