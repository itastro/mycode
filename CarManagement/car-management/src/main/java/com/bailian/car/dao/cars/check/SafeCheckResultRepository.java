package com.bailian.car.dao.cars.check;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bailian.car.domain.carcheckresult.SafeCheckResult;

public interface SafeCheckResultRepository extends JpaRepository<SafeCheckResult, String> {

	List<SafeCheckResult> findByvSn(String vSn);

	SafeCheckResult findByItemAndVSn(String item, String vSn);

}
