package com.bailian.car.dao.cars.car;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.bailian.car.domain.cars.car.CarPosition;

public interface CarPositionRepository extends JpaRepository<CarPosition, Integer> {

	List<CarPosition> findByColltimeBetweenAndCarcode(Date startDtae, Date endDate, String gpsSN);

	@Query(value = "SELECT DISTINCT LONGITUDE2,LATITUDE2,TOWARDS FROM t_carposition WHERE coll_time BETWEEN ?1 AND ?2 AND CAR_CODE = ?3", nativeQuery = true)
	String[] findGps(@Param("startDtae") Date startDtae, @Param("endDate") Date endDate,
			@Param("car_code") String gpsSN);

	@Query(value = "SELECT LONGITUDE2,LATITUDE2,TOWARDS FROM t_carposition WHERE CARPOSITIONID = (SELECT MIN(CARPOSITIONID) FROM t_carposition WHERE CAR_CODE=?3 AND coll_time BETWEEN ?1 AND ?2)", nativeQuery = true)
	String[] findOneGps(Date startDate, Date endDate, String gpsSN);

	@Query(value = "SELECT LONGITUDE2,LATITUDE2,TOWARDS FROM t_carposition WHERE CARPOSITIONID = (SELECT MAX(CARPOSITIONID) FROM t_carposition WHERE coll_time BETWEEN ?1 and ?2 and CAR_CODE=?3)", nativeQuery = true)

	String[] findLastGps(Date startDate, Date endDate, String gpsSN);

	
	@Query(value = "SELECT * FROM t_carposition WHERE CAR_CODE=?1", nativeQuery = true)

	List<CarPosition> findByGps(String gps);

}
