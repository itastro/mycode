package cn.shengrui.management.service;


import cn.shengrui.common.beans.JsonResult;
import cn.shengrui.common.beans.PageQuery;
import cn.shengrui.management.entity.TaskLog;
import cn.shengrui.param.TaskEchartSearch;
import cn.shengrui.param.TaskLogSearch;

public interface TaskLogService {


    JsonResult pageQuery(PageQuery pageQuery, TaskLogSearch taskLogSearch);

    Object getExcel();

    JsonResult save(TaskLog taskLog);

    JsonResult flashStatistics(TaskEchartSearch taskEchartSearch);


}
