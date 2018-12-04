package com.bailian.car.service.log;
import com.bailian.car.beans.PageBean;
import com.bailian.car.beans.PageQuery;
import com.bailian.car.common.JsonData;
import com.bailian.car.domain.Log.SysLog;

public interface LogService {

	void saveLog(SysLog slog);

	JsonData delete(String[] ids);

	PageBean<SysLog> findCarLog(PageQuery pageQuery);

	PageBean<SysLog> findCarDriverLog(PageQuery pageQuery);

	PageBean<SysLog> findCarMaintainLog(PageQuery pageQuery);

	PageBean<SysLog> findCarSystemLog(PageQuery pageQuery);

}
