package com.bailian.car.dao.cars.check;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bailian.car.domain.carcheck.Reviewer;

public interface ReviewerRepository extends JpaRepository<Reviewer, Integer> {

	Reviewer findByvSn(String vSn);

	@Query(value = " SELECT * FROM car.t_reviewer WHERE ((bomCheckPerson ='' OR bomCheckPerson IS NULL ) OR (hiCheckPerson='' OR hiCheckPerson IS NULL) OR (safeCheckPerson='' or safeCheckPerson IS NULL) OR (bomCheckingPerson ='' OR bomCheckingPerson IS NULL ) OR (hiCheckingPerson='' OR hiCheckingPerson IS NULL) OR (safeCheckingPerson='' or safeCheckingPerson IS NULL) OR (confirmPerson = '' OR confirmPerson IS NULL) ) AND vSn=?1", nativeQuery = true)
	Reviewer ifCheckCompltefindByvSn(String vSn);

}
