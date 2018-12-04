package com.bailian.car.service.driver.impl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Service;
import com.bailian.car.beans.PageBean;
import com.bailian.car.beans.PageQuery;
import com.bailian.car.common.JsonData;
import com.bailian.car.dao.iccard.IccardUseHistoryRepository;
import com.bailian.car.domain.cardriver.InAndOut;
import com.bailian.car.domain.iccard.IccardUseHistory;
import com.bailian.car.service.driver.InAndOutService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class InAndOutServiceImpl implements InAndOutService {
	@Autowired
	private IccardUseHistoryRepository iccardUseHistoryRepository;
	@Autowired
	private LocalContainerEntityManagerFactoryBean entityManagerFactory;
	@Override
	public PageBean<IccardUseHistory> pageQuery(PageQuery pageQuery) {
		long count = 0;
		PageBean<IccardUseHistory> result = new PageBean<>();
		List<IccardUseHistory> resultList = null;
		EntityManager em = entityManagerFactory.getNativeEntityManagerFactory().createEntityManager();

		String sql = "SELECT * FROM iccard_use_history ORDER BY ID DESC";
		count = em.createNativeQuery(sql, IccardUseHistory.class).getResultList().size();
		resultList = pageResult(pageQuery, em, sql);

		if (em != null) {
			em.close();
		}
		if (resultList == null) {
			result.setTotal((long) 0);
		} else {
			result.setTotal(count);
		}
		result.setRows(resultList);
		return result;
	}

	private List<IccardUseHistory> pageResult(PageQuery pQuery, EntityManager em, String sql) {
		List<IccardUseHistory> resultList = new ArrayList<IccardUseHistory>();
		Query nativeQuery = em.createNativeQuery(sql, IccardUseHistory.class)
				.setFirstResult(pQuery.getPage() * pQuery.getSize()).setMaxResults(pQuery.getSize());

		resultList = nativeQuery.getResultList();
		return resultList;
	}

	@Override
	public JsonData delete(String[] ids) {
		// TODO Auto-generated method stub

		if (ids == null) {
			return JsonData.fail("请你选择一条记录");
		}

		if (ids.length < 0) {
			return JsonData.fail("请你选择一条记录");
		}
		return JsonData.success("删除成功");
	}

	@Override
	public IccardUseHistory getNewInAndOut() {

		return iccardUseHistoryRepository.getnewinfo();
	}

}
