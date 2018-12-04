package com.bailian.car.controller.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bailian.car.beans.PageBean;
import com.bailian.car.beans.PageQuery;
import com.bailian.car.common.JsonData;
import com.bailian.car.domain.Log.SysLog;
import com.bailian.car.service.log.LogService;
import io.swagger.annotations.Api;

@Api(description = "日志查询")
@Controller
@RequestMapping(value = "/log")
@Scope("prototype")
public class LogController {
	@Autowired
	private LogService logService;

	@RequestMapping(value = "/delete.action")
	@ResponseBody
	public JsonData delete(String[] ids) {

		return logService.delete(ids);

	}

	@RequestMapping(value = "/findCarLog.action")
	@ResponseBody
	public PageBean<SysLog> findCarLog(PageQuery pageQuery) {
		return logService.findCarLog(pageQuery);

	}

	@RequestMapping(value = "/findCarDriverLog.action")
	@ResponseBody
	public PageBean<SysLog> findCarDriverLog(PageQuery pageQuery) {
		return logService.findCarDriverLog(pageQuery);

	}

	@RequestMapping(value = "/findCarMaintainLog.action")
	@ResponseBody
	public PageBean<SysLog> findCarMaintainLog(PageQuery pageQuery) {
		return logService.findCarMaintainLog(pageQuery);
	}

	@RequestMapping(value = "/findCarSystemLog.action")
	@ResponseBody
	public PageBean<SysLog> findCarSystemLog(PageQuery pageQuery) {
		return logService.findCarSystemLog(pageQuery);

	}
}
