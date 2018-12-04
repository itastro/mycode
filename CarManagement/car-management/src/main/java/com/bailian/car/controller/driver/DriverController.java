package com.bailian.car.controller.driver;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.bailian.car.annotation.SystemLog;
import com.bailian.car.beans.PageBean;
import com.bailian.car.beans.PageQuery;
import com.bailian.car.common.JsonData;
import com.bailian.car.domain.cardriver.Driver;
import com.bailian.car.emnu.OperationType;
import com.bailian.car.param.DriverSearchParam;
import com.bailian.car.service.driver.DriverService;
import com.bailian.car.utils.BeanValidator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Controller
@RequestMapping("/driver")
@Scope("prototype")
@Api(value = "api接口", description = "驾驶员相关操作")
public class DriverController {
	@Autowired
	private DriverService driverService;

	// 驾驶员的添加
	@RequestMapping("/add.action")
	@SystemLog(medoule = "驾驶员管理", type = OperationType.ADD, methods = "添加驾驶员")
	@ResponseBody
	@ApiOperation(value = "驾驶员添加", notes = "根据传过来的驾驶员模型")
	public JsonData addCarDriver(@ApiParam(value = "驾驶员模型") Driver carDriver) {
		BeanValidator.check(carDriver);

		return driverService.add(carDriver);
	}

	// 驾驶员列表
	@RequestMapping("/CarDriverList.action")
	@ResponseBody
	@ApiOperation(value = "驾驶员列表", notes = "根据分页对象，以及查询参数;每页默认10条数据")
	public PageBean<Driver> carDriverList(@ApiParam(value = "分页参数") PageQuery pageQuery,
			@ApiParam(value = "查询参数") DriverSearchParam searchParam) {
		PageBean<Driver> pageResult = driverService.pageQuery(pageQuery, searchParam);
		return pageResult;
	}

	// 驾驶员的删除
	@RequestMapping("/delete.action")
	@SystemLog(medoule = "驾驶员管理", type = OperationType.DELETE, methods = "驾驶员删除")
	@ResponseBody
	@ApiOperation(value = "驾驶员删除", notes = "根据id数组")
	public JsonData delete(@RequestParam(value = "ids") @ApiParam(value = "删除参数") String[] ids) {
		return driverService.delete(ids);
	}

	// 驾驶员编辑的时候数据进行回显
	@RequestMapping("/edit.action")
	@ResponseBody
	public Driver edit(Integer id) {
		return driverService.findById(id);
	}

	// 驾驶员的更新
	@RequestMapping("/update.action")
	@SystemLog(medoule = "驾驶员管理", type = OperationType.UPDATE, methods = "驾驶员更新")
	@ResponseBody
	@ApiOperation(value = "驾驶员更新", notes = "根据驾驶员数据进行跟新")
	public JsonData updatedriver(@ApiParam(value = "驾驶员数据模型") Driver carDriver) {

		return driverService.updatedriver(carDriver);
	}

	// 对驾驶员进行授权，设置权限的时间
	@RequestMapping("/authorized.action")
	@SystemLog(medoule = "驾驶员管理", type = OperationType.UPDATE, methods = "驾驶员设置权限")
	@ResponseBody
	@ApiOperation(value = "授权、批量授权", notes = "根据驾驶员数据进行跟新")
	public JsonData authorized(@ApiParam(value = "id数组") String[] ids, @ApiParam(value = "起始时间") Date startTime,
			@ApiParam(value = "结束时间") Date endTime, String[] gid) {

		return driverService.authorized(ids, startTime, endTime, gid);

	}

	// 对驾驶员进行取消权限
	@RequestMapping("/cancelAuthorized.action")
	@SystemLog(medoule = "驾驶员管理", type = OperationType.UPDATE, methods = "取消驾驶员权限")
	@ResponseBody
	@ApiOperation(value = "单个取消授权、批量取消授权", notes = "根据驾驶员id数组")
	public JsonData cancelAuthorized(@ApiParam(value = "id数组") String[] ids, @ApiParam(value = "分组数组") String[] gids) {
		return driverService.cancelAuthorized(ids, gids);
	}

	// 驾驶员列表的导入
	@SuppressWarnings("unused")
	@RequestMapping("/driver_batchImport.action")
	@ResponseBody
	public JsonData batchImport(@RequestParam(value = "file") MultipartFile file) {
		String filename = file.getOriginalFilename();
		if (file != null) {

			return driverService.insertDBByExcel(file, filename);
		}
		return JsonData.fail("文件不能为空");

	}
}
