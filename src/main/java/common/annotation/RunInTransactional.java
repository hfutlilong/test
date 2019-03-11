package common.annotation;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Transactional(rollbackFor = {Exception.class})
@Documented
public @interface RunInTransactional {
    Propagation propagation() default Propagation.REQUIRED;
}