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

@Entity
@Table(name = "t_carbase")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarBase implements Serializable {



	public String getBomurl() {
		return bomurl;
	}

	public void setBomurl(String bomurl) {
		this.bomurl = bomurl;
	}

	public String getIccard() {
		return iccard;
	}

	public void setIccard(String iccard) {
		this.iccard = iccard;
	}

	public String getBackCard() {
		return backCard;
	}

	public void setBackCard(String backCard) {
		this.backCard = backCard;
	}

	public String getWordurl() {
		return wordurl;
	}

	public void setWordurl(String wordurl) {
		this.wordurl = wordurl;
	}

	public String getWordName() {
		return wordName;
	}

	public void setWordName(String wordName) {
		this.wordName = wordName;
	}

	public String getCircuitName() {
		return circuitName;
	}

	public void setCircuitName(String circuitName) {
		this.circuitName = circuitName;
	}

	public String getCircuiturl() {
		return circuiturl;
	}

	public void setCircuiturl(String circuiturl) {
		this.circuiturl = circuiturl;
	}

	public String getFrontTireP() {
		return frontTireP;
	}

	public void setFrontTireP(String frontTireP) {
		this.frontTireP = frontTireP;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public String getGbts() {
		return gbts;
	}

	public void setGbts(String gbts) {
		this.gbts = gbts;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 1L;

	public Integer getSeats() {
		return seats;
	}

	public void setSeats(Integer seats) {
		this.seats = seats;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getPicurl() {
		return picurl;
	}

	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}

	public String getProjectEngineer() {
		return projectEngineer;
	}

	public void setProjectEngineer(String projectEngineer) {
		this.projectEngineer = projectEngineer;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOilspecification() {
		return oilspecification;
	}

	public void setOilspecification(String oilspecification) {
		this.oilspecification = oilspecification;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getvSn() {
		return vSn;
	}

	public void setvSn(String vSn) {
		this.vSn = vSn;
	}

	public String getProject_sn() {
		return project_sn;
	}

	public void setProject_sn(String project_sn) {
		this.project_sn = project_sn;
	}

	public String getProject_name() {
		return project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}

	public String getEngineType() {
		return engineType;
	}

	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getvCarType() {
		return vCarType;
	}

	public void setvCarType(String vCarType) {
		this.vCarType = vCarType;
	}

	public String getEngineCapacity() {
		return engineCapacity;
	}

	public void setEngineCapacity(String engineCapacity) {
		this.engineCapacity = engineCapacity;
	}

	public String getTyresize() {
		return tyresize;
	}

	public void setTyresize(String tyresize) {
		this.tyresize = tyresize;
	}

	public String getReaTireP() {
		return reaTireP;
	}

	public void setReaTireP(String reaTireP) {
		this.reaTireP = reaTireP;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Date getMakeTime() {
		return makeTime;
	}

	public void setMakeTime(Date makeTime) {
		this.makeTime = makeTime;
	}

	public String getVehicleQuality() {
		return vehicleQuality;
	}

	public void setVehicleQuality(String vehicleQuality) {
		this.vehicleQuality = vehicleQuality;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
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
	private Integer id;

	private String vSn; // 车辆编号

	private String project_sn; // 项目号

	private String project_name; // 项目名称

	private String projectEngineer; // 項目工程師

	private String engineType; // 发动机型号

	private String carName; // 车辆名称

	private String groupName; // 项目分组

	private String vCarType; // 车辆类型

	private String engineCapacity; // 发动机排量

	private String gbts; // 变速箱邮箱规格

	private String fuelType; // 燃油规格

	private String oilspecification; // 机油规格

	private String tyresize; // 轮胎规格

	private String reaTireP;// 后轮胎压力

	private String customer; // 客戶

	private String operator; // 填写人
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date makeTime; // 制作日期

	private String vehicleQuality; // 车辆整备质量

	private String color; // 车辆颜色

	private Integer seats; // 座位数

	private String adminName; // 车管

	private String price; // 价值

	private String contactNumber; // 联系电话

	private String picurl; // 车辆照片路径

	private String remark; // 备注

	private String frontTireP; // 前轮胎压力

	private String wordurl; // wordurl

	private String wordName; // word的名称

	private String circuiturl; // 电路图路径

	private String circuitName; // 电路图名称

	private String iccard;

	private String backCard;

	private String bomurl;
	
	

}