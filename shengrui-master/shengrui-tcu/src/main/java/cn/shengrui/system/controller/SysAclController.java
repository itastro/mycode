package cn.shengrui.system.controller;

import cn.shengrui.common.beans.JsonResult;
import cn.shengrui.common.beans.PageQuery;
import cn.shengrui.common.util.StringUtil;
import cn.shengrui.param.AclParam;
import cn.shengrui.param.AclSearch;
import cn.shengrui.system.service.SysAclService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @ClassName SysAclController
 * @Description TODO
 * @Date 2018/10/23 12:31
 * @Author itastro
 * @Version 1.0
 **/

@RestController
@RequestMapping("/sysacl")
public class SysAclController {
    @Autowired
    private SysAclService sysAclService;

    @GetMapping("/pageQuery")
    @RequiresPermissions(value = "acl:list", logical = Logical.OR)
    public JsonResult pageQuery(PageQuery pageQuery, AclSearch aclSearch) {

        return sysAclService.pageQuery(pageQuery, aclSearch);

    }

    @PostMapping("/delete")
    @RequiresPermissions(value = "acl:delete", logical = Logical.OR)
    public JsonResult delete(String ids) {
        if (StringUtils.isBlank(ids)) {
            return JsonResult.fail("请选择权限", ids);
        }
        List<Integer> list = StringUtil.splitToListInt(ids);

        return sysAclService.delete(list);
    }

    @PostMapping("/save")
    @RequiresPermissions(value = "acl:add", logical = Logical.OR)
    public JsonResult save(@Valid AclParam aclParam, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return JsonResult.fail(bindingResult.getFieldError().getDefaultMessage(), null);
        }
        return sysAclService.save(aclParam);
    }

    @PostMapping("/update")
    @RequiresPermissions(value = "acl:update", logical = Logical.OR)
    public JsonResult update(@Valid AclParam aclParam, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return JsonResult.fail(bindingResult.getFieldError().getDefaultMessage(), null);
        }
        return sysAclService.update(aclParam);
    }
}
