package event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Description 发布事件
 * @Author lilong
 * @Date 2019-04-28 16:12
 */
@Component
public class EventPublisher implements ApplicationContextAware {
    private ApplicationContext ctx;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }

    public void publish(BaseEvent event) {
        ctx.publishEvent(event);
    }
}
