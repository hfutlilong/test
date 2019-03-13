package dao.gen.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CsaiRobotEntrancePOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CsaiRobotEntrancePOExample() {
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
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
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

        public Criteria andEntranceNameIsNull() {
            addCriterion("entrance_name is null");
            return (Criteria) this;
        }

        public Criteria andEntranceNameIsNotNull() {
            addCriterion("entrance_name is not null");
            return (Criteria) this;
        }

        public Criteria andEntranceNameEqualTo(String value) {
            addCriterion("entrance_name =", value, "entranceName");
            return (Criteria) this;
        }

        public Criteria andEntranceNameNotEqualTo(String value) {
            addCriterion("entrance_name <>", value, "entranceName");
            return (Criteria) this;
        }

        public Criteria andEntranceNameGreaterThan(String value) {
            addCriterion("entrance_name >", value, "entranceName");
            return (Criteria) this;
        }

        public Criteria andEntranceNameGreaterThanOrEqualTo(String value) {
            addCriterion("entrance_name >=", value, "entranceName");
            return (Criteria) this;
        }

        public Criteria andEntranceNameLessThan(String value) {
            addCriterion("entrance_name <", value, "entranceName");
            return (Criteria) this;
        }

        public Criteria andEntranceNameLessThanOrEqualTo(String value) {
            addCriterion("entrance_name <=", value, "entranceName");
            return (Criteria) this;
        }

        public Criteria andEntranceNameLike(String value) {
            addCriterion("entrance_name like", value, "entranceName");
            return (Criteria) this;
        }

        public Criteria andEntranceNameNotLike(String value) {
            addCriterion("entrance_name not like", value, "entranceName");
            return (Criteria) this;
        }

        public Criteria andEntranceNameIn(List<String> values) {
            addCriterion("entrance_name in", values, "entranceName");
            return (Criteria) this;
        }

        public Criteria andEntranceNameNotIn(List<String> values) {
            addCriterion("entrance_name not in", values, "entranceName");
            return (Criteria) this;
        }

        public Criteria andEntranceNameBetween(String value1, String value2) {
            addCriterion("entrance_name between", value1, value2, "entranceName");
            return (Criteria) this;
        }

        public Criteria andEntranceNameNotBetween(String value1, String value2) {
            addCriterion("entrance_name not between", value1, value2, "entranceName");
            return (Criteria) this;
        }

        public Criteria andEntranceSourceIsNull() {
            addCriterion("entrance_source is null");
            return (Criteria) this;
        }

        public Criteria andEntranceSourceIsNotNull() {
            addCriterion("entrance_source is not null");
            return (Criteria) this;
        }

        public Criteria andEntranceSourceEqualTo(String value) {
            addCriterion("entrance_source =", value, "entranceSource");
            return (Criteria) this;
        }

        public Criteria andEntranceSourceNotEqualTo(String value) {
            addCriterion("entrance_source <>", value, "entranceSource");
            return (Criteria) this;
        }

        public Criteria andEntranceSourceGreaterThan(String value) {
            addCriterion("entrance_source >", value, "entranceSource");
            return (Criteria) this;
        }

        public Criteria andEntranceSourceGreaterThanOrEqualTo(String value) {
            addCriterion("entrance_source >=", value, "entranceSource");
            return (Criteria) this;
        }

        public Criteria andEntranceSourceLessThan(String value) {
            addCriterion("entrance_source <", value, "entranceSource");
            return (Criteria) this;
        }

        public Criteria andEntranceSourceLessThanOrEqualTo(String value) {
            addCriterion("entrance_source <=", value, "entranceSource");
            return (Criteria) this;
        }

        public Criteria andEntranceSourceLike(String value) {
            addCriterion("entrance_source like", value, "entranceSource");
            return (Criteria) this;
        }

        public Criteria andEntranceSourceNotLike(String value) {
            addCriterion("entrance_source not like", value, "entranceSource");
            return (Criteria) this;
        }

        public Criteria andEntranceSourceIn(List<String> values) {
            addCriterion("entrance_source in", values, "entranceSource");
            return (Criteria) this;
        }

        public Criteria andEntranceSourceNotIn(List<String> values) {
            addCriterion("entrance_source not in", values, "entranceSource");
            return (Criteria) this;
        }

        public Criteria andEntranceSourceBetween(String value1, String value2) {
            addCriterion("entrance_source between", value1, value2, "entranceSource");
            return (Criteria) this;
        }

        public Criteria andEntranceSourceNotBetween(String value1, String value2) {
            addCriterion("entrance_source not between", value1, value2, "entranceSource");
            return (Criteria) this;
        }

        public Criteria andRelatedOneLevelCategoryIsNull() {
            addCriterion("related_one_level_category is null");
            return (Criteria) this;
        }

        public Criteria andRelatedOneLevelCategoryIsNotNull() {
            addCriterion("related_one_level_category is not null");
            return (Criteria) this;
        }

        public Criteria andRelatedOneLevelCategoryEqualTo(String value) {
            addCriterion("related_one_level_category =", value, "relatedOneLevelCategory");
            return (Criteria) this;
        }

        public Criteria andRelatedOneLevelCategoryNotEqualTo(String value) {
            addCriterion("related_one_level_category <>", value, "relatedOneLevelCategory");
            return (Criteria) this;
        }

        public Criteria andRelatedOneLevelCategoryGreaterThan(String value) {
            addCriterion("related_one_level_category >", value, "relatedOneLevelCategory");
            return (Criteria) this;
        }

        public Criteria andRelatedOneLevelCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("related_one_level_category >=", value, "relatedOneLevelCategory");
            return (Criteria) this;
        }

        public Criteria andRelatedOneLevelCategoryLessThan(String value) {
            addCriterion("related_one_level_category <", value, "relatedOneLevelCategory");
            return (Criteria) this;
        }

        public Criteria andRelatedOneLevelCategoryLessThanOrEqualTo(String value) {
            addCriterion("related_one_level_category <=", value, "relatedOneLevelCategory");
            return (Criteria) this;
        }

        public Criteria andRelatedOneLevelCategoryLike(String value) {
            addCriterion("related_one_level_category like", value, "relatedOneLevelCategory");
            return (Criteria) this;
        }

        public Criteria andRelatedOneLevelCategoryNotLike(String value) {
            addCriterion("related_one_level_category not like", value, "relatedOneLevelCategory");
            return (Criteria) this;
        }

        public Criteria andRelatedOneLevelCategoryIn(List<String> values) {
            addCriterion("related_one_level_category in", values, "relatedOneLevelCategory");
            return (Criteria) this;
        }

        public Criteria andRelatedOneLevelCategoryNotIn(List<String> values) {
            addCriterion("related_one_level_category not in", values, "relatedOneLevelCategory");
            return (Criteria) this;
        }

        public Criteria andRelatedOneLevelCategoryBetween(String value1, String value2) {
            addCriterion("related_one_level_category between", value1, value2, "relatedOneLevelCategory");
            return (Criteria) this;
        }

        public Criteria andRelatedOneLevelCategoryNotBetween(String value1, String value2) {
            addCriterion("related_one_level_category not between", value1, value2, "relatedOneLevelCategory");
            return (Criteria) this;
        }

        public Criteria andRelatedBrandIsNull() {
            addCriterion("related_brand is null");
            return (Criteria) this;
        }

        public Criteria andRelatedBrandIsNotNull() {
            addCriterion("related_brand is not null");
            return (Criteria) this;
        }

        public Criteria andRelatedBrandEqualTo(String value) {
            addCriterion("related_brand =", value, "relatedBrand");
            return (Criteria) this;
        }

        public Criteria andRelatedBrandNotEqualTo(String value) {
            addCriterion("related_brand <>", value, "relatedBrand");
            return (Criteria) this;
        }

        public Criteria andRelatedBrandGreaterThan(String value) {
            addCriterion("related_brand >", value, "relatedBrand");
            return (Criteria) this;
        }

        public Criteria andRelatedBrandGreaterThanOrEqualTo(String value) {
            addCriterion("related_brand >=", value, "relatedBrand");
            return (Criteria) this;
        }

        public Criteria andRelatedBrandLessThan(String value) {
            addCriterion("related_brand <", value, "relatedBrand");
            return (Criteria) this;
        }

        public Criteria andRelatedBrandLessThanOrEqualTo(String value) {
            addCriterion("related_brand <=", value, "relatedBrand");
            return (Criteria) this;
        }

        public Criteria andRelatedBrandLike(String value) {
            addCriterion("related_brand like", value, "relatedBrand");
            return (Criteria) this;
        }

        public Criteria andRelatedBrandNotLike(String value) {
            addCriterion("related_brand not like", value, "relatedBrand");
            return (Criteria) this;
        }

        public Criteria andRelatedBrandIn(List<String> values) {
            addCriterion("related_brand in", values, "relatedBrand");
            return (Criteria) this;
        }

        public Criteria andRelatedBrandNotIn(List<String> values) {
            addCriterion("related_brand not in", values, "relatedBrand");
            return (Criteria) this;
        }

        public Criteria andRelatedBrandBetween(String value1, String value2) {
            addCriterion("related_brand between", value1, value2, "relatedBrand");
            return (Criteria) this;
        }

        public Criteria andRelatedBrandNotBetween(String value1, String value2) {
            addCriterion("related_brand not between", value1, value2, "relatedBrand");
            return (Criteria) this;
        }

        public Criteria andEffectSwitchIsNull() {
            addCriterion("effect_switch is null");
            return (Criteria) this;
        }

        public Criteria andEffectSwitchIsNotNull() {
            addCriterion("effect_switch is not null");
            return (Criteria) this;
        }

        public Criteria andEffectSwitchEqualTo(Byte value) {
            addCriterion("effect_switch =", value, "effectSwitch");
            return (Criteria) this;
        }

        public Criteria andEffectSwitchNotEqualTo(Byte value) {
            addCriterion("effect_switch <>", value, "effectSwitch");
            return (Criteria) this;
        }

        public Criteria andEffectSwitchGreaterThan(Byte value) {
            addCriterion("effect_switch >", value, "effectSwitch");
            return (Criteria) this;
        }

        public Criteria andEffectSwitchGreaterThanOrEqualTo(Byte value) {
            addCriterion("effect_switch >=", value, "effectSwitch");
            return (Criteria) this;
        }

        public Criteria andEffectSwitchLessThan(Byte value) {
            addCriterion("effect_switch <", value, "effectSwitch");
            return (Criteria) this;
        }

        public Criteria andEffectSwitchLessThanOrEqualTo(Byte value) {
            addCriterion("effect_switch <=", value, "effectSwitch");
            return (Criteria) this;
        }

        public Criteria andEffectSwitchIn(List<Byte> values) {
            addCriterion("effect_switch in", values, "effectSwitch");
            return (Criteria) this;
        }

        public Criteria andEffectSwitchNotIn(List<Byte> values) {
            addCriterion("effect_switch not in", values, "effectSwitch");
            return (Criteria) this;
        }

        public Criteria andEffectSwitchBetween(Byte value1, Byte value2) {
            addCriterion("effect_switch between", value1, value2, "effectSwitch");
            return (Criteria) this;
        }

        public Criteria andEffectSwitchNotBetween(Byte value1, Byte value2) {
            addCriterion("effect_switch not between", value1, value2, "effectSwitch");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNull() {
            addCriterion("operator is null");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNotNull() {
            addCriterion("operator is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorEqualTo(String value) {
            addCriterion("operator =", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotEqualTo(String value) {
            addCriterion("operator <>", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThan(String value) {
            addCriterion("operator >", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThanOrEqualTo(String value) {
            addCriterion("operator >=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThan(String value) {
            addCriterion("operator <", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThanOrEqualTo(String value) {
            addCriterion("operator <=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLike(String value) {
            addCriterion("operator like", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotLike(String value) {
            addCriterion("operator not like", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorIn(List<String> values) {
            addCriterion("operator in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotIn(List<String> values) {
            addCriterion("operator not in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorBetween(String value1, String value2) {
            addCriterion("operator between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotBetween(String value1, String value2) {
            addCriterion("operator not between", value1, value2, "operator");
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