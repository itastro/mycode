package cn.shengrui.management.controller;

import cn.shengrui.common.annotation.OperationLog;
import cn.shengrui.common.base.BaseController;
import cn.shengrui.common.beans.JsonResult;
import cn.shengrui.common.beans.PageQuery;
import cn.shengrui.common.enums.OperationType;
import cn.shengrui.common.util.StringUtil;
import cn.shengrui.param.TcuParam;
import cn.shengrui.param.TcuSearch;
import cn.shengrui.management.service.TcuService;
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
 * @ClassName TcuController
 * @Description TODO
 * @Date 2018/10/14 12:41
 * @Author itastro
 * @Version 1.0
 **/
@RestController
@RequestMapping("/tcu")
public class TcuController extends BaseController {

    @Autowired
    private TcuService tcuService;

    @OperationLog(action = "TCU查询", type = OperationType.QUERY)
    @RequiresPermissions(value = "tcu:list", logical = Logical.OR)
    @GetMapping("/pageQuery")
    public JsonResult pageQuery(PageQuery pageQuery, TcuSearch tcuSearch) {

        return tcuService.pageQuery(pageQuery, tcuSearch);

    }

    @OperationLog(action = "TCU删除", type = OperationType.DELETE)
    @RequiresPermissions(value = "tcu:delete", logical = Logical.OR)
    @PostMapping("/delete")
    public JsonResult delete(String ids) {
        if (StringUtils.isBlank(ids)) {
            return JsonResult.fail("请选择TCU", ids);
        }
        List<Integer> list = StringUtil.splitToListInt(ids);
        return tcuService.delete(list);

    }

    @OperationLog(action = "添加TCU", type = OperationType.ADD)
    @RequiresPermissions(value = "tcu:add", logical = Logical.OR)
    @PostMapping("/save")
    public JsonResult save(@Valid TcuParam tcuParam, BindingResult bindingResult) {


        if (bindingResult.hasErrors()) {
            return JsonResult.fail(bindingResult.getFieldError().getDefaultMessage(), tcuParam);
        }
        return tcuService.save(tcuParam);

    }

    @OperationLog(action = "更新TUC", type = OperationType.UPDATE)
    @RequiresPermissions(value = "tcu:update", logical = Logical.OR)
    @PostMapping("/update")
    public JsonResult update(@Valid TcuParam tcuParam, BindingResult bindingResult) {


        if (bindingResult.hasErrors()) {
            return JsonResult.fail(bindingResult.getFieldError().getDefaultMessage(), tcuParam);
        }
        return tcuService.update(tcuParam);

    }

    @GetMapping("/findAll")
    @RequiresUser
    public JsonResult findAll() {
        return tcuService.findAll();
    }
}
