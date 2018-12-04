package cn.shengrui.management.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TTcuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TTcuExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTcuCodeIsNull() {
            addCriterion("tcu_code is null");
            return (Criteria) this;
        }

        public Criteria andTcuCodeIsNotNull() {
            addCriterion("tcu_code is not null");
            return (Criteria) this;
        }

        public Criteria andTcuCodeEqualTo(String value) {
            addCriterion("tcu_code =", value, "tcuCode");
            return (Criteria) this;
        }

        public Criteria andTcuCodeNotEqualTo(String value) {
            addCriterion("tcu_code <>", value, "tcuCode");
            return (Criteria) this;
        }

        public Criteria andTcuCodeGreaterThan(String value) {
            addCriterion("tcu_code >", value, "tcuCode");
            return (Criteria) this;
        }

        public Criteria andTcuCodeGreaterThanOrEqualTo(String value) {
            addCriterion("tcu_code >=", value, "tcuCode");
            return (Criteria) this;
        }

        public Criteria andTcuCodeLessThan(String value) {
            addCriterion("tcu_code <", value, "tcuCode");
            return (Criteria) this;
        }

        public Criteria andTcuCodeLessThanOrEqualTo(String value) {
            addCriterion("tcu_code <=", value, "tcuCode");
            return (Criteria) this;
        }

        public Criteria andTcuCodeLike(String value) {
            addCriterion("tcu_code like", value, "tcuCode");
            return (Criteria) this;
        }

        public Criteria andTcuCodeNotLike(String value) {
            addCriterion("tcu_code not like", value, "tcuCode");
            return (Criteria) this;
        }

        public Criteria andTcuCodeIn(List<String> values) {
            addCriterion("tcu_code in", values, "tcuCode");
            return (Criteria) this;
        }

        public Criteria andTcuCodeNotIn(List<String> values) {
            addCriterion("tcu_code not in", values, "tcuCode");
            return (Criteria) this;
        }

        public Criteria andTcuCodeBetween(String value1, String value2) {
            addCriterion("tcu_code between", value1, value2, "tcuCode");
            return (Criteria) this;
        }

        public Criteria andTcuCodeNotBetween(String value1, String value2) {
            addCriterion("tcu_code not between", value1, value2, "tcuCode");
            return (Criteria) this;
        }

        public Criteria andSupplierIsNull() {
            addCriterion("supplier is null");
            return (Criteria) this;
        }

        public Criteria andSupplierIsNotNull() {
            addCriterion("supplier is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierEqualTo(String value) {
            addCriterion("supplier =", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierNotEqualTo(String value) {
            addCriterion("supplier <>", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierGreaterThan(String value) {
            addCriterion("supplier >", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierGreaterThanOrEqualTo(String value) {
            addCriterion("supplier >=", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierLessThan(String value) {
            addCriterion("supplier <", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierLessThanOrEqualTo(String value) {
            addCriterion("supplier <=", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierLike(String value) {
            addCriterion("supplier like", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierNotLike(String value) {
            addCriterion("supplier not like", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierIn(List<String> values) {
            addCriterion("supplier in", values, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierNotIn(List<String> values) {
            addCriterion("supplier not in", values, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierBetween(String value1, String value2) {
            addCriterion("supplier between", value1, value2, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierNotBetween(String value1, String value2) {
            addCriterion("supplier not between", value1, value2, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupCodeIsNull() {
            addCriterion("sup_code is null");
            return (Criteria) this;
        }

        public Criteria andSupCodeIsNotNull() {
            addCriterion("sup_code is not null");
            return (Criteria) this;
        }

        public Criteria andSupCodeEqualTo(String value) {
            addCriterion("sup_code =", value, "supCode");
            return (Criteria) this;
        }

        public Criteria andSupCodeNotEqualTo(String value) {
            addCriterion("sup_code <>", value, "supCode");
            return (Criteria) this;
        }

        public Criteria andSupCodeGreaterThan(String value) {
            addCriterion("sup_code >", value, "supCode");
            return (Criteria) this;
        }

        public Criteria andSupCodeGreaterThanOrEqualTo(String value) {
            addCriterion("sup_code >=", value, "supCode");
            return (Criteria) this;
        }

        public Criteria andSupCodeLessThan(String value) {
            addCriterion("sup_code <", value, "supCode");
            return (Criteria) this;
        }

        public Criteria andSupCodeLessThanOrEqualTo(String value) {
            addCriterion("sup_code <=", value, "supCode");
            return (Criteria) this;
        }

        public Criteria andSupCodeLike(String value) {
            addCriterion("sup_code like", value, "supCode");
            return (Criteria) this;
        }

        public Criteria andSupCodeNotLike(String value) {
            addCriterion("sup_code not like", value, "supCode");
            return (Criteria) this;
        }

        public Criteria andSupCodeIn(List<String> values) {
            addCriterion("sup_code in", values, "supCode");
            return (Criteria) this;
        }

        public Criteria andSupCodeNotIn(List<String> values) {
            addCriterion("sup_code not in", values, "supCode");
            return (Criteria) this;
        }

        public Criteria andSupCodeBetween(String value1, String value2) {
            addCriterion("sup_code between", value1, value2, "supCode");
            return (Criteria) this;
        }

        public Criteria andSupCodeNotBetween(String value1, String value2) {
            addCriterion("sup_code not between", value1, value2, "supCode");
            return (Criteria) this;
        }

        public Criteria andBootVersionIsNull() {
            addCriterion("boot_version is null");
            return (Criteria) this;
        }

        public Criteria andBootVersionIsNotNull() {
            addCriterion("boot_version is not null");
            return (Criteria) this;
        }

        public Criteria andBootVersionEqualTo(String value) {
            addCriterion("boot_version =", value, "bootVersion");
            return (Criteria) this;
        }

        public Criteria andBootVersionNotEqualTo(String value) {
            addCriterion("boot_version <>", value, "bootVersion");
            return (Criteria) this;
        }

        public Criteria andBootVersionGreaterThan(String value) {
            addCriterion("boot_version >", value, "bootVersion");
            return (Criteria) this;
        }

        public Criteria andBootVersionGreaterThanOrEqualTo(String value) {
            addCriterion("boot_version >=", value, "bootVersion");
            return (Criteria) this;
        }

        public Criteria andBootVersionLessThan(String value) {
            addCriterion("boot_version <", value, "bootVersion");
            return (Criteria) this;
        }

        public Criteria andBootVersionLessThanOrEqualTo(String value) {
            addCriterion("boot_version <=", value, "bootVersion");
            return (Criteria) this;
        }

        public Criteria andBootVersionLike(String value) {
            addCriterion("boot_version like", value, "bootVersion");
            return (Criteria) this;
        }

        public Criteria andBootVersionNotLike(String value) {
            addCriterion("boot_version not like", value, "bootVersion");
            return (Criteria) this;
        }

        public Criteria andBootVersionIn(List<String> values) {
            addCriterion("boot_version in", values, "bootVersion");
            return (Criteria) this;
        }

        public Criteria andBootVersionNotIn(List<String> values) {
            addCriterion("boot_version not in", values, "bootVersion");
            return (Criteria) this;
        }

        public Criteria andBootVersionBetween(String value1, String value2) {
            addCriterion("boot_version between", value1, value2, "bootVersion");
            return (Criteria) this;
        }

        public Criteria andBootVersionNotBetween(String value1, String value2) {
            addCriterion("boot_version not between", value1, value2, "bootVersion");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNull() {
            addCriterion("operator is null");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNotNull() {
            addCriterion("operator is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorEqualTo(String value) {
            addCriterion("operator =", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotEqualTo(String value) {
            addCriterion("operator <>", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThan(String value) {
            addCriterion("operator >", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThanOrEqualTo(String value) {
            addCriterion("operator >=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThan(String value) {
            addCriterion("operator <", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThanOrEqualTo(String value) {
            addCriterion("operator <=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLike(String value) {
            addCriterion("operator like", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotLike(String value) {
            addCriterion("operator not like", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorIn(List<String> values) {
            addCriterion("operator in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotIn(List<String> values) {
            addCriterion("operator not in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorBetween(String value1, String value2) {
            addCriterion("operator between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotBetween(String value1, String value2) {
            addCriterion("operator not between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorIpIsNull() {
            addCriterion("operator_ip is null");
            return (Criteria) this;
        }

        public Criteria andOperatorIpIsNotNull() {
            addCriterion("operator_ip is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorIpEqualTo(String value) {
            addCriterion("operator_ip =", value, "operatorIp");
            return (Criteria) this;
        }

        public Criteria andOperatorIpNotEqualTo(String value) {
            addCriterion("operator_ip <>", value, "operatorIp");
            return (Criteria) this;
        }

        public Criteria andOperatorIpGreaterThan(String value) {
            addCriterion("operator_ip >", value, "operatorIp");
            return (Criteria) this;
        }

        public Criteria andOperatorIpGreaterThanOrEqualTo(String value) {
            addCriterion("operator_ip >=", value, "operatorIp");
            return (Criteria) this;
        }

        public Criteria andOperatorIpLessThan(String value) {
            addCriterion("operator_ip <", value, "operatorIp");
            return (Criteria) this;
        }

        public Criteria andOperatorIpLessThanOrEqualTo(String value) {
            addCriterion("operator_ip <=", value, "operatorIp");
            return (Criteria) this;
        }

        public Criteria andOperatorIpLike(String value) {
            addCriterion("operator_ip like", value, "operatorIp");
            return (Criteria) this;
        }

        public Criteria andOperatorIpNotLike(String value) {
            addCriterion("operator_ip not like", value, "operatorIp");
            return (Criteria) this;
        }

        public Criteria andOperatorIpIn(List<String> values) {
            addCriterion("operator_ip in", values, "operatorIp");
            return (Criteria) this;
        }

        public Criteria andOperatorIpNotIn(List<String> values) {
            addCriterion("operator_ip not in", values, "operatorIp");
            return (Criteria) this;
        }

        public Criteria andOperatorIpBetween(String value1, String value2) {
            addCriterion("operator_ip between", value1, value2, "operatorIp");
            return (Criteria) this;
        }

        public Criteria andOperatorIpNotBetween(String value1, String value2) {
            addCriterion("operator_ip not between", value1, value2, "operatorIp");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andFileIdIsNull() {
            addCriterion("file_id is null");
            return (Criteria) this;
        }

        public Criteria andFileIdIsNotNull() {
            addCriterion("file_id is not null");
            return (Criteria) this;
        }

        public Criteria andFileIdEqualTo(Integer value) {
            addCriterion("file_id =", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdNotEqualTo(Integer value) {
            addCriterion("file_id <>", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdGreaterThan(Integer value) {
            addCriterion("file_id >", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("file_id >=", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdLessThan(Integer value) {
            addCriterion("file_id <", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdLessThanOrEqualTo(Integer value) {
            addCriterion("file_id <=", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdIn(List<Integer> values) {
            addCriterion("file_id in", values, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdNotIn(List<Integer> values) {
            addCriterion("file_id not in", values, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdBetween(Integer value1, Integer value2) {
            addCriterion("file_id between", value1, value2, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdNotBetween(Integer value1, Integer value2) {
            addCriterion("file_id not between", value1, value2, "fileId");
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