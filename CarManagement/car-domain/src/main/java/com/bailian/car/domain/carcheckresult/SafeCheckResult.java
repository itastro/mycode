package com.bailian.car.domain.carcheckresult;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 
    * @ClassName: SafeCheckResult
    * @Description: 安全检查结果
    * @author itastro
    * @date 2018年5月15日
    *
 */
@Entity
@Table(name = "t_safe_result")
public class SafeCheckResult implements Serializable{

	    
	public String getConfirmExplanation() {
		return confirmExplanation;
	}

	public void setConfirmExplanation(String confirmExplanation) {
		this.confirmExplanation = confirmExplanation;
	}

	private static final long serialVersionUID = 1L;

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public String getvSn() {
		return vSn;
	}

	public void setvSn(String vSn) {
		this.vSn = vSn;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getCheckingExplanation() {
		return checkingExplanation;
	}

	public void setCheckingExplanation(String checkingExplanation) {
		this.checkingExplanation = checkingExplanation;
	}

	public String getCheckExplanation() {
		return checkExplanation;
	}

	public void setCheckExplanation(String checkExplanation) {
		this.checkExplanation = checkExplanation;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid") // 这个是hibernate的注解/生成32位UUID
	@GeneratedValue(generator = "idGenerator")
	private String uuid;

	@NotBlank(message = "车辆编号不能为空")
	private String vSn; // 车辆编号

	private String request; // 要求
	
	@Column(columnDefinition = "varchar(20) default ''")
	private String status; // 状态： 是 否 NA

	private String item; // 检查项目

	private String checkExplanation; // 检查说明

	private String checkingExplanation; // 核对说明
	
	private String confirmExplanation; // 确认说明
	

}
