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

/**
 * 
    * @ClassName: CarInsurance
    * @Description: 车辆保险
    * @author itastro
    * @date 2018年4月19日
    *
 */
@Entity
@Table(name = "t_insurance")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarInsurance implements Serializable {

	

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public String getAddPerson() {
		return addPerson;
	}

	public void setAddPerson(String addPerson) {
		this.addPerson = addPerson;
	}

	public String getInsNo() {
		return insNo;
	}

	public void setInsNo(String insNo) {
		this.insNo = insNo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setNumtime(Integer numtime) {
		this.numtime = numtime;
	}

	private static final long serialVersionUID = 7851247288570299836L;

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

	public String getBrandModeltwo() {
		return brandModeltwo;
	}

	public void setBrandModeltwo(String brandModeltwo) {
		this.brandModeltwo = brandModeltwo;
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

	public int getNumtime() {
		return numtime;
	}

	public void setNumtime(int numtime) {
		this.numtime = numtime;
	}

	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	public String getApplyPerson() {
		return applyPerson;
	}

	public void setApplyPerson(String applyPerson) {
		this.applyPerson = applyPerson;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getMakeTime() {
		return makeTime;
	}

	public void setMakeTime(Date makeTime) {
		this.makeTime = makeTime;
	}

	public String getVehicleInspection() {
		return vehicleInspection;
	}

	public void setVehicleInspection(String vehicleInspection) {
		this.vehicleInspection = vehicleInspection;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false, length = 11)
	private Integer id;

	private String vSn; // 车辆编号

	private String brandModeltwo; // 厂牌型号1 （来自车辆录入）

	@Column(columnDefinition = "varchar(50) default ''")
	private String insNo; // 保险编号
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date startTime; // 保险起始时间
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date endTime; // 保险结束时间

	private Integer numtime; // 期限

	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date applyTime; // 申请时间

	private String applyPerson; // 申请人

	private String remark; // 备注

	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date makeTime; // 保险制作日期
	@Builder.Default
	private String vehicleInspection = "未申请"; // 验车状态

	public Integer getLave() {

		if (endTime == null) {
			return lave;
		}
		if (startTime == null) {
			return lave;
		}
		Long etime = endTime.getTime();
		Long stime = new Date().getTime();
		Long l = etime - stime;
		lave = (int) (l / 1000 / 60 / 60 / 24);

		return lave;
	}

	public void setLave(Integer lave) {
		this.lave = lave;
	}

	private Integer lave; // 保险剩余时间
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date addtime; // 录入时间

	private String addPerson; // 录入人
}
