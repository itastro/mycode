package com.bailian.car.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @ClassName: LedResult
 * @Description: 进出大门LED返回结果集
 * @author itastro
 * @date 2018年9月30日
 *
 */
/**
 * 
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LedResult {
	@Builder.Default
	private String carCode="";   //车辆编号
	@Builder.Default
	private String driver="";   //驾驶员名称
	
	private Integer driverAuth;   //驾驶员是否授权
	
	private Integer carAuth;   //车辆是否授权
	
	private Integer  cardType;  //车辆卡类型
	
	private String reason;  //原因
	
	private Integer in;
	

}
