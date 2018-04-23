package cn.binux.pojo.sys;

import java.util.ArrayList;
import java.util.List;

public class SysPermissionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysPermissionExample() {
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

        public Criteria andPermIdIsNull() {
            addCriterion("perm_id is null");
            return (Criteria) this;
        }

        public Criteria andPermIdIsNotNull() {
            addCriterion("perm_id is not null");
            return (Criteria) this;
        }

        public Criteria andPermIdEqualTo(Long value) {
            addCriterion("perm_id =", value, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdNotEqualTo(Long value) {
            addCriterion("perm_id <>", value, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdGreaterThan(Long value) {
            addCriterion("perm_id >", value, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdGreaterThanOrEqualTo(Long value) {
            addCriterion("perm_id >=", value, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdLessThan(Long value) {
            addCriterion("perm_id <", value, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdLessThanOrEqualTo(Long value) {
            addCriterion("perm_id <=", value, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdIn(List<Long> values) {
            addCriterion("perm_id in", values, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdNotIn(List<Long> values) {
            addCriterion("perm_id not in", values, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdBetween(Long value1, Long value2) {
            addCriterion("perm_id between", value1, value2, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdNotBetween(Long value1, Long value2) {
            addCriterion("perm_id not between", value1, value2, "permId");
            return (Criteria) this;
        }

        public Criteria andPermNameIsNull() {
            addCriterion("perm_name is null");
            return (Criteria) this;
        }

        public Criteria andPermNameIsNotNull() {
            addCriterion("perm_name is not null");
            return (Criteria) this;
        }

        public Criteria andPermNameEqualTo(String value) {
            addCriterion("perm_name =", value, "permName");
            return (Criteria) this;
        }

        public Criteria andPermNameNotEqualTo(String value) {
            addCriterion("perm_name <>", value, "permName");
            return (Criteria) this;
        }

        public Criteria andPermNameGreaterThan(String value) {
            addCriterion("perm_name >", value, "permName");
            return (Criteria) this;
        }

        public Criteria andPermNameGreaterThanOrEqualTo(String value) {
            addCriterion("perm_name >=", value, "permName");
            return (Criteria) this;
        }

        public Criteria andPermNameLessThan(String value) {
            addCriterion("perm_name <", value, "permName");
            return (Criteria) this;
        }

        public Criteria andPermNameLessThanOrEqualTo(String value) {
            addCriterion("perm_name <=", value, "permName");
            return (Criteria) this;
        }

        public Criteria andPermNameLike(String value) {
            addCriterion("perm_name like", value, "permName");
            return (Criteria) this;
        }

        public Criteria andPermNameNotLike(String value) {
            addCriterion("perm_name not like", value, "permName");
            return (Criteria) this;
        }

        public Criteria andPermNameIn(List<String> values) {
            addCriterion("perm_name in", values, "permName");
            return (Criteria) this;
        }

        public Criteria andPermNameNotIn(List<String> values) {
            addCriterion("perm_name not in", values, "permName");
            return (Criteria) this;
        }

        public Criteria andPermNameBetween(String value1, String value2) {
            addCriterion("perm_name between", value1, value2, "permName");
            return (Criteria) this;
        }

        public Criteria andPermNameNotBetween(String value1, String value2) {
            addCriterion("perm_name not between", value1, value2, "permName");
            return (Criteria) this;
        }

        public Criteria andPermDataUrlIsNull() {
            addCriterion("perm_data_url is null");
            return (Criteria) this;
        }

        public Criteria andPermDataUrlIsNotNull() {
            addCriterion("perm_data_url is not null");
            return (Criteria) this;
        }

        public Criteria andPermDataUrlEqualTo(String value) {
            addCriterion("perm_data_url =", value, "permDataUrl");
            return (Criteria) this;
        }

        public Criteria andPermDataUrlNotEqualTo(String value) {
            addCriterion("perm_data_url <>", value, "permDataUrl");
            return (Criteria) this;
        }

        public Criteria andPermDataUrlGreaterThan(String value) {
            addCriterion("perm_data_url >", value, "permDataUrl");
            return (Criteria) this;
        }

        public Criteria andPermDataUrlGreaterThanOrEqualTo(String value) {
            addCriterion("perm_data_url >=", value, "permDataUrl");
            return (Criteria) this;
        }

        public Criteria andPermDataUrlLessThan(String value) {
            addCriterion("perm_data_url <", value, "permDataUrl");
            return (Criteria) this;
        }

        public Criteria andPermDataUrlLessThanOrEqualTo(String value) {
            addCriterion("perm_data_url <=", value, "permDataUrl");
            return (Criteria) this;
        }

        public Criteria andPermDataUrlLike(String value) {
            addCriterion("perm_data_url like", value, "permDataUrl");
            return (Criteria) this;
        }

        public Criteria andPermDataUrlNotLike(String value) {
            addCriterion("perm_data_url not like", value, "permDataUrl");
            return (Criteria) this;
        }

        public Criteria andPermDataUrlIn(List<String> values) {
            addCriterion("perm_data_url in", values, "permDataUrl");
            return (Criteria) this;
        }

        public Criteria andPermDataUrlNotIn(List<String> values) {
            addCriterion("perm_data_url not in", values, "permDataUrl");
            return (Criteria) this;
        }

        public Criteria andPermDataUrlBetween(String value1, String value2) {
            addCriterion("perm_data_url between", value1, value2, "permDataUrl");
            return (Criteria) this;
        }

        public Criteria andPermDataUrlNotBetween(String value1, String value2) {
            addCriterion("perm_data_url not between", value1, value2, "permDataUrl");
            return (Criteria) this;
        }

        public Criteria andPermParentIdIsNull() {
            addCriterion("perm_parent_id is null");
            return (Criteria) this;
        }

        public Criteria andPermParentIdIsNotNull() {
            addCriterion("perm_parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andPermParentIdEqualTo(String value) {
            addCriterion("perm_parent_id =", value, "permParentId");
            return (Criteria) this;
        }

        public Criteria andPermParentIdNotEqualTo(String value) {
            addCriterion("perm_parent_id <>", value, "permParentId");
            return (Criteria) this;
        }

        public Criteria andPermParentIdGreaterThan(String value) {
            addCriterion("perm_parent_id >", value, "permParentId");
            return (Criteria) this;
        }

        public Criteria andPermParentIdGreaterThanOrEqualTo(String value) {
            addCriterion("perm_parent_id >=", value, "permParentId");
            return (Criteria) this;
        }

        public Criteria andPermParentIdLessThan(String value) {
            addCriterion("perm_parent_id <", value, "permParentId");
            return (Criteria) this;
        }

        public Criteria andPermParentIdLessThanOrEqualTo(String value) {
            addCriterion("perm_parent_id <=", value, "permParentId");
            return (Criteria) this;
        }

        public Criteria andPermParentIdLike(String value) {
            addCriterion("perm_parent_id like", value, "permParentId");
            return (Criteria) this;
        }

        public Criteria andPermParentIdNotLike(String value) {
            addCriterion("perm_parent_id not like", value, "permParentId");
            return (Criteria) this;
        }

        public Criteria andPermParentIdIn(List<String> values) {
            addCriterion("perm_parent_id in", values, "permParentId");
            return (Criteria) this;
        }

        public Criteria andPermParentIdNotIn(List<String> values) {
            addCriterion("perm_parent_id not in", values, "permParentId");
            return (Criteria) this;
        }

        public Criteria andPermParentIdBetween(String value1, String value2) {
            addCriterion("perm_parent_id between", value1, value2, "permParentId");
            return (Criteria) this;
        }

        public Criteria andPermParentIdNotBetween(String value1, String value2) {
            addCriterion("perm_parent_id not between", value1, value2, "permParentId");
            return (Criteria) this;
        }

        public Criteria andPermTypeIsNull() {
            addCriterion("perm_type is null");
            return (Criteria) this;
        }

        public Criteria andPermTypeIsNotNull() {
            addCriterion("perm_type is not null");
            return (Criteria) this;
        }

        public Criteria andPermTypeEqualTo(String value) {
            addCriterion("perm_type =", value, "permType");
            return (Criteria) this;
        }

        public Criteria andPermTypeNotEqualTo(String value) {
            addCriterion("perm_type <>", value, "permType");
            return (Criteria) this;
        }

        public Criteria andPermTypeGreaterThan(String value) {
            addCriterion("perm_type >", value, "permType");
            return (Criteria) this;
        }

        public Criteria andPermTypeGreaterThanOrEqualTo(String value) {
            addCriterion("perm_type >=", value, "permType");
            return (Criteria) this;
        }

        public Criteria andPermTypeLessThan(String value) {
            addCriterion("perm_type <", value, "permType");
            return (Criteria) this;
        }

        public Criteria andPermTypeLessThanOrEqualTo(String value) {
            addCriterion("perm_type <=", value, "permType");
            return (Criteria) this;
        }

        public Criteria andPermTypeLike(String value) {
            addCriterion("perm_type like", value, "permType");
            return (Criteria) this;
        }

        public Criteria andPermTypeNotLike(String value) {
            addCriterion("perm_type not like", value, "permType");
            return (Criteria) this;
        }

        public Criteria andPermTypeIn(List<String> values) {
            addCriterion("perm_type in", values, "permType");
            return (Criteria) this;
        }

        public Criteria andPermTypeNotIn(List<String> values) {
            addCriterion("perm_type not in", values, "permType");
            return (Criteria) this;
        }

        public Criteria andPermTypeBetween(String value1, String value2) {
            addCriterion("perm_type between", value1, value2, "permType");
            return (Criteria) this;
        }

        public Criteria andPermTypeNotBetween(String value1, String value2) {
            addCriterion("perm_type not between", value1, value2, "permType");
            return (Criteria) this;
        }

        public Criteria andPermCreateDateIsNull() {
            addCriterion("perm_create_date is null");
            return (Criteria) this;
        }

        public Criteria andPermCreateDateIsNotNull() {
            addCriterion("perm_create_date is not null");
            return (Criteria) this;
        }

        public Criteria andPermCreateDateEqualTo(String value) {
            addCriterion("perm_create_date =", value, "permCreateDate");
            return (Criteria) this;
        }

        public Criteria andPermCreateDateNotEqualTo(String value) {
            addCriterion("perm_create_date <>", value, "permCreateDate");
            return (Criteria) this;
        }

        public Criteria andPermCreateDateGreaterThan(String value) {
            addCriterion("perm_create_date >", value, "permCreateDate");
            return (Criteria) this;
        }

        public Criteria andPermCreateDateGreaterThanOrEqualTo(String value) {
            addCriterion("perm_create_date >=", value, "permCreateDate");
            return (Criteria) this;
        }

        public Criteria andPermCreateDateLessThan(String value) {
            addCriterion("perm_create_date <", value, "permCreateDate");
            return (Criteria) this;
        }

        public Criteria andPermCreateDateLessThanOrEqualTo(String value) {
            addCriterion("perm_create_date <=", value, "permCreateDate");
            return (Criteria) this;
        }

        public Criteria andPermCreateDateLike(String value) {
            addCriterion("perm_create_date like", value, "permCreateDate");
            return (Criteria) this;
        }

        public Criteria andPermCreateDateNotLike(String value) {
            addCriterion("perm_create_date not like", value, "permCreateDate");
            return (Criteria) this;
        }

        public Criteria andPermCreateDateIn(List<String> values) {
            addCriterion("perm_create_date in", values, "permCreateDate");
            return (Criteria) this;
        }

        public Criteria andPermCreateDateNotIn(List<String> values) {
            addCriterion("perm_create_date not in", values, "permCreateDate");
            return (Criteria) this;
        }

        public Criteria andPermCreateDateBetween(String value1, String value2) {
            addCriterion("perm_create_date between", value1, value2, "permCreateDate");
            return (Criteria) this;
        }

        public Criteria andPermCreateDateNotBetween(String value1, String value2) {
            addCriterion("perm_create_date not between", value1, value2, "permCreateDate");
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