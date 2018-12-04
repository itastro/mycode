package com.bailian.car.service.cars.car.impl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.bailian.car.beans.PageBean;
import com.bailian.car.beans.PageQuery;
import com.bailian.car.common.JsonData;
import com.bailian.car.dao.cars.car.CustomerRepository;
import com.bailian.car.domain.cars.car.Customer;
import com.bailian.car.param.CustomerQueryParam;
import com.bailian.car.service.cars.car.CustomerService;
import com.bailian.car.utils.ExcelUtils;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public JsonData save(Customer customer) {
		customerRepository.save(customer);
		return JsonData.success("保存成功");
	}

	@Override
	public JsonData update(Customer customer) {
		customerRepository.save(customer);
		return JsonData.success("更新成功");
	}

	@Override
	public JsonData delete(String[] ids) {
		if ("[]".equals(ids)) {
			return JsonData.fail("请选择删除行");
		}
		for (String id : ids) {
			customerRepository.delete(Integer.parseInt(id));
		}
		return JsonData.success("删除成功");
	}

	@Override
	public PageBean<Customer> pagaeQuery(PageQuery pageQuery, CustomerQueryParam customerQueryParam) {

		PageBean<Customer> result = new PageBean<>();
		Sort sort = new Sort(Direction.DESC, "id");

		Pageable pageable = new PageRequest(pageQuery.getPage(), pageQuery.getSize(), sort);

		final List<Predicate> list = new ArrayList<>();

		Specification<Customer> specification = new Specification<Customer>() {

			@Override
			public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				if (StringUtils.isNotBlank(customerQueryParam.getCustomerName())) {
					Predicate predicate = cb.like(root.get("name").as(String.class),
							"%" + customerQueryParam.getCustomerName() + "%");
					list.add(predicate);
				}
				return cb.and(list.toArray(new Predicate[list.size()]));
			}
		};
		Page<Customer> pageData = customerRepository.findAll(specification, pageable);
		result.setTotal(pageData.getTotalElements());
		result.setRows(pageData.getContent());
		return result;

	}

	@Override
	public int insertDBByExcel(MultipartFile file, String filename) {
		int count = 0;
		// 调用excel工具类
		List<String[]> readExcel = ExcelUtils.readExcel(file);
		if (readExcel != null && readExcel.size() > 0) {
			// 存库或者其他逻辑的处理
			for (int i = 1; i < readExcel.size(); i++) {
				String[] strings = readExcel.get(i);
				String name = strings[0];
				Customer customer = new Customer();
				customer.setName(name);
				this.save(customer);
				count++;
			}
		}
		return count;
	}

	@Override
	public List<String> like(String name) {
		List<String> lists = customerRepository.like(name);
		return lists;
	}

}
