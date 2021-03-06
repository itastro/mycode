package com.bailian.car.domain.cardriver;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_inandout")
public class InAndOut implements Serializable {




	public String getIo() {
		return io;
	}

	public void setIo(String io) {
		this.io = io;
	}

	public String getDriverCardId() {
		return driverCardId;
	}

	public void setDriverCardId(String driverCardId) {
		this.driverCardId = driverCardId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getInsNo() {
		return insNo;
	}

	public void setInsNo(String insNo) {
		this.insNo = insNo;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	private static final long serialVersionUID = 1L;

	public String getIsallow() {
		return isallow;
	}

	public void setIsallow(String isallow) {
		this.isallow = isallow;
	}

	public Date getLicenseEndTime() {
		return licenseEndTime;
	}

	public void setLicenseEndTime(Date licenseEndTime) {
		this.licenseEndTime = licenseEndTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getvSn() {
		return vSn;
	}

	public void setvSn(String vSn) {
		this.vSn = vSn;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getErrorString() {
		return errorString;
	}

	public void setErrorString(String errorString) {
		this.errorString = errorString;
	}

	public String getLicenseNo() {
		return LicenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		LicenseNo = licenseNo;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false, length = 11)
	private Integer id; // id
	@ApiModelProperty(value = "车辆编号")
	private String vSn; // 车辆编号

	@ApiModelProperty(value = "驾驶员名称")
	private String driverName; // 驾驶员名称

	@ApiModelProperty(value = "牌照有效期")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date licenseEndTime; // 牌照有效期

	@ApiModelProperty(value = "保险有效期")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date endTime; // 保险有效期

	// 保险编号
	private String insNo; // 保险编号

	@ApiModelProperty(value = "进出时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date updateTime; // 进出时间

	@ApiModelProperty(value = "是否允许通过")
	private String isallow; // 驾驶员是否授权

	@ApiModelProperty(value = "错误代码")
	private String errorString; // 错误代码 //如果有值 则提示“不允许通过” 无值“提示允许通过”

	@ApiModelProperty(value = "车牌号")
	private String LicenseNo; // 车牌号
	
	private String driverCardId;
	
	private String io;
}
