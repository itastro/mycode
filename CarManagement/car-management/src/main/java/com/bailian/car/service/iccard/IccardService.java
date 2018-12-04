package com.bailian.car.service.iccard;

import java.util.List;

import com.bailian.car.beans.PageBean;
import com.bailian.car.beans.PageQuery;
import com.bailian.car.common.IccardResult;
import com.bailian.car.common.JsonData;
import com.bailian.car.common.LedResult;
import com.bailian.car.domain.iccard.Iccard;
import com.bailian.car.domain.iccard.IccardUseHistory;
import com.bailian.car.param.IccardSearch;
import com.bailian.car.param.WriteCarCard;

public interface IccardService {

	JsonData insert(IccardUseHistory iccardUseHistory);

	JsonData save(Iccard iccard);

	List<Iccard> findSuppercarid();

	List<Iccard> findBackcarid();

	List<Iccard> findDrivercarid();

	List<Iccard> findcarid();

	PageBean<Iccard> findAll(PageQuery pQuery, IccardSearch search);

	JsonData delete(Integer id);

	JsonData update(Iccard iccard);

	IccardResult vehicleBindingcard(WriteCarCard writeCarCard);

	LedResult searchAuth(String codeOne, String codeTwo, String io);

	IccardResult carIn(String carSn, String personSn);

}
