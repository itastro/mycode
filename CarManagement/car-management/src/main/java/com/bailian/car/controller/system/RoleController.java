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
import com.bailian.car.domain.system.Menu;
import com.bailian.car.domain.system.Permission;
import com.bailian.car.domain.system.Role;
import com.bailian.car.emnu.OperationType;
import com.bailian.car.param.RoleSearchParam;
import com.bailian.car.service.system.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
@Api(value = "角色相关操作")
@Controller
@Scope("prototype")
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@Autowired
	private MenuService menuService;

	@Autowired
	private PermissionService permissionService;

	/**
	 * 
	    * @Title: addRole
	    * @Description: 添加角色
	    * @param @param role
	    * @param @return    参数
	    * @return JsonData    返回类型
	    * @throws
	 */

	@RequestMapping("/addRole.action")
	@ResponseBody
	@ApiOperation(value = "添加加色/角色添加时可以进行权限与菜单的关联")
	@SystemLog(medoule = "系统管理", methods = "添加角色", type = OperationType.ADD)
	public JsonData addRole(@ApiParam(value = "角色数据模型") Role role,
			@ApiParam(value = "权限id数组") @RequestParam(value = "pids[]", required = false) String[] permissionIds,
			@ApiParam(value = "菜单id数组") @RequestParam(value = "mids") String menuIds) {

		return roleService.add(role, permissionIds, menuIds);

	}

	@ApiOperation(value = "查看当前角色未关联的菜单")
	@RequestMapping("/findCurrentRoleIsNotRelatedMenu.action")
	@ResponseBody
	public List<Menu> findCurrentRoleIsNotRelatedMenu(Integer rid) {
		List<Menu> list = roleService.findCurrentRoleIsNotRelatedMenu(rid);
		return list;
	}

	@ApiOperation(value = "查看当前角色未关联的权限")
	@RequestMapping("/findCurrentRoleIsNotRelatedPre.action")
	@ResponseBody
	public List<Permission> findCurrentRoleIsNotRelatedPre(Integer rid) {
		List<Permission> list = roleService.findCurrentRoleIsNotRelatedPer(rid);
		return list;
	}

	/**
	 * 
	    * @Title: roleList
	    * @Description: 校色列表
	    * @param @param pQuery
	    * @param @param rSearchParam
	    * @param @return    参数
	    * @return PageBean<Role>    返回类型
	    * @throws
	 */
	@ApiOperation(value = "角色列表")
	@RequestMapping("/roleList.action")
	@ResponseBody
	public PageBean<Role> roleList(PageQuery pQuery, RoleSearchParam rSearchParam) {

		return roleService.query(pQuery, rSearchParam);

	}

	@RequestMapping("/deleteRole.action")
	@ResponseBody
	@ApiOperation(value = "删出角色")
	@SystemLog(medoule = "系统管理", methods = "删除角色", type = OperationType.DELETE)
	public JsonData deleteRole(@RequestParam(value = "rids[]", required = false) String[] roleIds) {
		JsonData jsonData = roleService.delete(roleIds);

		return jsonData;

	}

	// 角色关联权限
	@RequestMapping("/roleRelatedPermission.action")
	@ApiOperation(value = "角色关联权限")
	@SystemLog(medoule = "系统管理", methods = "角色关联权限", type = OperationType.UPDATE)
	@ResponseBody
	public JsonData roleRelatedPermission(@ApiParam(value = "角色id") Integer rid,
			@ApiParam(value = "权限id,如果多个以字符串拼接的形式") String[] pids) {

		return roleService.roleRelatedPermissionId(rid, pids);

	}

	@RequestMapping("/bacthRoleRelatedPermission.action")
	@ApiOperation(value = "批量角色关联权限")
	@SystemLog(medoule = "系统管理", methods = "角色关联权限", type = OperationType.UPDATE)
	@ResponseBody
	// 批量角色关联权限
	public JsonData bacthRoleRelatedPermission(@ApiParam(value = "角色id") String[] rid,
			@ApiParam(value = "权限id,如果多个以字符串拼接的形式") String[] pids) {

		return roleService.bacthRoleRelatedPermission(rid, pids);

	}

	// 角色关联菜单
	@ApiOperation(value = "角色关关联菜单")
	@RequestMapping("/roleRelatedMenu.action")
	@SystemLog(medoule = "系统管理", methods = "角色关联菜单", type = OperationType.UPDATE)
	@ResponseBody
	public JsonData roleRelatedMenu(@ApiParam(value = "角色id") Integer rid,
			@ApiParam(value = "菜单id,如果多个以字符串拼接的形式") String[] mids) {

		return roleService.roleRelatedMenu(rid, mids);

	}

	@RequestMapping("/bacthRoleRelatedMenu.action")
	@ApiOperation(value = "批量角色关联菜单")
	@SystemLog(medoule = "系统管理", methods = "角色关联权限", type = OperationType.UPDATE)
	@ResponseBody
	// 批量角色关联菜单
	public JsonData bacthRoleRelatedMenu(@ApiParam(value = "角色id") String[] rid,
			@ApiParam(value = "菜单id,如果多个以字符串拼接的形式") String[] mids) {

		return roleService.bacthRoleRelatedMenu(rid, mids);

	}

	// 校色添加的校验(名称)
	@ApiOperation(value = "添加角色时，对角色民称进行校验")
	@RequestMapping("/checkRoleByName.action")
	@ResponseBody
	public JsonData checkRoleByName(@ApiParam(value = "名称") String name) {
		return roleService.checkRoleByName(name);
	}

	// 校色添加的校验(关键字)
	@ApiOperation(value = "添加角色时，对角色关键字进行校验")
	@RequestMapping("/checkRoleBykeyWord.action")
	@ResponseBody
	public JsonData checkRoleBykeyWord(@ApiParam(value = "角色关键字") String keyWord) {
		return roleService.checkRoleBykeyWord(keyWord);
	}

	// 导入角色列表
	@RequestMapping("import_role.action")
	@ResponseBody
	public JsonData import_role(MultipartFile file) {
		return roleService.import_role(file);
	}

	// 查看当前角色已经关联过的菜单
	@ApiOperation(value = "查看当前角色关联的菜单")
	@RequestMapping("findMenuByRole.action")
	@ResponseBody
	public List<Menu> findMenuByRole(Integer rid) {
		return menuService.findByRole(rid);
	}

	// 查看当前角色关联的权限
	@ApiOperation(value = "查看当前角色关联的权限")
	@RequestMapping("findPerByRole.action")
	@ResponseBody
	public List<Permission> findPerByRole(Integer rid) {
		return permissionService.findByRole(rid);
	}
	
	@ApiOperation(value = "角色取消关联菜单")
	@RequestMapping("roleCancleMenu.action")
	@ResponseBody
	public JsonData roleCancleMenu(Integer rid,String[] mid) {
		return roleService.roleCancleMenu(rid,mid);
	}
	
	@ApiOperation(value = "角色取消关联权限")
	@RequestMapping("roleCanclePer.action")
	@ResponseBody
	public JsonData roleCanclePer(Integer rid,String[] pid) {
		return roleService.roleCanclePer(rid,pid);
	}
}
