package cn.binux.pojo;

import java.util.ArrayList;
import java.util.List;

public class AddressExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AddressExample() {
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

        public Criteria andAddressIdIsNull() {
            addCriterion("ADDRESS_ID is null");
            return (Criteria) this;
        }

        public Criteria andAddressIdIsNotNull() {
            addCriterion("ADDRESS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAddressIdEqualTo(Integer value) {
            addCriterion("ADDRESS_ID =", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdNotEqualTo(Integer value) {
            addCriterion("ADDRESS_ID <>", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdGreaterThan(Integer value) {
            addCriterion("ADDRESS_ID >", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ADDRESS_ID >=", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdLessThan(Integer value) {
            addCriterion("ADDRESS_ID <", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdLessThanOrEqualTo(Integer value) {
            addCriterion("ADDRESS_ID <=", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdIn(List<Integer> values) {
            addCriterion("ADDRESS_ID in", values, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdNotIn(List<Integer> values) {
            addCriterion("ADDRESS_ID not in", values, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdBetween(Integer value1, Integer value2) {
            addCriterion("ADDRESS_ID between", value1, value2, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ADDRESS_ID not between", value1, value2, "addressId");
            return (Criteria) this;
        }

        public Criteria andSendPlaceIsNull() {
            addCriterion("SEND_PLACE is null");
            return (Criteria) this;
        }

        public Criteria andSendPlaceIsNotNull() {
            addCriterion("SEND_PLACE is not null");
            return (Criteria) this;
        }

        public Criteria andSendPlaceEqualTo(String value) {
            addCriterion("SEND_PLACE =", value, "sendPlace");
            return (Criteria) this;
        }

        public Criteria andSendPlaceNotEqualTo(String value) {
            addCriterion("SEND_PLACE <>", value, "sendPlace");
            return (Criteria) this;
        }

        public Criteria andSendPlaceGreaterThan(String value) {
            addCriterion("SEND_PLACE >", value, "sendPlace");
            return (Criteria) this;
        }

        public Criteria andSendPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("SEND_PLACE >=", value, "sendPlace");
            return (Criteria) this;
        }

        public Criteria andSendPlaceLessThan(String value) {
            addCriterion("SEND_PLACE <", value, "sendPlace");
            return (Criteria) this;
        }

        public Criteria andSendPlaceLessThanOrEqualTo(String value) {
            addCriterion("SEND_PLACE <=", value, "sendPlace");
            return (Criteria) this;
        }

        public Criteria andSendPlaceLike(String value) {
            addCriterion("SEND_PLACE like", value, "sendPlace");
            return (Criteria) this;
        }

        public Criteria andSendPlaceNotLike(String value) {
            addCriterion("SEND_PLACE not like", value, "sendPlace");
            return (Criteria) this;
        }

        public Criteria andSendPlaceIn(List<String> values) {
            addCriterion("SEND_PLACE in", values, "sendPlace");
            return (Criteria) this;
        }

        public Criteria andSendPlaceNotIn(List<String> values) {
            addCriterion("SEND_PLACE not in", values, "sendPlace");
            return (Criteria) this;
        }

        public Criteria andSendPlaceBetween(String value1, String value2) {
            addCriterion("SEND_PLACE between", value1, value2, "sendPlace");
            return (Criteria) this;
        }

        public Criteria andSendPlaceNotBetween(String value1, String value2) {
            addCriterion("SEND_PLACE not between", value1, value2, "sendPlace");
            return (Criteria) this;
        }

        public Criteria andSendManIsNull() {
            addCriterion("SEND_MAN is null");
            return (Criteria) this;
        }

        public Criteria andSendManIsNotNull() {
            addCriterion("SEND_MAN is not null");
            return (Criteria) this;
        }

        public Criteria andSendManEqualTo(String value) {
            addCriterion("SEND_MAN =", value, "sendMan");
            return (Criteria) this;
        }

        public Criteria andSendManNotEqualTo(String value) {
            addCriterion("SEND_MAN <>", value, "sendMan");
            return (Criteria) this;
        }

        public Criteria andSendManGreaterThan(String value) {
            addCriterion("SEND_MAN >", value, "sendMan");
            return (Criteria) this;
        }

        public Criteria andSendManGreaterThanOrEqualTo(String value) {
            addCriterion("SEND_MAN >=", value, "sendMan");
            return (Criteria) this;
        }

        public Criteria andSendManLessThan(String value) {
            addCriterion("SEND_MAN <", value, "sendMan");
            return (Criteria) this;
        }

        public Criteria andSendManLessThanOrEqualTo(String value) {
            addCriterion("SEND_MAN <=", value, "sendMan");
            return (Criteria) this;
        }

        public Criteria andSendManLike(String value) {
            addCriterion("SEND_MAN like", value, "sendMan");
            return (Criteria) this;
        }

        public Criteria andSendManNotLike(String value) {
            addCriterion("SEND_MAN not like", value, "sendMan");
            return (Criteria) this;
        }

        public Criteria andSendManIn(List<String> values) {
            addCriterion("SEND_MAN in", values, "sendMan");
            return (Criteria) this;
        }

        public Criteria andSendManNotIn(List<String> values) {
            addCriterion("SEND_MAN not in", values, "sendMan");
            return (Criteria) this;
        }

        public Criteria andSendManBetween(String value1, String value2) {
            addCriterion("SEND_MAN between", value1, value2, "sendMan");
            return (Criteria) this;
        }

        public Criteria andSendManNotBetween(String value1, String value2) {
            addCriterion("SEND_MAN not between", value1, value2, "sendMan");
            return (Criteria) this;
        }

        public Criteria andSendPhoneIsNull() {
            addCriterion("SEND_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andSendPhoneIsNotNull() {
            addCriterion("SEND_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andSendPhoneEqualTo(String value) {
            addCriterion("SEND_PHONE =", value, "sendPhone");
            return (Criteria) this;
        }

        public Criteria andSendPhoneNotEqualTo(String value) {
            addCriterion("SEND_PHONE <>", value, "sendPhone");
            return (Criteria) this;
        }

        public Criteria andSendPhoneGreaterThan(String value) {
            addCriterion("SEND_PHONE >", value, "sendPhone");
            return (Criteria) this;
        }

        public Criteria andSendPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("SEND_PHONE >=", value, "sendPhone");
            return (Criteria) this;
        }

        public Criteria andSendPhoneLessThan(String value) {
            addCriterion("SEND_PHONE <", value, "sendPhone");
            return (Criteria) this;
        }

        public Criteria andSendPhoneLessThanOrEqualTo(String value) {
            addCriterion("SEND_PHONE <=", value, "sendPhone");
            return (Criteria) this;
        }

        public Criteria andSendPhoneLike(String value) {
            addCriterion("SEND_PHONE like", value, "sendPhone");
            return (Criteria) this;
        }

        public Criteria andSendPhoneNotLike(String value) {
            addCriterion("SEND_PHONE not like", value, "sendPhone");
            return (Criteria) this;
        }

        public Criteria andSendPhoneIn(List<String> values) {
            addCriterion("SEND_PHONE in", values, "sendPhone");
            return (Criteria) this;
        }

        public Criteria andSendPhoneNotIn(List<String> values) {
            addCriterion("SEND_PHONE not in", values, "sendPhone");
            return (Criteria) this;
        }

        public Criteria andSendPhoneBetween(String value1, String value2) {
            addCriterion("SEND_PHONE between", value1, value2, "sendPhone");
            return (Criteria) this;
        }

        public Criteria andSendPhoneNotBetween(String value1, String value2) {
            addCriterion("SEND_PHONE not between", value1, value2, "sendPhone");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("USER_ID <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("USER_ID >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("USER_ID >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("USER_ID <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("USER_ID <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("USER_ID in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("USER_ID not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("USER_ID between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("USER_ID not between", value1, value2, "userId");
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