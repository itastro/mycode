package com.bailian.car.service.driver;
import java.util.HashMap;

import com.bailian.car.beans.PageBean;
import com.bailian.car.beans.PageQuery;
import com.bailian.car.common.JsonData;
import com.bailian.car.domain.cardriver.InAndOut;
import com.bailian.car.domain.iccard.IccardUseHistory;

public interface InAndOutService {

	PageBean<IccardUseHistory> pageQuery(PageQuery pageQuery);

	JsonData delete(String[] ids);

	IccardUseHistory getNewInAndOut();

}
