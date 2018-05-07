package cn.market.pojo;

import java.util.ArrayList;
import java.util.List;

public class MachineInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MachineInfoExample() {
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

        public Criteria andMactypeIsNull() {
            addCriterion("macType is null");
            return (Criteria) this;
        }

        public Criteria andMactypeIsNotNull() {
            addCriterion("macType is not null");
            return (Criteria) this;
        }

        public Criteria andMactypeEqualTo(Integer value) {
            addCriterion("macType =", value, "mactype");
            return (Criteria) this;
        }

        public Criteria andMactypeNotEqualTo(Integer value) {
            addCriterion("macType <>", value, "mactype");
            return (Criteria) this;
        }

        public Criteria andMactypeGreaterThan(Integer value) {
            addCriterion("macType >", value, "mactype");
            return (Criteria) this;
        }

        public Criteria andMactypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("macType >=", value, "mactype");
            return (Criteria) this;
        }

        public Criteria andMactypeLessThan(Integer value) {
            addCriterion("macType <", value, "mactype");
            return (Criteria) this;
        }

        public Criteria andMactypeLessThanOrEqualTo(Integer value) {
            addCriterion("macType <=", value, "mactype");
            return (Criteria) this;
        }

        public Criteria andMactypeIn(List<Integer> values) {
            addCriterion("macType in", values, "mactype");
            return (Criteria) this;
        }

        public Criteria andMactypeNotIn(List<Integer> values) {
            addCriterion("macType not in", values, "mactype");
            return (Criteria) this;
        }

        public Criteria andMactypeBetween(Integer value1, Integer value2) {
            addCriterion("macType between", value1, value2, "mactype");
            return (Criteria) this;
        }

        public Criteria andMactypeNotBetween(Integer value1, Integer value2) {
            addCriterion("macType not between", value1, value2, "mactype");
            return (Criteria) this;
        }

        public Criteria andMaclocationIsNull() {
            addCriterion("macLocation is null");
            return (Criteria) this;
        }

        public Criteria andMaclocationIsNotNull() {
            addCriterion("macLocation is not null");
            return (Criteria) this;
        }

        public Criteria andMaclocationEqualTo(String value) {
            addCriterion("macLocation =", value, "maclocation");
            return (Criteria) this;
        }

        public Criteria andMaclocationNotEqualTo(String value) {
            addCriterion("macLocation <>", value, "maclocation");
            return (Criteria) this;
        }

        public Criteria andMaclocationGreaterThan(String value) {
            addCriterion("macLocation >", value, "maclocation");
            return (Criteria) this;
        }

        public Criteria andMaclocationGreaterThanOrEqualTo(String value) {
            addCriterion("macLocation >=", value, "maclocation");
            return (Criteria) this;
        }

        public Criteria andMaclocationLessThan(String value) {
            addCriterion("macLocation <", value, "maclocation");
            return (Criteria) this;
        }

        public Criteria andMaclocationLessThanOrEqualTo(String value) {
            addCriterion("macLocation <=", value, "maclocation");
            return (Criteria) this;
        }

        public Criteria andMaclocationLike(String value) {
            addCriterion("macLocation like", value, "maclocation");
            return (Criteria) this;
        }

        public Criteria andMaclocationNotLike(String value) {
            addCriterion("macLocation not like", value, "maclocation");
            return (Criteria) this;
        }

        public Criteria andMaclocationIn(List<String> values) {
            addCriterion("macLocation in", values, "maclocation");
            return (Criteria) this;
        }

        public Criteria andMaclocationNotIn(List<String> values) {
            addCriterion("macLocation not in", values, "maclocation");
            return (Criteria) this;
        }

        public Criteria andMaclocationBetween(String value1, String value2) {
            addCriterion("macLocation between", value1, value2, "maclocation");
            return (Criteria) this;
        }

        public Criteria andMaclocationNotBetween(String value1, String value2) {
            addCriterion("macLocation not between", value1, value2, "maclocation");
            return (Criteria) this;
        }

        public Criteria andWarehouseidIsNull() {
            addCriterion("warehouseId is null");
            return (Criteria) this;
        }

        public Criteria andWarehouseidIsNotNull() {
            addCriterion("warehouseId is not null");
            return (Criteria) this;
        }

        public Criteria andWarehouseidEqualTo(String value) {
            addCriterion("warehouseId =", value, "warehouseid");
            return (Criteria) this;
        }

        public Criteria andWarehouseidNotEqualTo(String value) {
            addCriterion("warehouseId <>", value, "warehouseid");
            return (Criteria) this;
        }

        public Criteria andWarehouseidGreaterThan(String value) {
            addCriterion("warehouseId >", value, "warehouseid");
            return (Criteria) this;
        }

        public Criteria andWarehouseidGreaterThanOrEqualTo(String value) {
            addCriterion("warehouseId >=", value, "warehouseid");
            return (Criteria) this;
        }

        public Criteria andWarehouseidLessThan(String value) {
            addCriterion("warehouseId <", value, "warehouseid");
            return (Criteria) this;
        }

        public Criteria andWarehouseidLessThanOrEqualTo(String value) {
            addCriterion("warehouseId <=", value, "warehouseid");
            return (Criteria) this;
        }

        public Criteria andWarehouseidLike(String value) {
            addCriterion("warehouseId like", value, "warehouseid");
            return (Criteria) this;
        }

        public Criteria andWarehouseidNotLike(String value) {
            addCriterion("warehouseId not like", value, "warehouseid");
            return (Criteria) this;
        }

        public Criteria andWarehouseidIn(List<String> values) {
            addCriterion("warehouseId in", values, "warehouseid");
            return (Criteria) this;
        }

        public Criteria andWarehouseidNotIn(List<String> values) {
            addCriterion("warehouseId not in", values, "warehouseid");
            return (Criteria) this;
        }

        public Criteria andWarehouseidBetween(String value1, String value2) {
            addCriterion("warehouseId between", value1, value2, "warehouseid");
            return (Criteria) this;
        }

        public Criteria andWarehouseidNotBetween(String value1, String value2) {
            addCriterion("warehouseId not between", value1, value2, "warehouseid");
            return (Criteria) this;
        }

        public Criteria andTotalsumIsNull() {
            addCriterion("totalSum is null");
            return (Criteria) this;
        }

        public Criteria andTotalsumIsNotNull() {
            addCriterion("totalSum is not null");
            return (Criteria) this;
        }

        public Criteria andTotalsumEqualTo(Integer value) {
            addCriterion("totalSum =", value, "totalsum");
            return (Criteria) this;
        }

        public Criteria andTotalsumNotEqualTo(Integer value) {
            addCriterion("totalSum <>", value, "totalsum");
            return (Criteria) this;
        }

        public Criteria andTotalsumGreaterThan(Integer value) {
            addCriterion("totalSum >", value, "totalsum");
            return (Criteria) this;
        }

        public Criteria andTotalsumGreaterThanOrEqualTo(Integer value) {
            addCriterion("totalSum >=", value, "totalsum");
            return (Criteria) this;
        }

        public Criteria andTotalsumLessThan(Integer value) {
            addCriterion("totalSum <", value, "totalsum");
            return (Criteria) this;
        }

        public Criteria andTotalsumLessThanOrEqualTo(Integer value) {
            addCriterion("totalSum <=", value, "totalsum");
            return (Criteria) this;
        }

        public Criteria andTotalsumIn(List<Integer> values) {
            addCriterion("totalSum in", values, "totalsum");
            return (Criteria) this;
        }

        public Criteria andTotalsumNotIn(List<Integer> values) {
            addCriterion("totalSum not in", values, "totalsum");
            return (Criteria) this;
        }

        public Criteria andTotalsumBetween(Integer value1, Integer value2) {
            addCriterion("totalSum between", value1, value2, "totalsum");
            return (Criteria) this;
        }

        public Criteria andTotalsumNotBetween(Integer value1, Integer value2) {
            addCriterion("totalSum not between", value1, value2, "totalsum");
            return (Criteria) this;
        }

        public Criteria andCurrentsumIsNull() {
            addCriterion("currentSum is null");
            return (Criteria) this;
        }

        public Criteria andCurrentsumIsNotNull() {
            addCriterion("currentSum is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentsumEqualTo(Integer value) {
            addCriterion("currentSum =", value, "currentsum");
            return (Criteria) this;
        }

        public Criteria andCurrentsumNotEqualTo(Integer value) {
            addCriterion("currentSum <>", value, "currentsum");
            return (Criteria) this;
        }

        public Criteria andCurrentsumGreaterThan(Integer value) {
            addCriterion("currentSum >", value, "currentsum");
            return (Criteria) this;
        }

        public Criteria andCurrentsumGreaterThanOrEqualTo(Integer value) {
            addCriterion("currentSum >=", value, "currentsum");
            return (Criteria) this;
        }

        public Criteria andCurrentsumLessThan(Integer value) {
            addCriterion("currentSum <", value, "currentsum");
            return (Criteria) this;
        }

        public Criteria andCurrentsumLessThanOrEqualTo(Integer value) {
            addCriterion("currentSum <=", value, "currentsum");
            return (Criteria) this;
        }

        public Criteria andCurrentsumIn(List<Integer> values) {
            addCriterion("currentSum in", values, "currentsum");
            return (Criteria) this;
        }

        public Criteria andCurrentsumNotIn(List<Integer> values) {
            addCriterion("currentSum not in", values, "currentsum");
            return (Criteria) this;
        }

        public Criteria andCurrentsumBetween(Integer value1, Integer value2) {
            addCriterion("currentSum between", value1, value2, "currentsum");
            return (Criteria) this;
        }

        public Criteria andCurrentsumNotBetween(Integer value1, Integer value2) {
            addCriterion("currentSum not between", value1, value2, "currentsum");
            return (Criteria) this;
        }

        public Criteria andSortingstatusIsNull() {
            addCriterion("sortingStatus is null");
            return (Criteria) this;
        }

        public Criteria andSortingstatusIsNotNull() {
            addCriterion("sortingStatus is not null");
            return (Criteria) this;
        }

        public Criteria andSortingstatusEqualTo(String value) {
            addCriterion("sortingStatus =", value, "sortingstatus");
            return (Criteria) this;
        }

        public Criteria andSortingstatusNotEqualTo(String value) {
            addCriterion("sortingStatus <>", value, "sortingstatus");
            return (Criteria) this;
        }

        public Criteria andSortingstatusGreaterThan(String value) {
            addCriterion("sortingStatus >", value, "sortingstatus");
            return (Criteria) this;
        }

        public Criteria andSortingstatusGreaterThanOrEqualTo(String value) {
            addCriterion("sortingStatus >=", value, "sortingstatus");
            return (Criteria) this;
        }

        public Criteria andSortingstatusLessThan(String value) {
            addCriterion("sortingStatus <", value, "sortingstatus");
            return (Criteria) this;
        }

        public Criteria andSortingstatusLessThanOrEqualTo(String value) {
            addCriterion("sortingStatus <=", value, "sortingstatus");
            return (Criteria) this;
        }

        public Criteria andSortingstatusLike(String value) {
            addCriterion("sortingStatus like", value, "sortingstatus");
            return (Criteria) this;
        }

        public Criteria andSortingstatusNotLike(String value) {
            addCriterion("sortingStatus not like", value, "sortingstatus");
            return (Criteria) this;
        }

        public Criteria andSortingstatusIn(List<String> values) {
            addCriterion("sortingStatus in", values, "sortingstatus");
            return (Criteria) this;
        }

        public Criteria andSortingstatusNotIn(List<String> values) {
            addCriterion("sortingStatus not in", values, "sortingstatus");
            return (Criteria) this;
        }

        public Criteria andSortingstatusBetween(String value1, String value2) {
            addCriterion("sortingStatus between", value1, value2, "sortingstatus");
            return (Criteria) this;
        }

        public Criteria andSortingstatusNotBetween(String value1, String value2) {
            addCriterion("sortingStatus not between", value1, value2, "sortingstatus");
            return (Criteria) this;
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

        public Criteria andBackdoorstatusIsNull() {
            addCriterion("backDoorStatus is null");
            return (Criteria) this;
        }

        public Criteria andBackdoorstatusIsNotNull() {
            addCriterion("backDoorStatus is not null");
            return (Criteria) this;
        }

        public Criteria andBackdoorstatusEqualTo(String value) {
            addCriterion("backDoorStatus =", value, "backdoorstatus");
            return (Criteria) this;
        }

        public Criteria andBackdoorstatusNotEqualTo(String value) {
            addCriterion("backDoorStatus <>", value, "backdoorstatus");
            return (Criteria) this;
        }

        public Criteria andBackdoorstatusGreaterThan(String value) {
            addCriterion("backDoorStatus >", value, "backdoorstatus");
            return (Criteria) this;
        }

        public Criteria andBackdoorstatusGreaterThanOrEqualTo(String value) {
            addCriterion("backDoorStatus >=", value, "backdoorstatus");
            return (Criteria) this;
        }

        public Criteria andBackdoorstatusLessThan(String value) {
            addCriterion("backDoorStatus <", value, "backdoorstatus");
            return (Criteria) this;
        }

        public Criteria andBackdoorstatusLessThanOrEqualTo(String value) {
            addCriterion("backDoorStatus <=", value, "backdoorstatus");
            return (Criteria) this;
        }

        public Criteria andBackdoorstatusLike(String value) {
            addCriterion("backDoorStatus like", value, "backdoorstatus");
            return (Criteria) this;
        }

        public Criteria andBackdoorstatusNotLike(String value) {
            addCriterion("backDoorStatus not like", value, "backdoorstatus");
            return (Criteria) this;
        }

        public Criteria andBackdoorstatusIn(List<String> values) {
            addCriterion("backDoorStatus in", values, "backdoorstatus");
            return (Criteria) this;
        }

        public Criteria andBackdoorstatusNotIn(List<String> values) {
            addCriterion("backDoorStatus not in", values, "backdoorstatus");
            return (Criteria) this;
        }

        public Criteria andBackdoorstatusBetween(String value1, String value2) {
            addCriterion("backDoorStatus between", value1, value2, "backdoorstatus");
            return (Criteria) this;
        }

        public Criteria andBackdoorstatusNotBetween(String value1, String value2) {
            addCriterion("backDoorStatus not between", value1, value2, "backdoorstatus");
            return (Criteria) this;
        }

        public Criteria andMacdoorstatusIsNull() {
            addCriterion("macDoorStatus is null");
            return (Criteria) this;
        }

        public Criteria andMacdoorstatusIsNotNull() {
            addCriterion("macDoorStatus is not null");
            return (Criteria) this;
        }

        public Criteria andMacdoorstatusEqualTo(String value) {
            addCriterion("macDoorStatus =", value, "macdoorstatus");
            return (Criteria) this;
        }

        public Criteria andMacdoorstatusNotEqualTo(String value) {
            addCriterion("macDoorStatus <>", value, "macdoorstatus");
            return (Criteria) this;
        }

        public Criteria andMacdoorstatusGreaterThan(String value) {
            addCriterion("macDoorStatus >", value, "macdoorstatus");
            return (Criteria) this;
        }

        public Criteria andMacdoorstatusGreaterThanOrEqualTo(String value) {
            addCriterion("macDoorStatus >=", value, "macdoorstatus");
            return (Criteria) this;
        }

        public Criteria andMacdoorstatusLessThan(String value) {
            addCriterion("macDoorStatus <", value, "macdoorstatus");
            return (Criteria) this;
        }

        public Criteria andMacdoorstatusLessThanOrEqualTo(String value) {
            addCriterion("macDoorStatus <=", value, "macdoorstatus");
            return (Criteria) this;
        }

        public Criteria andMacdoorstatusLike(String value) {
            addCriterion("macDoorStatus like", value, "macdoorstatus");
            return (Criteria) this;
        }

        public Criteria andMacdoorstatusNotLike(String value) {
            addCriterion("macDoorStatus not like", value, "macdoorstatus");
            return (Criteria) this;
        }

        public Criteria andMacdoorstatusIn(List<String> values) {
            addCriterion("macDoorStatus in", values, "macdoorstatus");
            return (Criteria) this;
        }

        public Criteria andMacdoorstatusNotIn(List<String> values) {
            addCriterion("macDoorStatus not in", values, "macdoorstatus");
            return (Criteria) this;
        }

        public Criteria andMacdoorstatusBetween(String value1, String value2) {
            addCriterion("macDoorStatus between", value1, value2, "macdoorstatus");
            return (Criteria) this;
        }

        public Criteria andMacdoorstatusNotBetween(String value1, String value2) {
            addCriterion("macDoorStatus not between", value1, value2, "macdoorstatus");
            return (Criteria) this;
        }

        public Criteria andMacrunningstatusIsNull() {
            addCriterion("macRunningStatus is null");
            return (Criteria) this;
        }

        public Criteria andMacrunningstatusIsNotNull() {
            addCriterion("macRunningStatus is not null");
            return (Criteria) this;
        }

        public Criteria andMacrunningstatusEqualTo(String value) {
            addCriterion("macRunningStatus =", value, "macrunningstatus");
            return (Criteria) this;
        }

        public Criteria andMacrunningstatusNotEqualTo(String value) {
            addCriterion("macRunningStatus <>", value, "macrunningstatus");
            return (Criteria) this;
        }

        public Criteria andMacrunningstatusGreaterThan(String value) {
            addCriterion("macRunningStatus >", value, "macrunningstatus");
            return (Criteria) this;
        }

        public Criteria andMacrunningstatusGreaterThanOrEqualTo(String value) {
            addCriterion("macRunningStatus >=", value, "macrunningstatus");
            return (Criteria) this;
        }

        public Criteria andMacrunningstatusLessThan(String value) {
            addCriterion("macRunningStatus <", value, "macrunningstatus");
            return (Criteria) this;
        }

        public Criteria andMacrunningstatusLessThanOrEqualTo(String value) {
            addCriterion("macRunningStatus <=", value, "macrunningstatus");
            return (Criteria) this;
        }

        public Criteria andMacrunningstatusLike(String value) {
            addCriterion("macRunningStatus like", value, "macrunningstatus");
            return (Criteria) this;
        }

        public Criteria andMacrunningstatusNotLike(String value) {
            addCriterion("macRunningStatus not like", value, "macrunningstatus");
            return (Criteria) this;
        }

        public Criteria andMacrunningstatusIn(List<String> values) {
            addCriterion("macRunningStatus in", values, "macrunningstatus");
            return (Criteria) this;
        }

        public Criteria andMacrunningstatusNotIn(List<String> values) {
            addCriterion("macRunningStatus not in", values, "macrunningstatus");
            return (Criteria) this;
        }

        public Criteria andMacrunningstatusBetween(String value1, String value2) {
            addCriterion("macRunningStatus between", value1, value2, "macrunningstatus");
            return (Criteria) this;
        }

        public Criteria andMacrunningstatusNotBetween(String value1, String value2) {
            addCriterion("macRunningStatus not between", value1, value2, "macrunningstatus");
            return (Criteria) this;
        }

        public Criteria andMacerrorIsNull() {
            addCriterion("macError is null");
            return (Criteria) this;
        }

        public Criteria andMacerrorIsNotNull() {
            addCriterion("macError is not null");
            return (Criteria) this;
        }

        public Criteria andMacerrorEqualTo(String value) {
            addCriterion("macError =", value, "macerror");
            return (Criteria) this;
        }

        public Criteria andMacerrorNotEqualTo(String value) {
            addCriterion("macError <>", value, "macerror");
            return (Criteria) this;
        }

        public Criteria andMacerrorGreaterThan(String value) {
            addCriterion("macError >", value, "macerror");
            return (Criteria) this;
        }

        public Criteria andMacerrorGreaterThanOrEqualTo(String value) {
            addCriterion("macError >=", value, "macerror");
            return (Criteria) this;
        }

        public Criteria andMacerrorLessThan(String value) {
            addCriterion("macError <", value, "macerror");
            return (Criteria) this;
        }

        public Criteria andMacerrorLessThanOrEqualTo(String value) {
            addCriterion("macError <=", value, "macerror");
            return (Criteria) this;
        }

        public Criteria andMacerrorLike(String value) {
            addCriterion("macError like", value, "macerror");
            return (Criteria) this;
        }

        public Criteria andMacerrorNotLike(String value) {
            addCriterion("macError not like", value, "macerror");
            return (Criteria) this;
        }

        public Criteria andMacerrorIn(List<String> values) {
            addCriterion("macError in", values, "macerror");
            return (Criteria) this;
        }

        public Criteria andMacerrorNotIn(List<String> values) {
            addCriterion("macError not in", values, "macerror");
            return (Criteria) this;
        }

        public Criteria andMacerrorBetween(String value1, String value2) {
            addCriterion("macError between", value1, value2, "macerror");
            return (Criteria) this;
        }

        public Criteria andMacerrorNotBetween(String value1, String value2) {
            addCriterion("macError not between", value1, value2, "macerror");
            return (Criteria) this;
        }

        public Criteria andTwodimencodeIsNull() {
            addCriterion("twoDimenCode is null");
            return (Criteria) this;
        }

        public Criteria andTwodimencodeIsNotNull() {
            addCriterion("twoDimenCode is not null");
            return (Criteria) this;
        }

        public Criteria andTwodimencodeEqualTo(String value) {
            addCriterion("twoDimenCode =", value, "twodimencode");
            return (Criteria) this;
        }

        public Criteria andTwodimencodeNotEqualTo(String value) {
            addCriterion("twoDimenCode <>", value, "twodimencode");
            return (Criteria) this;
        }

        public Criteria andTwodimencodeGreaterThan(String value) {
            addCriterion("twoDimenCode >", value, "twodimencode");
            return (Criteria) this;
        }

        public Criteria andTwodimencodeGreaterThanOrEqualTo(String value) {
            addCriterion("twoDimenCode >=", value, "twodimencode");
            return (Criteria) this;
        }

        public Criteria andTwodimencodeLessThan(String value) {
            addCriterion("twoDimenCode <", value, "twodimencode");
            return (Criteria) this;
        }

        public Criteria andTwodimencodeLessThanOrEqualTo(String value) {
            addCriterion("twoDimenCode <=", value, "twodimencode");
            return (Criteria) this;
        }

        public Criteria andTwodimencodeLike(String value) {
            addCriterion("twoDimenCode like", value, "twodimencode");
            return (Criteria) this;
        }

        public Criteria andTwodimencodeNotLike(String value) {
            addCriterion("twoDimenCode not like", value, "twodimencode");
            return (Criteria) this;
        }

        public Criteria andTwodimencodeIn(List<String> values) {
            addCriterion("twoDimenCode in", values, "twodimencode");
            return (Criteria) this;
        }

        public Criteria andTwodimencodeNotIn(List<String> values) {
            addCriterion("twoDimenCode not in", values, "twodimencode");
            return (Criteria) this;
        }

        public Criteria andTwodimencodeBetween(String value1, String value2) {
            addCriterion("twoDimenCode between", value1, value2, "twodimencode");
            return (Criteria) this;
        }

        public Criteria andTwodimencodeNotBetween(String value1, String value2) {
            addCriterion("twoDimenCode not between", value1, value2, "twodimencode");
            return (Criteria) this;
        }

        public Criteria andBatteryvoltageIsNull() {
            addCriterion("batteryVoltage is null");
            return (Criteria) this;
        }

        public Criteria andBatteryvoltageIsNotNull() {
            addCriterion("batteryVoltage is not null");
            return (Criteria) this;
        }

        public Criteria andBatteryvoltageEqualTo(Integer value) {
            addCriterion("batteryVoltage =", value, "batteryvoltage");
            return (Criteria) this;
        }

        public Criteria andBatteryvoltageNotEqualTo(Integer value) {
            addCriterion("batteryVoltage <>", value, "batteryvoltage");
            return (Criteria) this;
        }

        public Criteria andBatteryvoltageGreaterThan(Integer value) {
            addCriterion("batteryVoltage >", value, "batteryvoltage");
            return (Criteria) this;
        }

        public Criteria andBatteryvoltageGreaterThanOrEqualTo(Integer value) {
            addCriterion("batteryVoltage >=", value, "batteryvoltage");
            return (Criteria) this;
        }

        public Criteria andBatteryvoltageLessThan(Integer value) {
            addCriterion("batteryVoltage <", value, "batteryvoltage");
            return (Criteria) this;
        }

        public Criteria andBatteryvoltageLessThanOrEqualTo(Integer value) {
            addCriterion("batteryVoltage <=", value, "batteryvoltage");
            return (Criteria) this;
        }

        public Criteria andBatteryvoltageIn(List<Integer> values) {
            addCriterion("batteryVoltage in", values, "batteryvoltage");
            return (Criteria) this;
        }

        public Criteria andBatteryvoltageNotIn(List<Integer> values) {
            addCriterion("batteryVoltage not in", values, "batteryvoltage");
            return (Criteria) this;
        }

        public Criteria andBatteryvoltageBetween(Integer value1, Integer value2) {
            addCriterion("batteryVoltage between", value1, value2, "batteryvoltage");
            return (Criteria) this;
        }

        public Criteria andBatteryvoltageNotBetween(Integer value1, Integer value2) {
            addCriterion("batteryVoltage not between", value1, value2, "batteryvoltage");
            return (Criteria) this;
        }

        public Criteria andCurcustomidIsNull() {
            addCriterion("curCustomId is null");
            return (Criteria) this;
        }

        public Criteria andCurcustomidIsNotNull() {
            addCriterion("curCustomId is not null");
            return (Criteria) this;
        }

        public Criteria andCurcustomidEqualTo(String value) {
            addCriterion("curCustomId =", value, "curcustomid");
            return (Criteria) this;
        }

        public Criteria andCurcustomidNotEqualTo(String value) {
            addCriterion("curCustomId <>", value, "curcustomid");
            return (Criteria) this;
        }

        public Criteria andCurcustomidGreaterThan(String value) {
            addCriterion("curCustomId >", value, "curcustomid");
            return (Criteria) this;
        }

        public Criteria andCurcustomidGreaterThanOrEqualTo(String value) {
            addCriterion("curCustomId >=", value, "curcustomid");
            return (Criteria) this;
        }

        public Criteria andCurcustomidLessThan(String value) {
            addCriterion("curCustomId <", value, "curcustomid");
            return (Criteria) this;
        }

        public Criteria andCurcustomidLessThanOrEqualTo(String value) {
            addCriterion("curCustomId <=", value, "curcustomid");
            return (Criteria) this;
        }

        public Criteria andCurcustomidLike(String value) {
            addCriterion("curCustomId like", value, "curcustomid");
            return (Criteria) this;
        }

        public Criteria andCurcustomidNotLike(String value) {
            addCriterion("curCustomId not like", value, "curcustomid");
            return (Criteria) this;
        }

        public Criteria andCurcustomidIn(List<String> values) {
            addCriterion("curCustomId in", values, "curcustomid");
            return (Criteria) this;
        }

        public Criteria andCurcustomidNotIn(List<String> values) {
            addCriterion("curCustomId not in", values, "curcustomid");
            return (Criteria) this;
        }

        public Criteria andCurcustomidBetween(String value1, String value2) {
            addCriterion("curCustomId between", value1, value2, "curcustomid");
            return (Criteria) this;
        }

        public Criteria andCurcustomidNotBetween(String value1, String value2) {
            addCriterion("curCustomId not between", value1, value2, "curcustomid");
            return (Criteria) this;
        }

        public Criteria andCurorderidIsNull() {
            addCriterion("curOrderId is null");
            return (Criteria) this;
        }

        public Criteria andCurorderidIsNotNull() {
            addCriterion("curOrderId is not null");
            return (Criteria) this;
        }

        public Criteria andCurorderidEqualTo(String value) {
            addCriterion("curOrderId =", value, "curorderid");
            return (Criteria) this;
        }

        public Criteria andCurorderidNotEqualTo(String value) {
            addCriterion("curOrderId <>", value, "curorderid");
            return (Criteria) this;
        }

        public Criteria andCurorderidGreaterThan(String value) {
            addCriterion("curOrderId >", value, "curorderid");
            return (Criteria) this;
        }

        public Criteria andCurorderidGreaterThanOrEqualTo(String value) {
            addCriterion("curOrderId >=", value, "curorderid");
            return (Criteria) this;
        }

        public Criteria andCurorderidLessThan(String value) {
            addCriterion("curOrderId <", value, "curorderid");
            return (Criteria) this;
        }

        public Criteria andCurorderidLessThanOrEqualTo(String value) {
            addCriterion("curOrderId <=", value, "curorderid");
            return (Criteria) this;
        }

        public Criteria andCurorderidLike(String value) {
            addCriterion("curOrderId like", value, "curorderid");
            return (Criteria) this;
        }

        public Criteria andCurorderidNotLike(String value) {
            addCriterion("curOrderId not like", value, "curorderid");
            return (Criteria) this;
        }

        public Criteria andCurorderidIn(List<String> values) {
            addCriterion("curOrderId in", values, "curorderid");
            return (Criteria) this;
        }

        public Criteria andCurorderidNotIn(List<String> values) {
            addCriterion("curOrderId not in", values, "curorderid");
            return (Criteria) this;
        }

        public Criteria andCurorderidBetween(String value1, String value2) {
            addCriterion("curOrderId between", value1, value2, "curorderid");
            return (Criteria) this;
        }

        public Criteria andCurorderidNotBetween(String value1, String value2) {
            addCriterion("curOrderId not between", value1, value2, "curorderid");
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

        public Criteria andUseridIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userId =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userId <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userId >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userId >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userId <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userId <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userId in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userId not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userId between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userId not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andManagernameIsNull() {
            addCriterion("managerName is null");
            return (Criteria) this;
        }

        public Criteria andManagernameIsNotNull() {
            addCriterion("managerName is not null");
            return (Criteria) this;
        }

        public Criteria andManagernameEqualTo(String value) {
            addCriterion("managerName =", value, "managername");
            return (Criteria) this;
        }

        public Criteria andManagernameNotEqualTo(String value) {
            addCriterion("managerName <>", value, "managername");
            return (Criteria) this;
        }

        public Criteria andManagernameGreaterThan(String value) {
            addCriterion("managerName >", value, "managername");
            return (Criteria) this;
        }

        public Criteria andManagernameGreaterThanOrEqualTo(String value) {
            addCriterion("managerName >=", value, "managername");
            return (Criteria) this;
        }

        public Criteria andManagernameLessThan(String value) {
            addCriterion("managerName <", value, "managername");
            return (Criteria) this;
        }

        public Criteria andManagernameLessThanOrEqualTo(String value) {
            addCriterion("managerName <=", value, "managername");
            return (Criteria) this;
        }

        public Criteria andManagernameLike(String value) {
            addCriterion("managerName like", value, "managername");
            return (Criteria) this;
        }

        public Criteria andManagernameNotLike(String value) {
            addCriterion("managerName not like", value, "managername");
            return (Criteria) this;
        }

        public Criteria andManagernameIn(List<String> values) {
            addCriterion("managerName in", values, "managername");
            return (Criteria) this;
        }

        public Criteria andManagernameNotIn(List<String> values) {
            addCriterion("managerName not in", values, "managername");
            return (Criteria) this;
        }

        public Criteria andManagernameBetween(String value1, String value2) {
            addCriterion("managerName between", value1, value2, "managername");
            return (Criteria) this;
        }

        public Criteria andManagernameNotBetween(String value1, String value2) {
            addCriterion("managerName not between", value1, value2, "managername");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Integer value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Integer value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Integer value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Integer value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Integer value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Integer> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Integer> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Integer value1, Integer value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("version not between", value1, value2, "version");
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