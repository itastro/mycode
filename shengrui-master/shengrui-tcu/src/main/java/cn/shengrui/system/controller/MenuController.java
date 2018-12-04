package cn.shengrui.system.controller;

import cn.shengrui.common.beans.JsonResult;
import cn.shengrui.param.SysMenuParam;
import cn.shengrui.system.service.SysMenuService;
import cn.shengrui.system.service.SysTreeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @ClassName MenuControler
 * @Description TODO
 * @Date 2018/10/22 16:35
 * @Author itastro
 * @Version 1.0
 **/
@Api(description = "菜单API")
@RestController
@RequestMapping("/sysmenu")
public class MenuController {

    @Autowired
    private SysTreeService sysTreeService;

    @Autowired
    private SysMenuService sysMenuService;

    @GetMapping("/menuTree")
    public JsonResult menuTree() {

        return sysTreeService.menuTree();

    }
    @ApiOperation(value = "菜单增加", notes = "菜单增加")
    @PostMapping("/save")
    public JsonResult save(@Valid SysMenuParam sysMenuParam, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return JsonResult.fail(bindingResult.getFieldError().getDefaultMessage(), null);
        }
        return sysMenuService.save(sysMenuParam);
    }
    @ApiOperation(value = "菜单更新", notes = "菜单更新")
    @PostMapping("/update")
    public JsonResult update(@Valid SysMenuParam sysMenuParam, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return JsonResult.fail(bindingResult.getFieldError().getDefaultMessage(), null);
        }
        return sysMenuService.update(sysMenuParam);
    }

    @PostMapping("/delete")

    public JsonResult delete(Integer id) {
        if (id == null) {
            return JsonResult.fail("请传入菜单ID", null);
        }
        return sysMenuService.delete(id);
    }
}
