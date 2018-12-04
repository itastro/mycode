package com.bailian.car.service.oil.impl;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.bailian.car.beans.PageBean;
import com.bailian.car.beans.PageQuery;
import com.bailian.car.common.JsonData;
import com.bailian.car.dao.oil.OilCardRepository;
import com.bailian.car.domain.cars.car.OilCard;
import com.bailian.car.exception.PermissionException;
import com.bailian.car.param.AddOilParam;
import com.bailian.car.param.OilSearch;
import com.bailian.car.service.oil.OilService;
import com.bailian.car.utils.DateUtils;
import com.bailian.car.utils.ExcelUtils;
import com.bailian.car.utils.JsonMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class OilServiceImpl implements OilService {

	@Autowired
	private LocalContainerEntityManagerFactoryBean entityManagerFactory;

	@Autowired
	private OilCardRepository oilCardRepository;

	@Override
	public JsonData oil_batchimport(MultipartFile file) throws Exception {
		int count = 0;
		try {
			List<String[]> readExcel = ExcelUtils.readExcel(file);
			if (readExcel != null && readExcel.size() > 0) {
				for (int i = 1; i < readExcel.size(); i++) {
					OilCard oil = new OilCard();
					log.info("i:{}", i);
					log.info("readExcel.get(i):{}", JsonMapper.obj2String(readExcel.get(i)));
					String[] strings = readExcel.get(i);
					String time = strings[0]; // 时间
					oil.setTime(DateUtils.String2date(time));
					String GAS = strings[1]; // 加油站
					oil.setGas(GAS);
					String L = strings[2]; // 数量
					oil.setL(L);
					String type = strings[3]; // 型号
					oil.setType(type);
					String price = strings[4]; // 价格
					if (StringUtils.isBlank(price)) {
						continue;
					}
					oil.setPrice(Double.parseDouble(price));
					String projectSn = strings[5]; // 项目号
					oil.setProjectSn(projectSn);
					String vSn = strings[6]; // 车辆编号
					oil.setvSn(vSn);
					String mm = strings[7]; // 里程表
					oil.setMm(mm);
					String oilCardNum = strings[8];// 加油卡卡号
					oil.setOilCardNum(oilCardNum);
					String operator = strings[9]; // 加油人
					oil.setOperator(operator);
					String remark = strings[10]; // 说明
					oil.setRemark(remark);
					oil.setImportTime(new Date());
					oilCardRepository.save(oil);
					count++;
				}
			}
			return JsonData.success("你导入了" + count + "条数据");
		} catch (Exception e) {
			throw new PermissionException("excel格式错误,请安指定模板导入");
		}

	}

	@SuppressWarnings("unchecked")
	@Cacheable("car")
	@Override
	public PageBean<OilCard> query(PageQuery pQuery, OilSearch OilSearch) {
		long count = oilCardRepository.count();
		PageBean<OilCard> result = new PageBean<>();
		List<OilCard> resultList = null;
		EntityManager em = entityManagerFactory.getNativeEntityManagerFactory().createEntityManager();
		Integer page = pQuery.getPage();
		Integer size = pQuery.getSize();

		String sql = "SELECT DISTINCT ID,GAS,L,mm,importTime,projectSn,oilCardNum,operator,price,remark,time,type,vSn,expense1 AS expense FROM t_oilcard ,(SELECT operator o,SUM(price) AS expense1 FROM t_oilcard GROUP BY operator,importTime) AS vi WHERE operator=o"
				+ " ";

		if (StringUtils.isNotBlank(OilSearch.getImportTime())) {
			sql += "AND importTime LIKE" + "'" + "%" + OilSearch.getImportTime() + "%" + "'" + " ";
		}

		if (StringUtils.isNotBlank(OilSearch.getOperator())) {

			sql += "AND operator LIKE" + "'" + "%" + OilSearch.getOperator() + "%" + "'" + " ";
		}
		sql += "GROUP BY importTime ,ID  ORDER  BY importTime DESC " + " " + " LIMIT" + " " + page + "," + size;
		Query nativeQuery = em.createNativeQuery(sql, OilCard.class);
		resultList = nativeQuery.getResultList();

		result.setTotal(count);
		result.setRows(resultList);
		return result;
	}

	@Override
	public JsonData save(AddOilParam aParam) {
		Integer id = aParam.getId();
		OilCard oilCard = oilCardRepository.findOne(id);
		oilCard.setTime(DateUtils.String2date(aParam.getTime()));
		oilCard.setvSn(aParam.getvSn());
		oilCard.setProjectSn(aParam.getProjectSn());
		oilCard.setMm(aParam.getMm());
		return JsonData.success("油卡填写成功");
	}

}
