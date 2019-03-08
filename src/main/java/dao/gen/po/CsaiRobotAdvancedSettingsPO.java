package dao.gen.po;

import entity.AdvancedRobotSettingsDTO;
import java.io.Serializable;
import java.util.Date;

public class CsaiRobotAdvancedSettingsPO implements Serializable {
    private Long id;

    private Long corpId;

    private AdvancedRobotSettingsDTO advancedSettings;

    private String creator;

    private Date createTime;

    private String updator;

    private Date updateTime;

    private Date dbUpdateTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCorpId() {
        return corpId;
    }

    public void setCorpId(Long corpId) {
        this.corpId = corpId;
    }

    public AdvancedRobotSettingsDTO getAdvancedSettings() {
        return advancedSettings;
    }

    public void setAdvancedSettings(AdvancedRobotSettingsDTO advancedSettings) {
        this.advancedSettings = advancedSettings;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdator() {
        return updator;
    }

    public void setUpdator(String updator) {
        this.updator = updator == null ? null : updator.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getDbUpdateTime() {
        return dbUpdateTime;
    }

    public void setDbUpdateTime(Date dbUpdateTime) {
        this.dbUpdateTime = dbUpdateTime;
    }
}