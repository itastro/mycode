package cn.shengrui.management.service;

import cn.shengrui.common.beans.JsonResult;
import cn.shengrui.common.beans.PageQuery;
import cn.shengrui.management.entity.TOperationLog;
import cn.shengrui.param.OperationLogSearch;

import java.util.List;

/**
 * @ClassName TOperationLogService
 * @Description TODO
 * @Date 2018/10/16 13:24
 * @Author itastro
 * @Version 1.0
 **/
public interface OperationLogService {

    void save(TOperationLog operationLog);

    JsonResult delete(List<Integer> list);

    JsonResult pageQuery(PageQuery pageQuery, OperationLogSearch operationLogSearch);

    Object getExcel();
}
