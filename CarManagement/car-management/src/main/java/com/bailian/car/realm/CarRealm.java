package com.bailian.car.realm;
import java.util.List;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import com.bailian.car.domain.system.Permission;
import com.bailian.car.domain.system.Role;
import com.bailian.car.domain.system.User;
import com.bailian.car.service.system.*;;
public class CarRealm extends AuthorizingRealm {
	// 注入userService
	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private PermissionService permissionService;

	@Override
	// 授权方法
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {

		// 授权
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		// 获取当前登录的用户 查询相应的角色
		Subject subject = SecurityUtils.getSubject();
		User user = (User) subject.getPrincipal();

		// 调用业务层查询角色
		List<Role> roles = roleService.findByUser(user);
		// 遍历角色
		for (Role role : roles) {
			// 添加角色
			authorizationInfo.addRole(role.getKeyWord());
		}
		// 调用业务层查询权限
		List<Permission> Permissions = permissionService.findByUser(user);
		// 遍历权限
		for (Permission permission : Permissions) {
			authorizationInfo.addStringPermission(permission.getKeyWord());
		}
		return authorizationInfo;
		// TODO Auto-generated method stub
	}

	@Override
	// 认证方法
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		User user = null;
		// 根据用户名查询用户
		UsernamePasswordToken usernameToken = (UsernamePasswordToken) token;
		String username = usernameToken.getUsername();
		user = userService.findByNetid(username);
		
		if (user == null) {
			user = userService.findByEmployeeCard(username);
		}

		if (user != null) {
			// 如果存在
			// 当返回用户密码时,securityManager安全管理器,自动返回密码和用户密码是否输入一至
			// 如果密码一直登录成功,如果密不不同 失败 报密码错误异常
			return new SimpleAuthenticationInfo(user, user.getPassword(), this.getClass().getName());
		} else {
			// 登录失败
			return null;
		}
	}

}
