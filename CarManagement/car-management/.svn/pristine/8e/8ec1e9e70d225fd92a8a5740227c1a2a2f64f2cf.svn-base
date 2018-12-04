package com.bailian.car.service.oil;

import org.springframework.web.multipart.MultipartFile;

import com.bailian.car.beans.PageBean;
import com.bailian.car.beans.PageQuery;
import com.bailian.car.common.JsonData;
import com.bailian.car.domain.cars.car.OilCard;
import com.bailian.car.param.AddOilParam;
import com.bailian.car.param.OilSearch;

public interface OilService {

	JsonData oil_batchimport(MultipartFile file) throws Exception;

	PageBean<OilCard> query(PageQuery pQuery, OilSearch OilSearch);

	JsonData save(AddOilParam aParam);

}
