package com.bailian.car.controller.cars.develop;

import java.util.Date;
import java.util.List;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bailian.car.annotation.SystemLog;
import com.bailian.car.common.JsonData;
import com.bailian.car.domain.cars.develop.DevelopToolsRecord;
import com.bailian.car.emnu.OperationType;
import com.bailian.car.exception.PermissionException;
import com.bailian.car.service.cars.develop.DevelopToolsRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Api(description = "研发工具")
@RequestMapping(value = "/car/develop")
@Scope("prototype")
@Controller
public class DevelopToolsRecordController {

	@Autowired
	private DevelopToolsRecordService developToolsRecordService;

	@RequestMapping("/developEquipment.action")
	@SystemLog(type = OperationType.ADD, medoule = "车辆管理", methods = "研发装备操作")
	@ResponseBody
	@ApiOperation(value = "研发工具装备", notes = "装备")
	public JsonData developEquipment(Integer did, Date equippedDate, String remark) {
		log.info("did:{},equippedDate:{},remark:{}", did, equippedDate, remark);
		try {
			return developToolsRecordService.developEquipment(did, equippedDate, remark);
		} catch (UnauthorizedException e) {
			throw new PermissionException("当前用户不具备权限");
		}

		

	}

	@RequestMapping("/toolsRemove.action")
	@SystemLog(type = OperationType.DELETE, medoule = "车辆管理", methods = "研发工具删除")
	@ResponseBody
	@ApiOperation(value = "研发工具装备拆除", notes = "拆除")
	public JsonData toolsRemove(Integer did) {

		return developToolsRecordService.toolsRemove(did);

	}

	@RequestMapping("/find/{vSn}.action")
	@ResponseBody
	@ApiOperation(value = "研发工具装备查看", notes = "查看")
	public List<DevelopToolsRecord> find(@PathVariable String vSn) {

		return developToolsRecordService.findDevelopToolsRecordByvSn(vSn);

	}

}
