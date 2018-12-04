package com.bailian.car.controller.cars.insurance;

import java.util.List;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bailian.car.annotation.SystemLog;
import com.bailian.car.beans.PageBean;
import com.bailian.car.beans.PageQuery;
import com.bailian.car.common.JsonData;
import com.bailian.car.domain.cars.car.HistoryInsurance;
import com.bailian.car.dto.InsuranceDto;
import com.bailian.car.emnu.OperationType;
import com.bailian.car.exception.PermissionException;
import com.bailian.car.param.AddInsuranceParam;
import com.bailian.car.param.InsSearchParam;
import com.bailian.car.service.cars.insurance.InsuranceService;
import com.bailian.car.utils.BeanValidator;
import com.bailian.car.utils.JsonMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Api(description = "保险相关操作", value = "api接口")
@RequestMapping("/insurance")
@Controller
public class InsuranceController {

	@Autowired
	private InsuranceService insuranceService;

	@RequestMapping("/apply.action")
	@ResponseBody
	@ApiOperation(value = "申请保险/保险续保", notes = "根据车辆编号申请保险,同保险申请")
	@SystemLog(type = OperationType.APPLY, medoule = "车辆管理", methods = "保险申请")
	public JsonData applyInsurance(@ApiParam(value = "车辆编号数组") String[] vSns,
			@ApiParam(value = "保险期限") Integer numtime) {
		log.info("vSns:{},numtime:{}", vSns, numtime);

		try {
			return insuranceService.applyInsurance(vSns, numtime);
		} catch (UnauthorizedException e) {
			throw new PermissionException("当前用户不具工程师角色/保险申请权限");
		}

	}

	@RequestMapping("/addInsurance.action")
	@ResponseBody
	@ApiOperation(value = "保险录入", notes = "录入保险信息")
	@SystemLog(type = OperationType.ADD, medoule = "车辆管理", methods = "添加保险信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "vSn", value = "车辆编号", dataType = "String"),
			@ApiImplicitParam(name = "No", value = "保险编号", dataType = "String"),
			@ApiImplicitParam(name = "startTime", value = "起始时间", dataType = "Date"),
			@ApiImplicitParam(name = "endTime", value = "结束时间", dataType = "Date"),
			@ApiImplicitParam(name = "brandModeltwo", value = "厂牌型号（来自保险公司）", dataType = "String"),
			@ApiImplicitParam(name = "remark", value = "厂牌型号（来自保险公司）", dataType = "String") }) // remark
	public JsonData addInsurance(@RequestBody AddInsuranceParam addInsuranceParam) {
		log.info("addInsuranceParam:{}", JsonMapper.obj2String(addInsuranceParam));
		BeanValidator.check(addInsuranceParam);

		return insuranceService.addInsurance(addInsuranceParam);

	}

	@RequestMapping("/pageQuery.action")
	@ResponseBody
	@ApiOperation(value = "车辆保险列表", notes = "保险查询")
	@ApiImplicitParams({ @ApiImplicitParam(name = "page", value = "当前页", dataType = "int", defaultValue = "1"),
			@ApiImplicitParam(name = "size", value = "每页显示数量", dataType = "int", defaultValue = "10"),
			@ApiImplicitParam(name = "sort", value = "排序参数", dataType = "string"),
			@ApiImplicitParam(name = "sortOder", value = "排序命令", dataType = "string") })

	public PageBean<InsuranceDto> pageQuery(PageQuery pageQuery, InsSearchParam insSearchParam) {
		log.info("pageQuery:{}", pageQuery);
		return insuranceService.pageQuery1(pageQuery, insSearchParam);

	}

	// 查询这辆车的保险信息
	@RequestMapping("/findByvSn/{vSn}.action")
	@ResponseBody
	@ApiOperation(value = "车辆辆保险记录查询", notes = "单个车辆保险查询")
	public List<HistoryInsurance> findByvSn(@PathVariable String vSn) {

		return insuranceService.findByvSn(vSn);

	}

	// 保险修改
	@RequestMapping("/updateInsurance.action")
	@ResponseBody
	@ApiOperation(value = "车辆辆保险修改", notes = "保险修改")
	@SystemLog(type = OperationType.UPDATE, medoule = "车辆管理", methods = "保险信息修改")
	public JsonData updateInsurance(@RequestBody AddInsuranceParam InsuranceParam) {
		log.info("InsuranceParam:{}", JsonMapper.obj2String(InsuranceParam));
		BeanValidator.check(InsuranceParam);
		return insuranceService.updateInsurance(InsuranceParam);

	}

}
