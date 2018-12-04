package com.bailian.car.param;
import java.io.Serializable;
import java.util.Date;
import org.hibernate.validator.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
/**
 * 
    * @ClassName: LicenseParam
    * @Description:车辆牌照添加参数
    * @author itastro
    * @date 2018年6月21日
    *
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LicenseParam implements Serializable {

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	private static final long serialVersionUID = 1L;

	public Date getLicenseEndTime() {
		return licenseEndTime;
	}

	public void setLicenseEndTime(Date licenseEndTime) {
		this.licenseEndTime = licenseEndTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getWhether() {
		return whether;
	}

	public void setWhether(String whether) {
		this.whether = whether;
	}

	public String getvSn() {
		return vSn;
	}

	public void setvSn(String vSn) {
		this.vSn = vSn;
	}

	

	@NotBlank(message = "车辆编号不能为空")
	private String vSn;
	// @NotNull(message = "牌照结束日期不能为空")
	private Date licenseEndTime;
	@NotBlank(message = "车牌号不能为空")
	private String licenseNo; // 车牌号

	private String remark;
	@NotBlank(message = "是否拿到临牌不能为空")
	private String whether;

}
