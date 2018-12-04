package com.bailian.car.dao.cars.check;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bailian.car.domain.carcheck.*;;

public interface SafeCheckRepository extends JpaRepository<SafeCheck, Integer> {

	SafeCheck findByvSn(String vSn);

}
