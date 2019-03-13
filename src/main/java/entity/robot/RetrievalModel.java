package entity.robot;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Description 算法能力设置——检索模型
 * @Author lilong
 * @Date 2019-03-12 11:51
 */
public class RetrievalModel implements Serializable {

    private static final long serialVersionUID = 6377341059593351105L;

    /**
     * 精准回答阈值
     */
    private BigDecimal accurateAnswerThreshold;

    /**
     * 推荐回答阈值
     */
    private BigDecimal recommendAnswerThreshold;

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

    public BigDecimal getRecommendAnswerThreshold() {
        return recommendAnswerThreshold;
    }

    public void setRecommendAnswerThreshold(BigDecimal recommendAnswerThreshold) {
        this.recommendAnswerThreshold = recommendAnswerThreshold;
    }

    public Byte getPriority() {
        return priority;
    }

    public void setPriority(Byte priority) {
        this.priority = priority;
    }
}
