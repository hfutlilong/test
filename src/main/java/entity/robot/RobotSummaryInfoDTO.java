package entity.robot;

import java.io.Serializable;

/**
 * @Description 机器人列表中展示的机器人的信息
 * @Author lilong
 * @Date 2019-03-04 14:44
 */
public class RobotSummaryInfoDTO implements Serializable {

    private static final long serialVersionUID = -1219758973317573143L;

    /**
     * 机器人id
     */
    private String robotId;

    /**
     * 机器人头像url
     */
    private String logoUrl;

    /**
     * 对内名称
     */
    private String internalName;

    /**
     * 机器人类型，0：普通机器人，1：默认机器人
     */
    private Integer robotType;

    /**
     * 机器人状态，0：停用，1：启用
     */
    private Integer robotStatus;

    /**
     * 基础设置是否已完成，0：已完成，1：未完成
     */
    private Integer baseSettingsDone;

    /**
     * 算法模块是否已完成，0：已完成，1：未完成
     */
    private Integer algirithmModelDone;

    /**
     * 知识类目是否已完成，0：已完成，1：未完成
     */
    private Integer knowledgeCategoryDone;

    /**
     * 入口来源是否已完成，0：已完成，1：未完成
     */
    private Integer entranceSourceDone;

    public String getRobotId() {
        return robotId;
    }

    public void setRobotId(String robotId) {
        this.robotId = robotId;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getInternalName() {
        return internalName;
    }

    public void setInternalName(String internalName) {
        this.internalName = internalName;
    }

    public Integer getRobotType() {
        return robotType;
    }

    public void setRobotType(Integer robotType) {
        this.robotType = robotType;
    }

    public Integer getRobotStatus() {
        return robotStatus;
    }

    public void setRobotStatus(Integer robotStatus) {
        this.robotStatus = robotStatus;
    }

    public Integer getBaseSettingsDone() {
        return baseSettingsDone;
    }

    public void setBaseSettingsDone(Integer baseSettingsDone) {
        this.baseSettingsDone = baseSettingsDone;
    }

    public Integer getAlgirithmModelDone() {
        return algirithmModelDone;
    }

    public void setAlgirithmModelDone(Integer algirithmModelDone) {
        this.algirithmModelDone = algirithmModelDone;
    }

    public Integer getKnowledgeCategoryDone() {
        return knowledgeCategoryDone;
    }

    public void setKnowledgeCategoryDone(Integer knowledgeCategoryDone) {
        this.knowledgeCategoryDone = knowledgeCategoryDone;
    }

    public Integer getEntranceSourceDone() {
        return entranceSourceDone;
    }

    public void setEntranceSourceDone(Integer entranceSourceDone) {
        this.entranceSourceDone = entranceSourceDone;
    }
}