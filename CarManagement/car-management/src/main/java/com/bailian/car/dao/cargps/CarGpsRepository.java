package com.bailian.car.dao.cargps;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.bailian.car.domain.cargps.CarGps;


public interface CarGpsRepository extends JpaRepository<CarGps, Integer> ,JpaSpecificationExecutor<CarGps>{

	CarGps findByGpsSn(String gpsSn);

	CarGps findByVSn(String cvSn);
	
	

}
