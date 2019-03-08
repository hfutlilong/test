package common.factory;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description 日志工厂
 * @Author lilong
 * @Date 2019-03-08 19:53
 */
public class MyLoggerFactory {
    public MyLoggerFactory() {
    }

    public static Logger getLogger(String name) {
        return LoggerFactory.getLogger(name);
    }

    public static Logger getLogger(Class<?> clazz) {
        return LoggerFactory.getLogger(clazz);
    }

    public static ILoggerFactory getILoggerFactory() {
        return LoggerFactory.getILoggerFactory();
    }
}