package com.bailian.car.domain.iccard;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "iccard_use_history")
public class IccardUseHistory implements Serializable {
	public Date getLicenseEndTime() {
		return licenseEndTime;
	}

	public void setLicenseEndTime(Date licenseEndTime) {
		this.licenseEndTime = licenseEndTime;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public String getCarSn() {
		return carSn;
	}

	public void setCarSn(String carSn) {
		this.carSn = carSn;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getIo() {
		return io;
	}

	public void setIo(String io) {
		this.io = io;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCariccard() {
		return cariccard;
	}

	public void setCariccard(String cariccard) {
		this.cariccard = cariccard;
	}


	public String getDrivercard() {
		return drivercard;
	}

	public void setDrivercard(String drivercard) {
		this.drivercard = drivercard;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false, length = 11)
	private Integer id; // 主键

	@Column(name = "CAR_CARD_ID", length = 50)
	private String cariccard; // 车辆ic卡id
	
	@Column(name = "UPDATE_TIME")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date updateTime; // 更新时间
	
	@Column(name = "DRIVER_CARD_ID", length = 50)
	private String drivercard; // 驾驶员ic卡id
	
	@Column(name = "ERROR_STRING", length = 200)
	private String error; // 错误代码
	
	@Column(name = "IO", length = 20)
	private String io;

   //驾驶员名称
	private String driverName;
	
	//车辆编号
	private String carSn;
	
	//车牌号
	private String licenseNo;
	
	//车牌结束日
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone = "GMT+8")
	private Date licenseEndTime;
}
