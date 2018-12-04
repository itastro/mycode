package cn.shengrui.management.controller;

import cn.shengrui.common.beans.JsonResult;
import cn.shengrui.common.beans.PageQuery;
import cn.shengrui.common.util.StringUtil;
import cn.shengrui.param.OperationLogSearch;
import cn.shengrui.management.service.OperationLogService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName OperationLogController
 * @Description TODO
 * @Date 2018/10/18 10:50
 * @Author itastro
 * @Version 1.0
 **/

@RestController
@RequestMapping("/operationlog")
public class OperationLogController {


    @Autowired
    private OperationLogService operationLogService;

    @GetMapping("/pageQuery")
    @RequiresPermissions(value = "operlog:list", logical = Logical.OR)
    public JsonResult pageQuery(PageQuery pageQuery, OperationLogSearch operationLogSearch) {
        return operationLogService.pageQuery(pageQuery, operationLogSearch);
    }

    @PostMapping("/delete")
    @RequiresPermissions(value = "operlog:delete", logical = Logical.OR)
    public JsonResult delete(String ids) {

        if (StringUtils.isBlank(ids)) {
            return JsonResult.fail("请选择需要删除的日志", ids);
        }
        List<Integer> list = StringUtil.splitToListInt(ids);
        return operationLogService.delete(list);
    }

    /**
     * 导出excel
     *
     * @return
     */
    @GetMapping("/getExcel")

    public Object getgetExcel() {

        return operationLogService.getExcel();

    }

}
