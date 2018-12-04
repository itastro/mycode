package cn.shengrui.system.controller;

import cn.shengrui.common.annotation.OperationLog;
import cn.shengrui.common.beans.JsonResult;
import cn.shengrui.common.beans.PageQuery;
import cn.shengrui.common.enums.OperationType;
import cn.shengrui.common.util.StringUtil;
import cn.shengrui.param.SysUserParam;
import cn.shengrui.param.UserSearch;
import cn.shengrui.system.service.SysCoreService;
import cn.shengrui.system.service.SysUserService;
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
 * @ClassName SysUserController
 * @Description TODO
 * @Date 2018/10/8 0:50
 * @Author itastro
 * @Version 1.0
 **/

@RestController
@RequestMapping("/sysuser")
public class SysUserController {

  @Autowired
  private SysUserService sysUserService;

  @Autowired
  private SysCoreService sysCoreService;

  @OperationLog(action = "添加用户", type = OperationType.ADD)
  @PostMapping("/save")
  @RequiresPermissions(value = "user:add", logical = Logical.OR)
  public JsonResult save(@Valid SysUserParam sysUserParam, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return JsonResult.fail(bindingResult.getFieldError().getDefaultMessage(), null);
    }
    return sysUserService.save(sysUserParam);
  }

  @PostMapping("/update")
  @RequiresPermissions(value = "user:update", logical = Logical.OR)
  @OperationLog(action = "更新用户信息", type = OperationType.UPDATE)
  public JsonResult update(@Valid SysUserParam sysUserParam, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return JsonResult.fail(bindingResult.getFieldError().getDefaultMessage(), null);
    }

    return sysUserService.update(sysUserParam);
  }

  @PostMapping("/delete")
  @RequiresPermissions(value = "user:delete", logical = Logical.OR)
  @OperationLog(action = "删除用户", type = OperationType.DELETE)
  public JsonResult delete(String ids) {
    if (StringUtils.isBlank(ids)) {
      return JsonResult.fail("请选择需要删除的用户", ids);
    }
    List<Integer> list = StringUtil.splitToListInt(ids);
    return sysUserService.delete(list);
  }

  @GetMapping("/pageQuery")
  @RequiresPermissions(value = "user:list", logical = Logical.OR)
  public JsonResult pageQuery(PageQuery pageQuery, UserSearch userSearch) {
    return sysUserService.pageQuery(pageQuery, userSearch);
  }

  @PostMapping("/userBindRole")
  @RequiresPermissions(value = "user:roleuser", logical = Logical.OR)
  @OperationLog(action = "用户绑定角色", type = OperationType.OTHERT)
  public JsonResult userBindRole(Integer userId, String roleIds) {
        /*if (StringUtils.isBlank(roleIds)) {
            return JsonResult.fail("请选择角色", null);
        }*/
    List<Integer> list = StringUtil.splitToListInt(roleIds);
    return sysCoreService.userBindRole(userId, list);
  }

  @RequiresUser
  @GetMapping("/getRoleDto")
  public JsonResult getRoleDto(Integer userId) {
    if (userId == null) {
      return JsonResult.fail("请选择用户", null);
    }
    return sysCoreService.roleBindInfo(userId);
  }

  @PostMapping("/updatePassword")
  @RequiresUser
  @OperationLog(action = "更新密码", type = OperationType.UPDATE)

  /**
   * @Description:
   * @params [username, srcpasswd, targetpasswd]
   * @Return: cn.shengrui.common.beans.JsonResult
   * @Author: itastro
   * @Date: 2018/11/30 9:45
   * String confirmpass
   */
  public JsonResult updatePassword(String username, String srcpasswd, String targetpasswd,
      String confirmpass) {
    return sysUserService.updatePassword(username, srcpasswd, targetpasswd, confirmpass);
  }
}
