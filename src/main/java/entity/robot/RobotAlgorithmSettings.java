package entity.robot;

import java.io.Serializable;

/**
 * @Description 机器人算法能力设置
 * @Author lilong
 * @Date 2019-03-04 11:41
 */
public class RobotAlgorithmSettings implements Serializable {

    private static final long serialVersionUID = -3618915001641909873L;

    /**
     * 检索模型
     */
    private RetrievalModel retrievalModel;

    /**
     * 关键词模型
     */
    private KeywordModel keywordModel;

    /**
     * 寒暄模型
     */
    private GreetingModel greetingModel;

    public RetrievalModel getRetrievalModel() {
        return retrievalModel;
    }

    public void setRetrievalModel(RetrievalModel retrievalModel) {
        this.retrievalModel = retrievalModel;
    }

    public KeywordModel getKeywordModel() {
        return keywordModel;
    }

    public void setKeywordModel(KeywordModel keywordModel) {
        this.keywordModel = keywordModel;
    }

    public GreetingModel getGreetingModel() {
        return greetingModel;
    }

    public void setGreetingModel(GreetingModel greetingModel) {
        this.greetingModel = greetingModel;
    }
}
