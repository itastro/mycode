package cn.shengrui.management.controller;

import cn.shengrui.common.annotation.OperationLog;
import cn.shengrui.common.base.BaseController;
import cn.shengrui.common.beans.JsonResult;
import cn.shengrui.common.beans.PageQuery;
import cn.shengrui.common.enums.OperationType;
import cn.shengrui.common.util.StringUtil;
import cn.shengrui.param.CompanyParam;
import cn.shengrui.param.CompanySearch;
import cn.shengrui.management.service.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @ClassName CompanyController
 * @Description TODO
 * @Date 2018/10/12 12:59
 * @Author itastro
 * @Version 1.0
 **/
@Slf4j
@RestController
@RequestMapping("/company")
public class CompanyController extends BaseController {

    @Autowired
    private CompanyService companyService;

    @OperationLog(action = "车企添加", type = OperationType.ADD)
    @RequiresPermissions(value = "company:add", logical = Logical.OR)
    @PostMapping("/save")
    public JsonResult save(@Valid CompanyParam companyParam, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return JsonResult.fail(bindingResult.getFieldError().getDefaultMessage(), companyParam);
        }
        return companyService.save(companyParam);
    }

    @PostMapping("/delete")
    @RequiresPermissions(value = "company:delete", logical = Logical.OR)
    @OperationLog(action = "车企删除", type = OperationType.DELETE)
    public JsonResult delete(String ids) {
        log.info("ids:{}", ids);
        if (StringUtils.isBlank(ids)) {
            return JsonResult.fail("请选择需要删除的车企", ids);
        }
        List list = StringUtil.splitToListInt(ids);
        return companyService.delete(list);

    }

    @OperationLog(action = "车企更新", type = OperationType.UPDATE)
    @RequiresPermissions(value = "company:update", logical = Logical.OR)
    @PostMapping("/update")
    public JsonResult update(@Valid CompanyParam companyParam, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return JsonResult.fail(bindingResult.getFieldError().getDefaultMessage(), companyParam);
        }
        return companyService.update(companyParam);

    }

    @OperationLog(action = "车企查询", type = OperationType.QUERY)
    @RequiresPermissions(value = "company:list", logical = Logical.OR)
    @GetMapping("pageQuery")
    public JsonResult pageQuery(PageQuery pageQuery, CompanySearch companySearch) {
        return companyService.pageQuery(pageQuery, companySearch);
    }

    @GetMapping("/findAll")
    @RequiresUser
    public JsonResult findAll() {

        return companyService.findAll();

    }
}
