package cn.shengrui.management.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TaskLogExample() {
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

        public Criteria andOperateTimeIsNull() {
            addCriterion("operate_time is null");
            return (Criteria) this;
        }

        public Criteria andOperateTimeIsNotNull() {
            addCriterion("operate_time is not null");
            return (Criteria) this;
        }

        public Criteria andOperateTimeEqualTo(Date value) {
            addCriterion("operate_time =", value, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeNotEqualTo(Date value) {
            addCriterion("operate_time <>", value, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeGreaterThan(Date value) {
            addCriterion("operate_time >", value, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("operate_time >=", value, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeLessThan(Date value) {
            addCriterion("operate_time <", value, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeLessThanOrEqualTo(Date value) {
            addCriterion("operate_time <=", value, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeIn(List<Date> values) {
            addCriterion("operate_time in", values, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeNotIn(List<Date> values) {
            addCriterion("operate_time not in", values, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeBetween(Date value1, Date value2) {
            addCriterion("operate_time between", value1, value2, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeNotBetween(Date value1, Date value2) {
            addCriterion("operate_time not between", value1, value2, "operateTime");
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

        public Criteria andProjectNameIsNull() {
            addCriterion("project_name is null");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNotNull() {
            addCriterion("project_name is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNameEqualTo(String value) {
            addCriterion("project_name =", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotEqualTo(String value) {
            addCriterion("project_name <>", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThan(String value) {
            addCriterion("project_name >", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("project_name >=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThan(String value) {
            addCriterion("project_name <", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThanOrEqualTo(String value) {
            addCriterion("project_name <=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLike(String value) {
            addCriterion("project_name like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotLike(String value) {
            addCriterion("project_name not like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameIn(List<String> values) {
            addCriterion("project_name in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotIn(List<String> values) {
            addCriterion("project_name not in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameBetween(String value1, String value2) {
            addCriterion("project_name between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotBetween(String value1, String value2) {
            addCriterion("project_name not between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andTcuTypeIsNull() {
            addCriterion("tcu_type is null");
            return (Criteria) this;
        }

        public Criteria andTcuTypeIsNotNull() {
            addCriterion("tcu_type is not null");
            return (Criteria) this;
        }

        public Criteria andTcuTypeEqualTo(String value) {
            addCriterion("tcu_type =", value, "tcuType");
            return (Criteria) this;
        }

        public Criteria andTcuTypeNotEqualTo(String value) {
            addCriterion("tcu_type <>", value, "tcuType");
            return (Criteria) this;
        }

        public Criteria andTcuTypeGreaterThan(String value) {
            addCriterion("tcu_type >", value, "tcuType");
            return (Criteria) this;
        }

        public Criteria andTcuTypeGreaterThanOrEqualTo(String value) {
            addCriterion("tcu_type >=", value, "tcuType");
            return (Criteria) this;
        }

        public Criteria andTcuTypeLessThan(String value) {
            addCriterion("tcu_type <", value, "tcuType");
            return (Criteria) this;
        }

        public Criteria andTcuTypeLessThanOrEqualTo(String value) {
            addCriterion("tcu_type <=", value, "tcuType");
            return (Criteria) this;
        }

        public Criteria andTcuTypeLike(String value) {
            addCriterion("tcu_type like", value, "tcuType");
            return (Criteria) this;
        }

        public Criteria andTcuTypeNotLike(String value) {
            addCriterion("tcu_type not like", value, "tcuType");
            return (Criteria) this;
        }

        public Criteria andTcuTypeIn(List<String> values) {
            addCriterion("tcu_type in", values, "tcuType");
            return (Criteria) this;
        }

        public Criteria andTcuTypeNotIn(List<String> values) {
            addCriterion("tcu_type not in", values, "tcuType");
            return (Criteria) this;
        }

        public Criteria andTcuTypeBetween(String value1, String value2) {
            addCriterion("tcu_type between", value1, value2, "tcuType");
            return (Criteria) this;
        }

        public Criteria andTcuTypeNotBetween(String value1, String value2) {
            addCriterion("tcu_type not between", value1, value2, "tcuType");
            return (Criteria) this;
        }

        public Criteria andTaskNameIsNull() {
            addCriterion("task_name is null");
            return (Criteria) this;
        }

        public Criteria andTaskNameIsNotNull() {
            addCriterion("task_name is not null");
            return (Criteria) this;
        }

        public Criteria andTaskNameEqualTo(String value) {
            addCriterion("task_name =", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotEqualTo(String value) {
            addCriterion("task_name <>", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameGreaterThan(String value) {
            addCriterion("task_name >", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameGreaterThanOrEqualTo(String value) {
            addCriterion("task_name >=", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLessThan(String value) {
            addCriterion("task_name <", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLessThanOrEqualTo(String value) {
            addCriterion("task_name <=", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLike(String value) {
            addCriterion("task_name like", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotLike(String value) {
            addCriterion("task_name not like", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameIn(List<String> values) {
            addCriterion("task_name in", values, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotIn(List<String> values) {
            addCriterion("task_name not in", values, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameBetween(String value1, String value2) {
            addCriterion("task_name between", value1, value2, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotBetween(String value1, String value2) {
            addCriterion("task_name not between", value1, value2, "taskName");
            return (Criteria) this;
        }

        public Criteria andResultIsNull() {
            addCriterion("result is null");
            return (Criteria) this;
        }

        public Criteria andResultIsNotNull() {
            addCriterion("result is not null");
            return (Criteria) this;
        }

        public Criteria andResultEqualTo(Integer value) {
            addCriterion("result =", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotEqualTo(Integer value) {
            addCriterion("result <>", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThan(Integer value) {
            addCriterion("result >", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThanOrEqualTo(Integer value) {
            addCriterion("result >=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThan(Integer value) {
            addCriterion("result <", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThanOrEqualTo(Integer value) {
            addCriterion("result <=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultIn(List<Integer> values) {
            addCriterion("result in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotIn(List<Integer> values) {
            addCriterion("result not in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultBetween(Integer value1, Integer value2) {
            addCriterion("result between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotBetween(Integer value1, Integer value2) {
            addCriterion("result not between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andSerialNumberIsNull() {
            addCriterion("serial_number is null");
            return (Criteria) this;
        }

        public Criteria andSerialNumberIsNotNull() {
            addCriterion("serial_number is not null");
            return (Criteria) this;
        }

        public Criteria andSerialNumberEqualTo(String value) {
            addCriterion("serial_number =", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotEqualTo(String value) {
            addCriterion("serial_number <>", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberGreaterThan(String value) {
            addCriterion("serial_number >", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberGreaterThanOrEqualTo(String value) {
            addCriterion("serial_number >=", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberLessThan(String value) {
            addCriterion("serial_number <", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberLessThanOrEqualTo(String value) {
            addCriterion("serial_number <=", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberLike(String value) {
            addCriterion("serial_number like", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotLike(String value) {
            addCriterion("serial_number not like", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberIn(List<String> values) {
            addCriterion("serial_number in", values, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotIn(List<String> values) {
            addCriterion("serial_number not in", values, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberBetween(String value1, String value2) {
            addCriterion("serial_number between", value1, value2, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotBetween(String value1, String value2) {
            addCriterion("serial_number not between", value1, value2, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andBatchNoIsNull() {
            addCriterion("batch_no is null");
            return (Criteria) this;
        }

        public Criteria andBatchNoIsNotNull() {
            addCriterion("batch_no is not null");
            return (Criteria) this;
        }

        public Criteria andBatchNoEqualTo(Integer value) {
            addCriterion("batch_no =", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotEqualTo(Integer value) {
            addCriterion("batch_no <>", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoGreaterThan(Integer value) {
            addCriterion("batch_no >", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("batch_no >=", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLessThan(Integer value) {
            addCriterion("batch_no <", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLessThanOrEqualTo(Integer value) {
            addCriterion("batch_no <=", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoIn(List<Integer> values) {
            addCriterion("batch_no in", values, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotIn(List<Integer> values) {
            addCriterion("batch_no not in", values, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoBetween(Integer value1, Integer value2) {
            addCriterion("batch_no between", value1, value2, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotBetween(Integer value1, Integer value2) {
            addCriterion("batch_no not between", value1, value2, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNumberIsNull() {
            addCriterion("batch_number is null");
            return (Criteria) this;
        }

        public Criteria andBatchNumberIsNotNull() {
            addCriterion("batch_number is not null");
            return (Criteria) this;
        }

        public Criteria andBatchNumberEqualTo(Integer value) {
            addCriterion("batch_number =", value, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andBatchNumberNotEqualTo(Integer value) {
            addCriterion("batch_number <>", value, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andBatchNumberGreaterThan(Integer value) {
            addCriterion("batch_number >", value, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andBatchNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("batch_number >=", value, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andBatchNumberLessThan(Integer value) {
            addCriterion("batch_number <", value, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andBatchNumberLessThanOrEqualTo(Integer value) {
            addCriterion("batch_number <=", value, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andBatchNumberIn(List<Integer> values) {
            addCriterion("batch_number in", values, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andBatchNumberNotIn(List<Integer> values) {
            addCriterion("batch_number not in", values, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andBatchNumberBetween(Integer value1, Integer value2) {
            addCriterion("batch_number between", value1, value2, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andBatchNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("batch_number not between", value1, value2, "batchNumber");
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

        public Criteria andTagNumberIsNull() {
            addCriterion("tag_number is null");
            return (Criteria) this;
        }

        public Criteria andTagNumberIsNotNull() {
            addCriterion("tag_number is not null");
            return (Criteria) this;
        }

        public Criteria andTagNumberEqualTo(Integer value) {
            addCriterion("tag_number =", value, "tagNumber");
            return (Criteria) this;
        }

        public Criteria andTagNumberNotEqualTo(Integer value) {
            addCriterion("tag_number <>", value, "tagNumber");
            return (Criteria) this;
        }

        public Criteria andTagNumberGreaterThan(Integer value) {
            addCriterion("tag_number >", value, "tagNumber");
            return (Criteria) this;
        }

        public Criteria andTagNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("tag_number >=", value, "tagNumber");
            return (Criteria) this;
        }

        public Criteria andTagNumberLessThan(Integer value) {
            addCriterion("tag_number <", value, "tagNumber");
            return (Criteria) this;
        }

        public Criteria andTagNumberLessThanOrEqualTo(Integer value) {
            addCriterion("tag_number <=", value, "tagNumber");
            return (Criteria) this;
        }

        public Criteria andTagNumberIn(List<Integer> values) {
            addCriterion("tag_number in", values, "tagNumber");
            return (Criteria) this;
        }

        public Criteria andTagNumberNotIn(List<Integer> values) {
            addCriterion("tag_number not in", values, "tagNumber");
            return (Criteria) this;
        }

        public Criteria andTagNumberBetween(Integer value1, Integer value2) {
            addCriterion("tag_number between", value1, value2, "tagNumber");
            return (Criteria) this;
        }

        public Criteria andTagNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("tag_number not between", value1, value2, "tagNumber");
            return (Criteria) this;
        }

        public Criteria andTagLsNoIsNull() {
            addCriterion("tag_ls_no is null");
            return (Criteria) this;
        }

        public Criteria andTagLsNoIsNotNull() {
            addCriterion("tag_ls_no is not null");
            return (Criteria) this;
        }

        public Criteria andTagLsNoEqualTo(String value) {
            addCriterion("tag_ls_no =", value, "tagLsNo");
            return (Criteria) this;
        }

        public Criteria andTagLsNoNotEqualTo(String value) {
            addCriterion("tag_ls_no <>", value, "tagLsNo");
            return (Criteria) this;
        }

        public Criteria andTagLsNoGreaterThan(String value) {
            addCriterion("tag_ls_no >", value, "tagLsNo");
            return (Criteria) this;
        }

        public Criteria andTagLsNoGreaterThanOrEqualTo(String value) {
            addCriterion("tag_ls_no >=", value, "tagLsNo");
            return (Criteria) this;
        }

        public Criteria andTagLsNoLessThan(String value) {
            addCriterion("tag_ls_no <", value, "tagLsNo");
            return (Criteria) this;
        }

        public Criteria andTagLsNoLessThanOrEqualTo(String value) {
            addCriterion("tag_ls_no <=", value, "tagLsNo");
            return (Criteria) this;
        }

        public Criteria andTagLsNoLike(String value) {
            addCriterion("tag_ls_no like", value, "tagLsNo");
            return (Criteria) this;
        }

        public Criteria andTagLsNoNotLike(String value) {
            addCriterion("tag_ls_no not like", value, "tagLsNo");
            return (Criteria) this;
        }

        public Criteria andTagLsNoIn(List<String> values) {
            addCriterion("tag_ls_no in", values, "tagLsNo");
            return (Criteria) this;
        }

        public Criteria andTagLsNoNotIn(List<String> values) {
            addCriterion("tag_ls_no not in", values, "tagLsNo");
            return (Criteria) this;
        }

        public Criteria andTagLsNoBetween(String value1, String value2) {
            addCriterion("tag_ls_no between", value1, value2, "tagLsNo");
            return (Criteria) this;
        }

        public Criteria andTagLsNoNotBetween(String value1, String value2) {
            addCriterion("tag_ls_no not between", value1, value2, "tagLsNo");
            return (Criteria) this;
        }

        public Criteria andWtLsNoIsNull() {
            addCriterion("wt_ls_no is null");
            return (Criteria) this;
        }

        public Criteria andWtLsNoIsNotNull() {
            addCriterion("wt_ls_no is not null");
            return (Criteria) this;
        }

        public Criteria andWtLsNoEqualTo(String value) {
            addCriterion("wt_ls_no =", value, "wtLsNo");
            return (Criteria) this;
        }

        public Criteria andWtLsNoNotEqualTo(String value) {
            addCriterion("wt_ls_no <>", value, "wtLsNo");
            return (Criteria) this;
        }

        public Criteria andWtLsNoGreaterThan(String value) {
            addCriterion("wt_ls_no >", value, "wtLsNo");
            return (Criteria) this;
        }

        public Criteria andWtLsNoGreaterThanOrEqualTo(String value) {
            addCriterion("wt_ls_no >=", value, "wtLsNo");
            return (Criteria) this;
        }

        public Criteria andWtLsNoLessThan(String value) {
            addCriterion("wt_ls_no <", value, "wtLsNo");
            return (Criteria) this;
        }

        public Criteria andWtLsNoLessThanOrEqualTo(String value) {
            addCriterion("wt_ls_no <=", value, "wtLsNo");
            return (Criteria) this;
        }

        public Criteria andWtLsNoLike(String value) {
            addCriterion("wt_ls_no like", value, "wtLsNo");
            return (Criteria) this;
        }

        public Criteria andWtLsNoNotLike(String value) {
            addCriterion("wt_ls_no not like", value, "wtLsNo");
            return (Criteria) this;
        }

        public Criteria andWtLsNoIn(List<String> values) {
            addCriterion("wt_ls_no in", values, "wtLsNo");
            return (Criteria) this;
        }

        public Criteria andWtLsNoNotIn(List<String> values) {
            addCriterion("wt_ls_no not in", values, "wtLsNo");
            return (Criteria) this;
        }

        public Criteria andWtLsNoBetween(String value1, String value2) {
            addCriterion("wt_ls_no between", value1, value2, "wtLsNo");
            return (Criteria) this;
        }

        public Criteria andWtLsNoNotBetween(String value1, String value2) {
            addCriterion("wt_ls_no not between", value1, value2, "wtLsNo");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNull() {
            addCriterion("task_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNotNull() {
            addCriterion("task_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIdEqualTo(Integer value) {
            addCriterion("task_id =", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotEqualTo(Integer value) {
            addCriterion("task_id <>", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThan(Integer value) {
            addCriterion("task_id >", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_id >=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThan(Integer value) {
            addCriterion("task_id <", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThanOrEqualTo(Integer value) {
            addCriterion("task_id <=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIn(List<Integer> values) {
            addCriterion("task_id in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotIn(List<Integer> values) {
            addCriterion("task_id not in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdBetween(Integer value1, Integer value2) {
            addCriterion("task_id between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotBetween(Integer value1, Integer value2) {
            addCriterion("task_id not between", value1, value2, "taskId");
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