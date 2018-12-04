package com.bailian.car.service.cars.car;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.bailian.car.beans.PageBean;
import com.bailian.car.beans.PageQuery;
import com.bailian.car.common.JsonData;
import com.bailian.car.domain.cars.car.Customer;
import com.bailian.car.param.CustomerQueryParam;

public interface CustomerService {

	JsonData save(Customer customer);

	JsonData update(Customer customer);

	JsonData delete(String[] ids);

	PageBean<Customer> pagaeQuery(PageQuery pageQuery, CustomerQueryParam customerQueryParam);

	public int insertDBByExcel(MultipartFile file, String filename);

	List<String> like(String name);

}
