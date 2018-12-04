package com.bailian.car.dao.cars.car;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.bailian.car.domain.cars.car.CarInsurance;

public interface CarInsuranceRepository extends JpaRepository<CarInsurance, Integer> {

	CarInsurance findByvSn(String vSn);

	@Modifying
	@Query(value = "UPDATE t_insurance SET insNo=?2, startTime=?3,endTime=?4,brandModeltwo=?6,remark=?5 ,makeTime=now() WHERE vSn=?1", nativeQuery = true)
	void update(String vSn, String insNo, Date startTime, Date endTime, String remark, String brandModeltwo);

	@Modifying
	@Query(value = "UPDATE t_insurance SET vehicleInspection='未申请' WHERE vSn=?1", nativeQuery = true)
	void updateVehicleInspection(String vSn);

}
