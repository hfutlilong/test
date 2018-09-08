package common.aspect;

import common.enums.DataSourceEnum;

import java.lang.annotation.*;

/**
 * @ClassName: DataSourceSelect
 * @Description: 数据源选择注解
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSourceSelect {

    /**
     *
     * @Description: 数据源值，默认为主库
     * @return
     */
    DataSourceEnum value() default DataSourceEnum.READ_WRITE_DATA_SOURCE;
}