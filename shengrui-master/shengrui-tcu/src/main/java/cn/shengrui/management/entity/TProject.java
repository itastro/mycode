package cn.shengrui.management.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TProject implements Serializable{
    private Integer id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    private String operator;

    private String operateIp;

    private Integer status;

    private Integer companyId;

    private Integer tcuId;

    private String name;

    private String labelPartsNo;

    private String writePartsNo;

    private Integer customerBarcodeType;

    private Integer customerBarcodeCount;

    private String shengruiScript;

    private String customerScript;

    private TCompany company = new TCompany();

    private TTcu tcu = new TTcu();

    public Integer getTcuId() {
        return tcuId;
    }

    public void setTcuId(Integer tcuId) {
        this.tcuId = tcuId;
    }

    public TCompany getCompany() {
        return company;
    }

    public void setCompany(TCompany company) {
        this.company = company;
    }

    public TTcu getTcu() {
        return tcu;
    }

    public void setTcu(TTcu tcu) {
        this.tcu = tcu;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public String getOperateIp() {
        return operateIp;
    }

    public void setOperateIp(String operateIp) {
        this.operateIp = operateIp == null ? null : operateIp.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getLabelPartsNo() {
        return labelPartsNo;
    }

    public void setLabelPartsNo(String labelPartsNo) {
        this.labelPartsNo = labelPartsNo;
    }

    public String getWritePartsNo() {
        return writePartsNo;
    }

    public void setWritePartsNo(String writePartsNo) {
        this.writePartsNo = writePartsNo;
    }

    public Integer getCustomerBarcodeType() {
        return customerBarcodeType;
    }

    public void setCustomerBarcodeType(Integer customerBarcodeType) {
        this.customerBarcodeType = customerBarcodeType;
    }

    public Integer getCustomerBarcodeCount() {
        return customerBarcodeCount;
    }

    public void setCustomerBarcodeCount(Integer customerBarcodeCount) {
        this.customerBarcodeCount = customerBarcodeCount;
    }

    public String getShengruiScript() {
        return shengruiScript;
    }

    public void setShengruiScript(String shengruiScript) {
        this.shengruiScript = shengruiScript;
    }

    public String getCustomerScript() {
        return customerScript;
    }

    public void setCustomerScript(String customerScript) {
        this.customerScript = customerScript;
    }
}