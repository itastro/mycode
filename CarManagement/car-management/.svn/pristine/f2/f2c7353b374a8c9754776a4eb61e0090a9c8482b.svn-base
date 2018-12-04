package com.bailian.car.dao.system;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.bailian.car.domain.system.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>, JpaSpecificationExecutor<Role> {
	@Query("from Role r inner join fetch r.users u where u.uid=?1")
	List<Role> findByUser(Integer id);

	Role findByName(String name);

	Role findByKeyWord(String keyWord);

	@Query(value = "SELECT * from  t_role  where C_ID NOT IN (SELECT C_ROLE_ID from t_user_role where C_USER_ID=?1)", nativeQuery = true)
	List<Role> findCurrentUserIsNotRelatedRole(Integer id);

	@Query(value = "SELECT * from  t_role  where C_ID IN (SELECT C_ROLE_ID from t_user_role where C_USER_ID=?1)", nativeQuery = true)
	List<Role> findCurrentUserIsRelatedRole(Integer id);

	@Modifying
	@Query(value = "DELETE FROM t_role_menu WHERE C_ROLE_ID=?1 AND C_MENU_ID=?2", nativeQuery = true)
	void roleCancleMenu(Integer rid, int id);

	@Modifying
	@Query(value = "DELETE FROM t_role_permissions WHERE C_ROLE_ID=?1 AND C_PERMISSION_ID=?2", nativeQuery = true)
	void roleCanclePer(Integer rid, int id);

}
