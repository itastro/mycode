package com.bailian.car.service.cars.car;

import java.util.List;

import com.bailian.car.common.JsonData;
import com.bailian.car.domain.cars.car.CarGroup;

public interface CarGroupSrrvice {

	public JsonData add(CarGroup carGroup);

	public List<CarGroup> findAll();

	public JsonData delete(String[] gids);

	public JsonData update(CarGroup carGroup);

	public CarGroup findByName(String name);
	
	

}
