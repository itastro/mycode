package com.bailian.car.dao.cars.maintenance;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bailian.car.domain.cars.carmaintenance.VehicleMaintenanceRecords;

/**
 * 
    * @ClassName: VehicleMaintenanceRecordsRepository
    * @Description: 车辆保养持久层
    * @author itastro
    * @date 2018年4月16日
    *
 */
public interface VehicleMaintenanceRecordsRepository extends JpaRepository<VehicleMaintenanceRecords, Integer> {

	List<VehicleMaintenanceRecords> findByvSn(String vSn);

}
