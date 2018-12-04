package com.bailian.car.maintenance;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.bailian.car.dao.cars.develop.DevelopToolsRecordRepository;
import com.bailian.car.dao.cars.maintenance.MaintenanceItemRepository;
import com.bailian.car.dao.cars.maintenance.VehicleMaintenanceRecordsRepository;
import com.bailian.car.domain.cars.carmaintenance.MaintenanceItem;
import com.bailian.car.domain.cars.carmaintenance.VehicleMaintenanceRecords;
import com.bailian.car.param.CarmaintainAssign;
import com.bailian.car.service.CarMaintain.CarMaintainService;
import com.bailian.car.service.cars.maintenance.MaintenanceService;
@WebAppConfiguration
@Transactional
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class MaintenanceTest {
	@Autowired
	private CarMaintainService carMaintainService;
	@Autowired
	private MaintenanceService maintenanceService;
	@Autowired
	private MaintenanceItemRepository maintenanceItemRepository;
	@Autowired
	private VehicleMaintenanceRecordsRepository vehicleMaintenanceRecordsRepository;

	@Autowired
	private DevelopToolsRecordRepository developToolsRecordRepository;

	@Test
	@Transactional
	@Rollback(false)
	public void saveTest() {
		ArrayList<MaintenanceItem> maintenanceItems = new ArrayList<>();
		MaintenanceItem maintenanceItem = new MaintenanceItem();
		maintenanceItem.setItemName("机油");
		maintenanceItem.setBrandAndlabel("12#");
		maintenanceItems.add(maintenanceItem);
		MaintenanceItem maintenanceItem1 = new MaintenanceItem();
		maintenanceItem1.setItemName("换防冻液");
		maintenanceItem1.setBrandAndlabel("蓝色");
		maintenanceItems.add(maintenanceItem1);

		VehicleMaintenanceRecords vehicleMaintenanceRecords = new VehicleMaintenanceRecords();

		vehicleMaintenanceRecords.setMaintenanceTime(new Date());
		vehicleMaintenanceRecords.getMaintenanceItem().add(maintenanceItem);
		vehicleMaintenanceRecords.getMaintenanceItem().add(maintenanceItem1);
		vehicleMaintenanceRecords.setNextMaintenanceTime(new Date());
		vehicleMaintenanceRecords.setMaintenanceOperator("itwang");
		int id = 4;
		// maintenanceService.save(vehicleMaintenanceRecords, id);
		vehicleMaintenanceRecordsRepository.saveAndFlush(vehicleMaintenanceRecords);
	}

	@Test
	@Transactional
	@Rollback(false)
	public void saveTest1() {
		CarmaintainAssign assign = new CarmaintainAssign();
		//assign.setForecastTime(new Date());
		assign.setOperator("wang");
		assign.setWorkContent("haha");
		assign.setvSn("123456");
		carMaintainService.assign(assign);
	}

}
