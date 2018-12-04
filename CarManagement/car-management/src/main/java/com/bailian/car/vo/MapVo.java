package com.bailian.car.vo;

public class MapVo {
	
	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getTowards() {
		return towards;
	}

	public void setTowards(String towards) {
		this.towards = towards;
	}

	public String getvSn() {
		return vSn;
	}

	public void setvSn(String vSn) {
		this.vSn = vSn;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	private String vSn;
	
	private String longitude; // 经度

	private String latitude; // 维度 
	
	private String driverName;  //驾驶员姓名
	
	private String towards;   //朝向
	
	private String licenseNo;

}
