package event.impl;

import event.BaseEventListener;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author lilong
 * @Date 2019-04-28 16:21
 */
@Component
public class AEventListener extends BaseEventListener<AEvent> {
    @Override
    public void onEvent(AEvent event) {
        System.out.println("#### 事件id：" + event.getEventId());
        System.out.println("#### 事件内容：" + event.getMsg());
    }
}
