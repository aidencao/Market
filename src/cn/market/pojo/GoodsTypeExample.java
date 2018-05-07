package cn.market.pojo;

import java.util.ArrayList;
import java.util.List;

public class GoodsTypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodsTypeExample() {
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

        public Criteria andGoodsnameIsNull() {
            addCriterion("goodsName is null");
            return (Criteria) this;
        }

        public Criteria andGoodsnameIsNotNull() {
            addCriterion("goodsName is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsnameEqualTo(String value) {
            addCriterion("goodsName =", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameNotEqualTo(String value) {
            addCriterion("goodsName <>", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameGreaterThan(String value) {
            addCriterion("goodsName >", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameGreaterThanOrEqualTo(String value) {
            addCriterion("goodsName >=", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameLessThan(String value) {
            addCriterion("goodsName <", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameLessThanOrEqualTo(String value) {
            addCriterion("goodsName <=", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameLike(String value) {
            addCriterion("goodsName like", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameNotLike(String value) {
            addCriterion("goodsName not like", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameIn(List<String> values) {
            addCriterion("goodsName in", values, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameNotIn(List<String> values) {
            addCriterion("goodsName not in", values, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameBetween(String value1, String value2) {
            addCriterion("goodsName between", value1, value2, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameNotBetween(String value1, String value2) {
            addCriterion("goodsName not between", value1, value2, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsunitIsNull() {
            addCriterion("goodsUnit is null");
            return (Criteria) this;
        }

        public Criteria andGoodsunitIsNotNull() {
            addCriterion("goodsUnit is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsunitEqualTo(String value) {
            addCriterion("goodsUnit =", value, "goodsunit");
            return (Criteria) this;
        }

        public Criteria andGoodsunitNotEqualTo(String value) {
            addCriterion("goodsUnit <>", value, "goodsunit");
            return (Criteria) this;
        }

        public Criteria andGoodsunitGreaterThan(String value) {
            addCriterion("goodsUnit >", value, "goodsunit");
            return (Criteria) this;
        }

        public Criteria andGoodsunitGreaterThanOrEqualTo(String value) {
            addCriterion("goodsUnit >=", value, "goodsunit");
            return (Criteria) this;
        }

        public Criteria andGoodsunitLessThan(String value) {
            addCriterion("goodsUnit <", value, "goodsunit");
            return (Criteria) this;
        }

        public Criteria andGoodsunitLessThanOrEqualTo(String value) {
            addCriterion("goodsUnit <=", value, "goodsunit");
            return (Criteria) this;
        }

        public Criteria andGoodsunitLike(String value) {
            addCriterion("goodsUnit like", value, "goodsunit");
            return (Criteria) this;
        }

        public Criteria andGoodsunitNotLike(String value) {
            addCriterion("goodsUnit not like", value, "goodsunit");
            return (Criteria) this;
        }

        public Criteria andGoodsunitIn(List<String> values) {
            addCriterion("goodsUnit in", values, "goodsunit");
            return (Criteria) this;
        }

        public Criteria andGoodsunitNotIn(List<String> values) {
            addCriterion("goodsUnit not in", values, "goodsunit");
            return (Criteria) this;
        }

        public Criteria andGoodsunitBetween(String value1, String value2) {
            addCriterion("goodsUnit between", value1, value2, "goodsunit");
            return (Criteria) this;
        }

        public Criteria andGoodsunitNotBetween(String value1, String value2) {
            addCriterion("goodsUnit not between", value1, value2, "goodsunit");
            return (Criteria) this;
        }

        public Criteria andGoodsspecIsNull() {
            addCriterion("goodsSpec is null");
            return (Criteria) this;
        }

        public Criteria andGoodsspecIsNotNull() {
            addCriterion("goodsSpec is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsspecEqualTo(String value) {
            addCriterion("goodsSpec =", value, "goodsspec");
            return (Criteria) this;
        }

        public Criteria andGoodsspecNotEqualTo(String value) {
            addCriterion("goodsSpec <>", value, "goodsspec");
            return (Criteria) this;
        }

        public Criteria andGoodsspecGreaterThan(String value) {
            addCriterion("goodsSpec >", value, "goodsspec");
            return (Criteria) this;
        }

        public Criteria andGoodsspecGreaterThanOrEqualTo(String value) {
            addCriterion("goodsSpec >=", value, "goodsspec");
            return (Criteria) this;
        }

        public Criteria andGoodsspecLessThan(String value) {
            addCriterion("goodsSpec <", value, "goodsspec");
            return (Criteria) this;
        }

        public Criteria andGoodsspecLessThanOrEqualTo(String value) {
            addCriterion("goodsSpec <=", value, "goodsspec");
            return (Criteria) this;
        }

        public Criteria andGoodsspecLike(String value) {
            addCriterion("goodsSpec like", value, "goodsspec");
            return (Criteria) this;
        }

        public Criteria andGoodsspecNotLike(String value) {
            addCriterion("goodsSpec not like", value, "goodsspec");
            return (Criteria) this;
        }

        public Criteria andGoodsspecIn(List<String> values) {
            addCriterion("goodsSpec in", values, "goodsspec");
            return (Criteria) this;
        }

        public Criteria andGoodsspecNotIn(List<String> values) {
            addCriterion("goodsSpec not in", values, "goodsspec");
            return (Criteria) this;
        }

        public Criteria andGoodsspecBetween(String value1, String value2) {
            addCriterion("goodsSpec between", value1, value2, "goodsspec");
            return (Criteria) this;
        }

        public Criteria andGoodsspecNotBetween(String value1, String value2) {
            addCriterion("goodsSpec not between", value1, value2, "goodsspec");
            return (Criteria) this;
        }

        public Criteria andPurduceridIsNull() {
            addCriterion("purducerId is null");
            return (Criteria) this;
        }

        public Criteria andPurduceridIsNotNull() {
            addCriterion("purducerId is not null");
            return (Criteria) this;
        }

        public Criteria andPurduceridEqualTo(Integer value) {
            addCriterion("purducerId =", value, "purducerid");
            return (Criteria) this;
        }

        public Criteria andPurduceridNotEqualTo(Integer value) {
            addCriterion("purducerId <>", value, "purducerid");
            return (Criteria) this;
        }

        public Criteria andPurduceridGreaterThan(Integer value) {
            addCriterion("purducerId >", value, "purducerid");
            return (Criteria) this;
        }

        public Criteria andPurduceridGreaterThanOrEqualTo(Integer value) {
            addCriterion("purducerId >=", value, "purducerid");
            return (Criteria) this;
        }

        public Criteria andPurduceridLessThan(Integer value) {
            addCriterion("purducerId <", value, "purducerid");
            return (Criteria) this;
        }

        public Criteria andPurduceridLessThanOrEqualTo(Integer value) {
            addCriterion("purducerId <=", value, "purducerid");
            return (Criteria) this;
        }

        public Criteria andPurduceridIn(List<Integer> values) {
            addCriterion("purducerId in", values, "purducerid");
            return (Criteria) this;
        }

        public Criteria andPurduceridNotIn(List<Integer> values) {
            addCriterion("purducerId not in", values, "purducerid");
            return (Criteria) this;
        }

        public Criteria andPurduceridBetween(Integer value1, Integer value2) {
            addCriterion("purducerId between", value1, value2, "purducerid");
            return (Criteria) this;
        }

        public Criteria andPurduceridNotBetween(Integer value1, Integer value2) {
            addCriterion("purducerId not between", value1, value2, "purducerid");
            return (Criteria) this;
        }

        public Criteria andSalepriceIsNull() {
            addCriterion("salePrice is null");
            return (Criteria) this;
        }

        public Criteria andSalepriceIsNotNull() {
            addCriterion("salePrice is not null");
            return (Criteria) this;
        }

        public Criteria andSalepriceEqualTo(Double value) {
            addCriterion("salePrice =", value, "saleprice");
            return (Criteria) this;
        }

        public Criteria andSalepriceNotEqualTo(Double value) {
            addCriterion("salePrice <>", value, "saleprice");
            return (Criteria) this;
        }

        public Criteria andSalepriceGreaterThan(Double value) {
            addCriterion("salePrice >", value, "saleprice");
            return (Criteria) this;
        }

        public Criteria andSalepriceGreaterThanOrEqualTo(Double value) {
            addCriterion("salePrice >=", value, "saleprice");
            return (Criteria) this;
        }

        public Criteria andSalepriceLessThan(Double value) {
            addCriterion("salePrice <", value, "saleprice");
            return (Criteria) this;
        }

        public Criteria andSalepriceLessThanOrEqualTo(Double value) {
            addCriterion("salePrice <=", value, "saleprice");
            return (Criteria) this;
        }

        public Criteria andSalepriceIn(List<Double> values) {
            addCriterion("salePrice in", values, "saleprice");
            return (Criteria) this;
        }

        public Criteria andSalepriceNotIn(List<Double> values) {
            addCriterion("salePrice not in", values, "saleprice");
            return (Criteria) this;
        }

        public Criteria andSalepriceBetween(Double value1, Double value2) {
            addCriterion("salePrice between", value1, value2, "saleprice");
            return (Criteria) this;
        }

        public Criteria andSalepriceNotBetween(Double value1, Double value2) {
            addCriterion("salePrice not between", value1, value2, "saleprice");
            return (Criteria) this;
        }

        public Criteria andValiddaysIsNull() {
            addCriterion("validDays is null");
            return (Criteria) this;
        }

        public Criteria andValiddaysIsNotNull() {
            addCriterion("validDays is not null");
            return (Criteria) this;
        }

        public Criteria andValiddaysEqualTo(Integer value) {
            addCriterion("validDays =", value, "validdays");
            return (Criteria) this;
        }

        public Criteria andValiddaysNotEqualTo(Integer value) {
            addCriterion("validDays <>", value, "validdays");
            return (Criteria) this;
        }

        public Criteria andValiddaysGreaterThan(Integer value) {
            addCriterion("validDays >", value, "validdays");
            return (Criteria) this;
        }

        public Criteria andValiddaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("validDays >=", value, "validdays");
            return (Criteria) this;
        }

        public Criteria andValiddaysLessThan(Integer value) {
            addCriterion("validDays <", value, "validdays");
            return (Criteria) this;
        }

        public Criteria andValiddaysLessThanOrEqualTo(Integer value) {
            addCriterion("validDays <=", value, "validdays");
            return (Criteria) this;
        }

        public Criteria andValiddaysIn(List<Integer> values) {
            addCriterion("validDays in", values, "validdays");
            return (Criteria) this;
        }

        public Criteria andValiddaysNotIn(List<Integer> values) {
            addCriterion("validDays not in", values, "validdays");
            return (Criteria) this;
        }

        public Criteria andValiddaysBetween(Integer value1, Integer value2) {
            addCriterion("validDays between", value1, value2, "validdays");
            return (Criteria) this;
        }

        public Criteria andValiddaysNotBetween(Integer value1, Integer value2) {
            addCriterion("validDays not between", value1, value2, "validdays");
            return (Criteria) this;
        }

        public Criteria andOtherIsNull() {
            addCriterion("other is null");
            return (Criteria) this;
        }

        public Criteria andOtherIsNotNull() {
            addCriterion("other is not null");
            return (Criteria) this;
        }

        public Criteria andOtherEqualTo(String value) {
            addCriterion("other =", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotEqualTo(String value) {
            addCriterion("other <>", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherGreaterThan(String value) {
            addCriterion("other >", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherGreaterThanOrEqualTo(String value) {
            addCriterion("other >=", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherLessThan(String value) {
            addCriterion("other <", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherLessThanOrEqualTo(String value) {
            addCriterion("other <=", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherLike(String value) {
            addCriterion("other like", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotLike(String value) {
            addCriterion("other not like", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherIn(List<String> values) {
            addCriterion("other in", values, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotIn(List<String> values) {
            addCriterion("other not in", values, "other");
            return (Criteria) this;
        }

        public Criteria andOtherBetween(String value1, String value2) {
            addCriterion("other between", value1, value2, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotBetween(String value1, String value2) {
            addCriterion("other not between", value1, value2, "other");
            return (Criteria) this;
        }

        public Criteria andPicIsNull() {
            addCriterion("pic is null");
            return (Criteria) this;
        }

        public Criteria andPicIsNotNull() {
            addCriterion("pic is not null");
            return (Criteria) this;
        }

        public Criteria andPicEqualTo(String value) {
            addCriterion("pic =", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicNotEqualTo(String value) {
            addCriterion("pic <>", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicGreaterThan(String value) {
            addCriterion("pic >", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicGreaterThanOrEqualTo(String value) {
            addCriterion("pic >=", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicLessThan(String value) {
            addCriterion("pic <", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicLessThanOrEqualTo(String value) {
            addCriterion("pic <=", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicLike(String value) {
            addCriterion("pic like", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicNotLike(String value) {
            addCriterion("pic not like", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicIn(List<String> values) {
            addCriterion("pic in", values, "pic");
            return (Criteria) this;
        }

        public Criteria andPicNotIn(List<String> values) {
            addCriterion("pic not in", values, "pic");
            return (Criteria) this;
        }

        public Criteria andPicBetween(String value1, String value2) {
            addCriterion("pic between", value1, value2, "pic");
            return (Criteria) this;
        }

        public Criteria andPicNotBetween(String value1, String value2) {
            addCriterion("pic not between", value1, value2, "pic");
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