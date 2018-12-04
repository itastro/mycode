package com.bailian.car.service.cars.check;

import java.util.List;

import com.bailian.car.beans.PageBean;
import com.bailian.car.beans.PageQuery;
import com.bailian.car.common.JsonData;
import com.bailian.car.domain.carcheck.BackCheck;
import com.bailian.car.domain.carcheck.ClacyLindersss;
import com.bailian.car.domain.carcheck.PickUpCheck;
import com.bailian.car.domain.carcheck.Reviewer;
import com.bailian.car.domain.carcheckresult.EmsAndBomCheckResult;
import com.bailian.car.domain.carcheckresult.HIResult;
import com.bailian.car.domain.carcheckresult.SafeCheckResult;
import com.bailian.car.domain.cars.car.Car;
import com.bailian.car.param.CheckResult;
import com.bailian.car.param.ReviewerInfo;

public interface CarCheckService {

	JsonData save(PickUpCheck pickUpCheck);

	PickUpCheck findByvSn(String vSn);

	BackCheck findBackByvSn(String vSn);

	JsonData update(PickUpCheck pickUpCheck);

	JsonData developBackCheck(BackCheck backCheck);

	JsonData saveBackCheck(BackCheck backCheck);

	String getvSn(String vSn);

	JsonData save(ClacyLindersss clacyLindersss);

	JsonData updateCld(ClacyLindersss clacyLindersss);

	ClacyLindersss findCld(String vSn);

	JsonData saveSafeCheck(List<SafeCheckResult> safeCheckResult, String vSn);

	CheckResult findSafeResult(String vSn);

	JsonData update(List<SafeCheckResult> safeCheckResult, String vSn);
	
	JsonData confirmSafe(List<SafeCheckResult> safeCheckResult, String vSn);

	JsonData save(List<HIResult> hIResults, String vSn);

	JsonData hiupdate(List<HIResult> hIResult, String vSn);

	CheckResult findHiResult(String vSn);

	CheckResult findBomResult(String vSn);

	JsonData saveBom(List<EmsAndBomCheckResult> emsAndBomCheckResults, String vSn);

	JsonData updateEmsAndBom(List<EmsAndBomCheckResult> emsAndBomCheckResults, String vSn);

	Reviewer findReview(String vSn);

	ReviewerInfo getReviewInfo(String vSn);

	JsonData doReview(String vSn, String status, String explanation);


	PageBean<Car> checking(PageQuery pageQuery);

	PageBean<Car> waitchecking(PageQuery pageQuery);

	PageBean<Car> completeCheck(PageQuery pageQuery);

	
   

}
