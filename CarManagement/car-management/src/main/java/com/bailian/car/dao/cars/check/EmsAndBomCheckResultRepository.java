package com.bailian.car.dao.cars.check;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bailian.car.domain.carcheckresult.EmsAndBomCheckResult;

public interface EmsAndBomCheckResultRepository extends JpaRepository<EmsAndBomCheckResult, String> {

	List<EmsAndBomCheckResult> findByvSn(String vSn);

	//EmsAndBomCheckResult findByBomName(String bomName);
	
	EmsAndBomCheckResult findByBomNameAndVSn(String bomName, String vSn);

}
