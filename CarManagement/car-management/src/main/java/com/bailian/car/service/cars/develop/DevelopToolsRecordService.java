package com.bailian.car.service.cars.develop;

import java.util.Date;
import java.util.List;

import com.bailian.car.common.JsonData;
import com.bailian.car.domain.cars.develop.DevelopToolsRecord;

public interface DevelopToolsRecordService {

	List<DevelopToolsRecord> findDevelopToolsRecordByvSn(String vSn);

	JsonData toolsRemove(Integer did);

	JsonData developEquipment(Integer did, Date equippedDate, String remark);

}
