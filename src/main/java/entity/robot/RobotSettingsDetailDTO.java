package entity.robot;

import java.io.Serializable;
import java.util.List;

/**
 * @Description 机器人配置详细信息
 * @Author lilong
 * @Date 2019-03-13 16:22
 */
public class RobotSettingsDetailDTO implements Serializable {

    private static final long serialVersionUID = -8053027806355831504L;

    /**
     * 机器人开关，0-关，1-开
     */
    private Integer robotStatus;

    /**
     * 机器人类型 0：普通机器人，1：默认机器人
     */
    private Integer robotType;

    /**
     * 机器人头像、昵称等基本信息设置
     */
    private RobotBaseSettings robotBaseSettings;

    /**
     * 机器人算法能力设置
     */
    private RobotAlgorithmSettings robotAlgorithmSettings;

    /**
     * 绑定知识分类
     */
    private BindingKnowledgeCategory bindingKnowledgeCategory;

    /**
     * 入口配置摘要信息
     */
    private List<RobotEntranceSummary> robotEntranceSummary;

    public Integer getRobotStatus() {
        return robotStatus;
    }

    public void setRobotStatus(Integer robotStatus) {
        this.robotStatus = robotStatus;
    }

    public Integer getRobotType() {
        return robotType;
    }

    public void setRobotType(Integer robotType) {
        this.robotType = robotType;
    }

    public RobotBaseSettings getRobotBaseSettings() {
        return robotBaseSettings;
    }

    public void setRobotBaseSettings(RobotBaseSettings robotBaseSettings) {
        this.robotBaseSettings = robotBaseSettings;
    }

    public RobotAlgorithmSettings getRobotAlgorithmSettings() {
        return robotAlgorithmSettings;
    }

    public void setRobotAlgorithmSettings(RobotAlgorithmSettings robotAlgorithmSettings) {
        this.robotAlgorithmSettings = robotAlgorithmSettings;
    }

    public BindingKnowledgeCategory getBindingKnowledgeCategory() {
        return bindingKnowledgeCategory;
    }

    public void setBindingKnowledgeCategory(BindingKnowledgeCategory bindingKnowledgeCategory) {
        this.bindingKnowledgeCategory = bindingKnowledgeCategory;
    }

    public List<RobotEntranceSummary> getRobotEntranceSummary() {
        return robotEntranceSummary;
    }

    public void setRobotEntranceSummary(List<RobotEntranceSummary> robotEntranceSummary) {
        this.robotEntranceSummary = robotEntranceSummary;
    }
}