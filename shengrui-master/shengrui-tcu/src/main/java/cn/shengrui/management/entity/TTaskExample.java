package cn.shengrui.management.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TTaskExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TTaskExample() {
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

        public Criteria andProjectIdIsNull() {
            addCriterion("project_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNotNull() {
            addCriterion("project_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIdEqualTo(Integer value) {
            addCriterion("project_id =", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotEqualTo(Integer value) {
            addCriterion("project_id <>", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThan(Integer value) {
            addCriterion("project_id >", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("project_id >=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThan(Integer value) {
            addCriterion("project_id <", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThanOrEqualTo(Integer value) {
            addCriterion("project_id <=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIn(List<Integer> values) {
            addCriterion("project_id in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotIn(List<Integer> values) {
            addCriterion("project_id not in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdBetween(Integer value1, Integer value2) {
            addCriterion("project_id between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotBetween(Integer value1, Integer value2) {
            addCriterion("project_id not between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProducedTimeIsNull() {
            addCriterion("produced_time is null");
            return (Criteria) this;
        }

        public Criteria andProducedTimeIsNotNull() {
            addCriterion("produced_time is not null");
            return (Criteria) this;
        }

        public Criteria andProducedTimeEqualTo(Date value) {
            addCriterion("produced_time =", value, "producedTime");
            return (Criteria) this;
        }

        public Criteria andProducedTimeNotEqualTo(Date value) {
            addCriterion("produced_time <>", value, "producedTime");
            return (Criteria) this;
        }

        public Criteria andProducedTimeGreaterThan(Date value) {
            addCriterion("produced_time >", value, "producedTime");
            return (Criteria) this;
        }

        public Criteria andProducedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("produced_time >=", value, "producedTime");
            return (Criteria) this;
        }

        public Criteria andProducedTimeLessThan(Date value) {
            addCriterion("produced_time <", value, "producedTime");
            return (Criteria) this;
        }

        public Criteria andProducedTimeLessThanOrEqualTo(Date value) {
            addCriterion("produced_time <=", value, "producedTime");
            return (Criteria) this;
        }

        public Criteria andProducedTimeIn(List<Date> values) {
            addCriterion("produced_time in", values, "producedTime");
            return (Criteria) this;
        }

        public Criteria andProducedTimeNotIn(List<Date> values) {
            addCriterion("produced_time not in", values, "producedTime");
            return (Criteria) this;
        }

        public Criteria andProducedTimeBetween(Date value1, Date value2) {
            addCriterion("produced_time between", value1, value2, "producedTime");
            return (Criteria) this;
        }

        public Criteria andProducedTimeNotBetween(Date value1, Date value2) {
            addCriterion("produced_time not between", value1, value2, "producedTime");
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

        public Criteria andBatchNoEqualTo(String value) {
            addCriterion("batch_no =", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotEqualTo(String value) {
            addCriterion("batch_no <>", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoGreaterThan(String value) {
            addCriterion("batch_no >", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoGreaterThanOrEqualTo(String value) {
            addCriterion("batch_no >=", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLessThan(String value) {
            addCriterion("batch_no <", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLessThanOrEqualTo(String value) {
            addCriterion("batch_no <=", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLike(String value) {
            addCriterion("batch_no like", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotLike(String value) {
            addCriterion("batch_no not like", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoIn(List<String> values) {
            addCriterion("batch_no in", values, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotIn(List<String> values) {
            addCriterion("batch_no not in", values, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoBetween(String value1, String value2) {
            addCriterion("batch_no between", value1, value2, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotBetween(String value1, String value2) {
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

        public Criteria andFinishNumberIsNull() {
            addCriterion("finish_number is null");
            return (Criteria) this;
        }

        public Criteria andFinishNumberIsNotNull() {
            addCriterion("finish_number is not null");
            return (Criteria) this;
        }

        public Criteria andFinishNumberEqualTo(Integer value) {
            addCriterion("finish_number =", value, "finishNumber");
            return (Criteria) this;
        }

        public Criteria andFinishNumberNotEqualTo(Integer value) {
            addCriterion("finish_number <>", value, "finishNumber");
            return (Criteria) this;
        }

        public Criteria andFinishNumberGreaterThan(Integer value) {
            addCriterion("finish_number >", value, "finishNumber");
            return (Criteria) this;
        }

        public Criteria andFinishNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("finish_number >=", value, "finishNumber");
            return (Criteria) this;
        }

        public Criteria andFinishNumberLessThan(Integer value) {
            addCriterion("finish_number <", value, "finishNumber");
            return (Criteria) this;
        }

        public Criteria andFinishNumberLessThanOrEqualTo(Integer value) {
            addCriterion("finish_number <=", value, "finishNumber");
            return (Criteria) this;
        }

        public Criteria andFinishNumberIn(List<Integer> values) {
            addCriterion("finish_number in", values, "finishNumber");
            return (Criteria) this;
        }

        public Criteria andFinishNumberNotIn(List<Integer> values) {
            addCriterion("finish_number not in", values, "finishNumber");
            return (Criteria) this;
        }

        public Criteria andFinishNumberBetween(Integer value1, Integer value2) {
            addCriterion("finish_number between", value1, value2, "finishNumber");
            return (Criteria) this;
        }

        public Criteria andFinishNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("finish_number not between", value1, value2, "finishNumber");
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

        public Criteria andCateateTimeIsNull() {
            addCriterion("cateate_time is null");
            return (Criteria) this;
        }

        public Criteria andCateateTimeIsNotNull() {
            addCriterion("cateate_time is not null");
            return (Criteria) this;
        }

        public Criteria andCateateTimeEqualTo(Date value) {
            addCriterion("cateate_time =", value, "cateateTime");
            return (Criteria) this;
        }

        public Criteria andCateateTimeNotEqualTo(Date value) {
            addCriterion("cateate_time <>", value, "cateateTime");
            return (Criteria) this;
        }

        public Criteria andCateateTimeGreaterThan(Date value) {
            addCriterion("cateate_time >", value, "cateateTime");
            return (Criteria) this;
        }

        public Criteria andCateateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("cateate_time >=", value, "cateateTime");
            return (Criteria) this;
        }

        public Criteria andCateateTimeLessThan(Date value) {
            addCriterion("cateate_time <", value, "cateateTime");
            return (Criteria) this;
        }

        public Criteria andCateateTimeLessThanOrEqualTo(Date value) {
            addCriterion("cateate_time <=", value, "cateateTime");
            return (Criteria) this;
        }

        public Criteria andCateateTimeIn(List<Date> values) {
            addCriterion("cateate_time in", values, "cateateTime");
            return (Criteria) this;
        }

        public Criteria andCateateTimeNotIn(List<Date> values) {
            addCriterion("cateate_time not in", values, "cateateTime");
            return (Criteria) this;
        }

        public Criteria andCateateTimeBetween(Date value1, Date value2) {
            addCriterion("cateate_time between", value1, value2, "cateateTime");
            return (Criteria) this;
        }

        public Criteria andCateateTimeNotBetween(Date value1, Date value2) {
            addCriterion("cateate_time not between", value1, value2, "cateateTime");
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

        public Criteria andOperateIpIsNull() {
            addCriterion("operate_ip is null");
            return (Criteria) this;
        }

        public Criteria andOperateIpIsNotNull() {
            addCriterion("operate_ip is not null");
            return (Criteria) this;
        }

        public Criteria andOperateIpEqualTo(String value) {
            addCriterion("operate_ip =", value, "operateIp");
            return (Criteria) this;
        }

        public Criteria andOperateIpNotEqualTo(String value) {
            addCriterion("operate_ip <>", value, "operateIp");
            return (Criteria) this;
        }

        public Criteria andOperateIpGreaterThan(String value) {
            addCriterion("operate_ip >", value, "operateIp");
            return (Criteria) this;
        }

        public Criteria andOperateIpGreaterThanOrEqualTo(String value) {
            addCriterion("operate_ip >=", value, "operateIp");
            return (Criteria) this;
        }

        public Criteria andOperateIpLessThan(String value) {
            addCriterion("operate_ip <", value, "operateIp");
            return (Criteria) this;
        }

        public Criteria andOperateIpLessThanOrEqualTo(String value) {
            addCriterion("operate_ip <=", value, "operateIp");
            return (Criteria) this;
        }

        public Criteria andOperateIpLike(String value) {
            addCriterion("operate_ip like", value, "operateIp");
            return (Criteria) this;
        }

        public Criteria andOperateIpNotLike(String value) {
            addCriterion("operate_ip not like", value, "operateIp");
            return (Criteria) this;
        }

        public Criteria andOperateIpIn(List<String> values) {
            addCriterion("operate_ip in", values, "operateIp");
            return (Criteria) this;
        }

        public Criteria andOperateIpNotIn(List<String> values) {
            addCriterion("operate_ip not in", values, "operateIp");
            return (Criteria) this;
        }

        public Criteria andOperateIpBetween(String value1, String value2) {
            addCriterion("operate_ip between", value1, value2, "operateIp");
            return (Criteria) this;
        }

        public Criteria andOperateIpNotBetween(String value1, String value2) {
            addCriterion("operate_ip not between", value1, value2, "operateIp");
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andShengruiscripturlIsNull() {
            addCriterion("shengruiScriptUrl is null");
            return (Criteria) this;
        }

        public Criteria andShengruiscripturlIsNotNull() {
            addCriterion("shengruiScriptUrl is not null");
            return (Criteria) this;
        }

        public Criteria andShengruiscripturlEqualTo(String value) {
            addCriterion("shengruiScriptUrl =", value, "shengruiscripturl");
            return (Criteria) this;
        }

        public Criteria andShengruiscripturlNotEqualTo(String value) {
            addCriterion("shengruiScriptUrl <>", value, "shengruiscripturl");
            return (Criteria) this;
        }

        public Criteria andShengruiscripturlGreaterThan(String value) {
            addCriterion("shengruiScriptUrl >", value, "shengruiscripturl");
            return (Criteria) this;
        }

        public Criteria andShengruiscripturlGreaterThanOrEqualTo(String value) {
            addCriterion("shengruiScriptUrl >=", value, "shengruiscripturl");
            return (Criteria) this;
        }

        public Criteria andShengruiscripturlLessThan(String value) {
            addCriterion("shengruiScriptUrl <", value, "shengruiscripturl");
            return (Criteria) this;
        }

        public Criteria andShengruiscripturlLessThanOrEqualTo(String value) {
            addCriterion("shengruiScriptUrl <=", value, "shengruiscripturl");
            return (Criteria) this;
        }

        public Criteria andShengruiscripturlLike(String value) {
            addCriterion("shengruiScriptUrl like", value, "shengruiscripturl");
            return (Criteria) this;
        }

        public Criteria andShengruiscripturlNotLike(String value) {
            addCriterion("shengruiScriptUrl not like", value, "shengruiscripturl");
            return (Criteria) this;
        }

        public Criteria andShengruiscripturlIn(List<String> values) {
            addCriterion("shengruiScriptUrl in", values, "shengruiscripturl");
            return (Criteria) this;
        }

        public Criteria andShengruiscripturlNotIn(List<String> values) {
            addCriterion("shengruiScriptUrl not in", values, "shengruiscripturl");
            return (Criteria) this;
        }

        public Criteria andShengruiscripturlBetween(String value1, String value2) {
            addCriterion("shengruiScriptUrl between", value1, value2, "shengruiscripturl");
            return (Criteria) this;
        }

        public Criteria andShengruiscripturlNotBetween(String value1, String value2) {
            addCriterion("shengruiScriptUrl not between", value1, value2, "shengruiscripturl");
            return (Criteria) this;
        }

        public Criteria andProviderscripturlIsNull() {
            addCriterion("providerScriptUrl is null");
            return (Criteria) this;
        }

        public Criteria andProviderscripturlIsNotNull() {
            addCriterion("providerScriptUrl is not null");
            return (Criteria) this;
        }

        public Criteria andProviderscripturlEqualTo(String value) {
            addCriterion("providerScriptUrl =", value, "providerscripturl");
            return (Criteria) this;
        }

        public Criteria andProviderscripturlNotEqualTo(String value) {
            addCriterion("providerScriptUrl <>", value, "providerscripturl");
            return (Criteria) this;
        }

        public Criteria andProviderscripturlGreaterThan(String value) {
            addCriterion("providerScriptUrl >", value, "providerscripturl");
            return (Criteria) this;
        }

        public Criteria andProviderscripturlGreaterThanOrEqualTo(String value) {
            addCriterion("providerScriptUrl >=", value, "providerscripturl");
            return (Criteria) this;
        }

        public Criteria andProviderscripturlLessThan(String value) {
            addCriterion("providerScriptUrl <", value, "providerscripturl");
            return (Criteria) this;
        }

        public Criteria andProviderscripturlLessThanOrEqualTo(String value) {
            addCriterion("providerScriptUrl <=", value, "providerscripturl");
            return (Criteria) this;
        }

        public Criteria andProviderscripturlLike(String value) {
            addCriterion("providerScriptUrl like", value, "providerscripturl");
            return (Criteria) this;
        }

        public Criteria andProviderscripturlNotLike(String value) {
            addCriterion("providerScriptUrl not like", value, "providerscripturl");
            return (Criteria) this;
        }

        public Criteria andProviderscripturlIn(List<String> values) {
            addCriterion("providerScriptUrl in", values, "providerscripturl");
            return (Criteria) this;
        }

        public Criteria andProviderscripturlNotIn(List<String> values) {
            addCriterion("providerScriptUrl not in", values, "providerscripturl");
            return (Criteria) this;
        }

        public Criteria andProviderscripturlBetween(String value1, String value2) {
            addCriterion("providerScriptUrl between", value1, value2, "providerscripturl");
            return (Criteria) this;
        }

        public Criteria andProviderscripturlNotBetween(String value1, String value2) {
            addCriterion("providerScriptUrl not between", value1, value2, "providerscripturl");
            return (Criteria) this;
        }

        public Criteria andLabelcountIsNull() {
            addCriterion("labelCount is null");
            return (Criteria) this;
        }

        public Criteria andLabelcountIsNotNull() {
            addCriterion("labelCount is not null");
            return (Criteria) this;
        }

        public Criteria andLabelcountEqualTo(Integer value) {
            addCriterion("labelCount =", value, "labelcount");
            return (Criteria) this;
        }

        public Criteria andLabelcountNotEqualTo(Integer value) {
            addCriterion("labelCount <>", value, "labelcount");
            return (Criteria) this;
        }

        public Criteria andLabelcountGreaterThan(Integer value) {
            addCriterion("labelCount >", value, "labelcount");
            return (Criteria) this;
        }

        public Criteria andLabelcountGreaterThanOrEqualTo(Integer value) {
            addCriterion("labelCount >=", value, "labelcount");
            return (Criteria) this;
        }

        public Criteria andLabelcountLessThan(Integer value) {
            addCriterion("labelCount <", value, "labelcount");
            return (Criteria) this;
        }

        public Criteria andLabelcountLessThanOrEqualTo(Integer value) {
            addCriterion("labelCount <=", value, "labelcount");
            return (Criteria) this;
        }

        public Criteria andLabelcountIn(List<Integer> values) {
            addCriterion("labelCount in", values, "labelcount");
            return (Criteria) this;
        }

        public Criteria andLabelcountNotIn(List<Integer> values) {
            addCriterion("labelCount not in", values, "labelcount");
            return (Criteria) this;
        }

        public Criteria andLabelcountBetween(Integer value1, Integer value2) {
            addCriterion("labelCount between", value1, value2, "labelcount");
            return (Criteria) this;
        }

        public Criteria andLabelcountNotBetween(Integer value1, Integer value2) {
            addCriterion("labelCount not between", value1, value2, "labelcount");
            return (Criteria) this;
        }

        public Criteria andWritelogisticsnoIsNull() {
            addCriterion("writeLogisticsNo is null");
            return (Criteria) this;
        }

        public Criteria andWritelogisticsnoIsNotNull() {
            addCriterion("writeLogisticsNo is not null");
            return (Criteria) this;
        }

        public Criteria andWritelogisticsnoEqualTo(String value) {
            addCriterion("writeLogisticsNo =", value, "writelogisticsno");
            return (Criteria) this;
        }

        public Criteria andWritelogisticsnoNotEqualTo(String value) {
            addCriterion("writeLogisticsNo <>", value, "writelogisticsno");
            return (Criteria) this;
        }

        public Criteria andWritelogisticsnoGreaterThan(String value) {
            addCriterion("writeLogisticsNo >", value, "writelogisticsno");
            return (Criteria) this;
        }

        public Criteria andWritelogisticsnoGreaterThanOrEqualTo(String value) {
            addCriterion("writeLogisticsNo >=", value, "writelogisticsno");
            return (Criteria) this;
        }

        public Criteria andWritelogisticsnoLessThan(String value) {
            addCriterion("writeLogisticsNo <", value, "writelogisticsno");
            return (Criteria) this;
        }

        public Criteria andWritelogisticsnoLessThanOrEqualTo(String value) {
            addCriterion("writeLogisticsNo <=", value, "writelogisticsno");
            return (Criteria) this;
        }

        public Criteria andWritelogisticsnoLike(String value) {
            addCriterion("writeLogisticsNo like", value, "writelogisticsno");
            return (Criteria) this;
        }

        public Criteria andWritelogisticsnoNotLike(String value) {
            addCriterion("writeLogisticsNo not like", value, "writelogisticsno");
            return (Criteria) this;
        }

        public Criteria andWritelogisticsnoIn(List<String> values) {
            addCriterion("writeLogisticsNo in", values, "writelogisticsno");
            return (Criteria) this;
        }

        public Criteria andWritelogisticsnoNotIn(List<String> values) {
            addCriterion("writeLogisticsNo not in", values, "writelogisticsno");
            return (Criteria) this;
        }

        public Criteria andWritelogisticsnoBetween(String value1, String value2) {
            addCriterion("writeLogisticsNo between", value1, value2, "writelogisticsno");
            return (Criteria) this;
        }

        public Criteria andWritelogisticsnoNotBetween(String value1, String value2) {
            addCriterion("writeLogisticsNo not between", value1, value2, "writelogisticsno");
            return (Criteria) this;
        }

        public Criteria andLabellogisticsnoIsNull() {
            addCriterion("labelLogisticsNo is null");
            return (Criteria) this;
        }

        public Criteria andLabellogisticsnoIsNotNull() {
            addCriterion("labelLogisticsNo is not null");
            return (Criteria) this;
        }

        public Criteria andLabellogisticsnoEqualTo(String value) {
            addCriterion("labelLogisticsNo =", value, "labellogisticsno");
            return (Criteria) this;
        }

        public Criteria andLabellogisticsnoNotEqualTo(String value) {
            addCriterion("labelLogisticsNo <>", value, "labellogisticsno");
            return (Criteria) this;
        }

        public Criteria andLabellogisticsnoGreaterThan(String value) {
            addCriterion("labelLogisticsNo >", value, "labellogisticsno");
            return (Criteria) this;
        }

        public Criteria andLabellogisticsnoGreaterThanOrEqualTo(String value) {
            addCriterion("labelLogisticsNo >=", value, "labellogisticsno");
            return (Criteria) this;
        }

        public Criteria andLabellogisticsnoLessThan(String value) {
            addCriterion("labelLogisticsNo <", value, "labellogisticsno");
            return (Criteria) this;
        }

        public Criteria andLabellogisticsnoLessThanOrEqualTo(String value) {
            addCriterion("labelLogisticsNo <=", value, "labellogisticsno");
            return (Criteria) this;
        }

        public Criteria andLabellogisticsnoLike(String value) {
            addCriterion("labelLogisticsNo like", value, "labellogisticsno");
            return (Criteria) this;
        }

        public Criteria andLabellogisticsnoNotLike(String value) {
            addCriterion("labelLogisticsNo not like", value, "labellogisticsno");
            return (Criteria) this;
        }

        public Criteria andLabellogisticsnoIn(List<String> values) {
            addCriterion("labelLogisticsNo in", values, "labellogisticsno");
            return (Criteria) this;
        }

        public Criteria andLabellogisticsnoNotIn(List<String> values) {
            addCriterion("labelLogisticsNo not in", values, "labellogisticsno");
            return (Criteria) this;
        }

        public Criteria andLabellogisticsnoBetween(String value1, String value2) {
            addCriterion("labelLogisticsNo between", value1, value2, "labellogisticsno");
            return (Criteria) this;
        }

        public Criteria andLabellogisticsnoNotBetween(String value1, String value2) {
            addCriterion("labelLogisticsNo not between", value1, value2, "labellogisticsno");
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