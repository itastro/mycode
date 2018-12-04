package com.bailian.car.dao.CarMaintain;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bailian.car.domain.carmaintain.Screen;

public interface ScreenRepository extends JpaRepository<Screen, Integer>, JpaSpecificationExecutor<Screen> {

	@Query(value = "select COUNT(status) from t_screen where status='已完成'", nativeQuery = true)
	float findCompleteCountByStatus();

	@Query(value = "select COUNT(status) from t_screen where status='维修中'", nativeQuery = true)
	int findCurrentCountByStatus();

	@Query(value = "select COUNT(status) from t_screen where status='排队中 '", nativeQuery = true)
	float findQueueStatus();

	@Query(value = "select s from Screen s where s.status Not IN(?1) GROUP BY s.status")
	Page<Screen> findAll(@Param(value = "status") String status, Pageable pageable);

	@Modifying
	@Query(value = "UPDATE t_screen set status='已注销' where status='已完成'", nativeQuery = true)
	void updataStatus();

	@Query(value = "UPDATE t_screen set applyTime=?2 where vSn=?1", nativeQuery = true)
	@Modifying
	void updateApplyTime(String getvSn, Date date);

	@Query(value = "select s from Screen s where s.status Not IN(?1) ORDER BY s.applyTime ASC")
	List<Screen> findAll(String status);

	@Query(value = "SELECT * FROM t_screen WHERE vSn= ?1 AND mid=?2", nativeQuery = true)
	Screen findByvSn(String vSn, Integer id);

	@Modifying
	@Query(value = "DELETE FROM t_screen WHERE mid=?1", nativeQuery = true)
	void deleteByMid(Integer id);

	Screen findByMid(Integer id);
	
	@Query(value = "SELECT MIN(ID) FROM t_screen", nativeQuery = true)
	Integer findMinId();

	
	@Query(value = "UPDATE t_screen set ID=?2 where mid=?1", nativeQuery = true)
	@Modifying
	void updateId(Integer id, Integer stargetId);
	
	@Query(value = "SELECT MAX(ID) FROM t_screen", nativeQuery = true)
	Integer findMaxId();

	
	@Query(value = "UPDATE t_screen set ID=?1 where ID=?2", nativeQuery = true)
	@Modifying
	void updateIdtwo(Integer id, Integer sminid);

	@Query(value = "UPDATE t_screen set mid=?2 where ID=?1", nativeQuery = true)
	@Modifying
	void updateMid(Integer id, Integer targetId);

}
