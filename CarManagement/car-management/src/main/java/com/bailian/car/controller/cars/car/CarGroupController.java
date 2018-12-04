package com.bailian.car.controller.cars.car;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bailian.car.annotation.SystemLog;
import com.bailian.car.common.JsonData;
import com.bailian.car.domain.cars.car.CarGroup;
import com.bailian.car.emnu.OperationType;
import com.bailian.car.exception.ParamException;
import com.bailian.car.service.cars.car.CarGroupSrrvice;
import com.bailian.car.utils.BeanValidator;
import com.bailian.car.utils.JsonMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Api(value = "车辆分组", description = "车辆分组")
@Controller
@RequestMapping("/group")
@Scope("prototype")
public class CarGroupController {
	@Autowired
	private CarGroupSrrvice carGroupSrrvice;

	@RequestMapping("/add.action")
	// @SystemLog(type = OperationType.ADD, medoule = "车辆管理", methods = "添加车辆分组")
	@ResponseBody
	@ApiOperation(value = "添加车辆分组", notes = "车辆分组数据模型")
	@SystemLog(type = OperationType.ADD, medoule = "车辆管理", methods = "添加车辆分组")
	public JsonData addGroup(@ApiParam(value = "分组模型") @RequestBody CarGroup group) {

		log.info("group:{}", JsonMapper.obj2String(group));
		BeanValidator.check(group);
		CarGroup group1 = carGroupSrrvice.findByName(group.getName());

		if (group1 != null) {
			return JsonData.fail("此分组分组已经存在");
		}
		try {
			return carGroupSrrvice.add(group);
		} catch (Exception e) {
			// TODO: handle exception
			throw new ParamException("添加车辆分组失败");
		}
	}

	@RequestMapping("/getGroup.action")
	@ApiOperation(value = "查询所有的车辆分组")
	@ResponseBody
	public List<CarGroup> list() {
		List<CarGroup> list = carGroupSrrvice.findAll();
		return list;
	}

	@RequestMapping("/delete.action")
	@SystemLog(type = OperationType.DELETE, medoule = "车辆管理", methods = "删除车辆分组")
	@ResponseBody
	@ApiOperation(value = "删除车辆分组")
	public JsonData delete(@ApiParam(value = "id数组") String[] gids) {
		log.info("gids:{}", JsonMapper.obj2String(gids));
		if (gids == null) {
			return JsonData.fail("请选择分组");
		}
		if (gids.length <= 0) {
			return JsonData.fail("请选择分组");
		}
		carGroupSrrvice.delete(gids);
		return JsonData.success("成功");
	}

	@RequestMapping("/update.action")
	@SystemLog(type = OperationType.UPDATE, medoule = "车辆管理", methods = "更新车辆分组")
	@ResponseBody
	@ApiOperation(value = "更新车辆分组")
	public JsonData update(@ApiParam(value = "车辆分组数据模型") @RequestBody CarGroup carGroup) {
		BeanValidator.check(carGroup);
		try {
			return carGroupSrrvice.update(carGroup);
		} catch (Exception e) {
			// TODO: handle exception
			throw new ParamException("更新失败");
		}

	}
}
