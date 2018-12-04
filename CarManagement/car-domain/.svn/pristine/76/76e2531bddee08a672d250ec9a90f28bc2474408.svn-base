package com.bailian.car.domain.cardriver;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "t_driver")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "驾驶员")
public class Driver implements Serializable {

	public String getAllowType() {
		return allowType;
	}

	public void setAllowType(String allowType) {
		this.allowType = allowType;
	}

	public Date getAllowStartTime() {
		return allowStartTime;
	}

	public void setAllowStartTime(Date allowStartTime) {
		this.allowStartTime = allowStartTime;
	}

	public Date getAllowEndTime() {
		return allowEndTime;
	}

	public void setAllowEndTime(Date allowEndTime) {
		this.allowEndTime = allowEndTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getIccard() {
		return iccard;
	}

	public void setIccard(String iccard) {
		this.iccard = iccard;
	}

	public String getIsallow() {
		return isallow;
	}

	public void setIsallow(String isallow) {
		this.isallow = isallow;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getEmployeeCard() {
		return employeeCard;
	}

	public void setEmployeeCard(String employeeCard) {
		this.employeeCard = employeeCard;
	}

	public Set<DriverGroup> getGroups() {
		return groups;
	}

	public void setGroups(Set<DriverGroup> groups) {
		this.groups = groups;
	}

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false, length = 11)
	private Integer id;
	@NotBlank(message = "驾驶员名称不能为空")
	@ApiModelProperty(value = "驾驶员姓名")
	private String name; // 驾驶员姓名

	@ApiModelProperty(value = "驾驶员电话")
	private String telephone; // 驾驶员电话

	@ApiModelProperty(value = "ic卡")
	private String iccard; // ic卡卡号

	@ApiModelProperty(value = "起始日")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date allowStartTime; // 允许驾驶开始时间

	@ApiModelProperty(value = "终止日")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date allowEndTime; // 允许见识结束时间

	@ApiModelProperty(value = "是否禁用   正常  禁用")
	private String isallow; // 1 正常 2 禁用

	@ApiModelProperty(value = "备注")
	private String remark; // 备注
	
	@ApiModelProperty(value = "员工卡号")
	private String employeeCard; // 员工卡号

	private String allowType; // 准假车型

	@ManyToMany(cascade = { CascadeType.REMOVE })
	@JoinTable(name = "t_driver_group", joinColumns = {
			@JoinColumn(name = "driver_id", referencedColumnName = "ID") }, inverseJoinColumns = {
					@JoinColumn(name = "group_id", referencedColumnName = "ID") })
	@Builder.Default
	@ApiModelProperty(value = "分组")
	private Set<DriverGroup> groups = new HashSet<DriverGroup>(0);

}
