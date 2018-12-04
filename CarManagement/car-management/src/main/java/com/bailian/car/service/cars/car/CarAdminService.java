package com.bailian.car.service.cars.car;

import java.util.List;

import com.bailian.car.common.JsonData;
import com.bailian.car.domain.cars.car.CarAdmin;

public interface CarAdminService {

	JsonData save(CarAdmin carAdmin);

	JsonData delete(String[] ids);

	List<CarAdmin> find();

	JsonData update(CarAdmin carAdmin);

}
