package com.bailian.car.controller.cars.car;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bailian.car.annotation.SystemLog;
import com.bailian.car.common.JsonData;
import com.bailian.car.domain.cars.car.CarAdmin;
import com.bailian.car.emnu.OperationType;
import com.bailian.car.service.cars.car.CarAdminService;
import com.bailian.car.utils.BeanValidator;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(description = "车管增删改查")
@Controller
@RequestMapping("/caradmin")
public class CarAdminController {

	@Autowired
	private CarAdminService carAdminService;

	@RequestMapping("/add.action")
	@ResponseBody
	@SystemLog(type = OperationType.ADD, medoule = "系统管理", methods = "添加车管")
	@ApiOperation(value = "车管增加")
	public JsonData save(@ApiParam(value = "车管模型") CarAdmin carAdmin) {
		BeanValidator.check(carAdmin);
		return carAdminService.save(carAdmin);

	}

	@RequestMapping("/delete.action")
	@ResponseBody
	@SystemLog(type = OperationType.DELETE, medoule = "系统管理", methods = "删除车管 ")
	@ApiOperation(value = "车管删除")
	public JsonData delete(@ApiParam(value = "车管id数组") String[] ids) {

		if (ids == null) {
			return JsonData.fail("请你选择一个车管");
		}

		if (ids.length <= 0) {
			return JsonData.fail("请你选择一个车管");
		}
		return carAdminService.delete(ids);
	}

	@RequestMapping("/find.action")
	@ResponseBody
	@ApiOperation(value = "车管查询")
	public List<CarAdmin> find() {

		return carAdminService.find();
	}

	@RequestMapping("/update.action")
	@ResponseBody
	@ApiOperation(value = "车管更新")
	@SystemLog(type = OperationType.UPDATE, medoule = "系统管理", methods = "更新车管")
	public JsonData update(@ApiParam(value = "车管模型") CarAdmin carAdmin) {

		return carAdminService.update(carAdmin);
	}

}
