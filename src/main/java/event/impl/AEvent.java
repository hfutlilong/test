package event.impl;

import event.BaseEvent;

/**
 * @Description 事件
 * @Author lilong
 * @Date 2019-04-28 16:19
 */
public class AEvent extends BaseEvent {
    /**
     * 事件消息
     */
    private String msg;

    public AEvent() {};

    public AEvent(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
