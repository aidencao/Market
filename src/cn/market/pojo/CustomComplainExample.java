package cn.market.pojo;

import java.util.ArrayList;
import java.util.List;

public class CustomComplainExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CustomComplainExample() {
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

        public Criteria andCustomcomplainidIsNull() {
            addCriterion("customComplainId is null");
            return (Criteria) this;
        }

        public Criteria andCustomcomplainidIsNotNull() {
            addCriterion("customComplainId is not null");
            return (Criteria) this;
        }

        public Criteria andCustomcomplainidEqualTo(String value) {
            addCriterion("customComplainId =", value, "customcomplainid");
            return (Criteria) this;
        }

        public Criteria andCustomcomplainidNotEqualTo(String value) {
            addCriterion("customComplainId <>", value, "customcomplainid");
            return (Criteria) this;
        }

        public Criteria andCustomcomplainidGreaterThan(String value) {
            addCriterion("customComplainId >", value, "customcomplainid");
            return (Criteria) this;
        }

        public Criteria andCustomcomplainidGreaterThanOrEqualTo(String value) {
            addCriterion("customComplainId >=", value, "customcomplainid");
            return (Criteria) this;
        }

        public Criteria andCustomcomplainidLessThan(String value) {
            addCriterion("customComplainId <", value, "customcomplainid");
            return (Criteria) this;
        }

        public Criteria andCustomcomplainidLessThanOrEqualTo(String value) {
            addCriterion("customComplainId <=", value, "customcomplainid");
            return (Criteria) this;
        }

        public Criteria andCustomcomplainidLike(String value) {
            addCriterion("customComplainId like", value, "customcomplainid");
            return (Criteria) this;
        }

        public Criteria andCustomcomplainidNotLike(String value) {
            addCriterion("customComplainId not like", value, "customcomplainid");
            return (Criteria) this;
        }

        public Criteria andCustomcomplainidIn(List<String> values) {
            addCriterion("customComplainId in", values, "customcomplainid");
            return (Criteria) this;
        }

        public Criteria andCustomcomplainidNotIn(List<String> values) {
            addCriterion("customComplainId not in", values, "customcomplainid");
            return (Criteria) this;
        }

        public Criteria andCustomcomplainidBetween(String value1, String value2) {
            addCriterion("customComplainId between", value1, value2, "customcomplainid");
            return (Criteria) this;
        }

        public Criteria andCustomcomplainidNotBetween(String value1, String value2) {
            addCriterion("customComplainId not between", value1, value2, "customcomplainid");
            return (Criteria) this;
        }

        public Criteria andCustomidIsNull() {
            addCriterion("customId is null");
            return (Criteria) this;
        }

        public Criteria andCustomidIsNotNull() {
            addCriterion("customId is not null");
            return (Criteria) this;
        }

        public Criteria andCustomidEqualTo(String value) {
            addCriterion("customId =", value, "customid");
            return (Criteria) this;
        }

        public Criteria andCustomidNotEqualTo(String value) {
            addCriterion("customId <>", value, "customid");
            return (Criteria) this;
        }

        public Criteria andCustomidGreaterThan(String value) {
            addCriterion("customId >", value, "customid");
            return (Criteria) this;
        }

        public Criteria andCustomidGreaterThanOrEqualTo(String value) {
            addCriterion("customId >=", value, "customid");
            return (Criteria) this;
        }

        public Criteria andCustomidLessThan(String value) {
            addCriterion("customId <", value, "customid");
            return (Criteria) this;
        }

        public Criteria andCustomidLessThanOrEqualTo(String value) {
            addCriterion("customId <=", value, "customid");
            return (Criteria) this;
        }

        public Criteria andCustomidLike(String value) {
            addCriterion("customId like", value, "customid");
            return (Criteria) this;
        }

        public Criteria andCustomidNotLike(String value) {
            addCriterion("customId not like", value, "customid");
            return (Criteria) this;
        }

        public Criteria andCustomidIn(List<String> values) {
            addCriterion("customId in", values, "customid");
            return (Criteria) this;
        }

        public Criteria andCustomidNotIn(List<String> values) {
            addCriterion("customId not in", values, "customid");
            return (Criteria) this;
        }

