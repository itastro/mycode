package cn.shengrui.management.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TTask {

    /**
     * 任务ID
     */
    private Integer id;


    /**
     * 项目id
     */
    private Integer projectId;

    /**
     * 生产时间
     */
    private Date producedTime;


    /**
     * 批次号
     */
    private String batchNo;

    /**
     * 批次数量
     */
    private Integer batchNumber;

    /**
     * 完成数量
     */
    private Integer finishNumber;

    /**
     * 任务状态
     */
    private Integer status;

    /**
     * 流水号
     */
    private Integer serialNumber;

    /**
     * 创建时间
     */
    private Date cateateTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 操作者ip
     */
    private String operateIp;

    /**
     * 操作者
     */
    private String operator;

    /**
     * 任务名称
     */
    private String name;

    /**
     * tcu软件编号
     */
    private String tcuSoftwareNo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Date getProducedTime() {
        return producedTime;
    }

    public void setProducedTime(Date producedTime) {
        this.producedTime = producedTime;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public Integer getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(Integer batchNumber) {
        this.batchNumber = batchNumber;
    }

    public Integer getFinishNumber() {
        return finishNumber;
    }

    public void setFinishNumber(Integer finishNumber) {
        this.finishNumber = finishNumber;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Date getCateateTime() {
        return cateateTime;
    }

    public void setCateateTime(Date cateateTime) {
        this.cateateTime = cateateTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getOperateIp() {
        return operateIp;
    }

    public void setOperateIp(String operateIp) {
        this.operateIp = operateIp == null ? null : operateIp.trim();
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTcuSoftwareNo() {
        return tcuSoftwareNo;
    }

    public void setTcuSoftwareNo(String tcuSoftwareNo) {
        this.tcuSoftwareNo = tcuSoftwareNo;
    }
}