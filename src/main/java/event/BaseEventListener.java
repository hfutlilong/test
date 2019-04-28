package event;

import org.springframework.context.ApplicationListener;

/**
 * @Description 事件监听者
 * @Author lilong
 * @Date 2019-04-28 16:22
 */
public abstract class BaseEventListener<E extends BaseEvent> implements ApplicationListener<E> {
    @Override
    public void onApplicationEvent(E event) {
        onEvent(event);
    }

    public abstract void onEvent(E event);
}
