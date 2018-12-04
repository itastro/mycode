package com.bailian.car.service.system;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.bailian.car.beans.PageBean;
import com.bailian.car.beans.PageQuery;
import com.bailian.car.common.JsonData;
import com.bailian.car.domain.system.Menu;
import com.bailian.car.domain.system.Permission;
import com.bailian.car.domain.system.Role;
import com.bailian.car.domain.system.User;
import com.bailian.car.param.RoleSearchParam;

public interface RoleService {

	List<Role> findByUser(User user);

	JsonData add(Role role, String[] permissionIds, String menuIds);

	List<Role> findALL();

	JsonData delete(String[] roleIds);

	JsonData roleRelatedPermissionId(Integer rid, String[] pid);

	JsonData roleRelatedMenu(Integer rid, String[] mids);

	JsonData checkRoleByName(String name);

	JsonData checkRoleBykeyWord(String keyWord);

	JsonData import_role(MultipartFile file);

	PageBean<Role> query(PageQuery pQuery, RoleSearchParam SearchParam);

	List<Menu> findCurrentRoleIsNotRelatedMenu(Integer rid);

	List<Permission> findCurrentRoleIsNotRelatedPer(Integer rid);

	JsonData bacthRoleRelatedMenu(String[] rid, String[] mids);

	JsonData bacthRoleRelatedPermission(String[] rid, String[] pids);

	JsonData roleCancleMenu(Integer rid, String[] mid);

	JsonData roleCanclePer(Integer rid, String[] pid);

}
