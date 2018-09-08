//package test;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import service.impl.SimpleJobServiceImpl;
//
//public class TestSpring {
//    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//        System.out.println("context启动成功！");
//        SimpleJobServiceImpl job = context.getBean(SimpleJobServiceImpl.class);
//        job.execute();
//    }
//}
