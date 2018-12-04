package com.bailian.car.controller.system;

import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.bailian.car.annotation.SystemLog;
import com.bailian.car.beans.PageBean;
import com.bailian.car.beans.PageQuery;
import com.bailian.car.common.JsonData;
import com.bailian.car.domain.system.Role;
import com.bailian.car.domain.system.User;
import com.bailian.car.domain.vo.UserInfo;
import com.bailian.car.emnu.OperationType;
import com.bailian.car.exception.CustomException;
import com.bailian.car.param.UpdatePassParam;
import com.bailian.car.param.UserSearchParam;
import com.bailian.car.service.system.*;
import com.bailian.car.utils.JsonMapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Api(description = "用户相关操作")
@Controller
@Scope("prototype")
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login.action")
	@ResponseBody
	@ApiOperation(value = "用户登录1")
	public JsonData login(@ApiParam(value = "员工netid") String NETID, @ApiParam(value = "密码") String password,
			@ApiParam(value = "是否登录") String autologin) {
		JsonData login = userService.login(NETID, password, autologin);
		return login;
	}

	@ApiOperation(value = "用户登录2")
	@RequestMapping(value = "/logintwo.action")
	@ResponseBody
	public JsonData logintwo(@ApiParam(value = "员工卡号") String employeeCard, @ApiParam(value = "密码") String password,
			@ApiParam(value = "是否登录") String autologin) {
		JsonData login = userService.loginlogintwo(employeeCard, password, autologin);
		return login;
	}

	@ApiOperation(value = "用户退出")
	@RequestMapping(value = "/loginOut.action")
	@SystemLog(medoule = "系统管理", methods = "用户退出", type = OperationType.LOGINOUT)
	public String loginOut() {
		// 基于Shiro的退出
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "redirect:/car-management/login.html";

	}

	@ApiOperation(value = "修改密码")
	@RequestMapping(value = "/changeUserPassWord.action")
	@ResponseBody
	@SystemLog(medoule = "系统管理", methods = "修改密码", type = OperationType.UPDATE)
	public JsonData changeUserPassWord(@RequestBody UpdatePassParam updatePassParam) {
		JsonData jsonData = userService.changeUserPassWord(updatePassParam);
		return jsonData;
	}

	/**
	 * 
	* @Title: userInfo
	* @Description: 用户信息展示
	* @param @return    参数
	* @return String    返回类型
	* @throws
	 */
	@ApiOperation(value = "用户信息的展示")
	@RequestMapping(value = "/UserInfo.action")
	@ResponseBody
	public UserInfo userInfo() {
		UserInfo userInfo = new UserInfo();

		Subject subject = SecurityUtils.getSubject();
		User user = (User) subject.getPrincipal();

		Set<Role> roles = user.getRoles();

		for (Role role : roles) {
			userInfo.setRolename(role.getName());
		}
		userInfo.setNickname(user.getNickname());

		return userInfo;

	}

	@ApiOperation(value = "用户列表", hidden = true)
	@RequestMapping(value = "/userList.action")
	@ResponseBody
	public List<User> userList(HttpServletRequest request) {

		List<User> users = userService.findALL();

		if (users == null) {
			throw new CustomException("用户列表为空");

		}
		return users;

	}

	@ApiOperation(value = "用户列表，加查询")
	@RequestMapping("/searchUser.action")
	@ResponseBody
	public PageBean<User> searchUser(PageQuery pQuery, UserSearchParam uParam) {

		return userService.query(pQuery, uParam);

	}

	@RequestMapping(value = "/addUser.action")
	@ApiOperation(value = "添加用户")
	@ResponseBody
	@SystemLog(medoule = "系统管理", methods = "添加用户", type = OperationType.ADD)
	public JsonData addUser(@ApiParam(value = "用户模型") User user) {
		log.info("user:{}", JsonMapper.obj2String(user));
		return userService.save(user);

	}

	// 用户关联角色
	@ApiOperation(value = "用户关联角色")
	@RequestMapping(value = "/userRelatedRole.action")
	@ResponseBody
	@SystemLog(medoule = "系统管理", methods = "用户关联角色", type = OperationType.UPDATE)
	public JsonData userRelatedRole(@ApiParam(value = "用户id") Integer uid, @ApiParam(value = "角色id") String rid) {
		return userService.userRelatedRole(uid, rid);
	}

	// 用户关联角色
	@ApiOperation(value = "批量用户关联角色")
	@RequestMapping(value = "/bacthUserRelatedRole.action")
	@ResponseBody
	@SystemLog(medoule = "系统管理", methods = "用户关联角色", type = OperationType.UPDATE)
	public JsonData userRelatedRole(@ApiParam(value = "用户id") String[] uid, @ApiParam(value = "角色id") String[] rid) {
		return userService.bacthUserRelatedRole(uid, rid);
	}

	@ApiOperation(value = "添加用户参数校验")
	@RequestMapping(value = "/check/{param}/{type}.action")
	@ResponseBody
	public JsonData checkData(@PathVariable String param, @PathVariable Integer type) {

		return userService.checkData(param, type);
	}

	@ApiOperation(value = "用户的删除")
	@RequestMapping(value = "/delete.action")
	@ResponseBody
	@SystemLog(medoule = "系统管理", methods = "删除用户", type = OperationType.DELETE)
	public JsonData deleteUser(@RequestParam(value = "ids[]") @ApiParam(value = "用户id数组") String[] userIds) {

		int i = userService.deleteUserByID(userIds);
		if (i == 1) {
			return JsonData.success("删除成功");
		}

		return JsonData.fail("删除失败");
	}

	@ApiOperation(value = "用户修改时数据回显")
	@RequestMapping(value = "/editUser.action")
	@ResponseBody
	public User editUser(@ApiParam(value = "用户id") Integer userId) {
		User user = userService.findUserById(userId);
		if (user == null) {
			throw new CustomException("查无此用户，请联系管理员");
		}
		return user;
	}

	@ApiOperation(value = "用户数据更新")
	@RequestMapping("/updateUser.action")
	@SystemLog(medoule = "系统管理", methods = "更新用户信息", type = OperationType.UPDATE)
	@ResponseBody
	public JsonData updateUser(User user) {
		log.info("user:{}", JsonMapper.obj2String(user));
		JsonData data = userService.updateUser(user);
		return data;
	}

	@ApiOperation(value = "查看当前用户没有关联的角色")
	@RequestMapping("/findCurrentUserIsNotRelatedRole.action")
	@ResponseBody
	public List<Role> findCurrentUserIsNotRelatedRole() {
		List<Role> list = userService.findCurrentUserIsNotRelatedRole();
		return list;
	}

	@ApiOperation(value = "查看当前用户关联的角色")
	@RequestMapping("/findRoleByUser.action")
	@ResponseBody
	public List<Role> findRoleByUser(Integer uid) {
		List<Role> list = userService.findRoleByUser(uid);
		return list;
	}

	@ApiOperation(value = "用户与角色取消关联")
	@RequestMapping("/userCancleRole.action")
	@ResponseBody
	public JsonData userCancleRole(Integer uid, String[] rid) {

		return userService.userCancleRole(uid, rid);
	}

	// 导入用户的excel
	@RequestMapping("/user_batchImport.action")
	@ResponseBody
	public JsonData batchImport(MultipartFile file) {
		return userService.batchImport(file);
	}
}
