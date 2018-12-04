package com.bailian.car.param;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
/**
 * 
    * @ClassName: CarmaintainComplete
    * @Description: 维修完成传入参数
    * @author itastro
    * @date 2018年6月21日
    *
 */
public class CarmaintainComplete implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	@NotBlank(message = "车辆编号不能为空")
	private String vSn;
	@NotBlank(message = "停发地点不能为空")
	private String fin_park;
	private String remark;

}
