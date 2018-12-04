package cn.shengrui.management.controller;

import cn.shengrui.common.beans.JsonMapper;
import cn.shengrui.common.beans.JsonResult;
import cn.shengrui.common.beans.PageQuery;
import cn.shengrui.management.entity.TTask;
import cn.shengrui.management.entity.TaskLog;
import cn.shengrui.management.mapper.TTaskMapper;
import cn.shengrui.management.service.TaskLogService;
import cn.shengrui.param.TaskEchartSearch;
import cn.shengrui.param.TaskLogParam;
import cn.shengrui.param.TaskLogSearch;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * @ClassName TaskLogController
 * @Description TODO
 * @Date 2018/10/26 17:08
 * @Author itastro
 * @Version 1.0
 **/
@Slf4j
@RestController
@RequestMapping("/tasklog")
public class TaskLogController {


    @Autowired
    private TaskLogService taskLogService;

    @Autowired
    private TTaskMapper tTaskMapper;

    @GetMapping("/pageQuery")
    @RequiresPermissions(value = "tasklog:list", logical = Logical.OR)
    public JsonResult pageQuery(PageQuery pageQuery, TaskLogSearch taskSearch) {

        return taskLogService.pageQuery(pageQuery, taskSearch);

    }


    @GetMapping("/getEchatInfo")
    @RequiresPermissions(value = "tasklog:list", logical = Logical.OR)
    public JsonResult pageQuery(TaskEchartSearch taskSearch) {
        log.info("taskSearch:{}", JsonMapper.obj2String(taskSearch));
        return taskLogService.flashStatistics(taskSearch);

    }

    /**
     * 导出excel
     *
     * @return
     */
    @GetMapping("/getExcel")
    public Object getgetExcel() {

        return taskLogService.getExcel();

    }


    @PostMapping("/insertTaskLog")
    @RequiresPermissions(value = "tasklog:list", logical = Logical.OR)
    public JsonResult insertTaskLog(@RequestBody List<TaskLog> taskLogs) throws Exception {
        log.info("taskLogParam:{}", JsonMapper.obj2String(taskLogs));
        if (CollectionUtils.isEmpty(taskLogs)) {
            return JsonResult.fail("不能为空", taskLogs);
        }

       for (TaskLog taskLog : taskLogs) {
            if (taskLog.getTaskId() == 0) {
                continue;
            }
            TTask tTask = tTaskMapper.selectByPrimaryKey(taskLog.getTaskId());
            if (tTask == null) {
                continue;
            }
            JsonResult jsonResult = taskLogService.save(taskLog);
            if (jsonResult.getCode() == 0) {
                return jsonResult;
            }
        }
        return JsonResult.success("成功插入", null);
    }

}
