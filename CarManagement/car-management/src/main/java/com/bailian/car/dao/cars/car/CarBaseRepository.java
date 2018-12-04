package com.bailian.car.dao.cars.car;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bailian.car.domain.cars.car.CarBase;

public interface CarBaseRepository extends JpaRepository<CarBase, Integer> {

	CarBase findByvSn(String getvSn);
	
	

}
