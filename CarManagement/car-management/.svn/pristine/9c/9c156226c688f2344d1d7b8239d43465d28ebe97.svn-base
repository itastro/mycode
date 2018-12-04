package com.bailian.car.service.cars.license;

import java.util.List;

import com.bailian.car.beans.PageBean;
import com.bailian.car.beans.PageQuery;
import com.bailian.car.common.JsonData;
import com.bailian.car.domain.cars.car.HistoryLicense;
import com.bailian.car.dto.LicenseDto;
import com.bailian.car.param.LicSearchParam;
import com.bailian.car.param.LicenseParam;

public interface LicenseService {

	PageBean<LicenseDto> pageQuery(PageQuery pageQuery, LicSearchParam licSearchParam);

	JsonData vehicleInspectionCheck(String vSn);

	JsonData generateVehicleInspection(String vSn);

	JsonData saveLicenese(LicenseParam license);

	List<HistoryLicense> historyLicenseByvSn(String vSn);

	JsonData updateLicense(LicenseParam license);

	JsonData cancle(String vSn);

}
