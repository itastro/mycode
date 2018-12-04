package com.bailian.car.domain.cars.carmaintenance;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
    * @ClassName: VehicleMaintenanceRecords
    * @Description: TODO车辆保养
    * @author itastro
    * @date 2018年4月16日
    *
 */
@Entity
@Table(name = "t_vmr")
public class VehicleMaintenanceRecords implements Serializable {

	public Date getOperatorTime() {
		return operatorTime;
	}

	public void setOperatorTime(Date operatorTime) {
		this.operatorTime = operatorTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getvSn() {
		return vSn;
	}

	public void setvSn(String vSn) {
		this.vSn = vSn;
	}

	public String getMaintenanceMileage() {
		return maintenanceMileage;
	}

	public void setMaintenanceMileage(String maintenanceMileage) {
		this.maintenanceMileage = maintenanceMileage;
	}

	private static final long serialVersionUID = 654311424448004420L;

	public List<MaintenanceItem> getMaintenanceItem() {
		return maintenanceItem;
	}

	public void setMaintenanceItem(List<MaintenanceItem> maintenanceItem) {
		this.maintenanceItem = maintenanceItem;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getMaintenanceTime() {
		return maintenanceTime;
	}

	public void setMaintenanceTime(Date maintenanceTime) {
		this.maintenanceTime = maintenanceTime;
	}

	public Date getNextMaintenanceTime() {
		return nextMaintenanceTime;
	}

	public void setNextMaintenanceTime(Date nextMaintenanceTime) {
		this.nextMaintenanceTime = nextMaintenanceTime;
	}

	public String getMaintenanceOperator() {
		return maintenanceOperator;
	}

	public void setMaintenanceOperator(String maintenanceOperator) {
		this.maintenanceOperator = maintenanceOperator;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "C_ID", unique = true, nullable = false, length = 11)
	private Integer id;
	
	private String vSn;  //车辆编号
	
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date maintenanceTime; // 保养时间

	private String maintenanceMileage; // 保养里程

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date nextMaintenanceTime; // 下次保养时间
	@Column(columnDefinition = "varchar(20) default ''")
	private String maintenanceOperator; // 保养操作人
	
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date operatorTime;

	@OneToMany
	@JoinColumn(name = "VMR_ID")   //保养项目
	private List<MaintenanceItem> maintenanceItem = new ArrayList<MaintenanceItem>();

}
