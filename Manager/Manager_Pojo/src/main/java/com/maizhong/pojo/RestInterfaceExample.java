package com.maizhong.pojo;

import java.util.ArrayList;
import java.util.List;

public class RestInterfaceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RestInterfaceExample() {
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

        public Criteria andInterfaceNameIsNull() {
            addCriterion("interface_name is null");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameIsNotNull() {
            addCriterion("interface_name is not null");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameEqualTo(String value) {
            addCriterion("interface_name =", value, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameNotEqualTo(String value) {
            addCriterion("interface_name <>", value, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameGreaterThan(String value) {
            addCriterion("interface_name >", value, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameGreaterThanOrEqualTo(String value) {
            addCriterion("interface_name >=", value, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameLessThan(String value) {
            addCriterion("interface_name <", value, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameLessThanOrEqualTo(String value) {
            addCriterion("interface_name <=", value, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameLike(String value) {
            addCriterion("interface_name like", value, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameNotLike(String value) {
            addCriterion("interface_name not like", value, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameIn(List<String> values) {
            addCriterion("interface_name in", values, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameNotIn(List<String> values) {
            addCriterion("interface_name not in", values, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameBetween(String value1, String value2) {
            addCriterion("interface_name between", value1, value2, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameNotBetween(String value1, String value2) {
            addCriterion("interface_name not between", value1, value2, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceUrlIsNull() {
            addCriterion("interface_url is null");
            return (Criteria) this;
        }

        public Criteria andInterfaceUrlIsNotNull() {
            addCriterion("interface_url is not null");
            return (Criteria) this;
        }

        public Criteria andInterfaceUrlEqualTo(String value) {
            addCriterion("interface_url =", value, "interfaceUrl");
            return (Criteria) this;
        }

        public Criteria andInterfaceUrlNotEqualTo(String value) {
            addCriterion("interface_url <>", value, "interfaceUrl");
            return (Criteria) this;
        }

        public Criteria andInterfaceUrlGreaterThan(String value) {
            addCriterion("interface_url >", value, "interfaceUrl");
            return (Criteria) this;
        }

        public Criteria andInterfaceUrlGreaterThanOrEqualTo(String value) {
            addCriterion("interface_url >=", value, "interfaceUrl");
            return (Criteria) this;
        }

        public Criteria andInterfaceUrlLessThan(String value) {
            addCriterion("interface_url <", value, "interfaceUrl");
            return (Criteria) this;
        }

        public Criteria andInterfaceUrlLessThanOrEqualTo(String value) {
            addCriterion("interface_url <=", value, "interfaceUrl");
            return (Criteria) this;
        }

        public Criteria andInterfaceUrlLike(String value) {
            addCriterion("interface_url like", value, "interfaceUrl");
            return (Criteria) this;
        }

        public Criteria andInterfaceUrlNotLike(String value) {
            addCriterion("interface_url not like", value, "interfaceUrl");
            return (Criteria) this;
        }

        public Criteria andInterfaceUrlIn(List<String> values) {
            addCriterion("interface_url in", values, "interfaceUrl");
            return (Criteria) this;
        }

        public Criteria andInterfaceUrlNotIn(List<String> values) {
            addCriterion("interface_url not in", values, "interfaceUrl");
            return (Criteria) this;
        }

        public Criteria andInterfaceUrlBetween(String value1, String value2) {
            addCriterion("interface_url between", value1, value2, "interfaceUrl");
            return (Criteria) this;
        }

        public Criteria andInterfaceUrlNotBetween(String value1, String value2) {
            addCriterion("interface_url not between", value1, value2, "interfaceUrl");
            return (Criteria) this;
        }

        public Criteria andInterfaceParamIsNull() {
            addCriterion("interface_param is null");
            return (Criteria) this;
        }

        public Criteria andInterfaceParamIsNotNull() {
            addCriterion("interface_param is not null");
            return (Criteria) this;
        }

        public Criteria andInterfaceParamEqualTo(String value) {
            addCriterion("interface_param =", value, "interfaceParam");
            return (Criteria) this;
        }

        public Criteria andInterfaceParamNotEqualTo(String value) {
            addCriterion("interface_param <>", value, "interfaceParam");
            return (Criteria) this;
        }

        public Criteria andInterfaceParamGreaterThan(String value) {
            addCriterion("interface_param >", value, "interfaceParam");
            return (Criteria) this;
        }

        public Criteria andInterfaceParamGreaterThanOrEqualTo(String value) {
            addCriterion("interface_param >=", value, "interfaceParam");
            return (Criteria) this;
        }

        public Criteria andInterfaceParamLessThan(String value) {
            addCriterion("interface_param <", value, "interfaceParam");
            return (Criteria) this;
        }

        public Criteria andInterfaceParamLessThanOrEqualTo(String value) {
            addCriterion("interface_param <=", value, "interfaceParam");
            return (Criteria) this;
        }

        public Criteria andInterfaceParamLike(String value) {
            addCriterion("interface_param like", value, "interfaceParam");
            return (Criteria) this;
        }

        public Criteria andInterfaceParamNotLike(String value) {
            addCriterion("interface_param not like", value, "interfaceParam");
            return (Criteria) this;
        }

        public Criteria andInterfaceParamIn(List<String> values) {
            addCriterion("interface_param in", values, "interfaceParam");
            return (Criteria) this;
        }

        public Criteria andInterfaceParamNotIn(List<String> values) {
            addCriterion("interface_param not in", values, "interfaceParam");
            return (Criteria) this;
        }

        public Criteria andInterfaceParamBetween(String value1, String value2) {
            addCriterion("interface_param between", value1, value2, "interfaceParam");
            return (Criteria) this;
        }

        public Criteria andInterfaceParamNotBetween(String value1, String value2) {
            addCriterion("interface_param not between", value1, value2, "interfaceParam");
            return (Criteria) this;
        }

        public Criteria andInterfaceDescIsNull() {
            addCriterion("interface_desc is null");
            return (Criteria) this;
        }

        public Criteria andInterfaceDescIsNotNull() {
            addCriterion("interface_desc is not null");
            return (Criteria) this;
        }

        public Criteria andInterfaceDescEqualTo(String value) {
            addCriterion("interface_desc =", value, "interfaceDesc");
            return (Criteria) this;
        }

        public Criteria andInterfaceDescNotEqualTo(String value) {
            addCriterion("interface_desc <>", value, "interfaceDesc");
            return (Criteria) this;
        }

        public Criteria andInterfaceDescGreaterThan(String value) {
            addCriterion("interface_desc >", value, "interfaceDesc");
            return (Criteria) this;
        }

        public Criteria andInterfaceDescGreaterThanOrEqualTo(String value) {
            addCriterion("interface_desc >=", value, "interfaceDesc");
            return (Criteria) this;
        }

        public Criteria andInterfaceDescLessThan(String value) {
            addCriterion("interface_desc <", value, "interfaceDesc");
            return (Criteria) this;
        }

        public Criteria andInterfaceDescLessThanOrEqualTo(String value) {
            addCriterion("interface_desc <=", value, "interfaceDesc");
            return (Criteria) this;
        }

        public Criteria andInterfaceDescLike(String value) {
            addCriterion("interface_desc like", value, "interfaceDesc");
            return (Criteria) this;
        }

        public Criteria andInterfaceDescNotLike(String value) {
            addCriterion("interface_desc not like", value, "interfaceDesc");
            return (Criteria) this;
        }

        public Criteria andInterfaceDescIn(List<String> values) {
            addCriterion("interface_desc in", values, "interfaceDesc");
            return (Criteria) this;
        }

        public Criteria andInterfaceDescNotIn(List<String> values) {
            addCriterion("interface_desc not in", values, "interfaceDesc");
            return (Criteria) this;
        }

        public Criteria andInterfaceDescBetween(String value1, String value2) {
            addCriterion("interface_desc between", value1, value2, "interfaceDesc");
            return (Criteria) this;
        }

        public Criteria andInterfaceDescNotBetween(String value1, String value2) {
            addCriterion("interface_desc not between", value1, value2, "interfaceDesc");
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