package com.bailian.car.service.cars.insurance;

import java.util.List;

import com.bailian.car.beans.PageBean;
import com.bailian.car.beans.PageQuery;
import com.bailian.car.common.JsonData;
import com.bailian.car.domain.cars.car.CarInsurance;
import com.bailian.car.domain.cars.car.HistoryInsurance;
import com.bailian.car.dto.InsuranceDto;
import com.bailian.car.param.AddInsuranceParam;
import com.bailian.car.param.InsSearchParam;

public interface InsuranceService {

	JsonData applyInsurance(String[] vSns, Integer numtime);

	PageBean<CarInsurance> pageQuery(PageQuery pageQuery);

	JsonData addInsurance(AddInsuranceParam addInsuranceParam);

	List<HistoryInsurance> findByvSn(String vSn);

	PageBean<InsuranceDto> pageQuery1(PageQuery pageQuery, InsSearchParam insSearchParam);

	JsonData updateInsurance(AddInsuranceParam insuranceParam);

}
