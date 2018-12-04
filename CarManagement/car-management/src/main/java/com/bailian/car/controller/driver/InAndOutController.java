package com.bailian.car.controller.driver;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bailian.car.beans.PageBean;
import com.bailian.car.beans.PageQuery;
import com.bailian.car.common.JsonData;
import com.bailian.car.domain.cardriver.InAndOut;
import com.bailian.car.domain.iccard.IccardUseHistory;
import com.bailian.car.exception.PermissionException;
import com.bailian.car.service.driver.InAndOutService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "api接口", description = "出入管理")
@RequestMapping("/inAndOut")
@Controller
public class InAndOutController {
	@Autowired
	private InAndOutService inAndOutService;

	@RequestMapping("/all.action")
	@ResponseBody
	@ApiOperation(value = "出入管理", notes = "出入管理查询")
	public PageBean<IccardUseHistory> getInAndOut(@ApiParam(value = "出入管理查询参数") PageQuery pQuery) {
		return inAndOutService.pageQuery(pQuery);
	}
	
	
	@RequestMapping("/newInAndOut.action")
	@ResponseBody
	@ApiOperation(value = "出入管理", notes = "出入管理查询")
	public IccardUseHistory getNewInAndOut() {
		return inAndOutService.getNewInAndOut();
	}

	@RequestMapping("/delete.action")
	@ResponseBody
	@ApiOperation(value = "出入管理", notes = "出入管理删除")
	public JsonData getInAndOut(@ApiParam(value = "出入管理删除参数") String[] ids) {
		try {
			return inAndOutService.delete(ids);
		} catch (Exception e) {
			throw new PermissionException("我去去就回");
		}

	}
}
