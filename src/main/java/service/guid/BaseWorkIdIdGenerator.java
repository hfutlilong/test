package service.guid;

import javax.annotation.Resource;

/**
 * 基于workId的全局唯一Id生成器
 */
public abstract class BaseWorkIdIdGenerator<T> implements IdGenerator<T> {

    @Resource(name = "dbWorkIdResolver")
    private WorkIdResolver workIdResolver;

    protected Long getWorkId() {
        return workIdResolver.resolveWorkId();
    }

}
