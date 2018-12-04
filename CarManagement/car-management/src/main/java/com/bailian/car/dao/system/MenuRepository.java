package com.bailian.car.dao.system;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.bailian.car.domain.system.Menu;

public interface MenuRepository extends JpaRepository<Menu, Integer> {

	List<Menu> findByParentMenuIsNull();

	@Query("from Menu m inner join fetch m.roles r inner join fetch r.users u where u.uid=?1 and m.parentMenu=null order by m.priority")
	List<Menu> findByUser(Integer id);

	@Query(value = "SELECT * FROM t_menu WHERE C_ID NOT IN ( SELECT C_MENU_ID from t_role_menu where C_ROLE_ID=?1)", nativeQuery = true)
	List<Menu> findCurrentRoleIsNotRelatedMenu(Integer rid);

	// @Query(value = "SELECT * FROM t_menu WHERE C_ID IN ( SELECT C_MENU_ID from
	// t_role_menu where C_ROLE_ID=?1)", nativeQuery = true)
	@Query("from Menu m inner join fetch m.roles r where r.rid=?1 and m.parentMenu=null order by m.priority")
	List<Menu> findCurrentRoleIsRelatedMenu(Integer rid);

	@Query("from Menu m inner join fetch m.roles r inner join fetch r.users u where u.uid=?1 and m.parentMenu=null order by m.priority")
	List<Menu> findPMenuByUser(Integer uid);

	@Query("from Menu m inner join fetch m.roles r inner join fetch r.users u where u.uid=?1 and m.parentMenu.mid=?2  order by m.priority")
	Set<Menu> findByCmenuByPid(Integer uid, Integer pid);

	
	@Query("from Menu m inner join fetch m.roles r where r.rid=?1 and m.parentMenu.mid=?2 order by m.priority")
	Set<Menu> findcmenu(Integer rid, Integer mid);

}
