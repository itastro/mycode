package com.bailian.car.dao.cars.car;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bailian.car.domain.cars.car.HistoryInsurance;

public interface HistoryInsuranceRepository extends JpaRepository<HistoryInsurance, Integer> {

	@Query(value = "SELECT * FROM t_historyinsurance WHERE ID = (SELECT MAX(ID) FROM t_historyinsurance WHERE vSn=?1) AND (insNo IS NULL OR insNo='')", nativeQuery = true)
	HistoryInsurance findByNewHistoryInsurance(String vSn);

	@Query(value = "SELECT * FROM t_historyinsurance WHERE vSn=?1 ORDER BY makeTime DESC", nativeQuery = true)
	List<HistoryInsurance> findByvSn(String vSn);

}
