package com.bailian.car.service.cars.car;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.web.multipart.MultipartFile;

import com.bailian.car.beans.PageBean;
import com.bailian.car.beans.PageQuery;
import com.bailian.car.common.JsonData;
import com.bailian.car.domain.cars.car.Car;
import com.bailian.car.domain.cars.car.CarBase;
import com.bailian.car.param.ApplyBom;
import com.bailian.car.param.ApplyTools;
import com.bailian.car.param.CarParam;
import com.bailian.car.param.CarQueryOrder;
import com.bailian.car.param.CarQueryParam;
import com.bailian.car.vo.MapVo;

public interface CarService {

	JsonData save(CarParam param);

	CarBase getAddCar(String vSn);

	JsonData update(CarBase param);

	PageBean<Car> pageQuery(PageQuery pageQuery, CarQueryParam carQueryParam);

	JsonData deleteCar(String[] ids);

	List<String> findAllvSn(String vSn);

	Car findCarByvSn(String vSn);

	// int insertDBByExcel(InputStream inputStream, String filename);

	JsonData savebom(List<ApplyBom> applyBoms);

	JsonData savatools(List<ApplyTools> applyTools);

	PageBean<Car> orderQuery(PageQuery pQuery, CarQueryOrder cOrder);

	List<Car> findAll();

	List<MapVo> showTrack1(Date startDate, Date endDate, String vSn);

	int insertDBByExcel(MultipartFile file, String filename)
			throws IllegalStateException, InvalidFormatException, IOException;

	JsonData upload(MultipartFile uploadFile, String vSn, String iMAGE_SERVER_URL) throws Exception;

	JsonData updateVehicleTestingStationType(String vSn, String type);

	JsonData vehicleRelateGps(String vSn, String gps);

	JsonData vehicleCancleGps(String vSn);

	JsonData circuitPicUpload(MultipartFile uploadFile, String vSn, String iMAGE_SERVER_URL);

	PageBean<Car> pageQuery2(PageQuery pageQuery, CarQueryParam carQueryParam);

	void carCheck();

	void updateCheck();

	JsonData uploadbom(MultipartFile uploadFile, String vSn, String iMAGE_SERVER_URL) throws InterruptedException, Exception;
	JsonData updateBackCheckStatus(Integer id);

	JsonData updateVVV();
}
