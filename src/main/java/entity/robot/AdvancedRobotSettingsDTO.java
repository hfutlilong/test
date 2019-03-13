package entity.robot;

import java.io.Serializable;

/**
 * @Description 机器人高级设置
 * @Author lilong
 * @Date 2019-02-26 17:13
 */
public class AdvancedRobotSettingsDTO implements Serializable {

    private static final long serialVersionUID = -4761149770995006002L;

    /**
     * 机器人答案评价  0-关闭，1-打开
     */
    private Integer robotAnswerEvaluation;

    /**
     * 询问差评原因  0-关闭，1-打开
     */
    private Integer askBadCommentReason;

    /**
     * 机器人答案评价设置
     */
    private String robotAnswerEvaluationSettings;

    /**
     * 访客输入联想。0-关闭，1-打开
     */
    private Integer robotDialogueInputAssociation;

    /**
     * 页面机器人拒识后，由默认机器人兜底。0-关闭，1-打开
     */
    private Integer useDefaultRobotAsBottomPlan;

    public Integer getRobotAnswerEvaluation() {
        return robotAnswerEvaluation;
    }

    public void setRobotAnswerEvaluation(Integer robotAnswerEvaluation) {
        this.robotAnswerEvaluation = robotAnswerEvaluation;
    }

    public Integer getAskBadCommentReason() {
        return askBadCommentReason;
    }

    public void setAskBadCommentReason(Integer askBadCommentReason) {
        this.askBadCommentReason = askBadCommentReason;
    }

    public String getRobotAnswerEvaluationSettings() {
        return robotAnswerEvaluationSettings;
    }

    public void setRobotAnswerEvaluationSettings(String robotAnswerEvaluationSettings) {
        this.robotAnswerEvaluationSettings = robotAnswerEvaluationSettings;
    }

    public Integer getRobotDialogueInputAssociation() {
        return robotDialogueInputAssociation;
    }

    public void setRobotDialogueInputAssociation(Integer robotDialogueInputAssociation) {
        this.robotDialogueInputAssociation = robotDialogueInputAssociation;
    }

    public Integer getUseDefaultRobotAsBottomPlan() {
        return useDefaultRobotAsBottomPlan;
    }

    public void setUseDefaultRobotAsBottomPlan(Integer useDefaultRobotAsBottomPlan) {
        this.useDefaultRobotAsBottomPlan = useDefaultRobotAsBottomPlan;
    }
}
