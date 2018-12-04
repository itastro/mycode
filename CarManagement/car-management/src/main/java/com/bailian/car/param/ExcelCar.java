package com.bailian.car.param;

public class ExcelCar {

	public String getIsremark() {
		return isremark;
	}

	public void setIsremark(String isremark) {
		this.isremark = isremark;
	}

	@Override
	public String toString() {
		return "ExcelCar [explanation=" + explanation + ", vSn=" + vSn + ", project_sn=" + project_sn
				+ ", projectstatus=" + projectstatus + ", customer=" + customer + ", projectEngineer=" + projectEngineer
				+ ", car_status=" + car_status + ", upcheckTime=" + upcheckTime + ", backchecktime=" + backchecktime
				+ ", brandModelone=" + brandModelone + ", brandModeltwo=" + brandModeltwo + ", color=" + color
				+ ", type=" + type + ", engineCapacity=" + engineCapacity + ", seats=" + seats + ", vehicleQuality="
				+ vehicleQuality + ", engineNumber=" + engineNumber + ", vin=" + vin + ", no=" + no + ", startTime="
				+ startTime + ", endTime=" + endTime + ", licenseNo=" + licenseNo + ", adminName=" + adminName
				+ ", licendtime=" + licendtime + ", remark=" + remark + ", isremark=" + isremark + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adminName == null) ? 0 : adminName.hashCode());
		result = prime * result + ((backchecktime == null) ? 0 : backchecktime.hashCode());
		result = prime * result + ((brandModelone == null) ? 0 : brandModelone.hashCode());
		result = prime * result + ((brandModeltwo == null) ? 0 : brandModeltwo.hashCode());
		result = prime * result + ((car_status == null) ? 0 : car_status.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result + ((engineCapacity == null) ? 0 : engineCapacity.hashCode());
		result = prime * result + ((engineNumber == null) ? 0 : engineNumber.hashCode());
		result = prime * result + ((explanation == null) ? 0 : explanation.hashCode());
		result = prime * result + ((isremark == null) ? 0 : isremark.hashCode());
		result = prime * result + ((licendtime == null) ? 0 : licendtime.hashCode());
		result = prime * result + ((licenseNo == null) ? 0 : licenseNo.hashCode());
		result = prime * result + ((no == null) ? 0 : no.hashCode());
		result = prime * result + ((projectEngineer == null) ? 0 : projectEngineer.hashCode());
		result = prime * result + ((project_sn == null) ? 0 : project_sn.hashCode());
		result = prime * result + ((projectstatus == null) ? 0 : projectstatus.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + seats;
		result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((upcheckTime == null) ? 0 : upcheckTime.hashCode());
		result = prime * result + ((vSn == null) ? 0 : vSn.hashCode());
		result = prime * result + ((vehicleQuality == null) ? 0 : vehicleQuality.hashCode());
		result = prime * result + ((vin == null) ? 0 : vin.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExcelCar other = (ExcelCar) obj;
		if (adminName == null) {
			if (other.adminName != null)
				return false;
		} else if (!adminName.equals(other.adminName))
			return false;
		if (backchecktime == null) {
			if (other.backchecktime != null)
				return false;
		} else if (!backchecktime.equals(other.backchecktime))
			return false;
		if (brandModelone == null) {
			if (other.brandModelone != null)
				return false;
		} else if (!brandModelone.equals(other.brandModelone))
			return false;
		if (brandModeltwo == null) {
			if (other.brandModeltwo != null)
				return false;
		} else if (!brandModeltwo.equals(other.brandModeltwo))
			return false;
		if (car_status == null) {
			if (other.car_status != null)
				return false;
		} else if (!car_status.equals(other.car_status))
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (engineCapacity == null) {
			if (other.engineCapacity != null)
				return false;
		} else if (!engineCapacity.equals(other.engineCapacity))
			return false;
		if (engineNumber == null) {
			if (other.engineNumber != null)
				return false;
		} else if (!engineNumber.equals(other.engineNumber))
			return false;
		if (explanation == null) {
			if (other.explanation != null)
				return false;
		} else if (!explanation.equals(other.explanation))
			return false;
		if (isremark == null) {
			if (other.isremark != null)
				return false;
		} else if (!isremark.equals(other.isremark))
			return false;
		if (licendtime == null) {
			if (other.licendtime != null)
				return false;
		} else if (!licendtime.equals(other.licendtime))
			return false;
		if (licenseNo == null) {
			if (other.licenseNo != null)
				return false;
		} else if (!licenseNo.equals(other.licenseNo))
			return false;
		if (no == null) {
			if (other.no != null)
				return false;
		} else if (!no.equals(other.no))
			return false;
		if (projectEngineer == null) {
			if (other.projectEngineer != null)
				return false;
		} else if (!projectEngineer.equals(other.projectEngineer))
			return false;
		if (project_sn == null) {
			if (other.project_sn != null)
				return false;
		} else if (!project_sn.equals(other.project_sn))
			return false;
		if (projectstatus == null) {
			if (other.projectstatus != null)
				return false;
		} else if (!projectstatus.equals(other.projectstatus))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (seats != other.seats)
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (upcheckTime == null) {
			if (other.upcheckTime != null)
				return false;
		} else if (!upcheckTime.equals(other.upcheckTime))
			return false;
		if (vSn == null) {
			if (other.vSn != null)
				return false;
		} else if (!vSn.equals(other.vSn))
			return false;
		if (vehicleQuality == null) {
			if (other.vehicleQuality != null)
				return false;
		} else if (!vehicleQuality.equals(other.vehicleQuality))
			return false;
		if (vin == null) {
			if (other.vin != null)
				return false;
		} else if (!vin.equals(other.vin))
			return false;
		return true;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
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

	public String getProjectstatus() {
		return projectstatus;
	}

	public void setProjectstatus(String projectstatus) {
		this.projectstatus = projectstatus;
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

	public String getCar_status() {
		return car_status;
	}

	public void setCar_status(String car_status) {
		this.car_status = car_status;
	}

	public String getUpcheckTime() {
		return upcheckTime;
	}

	public void setUpcheckTime(String upcheckTime) {
		this.upcheckTime = upcheckTime;
	}

	public String getBackchecktime() {
		return backchecktime;
	}

	public void setBackchecktime(String backchecktime) {
		this.backchecktime = backchecktime;
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEngineCapacity() {
		return engineCapacity;
	}

	public void setEngineCapacity(String engineCapacity) {
		this.engineCapacity = engineCapacity;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public String getVehicleQuality() {
		return vehicleQuality;
	}

	public void setVehicleQuality(String vehicleQuality) {
		this.vehicleQuality = vehicleQuality;
	}

	public String getEngineNumber() {
		return engineNumber;
	}

	public void setEngineNumber(String engineNumber) {
		this.engineNumber = engineNumber;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getLicendtime() {
		return licendtime;
	}

	public void setLicendtime(String licendtime) {
		this.licendtime = licendtime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	private String explanation; // 说明
	private String vSn; //
	private String project_sn;
	private String projectstatus;
	private String customer;
	private String projectEngineer;
	private String car_status;
	private String upcheckTime;
	private String backchecktime;
	private String brandModelone;
	private String brandModeltwo;

	private String color;

	private String type;

	private String engineCapacity;

	private int seats;

	private String vehicleQuality;

	private String engineNumber;

	private String vin;

	private String no;

	private String startTime;
	private String endTime;

	private String licenseNo;

	private String adminName;

	private String licendtime;

	private String remark;

	private String isremark;
	
	public ExcelCar(String explanation, String vSn, String project_sn, String projectstatus, String customer,
			String projectEngineer, String car_status, String upcheckTime, String backchecktime, String brandModelone,
			String brandModeltwo, String color, String type, String engineCapacity, int seats, String vehicleQuality,
			String engineNumber, String vin, String no, String startTime, String endTime, String licenseNo,
			String adminName, String licendtime, String remark) {
		super();
		this.explanation = explanation;
		this.vSn = vSn;
		this.project_sn = project_sn;
		this.projectstatus = projectstatus;
		this.customer = customer;
		this.projectEngineer = projectEngineer;
		this.car_status = car_status;
		this.upcheckTime = upcheckTime;
		this.backchecktime = backchecktime;
		this.brandModelone = brandModelone;
		this.brandModeltwo = brandModeltwo;
		this.color = color;
		this.type = type;
		this.engineCapacity = engineCapacity;
		this.seats = seats;
		this.vehicleQuality = vehicleQuality;
		this.engineNumber = engineNumber;
		this.vin = vin;
		this.no = no;
		this.startTime = startTime;
		this.endTime = endTime;
		this.licenseNo = licenseNo;
		this.adminName = adminName;
		this.licendtime = licendtime;
		this.remark = remark;
	}

	public ExcelCar() {
		super();
		// TODO Auto-generated constructor stub
	}

}
