package com.bailian.car.dao.driver;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.bailian.car.domain.cardriver.DriverGroup;

public interface DriverGroupRepository extends JpaRepository<DriverGroup, Integer> {

	DriverGroup findByName(String name);

	@Modifying
	@Query(value = "INSERT INTO t_driver_group (driver_id,group_id) VALUES (?1,?2)", nativeQuery = true)
	void inSert(String id, int gi);

	@Modifying
	@Query(value = "DELETE FROM t_driver_group WHERE driver_id =?2 AND group_id=?1", nativeQuery = true)
	void cancelGroup(int gid, String id);

	@Query(value = "SELECT * from t_driver_group WHERE driver_id=?1 AND group_id=?2", nativeQuery = true)
	List<String> findByGidAndgi(String id, int gi);

}
