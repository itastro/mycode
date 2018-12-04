package com.bailian.car.domain.carcheckresult;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
    * @ClassName: HIesult
    * @Description: 线束检查结果
    * @author itastro
    * @date 2018年4月1日
    *
 */
@Entity
@Table(name = "t_h_result")
@ApiModel
public class HIResult implements Serializable {

	public String getPitem() {
		return pitem;
	}

	public void setPitem(String pitem) {
		this.pitem = pitem;
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

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getCheckExplanation() {
		return checkExplanation;
	}

	public void setCheckExplanation(String checkExplanation) {
		this.checkExplanation = checkExplanation;
	}

	private static final long serialVersionUID = 1L;

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
	@ApiModelProperty(value = "车辆编号")
	@NotBlank(message = "车辆编号不能为空")
	private String vSn; // 车辆编号
	@ApiModelProperty(value = "线束检查父项目")
	private String pitem; // 检查父项目
	@ApiModelProperty(value = "线束检查子项目")
	private String item; // 检查项目
	@ApiModelProperty(value = "线束检查状态")
	@Column(columnDefinition = "varchar(20) default ''")
	private String status; // 状态 : 是 否 NA

	@ApiModelProperty(value = "检查说明")
	@Column(columnDefinition = "varchar(50) default ''")
	private String checkExplanation; // 检查说明

	@ApiModelProperty(value = "核对说明")
	@Column(columnDefinition = "varchar(50) default ''")
	private String checkingExplanation; // 核对说明

}
