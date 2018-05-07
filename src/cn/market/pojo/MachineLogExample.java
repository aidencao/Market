package cn.market.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MachineLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MachineLogExample() {
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

        public Criteria andMaclogidIsNull() {
            addCriterion("macLogId is null");
            return (Criteria) this;
        }

        public Criteria andMaclogidIsNotNull() {
            addCriterion("macLogId is not null");
            return (Criteria) this;
        }

        public Criteria andMaclogidEqualTo(String value) {
            addCriterion("macLogId =", value, "maclogid");
            return (Criteria) this;
        }

        public Criteria andMaclogidNotEqualTo(String value) {
            addCriterion("macLogId <>", value, "maclogid");
            return (Criteria) this;
        }

        public Criteria andMaclogidGreaterThan(String value) {
            addCriterion("macLogId >", value, "maclogid");
            return (Criteria) this;
        }

        public Criteria andMaclogidGreaterThanOrEqualTo(String value) {
            addCriterion("macLogId >=", value, "maclogid");
            return (Criteria) this;
        }

        public Criteria andMaclogidLessThan(String value) {
            addCriterion("macLogId <", value, "maclogid");
            return (Criteria) this;
        }

        public Criteria andMaclogidLessThanOrEqualTo(String value) {
            addCriterion("macLogId <=", value, "maclogid");
            return (Criteria) this;
        }

        public Criteria andMaclogidLike(String value) {
            addCriterion("macLogId like", value, "maclogid");
            return (Criteria) this;
        }

        public Criteria andMaclogidNotLike(String value) {
            addCriterion("macLogId not like", value, "maclogid");
            return (Criteria) this;
        }

        public Criteria andMaclogidIn(List<String> values) {
            addCriterion("macLogId in", values, "maclogid");
            return (Criteria) this;
        }

        public Criteria andMaclogidNotIn(List<String> values) {
            addCriterion("macLogId not in", values, "maclogid");
            return (Criteria) this;
        }

        public Criteria andMaclogidBetween(String value1, String value2) {
            addCriterion("macLogId between", value1, value2, "maclogid");
            return (Criteria) this;
        }

        public Criteria andMaclogidNotBetween(String value1, String value2) {
            addCriterion("macLogId not between", value1, value2, "maclogid");
            return (Criteria) this;
        }

        public Criteria andMacidIsNull() {
            addCriterion("macId is null");
            return (Criteria) this;
        }

        public Criteria andMacidIsNotNull() {
            addCriterion("macId is not null");
            return (Criteria) this;
        }

        public Criteria andMacidEqualTo(String value) {
            addCriterion("macId =", value, "macid");
            return (Criteria) this;
        }

        public Criteria andMacidNotEqualTo(String value) {
            addCriterion("macId <>", value, "macid");
            return (Criteria) this;
        }

        public Criteria andMacidGreaterThan(String value) {
            addCriterion("macId >", value, "macid");
            return (Criteria) this;
        }

        public Criteria andMacidGreaterThanOrEqualTo(String value) {
            addCriterion("macId >=", value, "macid");
            return (Criteria) this;
        }

        public Criteria andMacidLessThan(String value) {
            addCriterion("macId <", value, "macid");
            return (Criteria) this;
        }

        public Criteria andMacidLessThanOrEqualTo(String value) {
            addCriterion("macId <=", value, "macid");
            return (Criteria) this;
        }

        public Criteria andMacidLike(String value) {
            addCriterion("macId like", value, "macid");
            return (Criteria) this;
        }

        public Criteria andMacidNotLike(String value) {
            addCriterion("macId not like", value, "macid");
            return (Criteria) this;
        }

        public Criteria andMacidIn(List<String> values) {
            addCriterion("macId in", values, "macid");
            return (Criteria) this;
        }

        public Criteria andMacidNotIn(List<String> values) {
            addCriterion("macId not in", values, "macid");
            return (Criteria) this;
        }

        public Criteria andMacidBetween(String value1, String value2) {
            addCriterion("macId between", value1, value2, "macid");
            return (Criteria) this;
        }

        public Criteria andMacidNotBetween(String value1, String value2) {
            addCriterion("macId not between", value1, value2, "macid");
            return (Criteria) this;
        }

        public Criteria andDatetimeIsNull() {
            addCriterion("dateTime is null");
            return (Criteria) this;
        }

        public Criteria andDatetimeIsNotNull() {
            addCriterion("dateTime is not null");
            return (Criteria) this;
        }

        public Criteria andDatetimeEqualTo(Date value) {
            addCriterion("dateTime =", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeNotEqualTo(Date value) {
            addCriterion("dateTime <>", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeGreaterThan(Date value) {
            addCriterion("dateTime >", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("dateTime >=", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeLessThan(Date value) {
            addCriterion("dateTime <", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("dateTime <=", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeIn(List<Date> values) {
            addCriterion("dateTime in", values, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeNotIn(List<Date> values) {
            addCriterion("dateTime not in", values, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeBetween(Date value1, Date value2) {
            addCriterion("dateTime between", value1, value2, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("dateTime not between", value1, value2, "datetime");
            return (Criteria) this;
        }

        public Criteria andErrortypeIsNull() {
            addCriterion("errorType is null");
            return (Criteria) this;
        }

        public Criteria andErrortypeIsNotNull() {
            addCriterion("errorType is not null");
            return (Criteria) this;
        }

        public Criteria andErrortypeEqualTo(String value) {
            addCriterion("errorType =", value, "errortype");
            return (Criteria) this;
        }

        public Criteria andErrortypeNotEqualTo(String value) {
            addCriterion("errorType <>", value, "errortype");
            return (Criteria) this;
        }

        public Criteria andErrortypeGreaterThan(String value) {
            addCriterion("errorType >", value, "errortype");
            return (Criteria) this;
        }

        public Criteria andErrortypeGreaterThanOrEqualTo(String value) {
            addCriterion("errorType >=", value, "errortype");
            return (Criteria) this;
        }

        public Criteria andErrortypeLessThan(String value) {
            addCriterion("errorType <", value, "errortype");
            return (Criteria) this;
        }

        public Criteria andErrortypeLessThanOrEqualTo(String value) {
            addCriterion("errorType <=", value, "errortype");
            return (Criteria) this;
        }

        public Criteria andErrortypeLike(String value) {
            addCriterion("errorType like", value, "errortype");
            return (Criteria) this;
        }

        public Criteria andErrortypeNotLike(String value) {
            addCriterion("errorType not like", value, "errortype");
            return (Criteria) this;
        }

        public Criteria andErrortypeIn(List<String> values) {
            addCriterion("errorType in", values, "errortype");
            return (Criteria) this;
        }

        public Criteria andErrortypeNotIn(List<String> values) {
            addCriterion("errorType not in", values, "errortype");
            return (Criteria) this;
        }

        public Criteria andErrortypeBetween(String value1, String value2) {
            addCriterion("errorType between", value1, value2, "errortype");
            return (Criteria) this;
        }

        public Criteria andErrortypeNotBetween(String value1, String value2) {
            addCriterion("errorType not between", value1, value2, "errortype");
            return (Criteria) this;
        }

        public Criteria andTreatresultIsNull() {
            addCriterion("treatResult is null");
            return (Criteria) this;
        }

        public Criteria andTreatresultIsNotNull() {
            addCriterion("treatResult is not null");
            return (Criteria) this;
        }

        public Criteria andTreatresultEqualTo(String value) {
            addCriterion("treatResult =", value, "treatresult");
            return (Criteria) this;
        }

        public Criteria andTreatresultNotEqualTo(String value) {
            addCriterion("treatResult <>", value, "treatresult");
            return (Criteria) this;
        }

        public Criteria andTreatresultGreaterThan(String value) {
            addCriterion("treatResult >", value, "treatresult");
            return (Criteria) this;
        }

        public Criteria andTreatresultGreaterThanOrEqualTo(String value) {
            addCriterion("treatResult >=", value, "treatresult");
            return (Criteria) this;
        }

        public Criteria andTreatresultLessThan(String value) {
            addCriterion("treatResult <", value, "treatresult");
            return (Criteria) this;
        }

        public Criteria andTreatresultLessThanOrEqualTo(String value) {
            addCriterion("treatResult <=", value, "treatresult");
            return (Criteria) this;
        }

        public Criteria andTreatresultLike(String value) {
            addCriterion("treatResult like", value, "treatresult");
            return (Criteria) this;
        }

        public Criteria andTreatresultNotLike(String value) {
            addCriterion("treatResult not like", value, "treatresult");
            return (Criteria) this;
        }

        public Criteria andTreatresultIn(List<String> values) {
            addCriterion("treatResult in", values, "treatresult");
            return (Criteria) this;
        }

        public Criteria andTreatresultNotIn(List<String> values) {
            addCriterion("treatResult not in", values, "treatresult");
            return (Criteria) this;
        }

        public Criteria andTreatresultBetween(String value1, String value2) {
            addCriterion("treatResult between", value1, value2, "treatresult");
            return (Criteria) this;
        }

        public Criteria andTreatresultNotBetween(String value1, String value2) {
            addCriterion("treatResult not between", value1, value2, "treatresult");
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