package com.bailian.car.service.checktable.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bailian.car.dao.cars.checktable.CheckParentItemRepository;
import com.bailian.car.dao.cars.checktable.CheckTypeRepository;
import com.bailian.car.domain.cars.checktable.CheckParentItem;
import com.bailian.car.domain.cars.checktable.CheckType;
import com.bailian.car.param.CheckItemId;
import com.bailian.car.service.checktable.CheckTableService;
@Service
@Transactional
public class CheckTableServiceImpl implements CheckTableService {

	@Autowired
	private CheckParentItemRepository checkParentItemRepository;

	@Autowired
	private CheckTypeRepository checkTypeRepository;

	@Override
	public List<CheckParentItem> findSafeTable() {

		CheckType checkType = checkTypeRepository.findOne(CheckItemId.SAFE);
		List<CheckParentItem> safe = checkType.getCarCheckParentItems();
		return safe;
	}

	@Override
	public List<CheckParentItem> findHiTable() {
		CheckType checkType = checkTypeRepository.findOne(CheckItemId.HI);
		List<CheckParentItem> HI = checkType.getCarCheckParentItems();
		return HI;
	}

	@Override
	public List<CheckParentItem> findBomTable() {
		CheckType checkType = checkTypeRepository.findOne(CheckItemId.BOM);
		List<CheckParentItem> bom = checkType.getCarCheckParentItems();
		return bom;
	}

}
