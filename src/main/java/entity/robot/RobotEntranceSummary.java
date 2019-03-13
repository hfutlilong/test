package entity.robot;

import java.io.Serializable;

/**
 * @Description 机器人入口配置摘要信息
 * @Author lilong
 * @Date 2019-03-04 11:43
 */
public class RobotEntranceSummary implements Serializable {

    private static final long serialVersionUID = -5665999152933926711L;

    /**
     * 入口id
     */
    private Long id;

    /**
     * 入口名称
     */
    private String entranceName;

    /**
     * 生效开关 0-停用，1-启用
     */
    private Integer effectSwitch;

    /**
     * 入口来源id 逗号分开
     */
    private String entranceSource;

    /**
     * 相关一级类目id  逗号分开
     */
    private String relatedOneLevelCategory;

    /**
     * 相关品牌id 逗号分开
     */
    private String relatedBrand;

    /**
     * 修改人
     */
    private String operator;

    /**
     * 修改时间
     */
    private String updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEntranceName() {
        return entranceName;
    }

    public void setEntranceName(String entranceName) {
        this.entranceName = entranceName;
    }

    public Integer getEffectSwitch() {
        return effectSwitch;
    }

    public void setEffectSwitch(Integer effectSwitch) {
        this.effectSwitch = effectSwitch;
    }

    public String getEntranceSource() {
        return entranceSource;
    }

    public void setEntranceSource(String entranceSource) {
        this.entranceSource = entranceSource;
    }

    public String getRelatedOneLevelCategory() {
        return relatedOneLevelCategory;
    }

    public void setRelatedOneLevelCategory(String relatedOneLevelCategory) {
        this.relatedOneLevelCategory = relatedOneLevelCategory;
    }

    public String getRelatedBrand() {
        return relatedBrand;
    }

    public void setRelatedBrand(String relatedBrand) {
        this.relatedBrand = relatedBrand;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}