package com.bailian.car.domain.carcheckresult;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * 
    * @ClassName: EmsAndBomCheckResult
    * @Description: bom零部件检查结果类
    * @author itastro
    * @date 2018年5月15日
    *
 */
@Entity
@Table(name = "t_bom_result")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmsAndBomCheckResult implements Serializable{
	
	    
	private static final long serialVersionUID = 1L;

	public String getBomNum() {
		return bomNum;
	}

	public void setBomNum(String bomNum) {
		this.bomNum = bomNum;
	}


	public String getCheckExplanation() {
		return checkExplanation;
	}

	public void setCheckExplanation(String checkExplanation) {
		this.checkExplanation = checkExplanation;
	}

	public String getCheckingExplanation() {
		return checkingExplanation;
	}

	public void setCheckingExplanation(String checkingExplanation) {
		this.checkingExplanation = checkingExplanation;
	}

	public String getvSn() {
		return vSn;
	}

	public void setvSn(String vSn) {
		this.vSn = vSn;
	}

	

	public String getBomName() {
		return bomName;
	}

	public void setBomName(String bomName) {
		this.bomName = bomName;
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

	@Column(columnDefinition = "varchar(50) default ''")
	private String bomName; // bom检查名称
	@Column(columnDefinition = "varchar(20) default ''")
	private String bomNum; // 零部件号

	@Column(columnDefinition = "varchar(20) default ''")
	private String status; // 状态 : 是 否 NA


	@Column(columnDefinition = "varchar(50) default ''")
	private String checkExplanation; // 检查说明

	@Column(columnDefinition = "varchar(50) default ''")
	private String checkingExplanation; // 核对说明
	
}
