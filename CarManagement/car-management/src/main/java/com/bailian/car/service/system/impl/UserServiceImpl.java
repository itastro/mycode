package com.bailian.car.service.system.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import com.bailian.car.beans.PageBean;
import com.bailian.car.beans.PageQuery;
import com.bailian.car.common.JsonData;
import com.bailian.car.dao.system.RoleRepository;
import com.bailian.car.dao.system.UserRepository;
import com.bailian.car.domain.system.Role;
import com.bailian.car.domain.system.User;
import com.bailian.car.exception.CustomException;
import com.bailian.car.exception.PermissionException;
import com.bailian.car.param.UpdatePassParam;
import com.bailian.car.param.UserSearchParam;
import com.bailian.car.service.system.UserService;
import com.bailian.car.utils.ComputerInfoUtils;
import com.bailian.car.utils.CookieUtils;
import com.bailian.car.utils.ExcelUtils;
import com.bailian.car.utils.MD5Utils;
import com.bailian.car.utils.TokenManagerUtils;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public JsonData login(String NETID, String password, String autologin) {
		// TODO Auto-generated method stub
		// 获取当前用户
		Subject subject = SecurityUtils.getSubject();

		if (StringUtils.isBlank(NETID)) {
			return JsonData.fail("NETID不能为空");
		}
		try {
			// 对密码进行MD5加密
			String pass = MD5Utils.toMD5(password, MD5Utils.salt);
			// 传入密码和用户构建令牌
			UsernamePasswordToken token = new UsernamePasswordToken(NETID, pass);
			if ("true".equals(autologin)) {
				token.setRememberMe(true);
			}
			token.setRememberMe(true);
			// 登录成功，保存session
			subject.login(token);
			User user = TokenManagerUtils.getToken();

			JsonData success = JsonData.success(user, "登录成功,");
			return success;
		} catch (AuthenticationException e) {
			if (e instanceof UnknownAccountException) {
				return JsonData.fail("无此用户，请联系管理员");
			} else if (e instanceof IncorrectCredentialsException) {
				return JsonData.fail("密码错误");
			}
			return JsonData.fail("登录失败");
		}

	}

	@Override
	public User findByNetid(String NETID) {
		// TODO Auto-generated method stub
		return userRepository.findByNetid(NETID);
	}

	@Cacheable("user")
	@Override
	public User findByEmployeeCard(String employeeCard) {
		return userRepository.findByEmployeeCard(employeeCard);
	}

	@Override
	public JsonData changeUserPassWord(UpdatePassParam updatePassParam) {
		User user = null;
		if (StringUtils.isBlank(updatePassParam.getNewPass())) {
			return JsonData.fail("新密码不能为空");
		}
		String newpass = MD5Utils.toMD5(updatePassParam.getNewPass(), MD5Utils.salt);
		// 获得旧密码
		String pass = MD5Utils.toMD5(updatePassParam.getOldPass(), MD5Utils.salt);
		Integer userId = null;
		try {
			userId = TokenManagerUtils.getToken().getUid();
		} catch (Exception e) {

			throw new PermissionException("请你先进行登录");
		}
		user = userRepository.findUserByUidAndPassword(userId, pass);

		if (user == null) {
			return JsonData.fail("原始密码错误");
		}
		userRepository.updatePassWord(userId, newpass);
		return JsonData.success("密码修改成功,请退出重新登录");
	}

	@Override
	public List<User> findALL() {

		List<User> users = userRepository.findAll();

		return users;

	}

	// 1、2、3、4分别代表NETID、phone、email
	@Override
	public JsonData checkData(String param, Integer type) {
		String NETID = null;
		String telephone = null;
		String email = null;
		if (param != null & type != null) {
			// TODO Auto-generated method stub
			if (type == 1) {
				NETID = param;
				User user = userRepository.findByNetid(NETID);
				if (user != null) {
					return JsonData.fail("账户已经被占用");
				}
				return JsonData.success();
			}

			if (type == 2) {
				telephone = param;
				User user = userRepository.findByTelephone(telephone);
				if (user != null) {
					return JsonData.fail("此号码已经被占用");
				}
				return JsonData.success();
			}

			if (type == 3) {
				email = param;
				User user = userRepository.findByEmail(email);
				if (user != null) {
					return JsonData.fail("邮箱已经被占用");
				}
				return JsonData.success();

			}
		} else {
			return JsonData.fail("非法的参数");
		}
		return null;
	}

	@Override
	@Transactional
	// @RequiresRoles("system")
	public JsonData save(User user) {
		if (StringUtils.isBlank(user.getNickname())) {
			return JsonData.fail("姓名不能为空");
		}

		if (StringUtils.isBlank(user.getTelephone())) {
			return JsonData.fail("手机号不能为空");
		}

		// User currentUser = TokenManagerUtils.getToken();
		// 获取当前用户电脑的ip
		String ipAddr = ComputerInfoUtils.getIpAddr();
		// 补全User的其他属性
		user.setCreateTime(new Date());
		user.setOperate_id(ipAddr);

		user.setOperator(TokenManagerUtils.getNickname());
		String md5pass = MD5Utils.toMD5("123456", MD5Utils.salt);
		user.setPassword(md5pass);
		HashSet<Role> set = userSetRole();
		userRepository.save(user);
		user.setRoles(set);
		return JsonData.success("添加成功");

	}

	private HashSet<Role> userSetRole() {
		Role role = roleRepository.findByKeyWord("engineer");
		HashSet<Role> set = new HashSet<Role>();
		set.add(role);
		return set;
	}

	@CacheEvict(value = "user", allEntries = true)
	@Override
	// @RequiresRoles("system")
	public int deleteUserByID(String[] userIds) {
		// TODO Auto-generated method stub
		int a = 0;
		for (String userId : userIds) {
			int id = Integer.parseInt(userId);
			User user = userRepository.findOne(id);
			if (user != null) {
				userRepository.delete(user);
				a = 1;
			} else {
				throw new PermissionException("此用户不存在");
			}
		}
		return a;
	}

	@Override
	public User findUserById(Integer userId) {
		return userRepository.findOne(userId);
	}

	@CacheEvict(value = "user", allEntries = true)
	@Override
	// @RequiresRoles("system")
	public JsonData updateUser(User user) {
		if (user.getUid() != null) {
			User user2 = userRepository.findOne(user.getUid());
			//user2.setUid(user2.getUid());
			user2.setCreateTime(new Date());
			user2.setOperate_id(ComputerInfoUtils.getIpAddr());
			user2.setEmployeeCard(user.getEmployeeCard());
			user2.setNetid(user.getNetid());
			user2.setTelephone(user.getTelephone());
			user2.setNickname(user.getNickname());
			return JsonData.success("修改成功");
		}
		return JsonData.fail("修改失败");
	}

	@Cacheable("user")
	@Override
	public PageBean<User> query(PageQuery pQuery, UserSearchParam uParam) {

		PageBean<User> pageBean = new PageBean<>();

		Sort sort = new Sort(Direction.DESC, "uid");

		Pageable pageable = new PageRequest(pQuery.getPage(), pQuery.getSize(), sort);
		List<Predicate> p = new ArrayList<>();
		Specification<User> querySpecifi = new Specification<User>() {
			@Override
			public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				if (StringUtils.isNotBlank(uParam.getNetid())) {
					Predicate predicate1 = cb.like(root.get("netid").as(String.class), "%" + uParam.getNetid() + "%");
					p.add(predicate1);
				}

				if (StringUtils.isNotBlank(uParam.getName())) {
					Predicate predicate2 = cb.like(root.get("nickname").as(String.class), "%" + uParam.getName() + "%");
					p.add(predicate2);
				}

				if (StringUtils.isNotBlank(uParam.getTeam())) {
					Predicate predicate2 = cb.like(root.get("team").as(String.class), "%" + uParam.getTeam() + "%");
					p.add(predicate2);
				}
				if (StringUtils.isNotBlank(uParam.getRoleName())) {

					Join<User, Role> carjoin = root.join("roles", JoinType.INNER);
					Predicate p3 = cb.like(carjoin.get("name").as(String.class), "%" + uParam.getRoleName() + "%");
					p.add(p3);
				}
				// TODO Auto-generated method stub
				return cb.and(p.toArray(new Predicate[p.size()]));
			}

		};
		Page<User> pageData = userRepository.findAll(querySpecifi, pageable);
		pageBean.setTotal(pageData.getTotalElements());
		pageBean.setRows(pageData.getContent());
		return pageBean;
	}

	@Override
	// @RequiresRoles("system")
	public JsonData userRelatedRole(Integer uid, String rids) {
		if (uid != null) {
			User user = userRepository.findOne(uid);
			if (rids.length() != 0) {
				String[] ridss = rids.split(",");
				for (String rid : ridss) {
					Role role = roleRepository.findOne(Integer.parseInt(rid));
					user.getRoles().add(role);
					userRepository.save(user);
				}
				return JsonData.success("关联成功");
			}
			return JsonData.fail("请选择一角色");
		}
		return JsonData.fail("请选择一个用户");
	}

	@Override
	public JsonData batchImport(MultipartFile file) {

		List<String[]> readExcel = ExcelUtils.readExcel(file);
		for (int i = 1; i < readExcel.size(); i++) {
			String[] strings = readExcel.get(i);

			String NETID = strings[2];
			//
			/*
			 * User user = userRepository.findByNetid(NETID); if (user != null) { continue;
			 * }
			 */
			User excelUser = new User();
			String employeeCard = strings[1];
			excelUser.setEmployeeCard(employeeCard);
			/*
			 * user = userRepository.findByEmployeeCard(employeeCard); if (user != null) {
			 * continue; }
			 */
			excelUser.setNetid(NETID);
			String nickName = strings[0];
			excelUser.setNickname(nickName);
			String tel = strings[3];
			excelUser.setTelephone(tel);

			String team = strings[4];
			excelUser.setTeam(team);

			excelUser.setPassword(MD5Utils.toMD5("123456", MD5Utils.salt));
			excelUser.setOperate_id(ComputerInfoUtils.getIpAddr());
			excelUser.setCreateTime(new Date());
			userRepository.save(excelUser);
			HashSet<Role> set = userSetRole();
			excelUser.setRoles(set);
		}
		return JsonData.success("导入员工信息成功,冲突的用户名自动忽略");
	}

	@Override
	public JsonData loginlogintwo(String employeeCard, String password, String autologin) {
		// 获取当前用户
		Subject subject = SecurityUtils.getSubject();

		if (StringUtils.isBlank(employeeCard)) {
			return JsonData.fail("员工卡号不能为空");
		}
		try {
			// 对密码进行MD5加密
			String pass = MD5Utils.toMD5(password, MD5Utils.salt);
			// 传入密码和用户构建令牌
			UsernamePasswordToken token = new UsernamePasswordToken(employeeCard, pass);
			if ("true".equals(autologin)) {
				token.setRememberMe(true);
			}
			// 登录成功，保存session
			subject.login(token);
			User user = TokenManagerUtils.getToken();

			JsonData success = JsonData.success(user, "登录成功");
			return success;
		} catch (AuthenticationException e) {
			if (e instanceof UnknownAccountException) {
				return JsonData.fail("无此用户，请联系管理员");
			} else if (e instanceof IncorrectCredentialsException) {
				return JsonData.fail("密码错误");
			}
			return JsonData.fail("登录失败");
		}
	}

	@Override
	public List<Role> findCurrentUserIsNotRelatedRole() {
		// Integer id = TokenManagerUtils.getUserId();
		// 查询所有的角色
		// List<Role> roles = roleRepository.findCurrentUserIsNotRelatedRole(id); //TODD
		List<Role> roles = roleRepository.findAll();
		return roles;
	}

	// 批量用户批量进行关联角色
	@Override
	public JsonData bacthUserRelatedRole(String[] uids, String[] rids) {
		for (String uid : uids) {
			User user = userRepository.findOne(Integer.parseInt(uid));
			for (String rid : rids) {
				Role role = roleRepository.findOne(Integer.parseInt(rid));
				Set<Role> roles = user.getRoles();
				if (roles.contains(role)) { // 判断当前用户是否已经关联了这个角色
					continue;
				}
				roles.add(role);
				userRepository.save(user);
			}
		}
		return JsonData.success("用户关联角色成功");
	}

	@Override
	public List<Role> findRoleByUser(Integer uid) {

		return roleRepository.findCurrentUserIsRelatedRole(uid);
	}

	@Override
	public JsonData userCancleRole(Integer uid, String[] rid) {
		// User user = userRepository.findOne(uid);
		for (String id : rid) {
			int i = Integer.parseInt(id);
			userRepository.userCancleRole(uid, i);
		}
		return JsonData.success("取消关联成功");
	}
}
