package service.guid;

/**
 * 全局唯一id生成器
 * global unique id generator
 */
public interface IdGenerator<T> {
    T generateId();


}