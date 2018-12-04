package com.bailian.car.service.driver;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import com.bailian.car.beans.PageBean;
import com.bailian.car.beans.PageQuery;
import com.bailian.car.common.JsonData;
import com.bailian.car.domain.cardriver.Driver;
import com.bailian.car.param.DriverSearchParam;

public interface DriverService {

	JsonData add(Driver carDriver);

	PageBean<Driver> pageQuery(PageQuery pageQuery, DriverSearchParam searchParam);

	JsonData delete(String[] ids);

	Driver findById(Integer id);

	JsonData updatedriver(Driver carDriver);

	JsonData authorized(String[] ids, Date startTime, Date endTime, String[] gid);

	JsonData cancelAuthorized(String[] ids, String[] gids);

	int insertDBByExcel(InputStream inputStream,String fileName) throws IOException;

	JsonData insertDBByExcel(MultipartFile file, String filename);
}
