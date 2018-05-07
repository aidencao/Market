package cn.market.pojo;

import java.util.ArrayList;
import java.util.List;

public class DeliveryOrderDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DeliveryOrderDetailExample() {
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

        public Criteria andBoxnoIsNull() {
            addCriterion("boxNo is null");
            return (Criteria) this;
        }

        public Criteria andBoxnoIsNotNull() {
            addCriterion("boxNo is not null");
            return (Criteria) this;
        }

        public Criteria andBoxnoEqualTo(Integer value) {
            addCriterion("boxNo =", value, "boxno");
            return (Criteria) this;
        }

        public Criteria andBoxnoNotEqualTo(Integer value) {
            addCriterion("boxNo <>", value, "boxno");
            return (Criteria) this;
        }

        public Criteria andBoxnoGreaterThan(Integer value) {
            addCriterion("boxNo >", value, "boxno");
            return (Criteria) this;
        }

        public Criteria andBoxnoGreaterThanOrEqualTo(Integer value) {
            addCriterion("boxNo >=", value, "boxno");
            return (Criteria) this;
        }

        public Criteria andBoxnoLessThan(Integer value) {
            addCriterion("boxNo <", value, "boxno");
            return (Criteria) this;
        }

        public Criteria andBoxnoLessThanOrEqualTo(Integer value) {
            addCriterion("boxNo <=", value, "boxno");
            return (Criteria) this;
        }

        public Criteria andBoxnoIn(List<Integer> values) {
            addCriterion("boxNo in", values, "boxno");
            return (Criteria) this;
        }

        public Criteria andBoxnoNotIn(List<Integer> values) {
            addCriterion("boxNo not in", values, "boxno");
            return (Criteria) this;
        }

        public Criteria andBoxnoBetween(Integer value1, Integer value2) {
            addCriterion("boxNo between", value1, value2, "boxno");
            return (Criteria) this;
        }

        public Criteria andBoxnoNotBetween(Integer value1, Integer value2) {
            addCriterion("boxNo not between", value1, value2, "boxno");
            return (Criteria) this;
        }

        public Criteria andGoodstypeidIsNull() {
            addCriterion("goodsTypeId is null");
            return (Criteria) this;
        }

        public Criteria andGoodstypeidIsNotNull() {
            addCriterion("goodsTypeId is not null");
            return (Criteria) this;
        }

        public Criteria andGoodstypeidEqualTo(Integer value) {
            addCriterion("goodsTypeId =", value, "goodstypeid");
            return (Criteria) this;
        }

        public Criteria andGoodstypeidNotEqualTo(Integer value) {
            addCriterion("goodsTypeId <>", value, "goodstypeid");
            return (Criteria) this;
        }

        public Criteria andGoodstypeidGreaterThan(Integer value) {
            addCriterion("goodsTypeId >", value, "goodstypeid");
            return (Criteria) this;
        }

        public Criteria andGoodstypeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("goodsTypeId >=", value, "goodstypeid");
            return (Criteria) this;
        }

        public Criteria andGoodstypeidLessThan(Integer value) {
            addCriterion("goodsTypeId <", value, "goodstypeid");
            return (Criteria) this;
        }

        public Criteria andGoodstypeidLessThanOrEqualTo(Integer value) {
            addCriterion("goodsTypeId <=", value, "goodstypeid");
            return (Criteria) this;
        }

        public Criteria andGoodstypeidIn(List<Integer> values) {
            addCriterion("goodsTypeId in", values, "goodstypeid");
            return (Criteria) this;
        }

        public Criteria andGoodstypeidNotIn(List<Integer> values) {
            addCriterion("goodsTypeId not in", values, "goodstypeid");
            return (Criteria) this;
        }

        public Criteria andGoodstypeidBetween(Integer value1, Integer value2) {
            addCriterion("goodsTypeId between", value1, value2, "goodstypeid");
            return (Criteria) this;
        }

        public Criteria andGoodstypeidNotBetween(Integer value1, Integer value2) {
            addCriterion("goodsTypeId not between", value1, value2, "goodstypeid");
            return (Criteria) this;
        }

        public Criteria andNumIsNull() {
            addCriterion("num is null");
            return (Criteria) this;
        }

        public Criteria andNumIsNotNull() {
            addCriterion("num is not null");
            return (Criteria) this;
        }

        public Criteria andNumEqualTo(Integer value) {
            addCriterion("num =", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotEqualTo(Integer value) {
            addCriterion("num <>", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThan(Integer value) {
            addCriterion("num >", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("num >=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThan(Integer value) {
            addCriterion("num <", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThanOrEqualTo(Integer value) {
            addCriterion("num <=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumIn(List<Integer> values) {
            addCriterion("num in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotIn(List<Integer> values) {
            addCriterion("num not in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumBetween(Integer value1, Integer value2) {
            addCriterion("num between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotBetween(Integer value1, Integer value2) {
            addCriterion("num not between", value1, value2, "num");
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