package com.bailian.car.param;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 
    * @ClassName: CarmaintainAssign
    * @Description: 维修任务分配传入参数
    * @author itastro
    * @date 2018年6月21日
    *
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class CarmaintainAssign implements Serializable {

	private static final long serialVersionUID = 1L;

	public String getForecastTime() {
		return forecastTime;
	}

	public void setForecastTime(String forecastTime) {
		this.forecastTime = forecastTime;
	}

	// 任务分配
	public String getOperatorTEL() {
		return operatorTEL;
	}

	public void setOperatorTEL(String operatorTEL) {
		this.operatorTEL = operatorTEL;
	}

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

	public String getWorkContent() {
		return workContent;
	}

	public void setWorkContent(String workContent) {
		this.workContent = workContent;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	private Integer id;
	@NotBlank(message = "车辆编号不能为空")
	private String vSn;

	private String forecastTime;
	@NotBlank(message = "工作内容不能为空")
	private String workContent;
	@NotBlank(message = "操作人不能为空")

	private String operator;

	@NotBlank(message = "操作人电话不能为空")
	private String operatorTEL;

}
