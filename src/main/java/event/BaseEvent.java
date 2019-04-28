package event;

import org.springframework.context.ApplicationEvent;
import service.guid.CommonIdGenerator;
import utils.SpringContextUtil;

/**
 * @Description 事件父类
 * @Author lilong
 * @Date 2019-04-28 16:03
 */
public abstract class BaseEvent extends ApplicationEvent {
    private Long eventId;

    public BaseEvent() {
        super(0);
        CommonIdGenerator commonIdGenerator = SpringContextUtil.getBean("commonIdGenerator", CommonIdGenerator.class);
        eventId = commonIdGenerator.generateId();
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }
}
