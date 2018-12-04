package com.bailian.car.service.CarMaintain;

import java.util.List;
import com.bailian.car.beans.PageBean;
import com.bailian.car.beans.PageQuery;
import com.bailian.car.common.JsonData;
import com.bailian.car.domain.carmaintain.CarMaintain;
import com.bailian.car.domain.carmaintain.Employee;
import com.bailian.car.domain.system.User;
import com.bailian.car.param.CarmaintainApply;
import com.bailian.car.param.CarmaintainAssign;
import com.bailian.car.param.CarmaintainComplete;
import com.bailian.car.param.MaintainQueryParam;
import com.bailian.car.param.ScreenResult;

public interface CarMaintainService {

	JsonData apply(CarmaintainApply carmaintainApply);

	JsonData assign(CarmaintainAssign carmaintainAssign);

	JsonData complete(CarmaintainComplete carmaintainComplete);

	JsonData top(Integer id);

	PageBean<CarMaintain> pageQuery(PageQuery pageQuery, MaintainQueryParam maintainQueryParam);

	ScreenResult findScreen(PageQuery pQuery);

	List<Employee> getAllEmployee();

	JsonData addEmployee(Employee employee);

	JsonData delEmployee(String[] ids);

	void updtaStatus();

	JsonData updateEmployee(Employee employee);

	List<User> findEmployee();

	JsonData supplement(CarMaintain carMaintain);

	JsonData delete(String ids);

	JsonData edit(CarmaintainApply carmaintainApply);


}