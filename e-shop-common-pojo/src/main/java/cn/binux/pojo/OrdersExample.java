package cn.binux.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrdersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrdersExample() {
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

        public Criteria andOrderIdIsNull() {
            addCriterion("ORDER_ID is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("ORDER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Integer value) {
            addCriterion("ORDER_ID =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Integer value) {
            addCriterion("ORDER_ID <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Integer value) {
            addCriterion("ORDER_ID >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ORDER_ID >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Integer value) {
            addCriterion("ORDER_ID <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("ORDER_ID <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Integer> values) {
            addCriterion("ORDER_ID in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Integer> values) {
            addCriterion("ORDER_ID not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("ORDER_ID between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ORDER_ID not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderNumIsNull() {
            addCriterion("ORDER_NUM is null");
            return (Criteria) this;
        }

        public Criteria andOrderNumIsNotNull() {
            addCriterion("ORDER_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNumEqualTo(String value) {
            addCriterion("ORDER_NUM =", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotEqualTo(String value) {
            addCriterion("ORDER_NUM <>", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumGreaterThan(String value) {
            addCriterion("ORDER_NUM >", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumGreaterThanOrEqualTo(String value) {
            addCriterion("ORDER_NUM >=", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumLessThan(String value) {
            addCriterion("ORDER_NUM <", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumLessThanOrEqualTo(String value) {
            addCriterion("ORDER_NUM <=", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumLike(String value) {
            addCriterion("ORDER_NUM like", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotLike(String value) {
            addCriterion("ORDER_NUM not like", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumIn(List<String> values) {
            addCriterion("ORDER_NUM in", values, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotIn(List<String> values) {
            addCriterion("ORDER_NUM not in", values, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumBetween(String value1, String value2) {
            addCriterion("ORDER_NUM between", value1, value2, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotBetween(String value1, String value2) {
            addCriterion("ORDER_NUM not between", value1, value2, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIsNull() {
            addCriterion("ORDER_TIME is null");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIsNotNull() {
            addCriterion("ORDER_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTimeEqualTo(Date value) {
            addCriterion("ORDER_TIME =", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotEqualTo(Date value) {
            addCriterion("ORDER_TIME <>", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeGreaterThan(Date value) {
            addCriterion("ORDER_TIME >", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ORDER_TIME >=", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeLessThan(Date value) {
            addCriterion("ORDER_TIME <", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeLessThanOrEqualTo(Date value) {
            addCriterion("ORDER_TIME <=", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIn(List<Date> values) {
            addCriterion("ORDER_TIME in", values, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotIn(List<Date> values) {
            addCriterion("ORDER_TIME not in", values, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeBetween(Date value1, Date value2) {
            addCriterion("ORDER_TIME between", value1, value2, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotBetween(Date value1, Date value2) {
            addCriterion("ORDER_TIME not between", value1, value2, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNull() {
            addCriterion("ORDER_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNotNull() {
            addCriterion("ORDER_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusEqualTo(Integer value) {
            addCriterion("ORDER_STATUS =", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotEqualTo(Integer value) {
            addCriterion("ORDER_STATUS <>", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThan(Integer value) {
            addCriterion("ORDER_STATUS >", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("ORDER_STATUS >=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThan(Integer value) {
            addCriterion("ORDER_STATUS <", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThanOrEqualTo(Integer value) {
            addCriterion("ORDER_STATUS <=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIn(List<Integer> values) {
            addCriterion("ORDER_STATUS in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotIn(List<Integer> values) {
            addCriterion("ORDER_STATUS not in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusBetween(Integer value1, Integer value2) {
            addCriterion("ORDER_STATUS between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("ORDER_STATUS not between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andNoteIsNull() {
            addCriterion("NOTE is null");
            return (Criteria) this;
        }

        public Criteria andNoteIsNotNull() {
            addCriterion("NOTE is not null");
            return (Criteria) this;
        }

        public Criteria andNoteEqualTo(String value) {
            addCriterion("NOTE =", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotEqualTo(String value) {
            addCriterion("NOTE <>", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThan(String value) {
            addCriterion("NOTE >", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThanOrEqualTo(String value) {
            addCriterion("NOTE >=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThan(String value) {
            addCriterion("NOTE <", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThanOrEqualTo(String value) {
            addCriterion("NOTE <=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLike(String value) {
            addCriterion("NOTE like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotLike(String value) {
            addCriterion("NOTE not like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteIn(List<String> values) {
            addCriterion("NOTE in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotIn(List<String> values) {
            addCriterion("NOTE not in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteBetween(String value1, String value2) {
            addCriterion("NOTE between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotBetween(String value1, String value2) {
            addCriterion("NOTE not between", value1, value2, "note");
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

        public Criteria andProductIdIsNull() {
            addCriterion("PRODUCT_ID is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("PRODUCT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(Integer value) {
            addCriterion("PRODUCT_ID =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(Integer value) {
            addCriterion("PRODUCT_ID <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(Integer value) {
            addCriterion("PRODUCT_ID >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("PRODUCT_ID >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(Integer value) {
            addCriterion("PRODUCT_ID <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(Integer value) {
            addCriterion("PRODUCT_ID <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<Integer> values) {
            addCriterion("PRODUCT_ID in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<Integer> values) {
            addCriterion("PRODUCT_ID not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(Integer value1, Integer value2) {
            addCriterion("PRODUCT_ID between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(Integer value1, Integer value2) {
            addCriterion("PRODUCT_ID not between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNull() {
            addCriterion("PRODUCT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNotNull() {
            addCriterion("PRODUCT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andProductNameEqualTo(String value) {
            addCriterion("PRODUCT_NAME =", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotEqualTo(String value) {
            addCriterion("PRODUCT_NAME <>", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThan(String value) {
            addCriterion("PRODUCT_NAME >", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThanOrEqualTo(String value) {
            addCriterion("PRODUCT_NAME >=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThan(String value) {
            addCriterion("PRODUCT_NAME <", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThanOrEqualTo(String value) {
            addCriterion("PRODUCT_NAME <=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLike(String value) {
            addCriterion("PRODUCT_NAME like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotLike(String value) {
            addCriterion("PRODUCT_NAME not like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameIn(List<String> values) {
            addCriterion("PRODUCT_NAME in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotIn(List<String> values) {
            addCriterion("PRODUCT_NAME not in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameBetween(String value1, String value2) {
            addCriterion("PRODUCT_NAME between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotBetween(String value1, String value2) {
            addCriterion("PRODUCT_NAME not between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductPriceIsNull() {
            addCriterion("PRODUCT_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andProductPriceIsNotNull() {
            addCriterion("PRODUCT_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andProductPriceEqualTo(Double value) {
            addCriterion("PRODUCT_PRICE =", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceNotEqualTo(Double value) {
            addCriterion("PRODUCT_PRICE <>", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceGreaterThan(Double value) {
            addCriterion("PRODUCT_PRICE >", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("PRODUCT_PRICE >=", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceLessThan(Double value) {
            addCriterion("PRODUCT_PRICE <", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceLessThanOrEqualTo(Double value) {
            addCriterion("PRODUCT_PRICE <=", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceIn(List<Double> values) {
            addCriterion("PRODUCT_PRICE in", values, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceNotIn(List<Double> values) {
            addCriterion("PRODUCT_PRICE not in", values, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceBetween(Double value1, Double value2) {
            addCriterion("PRODUCT_PRICE between", value1, value2, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceNotBetween(Double value1, Double value2) {
            addCriterion("PRODUCT_PRICE not between", value1, value2, "productPrice");
            return (Criteria) this;
        }

        public Criteria andSaleCountIsNull() {
            addCriterion("SALE_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andSaleCountIsNotNull() {
            addCriterion("SALE_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andSaleCountEqualTo(Integer value) {
            addCriterion("SALE_COUNT =", value, "saleCount");
            return (Criteria) this;
        }

        public Criteria andSaleCountNotEqualTo(Integer value) {
            addCriterion("SALE_COUNT <>", value, "saleCount");
            return (Criteria) this;
        }

        public Criteria andSaleCountGreaterThan(Integer value) {
            addCriterion("SALE_COUNT >", value, "saleCount");
            return (Criteria) this;
        }

        public Criteria andSaleCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("SALE_COUNT >=", value, "saleCount");
            return (Criteria) this;
        }

        public Criteria andSaleCountLessThan(Integer value) {
            addCriterion("SALE_COUNT <", value, "saleCount");
            return (Criteria) this;
        }

        public Criteria andSaleCountLessThanOrEqualTo(Integer value) {
            addCriterion("SALE_COUNT <=", value, "saleCount");
            return (Criteria) this;
        }

        public Criteria andSaleCountIn(List<Integer> values) {
            addCriterion("SALE_COUNT in", values, "saleCount");
            return (Criteria) this;
        }

        public Criteria andSaleCountNotIn(List<Integer> values) {
            addCriterion("SALE_COUNT not in", values, "saleCount");
            return (Criteria) this;
        }

        public Criteria andSaleCountBetween(Integer value1, Integer value2) {
            addCriterion("SALE_COUNT between", value1, value2, "saleCount");
            return (Criteria) this;
        }

        public Criteria andSaleCountNotBetween(Integer value1, Integer value2) {
            addCriterion("SALE_COUNT not between", value1, value2, "saleCount");
            return (Criteria) this;
        }

        public Criteria andVisibleIsNull() {
            addCriterion("VISIBLE is null");
            return (Criteria) this;
        }

        public Criteria andVisibleIsNotNull() {
            addCriterion("VISIBLE is not null");
            return (Criteria) this;
        }

        public Criteria andVisibleEqualTo(Integer value) {
            addCriterion("VISIBLE =", value, "visible");
            return (Criteria) this;
        }

        public Criteria andVisibleNotEqualTo(Integer value) {
            addCriterion("VISIBLE <>", value, "visible");
            return (Criteria) this;
        }

        public Criteria andVisibleGreaterThan(Integer value) {
            addCriterion("VISIBLE >", value, "visible");
            return (Criteria) this;
        }

        public Criteria andVisibleGreaterThanOrEqualTo(Integer value) {
            addCriterion("VISIBLE >=", value, "visible");
            return (Criteria) this;
        }

        public Criteria andVisibleLessThan(Integer value) {
            addCriterion("VISIBLE <", value, "visible");
            return (Criteria) this;
        }

        public Criteria andVisibleLessThanOrEqualTo(Integer value) {
            addCriterion("VISIBLE <=", value, "visible");
            return (Criteria) this;
        }

        public Criteria andVisibleIn(List<Integer> values) {
            addCriterion("VISIBLE in", values, "visible");
            return (Criteria) this;
        }

        public Criteria andVisibleNotIn(List<Integer> values) {
            addCriterion("VISIBLE not in", values, "visible");
            return (Criteria) this;
        }

        public Criteria andVisibleBetween(Integer value1, Integer value2) {
            addCriterion("VISIBLE between", value1, value2, "visible");
            return (Criteria) this;
        }

        public Criteria andVisibleNotBetween(Integer value1, Integer value2) {
            addCriterion("VISIBLE not between", value1, value2, "visible");
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