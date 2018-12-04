package com.bailian.car.dao.cars.check;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bailian.car.domain.carcheck.ClacyLindersss;

public interface ClacyLindersssRepository extends JpaRepository<ClacyLindersss, Integer>{

	ClacyLindersss findByvSn(String sn);

}
