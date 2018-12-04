package cn.shengrui.system.service;


import cn.shengrui.common.beans.JsonResult;
import cn.shengrui.system.entity.SysMenu;

import java.util.List;

/**
 * @author itastro
 */

public interface SysCoreService {

    /**
     * 用户关联角色
     *
     * @param userId
     * @param roleIds
     * @return
     */
    JsonResult userBindRole(Integer userId, List<Integer> roleIds);


    /**
     * 角色绑定权限
     *
     * @param roleId
     * @param aclIds
     * @return
     */
    JsonResult roleBindAcl(Integer roleId, List<Integer> aclIds);

    /**
     * 角色绑定菜单
     *
     * @param roleId
     * @param menuIds
     * @return
     */
    JsonResult roleBindMenu(Integer roleId, List<Integer> menuIds);


    /**
     * 用户未关联的角色
     *
     * @param userId
     * @return
     */
    JsonResult userNoRole(Integer userId);

    /**
     * 角色未关联的权限
     *
     * @param roleId
     * @return
     */
    JsonResult roleNoAcl(Integer roleId);


    /**
     * 用户关联的角色
     *
     * @param userId
     * @return
     */
    JsonResult userInRole(Integer userId);


    /**
     * 角色关联的权限
     *
     * @param roleId
     * @return
     */
    JsonResult roleInAcl(Integer roleId);

    /**
     * 通过用户查询权限
     *
     * @param userId
     * @return
     */
    JsonResult userInAcl(Integer userId);

    /**
     * 用户绑定角色
     *
     * @param userId
     * @return
     */
    JsonResult roleBindInfo(Integer userId);

    /**
     * 角色绑定权限
     *
     * @param roleId
     * @return
     */
    JsonResult aclBindInfo(Integer roleId);


    /**
     * 通过角色查询菜单
     *
     * @param roleId
     * @return
     */
    List<SysMenu> getMenuByRoleId(Integer roleId);

    /**
     * 获取当前用户分配的菜单
     * @return
     */
    List<SysMenu> getCurrentUserMenuList();
}
