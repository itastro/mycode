package cn.shengrui.management.service;

import cn.shengrui.common.beans.JsonResult;
import cn.shengrui.common.beans.PageQuery;
import cn.shengrui.param.TaskParam;
import cn.shengrui.param.TaskSearch;

import java.util.List;

public interface TaskService {

    JsonResult save(TaskParam taskParam);

    JsonResult delete(List<Integer> ids);

    JsonResult pageQuery(PageQuery pageQuery, TaskSearch taskSearch);

    JsonResult CancleTask(List<Integer> ids);

    JsonResult update(TaskParam taskParam);


    boolean checkExist(String name, Integer companyid, Integer projectid);

    JsonResult restTask(List<Integer> ids);

    JsonResult getCurrentTask();

    JsonResult updateComplateNumber(Integer id);

    void updateStatusIng(Integer taskId);


    void updateAllStatusIngToWait();


}
