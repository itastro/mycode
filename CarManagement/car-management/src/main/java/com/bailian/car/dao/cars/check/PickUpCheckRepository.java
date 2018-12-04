package com.bailian.car.dao.cars.check;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bailian.car.domain.carcheck.PickUpCheck;

public interface PickUpCheckRepository extends JpaRepository<PickUpCheck, Integer> {

	PickUpCheck findByvSn(String vSn);

}
