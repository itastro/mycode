package com.bailian.car.service.cars.develop.impl;

import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bailian.car.common.JsonData;
import com.bailian.car.dao.cars.develop.DevelopToolsRecordRepository;
import com.bailian.car.domain.cars.develop.DevelopToolsRecord;
import com.bailian.car.service.cars.develop.DevelopToolsRecordService;
import com.bailian.car.utils.DateUtils;
import com.bailian.car.utils.TokenManagerUtils;

import lombok.extern.slf4j.Slf4j;

@Transactional
@Service
@Slf4j
public class DevelopToolsRecordServiceImpl implements DevelopToolsRecordService {

	@Autowired
	private DevelopToolsRecordRepository developToolsRecordRepository;

	@Override
	public List<DevelopToolsRecord> findDevelopToolsRecordByvSn(String vSn) {
		log.info("vSn:{}", vSn);
		List<DevelopToolsRecord> developResult = developToolsRecordRepository.findByvSn(vSn);

		return developResult;
	}
	
	
	@RequiresRoles(value = { "admin", "maintain" }, logical = Logical.OR)
	@Override
	public JsonData developEquipment(Integer did, Date equippedDate, String remark) {
		if (did == null) {
			log.error("did不能为null");
			return JsonData.fail("did不能为null");
		}
		log.info("developToolsRecords:{}", did);
		// String nickname = TokenManagerUtils.getNickname();
		String operator = TokenManagerUtils.getNickname();
		log.info("operator:{},equippedDate:{}", operator, DateUtils.Date2String(equippedDate));
		developToolsRecordRepository.developEquipment(did, operator, equippedDate, remark);
		return JsonData.success("研发工具装备成功");
	}

	@Override
	public JsonData toolsRemove(Integer did) {
		log.info("did:{}", did);
		String demolitionOperator = TokenManagerUtils.getNickname();
		Date demolitionDate = new Date();
		developToolsRecordRepository.toolsRemove(did, demolitionOperator, demolitionDate);
		return JsonData.success("研发工具拆除成功");

	}

}
