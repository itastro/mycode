package com.bailian.car.dao.cars.car;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.bailian.car.domain.cars.car.CarLicense;

public interface CarLicenseRepository extends JpaRepository<CarLicense, Integer> {

	CarLicense findByvSn(String vSn);

	@Modifying
	@Query(value = "UPDATE t_carlicense SET licenseNo=?2,licenseEndTime=?3,remark=?4 WHERE vSn=?1", nativeQuery = true)
	void updateLicense(String vSn, String licenseNo, Date licenseEndTime, String remark);

	@Modifying
	@Query(value = "DELETE FROM t_carlicense WHERE vSn=?1", nativeQuery = true)
	void deleteByvSn(String vSn);

}
