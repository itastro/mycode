package com.bailian.car.param;

import java.io.Serializable;

import com.bailian.car.beans.PageBean;
import com.bailian.car.domain.carmaintain.Screen;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
    * @ClassName: ScreenResult
    * @Description: 维修大屏结果集
    * @author itastro
    * @date 2018年6月21日
    *
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ScreenResult implements Serializable {

	private static final long serialVersionUID = 1L;

	private PageBean<Screen> pageBean;

	private String currentpercentage;

	private String completepercentage;

	private String queuepercentage;

	private float count; // 维修总数

	private float current; // 维修中

	private float complete; // 维修完成

	private float queue; // 排队中

}