        public Criteria andCustomidBetween(String value1, String value2) {
            addCriterion("customId between", value1, value2, "customid");
            return (Criteria) this;
        }

        public Criteria andCustomidNotBetween(String value1, String value2) {
            addCriterion("customId not between", value1, value2, "customid");
            return (Criteria) this;
        }

        public Criteria andComplaininfoIsNull() {
            addCriterion("complainInfo is null");
            return (Criteria) this;
        }

        public Criteria andComplaininfoIsNotNull() {
            addCriterion("complainInfo is not null");
            return (Criteria) this;
        }

        public Criteria andComplaininfoEqualTo(String value) {
            addCriterion("complainInfo =", value, "complaininfo");
            return (Criteria) this;
        }

        public Criteria andComplaininfoNotEqualTo(String value) {
            addCriterion("complainInfo <>", value, "complaininfo");
            return (Criteria) this;
        }

        public Criteria andComplaininfoGreaterThan(String value) {
            addCriterion("complainInfo >", value, "complaininfo");
            return (Criteria) this;
        }

        public Criteria andComplaininfoGreaterThanOrEqualTo(String value) {
            addCriterion("complainInfo >=", value, "complaininfo");
            return (Criteria) this;
        }

        public Criteria andComplaininfoLessThan(String value) {
            addCriterion("complainInfo <", value, "complaininfo");
            return (Criteria) this;
        }

        public Criteria andComplaininfoLessThanOrEqualTo(String value) {
            addCriterion("complainInfo <=", value, "complaininfo");
            return (Criteria) this;
        }

        public Criteria andComplaininfoLike(String value) {
            addCriterion("complainInfo like", value, "complaininfo");
            return (Criteria) this;
        }

        public Criteria andComplaininfoNotLike(String value) {
            addCriterion("complainInfo not like", value, "complaininfo");
            return (Criteria) this;
        }

        public Criteria andComplaininfoIn(List<String> values) {
            addCriterion("complainInfo in", values, "complaininfo");
            return (Criteria) this;
        }

        public Criteria andComplaininfoNotIn(List<String> values) {
            addCriterion("complainInfo not in", values, "complaininfo");
            return (Criteria) this;
        }

        public Criteria andComplaininfoBetween(String value1, String value2) {
            addCriterion("complainInfo between", value1, value2, "complaininfo");
            return (Criteria) this;
        }

        public Criteria andComplaininfoNotBetween(String value1, String value2) {
            addCriterion("complainInfo not between", value1, value2, "complaininfo");
            return (Criteria) this;
        }

        public Criteria andComplaintreatIsNull() {
            addCriterion("complainTreat is null");
            return (Criteria) this;
        }

        public Criteria andComplaintreatIsNotNull() {
            addCriterion("complainTreat is not null");
            return (Criteria) this;
        }

        public Criteria andComplaintreatEqualTo(String value) {
            addCriterion("complainTreat =", value, "complaintreat");
            return (Criteria) this;
        }

        public Criteria andComplaintreatNotEqualTo(String value) {
            addCriterion("complainTreat <>", value, "complaintreat");
            return (Criteria) this;
        }

        public Criteria andComplaintreatGreaterThan(String value) {
            addCriterion("complainTreat >", value, "complaintreat");
            return (Criteria) this;
        }

        public Criteria andComplaintreatGreaterThanOrEqualTo(String value) {
            addCriterion("complainTreat >=", value, "complaintreat");
            return (Criteria) this;
        }

        public Criteria andComplaintreatLessThan(String value) {
            addCriterion("complainTreat <", value, "complaintreat");
            return (Criteria) this;
        }

        public Criteria andComplaintreatLessThanOrEqualTo(String value) {
            addCriterion("complainTreat <=", value, "complaintreat");
            return (Criteria) this;
        }

        public Criteria andComplaintreatLike(String value) {
            addCriterion("complainTreat like", value, "complaintreat");
            return (Criteria) this;
        }

        public Criteria andComplaintreatNotLike(String value) {
            addCriterion("complainTreat not like", value, "complaintreat");
            return (Criteria) this;
        }

