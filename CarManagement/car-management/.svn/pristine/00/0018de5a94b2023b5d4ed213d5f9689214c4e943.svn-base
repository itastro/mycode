package com.bailian.car.service.system;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.bailian.car.beans.PageBean;
import com.bailian.car.beans.PageQuery;
import com.bailian.car.common.JsonData;
import com.bailian.car.domain.system.Permission;
import com.bailian.car.domain.system.User;
import com.bailian.car.param.PerSearchParam;

public interface PermissionService {

	List<Permission> findByUser(User user);
	
	JsonData add(Permission permission);

	JsonData deletePermission(String[] pids);

	JsonData checkPermissionByName(String name);

	JsonData checkPermissionBykeyWord(String keyWord);

	JsonData per_import(MultipartFile file);

	PageBean<Permission> query(PageQuery pQuery, PerSearchParam perSearchParam);

	List<Permission> findAll();

	List<Permission> findByRole(Integer pid);


}
