package cn.shengrui.system.controller;

import cn.shengrui.common.annotation.OperationLog;
import cn.shengrui.common.beans.JsonResult;
import cn.shengrui.common.beans.PageQuery;
import cn.shengrui.common.enums.OperationType;
import cn.shengrui.common.util.StringUtil;
import cn.shengrui.param.RoleParam;
import cn.shengrui.param.RoleSearch;
import cn.shengrui.system.service.SysCoreService;
import cn.shengrui.system.service.SysRoleService;
import cn.shengrui.system.service.SysTreeService;
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
 * @ClassName SysRoleController
 * @Description TODO
 * @Date 2018/10/23 9:34
 * @Author itastro
 * @Version 1.0
 **/

@RestController
@RequestMapping("/sysrole")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysCoreService sysCoreService;

    @Autowired
    private SysTreeService sysTreeService;

    @PostMapping("/save")
    @RequiresPermissions(value = "role:add", logical = Logical.OR)
    @OperationLog(action = "增加角色", type = OperationType.ADD)
    public JsonResult save(@Valid RoleParam roleParam, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return JsonResult.fail(bindingResult.getFieldError().getDefaultMessage(), null);
        }
        return sysRoleService.save(roleParam);
    }


    @PostMapping("/update")
    @RequiresPermissions(value = "role:update", logical = Logical.OR)
    @OperationLog(action = "更新角色", type = OperationType.UPDATE)
    public JsonResult update(@Valid RoleParam roleParam, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return JsonResult.fail(bindingResult.getFieldError().getDefaultMessage(), null);
        }
        return sysRoleService.update(roleParam);
    }

    @PostMapping("/delete")
    @RequiresPermissions(value = "role:delete", logical = Logical.OR)
    @OperationLog(action = "删除角色", type = OperationType.DELETE)
    public JsonResult delete(String ids) {
        if (StringUtils.isBlank(ids)) {
            return JsonResult.fail("请选择需要删除的用户", ids);
        }
        List<Integer> list = StringUtil.splitToListInt(ids);
        return sysRoleService.delete(list);
    }

    @GetMapping("/pageQuery")
    @RequiresPermissions(value = "role:list", logical = Logical.OR)
    public JsonResult pageQuery(PageQuery pageQuery, RoleSearch roleSearch) {
        return sysRoleService.pageQuery(pageQuery, roleSearch);
    }


    @PostMapping("/roleBindAcl")
    @RequiresPermissions(value = "role:roleacl", logical = Logical.OR)
    @OperationLog(action = "角色绑定权限", type = OperationType.OTHERT)
    public JsonResult roleBindAcl(Integer roleId, String aclIds) {
       /* if (StringUtils.isBlank(aclIds)) {
            return JsonResult.fail("请选择权限", null);
        }*/
        List<Integer> list = StringUtil.splitToListInt(aclIds);
        return sysCoreService.roleBindAcl(roleId, list);
    }

    @GetMapping("/getAclDto")
    @RequiresUser
    public JsonResult getAclDto(Integer roleId) {
        if (roleId == null) {
            return JsonResult.fail("请选择角色", null);
        }
        return sysCoreService.aclBindInfo(roleId);
    }

    @GetMapping("/roleMenuTree")
    public JsonResult roleMenuTree(Integer roleId) {

        if (roleId == null) {
            return JsonResult.fail("请传入角色Id", null);
        }
        return sysTreeService.roleMenuTree(roleId);
    }

    @PostMapping("/roleBindMenu")
    @OperationLog(action = "角色绑定菜单", type = OperationType.OTHERT)
    public JsonResult roleBindMenu(Integer roleId, String menuIds) {
        if (StringUtils.isBlank(menuIds)) {
            return JsonResult.fail("请选择角色", null);
        }
        List<Integer> list = StringUtil.splitToListInt(menuIds);
        return sysCoreService.roleBindMenu(roleId, list);
    }
}
