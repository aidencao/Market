package cn.market.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CustomOrderExample() {
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

        public Criteria andOrderidIsNull() {
            addCriterion("orderId is null");
            return (Criteria) this;
        }

        public Criteria andOrderidIsNotNull() {
            addCriterion("orderId is not null");
            return (Criteria) this;
        }

        public Criteria andOrderidEqualTo(String value) {
            addCriterion("orderId =", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotEqualTo(String value) {
            addCriterion("orderId <>", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThan(String value) {
            addCriterion("orderId >", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThanOrEqualTo(String value) {
            addCriterion("orderId >=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThan(String value) {
            addCriterion("orderId <", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThanOrEqualTo(String value) {
            addCriterion("orderId <=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLike(String value) {
            addCriterion("orderId like", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotLike(String value) {
            addCriterion("orderId not like", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidIn(List<String> values) {
            addCriterion("orderId in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotIn(List<String> values) {
            addCriterion("orderId not in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidBetween(String value1, String value2) {
            addCriterion("orderId between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotBetween(String value1, String value2) {
            addCriterion("orderId not between", value1, value2, "orderid");
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

        public Criteria andOrderpriceIsNull() {
            addCriterion("orderPrice is null");
            return (Criteria) this;
        }

        public Criteria andOrderpriceIsNotNull() {
            addCriterion("orderPrice is not null");
            return (Criteria) this;
        }

        public Criteria andOrderpriceEqualTo(Double value) {
            addCriterion("orderPrice =", value, "orderprice");
            return (Criteria) this;
        }

        public Criteria andOrderpriceNotEqualTo(Double value) {
            addCriterion("orderPrice <>", value, "orderprice");
            return (Criteria) this;
        }

        public Criteria andOrderpriceGreaterThan(Double value) {
            addCriterion("orderPrice >", value, "orderprice");
            return (Criteria) this;
        }

        public Criteria andOrderpriceGreaterThanOrEqualTo(Double value) {
            addCriterion("orderPrice >=", value, "orderprice");
            return (Criteria) this;
        }

        public Criteria andOrderpriceLessThan(Double value) {
            addCriterion("orderPrice <", value, "orderprice");
            return (Criteria) this;
        }

        public Criteria andOrderpriceLessThanOrEqualTo(Double value) {
            addCriterion("orderPrice <=", value, "orderprice");
            return (Criteria) this;
        }

        public Criteria andOrderpriceIn(List<Double> values) {
            addCriterion("orderPrice in", values, "orderprice");
            return (Criteria) this;
        }

        public Criteria andOrderpriceNotIn(List<Double> values) {
            addCriterion("orderPrice not in", values, "orderprice");
            return (Criteria) this;
        }

        public Criteria andOrderpriceBetween(Double value1, Double value2) {
            addCriterion("orderPrice between", value1, value2, "orderprice");
            return (Criteria) this;
        }

        public Criteria andOrderpriceNotBetween(Double value1, Double value2) {
            addCriterion("orderPrice not between", value1, value2, "orderprice");
            return (Criteria) this;
        }

        public Criteria andOpendatetimeIsNull() {
            addCriterion("openDatetime is null");
            return (Criteria) this;
        }

        public Criteria andOpendatetimeIsNotNull() {
            addCriterion("openDatetime is not null");
            return (Criteria) this;
        }

        public Criteria andOpendatetimeEqualTo(Date value) {
            addCriterion("openDatetime =", value, "opendatetime");
            return (Criteria) this;
        }

        public Criteria andOpendatetimeNotEqualTo(Date value) {
            addCriterion("openDatetime <>", value, "opendatetime");
            return (Criteria) this;
        }

        public Criteria andOpendatetimeGreaterThan(Date value) {
            addCriterion("openDatetime >", value, "opendatetime");
            return (Criteria) this;
        }

        public Criteria andOpendatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("openDatetime >=", value, "opendatetime");
            return (Criteria) this;
        }

        public Criteria andOpendatetimeLessThan(Date value) {
            addCriterion("openDatetime <", value, "opendatetime");
            return (Criteria) this;
        }

        public Criteria andOpendatetimeLessThanOrEqualTo(Date value) {
            addCriterion("openDatetime <=", value, "opendatetime");
            return (Criteria) this;
        }

        public Criteria andOpendatetimeIn(List<Date> values) {
            addCriterion("openDatetime in", values, "opendatetime");
            return (Criteria) this;
        }

        public Criteria andOpendatetimeNotIn(List<Date> values) {
            addCriterion("openDatetime not in", values, "opendatetime");
            return (Criteria) this;
        }

        public Criteria andOpendatetimeBetween(Date value1, Date value2) {
            addCriterion("openDatetime between", value1, value2, "opendatetime");
            return (Criteria) this;
        }

        public Criteria andOpendatetimeNotBetween(Date value1, Date value2) {
            addCriterion("openDatetime not between", value1, value2, "opendatetime");
            return (Criteria) this;
        }

        public Criteria andClosedatetimeIsNull() {
            addCriterion("closeDatetime is null");
            return (Criteria) this;
        }

        public Criteria andClosedatetimeIsNotNull() {
            addCriterion("closeDatetime is not null");
            return (Criteria) this;
        }

        public Criteria andClosedatetimeEqualTo(Date value) {
            addCriterion("closeDatetime =", value, "closedatetime");
            return (Criteria) this;
        }

        public Criteria andClosedatetimeNotEqualTo(Date value) {
            addCriterion("closeDatetime <>", value, "closedatetime");
            return (Criteria) this;
        }

        public Criteria andClosedatetimeGreaterThan(Date value) {
            addCriterion("closeDatetime >", value, "closedatetime");
            return (Criteria) this;
        }

        public Criteria andClosedatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("closeDatetime >=", value, "closedatetime");
            return (Criteria) this;
        }

        public Criteria andClosedatetimeLessThan(Date value) {
            addCriterion("closeDatetime <", value, "closedatetime");
            return (Criteria) this;
        }

        public Criteria andClosedatetimeLessThanOrEqualTo(Date value) {
            addCriterion("closeDatetime <=", value, "closedatetime");
            return (Criteria) this;
        }

        public Criteria andClosedatetimeIn(List<Date> values) {
            addCriterion("closeDatetime in", values, "closedatetime");
            return (Criteria) this;
        }

        public Criteria andClosedatetimeNotIn(List<Date> values) {
            addCriterion("closeDatetime not in", values, "closedatetime");
            return (Criteria) this;
        }

        public Criteria andClosedatetimeBetween(Date value1, Date value2) {
            addCriterion("closeDatetime between", value1, value2, "closedatetime");
            return (Criteria) this;
        }

        public Criteria andClosedatetimeNotBetween(Date value1, Date value2) {
            addCriterion("closeDatetime not between", value1, value2, "closedatetime");
            return (Criteria) this;
        }

        public Criteria andPaydatetimeIsNull() {
            addCriterion("payDatetime is null");
            return (Criteria) this;
        }

        public Criteria andPaydatetimeIsNotNull() {
            addCriterion("payDatetime is not null");
            return (Criteria) this;
        }

        public Criteria andPaydatetimeEqualTo(Date value) {
            addCriterion("payDatetime =", value, "paydatetime");
            return (Criteria) this;
        }

        public Criteria andPaydatetimeNotEqualTo(Date value) {
            addCriterion("payDatetime <>", value, "paydatetime");
            return (Criteria) this;
        }

        public Criteria andPaydatetimeGreaterThan(Date value) {
            addCriterion("payDatetime >", value, "paydatetime");
            return (Criteria) this;
        }

        public Criteria andPaydatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("payDatetime >=", value, "paydatetime");
            return (Criteria) this;
        }

        public Criteria andPaydatetimeLessThan(Date value) {
            addCriterion("payDatetime <", value, "paydatetime");
            return (Criteria) this;
        }

        public Criteria andPaydatetimeLessThanOrEqualTo(Date value) {
            addCriterion("payDatetime <=", value, "paydatetime");
            return (Criteria) this;
        }

        public Criteria andPaydatetimeIn(List<Date> values) {
            addCriterion("payDatetime in", values, "paydatetime");
            return (Criteria) this;
        }

        public Criteria andPaydatetimeNotIn(List<Date> values) {
            addCriterion("payDatetime not in", values, "paydatetime");
            return (Criteria) this;
        }

        public Criteria andPaydatetimeBetween(Date value1, Date value2) {
            addCriterion("payDatetime between", value1, value2, "paydatetime");
            return (Criteria) this;
        }

        public Criteria andPaydatetimeNotBetween(Date value1, Date value2) {
            addCriterion("payDatetime not between", value1, value2, "paydatetime");
            return (Criteria) this;
        }

        public Criteria andPaystateIsNull() {
            addCriterion("payState is null");
            return (Criteria) this;
        }

        public Criteria andPaystateIsNotNull() {
            addCriterion("payState is not null");
            return (Criteria) this;
        }

        public Criteria andPaystateEqualTo(Integer value) {
            addCriterion("payState =", value, "paystate");
            return (Criteria) this;
        }

        public Criteria andPaystateNotEqualTo(Integer value) {
            addCriterion("payState <>", value, "paystate");
            return (Criteria) this;
        }

        public Criteria andPaystateGreaterThan(Integer value) {
            addCriterion("payState >", value, "paystate");
            return (Criteria) this;
        }

        public Criteria andPaystateGreaterThanOrEqualTo(Integer value) {
            addCriterion("payState >=", value, "paystate");
            return (Criteria) this;
        }

        public Criteria andPaystateLessThan(Integer value) {
            addCriterion("payState <", value, "paystate");
            return (Criteria) this;
        }

        public Criteria andPaystateLessThanOrEqualTo(Integer value) {
            addCriterion("payState <=", value, "paystate");
            return (Criteria) this;
        }

        public Criteria andPaystateIn(List<Integer> values) {
            addCriterion("payState in", values, "paystate");
            return (Criteria) this;
        }

        public Criteria andPaystateNotIn(List<Integer> values) {
            addCriterion("payState not in", values, "paystate");
            return (Criteria) this;
        }

        public Criteria andPaystateBetween(Integer value1, Integer value2) {
            addCriterion("payState between", value1, value2, "paystate");
            return (Criteria) this;
        }

        public Criteria andPaystateNotBetween(Integer value1, Integer value2) {
            addCriterion("payState not between", value1, value2, "paystate");
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