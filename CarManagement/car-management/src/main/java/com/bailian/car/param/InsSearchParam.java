package com.bailian.car.param;

import java.io.Serializable;

/**
 * 
    * @ClassName: InsSearchParam
    * @Description: 保险搜索参数
    * @author itastro
    * @date 2018年6月21日
    *
 */
public class InsSearchParam implements Serializable {

	

	public String getIstatus() {
		return istatus;
	}

	public void setIstatus(String istatus) {
		this.istatus = istatus;
	}

	public String getVehicleInspection() {
		return vehicleInspection;
	}

	public void setVehicleInspection(String vehicleInspection) {
		this.vehicleInspection = vehicleInspection;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getInsNo() {
		return insNo;
	}

	public void setInsNo(String insNo) {
		this.insNo = insNo;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getEngineNumber() {
		return engineNumber;
	}

	public void setEngineNumber(String engineNumber) {
		this.engineNumber = engineNumber;
	}

	public String getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 1L;

	public String getIendTime() {
		return iendTime;
	}

	public void setIendTime(String iendTime) {
		this.iendTime = iendTime;
	}

	public String getvSn() {
		return vSn;
	}

	public void setvSn(String vSn) {
		this.vSn = vSn;
	}

	private String vSn; // 车辆编号

	private String iendTime; // 保险终止日

	private String updateTime; // 保险更新日期

	private String insNo; // 保险编号

	private String applyTime; // 保险申请日

	private String engineNumber; // 发动机号

	private String vin; // 车架号

	private String customer; // 客户
	
    private String istatus;  //保险状态
	
	private  String  vehicleInspection;  //验车状态

}
