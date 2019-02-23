package service.guid;

/**
 * 全局唯一id生成器
 * global unique id generator
 */
public interface IdGenerator<T> {
    /**
     * 生成分布式全局唯一id
     * @return
     */
    T generateId();

    /**
     * 反解析id
     * @param id
     * @return
     */
    GuidBO parseId(Long id);
}