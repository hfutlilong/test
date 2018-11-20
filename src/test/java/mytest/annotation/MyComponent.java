package mytest.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @Description MyComponent注解
 * @Author lilong
 * @Date 2018-11-20 20:18
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface MyComponent {
    String value() default "";
}