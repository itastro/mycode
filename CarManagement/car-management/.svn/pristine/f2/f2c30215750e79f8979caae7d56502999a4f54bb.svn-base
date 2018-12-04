package com.bailian.car.service.system.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bailian.car.beans.MenuComparator;
import com.bailian.car.common.JsonData;
import com.bailian.car.dao.system.MenuRepository;
import com.bailian.car.domain.system.Menu;
import com.bailian.car.domain.system.User;
import com.bailian.car.service.system.MenuService;
import com.bailian.car.utils.ComputerInfoUtils;
import com.bailian.car.utils.TokenManagerUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
@Cacheable("menu")
public class MenuServiceImpl implements MenuService {
	@Autowired
	private MenuRepository menuRepository;

	// 查询菜单
	@Override
	@Cacheable("menu")
	public List<Menu> findByParentMenuIsNull() {
		// TODO Auto-generated method stub
		return menuRepository.findByParentMenuIsNull();
	}

	// 菜单展示
	@Override
	@Cacheable(value = "menu", key = "#user.uid")
	public List<Menu> findByUser(User user) {
		List<Menu> list = new ArrayList<>();
		//
		
		if ("admin".equals(user.getNetid())) {
			List<Menu> list1 = menuRepository.findByParentMenuIsNull();

			for (Menu menu : list1) {
				// menu.setChildrenMenus(null);
				Set<Menu> childrenMenus = menu.getChildrenMenus();
				Set<Menu> set = menuSort(childrenMenus);
				menu.setChildrenMenus(set);
				list.add(menu);

			}
			return list;
		}

		list = this.findPmenu();
		HashSet<Menu> set = new HashSet<>();

		ArrayList<Menu> list2 = new ArrayList<>();

		for (Menu menu : list) {
			if (set.add(menu)) {
				list2.add(menu);
			}
		}

		return list2;
	}

	/**
	 * 查询当前用户的所有父菜单
	 */
	@Override
	public List<Menu> findPmenu() {
		List<Menu> list = new ArrayList<Menu>();
		Integer uid = TokenManagerUtils.getUserId();
		List<Menu> P = menuRepository.findPMenuByUser(uid);
		for (Menu menu : P) {
			menu.setChildrenMenus(null);
			Integer mid = menu.getMid();

			Set<Menu> childrenMenus = this.findcmenu(uid, mid); // 查询当前菜单的用户关联的子菜单
			Set<Menu> set = menuSort(childrenMenus);
			menu.setChildrenMenus(set); // 设置子菜单
			if (menu.getChildrenMenus().size() > 0) { // 如果当前父菜单下没有子菜单 则不进行展示
				list.add(menu);
			}
		}
		return list;
	}

	private Set<Menu> menuSort(Set<Menu> childrenMenus) {
		Set<Menu> set = new TreeSet<Menu>(new MenuComparator()); // 因为set集合无序 根据菜单顺序进行排序
		for (Iterator<Menu> iterator = childrenMenus.iterator(); iterator.hasNext();) {
			Menu menu2 = (Menu) iterator.next();
			set.add(menu2);
		}
		return set;
	}

	@Override
	public Set<Menu> findcmenu(Integer uid, Integer pid) {
		return menuRepository.findByCmenuByPid(uid, pid);

	}

	// 添加菜单
	@Override
	public JsonData save(Menu menu) {
		// 防止用户没有选中菜单
		if (menu.getParentMenu() != null && menu.getParentMenu().getMid() == 0) {
			menu.setParentMenu(null);
		}
		menu.setCreateTime(new Date());
		menu.setOperate_ip(ComputerInfoUtils.getIpAddr());
		menu.setOperator(TokenManagerUtils.getToken().getNickname());
		menuRepository.save(menu);

		return JsonData.success("添加成功");
	}

	@Override
	public JsonData delete(String mids) {

		if (mids.length() != 0) {
			String[] split = mids.split(",");
			for (String id : split) {
				menuRepository.delete(Integer.parseInt(id));
			}
		}
		return JsonData.success("删除成功");
	}

	@Override
	public List<Menu> findByRole(Integer rid) {
		ArrayList<Menu> list = new ArrayList<>();
		// 查询当前角色关联的所有父菜单
		List<Menu> menus = menuRepository.findCurrentRoleIsRelatedMenu(rid);
		for (Menu menu : menus) {
			menu.setChildrenMenus(null);
			Integer mid = menu.getMid();
			Set<Menu> childrenMenus = menuRepository.findcmenu(rid, mid); // 查询当前角色关联的子菜单

			Set<Menu> set = menuSort(childrenMenus);
			menu.setChildrenMenus(set); // 设置子菜单
			if (menu.getChildrenMenus().size() > 0) { // 如果当前父菜单下没有子菜单 则不进行展示
				list.add(menu);
			}
		}
		return list;
	}
}
