package cn.shengrui.management.service;

import cn.shengrui.common.beans.JsonResult;
import cn.shengrui.param.ProjectTcuFileParam;

import java.util.List;

/**
 * @author itastro
 */
public interface ProjectTcuFileCoreService {

    /**
     * 获取此项目的详情
     *
     * @param id
     * @return
     */
    JsonResult getProjectDetails(Integer id);

    /**
     * 关联TCU  关联文件
     *
     * @param projectTcuFileParam
     * @return
     */
    JsonResult associate(ProjectTcuFileParam projectTcuFileParam);


    /**
     * 禁用
     *
     * @param pid
     * @param ptfId
     * @return
     */
    JsonResult disable(Integer pid, Integer ptfId);

    /**
     * 启用
     *
     * @param pid
     * @param ptfId
     * @return
     */
    JsonResult enable(Integer pid, Integer ptfId);


    /**
     * 删除项目
     * @param list
     * @return
     */
    JsonResult delete(List<Integer> list);

}
