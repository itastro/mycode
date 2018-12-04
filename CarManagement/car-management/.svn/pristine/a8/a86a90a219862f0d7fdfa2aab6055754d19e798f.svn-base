package com.bailian.car.log;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.bailian.car.beans.PageBean;
import com.bailian.car.beans.PageQuery;
import com.bailian.car.dao.log.SysLogRepository;
import com.bailian.car.domain.Log.SysLog;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class LogTest {

	@Autowired

	private SysLogRepository sysLogRepository;

	@Test
	public void test() {
		PageQuery pageQuery = new PageQuery();
		PageBean<SysLog> result = new PageBean<>();
		Sort sort = new Sort(Direction.DESC, "createTime");
		Pageable pageable = new PageRequest(pageQuery.getPage(), pageQuery.getSize(), sort);
		String cm = "车辆管理";
		Page<SysLog> pageData = sysLogRepository.findcarLog(cm, pageable);

		result.setTotal(pageData.getTotalElements());
		result.setRows(pageData.getContent());
		log.info("result:{},result");

	}

}
