package com.bailian.car.controller.system;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bailian.car.annotation.SystemLog;
import com.bailian.car.common.JsonData;
import com.bailian.car.domain.system.Menu;
import com.bailian.car.domain.system.User;
import com.bailian.car.emnu.OperationType;
import com.bailian.car.exception.PermissionException;
import com.bailian.car.service.system.*;
import com.bailian.car.utils.TokenManagerUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "菜单相关操作")
@Controller
@RequestMapping("/menu")
@Scope("prototype")
public class MenuController {

	@Autowired
	private MenuService menuService;

	/**
	 * 
	* @Title: munuList
	* @Description: 查询所有的功能菜单
	* @param @return    参数  
	* @return ModelAndView    返回类型
	* @throws
	 */
	@ApiOperation(value = "菜单列表的展示")
	@RequestMapping("/menuList.action")
	@ResponseBody
	public List<Menu> munuList() {

		List<Menu> menuList = menuService.findByParentMenuIsNull();

		return menuList;
	}

	@ApiOperation(value = "查询当前用户的父菜单")
	@RequestMapping("/pmenuList.action")
	@ResponseBody
	public List<Menu> PList() {

		List<Menu> menuList = menuService.findPmenu();

		return menuList;
	}

	@ApiOperation(value = "查看当前用户的子菜单")
	@RequestMapping("/cmenuList.action")
	@ResponseBody
	public Set<Menu> cList(Integer pid) {
		Integer uid = TokenManagerUtils.getUserId();
		Set<Menu> menuList = menuService.findcmenu(uid, pid);

		return menuList;
	}

	@ApiOperation(value = "菜单栏的展示")
	@RequestMapping(value = "/showMenu.action", produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<Menu> showMenu() {
		// 获取当前用户的信息
		User user = TokenManagerUtils.getToken();
		if (user == null) {
			throw new PermissionException("请登录");
		}
		return menuService.findByUser(user);

	}

	// 添加菜单
	@SystemLog(medoule = "系统管理", methods = "添加菜单", type = OperationType.ADD)
	@RequestMapping(value = "/addMenu.action")
	public JsonData addMenu(Menu menu) {
		return menuService.save(menu);

	}

	//
	@SystemLog(medoule = "系统管理", methods = "删除菜单", type = OperationType.DELETE)
	@RequestMapping(value = "/deleteMenu.action")
	public JsonData deleteMenu(String mids) {
		return menuService.delete(mids);
	}
}