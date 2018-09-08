package test;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("classpath:PostConstructAndPreDestroy.xml");
        PostConstructAndPreDestroy cust = (PostConstructAndPreDestroy)context.getBean("postConstructAndPreDestroy");
        System.out.println(cust);
        context.close();
    }
}
