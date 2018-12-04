package com.bailian.car.param;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Builder;

/**
 * 
    * @ClassName: AddInsuranceParam
    * @Description: 添加保险参数
    * @author itastro
    * @date 2018年6月21日
    *
 */
@Builder
public class AddInsuranceParam implements Serializable{

	public String getInsNo() {
		return insNo;
	}

	public void setInsNo(String insNo) {
		this.insNo = insNo;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getvSn() {
		return vSn;
	}

	public void setvSn(String vSn) {
		this.vSn = vSn;
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

	public String getBrandModeltwo() {
		return brandModeltwo;
	}

	public void setBrandModeltwo(String brandModeltwo) {
		this.brandModeltwo = brandModeltwo;
	}

	@NotBlank(message = "车辆编号不能为空")
	private String vSn; // 车辆编号
	@NotBlank(message = "保险编号不能为空")
	private String insNo;

	private Date startTime; // 保险起始时间

	private Date endTime; // 保险接受时间
	@NotBlank(message = "厂牌型号不能为空")
	private String brandModeltwo; // 厂牌型号2 （来自保险）

	private String remark;

}
