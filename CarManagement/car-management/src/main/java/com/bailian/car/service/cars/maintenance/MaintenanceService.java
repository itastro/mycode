package com.bailian.car.service.cars.maintenance;

import java.text.ParseException;
import java.util.List;

import com.bailian.car.common.JsonData;
import com.bailian.car.domain.cars.carmaintenance.MaintenanceItem;
import com.bailian.car.domain.cars.carmaintenance.VehicleMaintenanceRecords;

public interface MaintenanceService {

	JsonData save(String vSn, String mm, String nt, Integer mid, List<MaintenanceItem> maintenanceItems)
			throws ParseException;

	List<VehicleMaintenanceRecords> getMaintenanceByvSn(String vSn);

	JsonData delete(String[] ids);

}
