package com.bailian.car.domain.cars.car;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "t_car")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties
public class Car implements Serializable {

	

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getVehicleInspection() {
		return vehicleInspection;
	}

	public void setVehicleInspection(String vehicleInspection) {
		this.vehicleInspection = vehicleInspection;
	}

	public String getBackStatus() {
		return backStatus;
	}

	public void setBackStatus(String backStatus) {
		this.backStatus = backStatus;
	}

	public String getBomurl() {
		return bomurl;
	}

	public void setBomurl(String bomurl) {
		this.bomurl = bomurl;
	}

	public String getSafeCheck() {
		return safeCheck;
	}

	public void setSafeCheck(String safeCheck) {
		this.safeCheck = safeCheck;
	}

	public String getHiCheck() {
		return hiCheck;
	}

	public void setHiCheck(String hiCheck) {
		this.hiCheck = hiCheck;
	}

	public String getBackCard() {
		return backCard;
	}

	public void setBackCard(String backCard) {
		this.backCard = backCard;
	}

	public String getCircuitName() {
		return circuitName;
	}

	public void setCircuitName(String circuitName) {
		this.circuitName = circuitName;
	}

	public String getWordName() {
		return wordName;
	}

	public void setWordName(String wordName) {
		this.wordName = wordName;
	}

	public String getWordurl() {
		return wordurl;
	}

	public void setWordurl(String wordurl) {
		this.wordurl = wordurl;
	}

	public String getInsremark() {
		return insremark;
	}

	public void setInsremark(String insremark) {
		this.insremark = insremark;
	}

	public String getLicremark() {
		return licremark;
	}

	public void setLicremark(String licremark) {
		this.licremark = licremark;
	}

	public String getRstatus() {
		return rstatus;
	}

	public void setRstatus(String rstatus) {
		this.rstatus = rstatus;
	}

	public String getCircuiturl() {
		return circuiturl;
	}

	public void setCircuiturl(String circuiturl) {
		this.circuiturl = circuiturl;
	}

	public String getFsuelType() {
		return fsuelType;
	}

	public void setFsuelType(String fsuelType) {
		this.fsuelType = fsuelType;
	}

	public String getGbts() {
		return gbts;
	}

	public void setGbts(String gbts) {
		this.gbts = gbts;
	}

	public Double getTowards() {
		return towards;
	}

