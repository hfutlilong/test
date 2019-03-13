package dao.gen.po;

import entity.enums.RobotStatusEnum;
import entity.enums.RobotTypeEnum;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CsaiRobotSettingsPOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CsaiRobotSettingsPOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> robotTypeCriteria;

        protected List<Criterion> robotStatusCriteria;

        protected List<Criterion> allCriteria;

        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
            robotTypeCriteria = new ArrayList<Criterion>();
            robotStatusCriteria = new ArrayList<Criterion>();
        }

        public List<Criterion> getRobotTypeCriteria() {
            return robotTypeCriteria;
        }

        protected void addRobotTypeCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            robotTypeCriteria.add(new Criterion(condition, value, "handler.RobotTypeEnumTypeHandler"));
            allCriteria = null;
        }

        protected void addRobotTypeCriterion(String condition, RobotTypeEnum value1, RobotTypeEnum value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            robotTypeCriteria.add(new Criterion(condition, value1, value2, "handler.RobotTypeEnumTypeHandler"));
            allCriteria = null;
        }

        public List<Criterion> getRobotStatusCriteria() {
            return robotStatusCriteria;
        }

        protected void addRobotStatusCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            robotStatusCriteria.add(new Criterion(condition, value, "handler.RobotStatusEnumTypeHandler"));
            allCriteria = null;
        }

        protected void addRobotStatusCriterion(String condition, RobotStatusEnum value1, RobotStatusEnum value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            robotStatusCriteria.add(new Criterion(condition, value1, value2, "handler.RobotStatusEnumTypeHandler"));
            allCriteria = null;
        }

        public boolean isValid() {
            return criteria.size() > 0
                || robotTypeCriteria.size() > 0
                || robotStatusCriteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            if (allCriteria == null) {
                allCriteria = new ArrayList<Criterion>();
                allCriteria.addAll(criteria);
                allCriteria.addAll(robotTypeCriteria);
                allCriteria.addAll(robotStatusCriteria);
            }
            return allCriteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
            allCriteria = null;
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
            allCriteria = null;
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
            allCriteria = null;
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andRobotIdIsNull() {
            addCriterion("robot_id is null");
            return (Criteria) this;
        }

        public Criteria andRobotIdIsNotNull() {
            addCriterion("robot_id is not null");
            return (Criteria) this;
        }

        public Criteria andRobotIdEqualTo(String value) {
            addCriterion("robot_id =", value, "robotId");
            return (Criteria) this;
        }

        public Criteria andRobotIdNotEqualTo(String value) {
            addCriterion("robot_id <>", value, "robotId");
            return (Criteria) this;
        }

        public Criteria andRobotIdGreaterThan(String value) {
            addCriterion("robot_id >", value, "robotId");
            return (Criteria) this;
        }

        public Criteria andRobotIdGreaterThanOrEqualTo(String value) {
            addCriterion("robot_id >=", value, "robotId");
            return (Criteria) this;
        }

        public Criteria andRobotIdLessThan(String value) {
            addCriterion("robot_id <", value, "robotId");
            return (Criteria) this;
        }

        public Criteria andRobotIdLessThanOrEqualTo(String value) {
            addCriterion("robot_id <=", value, "robotId");
            return (Criteria) this;
        }

        public Criteria andRobotIdLike(String value) {
            addCriterion("robot_id like", value, "robotId");
            return (Criteria) this;
        }

        public Criteria andRobotIdNotLike(String value) {
            addCriterion("robot_id not like", value, "robotId");
            return (Criteria) this;
        }

        public Criteria andRobotIdIn(List<String> values) {
            addCriterion("robot_id in", values, "robotId");
            return (Criteria) this;
        }

        public Criteria andRobotIdNotIn(List<String> values) {
            addCriterion("robot_id not in", values, "robotId");
            return (Criteria) this;
        }

        public Criteria andRobotIdBetween(String value1, String value2) {
            addCriterion("robot_id between", value1, value2, "robotId");
            return (Criteria) this;
        }

        public Criteria andRobotIdNotBetween(String value1, String value2) {
            addCriterion("robot_id not between", value1, value2, "robotId");
            return (Criteria) this;
        }

        public Criteria andCorpIdIsNull() {
            addCriterion("corp_id is null");
            return (Criteria) this;
        }

        public Criteria andCorpIdIsNotNull() {
            addCriterion("corp_id is not null");
            return (Criteria) this;
        }

        public Criteria andCorpIdEqualTo(Long value) {
            addCriterion("corp_id =", value, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdNotEqualTo(Long value) {
            addCriterion("corp_id <>", value, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdGreaterThan(Long value) {
            addCriterion("corp_id >", value, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdGreaterThanOrEqualTo(Long value) {
            addCriterion("corp_id >=", value, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdLessThan(Long value) {
            addCriterion("corp_id <", value, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdLessThanOrEqualTo(Long value) {
            addCriterion("corp_id <=", value, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdIn(List<Long> values) {
            addCriterion("corp_id in", values, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdNotIn(List<Long> values) {
            addCriterion("corp_id not in", values, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdBetween(Long value1, Long value2) {
            addCriterion("corp_id between", value1, value2, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdNotBetween(Long value1, Long value2) {
            addCriterion("corp_id not between", value1, value2, "corpId");
            return (Criteria) this;
        }

        public Criteria andLogoUrlIsNull() {
            addCriterion("logo_url is null");
            return (Criteria) this;
        }

        public Criteria andLogoUrlIsNotNull() {
            addCriterion("logo_url is not null");
            return (Criteria) this;
        }

        public Criteria andLogoUrlEqualTo(String value) {
            addCriterion("logo_url =", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlNotEqualTo(String value) {
            addCriterion("logo_url <>", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlGreaterThan(String value) {
            addCriterion("logo_url >", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlGreaterThanOrEqualTo(String value) {
            addCriterion("logo_url >=", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlLessThan(String value) {
            addCriterion("logo_url <", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlLessThanOrEqualTo(String value) {
            addCriterion("logo_url <=", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlLike(String value) {
            addCriterion("logo_url like", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlNotLike(String value) {
            addCriterion("logo_url not like", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlIn(List<String> values) {
            addCriterion("logo_url in", values, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlNotIn(List<String> values) {
            addCriterion("logo_url not in", values, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlBetween(String value1, String value2) {
            addCriterion("logo_url between", value1, value2, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlNotBetween(String value1, String value2) {
            addCriterion("logo_url not between", value1, value2, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andInternalNameIsNull() {
            addCriterion("internal_name is null");
            return (Criteria) this;
        }

        public Criteria andInternalNameIsNotNull() {
            addCriterion("internal_name is not null");
            return (Criteria) this;
        }

        public Criteria andInternalNameEqualTo(String value) {
            addCriterion("internal_name =", value, "internalName");
            return (Criteria) this;
        }

        public Criteria andInternalNameNotEqualTo(String value) {
            addCriterion("internal_name <>", value, "internalName");
            return (Criteria) this;
        }

        public Criteria andInternalNameGreaterThan(String value) {
            addCriterion("internal_name >", value, "internalName");
            return (Criteria) this;
        }

        public Criteria andInternalNameGreaterThanOrEqualTo(String value) {
            addCriterion("internal_name >=", value, "internalName");
            return (Criteria) this;
        }

        public Criteria andInternalNameLessThan(String value) {
            addCriterion("internal_name <", value, "internalName");
            return (Criteria) this;
        }

        public Criteria andInternalNameLessThanOrEqualTo(String value) {
            addCriterion("internal_name <=", value, "internalName");
            return (Criteria) this;
        }

        public Criteria andInternalNameLike(String value) {
            addCriterion("internal_name like", value, "internalName");
            return (Criteria) this;
        }

        public Criteria andInternalNameNotLike(String value) {
            addCriterion("internal_name not like", value, "internalName");
            return (Criteria) this;
        }

        public Criteria andInternalNameIn(List<String> values) {
            addCriterion("internal_name in", values, "internalName");
            return (Criteria) this;
        }

        public Criteria andInternalNameNotIn(List<String> values) {
            addCriterion("internal_name not in", values, "internalName");
            return (Criteria) this;
        }

        public Criteria andInternalNameBetween(String value1, String value2) {
            addCriterion("internal_name between", value1, value2, "internalName");
            return (Criteria) this;
        }

        public Criteria andInternalNameNotBetween(String value1, String value2) {
            addCriterion("internal_name not between", value1, value2, "internalName");
            return (Criteria) this;
        }

        public Criteria andExternalNameIsNull() {
            addCriterion("external_name is null");
            return (Criteria) this;
        }

        public Criteria andExternalNameIsNotNull() {
            addCriterion("external_name is not null");
            return (Criteria) this;
        }

        public Criteria andExternalNameEqualTo(String value) {
            addCriterion("external_name =", value, "externalName");
            return (Criteria) this;
        }

        public Criteria andExternalNameNotEqualTo(String value) {
            addCriterion("external_name <>", value, "externalName");
            return (Criteria) this;
        }

        public Criteria andExternalNameGreaterThan(String value) {
            addCriterion("external_name >", value, "externalName");
            return (Criteria) this;
        }

        public Criteria andExternalNameGreaterThanOrEqualTo(String value) {
            addCriterion("external_name >=", value, "externalName");
            return (Criteria) this;
        }

        public Criteria andExternalNameLessThan(String value) {
            addCriterion("external_name <", value, "externalName");
            return (Criteria) this;
        }

        public Criteria andExternalNameLessThanOrEqualTo(String value) {
            addCriterion("external_name <=", value, "externalName");
            return (Criteria) this;
        }

        public Criteria andExternalNameLike(String value) {
            addCriterion("external_name like", value, "externalName");
            return (Criteria) this;
        }

        public Criteria andExternalNameNotLike(String value) {
            addCriterion("external_name not like", value, "externalName");
            return (Criteria) this;
        }

        public Criteria andExternalNameIn(List<String> values) {
            addCriterion("external_name in", values, "externalName");
            return (Criteria) this;
        }

        public Criteria andExternalNameNotIn(List<String> values) {
            addCriterion("external_name not in", values, "externalName");
            return (Criteria) this;
        }

        public Criteria andExternalNameBetween(String value1, String value2) {
            addCriterion("external_name between", value1, value2, "externalName");
            return (Criteria) this;
        }

        public Criteria andExternalNameNotBetween(String value1, String value2) {
            addCriterion("external_name not between", value1, value2, "externalName");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRobotTypeIsNull() {
            addCriterion("robot_type is null");
            return (Criteria) this;
        }

        public Criteria andRobotTypeIsNotNull() {
            addCriterion("robot_type is not null");
            return (Criteria) this;
        }

        public Criteria andRobotTypeEqualTo(RobotTypeEnum value) {
            addRobotTypeCriterion("robot_type =", value, "robotType");
            return (Criteria) this;
        }

        public Criteria andRobotTypeNotEqualTo(RobotTypeEnum value) {
            addRobotTypeCriterion("robot_type <>", value, "robotType");
            return (Criteria) this;
        }

        public Criteria andRobotTypeGreaterThan(RobotTypeEnum value) {
            addRobotTypeCriterion("robot_type >", value, "robotType");
            return (Criteria) this;
        }

        public Criteria andRobotTypeGreaterThanOrEqualTo(RobotTypeEnum value) {
            addRobotTypeCriterion("robot_type >=", value, "robotType");
            return (Criteria) this;
        }

        public Criteria andRobotTypeLessThan(RobotTypeEnum value) {
            addRobotTypeCriterion("robot_type <", value, "robotType");
            return (Criteria) this;
        }

        public Criteria andRobotTypeLessThanOrEqualTo(RobotTypeEnum value) {
            addRobotTypeCriterion("robot_type <=", value, "robotType");
            return (Criteria) this;
        }

        public Criteria andRobotTypeIn(List<RobotTypeEnum> values) {
            addRobotTypeCriterion("robot_type in", values, "robotType");
            return (Criteria) this;
        }

        public Criteria andRobotTypeNotIn(List<RobotTypeEnum> values) {
            addRobotTypeCriterion("robot_type not in", values, "robotType");
            return (Criteria) this;
        }

        public Criteria andRobotTypeBetween(RobotTypeEnum value1, RobotTypeEnum value2) {
            addRobotTypeCriterion("robot_type between", value1, value2, "robotType");
            return (Criteria) this;
        }

        public Criteria andRobotTypeNotBetween(RobotTypeEnum value1, RobotTypeEnum value2) {
            addRobotTypeCriterion("robot_type not between", value1, value2, "robotType");
            return (Criteria) this;
        }

        public Criteria andRobotStatusIsNull() {
            addCriterion("robot_status is null");
            return (Criteria) this;
        }

        public Criteria andRobotStatusIsNotNull() {
            addCriterion("robot_status is not null");
            return (Criteria) this;
        }

        public Criteria andRobotStatusEqualTo(RobotStatusEnum value) {
            addRobotStatusCriterion("robot_status =", value, "robotStatus");
            return (Criteria) this;
        }

        public Criteria andRobotStatusNotEqualTo(RobotStatusEnum value) {
            addRobotStatusCriterion("robot_status <>", value, "robotStatus");
            return (Criteria) this;
        }

        public Criteria andRobotStatusGreaterThan(RobotStatusEnum value) {
            addRobotStatusCriterion("robot_status >", value, "robotStatus");
            return (Criteria) this;
        }

        public Criteria andRobotStatusGreaterThanOrEqualTo(RobotStatusEnum value) {
            addRobotStatusCriterion("robot_status >=", value, "robotStatus");
            return (Criteria) this;
        }

        public Criteria andRobotStatusLessThan(RobotStatusEnum value) {
            addRobotStatusCriterion("robot_status <", value, "robotStatus");
            return (Criteria) this;
        }

        public Criteria andRobotStatusLessThanOrEqualTo(RobotStatusEnum value) {
            addRobotStatusCriterion("robot_status <=", value, "robotStatus");
            return (Criteria) this;
        }

        public Criteria andRobotStatusIn(List<RobotStatusEnum> values) {
            addRobotStatusCriterion("robot_status in", values, "robotStatus");
            return (Criteria) this;
        }

        public Criteria andRobotStatusNotIn(List<RobotStatusEnum> values) {
            addRobotStatusCriterion("robot_status not in", values, "robotStatus");
            return (Criteria) this;
        }

        public Criteria andRobotStatusBetween(RobotStatusEnum value1, RobotStatusEnum value2) {
            addRobotStatusCriterion("robot_status between", value1, value2, "robotStatus");
            return (Criteria) this;
        }

        public Criteria andRobotStatusNotBetween(RobotStatusEnum value1, RobotStatusEnum value2) {
            addRobotStatusCriterion("robot_status not between", value1, value2, "robotStatus");
            return (Criteria) this;
        }

        public Criteria andSearchAccurateAnswerThresholdIsNull() {
            addCriterion("search_accurate_answer_threshold is null");
            return (Criteria) this;
        }

        public Criteria andSearchAccurateAnswerThresholdIsNotNull() {
            addCriterion("search_accurate_answer_threshold is not null");
            return (Criteria) this;
        }

        public Criteria andSearchAccurateAnswerThresholdEqualTo(BigDecimal value) {
            addCriterion("search_accurate_answer_threshold =", value, "searchAccurateAnswerThreshold");
            return (Criteria) this;
        }

        public Criteria andSearchAccurateAnswerThresholdNotEqualTo(BigDecimal value) {
            addCriterion("search_accurate_answer_threshold <>", value, "searchAccurateAnswerThreshold");
            return (Criteria) this;
        }

        public Criteria andSearchAccurateAnswerThresholdGreaterThan(BigDecimal value) {
            addCriterion("search_accurate_answer_threshold >", value, "searchAccurateAnswerThreshold");
            return (Criteria) this;
        }

        public Criteria andSearchAccurateAnswerThresholdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("search_accurate_answer_threshold >=", value, "searchAccurateAnswerThreshold");
            return (Criteria) this;
        }

        public Criteria andSearchAccurateAnswerThresholdLessThan(BigDecimal value) {
            addCriterion("search_accurate_answer_threshold <", value, "searchAccurateAnswerThreshold");
            return (Criteria) this;
        }

        public Criteria andSearchAccurateAnswerThresholdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("search_accurate_answer_threshold <=", value, "searchAccurateAnswerThreshold");
            return (Criteria) this;
        }

        public Criteria andSearchAccurateAnswerThresholdIn(List<BigDecimal> values) {
            addCriterion("search_accurate_answer_threshold in", values, "searchAccurateAnswerThreshold");
            return (Criteria) this;
        }

        public Criteria andSearchAccurateAnswerThresholdNotIn(List<BigDecimal> values) {
            addCriterion("search_accurate_answer_threshold not in", values, "searchAccurateAnswerThreshold");
            return (Criteria) this;
        }

        public Criteria andSearchAccurateAnswerThresholdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("search_accurate_answer_threshold between", value1, value2, "searchAccurateAnswerThreshold");
            return (Criteria) this;
        }

        public Criteria andSearchAccurateAnswerThresholdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("search_accurate_answer_threshold not between", value1, value2, "searchAccurateAnswerThreshold");
            return (Criteria) this;
        }

        public Criteria andSearchRecommendAnswerThresholdIsNull() {
            addCriterion("search_recommend_answer_threshold is null");
            return (Criteria) this;
        }

        public Criteria andSearchRecommendAnswerThresholdIsNotNull() {
            addCriterion("search_recommend_answer_threshold is not null");
            return (Criteria) this;
        }

        public Criteria andSearchRecommendAnswerThresholdEqualTo(BigDecimal value) {
            addCriterion("search_recommend_answer_threshold =", value, "searchRecommendAnswerThreshold");
            return (Criteria) this;
        }

        public Criteria andSearchRecommendAnswerThresholdNotEqualTo(BigDecimal value) {
            addCriterion("search_recommend_answer_threshold <>", value, "searchRecommendAnswerThreshold");
            return (Criteria) this;
        }

        public Criteria andSearchRecommendAnswerThresholdGreaterThan(BigDecimal value) {
            addCriterion("search_recommend_answer_threshold >", value, "searchRecommendAnswerThreshold");
            return (Criteria) this;
        }

        public Criteria andSearchRecommendAnswerThresholdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("search_recommend_answer_threshold >=", value, "searchRecommendAnswerThreshold");
            return (Criteria) this;
        }

        public Criteria andSearchRecommendAnswerThresholdLessThan(BigDecimal value) {
            addCriterion("search_recommend_answer_threshold <", value, "searchRecommendAnswerThreshold");
            return (Criteria) this;
        }

        public Criteria andSearchRecommendAnswerThresholdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("search_recommend_answer_threshold <=", value, "searchRecommendAnswerThreshold");
            return (Criteria) this;
        }

        public Criteria andSearchRecommendAnswerThresholdIn(List<BigDecimal> values) {
            addCriterion("search_recommend_answer_threshold in", values, "searchRecommendAnswerThreshold");
            return (Criteria) this;
        }

        public Criteria andSearchRecommendAnswerThresholdNotIn(List<BigDecimal> values) {
            addCriterion("search_recommend_answer_threshold not in", values, "searchRecommendAnswerThreshold");
            return (Criteria) this;
        }

        public Criteria andSearchRecommendAnswerThresholdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("search_recommend_answer_threshold between", value1, value2, "searchRecommendAnswerThreshold");
            return (Criteria) this;
        }

        public Criteria andSearchRecommendAnswerThresholdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("search_recommend_answer_threshold not between", value1, value2, "searchRecommendAnswerThreshold");
            return (Criteria) this;
        }

        public Criteria andSearchPriorityIsNull() {
            addCriterion("search_priority is null");
            return (Criteria) this;
        }

        public Criteria andSearchPriorityIsNotNull() {
            addCriterion("search_priority is not null");
            return (Criteria) this;
        }

        public Criteria andSearchPriorityEqualTo(Byte value) {
            addCriterion("search_priority =", value, "searchPriority");
            return (Criteria) this;
        }

        public Criteria andSearchPriorityNotEqualTo(Byte value) {
            addCriterion("search_priority <>", value, "searchPriority");
            return (Criteria) this;
        }

        public Criteria andSearchPriorityGreaterThan(Byte value) {
            addCriterion("search_priority >", value, "searchPriority");
            return (Criteria) this;
        }

        public Criteria andSearchPriorityGreaterThanOrEqualTo(Byte value) {
            addCriterion("search_priority >=", value, "searchPriority");
            return (Criteria) this;
        }

        public Criteria andSearchPriorityLessThan(Byte value) {
            addCriterion("search_priority <", value, "searchPriority");
            return (Criteria) this;
        }

        public Criteria andSearchPriorityLessThanOrEqualTo(Byte value) {
            addCriterion("search_priority <=", value, "searchPriority");
            return (Criteria) this;
        }

        public Criteria andSearchPriorityIn(List<Byte> values) {
            addCriterion("search_priority in", values, "searchPriority");
            return (Criteria) this;
        }

        public Criteria andSearchPriorityNotIn(List<Byte> values) {
            addCriterion("search_priority not in", values, "searchPriority");
            return (Criteria) this;
        }

        public Criteria andSearchPriorityBetween(Byte value1, Byte value2) {
            addCriterion("search_priority between", value1, value2, "searchPriority");
            return (Criteria) this;
        }

        public Criteria andSearchPriorityNotBetween(Byte value1, Byte value2) {
            addCriterion("search_priority not between", value1, value2, "searchPriority");
            return (Criteria) this;
        }

        public Criteria andKeywordAccurateAnswerThresholdIsNull() {
            addCriterion("keyword_accurate_answer_threshold is null");
            return (Criteria) this;
        }

        public Criteria andKeywordAccurateAnswerThresholdIsNotNull() {
            addCriterion("keyword_accurate_answer_threshold is not null");
            return (Criteria) this;
        }

        public Criteria andKeywordAccurateAnswerThresholdEqualTo(BigDecimal value) {
            addCriterion("keyword_accurate_answer_threshold =", value, "keywordAccurateAnswerThreshold");
            return (Criteria) this;
        }

        public Criteria andKeywordAccurateAnswerThresholdNotEqualTo(BigDecimal value) {
            addCriterion("keyword_accurate_answer_threshold <>", value, "keywordAccurateAnswerThreshold");
            return (Criteria) this;
        }

        public Criteria andKeywordAccurateAnswerThresholdGreaterThan(BigDecimal value) {
            addCriterion("keyword_accurate_answer_threshold >", value, "keywordAccurateAnswerThreshold");
            return (Criteria) this;
        }

        public Criteria andKeywordAccurateAnswerThresholdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("keyword_accurate_answer_threshold >=", value, "keywordAccurateAnswerThreshold");
            return (Criteria) this;
        }

        public Criteria andKeywordAccurateAnswerThresholdLessThan(BigDecimal value) {
            addCriterion("keyword_accurate_answer_threshold <", value, "keywordAccurateAnswerThreshold");
            return (Criteria) this;
        }

        public Criteria andKeywordAccurateAnswerThresholdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("keyword_accurate_answer_threshold <=", value, "keywordAccurateAnswerThreshold");
            return (Criteria) this;
        }

        public Criteria andKeywordAccurateAnswerThresholdIn(List<BigDecimal> values) {
            addCriterion("keyword_accurate_answer_threshold in", values, "keywordAccurateAnswerThreshold");
            return (Criteria) this;
        }

        public Criteria andKeywordAccurateAnswerThresholdNotIn(List<BigDecimal> values) {
            addCriterion("keyword_accurate_answer_threshold not in", values, "keywordAccurateAnswerThreshold");
            return (Criteria) this;
        }

        public Criteria andKeywordAccurateAnswerThresholdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("keyword_accurate_answer_threshold between", value1, value2, "keywordAccurateAnswerThreshold");
            return (Criteria) this;
        }

        public Criteria andKeywordAccurateAnswerThresholdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("keyword_accurate_answer_threshold not between", value1, value2, "keywordAccurateAnswerThreshold");
            return (Criteria) this;
        }

        public Criteria andKeywordPriorityIsNull() {
            addCriterion("keyword_priority is null");
            return (Criteria) this;
        }

        public Criteria andKeywordPriorityIsNotNull() {
            addCriterion("keyword_priority is not null");
            return (Criteria) this;
        }

        public Criteria andKeywordPriorityEqualTo(Byte value) {
            addCriterion("keyword_priority =", value, "keywordPriority");
            return (Criteria) this;
        }

        public Criteria andKeywordPriorityNotEqualTo(Byte value) {
            addCriterion("keyword_priority <>", value, "keywordPriority");
            return (Criteria) this;
        }

        public Criteria andKeywordPriorityGreaterThan(Byte value) {
            addCriterion("keyword_priority >", value, "keywordPriority");
            return (Criteria) this;
        }

        public Criteria andKeywordPriorityGreaterThanOrEqualTo(Byte value) {
            addCriterion("keyword_priority >=", value, "keywordPriority");
            return (Criteria) this;
        }

        public Criteria andKeywordPriorityLessThan(Byte value) {
            addCriterion("keyword_priority <", value, "keywordPriority");
            return (Criteria) this;
        }

        public Criteria andKeywordPriorityLessThanOrEqualTo(Byte value) {
            addCriterion("keyword_priority <=", value, "keywordPriority");
            return (Criteria) this;
        }

        public Criteria andKeywordPriorityIn(List<Byte> values) {
            addCriterion("keyword_priority in", values, "keywordPriority");
            return (Criteria) this;
        }

        public Criteria andKeywordPriorityNotIn(List<Byte> values) {
            addCriterion("keyword_priority not in", values, "keywordPriority");
            return (Criteria) this;
        }

        public Criteria andKeywordPriorityBetween(Byte value1, Byte value2) {
            addCriterion("keyword_priority between", value1, value2, "keywordPriority");
            return (Criteria) this;
        }

        public Criteria andKeywordPriorityNotBetween(Byte value1, Byte value2) {
            addCriterion("keyword_priority not between", value1, value2, "keywordPriority");
            return (Criteria) this;
        }

        public Criteria andGreetingAccurateAnswerThresholdIsNull() {
            addCriterion("greeting_accurate_answer_threshold is null");
            return (Criteria) this;
        }

        public Criteria andGreetingAccurateAnswerThresholdIsNotNull() {
            addCriterion("greeting_accurate_answer_threshold is not null");
            return (Criteria) this;
        }

        public Criteria andGreetingAccurateAnswerThresholdEqualTo(BigDecimal value) {
            addCriterion("greeting_accurate_answer_threshold =", value, "greetingAccurateAnswerThreshold");
            return (Criteria) this;
        }

        public Criteria andGreetingAccurateAnswerThresholdNotEqualTo(BigDecimal value) {
            addCriterion("greeting_accurate_answer_threshold <>", value, "greetingAccurateAnswerThreshold");
            return (Criteria) this;
        }

        public Criteria andGreetingAccurateAnswerThresholdGreaterThan(BigDecimal value) {
            addCriterion("greeting_accurate_answer_threshold >", value, "greetingAccurateAnswerThreshold");
            return (Criteria) this;
        }

        public Criteria andGreetingAccurateAnswerThresholdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("greeting_accurate_answer_threshold >=", value, "greetingAccurateAnswerThreshold");
            return (Criteria) this;
        }

        public Criteria andGreetingAccurateAnswerThresholdLessThan(BigDecimal value) {
            addCriterion("greeting_accurate_answer_threshold <", value, "greetingAccurateAnswerThreshold");
            return (Criteria) this;
        }

        public Criteria andGreetingAccurateAnswerThresholdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("greeting_accurate_answer_threshold <=", value, "greetingAccurateAnswerThreshold");
            return (Criteria) this;
        }

        public Criteria andGreetingAccurateAnswerThresholdIn(List<BigDecimal> values) {
            addCriterion("greeting_accurate_answer_threshold in", values, "greetingAccurateAnswerThreshold");
            return (Criteria) this;
        }

        public Criteria andGreetingAccurateAnswerThresholdNotIn(List<BigDecimal> values) {
            addCriterion("greeting_accurate_answer_threshold not in", values, "greetingAccurateAnswerThreshold");
            return (Criteria) this;
        }

        public Criteria andGreetingAccurateAnswerThresholdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("greeting_accurate_answer_threshold between", value1, value2, "greetingAccurateAnswerThreshold");
            return (Criteria) this;
        }

        public Criteria andGreetingAccurateAnswerThresholdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("greeting_accurate_answer_threshold not between", value1, value2, "greetingAccurateAnswerThreshold");
            return (Criteria) this;
        }

        public Criteria andGreetingPriorityIsNull() {
            addCriterion("greeting_priority is null");
            return (Criteria) this;
        }

        public Criteria andGreetingPriorityIsNotNull() {
            addCriterion("greeting_priority is not null");
            return (Criteria) this;
        }

        public Criteria andGreetingPriorityEqualTo(Byte value) {
            addCriterion("greeting_priority =", value, "greetingPriority");
            return (Criteria) this;
        }

        public Criteria andGreetingPriorityNotEqualTo(Byte value) {
            addCriterion("greeting_priority <>", value, "greetingPriority");
            return (Criteria) this;
        }

        public Criteria andGreetingPriorityGreaterThan(Byte value) {
            addCriterion("greeting_priority >", value, "greetingPriority");
            return (Criteria) this;
        }

        public Criteria andGreetingPriorityGreaterThanOrEqualTo(Byte value) {
            addCriterion("greeting_priority >=", value, "greetingPriority");
            return (Criteria) this;
        }

        public Criteria andGreetingPriorityLessThan(Byte value) {
            addCriterion("greeting_priority <", value, "greetingPriority");
            return (Criteria) this;
        }

        public Criteria andGreetingPriorityLessThanOrEqualTo(Byte value) {
            addCriterion("greeting_priority <=", value, "greetingPriority");
            return (Criteria) this;
        }

        public Criteria andGreetingPriorityIn(List<Byte> values) {
            addCriterion("greeting_priority in", values, "greetingPriority");
            return (Criteria) this;
        }

        public Criteria andGreetingPriorityNotIn(List<Byte> values) {
            addCriterion("greeting_priority not in", values, "greetingPriority");
            return (Criteria) this;
        }

        public Criteria andGreetingPriorityBetween(Byte value1, Byte value2) {
            addCriterion("greeting_priority between", value1, value2, "greetingPriority");
            return (Criteria) this;
        }

        public Criteria andGreetingPriorityNotBetween(Byte value1, Byte value2) {
            addCriterion("greeting_priority not between", value1, value2, "greetingPriority");
            return (Criteria) this;
        }

        public Criteria andSearchLibCategoryIsNull() {
            addCriterion("search_lib_category is null");
            return (Criteria) this;
        }

        public Criteria andSearchLibCategoryIsNotNull() {
            addCriterion("search_lib_category is not null");
            return (Criteria) this;
        }

        public Criteria andSearchLibCategoryEqualTo(String value) {
            addCriterion("search_lib_category =", value, "searchLibCategory");
            return (Criteria) this;
        }

        public Criteria andSearchLibCategoryNotEqualTo(String value) {
            addCriterion("search_lib_category <>", value, "searchLibCategory");
            return (Criteria) this;
        }

        public Criteria andSearchLibCategoryGreaterThan(String value) {
            addCriterion("search_lib_category >", value, "searchLibCategory");
            return (Criteria) this;
        }

        public Criteria andSearchLibCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("search_lib_category >=", value, "searchLibCategory");
            return (Criteria) this;
        }

        public Criteria andSearchLibCategoryLessThan(String value) {
            addCriterion("search_lib_category <", value, "searchLibCategory");
            return (Criteria) this;
        }

        public Criteria andSearchLibCategoryLessThanOrEqualTo(String value) {
            addCriterion("search_lib_category <=", value, "searchLibCategory");
            return (Criteria) this;
        }

        public Criteria andSearchLibCategoryLike(String value) {
            addCriterion("search_lib_category like", value, "searchLibCategory");
            return (Criteria) this;
        }

        public Criteria andSearchLibCategoryNotLike(String value) {
            addCriterion("search_lib_category not like", value, "searchLibCategory");
            return (Criteria) this;
        }

        public Criteria andSearchLibCategoryIn(List<String> values) {
            addCriterion("search_lib_category in", values, "searchLibCategory");
            return (Criteria) this;
        }

        public Criteria andSearchLibCategoryNotIn(List<String> values) {
            addCriterion("search_lib_category not in", values, "searchLibCategory");
            return (Criteria) this;
        }

        public Criteria andSearchLibCategoryBetween(String value1, String value2) {
            addCriterion("search_lib_category between", value1, value2, "searchLibCategory");
            return (Criteria) this;
        }

        public Criteria andSearchLibCategoryNotBetween(String value1, String value2) {
            addCriterion("search_lib_category not between", value1, value2, "searchLibCategory");
            return (Criteria) this;
        }

        public Criteria andGreetingLibCategoryIsNull() {
            addCriterion("greeting_lib_category is null");
            return (Criteria) this;
        }

        public Criteria andGreetingLibCategoryIsNotNull() {
            addCriterion("greeting_lib_category is not null");
            return (Criteria) this;
        }

        public Criteria andGreetingLibCategoryEqualTo(String value) {
            addCriterion("greeting_lib_category =", value, "greetingLibCategory");
            return (Criteria) this;
        }

        public Criteria andGreetingLibCategoryNotEqualTo(String value) {
            addCriterion("greeting_lib_category <>", value, "greetingLibCategory");
            return (Criteria) this;
        }

        public Criteria andGreetingLibCategoryGreaterThan(String value) {
            addCriterion("greeting_lib_category >", value, "greetingLibCategory");
            return (Criteria) this;
        }

        public Criteria andGreetingLibCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("greeting_lib_category >=", value, "greetingLibCategory");
            return (Criteria) this;
        }

        public Criteria andGreetingLibCategoryLessThan(String value) {
            addCriterion("greeting_lib_category <", value, "greetingLibCategory");
            return (Criteria) this;
        }

        public Criteria andGreetingLibCategoryLessThanOrEqualTo(String value) {
            addCriterion("greeting_lib_category <=", value, "greetingLibCategory");
            return (Criteria) this;
        }

        public Criteria andGreetingLibCategoryLike(String value) {
            addCriterion("greeting_lib_category like", value, "greetingLibCategory");
            return (Criteria) this;
        }

        public Criteria andGreetingLibCategoryNotLike(String value) {
            addCriterion("greeting_lib_category not like", value, "greetingLibCategory");
            return (Criteria) this;
        }

        public Criteria andGreetingLibCategoryIn(List<String> values) {
            addCriterion("greeting_lib_category in", values, "greetingLibCategory");
            return (Criteria) this;
        }

        public Criteria andGreetingLibCategoryNotIn(List<String> values) {
            addCriterion("greeting_lib_category not in", values, "greetingLibCategory");
            return (Criteria) this;
        }

        public Criteria andGreetingLibCategoryBetween(String value1, String value2) {
            addCriterion("greeting_lib_category between", value1, value2, "greetingLibCategory");
            return (Criteria) this;
        }

        public Criteria andGreetingLibCategoryNotBetween(String value1, String value2) {
            addCriterion("greeting_lib_category not between", value1, value2, "greetingLibCategory");
            return (Criteria) this;
        }

        public Criteria andSyncalgorithmIsNull() {
            addCriterion("syncAlgorithm is null");
            return (Criteria) this;
        }

        public Criteria andSyncalgorithmIsNotNull() {
            addCriterion("syncAlgorithm is not null");
            return (Criteria) this;
        }

        public Criteria andSyncalgorithmEqualTo(Byte value) {
            addCriterion("syncAlgorithm =", value, "syncalgorithm");
            return (Criteria) this;
        }

        public Criteria andSyncalgorithmNotEqualTo(Byte value) {
            addCriterion("syncAlgorithm <>", value, "syncalgorithm");
            return (Criteria) this;
        }

        public Criteria andSyncalgorithmGreaterThan(Byte value) {
            addCriterion("syncAlgorithm >", value, "syncalgorithm");
            return (Criteria) this;
        }

        public Criteria andSyncalgorithmGreaterThanOrEqualTo(Byte value) {
            addCriterion("syncAlgorithm >=", value, "syncalgorithm");
            return (Criteria) this;
        }

        public Criteria andSyncalgorithmLessThan(Byte value) {
            addCriterion("syncAlgorithm <", value, "syncalgorithm");
            return (Criteria) this;
        }

        public Criteria andSyncalgorithmLessThanOrEqualTo(Byte value) {
            addCriterion("syncAlgorithm <=", value, "syncalgorithm");
            return (Criteria) this;
        }

        public Criteria andSyncalgorithmIn(List<Byte> values) {
            addCriterion("syncAlgorithm in", values, "syncalgorithm");
            return (Criteria) this;
        }

        public Criteria andSyncalgorithmNotIn(List<Byte> values) {
            addCriterion("syncAlgorithm not in", values, "syncalgorithm");
            return (Criteria) this;
        }

        public Criteria andSyncalgorithmBetween(Byte value1, Byte value2) {
            addCriterion("syncAlgorithm between", value1, value2, "syncalgorithm");
            return (Criteria) this;
        }

        public Criteria andSyncalgorithmNotBetween(Byte value1, Byte value2) {
            addCriterion("syncAlgorithm not between", value1, value2, "syncalgorithm");
            return (Criteria) this;
        }

        public Criteria andRobotTokenIsNull() {
            addCriterion("robot_token is null");
            return (Criteria) this;
        }

        public Criteria andRobotTokenIsNotNull() {
            addCriterion("robot_token is not null");
            return (Criteria) this;
        }

        public Criteria andRobotTokenEqualTo(String value) {
            addCriterion("robot_token =", value, "robotToken");
            return (Criteria) this;
        }

        public Criteria andRobotTokenNotEqualTo(String value) {
            addCriterion("robot_token <>", value, "robotToken");
            return (Criteria) this;
        }

        public Criteria andRobotTokenGreaterThan(String value) {
            addCriterion("robot_token >", value, "robotToken");
            return (Criteria) this;
        }

        public Criteria andRobotTokenGreaterThanOrEqualTo(String value) {
            addCriterion("robot_token >=", value, "robotToken");
            return (Criteria) this;
        }

        public Criteria andRobotTokenLessThan(String value) {
            addCriterion("robot_token <", value, "robotToken");
            return (Criteria) this;
        }

        public Criteria andRobotTokenLessThanOrEqualTo(String value) {
            addCriterion("robot_token <=", value, "robotToken");
            return (Criteria) this;
        }

        public Criteria andRobotTokenLike(String value) {
            addCriterion("robot_token like", value, "robotToken");
            return (Criteria) this;
        }

        public Criteria andRobotTokenNotLike(String value) {
            addCriterion("robot_token not like", value, "robotToken");
            return (Criteria) this;
        }

        public Criteria andRobotTokenIn(List<String> values) {
            addCriterion("robot_token in", values, "robotToken");
            return (Criteria) this;
        }

        public Criteria andRobotTokenNotIn(List<String> values) {
            addCriterion("robot_token not in", values, "robotToken");
            return (Criteria) this;
        }

        public Criteria andRobotTokenBetween(String value1, String value2) {
            addCriterion("robot_token between", value1, value2, "robotToken");
            return (Criteria) this;
        }

        public Criteria andRobotTokenNotBetween(String value1, String value2) {
            addCriterion("robot_token not between", value1, value2, "robotToken");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNull() {
            addCriterion("creator is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNotNull() {
            addCriterion("creator is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorEqualTo(String value) {
            addCriterion("creator =", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotEqualTo(String value) {
            addCriterion("creator <>", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThan(String value) {
            addCriterion("creator >", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThanOrEqualTo(String value) {
            addCriterion("creator >=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThan(String value) {
            addCriterion("creator <", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThanOrEqualTo(String value) {
            addCriterion("creator <=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLike(String value) {
            addCriterion("creator like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotLike(String value) {
            addCriterion("creator not like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorIn(List<String> values) {
            addCriterion("creator in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotIn(List<String> values) {
            addCriterion("creator not in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorBetween(String value1, String value2) {
            addCriterion("creator between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotBetween(String value1, String value2) {
            addCriterion("creator not between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdatorIsNull() {
            addCriterion("updator is null");
            return (Criteria) this;
        }

        public Criteria andUpdatorIsNotNull() {
            addCriterion("updator is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatorEqualTo(String value) {
            addCriterion("updator =", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorNotEqualTo(String value) {
            addCriterion("updator <>", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorGreaterThan(String value) {
            addCriterion("updator >", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorGreaterThanOrEqualTo(String value) {
            addCriterion("updator >=", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorLessThan(String value) {
            addCriterion("updator <", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorLessThanOrEqualTo(String value) {
            addCriterion("updator <=", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorLike(String value) {
            addCriterion("updator like", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorNotLike(String value) {
            addCriterion("updator not like", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorIn(List<String> values) {
            addCriterion("updator in", values, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorNotIn(List<String> values) {
            addCriterion("updator not in", values, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorBetween(String value1, String value2) {
            addCriterion("updator between", value1, value2, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorNotBetween(String value1, String value2) {
            addCriterion("updator not between", value1, value2, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andDbUpdateTimeIsNull() {
            addCriterion("db_update_time is null");
            return (Criteria) this;
        }

        public Criteria andDbUpdateTimeIsNotNull() {
            addCriterion("db_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andDbUpdateTimeEqualTo(Date value) {
            addCriterion("db_update_time =", value, "dbUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDbUpdateTimeNotEqualTo(Date value) {
            addCriterion("db_update_time <>", value, "dbUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDbUpdateTimeGreaterThan(Date value) {
            addCriterion("db_update_time >", value, "dbUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDbUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("db_update_time >=", value, "dbUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDbUpdateTimeLessThan(Date value) {
            addCriterion("db_update_time <", value, "dbUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDbUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("db_update_time <=", value, "dbUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDbUpdateTimeIn(List<Date> values) {
            addCriterion("db_update_time in", values, "dbUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDbUpdateTimeNotIn(List<Date> values) {
            addCriterion("db_update_time not in", values, "dbUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDbUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("db_update_time between", value1, value2, "dbUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDbUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("db_update_time not between", value1, value2, "dbUpdateTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}