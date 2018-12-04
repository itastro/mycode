package com.bailian.car.dao.cars.car;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.bailian.car.domain.cars.car.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>, JpaSpecificationExecutor<Customer> {
	@Query(value = "SELECT name FROM t_customer WHERE name like CONCAT('%',:name,'%')", nativeQuery = true)
	List<String> like(String name);

}