	public void setTowards(Double towards) {
		this.towards = towards;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public String getInsNo() {
		return insNo;
	}

	public void setInsNo(String insNo) {
		this.insNo = insNo;
	}

	public String getCheckStaionType() {
		return checkStaionType;
	}

	public void setCheckStaionType(String checkStaionType) {
		this.checkStaionType = checkStaionType;
	}

	public Date getBackcheckSubmitTime() {
		return backcheckSubmitTime;
	}

	public void setBackcheckSubmitTime(Date backcheckSubmitTime) {
		this.backcheckSubmitTime = backcheckSubmitTime;
	}

	public Date getUpcheckSubmitTime() {
		return upcheckSubmitTime;
	}

	public void setUpcheckSubmitTime(Date upcheckSubmitTime) {
		this.upcheckSubmitTime = upcheckSubmitTime;
	}

	public String getIstatus() {
		return istatus;
	}

	public void setIstatus(String istatus) {
		this.istatus = istatus;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public Integer getSeats() {
		return seats;
	}

	public void setSeats(Integer seats) {
		this.seats = seats;
	}

	public String getPicurl() {
		return picurl;
	}

	public void setPicurl(String picurl) {
		this.picurl = picurl;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getvSn() {
		return vSn;
	}

	public void setvSn(String vSn) {
		this.vSn = vSn;
	}

	public String getvCarType() {
		return vCarType;
	}

	public void setvCarType(String vCarType) {
		this.vCarType = vCarType;
	}

	public String getBrandModelone() {
		return brandModelone;
	}

	public void setBrandModelone(String brandModelone) {
		this.brandModelone = brandModelone;
	}

	public String getBrandModeltwo() {
		return brandModeltwo;
	}

	public void setBrandModeltwo(String brandModeltwo) {
		this.brandModeltwo = brandModeltwo;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getProjectEngineer() {
		return projectEngineer;
	}

	public void setProjectEngineer(String projectEngineer) {
		this.projectEngineer = projectEngineer;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEngineType() {
		return engineType;
	}

	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}

	public String getEngineNumber() {
		return engineNumber;
	}

	public void setEngineNumber(String engineNumber) {
		this.engineNumber = engineNumber;
	}

	public String getEngineCapacity() {
		return engineCapacity;
	}

	public void setEngineCapacity(String engineCapacity) {
		this.engineCapacity = engineCapacity;
	}

	public String getOilspecification() {
		return oilspecification;
	}

	public void setOilspecification(String oilspecification) {
		this.oilspecification = oilspecification;
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

	public String getFrontTireP() {
		return frontTireP;
	}

	public void setFrontTireP(String frontTireP) {
		this.frontTireP = frontTireP;
	}

	public String getVehicleQuality() {
		return vehicleQuality;
	}

	public void setVehicleQuality(String vehicleQuality) {
		this.vehicleQuality = vehicleQuality;
	}

	public String getLoadMethod() {
		return loadMethod;
	}

	public void setLoadMethod(String loadMethod) {
		this.loadMethod = loadMethod;
	}

	public String getLoadData() {
		return loadData;
	}

	public void setLoadData(String loadData) {
		this.loadData = loadData;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Date getMakeTime() {
		return makeTime;
	}

	public void setMakeTime(Date makeTime) {
		this.makeTime = makeTime;
	}

	public Integer getRunsumtime() {
		return runsumtime;
	}

	public void setRunsumtime(Integer runsumtime) {
		this.runsumtime = runsumtime;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public String getRunStatic() {
		return runStatic;
	}

	public void setRunStatic(String runStatic) {
		this.runStatic = runStatic;
	}

	public Double getBatteryvoltage() {
		return batteryvoltage;
	}

	public void setBatteryvoltage(Double batteryvoltage) {
		this.batteryvoltage = batteryvoltage;
	}

	public String getGpsSN() {
		return gpsSN;
	}

	public void setGpsSN(String gpsSN) {
		this.gpsSN = gpsSN;
	}

	public String getIccard() {
		return iccard;
	}

	public void setIccard(String iccard) {
		this.iccard = iccard;
	}

	public Date getdAllowStartTm() {
		return dAllowStartTm;
	}

	public void setdAllowStartTm(Date dAllowStartTm) {
		this.dAllowStartTm = dAllowStartTm;
	}

	public Date getdAllowEndTm() {
		return dAllowEndTm;
	}

	public void setdAllowEndTm(Date dAllowEndTm) {
		this.dAllowEndTm = dAllowEndTm;
	}

	public String getIsAllow() {
		return isAllow;
	}

	public void setIsAllow(String isAllow) {
		this.isAllow = isAllow;
	}

	public Date getFromtime() {
		return fromtime;
	}

	public void setFromtime(Date fromtime) {
		this.fromtime = fromtime;
	}

	public Date getLastTime() {
		return lastTime;
	}

	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}

	public Double getSpeed() {
		return speed;
	}

	public void setSpeed(Double speed) {
		this.speed = speed;
	}

	public String getCar_status() {
		return car_status;
	}

	public void setCar_status(String car_status) {
		this.car_status = car_status;
	}

	public String getWarn() {
		return warn;
	}

	public void setWarn(String warn) {
		this.warn = warn;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getUpcheckTime() {
		return upcheckTime;
	}

	public void setUpcheckTime(Date upcheckTime) {
		this.upcheckTime = upcheckTime;
	}

	public Date getBackchecktime() {
		return backchecktime;
	}

	public void setBackchecktime(Date backchecktime) {
		this.backchecktime = backchecktime;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getChecks_status() {
		return checks_status;
	}

	public void setChecks_status(String checks_status) {
		this.checks_status = checks_status;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getLicenseEndTime() {
		return licenseEndTime;
	}

	public void setLicenseEndTime(Date licenseEndTime) {
		this.licenseEndTime = licenseEndTime;
	}

	public Date getLicenseStartTime() {
		return licenseStartTime;
	}

	public void setLicenseStartTime(Date licenseStartTime) {
		this.licenseStartTime = licenseStartTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = -4620455602495338828L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false, length = 11)
	private Integer id;

	private String carName; // 车辆名称

	private String vSn; // 车辆编号

	private String vCarType; // 车辆类型

	private String brandModelone; // 厂牌型号1 （来自车辆录入）

	private String brandModeltwo; // 厂牌型号2 （来自保险）

	private String customer; // 客戶

	private String projectEngineer; // 項目工程師

	private String contactNumber; // 联系电话

	private String engineType; // 发动机型号

	private String engineNumber; // 发动机编号

	private String engineCapacity; // 发动机排量

	private String fsuelType; // 燃油规格

	private String oilspecification; // 机油规格

	private String tyresize; // 轮胎规格

	private String gbts; // 变速箱邮箱规格

	private String reaTireP;// 后轮胎压力

	private String frontTireP; // 前轮胎压力

	private String vehicleQuality; // 车辆整备质量

	private String loadMethod; // 加载方式

	private String loadData; // 加载数据

	private String vin; // 车辆识别码

	private String color; // 车辆颜色

	private Integer seats; // 座位数

	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date makeTime; // 制作日期

	private Integer runsumtime; // 车辆行驶总时间

	private Double longitude; // 经度

	private Double latitude; // 维度

	private String runStatic; // 行驶状态

	private Double batteryvoltage; // 电瓶电压
	@Column(name = "GPSSN")
	private String gpsSN; // gps编号

	private String iccard; // ic卡
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date dAllowStartTm; // 允许行驶开始时间
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date dAllowEndTm; // 允许行驶结束时间

	private String isAllow; // 是否允许

	private Date fromtime; // 开始时间
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date lastTime; // 结束时间

	private Double speed; // 行驶速度

	private String car_status; // 车辆状态

	private String warn; // 报警
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date upcheckTime; // 接车日期
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date upcheckSubmitTime; // 接车提交日期
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date backchecktime; // 还车日期
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date backcheckSubmitTime; // 还车点检体提交日期

	private String groupName; // 车辆分组;

	private String checks_status; // 车辆检查状态

	private String insNo; // 保险编号

	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date startTime; // 保险起始时间
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date endTime; // 保险结束时间
	@Builder.Default
	private String istatus = "未申请"; // 保险状态

	@Column(columnDefinition = "varchar(50) default ''")
	private String licenseNo; // 车牌号

	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date licenseEndTime; // 牌照结束时间

	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date licenseStartTime; // 牌照起始日期

	private String adminName; // 车管

	private String price; // 价值

	private String picurl; // 车辆照片路径

	private String explanation; // 说明

	private String remark; // 备注
	@ManyToOne
	@JoinColumn(name = "project_id")
	private Project project;

	private String checkStaionType; // 监测站车型

	private Double towards;

	@Builder.Default
	private String rstatus = "未审核";

	private String insremark; // 保险备注

	private String licremark; // 车牌备注

	private String wordurl; // wordurl

	private String wordName; // word的名称

	private String circuiturl; // 电路图路径

	private String circuitName; // 电路图名称

	private String backCard; // 尾卡
	@Builder.Default
	private String safeCheck="未通过"; //安全检查状态
	@Builder.Default
	private String hiCheck="未完成";   //线束检查状态
	
	private String bomurl; // 电路图名称
	
	private String backStatus;
	@Builder.Default
	private  String  vehicleInspection="未申请";  //验车状态
	
	private String driverName;
	

}
