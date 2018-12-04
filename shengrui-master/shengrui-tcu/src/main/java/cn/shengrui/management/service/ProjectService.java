package cn.shengrui.management.service;

import cn.shengrui.common.beans.JsonResult;
import cn.shengrui.common.beans.PageQuery;
import cn.shengrui.param.ProjectParam;
import cn.shengrui.param.ProjectSearch;

import java.util.List;

public interface ProjectService {

    JsonResult save(ProjectParam projectParam);

    JsonResult update(ProjectParam projectParam);

    JsonResult delete(List<Integer> ids);

    JsonResult pageQuery(PageQuery pageQuery, ProjectSearch projectSearch);

    boolean checkExist(String name, Integer companyid,Integer projectid);

    JsonResult findAll();
}
