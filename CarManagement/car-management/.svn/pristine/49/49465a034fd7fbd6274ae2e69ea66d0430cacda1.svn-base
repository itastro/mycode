package com.bailian.car.service.system;

import java.util.List;
import java.util.Set;

import com.bailian.car.common.JsonData;
import com.bailian.car.domain.system.Menu;
import com.bailian.car.domain.system.User;

public interface MenuService {

	List<Menu> findByParentMenuIsNull();

	List<Menu> findByUser(User user);

	JsonData save(Menu menu);

	JsonData delete(String mids);

	List<Menu> findPmenu();

	Set<Menu> findcmenu(Integer uid, Integer pid);

	List<Menu> findByRole(Integer rid);

}
