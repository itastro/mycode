package com.bailian.car.controller.driver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bailian.car.annotation.SystemLog;
import com.bailian.car.common.JsonData;
import com.bailian.car.domain.cardriver.DriverGroup;
import com.bailian.car.emnu.OperationType;
import com.bailian.car.service.driver.DriverGroupService;
import com.bailian.car.utils.BeanValidator;
import com.bailian.car.utils.JsonMapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/driver/group")
@Api(value = "api接口", description = "驾驶员分组")
public class GroupController {

	@Autowired
	private DriverGroupService driverGroupService;

	@RequestMapping("/add.action")
	@ResponseBody
	@ApiOperation(value = "添加分组", notes = "分组数据模型")
	@SystemLog(type = OperationType.ADD, medoule = "驾驶员管理", methods = "添加驾驶员分组")
	public JsonData save(@ApiParam(value = "分组模型") DriverGroup group) {
		log.info("group:{}", JsonMapper.obj2String(group));
		BeanValidator.check(group);
		driverGroupService.save(group);
		return JsonData.success("添加成功分组");

	}

	@RequestMapping("/getGroup.action")
	@ResponseBody
	@ApiOperation(value = "获取分组", notes = "分组")
	public List<DriverGroup> getGroup() {

		return driverGroupService.getGroup();

	}

	// 驾驶员分组删除
	@RequestMapping("/deleteGroup.action")
	@ResponseBody
	@ApiOperation(value = "删除分组", notes = "分组")
	@SystemLog(type = OperationType.DELETE, medoule = "驾驶员管理", methods = "驾驶员分组的删除")
	public JsonData deleteGroup(@ApiParam(value = "分组id") String[] ids) {
		return driverGroupService.deleteGroup(ids);
	}

	// 修改驾驶员分组名称
	@RequestMapping("/updateGroup.action")
	@ResponseBody
	@SystemLog(type = OperationType.UPDATE, medoule = "驾驶员管理", methods = "驾驶员分组的删除")
	@ApiOperation(value = "修改分组", notes = "分组")
	public JsonData updateGroup(DriverGroup dGroup) {

		BeanValidator.check(dGroup);
		return driverGroupService.updateGroup(dGroup);
	}
}
