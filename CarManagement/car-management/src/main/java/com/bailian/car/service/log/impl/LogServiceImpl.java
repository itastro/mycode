package com.bailian.car.service.log.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bailian.car.beans.PageBean;
import com.bailian.car.beans.PageQuery;
import com.bailian.car.common.JsonData;
import com.bailian.car.dao.log.SysLogRepository;
import com.bailian.car.domain.Log.SysLog;
import com.bailian.car.service.log.LogService;

@Service
@Transactional
public class LogServiceImpl implements LogService {
	@Autowired
	private SysLogRepository sysLogRepository;

	@Override
	@CacheEvict(value = "log", allEntries = true)
	public void saveLog(SysLog slog) {

		sysLogRepository.save(slog);
	}

	@Override
	// @RequiresRoles("system")
	@CacheEvict(value = "log", allEntries = true)
	public JsonData delete(String[] ids) {
		if (ids.length != 0) {
			for (String id : ids) {
				sysLogRepository.delete(Integer.parseInt(id));
			}
		}
		return JsonData.success("删除成功");
	}

	@Cacheable("log")
	@Override
	public PageBean<SysLog> findCarLog(PageQuery pageQuery) {

		PageBean<SysLog> result = new PageBean<>();
		Sort sort = new Sort(Direction.DESC, "createTime");
		Pageable pageable = new PageRequest(pageQuery.getPage(), pageQuery.getSize(), sort);
		String moudle = "车辆管理";
		Page<SysLog> pageData = sysLogRepository.findcarLog(moudle, pageable);

		result.setTotal(pageData.getTotalElements());
		result.setRows(pageData.getContent());
		return result;
	}

	@Cacheable("log")
	@Override
	public PageBean<SysLog> findCarDriverLog(PageQuery pageQuery) {
		PageBean<SysLog> result = new PageBean<>();
		Sort sort = new Sort(Direction.DESC, "createTime");
		Pageable pageable = new PageRequest(pageQuery.getPage(), pageQuery.getSize(), sort);
		String moudle = "驾驶员管理";
		Page<SysLog> pageData = sysLogRepository.findDriverLog(moudle, pageable);

		result.setTotal(pageData.getTotalElements());
		result.setRows(pageData.getContent());
		return result;
	}

	@Cacheable("log")
	@Override
	public PageBean<SysLog> findCarMaintainLog(PageQuery pageQuery) {
		PageBean<SysLog> result = new PageBean<>();
		Sort sort = new Sort(Direction.DESC, "createTime");
		Pageable pageable = new PageRequest(pageQuery.getPage(), pageQuery.getSize(), sort);
		String moudle = "维修管理";
		Page<SysLog> pageData = sysLogRepository.findMaintainLog(moudle, pageable);

		result.setTotal(pageData.getTotalElements());
		result.setRows(pageData.getContent());
		return result;
	}

	@Cacheable("log")
	@Override
	public PageBean<SysLog> findCarSystemLog(PageQuery pageQuery) {
		PageBean<SysLog> result = new PageBean<>();
		Sort sort = new Sort(Direction.DESC, "createTime");
		Pageable pageable = new PageRequest(pageQuery.getPage(), pageQuery.getSize(), sort);
		String moudle = "系统管理";
		Page<SysLog> pageData = sysLogRepository.findSystemLog(moudle, pageable);
		result.setTotal(pageData.getTotalElements());
		result.setRows(pageData.getContent());
		return result;
	}

}
