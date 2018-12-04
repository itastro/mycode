package com.bailian.car.domain.cars.car;

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

@Builder
@Entity
@Table(name = "t_carlicense")
@AllArgsConstructor
@NoArgsConstructor
public class CarLicense implements Serializable{
	    
	private static final long serialVersionUID = 1L;

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public String getApplyperson() {
		return applyperson;
	}

	public void setApplyperson(String applyperson) {
		this.applyperson = applyperson;
	}

	public String getAddPerson() {
		return addPerson;
	}

	public void setAddPerson(String addPerson) {
		this.addPerson = addPerson;
	}

	public Date getApplytime() {
		return applytime;
	}

	public void setApplytime(Date applytime) {
		this.applytime = applytime;
	}

	public Date getMaketime() {
		return maketime;
	}

	public void setMaketime(Date maketime) {
		this.maketime = maketime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getVehicleInspection() {
		return vehicleInspection;
	}

	public void setVehicleInspection(String vehicleInspection) {
		this.vehicleInspection = vehicleInspection;
	}

	public Integer getLlave() {

		if (licenseEndTime == null) {
			return llave;
		}
		if (licenseStartTime == null) {
			return llave;
		}
		Long etime = licenseEndTime.getTime();
		Long stime = new Date().getTime();
		Long l = etime - stime;
		llave = (int) (l / 1000 / 60 / 60 / 24);

		return llave;
	}

	public void setLlave(Integer llave) {
		this.llave = llave;
	}

	public String getvSn() {
		return vSn;
	}

	public void setvSn(String vSn) {
		this.vSn = vSn;
	}

	public Date getLicenseStartTime() {
		return licenseStartTime;
	}

	public void setLicenseStartTime(Date licenseStartTime) {
		this.licenseStartTime = licenseStartTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getLicenseEndTime() {
		return licenseEndTime;
	}

	public void setLicenseEndTime(Date licenseEndTime) {
		this.licenseEndTime = licenseEndTime;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "C_ID", unique = true, nullable = false, length = 11)
	private Integer id;

	private String vSn;// 车辆编号

	private String licenseNo; // 车牌号

	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date licenseEndTime; // 牌照结束时间
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date licenseStartTime; // 牌照起始日期

	private Integer llave; // 牌照剩余日期

	private String vehicleInspection; // 验车状态 

	private String remark; // 备注

	private Date applytime; // 申请时间

	private String applyperson; // 验车申请人

	private Date maketime; // 牌照制作日期

	private String addPerson; // 录入人

}
