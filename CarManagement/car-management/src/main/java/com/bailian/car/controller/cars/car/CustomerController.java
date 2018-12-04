package com.bailian.car.controller.cars.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bailian.car.beans.PageBean;
import com.bailian.car.beans.PageQuery;
import com.bailian.car.common.JsonData;
import com.bailian.car.domain.cars.car.Customer;
import com.bailian.car.param.CustomerQueryParam;
import com.bailian.car.service.cars.car.CustomerService;

@RequestMapping("/customer")
@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping("/save.action")
	@ResponseBody
	public JsonData save(Customer customer) {

		return customerService.save(customer);

	}

	@RequestMapping("/delete.action")
	@ResponseBody
	public JsonData delete(String[] ids) {

		return customerService.delete(ids);

	}

	@RequestMapping("/update.action")
	@ResponseBody
	public JsonData update(Customer customer) {

		return customerService.update(customer);

	}
	
	@RequestMapping("/query.action")
	@ResponseBody
	public PageBean<Customer> query(PageQuery pageQuery,CustomerQueryParam customerQueryParam) {

		return customerService.pagaeQuery(pageQuery, customerQueryParam);

	}


}
