package cn.binux.pojo.sys;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysRoleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysRoleExample() {
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

        public Criteria andRoleIdIsNull() {
            addCriterion("role_id is null");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNotNull() {
            addCriterion("role_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoleIdEqualTo(Integer value) {
            addCriterion("role_id =", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotEqualTo(Integer value) {
            addCriterion("role_id <>", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThan(Integer value) {
            addCriterion("role_id >", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("role_id >=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThan(Integer value) {
            addCriterion("role_id <", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThanOrEqualTo(Integer value) {
            addCriterion("role_id <=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdIn(List<Integer> values) {
            addCriterion("role_id in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotIn(List<Integer> values) {
            addCriterion("role_id not in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdBetween(Integer value1, Integer value2) {
            addCriterion("role_id between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("role_id not between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleNameIsNull() {
            addCriterion("role_name is null");
            return (Criteria) this;
        }

        public Criteria andRoleNameIsNotNull() {
            addCriterion("role_name is not null");
            return (Criteria) this;
        }

        public Criteria andRoleNameEqualTo(String value) {
            addCriterion("role_name =", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotEqualTo(String value) {
            addCriterion("role_name <>", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameGreaterThan(String value) {
            addCriterion("role_name >", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameGreaterThanOrEqualTo(String value) {
            addCriterion("role_name >=", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameLessThan(String value) {
            addCriterion("role_name <", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameLessThanOrEqualTo(String value) {
            addCriterion("role_name <=", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameLike(String value) {
            addCriterion("role_name like", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotLike(String value) {
            addCriterion("role_name not like", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameIn(List<String> values) {
            addCriterion("role_name in", values, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotIn(List<String> values) {
            addCriterion("role_name not in", values, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameBetween(String value1, String value2) {
            addCriterion("role_name between", value1, value2, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotBetween(String value1, String value2) {
            addCriterion("role_name not between", value1, value2, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleDescIsNull() {
            addCriterion("role_desc is null");
            return (Criteria) this;
        }

        public Criteria andRoleDescIsNotNull() {
            addCriterion("role_desc is not null");
            return (Criteria) this;
        }

        public Criteria andRoleDescEqualTo(String value) {
            addCriterion("role_desc =", value, "roleDesc");
            return (Criteria) this;
        }

        public Criteria andRoleDescNotEqualTo(String value) {
            addCriterion("role_desc <>", value, "roleDesc");
            return (Criteria) this;
        }

        public Criteria andRoleDescGreaterThan(String value) {
            addCriterion("role_desc >", value, "roleDesc");
            return (Criteria) this;
        }

        public Criteria andRoleDescGreaterThanOrEqualTo(String value) {
            addCriterion("role_desc >=", value, "roleDesc");
            return (Criteria) this;
        }

        public Criteria andRoleDescLessThan(String value) {
            addCriterion("role_desc <", value, "roleDesc");
            return (Criteria) this;
        }

        public Criteria andRoleDescLessThanOrEqualTo(String value) {
            addCriterion("role_desc <=", value, "roleDesc");
            return (Criteria) this;
        }

        public Criteria andRoleDescLike(String value) {
            addCriterion("role_desc like", value, "roleDesc");
            return (Criteria) this;
        }

        public Criteria andRoleDescNotLike(String value) {
            addCriterion("role_desc not like", value, "roleDesc");
            return (Criteria) this;
        }

        public Criteria andRoleDescIn(List<String> values) {
            addCriterion("role_desc in", values, "roleDesc");
            return (Criteria) this;
        }

        public Criteria andRoleDescNotIn(List<String> values) {
            addCriterion("role_desc not in", values, "roleDesc");
            return (Criteria) this;
        }

        public Criteria andRoleDescBetween(String value1, String value2) {
            addCriterion("role_desc between", value1, value2, "roleDesc");
            return (Criteria) this;
        }

        public Criteria andRoleDescNotBetween(String value1, String value2) {
            addCriterion("role_desc not between", value1, value2, "roleDesc");
            return (Criteria) this;
        }

        public Criteria andRoleUpdateUserIsNull() {
            addCriterion("role_update_user is null");
            return (Criteria) this;
        }

        public Criteria andRoleUpdateUserIsNotNull() {
            addCriterion("role_update_user is not null");
            return (Criteria) this;
        }

        public Criteria andRoleUpdateUserEqualTo(Integer value) {
            addCriterion("role_update_user =", value, "roleUpdateUser");
            return (Criteria) this;
        }

        public Criteria andRoleUpdateUserNotEqualTo(Integer value) {
            addCriterion("role_update_user <>", value, "roleUpdateUser");
            return (Criteria) this;
        }

        public Criteria andRoleUpdateUserGreaterThan(Integer value) {
            addCriterion("role_update_user >", value, "roleUpdateUser");
            return (Criteria) this;
        }

        public Criteria andRoleUpdateUserGreaterThanOrEqualTo(Integer value) {
            addCriterion("role_update_user >=", value, "roleUpdateUser");
            return (Criteria) this;
        }

        public Criteria andRoleUpdateUserLessThan(Integer value) {
            addCriterion("role_update_user <", value, "roleUpdateUser");
            return (Criteria) this;
        }

        public Criteria andRoleUpdateUserLessThanOrEqualTo(Integer value) {
            addCriterion("role_update_user <=", value, "roleUpdateUser");
            return (Criteria) this;
        }

        public Criteria andRoleUpdateUserIn(List<Integer> values) {
            addCriterion("role_update_user in", values, "roleUpdateUser");
            return (Criteria) this;
        }

        public Criteria andRoleUpdateUserNotIn(List<Integer> values) {
            addCriterion("role_update_user not in", values, "roleUpdateUser");
            return (Criteria) this;
        }

        public Criteria andRoleUpdateUserBetween(Integer value1, Integer value2) {
            addCriterion("role_update_user between", value1, value2, "roleUpdateUser");
            return (Criteria) this;
        }

        public Criteria andRoleUpdateUserNotBetween(Integer value1, Integer value2) {
            addCriterion("role_update_user not between", value1, value2, "roleUpdateUser");
            return (Criteria) this;
        }

        public Criteria andRoleCreateDateIsNull() {
            addCriterion("role_create_date is null");
            return (Criteria) this;
        }

        public Criteria andRoleCreateDateIsNotNull() {
            addCriterion("role_create_date is not null");
            return (Criteria) this;
        }

        public Criteria andRoleCreateDateEqualTo(String value) {
            addCriterion("role_create_date =", value, "roleCreateDate");
            return (Criteria) this;
        }

        public Criteria andRoleCreateDateNotEqualTo(String value) {
            addCriterion("role_create_date <>", value, "roleCreateDate");
            return (Criteria) this;
        }

        public Criteria andRoleCreateDateGreaterThan(String value) {
            addCriterion("role_create_date >", value, "roleCreateDate");
            return (Criteria) this;
        }

        public Criteria andRoleCreateDateGreaterThanOrEqualTo(String value) {
            addCriterion("role_create_date >=", value, "roleCreateDate");
            return (Criteria) this;
        }

        public Criteria andRoleCreateDateLessThan(String value) {
            addCriterion("role_create_date <", value, "roleCreateDate");
            return (Criteria) this;
        }

        public Criteria andRoleCreateDateLessThanOrEqualTo(String value) {
            addCriterion("role_create_date <=", value, "roleCreateDate");
            return (Criteria) this;
        }

        public Criteria andRoleCreateDateLike(String value) {
            addCriterion("role_create_date like", value, "roleCreateDate");
            return (Criteria) this;
        }

        public Criteria andRoleCreateDateNotLike(String value) {
            addCriterion("role_create_date not like", value, "roleCreateDate");
            return (Criteria) this;
        }

        public Criteria andRoleCreateDateIn(List<String> values) {
            addCriterion("role_create_date in", values, "roleCreateDate");
            return (Criteria) this;
        }

        public Criteria andRoleCreateDateNotIn(List<String> values) {
            addCriterion("role_create_date not in", values, "roleCreateDate");
            return (Criteria) this;
        }

        public Criteria andRoleCreateDateBetween(String value1, String value2) {
            addCriterion("role_create_date between", value1, value2, "roleCreateDate");
            return (Criteria) this;
        }

        public Criteria andRoleCreateDateNotBetween(String value1, String value2) {
            addCriterion("role_create_date not between", value1, value2, "roleCreateDate");
            return (Criteria) this;
        }

        public Criteria andRoleUpdateDateIsNull() {
            addCriterion("role_update_date is null");
            return (Criteria) this;
        }

        public Criteria andRoleUpdateDateIsNotNull() {
            addCriterion("role_update_date is not null");
            return (Criteria) this;
        }

        public Criteria andRoleUpdateDateEqualTo(Date value) {
            addCriterion("role_update_date =", value, "roleUpdateDate");
            return (Criteria) this;
        }

        public Criteria andRoleUpdateDateNotEqualTo(Date value) {
            addCriterion("role_update_date <>", value, "roleUpdateDate");
            return (Criteria) this;
        }

        public Criteria andRoleUpdateDateGreaterThan(Date value) {
            addCriterion("role_update_date >", value, "roleUpdateDate");
            return (Criteria) this;
        }

        public Criteria andRoleUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("role_update_date >=", value, "roleUpdateDate");
            return (Criteria) this;
        }

        public Criteria andRoleUpdateDateLessThan(Date value) {
            addCriterion("role_update_date <", value, "roleUpdateDate");
            return (Criteria) this;
        }

        public Criteria andRoleUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("role_update_date <=", value, "roleUpdateDate");
            return (Criteria) this;
        }

        public Criteria andRoleUpdateDateIn(List<Date> values) {
            addCriterion("role_update_date in", values, "roleUpdateDate");
            return (Criteria) this;
        }

        public Criteria andRoleUpdateDateNotIn(List<Date> values) {
            addCriterion("role_update_date not in", values, "roleUpdateDate");
            return (Criteria) this;
        }

        public Criteria andRoleUpdateDateBetween(Date value1, Date value2) {
            addCriterion("role_update_date between", value1, value2, "roleUpdateDate");
            return (Criteria) this;
        }

        public Criteria andRoleUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("role_update_date not between", value1, value2, "roleUpdateDate");
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