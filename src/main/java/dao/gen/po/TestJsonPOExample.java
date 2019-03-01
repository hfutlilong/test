package dao.gen.po;

import entity.TestJsonDetail;
import java.util.ArrayList;
import java.util.List;

public class TestJsonPOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TestJsonPOExample() {
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
        protected List<Criterion> jsonDetailCriteria;

        protected List<Criterion> allCriteria;

        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
            jsonDetailCriteria = new ArrayList<Criterion>();
        }

        public List<Criterion> getJsonDetailCriteria() {
            return jsonDetailCriteria;
        }

        protected void addJsonDetailCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            jsonDetailCriteria.add(new Criterion(condition, value, "handler.JsonTypeHandler"));
            allCriteria = null;
        }

        protected void addJsonDetailCriterion(String condition, TestJsonDetail value1, TestJsonDetail value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            jsonDetailCriteria.add(new Criterion(condition, value1, value2, "handler.JsonTypeHandler"));
            allCriteria = null;
        }

        public boolean isValid() {
            return criteria.size() > 0
                || jsonDetailCriteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            if (allCriteria == null) {
                allCriteria = new ArrayList<Criterion>();
                allCriteria.addAll(criteria);
                allCriteria.addAll(jsonDetailCriteria);
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

        public Criteria andJsonDetailIsNull() {
            addCriterion("json_string is null");
            return (Criteria) this;
        }

        public Criteria andJsonDetailIsNotNull() {
            addCriterion("json_string is not null");
            return (Criteria) this;
        }

        public Criteria andJsonDetailEqualTo(TestJsonDetail value) {
            addJsonDetailCriterion("json_string =", value, "jsonDetail");
            return (Criteria) this;
        }

        public Criteria andJsonDetailNotEqualTo(TestJsonDetail value) {
            addJsonDetailCriterion("json_string <>", value, "jsonDetail");
            return (Criteria) this;
        }

        public Criteria andJsonDetailGreaterThan(TestJsonDetail value) {
            addJsonDetailCriterion("json_string >", value, "jsonDetail");
            return (Criteria) this;
        }

        public Criteria andJsonDetailGreaterThanOrEqualTo(TestJsonDetail value) {
            addJsonDetailCriterion("json_string >=", value, "jsonDetail");
            return (Criteria) this;
        }

        public Criteria andJsonDetailLessThan(TestJsonDetail value) {
            addJsonDetailCriterion("json_string <", value, "jsonDetail");
            return (Criteria) this;
        }

        public Criteria andJsonDetailLessThanOrEqualTo(TestJsonDetail value) {
            addJsonDetailCriterion("json_string <=", value, "jsonDetail");
            return (Criteria) this;
        }

        public Criteria andJsonDetailLike(TestJsonDetail value) {
            addJsonDetailCriterion("json_string like", value, "jsonDetail");
            return (Criteria) this;
        }

        public Criteria andJsonDetailNotLike(TestJsonDetail value) {
            addJsonDetailCriterion("json_string not like", value, "jsonDetail");
            return (Criteria) this;
        }

        public Criteria andJsonDetailIn(List<TestJsonDetail> values) {
            addJsonDetailCriterion("json_string in", values, "jsonDetail");
            return (Criteria) this;
        }

        public Criteria andJsonDetailNotIn(List<TestJsonDetail> values) {
            addJsonDetailCriterion("json_string not in", values, "jsonDetail");
            return (Criteria) this;
        }

        public Criteria andJsonDetailBetween(TestJsonDetail value1, TestJsonDetail value2) {
            addJsonDetailCriterion("json_string between", value1, value2, "jsonDetail");
            return (Criteria) this;
        }

        public Criteria andJsonDetailNotBetween(TestJsonDetail value1, TestJsonDetail value2) {
            addJsonDetailCriterion("json_string not between", value1, value2, "jsonDetail");
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