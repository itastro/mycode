package com.bailian.car.dao.iccard;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.bailian.car.domain.iccard.Iccard;

public interface IccardRepository extends JpaRepository<Iccard, Integer> ,JpaSpecificationExecutor<Iccard>{

	@Query(value = "SELECT * FROM iccard where CARDTYPE=3", nativeQuery = true)
	List<Iccard> findSuppercarid();

	@Query(value = "SELECT * FROM iccard where CARDTYPE=2", nativeQuery = true)
	List<Iccard> findbackcarid();

	@Query(value = "SELECT * FROM iccard where CARDTYPE=1", nativeQuery = true)
	List<Iccard> findDrivercarid();

	@Query(value = "SELECT * FROM iccard where CARDTYPE=0", nativeQuery = true)
	List<Iccard> findcarid();

	Iccard findByIccard(String personSn);

	@Query(value = "SELECT CARDTYPE FROM iccard where ICID=?1", nativeQuery = true)
	Integer findByCarType(String codeOne);

}
