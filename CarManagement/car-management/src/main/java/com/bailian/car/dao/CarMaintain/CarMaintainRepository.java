package com.bailian.car.dao.CarMaintain;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.bailian.car.domain.carmaintain.CarMaintain;

public interface CarMaintainRepository
		extends JpaRepository<CarMaintain, Integer>, JpaSpecificationExecutor<CarMaintain> {
	@Query(value = "SELECT * FROM t_carmaintain WHERE vSn= ?1 AND ID=?2 ORDER BY applytime DESC LIMIT 1", nativeQuery = true)
	CarMaintain findByvSn(String vSn, Integer id);

	@Query(value = "UPDATE t_carmaintain set sortTime=?2 where ID=?1", nativeQuery = true)
	@Modifying
	void updateMakeTime(Integer id, Date date);

	@Query(value = "SELECT  * FROM t_carmaintain WHERE applytime =(SELECT MIN(applytime) FROM  t_carmaintain)", nativeQuery = true)
	List<CarMaintain> findByMinId();

	
	@Query(value = "SELECT MAX(ID) FROM t_carmaintain", nativeQuery = true)
	Integer findMaxId();

	
	@Query(value = "UPDATE t_carmaintain set ID=?2 where ID=?1", nativeQuery = true)
	@Modifying
	void updateId(Integer id, Integer targetId);
	
	
	@Query(value = "SELECT MIN(ID) FROM t_carmaintain", nativeQuery = true)
	Integer findMinId();

}
