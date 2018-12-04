package com.bailian.car.controller.oil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.bailian.car.beans.PageBean;
import com.bailian.car.beans.PageQuery;
import com.bailian.car.common.JsonData;
import com.bailian.car.domain.cars.car.OilCard;
import com.bailian.car.param.AddOilParam;
import com.bailian.car.param.OilSearch;
import com.bailian.car.service.oil.OilService;
import com.bailian.car.utils.JsonMapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Api(description = "油卡相关操作")
@RequestMapping("/oil")
@Controller
public class OilCardController {

	@Autowired
	private OilService oilService;

	// 导入油卡信息
	@RequestMapping("/batchimport.action")
	@ResponseBody
	@ApiOperation(value = "油卡导入")
	public JsonData batchimport(MultipartFile file) throws Exception {
		return oilService.oil_batchimport(file);
	}

	// 查询油卡信息
	@RequestMapping("/query.action")
	@ResponseBody
	@ApiOperation("查询油卡信息")
	public PageBean<OilCard> query(PageQuery pQuery, OilSearch oilSearch) {
		log.info("oilSearch:{}", JsonMapper.obj2String(oilSearch));
		return oilService.query(pQuery, oilSearch);
	}

	// 填写油卡信息
	@ApiOperation(value = "油卡信息填写")
	@RequestMapping("/save.action")
	@ResponseBody
	public JsonData save(@RequestBody AddOilParam aParam) {
		log.info("aParam:{}", JsonMapper.obj2String(aParam));
		return oilService.save(aParam);
	}
}
