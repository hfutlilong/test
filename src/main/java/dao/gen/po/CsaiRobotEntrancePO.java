package dao.gen.po;

import java.io.Serializable;
import java.util.Date;

public class CsaiRobotEntrancePO implements Serializable {
    private Long id;

    private String robotId;

    private Long corpId;

    private String entranceName;

    private String entranceSource;

    private String relatedOneLevelCategory;

    private String relatedBrand;

    private Byte effectSwitch;

    private String operator;

    private Date createTime;

    private Date dbUpdateTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRobotId() {
        return robotId;
    }

    public void setRobotId(String robotId) {
        this.robotId = robotId == null ? null : robotId.trim();
    }

    public Long getCorpId() {
        return corpId;
    }

    public void setCorpId(Long corpId) {
        this.corpId = corpId;
    }

    public String getEntranceName() {
        return entranceName;
    }

    public void setEntranceName(String entranceName) {
        this.entranceName = entranceName == null ? null : entranceName.trim();
    }

    public String getEntranceSource() {
        return entranceSource;
    }

    public void setEntranceSource(String entranceSource) {
        this.entranceSource = entranceSource == null ? null : entranceSource.trim();
    }

    public String getRelatedOneLevelCategory() {
        return relatedOneLevelCategory;
    }

    public void setRelatedOneLevelCategory(String relatedOneLevelCategory) {
        this.relatedOneLevelCategory = relatedOneLevelCategory == null ? null : relatedOneLevelCategory.trim();
    }

    public String getRelatedBrand() {
        return relatedBrand;
    }

    public void setRelatedBrand(String relatedBrand) {
        this.relatedBrand = relatedBrand == null ? null : relatedBrand.trim();
    }

    public Byte getEffectSwitch() {
        return effectSwitch;
    }

    public void setEffectSwitch(Byte effectSwitch) {
        this.effectSwitch = effectSwitch;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getDbUpdateTime() {
        return dbUpdateTime;
    }

    public void setDbUpdateTime(Date dbUpdateTime) {
        this.dbUpdateTime = dbUpdateTime;
    }
}