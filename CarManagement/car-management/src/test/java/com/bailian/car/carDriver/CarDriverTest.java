package com.bailian.car.carDriver;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import com.bailian.car.beans.PageBean;
import com.bailian.car.beans.PageQuery;
import com.bailian.car.dto.GpsCarDto;
import com.bailian.car.service.cargps.CarGpsService;
import com.bailian.car.utils.JsonMapper;

import lombok.extern.slf4j.Slf4j;
@Slf4j

@Transactional
@WebAppConfiguration
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class CarDriverTest {
	
	@Autowired
	private  CarGpsService carGpsService;
	
	@Test
	public void Test1() {
		
	PageQuery pageQuery=	new PageQuery();
	   PageBean<GpsCarDto> pageBean = carGpsService.gpsOnline(pageQuery);
	   System.err.println(JsonMapper.obj2String(pageBean));
		
	}

}
