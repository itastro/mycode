package com.bailian.car.controller.cars.maintenance;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bailian.car.annotation.SystemLog;
import com.bailian.car.common.JsonData;
import com.bailian.car.domain.cars.carmaintenance.MaintenanceItem;
import com.bailian.car.domain.cars.carmaintenance.VehicleMaintenanceRecords;
import com.bailian.car.emnu.OperationType;
import com.bailian.car.exception.PermissionException;
import com.bailian.car.service.cars.maintenance.MaintenanceService;
import com.bailian.car.utils.JsonMapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

@Api(value = "api接口", description = "车辆保养")
@Controller
@RequestMapping(value = "/car/maintenance")
@Scope("prototype")
@Slf4j
public class MaintenanceController {

	@Autowired
	private MaintenanceService maintenanceService;

	@RequestMapping(value = "save/{vSn}/{mm}/{nt}/{mid}.action")
	@ResponseBody
	@ApiOperation(value = "保养记录保存")
	@SystemLog(type = OperationType.ADD, medoule = "车辆管理", methods = "添加保养记录")
	public JsonData SaveMaintenance(@PathVariable(required = true) @ApiParam(value = "车辆编号") String vSn,
			@PathVariable @ApiParam(value = "保养里程") String mm, @PathVariable @ApiParam(value = "下次保养时间") String nt,
			@PathVariable @ApiParam(value = "id") Integer mid,
			@RequestBody @ApiParam(value = "保养项目") List<MaintenanceItem> maintenanceItems) {

		log.info("vSn:{},mm:{},nt:{}", vSn, mm, JsonMapper.obj2String(maintenanceItems));
		try {
			return maintenanceService.save(vSn, mm, nt, mid, maintenanceItems);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			throw new PermissionException("时间转换异常");
		} catch (Exception e) {
			throw new PermissionException("系统开小差了");
		}

	}

	@RequestMapping(value = "getMaintenance.action")
	@ResponseBody
	@ApiOperation(value = "查询这个车辆的所有保养记录")
	public List<VehicleMaintenanceRecords> findByvSn(@ApiParam(value = "车辆编号") String vSn) {

		log.info("vSn:{}", vSn);

		return maintenanceService.getMaintenanceByvSn(vSn);

	}

	@RequestMapping(value = "delete.action")
	@SystemLog(type = OperationType.DELETE, medoule = "车辆管理", methods = "删除车辆保养")
	@ResponseBody
	@ApiOperation(value = "删除车辆保养记录", notes = "可以删除单个、可以进行批量删除")
	public JsonData delete(@ApiParam(value = "车辆id数组") String[] ids) {

		return maintenanceService.delete(ids);
	}

}
