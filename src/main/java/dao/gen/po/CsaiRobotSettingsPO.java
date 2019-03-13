package dao.gen.po;

import entity.enums.RobotStatusEnum;
import entity.enums.RobotTypeEnum;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CsaiRobotSettingsPO implements Serializable {
    private Long id;

    private String robotId;

    private Long corpId;

    private String logoUrl;

    private String internalName;

    private String externalName;

    private String remark;

    private RobotTypeEnum robotType;

    private RobotStatusEnum robotStatus;

    private BigDecimal searchAccurateAnswerThreshold;

    private BigDecimal searchRecommendAnswerThreshold;

    private Byte searchPriority;

    private BigDecimal keywordAccurateAnswerThreshold;

    private Byte keywordPriority;

    private BigDecimal greetingAccurateAnswerThreshold;

    private Byte greetingPriority;

    private String searchLibCategory;

    private String greetingLibCategory;

    private Byte syncalgorithm;

    private String robotToken;

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

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl == null ? null : logoUrl.trim();
    }

    public String getInternalName() {
        return internalName;
    }

    public void setInternalName(String internalName) {
        this.internalName = internalName == null ? null : internalName.trim();
    }

    public String getExternalName() {
        return externalName;
    }

    public void setExternalName(String externalName) {
        this.externalName = externalName == null ? null : externalName.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public RobotTypeEnum getRobotType() {
        return robotType;
    }

    public void setRobotType(RobotTypeEnum robotType) {
        this.robotType = robotType;
    }

    public RobotStatusEnum getRobotStatus() {
        return robotStatus;
    }

    public void setRobotStatus(RobotStatusEnum robotStatus) {
        this.robotStatus = robotStatus;
    }

    public BigDecimal getSearchAccurateAnswerThreshold() {
        return searchAccurateAnswerThreshold;
    }

    public void setSearchAccurateAnswerThreshold(BigDecimal searchAccurateAnswerThreshold) {
        this.searchAccurateAnswerThreshold = searchAccurateAnswerThreshold;
    }

    public BigDecimal getSearchRecommendAnswerThreshold() {
        return searchRecommendAnswerThreshold;
    }

    public void setSearchRecommendAnswerThreshold(BigDecimal searchRecommendAnswerThreshold) {
        this.searchRecommendAnswerThreshold = searchRecommendAnswerThreshold;
    }

    public Byte getSearchPriority() {
        return searchPriority;
    }

    public void setSearchPriority(Byte searchPriority) {
        this.searchPriority = searchPriority;
    }

    public BigDecimal getKeywordAccurateAnswerThreshold() {
        return keywordAccurateAnswerThreshold;
    }

    public void setKeywordAccurateAnswerThreshold(BigDecimal keywordAccurateAnswerThreshold) {
        this.keywordAccurateAnswerThreshold = keywordAccurateAnswerThreshold;
    }

    public Byte getKeywordPriority() {
        return keywordPriority;
    }

    public void setKeywordPriority(Byte keywordPriority) {
        this.keywordPriority = keywordPriority;
    }

    public BigDecimal getGreetingAccurateAnswerThreshold() {
        return greetingAccurateAnswerThreshold;
    }

    public void setGreetingAccurateAnswerThreshold(BigDecimal greetingAccurateAnswerThreshold) {
        this.greetingAccurateAnswerThreshold = greetingAccurateAnswerThreshold;
    }

    public Byte getGreetingPriority() {
        return greetingPriority;
    }

    public void setGreetingPriority(Byte greetingPriority) {
        this.greetingPriority = greetingPriority;
    }

    public String getSearchLibCategory() {
        return searchLibCategory;
    }

    public void setSearchLibCategory(String searchLibCategory) {
        this.searchLibCategory = searchLibCategory == null ? null : searchLibCategory.trim();
    }

    public String getGreetingLibCategory() {
        return greetingLibCategory;
    }

    public void setGreetingLibCategory(String greetingLibCategory) {
        this.greetingLibCategory = greetingLibCategory == null ? null : greetingLibCategory.trim();
    }

    public Byte getSyncalgorithm() {
        return syncalgorithm;
    }

    public void setSyncalgorithm(Byte syncalgorithm) {
        this.syncalgorithm = syncalgorithm;
    }

    public String getRobotToken() {
        return robotToken;
    }

    public void setRobotToken(String robotToken) {
        this.robotToken = robotToken == null ? null : robotToken.trim();
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