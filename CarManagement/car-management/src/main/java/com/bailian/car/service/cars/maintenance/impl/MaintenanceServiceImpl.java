package com.bailian.car.service.cars.maintenance.impl;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bailian.car.common.JsonData;
import com.bailian.car.dao.CarMaintain.CarMaintainRepository;
import com.bailian.car.dao.cars.maintenance.MaintenanceItemRepository;
import com.bailian.car.dao.cars.maintenance.VehicleMaintenanceRecordsRepository;
import com.bailian.car.domain.carmaintain.CarMaintain;
import com.bailian.car.domain.cars.carmaintenance.MaintenanceItem;
import com.bailian.car.domain.cars.carmaintenance.VehicleMaintenanceRecords;
import com.bailian.car.service.cars.maintenance.MaintenanceService;
import com.bailian.car.utils.DateUtils;
import com.bailian.car.utils.JsonMapper;
import com.bailian.car.utils.TokenManagerUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class MaintenanceServiceImpl implements MaintenanceService {

	@Autowired
	private CarMaintainRepository carMaintainRepository;
	@Autowired
	private MaintenanceItemRepository maintenanceItemRepository;
	@Autowired
	private VehicleMaintenanceRecordsRepository vehicleMaintenanceRecordsRepository;

	@Override
	public JsonData save(String vSn, String mm, String nt,Integer mid,List<MaintenanceItem> maintenanceItems)
			throws ParseException {
		// String nickname = TokenManagerUtils.getNickname(); TODO
		if (StringUtils.isBlank(vSn)) {
			return JsonData.fail("请输入车辆编号");
		}
		CarMaintain car = carMaintainRepository.findByvSn(vSn, mid);

		if (car == null) {
			return JsonData.fail("此车辆不存在");
		}

		VehicleMaintenanceRecords vehicleMaintenanceRecords = new VehicleMaintenanceRecords();

		vehicleMaintenanceRecords.setvSn(vSn);
		vehicleMaintenanceRecords.setMaintenanceMileage(mm);
		vehicleMaintenanceRecords.setNextMaintenanceTime(DateUtils.String2date(nt));
		vehicleMaintenanceRecords.setMaintenanceTime(new Date());
		vehicleMaintenanceRecords.setMaintenanceOperator(TokenManagerUtils.getNickname()); // TODD
		vehicleMaintenanceRecords.setOperatorTime(new Date());
		vehicleMaintenanceRecordsRepository.save(vehicleMaintenanceRecords);
		log.info("vehicleMaintenanceRecords:{}", vehicleMaintenanceRecords);
		maintenanceItemRepository.save(maintenanceItems);

		log.info("maintenanceItems:{}", maintenanceItems);
		vehicleMaintenanceRecords.setMaintenanceItem(maintenanceItems);
		return JsonData.success("保养记录添加成功");
	}

	@Override
	public List<VehicleMaintenanceRecords> getMaintenanceByvSn(String vSn) {

		List<VehicleMaintenanceRecords> maintenance = vehicleMaintenanceRecordsRepository.findByvSn(vSn);
		log.info("maintenance:{}", maintenance);
		return maintenance;
	}

	@Override
	public JsonData delete(String[] ids) {

		log.info("ids:{}", JsonMapper.obj2String(ids));
		if (ids == null) {
			return JsonData.fail("请你至少选择一条记录");
		}

		if (ids.length < 0) {
			return JsonData.fail("请你至少选择一条记录");
		}

		for (String id : ids) {
			vehicleMaintenanceRecordsRepository.delete(Integer.parseInt(id));
		}
		return JsonData.success("删除成功");
	}

}
