package com.bailian.car.dao.cars.maintenance;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bailian.car.domain.cars.carmaintenance.MaintenanceItem;

/**
 * 
    * @ClassName: MaintenanceRepository
    * @Description: 保养项目持久层
    * @author itastro
    * @date 2018年4月16日
    *
 */
public interface MaintenanceItemRepository extends JpaRepository<MaintenanceItem, Integer> {

}
