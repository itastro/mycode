package com.bailian.car.param;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
    * @ClassName: CarmaintainApply
    * @Description: 维修申请参数
    * @author itastro
    * @date 2018年6月21日
    *
 */
@ApiModel
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CarmaintainApply implements Serializable {

	private static final long serialVersionUID = 1L;

	// 维修申请
	private Integer id;

	@ApiModelProperty(value = "车辆编号")
	@NotBlank(message = "车辆编号不能为空")
	private String vSn;
	@ApiModelProperty(value = "停放地点")
	@NotBlank(message = "停放地地点不能为空")
	private String send_park;
	@ApiModelProperty(value = "维修项目")
	@NotBlank(message = "维修项目不能为空")
	private String item;
	@ApiModelProperty(value = "维修备注")
	private String applyRemark;
	@NotBlank(message = "申请电话不能为空")
	private String applyTEL;

}
