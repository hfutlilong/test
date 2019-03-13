package entity.robot;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Description 算法能力设置——关键词模型
 * @Author lilong
 * @Date 2019-03-12 11:51
 */
public class KeywordModel implements Serializable {

    private static final long serialVersionUID = 1181658312952436234L;

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
