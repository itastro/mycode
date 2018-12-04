package com.bailian.car.dao.cars.car;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.bailian.car.domain.cars.car.HistoryLicense;

public interface HistoryLicenseRepository extends JpaRepository<HistoryLicense, Integer> {

	@Query(value = "SELECT * FROM t_historylicense WHERE vSn=?1 ORDER BY maketime DESC", nativeQuery = true)
	List<HistoryLicense> findByvSn(String vSn);

	@Modifying
	@Query(value = "UPDATE t_carlicense SET licenseNo=?2,licenseEndTime=?3,remark=?4 WHERE vSn=?1 AND maketime= ?5 ", nativeQuery = true)
	void updateLicense(String vSn, String licenseNo, Date licenseEndTime, String remark, Date maketime);

}
