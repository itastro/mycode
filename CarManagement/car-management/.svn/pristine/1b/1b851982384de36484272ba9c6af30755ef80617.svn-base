package com.bailian.car.dao.driver;

import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.bailian.car.domain.cardriver.Driver;

public interface DriverRepository extends JpaRepository<Driver, Integer>, JpaSpecificationExecutor<Driver> {
	@Query(value = "UPDATE t_driver t SET t.allowStartTime=?2,t.allowEndTime=?3 ,t.isallow='正常' WHERE t.ID=?1", nativeQuery = true)
	@Modifying
	void updateAuthorized(Integer id, Date startTime, Date endTime);

	@Query(value = "UPDATE t_driver t SET t.allowStartTime=null,t.allowEndTime=null ,t.isallow='禁止' WHERE t.ID=?1", nativeQuery = true)
	@Modifying
	void cancelAuthorized(Integer id);

	@Query(value = "UPDATE t_driver t SET t.allowStartTime=?2,t.allowEndTime=?3 ,t.isallow='2' WHERE t.ID=?1", nativeQuery = true)
	@Modifying
	void batahcAuthorized(int id, Date start, Date end);

	Driver findByName(String name);

	Driver findByEmployeeCard(String employeeCard);

	Driver findByIccard(String iccard);

	@Query(value = "UPDATE t_driver t SET t.iccard=?2 WHERE t.employeeCard=?1", nativeQuery = true)
	@Modifying
	void updateCard(String otherNumber, String card);

}
