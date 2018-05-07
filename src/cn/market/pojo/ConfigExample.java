package cn.market.pojo;

import java.util.ArrayList;
import java.util.List;

public class ConfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ConfigExample() {
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

        public Criteria andMallidIsNull() {
            addCriterion("mallId is null");
            return (Criteria) this;
        }

        public Criteria andMallidIsNotNull() {
            addCriterion("mallId is not null");
            return (Criteria) this;
        }

        public Criteria andMallidEqualTo(String value) {
            addCriterion("mallId =", value, "mallid");
            return (Criteria) this;
        }

        public Criteria andMallidNotEqualTo(String value) {
            addCriterion("mallId <>", value, "mallid");
            return (Criteria) this;
        }

        public Criteria andMallidGreaterThan(String value) {
            addCriterion("mallId >", value, "mallid");
            return (Criteria) this;
        }

        public Criteria andMallidGreaterThanOrEqualTo(String value) {
            addCriterion("mallId >=", value, "mallid");
            return (Criteria) this;
        }

        public Criteria andMallidLessThan(String value) {
            addCriterion("mallId <", value, "mallid");
            return (Criteria) this;
        }

        public Criteria andMallidLessThanOrEqualTo(String value) {
            addCriterion("mallId <=", value, "mallid");
            return (Criteria) this;
        }

        public Criteria andMallidLike(String value) {
            addCriterion("mallId like", value, "mallid");
            return (Criteria) this;
        }

        public Criteria andMallidNotLike(String value) {
            addCriterion("mallId not like", value, "mallid");
            return (Criteria) this;
        }

        public Criteria andMallidIn(List<String> values) {
            addCriterion("mallId in", values, "mallid");
            return (Criteria) this;
        }

        public Criteria andMallidNotIn(List<String> values) {
            addCriterion("mallId not in", values, "mallid");
            return (Criteria) this;
        }

        public Criteria andMallidBetween(String value1, String value2) {
            addCriterion("mallId between", value1, value2, "mallid");
            return (Criteria) this;
        }

        public Criteria andMallidNotBetween(String value1, String value2) {
            addCriterion("mallId not between", value1, value2, "mallid");
            return (Criteria) this;
        }

        public Criteria andMallnameIsNull() {
            addCriterion("mallName is null");
            return (Criteria) this;
        }

        public Criteria andMallnameIsNotNull() {
            addCriterion("mallName is not null");
            return (Criteria) this;
        }

        public Criteria andMallnameEqualTo(String value) {
            addCriterion("mallName =", value, "mallname");
            return (Criteria) this;
        }

        public Criteria andMallnameNotEqualTo(String value) {
            addCriterion("mallName <>", value, "mallname");
            return (Criteria) this;
        }

        public Criteria andMallnameGreaterThan(String value) {
            addCriterion("mallName >", value, "mallname");
            return (Criteria) this;
        }

        public Criteria andMallnameGreaterThanOrEqualTo(String value) {
            addCriterion("mallName >=", value, "mallname");
            return (Criteria) this;
        }

        public Criteria andMallnameLessThan(String value) {
            addCriterion("mallName <", value, "mallname");
            return (Criteria) this;
        }

        public Criteria andMallnameLessThanOrEqualTo(String value) {
            addCriterion("mallName <=", value, "mallname");
            return (Criteria) this;
        }

        public Criteria andMallnameLike(String value) {
            addCriterion("mallName like", value, "mallname");
            return (Criteria) this;
        }

        public Criteria andMallnameNotLike(String value) {
            addCriterion("mallName not like", value, "mallname");
            return (Criteria) this;
        }

        public Criteria andMallnameIn(List<String> values) {
            addCriterion("mallName in", values, "mallname");
            return (Criteria) this;
        }

        public Criteria andMallnameNotIn(List<String> values) {
            addCriterion("mallName not in", values, "mallname");
            return (Criteria) this;
        }

        public Criteria andMallnameBetween(String value1, String value2) {
            addCriterion("mallName between", value1, value2, "mallname");
            return (Criteria) this;
        }

        public Criteria andMallnameNotBetween(String value1, String value2) {
            addCriterion("mallName not between", value1, value2, "mallname");
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