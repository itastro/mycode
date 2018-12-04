package com.bailian.car.service.system;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.bailian.car.beans.PageBean;
import com.bailian.car.beans.PageQuery;
import com.bailian.car.common.JsonData;
import com.bailian.car.domain.system.Role;
import com.bailian.car.domain.system.User;
import com.bailian.car.param.UpdatePassParam;
import com.bailian.car.param.UserSearchParam;

public interface UserService {

	public JsonData login(String NETID, String password, String autologin);

	public User findByNetid(String username);

	public List<User> findALL();

	public JsonData save(User user);

	public JsonData checkData(String param, Integer type);

	public int deleteUserByID(String[] userIds);

	public User findUserById(Integer userId);

	public JsonData updateUser(User user);

	PageBean<User> query(PageQuery pQuery, UserSearchParam uParam);

	public JsonData userRelatedRole(Integer uid, String rid);

	public JsonData batchImport(MultipartFile file);

	public JsonData loginlogintwo(String employeeCard, String password, String autologin);

	public List<Role> findCurrentUserIsNotRelatedRole();

	public User findByEmployeeCard(String username);

	public JsonData changeUserPassWord(UpdatePassParam updatePassParam);

	public JsonData bacthUserRelatedRole(String[] uid, String[] rid);

	public List<Role> findRoleByUser(Integer uid);

	public JsonData userCancleRole(Integer uid, String[] rid);

}
