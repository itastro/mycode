package com.bailian.car.param;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * 
    * @ClassName: ApplyTools
    * @Description: 申请研发工具参数
    * @author itastro
    * @date 2018年6月21日
    *
 */

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApplyTools implements Serializable {

	private static final long serialVersionUID = 1L;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getToolName() {
		return toolName;
	}

	public void setToolName(String toolName) {
		this.toolName = toolName;
	}

	public String getApplicant() {
		return applicant;
	}

	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}

	public String getvSn() {
		return vSn;
	}

	public void setvSn(String vSn) {
		this.vSn = vSn;
	}

	private Integer id;

	private String toolName; // 工具名称

	private String applicant; // 申请人

	private String vSn; // 车辆编号
}
