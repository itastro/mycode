package com.bailian.car.dao.cars.develop;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.bailian.car.domain.cars.develop.DevelopToolsRecord;

public interface DevelopToolsRecordRepository extends JpaRepository<DevelopToolsRecord, Integer> {

	List<DevelopToolsRecord> findByvSn(String vSn);

	DevelopToolsRecord findByToolNameAndVSn(String toolName, String vSn);

	@Modifying
	@Query(value = "UPDATE t_develop SET operator=?2 , equippedDate=?3 ,operatorDate=NOW(),remark=?4 WHERE C_ID=?1", nativeQuery = true)
	void developEquipment(Integer did, String operator, Date equippedDate, String remark);

	@Modifying
	@Query(value = "UPDATE t_develop SET demolitionOperator=?2 , demolitionDate=?3 WHERE C_ID=?1", nativeQuery = true)
	void toolsRemove(Integer did, String demolitionOperator, Date demolitionDate);

}
