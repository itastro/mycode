package cn.shengrui.management.controller;

import cn.shengrui.common.annotation.OperationLog;
import cn.shengrui.common.beans.JsonMapper;
import cn.shengrui.common.beans.JsonResult;
import cn.shengrui.common.beans.PageQuery;
import cn.shengrui.common.enums.OperationType;
import cn.shengrui.common.util.StringUtil;
import cn.shengrui.param.TaskParam;
import cn.shengrui.param.TaskSearch;
import cn.shengrui.management.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.rmi.runtime.Log;

import javax.validation.Valid;
import java.util.List;

/**
 * @ClassName TaskController
 * @Description TODO
 * @Date 2018/10/16 16:19
 * @Author itastro
 * @Version 1.0
 **/
@Slf4j
@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @OperationLog(action = "查询生产任务", type = OperationType.QUERY)
    @RequiresPermissions(value = "task:list", logical = Logical.OR)
    @GetMapping("/pageQuery")

    public JsonResult pageQuery(PageQuery pageQuery, TaskSearch taskSearch) {

        log.info("taskSearch:{}", JsonMapper.obj2String(taskSearch));

        return taskService.pageQuery(pageQuery, taskSearch);

    }

    @OperationLog(action = "删除生产任务", type = OperationType.DELETE)
    @RequiresPermissions(value = "task:delete", logical = Logical.OR)
    @PostMapping("/delete")
    public JsonResult delete(String ids) {
        if (StringUtils.isBlank(ids)) {
            return JsonResult.fail("请选择TCU");
        }
        List<Integer> list = StringUtil.splitToListInt(ids);
        return taskService.delete(list);

    }

    @OperationLog(action = "添加生产任务", type = OperationType.ADD)
    @RequiresPermissions(value = "task:add", logical = Logical.OR)
    @PostMapping("/save")
    public JsonResult save(@Valid TaskParam taskParam, BindingResult bindingResult) {


        if (bindingResult.hasErrors()) {
            return JsonResult.fail(bindingResult.getFieldError().getDefaultMessage(), taskParam);
        }
        return taskService.save(taskParam);

    }

    @OperationLog(action = "生产任务更新", type = OperationType.UPDATE)
    @RequiresPermissions(value = "task:update", logical = Logical.OR)
    @PostMapping("/update")
    public JsonResult update(@Valid TaskParam taskParam, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return JsonResult.fail(bindingResult.getFieldError().getDefaultMessage(), taskParam);
        }
        return taskService.update(taskParam);

    }

    @OperationLog(action = "生产任务更新", type = OperationType.UPDATE)
    @PostMapping("/cancleTask")
    @RequiresPermissions(value = "task:cancle", logical = Logical.OR)
    public JsonResult CancleTask(String ids) {

        if (StringUtils.isBlank(ids)) {
            return JsonResult.fail("请传入需要取消任务的id");
        }
        List<Integer> list = StringUtil.splitToListInt(ids);
        return taskService.CancleTask(list);

    }

    @OperationLog(action = "生产任务恢复", type = OperationType.UPDATE)
    @PostMapping("/restTask")
    @RequiresPermissions(value = "task:rest", logical = Logical.OR)
    public JsonResult restTask(String ids) {

        if (StringUtils.isBlank(ids)) {
            return JsonResult.fail("请传入需要取消任务的id");
        }
        List<Integer> list = StringUtil.splitToListInt(ids);
        return taskService.restTask(list);
    }

    @GetMapping("/getCurrentTask")
    @RequiresUser
    public JsonResult getCurrentTask() {

        return taskService.getCurrentTask();

    }
}
