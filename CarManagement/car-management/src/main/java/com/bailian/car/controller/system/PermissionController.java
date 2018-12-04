package com.bailian.car.controller.system;

import java.util.List;

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
import com.bailian.car.domain.system.Permission;
import com.bailian.car.emnu.OperationType;
import com.bailian.car.param.PerSearchParam;
import com.bailian.car.service.system.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "权限的相关操作")
@Controller
@RequestMapping("/permission")
@Scope("prototype")
public class PermissionController {

	@Autowired
	private PermissionService permissionService;

	/**
	 * 
	* @Title: permissionList
	* @Description: 分页
	* @param @return    参数
	* @return ModelAndView    返回类型
	* @throws
	 */
	@ApiOperation(value = "权限列表的查询")
	@RequestMapping("/permissionList.action")
	@ResponseBody
	public PageBean<Permission> permissionList(PageQuery pQuery, PerSearchParam PerSearchParam) {

		return permissionService.query(pQuery, PerSearchParam);

	}

	@ApiOperation(value = "权限的添加")
	@RequestMapping("/addPermission.action")
	@ResponseBody
	@SystemLog(medoule = "系统管理", methods = "增加权限", type = OperationType.ADD)
	public JsonData createPermission(@ApiParam(value = "权限数据模型") Permission permission) {

		return permissionService.add(permission);

	}

	@ApiOperation(value = "权限的删除")
	@RequestMapping("/deletePermission.action")
	@ResponseBody
	@SystemLog(medoule = "系统管理", methods = "删除权限", type = OperationType.DELETE)
	public JsonData deletePermission(@ApiParam(value = "权限的id数组") @RequestParam(value = "pids[]") String[] pids) {

		return permissionService.deletePermission(pids);
	}

	// 权限添加的校验(名称)
	@ApiOperation(value = "权限名称的校验")
	@RequestMapping("/checkPermissionByName.action")
	@ResponseBody
	public JsonData checkRoleByName(String name) {
		return permissionService.checkPermissionByName(name);
	}

	@ApiOperation(value = "权限关键字的校验")
	@RequestMapping("/checkPermissionBykeyWord.action")
	@ResponseBody
	public JsonData checkRoleBykeyWord(String keyWord) {
		return permissionService.checkPermissionBykeyWord(keyWord);
	}

	@RequestMapping("per_import.action")
	@ResponseBody
	public JsonData per_import(MultipartFile file) {
		return permissionService.per_import(file);
	}

	// 查询所有的权限不做分页
	@ApiOperation(value = "查询所有的权限未作分页")
	@RequestMapping("perList.action")
	@ResponseBody
	public List<Permission> perList() {
		return permissionService.findAll();
	}
}
