package com.bailian.car.domain.carcheck;

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
    * @ClassName: SystemCheck
    * @Description: 系统检查确认类
    * @author itastro
    * @date 2018年3月31日
    *
 */
@Entity
@Table(name = "t_systemcheck")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SystemCheck implements Serializable{

	private static final long serialVersionUID = 1L;

	public Date getCheckingTime() {
		return checkingTime;
	}

	public void setCheckingTime(Date checkingTime) {
		this.checkingTime = checkingTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getvSn() {
		return vSn;
	}

	public void setvSn(String vSn) {
		this.vSn = vSn;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCheckingPerson() {
		return checkingPerson;
	}

	public void setCheckingPerson(String checkingPerson) {
		this.checkingPerson = checkingPerson;
	}

	public String getCheckPerson() {
		return checkPerson;
	}

	public void setCheckPerson(String checkPerson) {
		this.checkPerson = checkPerson;
	}

	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false, length = 11)

	private Integer id;

	private String vSn; // 车辆编号

	private String status; // 检查状态

	@Column(columnDefinition = "varchar(20) default ''")
	private String checkingPerson; // 核对人

	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date checkingTime; // 核对时间

	@Column(columnDefinition = "varchar(50) default ''")
	private String checkPerson; // 检查人

	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date checkTime; // 检查时间

}
