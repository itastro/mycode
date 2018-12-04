package com.bailian.car.domain.carmaintain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.time.DateUtils;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * 
 * @ClassName: CarMaintain
 * @Description:车辆维修实体类
 * @author itastro
 * @date 2018年5月15日
 *
 */
@Entity
@Table(name = "t_carmaintain")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarMaintain implements Serializable{

	    
	public Date getSortTime() {
		return sortTime;
	}

	public void setSortTime(Date sortTime) {
		this.sortTime = sortTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 1L;

	public String getApplyTEL() {
		return applyTEL;
	}

	public void setApplyTEL(String applyTEL) {
		this.applyTEL = applyTEL;
	}

	public String getOperatorTEL() {
		return operatorTEL;
	}

	public void setOperatorTEL(String operatorTEL) {
		this.operatorTEL = operatorTEL;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getvSn() {
		return vSn;
	}

	public void setvSn(String vSn) {
		this.vSn = vSn;
	}

	public String getApplyPeople() {
		return applyPeople;
	}

	public void setApplyPeople(String applyPeople) {
		this.applyPeople = applyPeople;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getSend_park() {
		return send_park;
	}

	public void setSend_park(String send_park) {
		this.send_park = send_park;
	}

	public Date getApplytime() {
		return applytime;
	}

	public void setApplytime(Date applytime) {
		this.applytime = applytime;
	}

	public String getApplyRemark() {
		return applyRemark;
	}

	public void setApplyRemark(String applyRemark) {
		this.applyRemark = applyRemark;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getWorkContent() {
		return workContent;
	}

	public void setWorkContent(String workContent) {
		this.workContent = workContent;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Date getForecastTime() {
		return forecastTime;
	}

	public void setForecastTime(Date forecastTime) {
		this.forecastTime = forecastTime;
	}

	public String getFin_park() {
		return fin_park;
	}

	public void setFin_park(String fin_park) {
		this.fin_park = fin_park;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false, length = 11)
	private int id;

	@Column(columnDefinition = "varchar(20) default ''")
	private String vSn; // 车辆编号

	@Column(columnDefinition = "varchar(20) default ''")
	private String applyPeople; // 申请人

	@Column(columnDefinition = "varchar(20) default ''")
	private String item; // 维修项目

	@Column(columnDefinition = "varchar(20) default ''")
	private String send_park; // 停放地点

	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date applytime; // 申请时间
	
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date sortTime; // 排序时间

	private String applyRemark; // 申请备注

	private String status; // 状态

	private String workContent; // 工作内容

	@Column(columnDefinition = "varchar(20) default ''")
	private String operator; // 维修人 谁去维修

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date forecastTime; // 预计完成时间

	@Column(columnDefinition = "varchar(20) default ''")
	private String fin_park; // 完成停发地点

	@Column(columnDefinition = "varchar(255) default ''")
	private String remark; // 备注

	private String applyTEL;

	private String operatorTEL;

}
