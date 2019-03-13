package entity.robot;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Description 算法能力设置——寒暄模型
 * @Author lilong
 * @Date 2019-03-12 11:52
 */
public class GreetingModel implements Serializable {

    private static final long serialVersionUID = 1602214714680051501L;

    /**
     * 精准回答阈值
     */
    private BigDecimal accurateAnswerThreshold;

    /**
     * 优先级
     */
    private Byte priority;

    public BigDecimal getAccurateAnswerThreshold() {
        return accurateAnswerThreshold;
    }

    public void setAccurateAnswerThreshold(BigDecimal accurateAnswerThreshold) {
        this.accurateAnswerThreshold = accurateAnswerThreshold;
    }

    public Byte getPriority() {
        return priority;
    }

    public void setPriority(Byte priority) {
        this.priority = priority;
    }
}

