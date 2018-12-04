package com.bailian.car.service.driver.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bailian.car.common.JsonData;
import com.bailian.car.dao.driver.DriverGroupRepository;
import com.bailian.car.domain.cardriver.DriverGroup;
import com.bailian.car.service.driver.DriverGroupService;
import com.bailian.car.utils.JsonMapper;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class DriverGroupServiceImpl implements DriverGroupService {

	@Autowired
	private DriverGroupRepository driverGroupRepository;

	@Override
	public void save(DriverGroup group) {
		log.info("group:{}", JsonMapper.obj2String(group));
		driverGroupRepository.save(group);
	}

	@Override
	public List<DriverGroup> getGroup() {
		List<DriverGroup> findAll = driverGroupRepository.findAll();
		log.info("findAll:{}", JsonMapper.obj2String(findAll));
		return findAll;
	}

	@Override
	public JsonData deleteGroup(String[] ids) {
		log.info("ids:{}", JsonMapper.obj2String(ids));
		if (ids != null) {
			if (ids.length > 0) {
				for (String id : ids) {

					DriverGroup driverGroup = driverGroupRepository.findOne(Integer.parseInt(id));
					driverGroup.setDriver(null);
					driverGroupRepository.delete(Integer.parseInt(id));
				}
				return JsonData.success("删除分组成功");
			}
			return JsonData.fail("请选择分组");
		}
		return JsonData.fail("请选择分组");
	}

	@Override
	public JsonData updateGroup(DriverGroup dGroup) {
		log.info("dGroup:{}", JsonMapper.obj2String(dGroup));

		driverGroupRepository.save(dGroup);
		return JsonData.success("更新成功");
	}

}
