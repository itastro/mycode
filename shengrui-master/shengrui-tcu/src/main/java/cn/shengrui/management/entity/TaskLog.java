package cn.shengrui.management.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
public class TaskLog {
    private Integer id;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date operateTime;

    private String operator;

    private String projectName;

    private String tcuType;

    private String taskName;

    private Integer result;

    private String serialNumber;

    private String batchNo;

    private Integer batchNumber;

    private String tcuCode;

    private String supCode;

    private Integer customerBarcodeCount;

    private String writePartsNo;

    private String labelPartsNo;

    private Integer taskId;

    private String reason;

    private String calibrationFileName;

    private String srPrintScript;

    private String automakerPrintScript;

    private String tcuNo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public String getTcuType() {
        return tcuType;
    }

    public void setTcuType(String tcuType) {
        this.tcuType = tcuType == null ? null : tcuType.trim();
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName == null ? null : taskName.trim();
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber == null ? null : serialNumber.trim();
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo == null ? null : batchNo.trim();
    }

    public Integer getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(Integer batchNumber) {
        this.batchNumber = batchNumber;
    }

    public String getTcuCode() {
        return tcuCode;
    }

    public void setTcuCode(String tcuCode) {
        this.tcuCode = tcuCode == null ? null : tcuCode.trim();
    }

    public String getSupCode() {
        return supCode;
    }

    public void setSupCode(String supCode) {
        this.supCode = supCode == null ? null : supCode.trim();
    }

    public Integer getCustomerBarcodeCount() {
        return customerBarcodeCount;
    }

    public void setCustomerBarcodeCount(Integer customerBarcodeCount) {
        this.customerBarcodeCount = customerBarcodeCount;
    }

    public String getWritePartsNo() {
        return writePartsNo;
    }

    public void setWritePartsNo(String writePartsNo) {
        this.writePartsNo = writePartsNo == null ? null : writePartsNo.trim();
    }

    public String getLabelPartsNo() {
        return labelPartsNo;
    }

    public void setLabelPartsNo(String labelPartsNo) {
        this.labelPartsNo = labelPartsNo == null ? null : labelPartsNo.trim();
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public String getCalibrationFileName() {
        return calibrationFileName;
    }

    public void setCalibrationFileName(String calibrationFileName) {
        this.calibrationFileName = calibrationFileName == null ? null : calibrationFileName.trim();
    }

    public String getSrPrintScript() {
        return srPrintScript;
    }

    public void setSrPrintScript(String srPrintScript) {
        this.srPrintScript = srPrintScript == null ? null : srPrintScript.trim();
    }

    public String getAutomakerPrintScript() {
        return automakerPrintScript;
    }

    public void setAutomakerPrintScript(String automakerPrintScript) {
        this.automakerPrintScript = automakerPrintScript == null ? null : automakerPrintScript.trim();
    }

    public String getTcuNo() {
        return tcuNo;
    }

    public void setTcuNo(String tcuNo) {
        this.tcuNo = tcuNo == null ? null : tcuNo.trim();
    }
}