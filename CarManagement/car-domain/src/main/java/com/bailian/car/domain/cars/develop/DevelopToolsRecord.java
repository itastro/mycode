package com.bailian.car.domain.cars.develop;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * 
    * @ClassName: DevelopToolsRecord
    * @Description: 研发工具记录
    * @author itastro
    * @date 2018年4月17日
    *
 */
@Entity
@Table(name = "t_develop")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DevelopToolsRecord implements Serializable {

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getOperatorDate() {
		return operatorDate;
	}

	public void setOperatorDate(Date operatorDate) {
		this.operatorDate = operatorDate;
	}

	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getvSn() {
		return vSn;
	}

	public void setvSn(String vSn) {
		this.vSn = vSn;
	}

	private static final long serialVersionUID = 1L;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getToolName() {
		return toolName;
	}

	public void setToolName(String toolName) {
		this.toolName = toolName;
	}

	public String getApplicant() {
		return applicant;
	}

	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}

	public Date getEquippedDate() {
		return equippedDate;
	}

	public void setEquippedDate(Date equippedDate) {
		this.equippedDate = equippedDate;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Date getDemolitionDate() {
		return demolitionDate;
	}

	public void setDemolitionDate(Date demolitionDate) {
		this.demolitionDate = demolitionDate;
	}

	public String getDemolitionOperator() {
		return demolitionOperator;
	}

	public void setDemolitionOperator(String demolitionOperator) {
		this.demolitionOperator = demolitionOperator;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "C_ID", unique = true, nullable = false, length = 11)
	private Integer id;
	@Column(columnDefinition = "varchar(20) default ''")
	private String vSn; // 车辆编号

	@Column(columnDefinition = "varchar(20) default ''")
	private String toolName; // 工具名称

	@Column(columnDefinition = "varchar(20) default ''")
	private String applicant; // 申请人

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date applyTime;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	
	private Date equippedDate; // 装备日期

	@Column(columnDefinition = "varchar(20) default ''")
	private String operator; // 操作人

	
	private Date operatorDate; // 操作日期

	
	private Date demolitionDate; // 拆除日期

	@Column(columnDefinition = "varchar(20) default ''")
	private String demolitionOperator; // 拆除操做人

	private String remark;
}
