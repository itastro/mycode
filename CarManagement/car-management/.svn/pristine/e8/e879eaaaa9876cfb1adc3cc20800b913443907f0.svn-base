package com.bailian.car.service.cars.car.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bailian.car.common.JsonData;
import com.bailian.car.dao.cars.car.CarAdminRepository;
import com.bailian.car.dao.cars.car.CarRepository;
import com.bailian.car.domain.cars.car.CarAdmin;
import com.bailian.car.exception.PermissionException;
import com.bailian.car.service.cars.car.CarAdminService;

@Transactional
@Service
public class CarAdminServiceImpl implements CarAdminService {

	@Autowired
	private CarAdminRepository carAdminRepository;

	@Autowired
	private CarRepository carRepository;

	@Override
	public JsonData save(CarAdmin carAdmin) {
		CarAdmin cAdmin = carAdminRepository.findByAdminName(carAdmin.getAdminName());
		if (cAdmin != null) {
			return JsonData.fail("此车管已经存在");
		}
		carAdminRepository.save(carAdmin);
		return JsonData.success("车管添加成功");
	}

	@Override
	public JsonData delete(String[] ids) {
		try {
			for (String id : ids) {
				CarAdmin carAdmin = carAdminRepository.findOne(Integer.parseInt(id));
				String name = carAdmin.getAdminName();
				carRepository.updateCarAdmin(name);
				carAdminRepository.delete(carAdmin);
			}
			return JsonData.success("删除成功");
		} catch (Exception e) {
			throw new PermissionException("系统开小差了");
		}

	}

	@Override
	public List<CarAdmin> find() {
		List<CarAdmin> list = carAdminRepository.findAll();
		return list;
	}

	@Override
	public JsonData update(CarAdmin carAdmin) {
		
		CarAdmin cAdmin = carAdminRepository.findOne(carAdmin.getId());
		
		carRepository.updateCarAdmin(cAdmin.getAdminName(),carAdmin.getAdminName());
		return JsonData.success("成功");
	}

}
