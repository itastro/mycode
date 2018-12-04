package cn.shengrui.management.controller;

import cn.shengrui.common.annotation.OperationLog;
import cn.shengrui.common.base.BaseController;
import cn.shengrui.common.beans.JsonResult;
import cn.shengrui.common.beans.PageQuery;
import cn.shengrui.common.enums.OperationType;
import cn.shengrui.common.util.StringUtil;
import cn.shengrui.param.ProjectParam;
import cn.shengrui.param.ProjectSearch;
import cn.shengrui.param.ProjectTcuFileParam;
import cn.shengrui.management.service.ProjectService;
import cn.shengrui.management.service.ProjectTcuFileCoreService;
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

import javax.validation.Valid;
import java.util.List;

/**
 * @ClassName ProjectController
 * @Description TODO
 * @Date 2018/10/14 20:35
 * @Author itastro
 * @Version 1.0
 **/
@Slf4j
@RestController
@RequestMapping("/project")
public class ProjectController extends BaseController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ProjectTcuFileCoreService projectTcuFileCoreService;

    @OperationLog(action = "查询项目", type = OperationType.QUERY)
    @RequiresPermissions(value = "project:list", logical = Logical.OR)
    @GetMapping("/pageQuery")
    public JsonResult pageQuery(PageQuery pageQuery, ProjectSearch projectSearch) {
        return projectService.pageQuery(pageQuery, projectSearch);
    }

    @OperationLog(action = "删除项目", type = OperationType.DELETE)
    @RequiresPermissions(value = "project:delete", logical = Logical.OR)
    @PostMapping("/delete")
    public JsonResult delete(String ids) {
        if (StringUtils.isBlank(ids)) {
            return JsonResult.fail("请选择TCU");
        }
        List<Integer> list = StringUtil.splitToListInt(ids);
        return projectService.delete(list);

    }

    @OperationLog(action = "添加项目", type = OperationType.ADD)
    @RequiresPermissions(value = "project:add", logical = Logical.OR)
    @PostMapping("/save")
    public JsonResult save(@Valid ProjectParam projectParam, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return JsonResult.fail(bindingResult.getFieldError().getDefaultMessage(), projectParam);
        }
        return projectService.save(projectParam);
    }

    @OperationLog(action = "更新项目", type = OperationType.UPDATE)
    @RequiresPermissions(value = "project:update", logical = Logical.OR)
    @GetMapping("/update")
    public JsonResult update(@Valid ProjectParam projectParam, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return JsonResult.fail(bindingResult.getFieldError().getDefaultMessage(), projectParam);
        }
        return projectService.update(projectParam);
    }

    @GetMapping("/getProjectDetails")
    @RequiresUser
    public JsonResult getProjectDetails(Integer id) {
        if (id == null) {
            return JsonResult.fail("请选择需要查看的项目", id);
        }
        return projectTcuFileCoreService.getProjectDetails(id);
    }

    @PostMapping("/associate")
    @RequiresPermissions(value = "project:associate", logical = Logical.OR)
    @OperationLog(action = "项目关联TCU", type = OperationType.OTHERT)
    public JsonResult associate(@Valid ProjectTcuFileParam projectTcuFileParam, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {

            return JsonResult.fail(bindingResult.getFieldError().getDefaultMessage(), projectTcuFileParam);
        }

        return projectTcuFileCoreService.associate(projectTcuFileParam);
    }


    @PostMapping("/disable")
    @RequiresPermissions(value = "project:disable", logical = Logical.OR)
    @OperationLog(action = "禁止TCU", type = OperationType.OTHERT)
    public JsonResult disable(Integer pId, Integer ptfId) {
        log.info("pid:{}", pId);
        log.info("ptfId:{}", ptfId);
        if (pId == null || ptfId == null) {
            return JsonResult.fail("id不能为空", null);
        }
        return projectTcuFileCoreService.disable(pId, ptfId);
    }

    @PostMapping("/enable")
    @RequiresPermissions(value = "project:enable", logical = Logical.OR)
    @OperationLog(action = "启用TCU", type = OperationType.OTHERT)
    public JsonResult enable(Integer pId, Integer ptfId) {

        log.info("pid:{}", pId);
        log.info("ptfId:{}", ptfId);
        if (pId == null || ptfId == null) {
            return JsonResult.fail("id不能为空", null);
        }
        return projectTcuFileCoreService.enable(pId, ptfId);
    }

    @PostMapping("/deleteAssociate")
    @OperationLog(action = "删除关联关系", type = OperationType.DELETE)
    @RequiresPermissions(value = "project:deleteAssociate", logical = Logical.OR)
    public JsonResult deleteAssociate(String ids) {
        if (StringUtils.isBlank(ids)) {
            return JsonResult.fail("ids不能为空", ids);
        }
        List<Integer> list = StringUtil.splitToListInt(ids);
        return projectTcuFileCoreService.delete(list);
    }

    @GetMapping("/findAll")
    @RequiresUser
    public JsonResult findAll() {
        return projectService.findAll();
    }
}
