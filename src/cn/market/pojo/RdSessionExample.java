package cn.market.pojo;

import java.util.ArrayList;
import java.util.List;

public class RdSessionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RdSessionExample() {
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

        public Criteria andRdsessionIsNull() {
            addCriterion("rdSession is null");
            return (Criteria) this;
        }

        public Criteria andRdsessionIsNotNull() {
            addCriterion("rdSession is not null");
            return (Criteria) this;
        }

        public Criteria andRdsessionEqualTo(String value) {
            addCriterion("rdSession =", value, "rdsession");
            return (Criteria) this;
        }

        public Criteria andRdsessionNotEqualTo(String value) {
            addCriterion("rdSession <>", value, "rdsession");
            return (Criteria) this;
        }

        public Criteria andRdsessionGreaterThan(String value) {
            addCriterion("rdSession >", value, "rdsession");
            return (Criteria) this;
        }

        public Criteria andRdsessionGreaterThanOrEqualTo(String value) {
            addCriterion("rdSession >=", value, "rdsession");
            return (Criteria) this;
        }

        public Criteria andRdsessionLessThan(String value) {
            addCriterion("rdSession <", value, "rdsession");
            return (Criteria) this;
        }

        public Criteria andRdsessionLessThanOrEqualTo(String value) {
            addCriterion("rdSession <=", value, "rdsession");
            return (Criteria) this;
        }

        public Criteria andRdsessionLike(String value) {
            addCriterion("rdSession like", value, "rdsession");
            return (Criteria) this;
        }

        public Criteria andRdsessionNotLike(String value) {
            addCriterion("rdSession not like", value, "rdsession");
            return (Criteria) this;
        }

        public Criteria andRdsessionIn(List<String> values) {
            addCriterion("rdSession in", values, "rdsession");
            return (Criteria) this;
        }

        public Criteria andRdsessionNotIn(List<String> values) {
            addCriterion("rdSession not in", values, "rdsession");
            return (Criteria) this;
        }

        public Criteria andRdsessionBetween(String value1, String value2) {
            addCriterion("rdSession between", value1, value2, "rdsession");
            return (Criteria) this;
        }

        public Criteria andRdsessionNotBetween(String value1, String value2) {
            addCriterion("rdSession not between", value1, value2, "rdsession");
            return (Criteria) this;
        }

        public Criteria andOpenidIsNull() {
            addCriterion("openId is null");
            return (Criteria) this;
        }

        public Criteria andOpenidIsNotNull() {
            addCriterion("openId is not null");
            return (Criteria) this;
        }

        public Criteria andOpenidEqualTo(String value) {
            addCriterion("openId =", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotEqualTo(String value) {
            addCriterion("openId <>", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidGreaterThan(String value) {
            addCriterion("openId >", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidGreaterThanOrEqualTo(String value) {
            addCriterion("openId >=", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLessThan(String value) {
            addCriterion("openId <", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLessThanOrEqualTo(String value) {
            addCriterion("openId <=", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLike(String value) {
            addCriterion("openId like", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotLike(String value) {
            addCriterion("openId not like", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidIn(List<String> values) {
            addCriterion("openId in", values, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotIn(List<String> values) {
            addCriterion("openId not in", values, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidBetween(String value1, String value2) {
            addCriterion("openId between", value1, value2, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotBetween(String value1, String value2) {
            addCriterion("openId not between", value1, value2, "openid");
            return (Criteria) this;
        }

        public Criteria andSessionkeyIsNull() {
            addCriterion("sessionKey is null");
            return (Criteria) this;
        }

        public Criteria andSessionkeyIsNotNull() {
            addCriterion("sessionKey is not null");
            return (Criteria) this;
        }

        public Criteria andSessionkeyEqualTo(String value) {
            addCriterion("sessionKey =", value, "sessionkey");
            return (Criteria) this;
        }

        public Criteria andSessionkeyNotEqualTo(String value) {
            addCriterion("sessionKey <>", value, "sessionkey");
            return (Criteria) this;
        }

        public Criteria andSessionkeyGreaterThan(String value) {
            addCriterion("sessionKey >", value, "sessionkey");
            return (Criteria) this;
        }

        public Criteria andSessionkeyGreaterThanOrEqualTo(String value) {
            addCriterion("sessionKey >=", value, "sessionkey");
            return (Criteria) this;
        }

        public Criteria andSessionkeyLessThan(String value) {
            addCriterion("sessionKey <", value, "sessionkey");
            return (Criteria) this;
        }

        public Criteria andSessionkeyLessThanOrEqualTo(String value) {
            addCriterion("sessionKey <=", value, "sessionkey");
            return (Criteria) this;
        }

        public Criteria andSessionkeyLike(String value) {
            addCriterion("sessionKey like", value, "sessionkey");
            return (Criteria) this;
        }

        public Criteria andSessionkeyNotLike(String value) {
            addCriterion("sessionKey not like", value, "sessionkey");
            return (Criteria) this;
        }

        public Criteria andSessionkeyIn(List<String> values) {
            addCriterion("sessionKey in", values, "sessionkey");
            return (Criteria) this;
        }

        public Criteria andSessionkeyNotIn(List<String> values) {
            addCriterion("sessionKey not in", values, "sessionkey");
            return (Criteria) this;
        }

        public Criteria andSessionkeyBetween(String value1, String value2) {
            addCriterion("sessionKey between", value1, value2, "sessionkey");
            return (Criteria) this;
        }

        public Criteria andSessionkeyNotBetween(String value1, String value2) {
            addCriterion("sessionKey not between", value1, value2, "sessionkey");
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