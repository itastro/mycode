package com.bailian.car.dao.system;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import com.bailian.car.domain.system.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Integer>, JpaSpecificationExecutor<Permission> {
	@Query("from Permission p inner join fetch p.roles r inner join fetch r.users u where u.uid=?1")
	List<Permission> findByUser(Integer id);

	Permission findByName(String name);

	Permission findByKeyWord(String keyWord);

	@Query(value = "SELECT * FROM t_permission WHERE C_ID NOT IN ( SELECT C_PERMISSION_ID from t_role_permissions where C_ROLE_ID=?1)", nativeQuery = true)
	List<Permission> findCurrentRoleIsNotRelatedPer(Integer rid);
	
	
	@Query(value = "SELECT * FROM t_permission WHERE C_ID IN ( SELECT C_PERMISSION_ID from t_role_permissions where C_ROLE_ID=?1)", nativeQuery = true)
	List<Permission> findCurrentRoleIsRelatedPer(Integer rid);

}