        public Criteria andComplaintreatIn(List<String> values) {
            addCriterion("complainTreat in", values, "complaintreat");
            return (Criteria) this;
        }

        public Criteria andComplaintreatNotIn(List<String> values) {
            addCriterion("complainTreat not in", values, "complaintreat");
            return (Criteria) this;
        }

        public Criteria andComplaintreatBetween(String value1, String value2) {
            addCriterion("complainTreat between", value1, value2, "complaintreat");
            return (Criteria) this;
        }

        public Criteria andComplaintreatNotBetween(String value1, String value2) {
            addCriterion("complainTreat not between", value1, value2, "complaintreat");
            return (Criteria) this;
        }

        public Criteria andTreatIsNull() {
            addCriterion("treat is null");
            return (Criteria) this;
        }

        public Criteria andTreatIsNotNull() {
            addCriterion("treat is not null");
            return (Criteria) this;
        }

        public Criteria andTreatEqualTo(Integer value) {
            addCriterion("treat =", value, "treat");
            return (Criteria) this;
        }

        public Criteria andTreatNotEqualTo(Integer value) {
            addCriterion("treat <>", value, "treat");
            return (Criteria) this;
        }

        public Criteria andTreatGreaterThan(Integer value) {
            addCriterion("treat >", value, "treat");
            return (Criteria) this;
        }

        public Criteria andTreatGreaterThanOrEqualTo(Integer value) {
            addCriterion("treat >=", value, "treat");
            return (Criteria) this;
        }

        public Criteria andTreatLessThan(Integer value) {
            addCriterion("treat <", value, "treat");
            return (Criteria) this;
        }

        public Criteria andTreatLessThanOrEqualTo(Integer value) {
            addCriterion("treat <=", value, "treat");
            return (Criteria) this;
        }

        public Criteria andTreatIn(List<Integer> values) {
            addCriterion("treat in", values, "treat");
            return (Criteria) this;
        }

        public Criteria andTreatNotIn(List<Integer> values) {
            addCriterion("treat not in", values, "treat");
            return (Criteria) this;
        }

        public Criteria andTreatBetween(Integer value1, Integer value2) {
            addCriterion("treat between", value1, value2, "treat");
            return (Criteria) this;
        }

        public Criteria andTreatNotBetween(Integer value1, Integer value2) {
            addCriterion("treat not between", value1, value2, "treat");
            return (Criteria) this;
        }

        public Criteria andManageridIsNull() {
            addCriterion("managerId is null");
            return (Criteria) this;
        }

        public Criteria andManageridIsNotNull() {
            addCriterion("managerId is not null");
            return (Criteria) this;
        }

        public Criteria andManageridEqualTo(Integer value) {
            addCriterion("managerId =", value, "managerid");
            return (Criteria) this;
        }

        public Criteria andManageridNotEqualTo(Integer value) {
            addCriterion("managerId <>", value, "managerid");
            return (Criteria) this;
        }

        public Criteria andManageridGreaterThan(Integer value) {
            addCriterion("managerId >", value, "managerid");
            return (Criteria) this;
        }

        public Criteria andManageridGreaterThanOrEqualTo(Integer value) {
            addCriterion("managerId >=", value, "managerid");
            return (Criteria) this;
        }

        public Criteria andManageridLessThan(Integer value) {
            addCriterion("managerId <", value, "managerid");
            return (Criteria) this;
        }

        public Criteria andManageridLessThanOrEqualTo(Integer value) {
            addCriterion("managerId <=", value, "managerid");
            return (Criteria) this;
        }

        public Criteria andManageridIn(List<Integer> values) {
            addCriterion("managerId in", values, "managerid");
            return (Criteria) this;
        }

        public Criteria andManageridNotIn(List<Integer> values) {
            addCriterion("managerId not in", values, "managerid");
            return (Criteria) this;
        }

        public Criteria andManageridBetween(Integer value1, Integer value2) {
            addCriterion("managerId between", value1, value2, "managerid");
            return (Criteria) this;
        }

        public Criteria andManageridNotBetween(Integer value1, Integer value2) {
            addCriterion("managerId not between", value1, value2, "managerid");
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