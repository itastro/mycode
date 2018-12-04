package com.bailian.car.service.cars.car.impl;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bailian.car.common.JsonData;
import com.bailian.car.dao.cars.car.GroupReposity;
import com.bailian.car.domain.cars.car.CarGroup;
import com.bailian.car.service.cars.car.CarGroupSrrvice;
import com.bailian.car.utils.JsonMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class CarGroupServiceImpl implements CarGroupSrrvice {
	@Autowired
	private GroupReposity groupReposity;

	@Override
	// @RequiresRoles("carmanagement")
	public JsonData add(CarGroup carGroup) {
		log.info("carGroup:{}", JsonMapper.obj2String(carGroup));
		// TODO Auto-generated method stub
		groupReposity.save(carGroup);
		return JsonData.success("添加成功");
	}

	@Override
	public List<CarGroup> findAll() {
		// TODO Auto-generated method stub
		return groupReposity.findAll();
	}

	@Override
	public JsonData delete(String[] gids) {
		log.info("gids:{}", JsonMapper.obj2String(gids));
		if (gids != null) {
			if (gids.length > 0) {
				for (String id : gids) {
					CarGroup group = groupReposity.findOne(Integer.parseInt(id));
					if (group != null) {
						groupReposity.delete(Integer.parseInt(id));
					}
				}
				return JsonData.success("删除成功");
			}
			return JsonData.fail("请选择要删除的分组");
		}
		return JsonData.fail("请选择要删除的分组");

	}

	@Override
	public JsonData update(CarGroup carGroup) {
		groupReposity.save(carGroup);
		return JsonData.success("更新成功");
	}

	@Override
	public CarGroup findByName(String name) {
		// TODO Auto-generated method stub
		CarGroup group = groupReposity.findByName(name);

		return group;
	}

}
