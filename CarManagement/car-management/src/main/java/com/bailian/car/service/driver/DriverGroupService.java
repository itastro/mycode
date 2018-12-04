package com.bailian.car.service.driver;

import java.util.List;

import com.bailian.car.common.JsonData;
import com.bailian.car.domain.cardriver.DriverGroup;

public interface DriverGroupService {

	void save(DriverGroup group);

	List<DriverGroup> getGroup();

	JsonData deleteGroup(String[] ids);

	JsonData updateGroup(DriverGroup dGroup);

}
