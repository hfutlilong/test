//package transcational;
//
//import dao.gen.po.User1;
//import dao.gen.po.User2;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;
//import service.User1Service;
//import service.User2Service;
//
//import javax.annotation.Resource;
//
//@Service
//public class UserTransational {
//    @Resource
//    private User1Service user1Service;
//
//    @Resource
//    private User2Service user2Service;
//
//    /**
//     * #####################################
//     * 1.PROPAGATION_REQUIRED
//     * #####################################
//     */
//
//    /**
//     * Case1.1: 外围方法没有开启事务
//     */
//    public void notransaction_exception_required_required() {
//        User1 user1 = new User1();
//        user1.setName("张三");
//        user1Service.addRequired(user1);
//
//        User2 user2 = new User2();
//        user2.setName("李四");
//        user2Service.addRequiredException(user2);
//
//        throw new RuntimeException();
//    }
//
//    public void notransaction_required_required_exception() {
//        User1 user1 = new User1();
//        user1.setName("张三");
//        user1Service.addRequired(user1);
//
//        User2 user2 = new User2();
//        user2.setName("李四");
//        user2Service.addRequiredException(user2);
//    }
//
//    /**
//     * Case1.2:外围方法开启事务
//     */
//    @Transactional
//    public void transaction_exception_required_required(){
//        User1 user1 = new User1();
//        user1.setName("张三");
//        user1Service.addRequired(user1);
//
//        User2 user2 = new User2();
//        user2.setName("李四");
//        user2Service.addRequired(user2);
//
//        throw new RuntimeException();
//    }
//
//    @Transactional(propagation = Propagation.REQUIRED)
//    public void transaction_required_required_exception(){
//        User1 user1 = new User1();
//        user1.setName("张三");
//        user1Service.addRequired(user1);
//
//        User2 user2 = new User2();
//        user2.setName("李四");
//        user2Service.addRequiredException(user2);
//    }
//
//    @Transactional
//    public void transaction_required_required_exception_try(){
//        User1 user1 = new User1();
//        user1.setName("张三");
//        user1Service.addRequired(user1);
//
//        User2 user2 = new User2();
//        user2.setName("李四");
//        try {
//            user2Service.addRequiredException(user2);
//        } catch (Exception e) {
//            System.out.println("方法回滚");
//        }
//    }
//
//
//    /**
//     * #####################################
//     * 2.PROPAGATION_REQUIRES_NEW
//     * #####################################
//     */
//
//    /**
//     * Case2.1: 外围方法没有开启事务
//     */
//    public void notransaction_exception_requiresNew_requiresNew(){
//        User1 user1=new User1();
//        user1.setName("张三");
//        user1Service.addRequiresNew(user1);
//
//        User2 user2=new User2();
//        user2.setName("李四");
//        user2Service.addRequiresNew(user2);
//        throw new RuntimeException();
//
//    }
//
//    public void notransaction_requiresNew_requiresNew_exception(){
//        User1 user1=new User1();
//        user1.setName("张三");
//        user1Service.addRequiresNew(user1);
//
//        User2 user2=new User2();
//        user2.setName("李四");
//        user2Service.addRequiresNewException(user2);
//    }
//
//    /**
//     * Case2.2:外围方法开启事务
//     */
//    @Transactional(propagation = Propagation.REQUIRED)
//    public void transaction_exception_required_requiresNew_requiresNew(){
//        User1 user1=new User1();
//        user1.setName("张三");
//        user1Service.addRequired(user1);
//
//        User2 user2=new User2();
//        user2.setName("李四");
//        user2Service.addRequiresNew(user2);
//
//        User2 user3=new User2();
//        user3.setName("王五");
//        user2Service.addRequiresNew(user3);
//        throw new RuntimeException();
//    }
//
//    @Transactional(propagation = Propagation.REQUIRED)
//    public void transaction_required_requiresNew_requiresNew_exception(){
//        User1 user1=new User1();
//        user1.setName("张三");
//        user1Service.addRequired(user1);
//
//        User2 user2=new User2();
//        user2.setName("李四");
//        user2Service.addRequiresNew(user2);
//
//        User2 user3=new User2();
//        user3.setName("王五");
//        user2Service.addRequiresNewException(user3);
//    }
//
//    @Transactional(propagation = Propagation.REQUIRED)
//    public void transaction_required_requiresNew_requiresNew_exception_try(){
//        User1 user1=new User1();
//        user1.setName("张三");
//        user1Service.addRequired(user1);
//
//        User2 user2=new User2();
//        user2.setName("李四");
//        user2Service.addRequiresNew(user2);
//        User2 user3=new User2();
//        user3.setName("王五");
//        try {
//            user2Service.addRequiresNewException(user3);
//        } catch (Exception e) {
//            System.out.println("回滚");
//        }
//    }
//}
