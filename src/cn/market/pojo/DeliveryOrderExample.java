package cn.market.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DeliveryOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DeliveryOrderExample() {
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

        public Criteria andDeliveryidIsNull() {
            addCriterion("deliveryId is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryidIsNotNull() {
            addCriterion("deliveryId is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryidEqualTo(String value) {
            addCriterion("deliveryId =", value, "deliveryid");
            return (Criteria) this;
        }

        public Criteria andDeliveryidNotEqualTo(String value) {
            addCriterion("deliveryId <>", value, "deliveryid");
            return (Criteria) this;
        }

        public Criteria andDeliveryidGreaterThan(String value) {
            addCriterion("deliveryId >", value, "deliveryid");
            return (Criteria) this;
        }

        public Criteria andDeliveryidGreaterThanOrEqualTo(String value) {
            addCriterion("deliveryId >=", value, "deliveryid");
            return (Criteria) this;
        }

        public Criteria andDeliveryidLessThan(String value) {
            addCriterion("deliveryId <", value, "deliveryid");
            return (Criteria) this;
        }

        public Criteria andDeliveryidLessThanOrEqualTo(String value) {
            addCriterion("deliveryId <=", value, "deliveryid");
            return (Criteria) this;
        }

        public Criteria andDeliveryidLike(String value) {
            addCriterion("deliveryId like", value, "deliveryid");
            return (Criteria) this;
        }

        public Criteria andDeliveryidNotLike(String value) {
            addCriterion("deliveryId not like", value, "deliveryid");
            return (Criteria) this;
        }

        public Criteria andDeliveryidIn(List<String> values) {
            addCriterion("deliveryId in", values, "deliveryid");
            return (Criteria) this;
        }

        public Criteria andDeliveryidNotIn(List<String> values) {
            addCriterion("deliveryId not in", values, "deliveryid");
            return (Criteria) this;
        }

        public Criteria andDeliveryidBetween(String value1, String value2) {
            addCriterion("deliveryId between", value1, value2, "deliveryid");
            return (Criteria) this;
        }

        public Criteria andDeliveryidNotBetween(String value1, String value2) {
            addCriterion("deliveryId not between", value1, value2, "deliveryid");
            return (Criteria) this;
        }

        public Criteria andDeliverystatusIsNull() {
            addCriterion("deliveryStatus is null");
            return (Criteria) this;
        }

        public Criteria andDeliverystatusIsNotNull() {
            addCriterion("deliveryStatus is not null");
            return (Criteria) this;
        }

        public Criteria andDeliverystatusEqualTo(String value) {
            addCriterion("deliveryStatus =", value, "deliverystatus");
            return (Criteria) this;
        }

        public Criteria andDeliverystatusNotEqualTo(String value) {
            addCriterion("deliveryStatus <>", value, "deliverystatus");
            return (Criteria) this;
        }

        public Criteria andDeliverystatusGreaterThan(String value) {
            addCriterion("deliveryStatus >", value, "deliverystatus");
            return (Criteria) this;
        }

        public Criteria andDeliverystatusGreaterThanOrEqualTo(String value) {
            addCriterion("deliveryStatus >=", value, "deliverystatus");
            return (Criteria) this;
        }

        public Criteria andDeliverystatusLessThan(String value) {
            addCriterion("deliveryStatus <", value, "deliverystatus");
            return (Criteria) this;
        }

        public Criteria andDeliverystatusLessThanOrEqualTo(String value) {
            addCriterion("deliveryStatus <=", value, "deliverystatus");
            return (Criteria) this;
        }

        public Criteria andDeliverystatusLike(String value) {
            addCriterion("deliveryStatus like", value, "deliverystatus");
            return (Criteria) this;
        }

        public Criteria andDeliverystatusNotLike(String value) {
            addCriterion("deliveryStatus not like", value, "deliverystatus");
            return (Criteria) this;
        }

        public Criteria andDeliverystatusIn(List<String> values) {
            addCriterion("deliveryStatus in", values, "deliverystatus");
            return (Criteria) this;
        }

        public Criteria andDeliverystatusNotIn(List<String> values) {
            addCriterion("deliveryStatus not in", values, "deliverystatus");
            return (Criteria) this;
        }

        public Criteria andDeliverystatusBetween(String value1, String value2) {
            addCriterion("deliveryStatus between", value1, value2, "deliverystatus");
            return (Criteria) this;
        }

        public Criteria andDeliverystatusNotBetween(String value1, String value2) {
            addCriterion("deliveryStatus not between", value1, value2, "deliverystatus");
            return (Criteria) this;
        }

        public Criteria andSorternameIsNull() {
            addCriterion("sorterName is null");
            return (Criteria) this;
        }

        public Criteria andSorternameIsNotNull() {
            addCriterion("sorterName is not null");
            return (Criteria) this;
        }

        public Criteria andSorternameEqualTo(String value) {
            addCriterion("sorterName =", value, "sortername");
            return (Criteria) this;
        }

        public Criteria andSorternameNotEqualTo(String value) {
            addCriterion("sorterName <>", value, "sortername");
            return (Criteria) this;
        }

        public Criteria andSorternameGreaterThan(String value) {
            addCriterion("sorterName >", value, "sortername");
            return (Criteria) this;
        }

        public Criteria andSorternameGreaterThanOrEqualTo(String value) {
            addCriterion("sorterName >=", value, "sortername");
            return (Criteria) this;
        }

        public Criteria andSorternameLessThan(String value) {
            addCriterion("sorterName <", value, "sortername");
            return (Criteria) this;
        }

        public Criteria andSorternameLessThanOrEqualTo(String value) {
            addCriterion("sorterName <=", value, "sortername");
            return (Criteria) this;
        }

        public Criteria andSorternameLike(String value) {
            addCriterion("sorterName like", value, "sortername");
            return (Criteria) this;
        }

        public Criteria andSorternameNotLike(String value) {
            addCriterion("sorterName not like", value, "sortername");
            return (Criteria) this;
        }

        public Criteria andSorternameIn(List<String> values) {
            addCriterion("sorterName in", values, "sortername");
            return (Criteria) this;
        }

        public Criteria andSorternameNotIn(List<String> values) {
            addCriterion("sorterName not in", values, "sortername");
            return (Criteria) this;
        }

        public Criteria andSorternameBetween(String value1, String value2) {
            addCriterion("sorterName between", value1, value2, "sortername");
            return (Criteria) this;
        }

        public Criteria andSorternameNotBetween(String value1, String value2) {
            addCriterion("sorterName not between", value1, value2, "sortername");
            return (Criteria) this;
        }

        public Criteria andSorteridIsNull() {
            addCriterion("sorterId is null");
            return (Criteria) this;
        }

        public Criteria andSorteridIsNotNull() {
            addCriterion("sorterId is not null");
            return (Criteria) this;
        }

        public Criteria andSorteridEqualTo(Integer value) {
            addCriterion("sorterId =", value, "sorterid");
            return (Criteria) this;
        }

        public Criteria andSorteridNotEqualTo(Integer value) {
            addCriterion("sorterId <>", value, "sorterid");
            return (Criteria) this;
        }

        public Criteria andSorteridGreaterThan(Integer value) {
            addCriterion("sorterId >", value, "sorterid");
            return (Criteria) this;
        }

        public Criteria andSorteridGreaterThanOrEqualTo(Integer value) {
            addCriterion("sorterId >=", value, "sorterid");
            return (Criteria) this;
        }

        public Criteria andSorteridLessThan(Integer value) {
            addCriterion("sorterId <", value, "sorterid");
            return (Criteria) this;
        }

        public Criteria andSorteridLessThanOrEqualTo(Integer value) {
            addCriterion("sorterId <=", value, "sorterid");
            return (Criteria) this;
        }

        public Criteria andSorteridIn(List<Integer> values) {
            addCriterion("sorterId in", values, "sorterid");
            return (Criteria) this;
        }

        public Criteria andSorteridNotIn(List<Integer> values) {
            addCriterion("sorterId not in", values, "sorterid");
            return (Criteria) this;
        }

        public Criteria andSorteridBetween(Integer value1, Integer value2) {
            addCriterion("sorterId between", value1, value2, "sorterid");
            return (Criteria) this;
        }

        public Criteria andSorteridNotBetween(Integer value1, Integer value2) {
            addCriterion("sorterId not between", value1, value2, "sorterid");
            return (Criteria) this;
        }

        public Criteria andSortingdatetimeIsNull() {
            addCriterion("sortingDateTime is null");
            return (Criteria) this;
        }

        public Criteria andSortingdatetimeIsNotNull() {
            addCriterion("sortingDateTime is not null");
            return (Criteria) this;
        }

        public Criteria andSortingdatetimeEqualTo(Date value) {
            addCriterion("sortingDateTime =", value, "sortingdatetime");
            return (Criteria) this;
        }

        public Criteria andSortingdatetimeNotEqualTo(Date value) {
            addCriterion("sortingDateTime <>", value, "sortingdatetime");
            return (Criteria) this;
        }

        public Criteria andSortingdatetimeGreaterThan(Date value) {
            addCriterion("sortingDateTime >", value, "sortingdatetime");
            return (Criteria) this;
        }

        public Criteria andSortingdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sortingDateTime >=", value, "sortingdatetime");
            return (Criteria) this;
        }

        public Criteria andSortingdatetimeLessThan(Date value) {
            addCriterion("sortingDateTime <", value, "sortingdatetime");
            return (Criteria) this;
        }

        public Criteria andSortingdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("sortingDateTime <=", value, "sortingdatetime");
            return (Criteria) this;
        }

        public Criteria andSortingdatetimeIn(List<Date> values) {
            addCriterion("sortingDateTime in", values, "sortingdatetime");
            return (Criteria) this;
        }

        public Criteria andSortingdatetimeNotIn(List<Date> values) {
            addCriterion("sortingDateTime not in", values, "sortingdatetime");
            return (Criteria) this;
        }

        public Criteria andSortingdatetimeBetween(Date value1, Date value2) {
            addCriterion("sortingDateTime between", value1, value2, "sortingdatetime");
            return (Criteria) this;
        }

        public Criteria andSortingdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("sortingDateTime not between", value1, value2, "sortingdatetime");
            return (Criteria) this;
        }

        public Criteria andCouriernameIsNull() {
            addCriterion("courierName is null");
            return (Criteria) this;
        }

        public Criteria andCouriernameIsNotNull() {
            addCriterion("courierName is not null");
            return (Criteria) this;
        }

        public Criteria andCouriernameEqualTo(String value) {
            addCriterion("courierName =", value, "couriername");
            return (Criteria) this;
        }

        public Criteria andCouriernameNotEqualTo(String value) {
            addCriterion("courierName <>", value, "couriername");
            return (Criteria) this;
        }

        public Criteria andCouriernameGreaterThan(String value) {
            addCriterion("courierName >", value, "couriername");
            return (Criteria) this;
        }

        public Criteria andCouriernameGreaterThanOrEqualTo(String value) {
            addCriterion("courierName >=", value, "couriername");
            return (Criteria) this;
        }

        public Criteria andCouriernameLessThan(String value) {
            addCriterion("courierName <", value, "couriername");
            return (Criteria) this;
        }

        public Criteria andCouriernameLessThanOrEqualTo(String value) {
            addCriterion("courierName <=", value, "couriername");
            return (Criteria) this;
        }

        public Criteria andCouriernameLike(String value) {
            addCriterion("courierName like", value, "couriername");
            return (Criteria) this;
        }

        public Criteria andCouriernameNotLike(String value) {
            addCriterion("courierName not like", value, "couriername");
            return (Criteria) this;
        }

        public Criteria andCouriernameIn(List<String> values) {
            addCriterion("courierName in", values, "couriername");
            return (Criteria) this;
        }

        public Criteria andCouriernameNotIn(List<String> values) {
            addCriterion("courierName not in", values, "couriername");
            return (Criteria) this;
        }

        public Criteria andCouriernameBetween(String value1, String value2) {
            addCriterion("courierName between", value1, value2, "couriername");
            return (Criteria) this;
        }

        public Criteria andCouriernameNotBetween(String value1, String value2) {
            addCriterion("courierName not between", value1, value2, "couriername");
            return (Criteria) this;
        }

        public Criteria andCourieridIsNull() {
            addCriterion("courierId is null");
            return (Criteria) this;
        }

        public Criteria andCourieridIsNotNull() {
            addCriterion("courierId is not null");
            return (Criteria) this;
        }

        public Criteria andCourieridEqualTo(Integer value) {
            addCriterion("courierId =", value, "courierid");
            return (Criteria) this;
        }

        public Criteria andCourieridNotEqualTo(Integer value) {
            addCriterion("courierId <>", value, "courierid");
            return (Criteria) this;
        }

        public Criteria andCourieridGreaterThan(Integer value) {
            addCriterion("courierId >", value, "courierid");
            return (Criteria) this;
        }

        public Criteria andCourieridGreaterThanOrEqualTo(Integer value) {
            addCriterion("courierId >=", value, "courierid");
            return (Criteria) this;
        }

        public Criteria andCourieridLessThan(Integer value) {
            addCriterion("courierId <", value, "courierid");
            return (Criteria) this;
        }

        public Criteria andCourieridLessThanOrEqualTo(Integer value) {
            addCriterion("courierId <=", value, "courierid");
            return (Criteria) this;
        }

        public Criteria andCourieridIn(List<Integer> values) {
            addCriterion("courierId in", values, "courierid");
            return (Criteria) this;
        }

        public Criteria andCourieridNotIn(List<Integer> values) {
            addCriterion("courierId not in", values, "courierid");
            return (Criteria) this;
        }

        public Criteria andCourieridBetween(Integer value1, Integer value2) {
            addCriterion("courierId between", value1, value2, "courierid");
            return (Criteria) this;
        }

        public Criteria andCourieridNotBetween(Integer value1, Integer value2) {
            addCriterion("courierId not between", value1, value2, "courierid");
            return (Criteria) this;
        }

        public Criteria andDeliverydatetimeIsNull() {
            addCriterion("deliveryDateTime is null");
            return (Criteria) this;
        }

        public Criteria andDeliverydatetimeIsNotNull() {
            addCriterion("deliveryDateTime is not null");
            return (Criteria) this;
        }

        public Criteria andDeliverydatetimeEqualTo(Date value) {
            addCriterion("deliveryDateTime =", value, "deliverydatetime");
            return (Criteria) this;
        }

        public Criteria andDeliverydatetimeNotEqualTo(Date value) {
            addCriterion("deliveryDateTime <>", value, "deliverydatetime");
            return (Criteria) this;
        }

        public Criteria andDeliverydatetimeGreaterThan(Date value) {
            addCriterion("deliveryDateTime >", value, "deliverydatetime");
            return (Criteria) this;
        }

        public Criteria andDeliverydatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("deliveryDateTime >=", value, "deliverydatetime");
            return (Criteria) this;
        }

        public Criteria andDeliverydatetimeLessThan(Date value) {
            addCriterion("deliveryDateTime <", value, "deliverydatetime");
            return (Criteria) this;
        }

        public Criteria andDeliverydatetimeLessThanOrEqualTo(Date value) {
            addCriterion("deliveryDateTime <=", value, "deliverydatetime");
            return (Criteria) this;
        }

        public Criteria andDeliverydatetimeIn(List<Date> values) {
            addCriterion("deliveryDateTime in", values, "deliverydatetime");
            return (Criteria) this;
        }

        public Criteria andDeliverydatetimeNotIn(List<Date> values) {
            addCriterion("deliveryDateTime not in", values, "deliverydatetime");
            return (Criteria) this;
        }

        public Criteria andDeliverydatetimeBetween(Date value1, Date value2) {
            addCriterion("deliveryDateTime between", value1, value2, "deliverydatetime");
            return (Criteria) this;
        }

        public Criteria andDeliverydatetimeNotBetween(Date value1, Date value2) {
            addCriterion("deliveryDateTime not between", value1, value2, "deliverydatetime");
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