package com.bl.station.controller.menu;

import com.bl.station.dto.MenuLeveDto;
import com.bl.station.exception.CustomException;
import com.bl.station.param.MenuParam;
import com.bl.station.service.menu.MenuService;
import com.bl.station.utils.StationResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author itastro
 */
@Api(description = "后端管理页面菜单API,菜单展示支持多层级")
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @ApiOperation(notes = "菜单的添加", value = "菜单的添加")
    @PostMapping("/add")
    public StationResult add(@RequestBody MenuParam menuParam) {

        try {
            return menuService.add(menuParam);
        } catch (CustomException e) {

            throw new CustomException("菜单添加失败");

        }
    }

    @ApiOperation(notes = "菜单的更新", value = "菜单的更新")
    @PostMapping("/update")
    public StationResult update(@RequestBody MenuParam menuParam) {

        try {
            return menuService.update(menuParam);

        } catch (CustomException ex) {

            throw new CustomException("菜单更新失败");
        }
    }

    @ApiOperation(notes = "菜单的删除", value = "菜单的删除")
    @PostMapping("/delete/{id}")
    public StationResult delete(@PathVariable(value = "id") @ApiParam(name = "id") Integer id) {
        try {
            return menuService.delete(id);
        } catch (CustomException ex) {

            throw new CustomException("删除菜单失败");
        }
    }

    @ApiOperation(notes = "获取所有的菜单", value = "菜单树")
    @GetMapping("/tree")
    public StationResult tree() {
        try {

            List<MenuLeveDto> list = menuService.menuTree();

            return StationResult.success(list);
        } catch (CustomException ex) {

            throw new CustomException("网络较慢，请稍等");
        }
    }
}
