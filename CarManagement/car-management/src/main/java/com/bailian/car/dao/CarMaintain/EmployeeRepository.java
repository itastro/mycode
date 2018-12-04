package com.bailian.car.dao.CarMaintain;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bailian.car.domain.carmaintain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	Employee findByName(String name);

}
