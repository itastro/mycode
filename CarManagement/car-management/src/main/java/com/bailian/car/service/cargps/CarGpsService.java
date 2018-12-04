package com.bailian.car.service.cargps;

import com.bailian.car.beans.PageBean;
import com.bailian.car.beans.PageQuery;
import com.bailian.car.common.JsonData;
import com.bailian.car.domain.cargps.CarGps;
import com.bailian.car.dto.GpsCarDto;
import com.bailian.car.param.CarGpsSearch;
import com.bailian.car.param.CarQueryOrder;

public interface CarGpsService {
	
	
	JsonData check(String vSn,String gpsSn);
	
	JsonData carGpsBind(String vSn,String gpsSn );
	
	PageBean<CarGps>  pageQuery(PageQuery pQuery,CarGpsSearch carGpsSearch);
	
PageBean<GpsCarDto> gpsOnline(PageQuery pQuery);

 PageBean<GpsCarDto> currentDayGps(PageQuery pQuery);

}
