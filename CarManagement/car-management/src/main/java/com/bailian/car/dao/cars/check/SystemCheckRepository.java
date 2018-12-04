package com.bailian.car.dao.cars.check;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bailian.car.domain.carcheck.SystemCheck;

public interface SystemCheckRepository extends JpaRepository<SystemCheck, Integer> {

	SystemCheck findByvSn(String vSn);

}
