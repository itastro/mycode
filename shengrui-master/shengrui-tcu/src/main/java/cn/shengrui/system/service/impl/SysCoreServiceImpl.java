package cn.shengrui.system.service.impl;

import cn.shengrui.common.beans.JsonResult;
import cn.shengrui.common.constant.SysUserConstant;
import cn.shengrui.common.enums.ResultEnum;
import cn.shengrui.common.exception.SystemException;
import cn.shengrui.common.util.HttpContextUtils;
import cn.shengrui.common.util.IpUtil;
import cn.shengrui.dto.AclDto;
import cn.shengrui.dto.RoleDto;
import cn.shengrui.system.entity.*;
import cn.shengrui.system.mapper.*;
import cn.shengrui.system.service.SysCoreService;
import cn.shengrui.system.shiro.ShiroUtils;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @ClassName SysCoreServiceImpl
 * @Description 用户 权限 角色 核心类
 * @Date 2018/10/22 13:58
 * @Author itastro
 * @Version 1.0
 **/
@Service
public class SysCoreServiceImpl implements SysCoreService {


    @Autowired
    private SysRoleUserMapper sysRoleUserMapper;

    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;

    @Autowired
    private SysRoleAclMapper sysRoleAclMapper;

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysAclMapper sysAclMapper;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysMenuMapper sysMenuMapper;


    public HttpServletRequest getRequest() {
        return HttpContextUtils.getHttpServletRequest();
    }


    @Override
    public JsonResult roleBindInfo(Integer userId) {
        RoleDto roleDto = new RoleDto();
        SysUser user = sysUserMapper.selectByPrimaryKey(userId);
        if (user.getUsername().equals(SysUserConstant.USERNAME)) {
            List<SysRole> roles = sysRoleMapper.findAllRole();
            List<SysRole> noBind = Lists.newArrayList();
            roleDto.setNoBind(noBind);
            roleDto.setInBind(roles);
            return JsonResult.success("加载成功", roleDto);
        } else {

            List<SysRole> inRole = (List<SysRole>) this.userInRole(userId).getData();
            List<SysRole> noRole = (List<SysRole>) this.userNoRole(userId).getData();
            roleDto.setInBind(inRole);
            roleDto.setNoBind(noRole);
            return JsonResult.success("加载成功", roleDto);
        }
    }


    @Override
    public JsonResult aclBindInfo(Integer roleId) {
        AclDto aclDto = new AclDto();
        List<SysAcl> inAcl = (List<SysAcl>) this.roleInAcl(roleId).getData();
        List<SysAcl> noAcl = (List<SysAcl>) this.roleNoAcl(roleId).getData();

        aclDto.setInBind(inAcl);
        aclDto.setNoBind(noAcl);

        return JsonResult.success("加载成功", aclDto);
    }

    @Override
    public JsonResult userNoRole(Integer userId) {

        if (userId == null) {
            return JsonResult.fail("请选择用户", null);
        }

        List<SysRole> noRoles = Lists.newArrayList();
        //取出所有角色的id
        List<Integer> roleIdList = sysRoleMapper.findAllId();
        //取出用户关联过的角色ID
        List<Integer> originRoleIdList = sysRoleUserMapper.findByUserId(userId);
        //把所有的角色id转换成SET
        Set<Integer> roleIdSet = Sets.newHashSet(roleIdList);
        //把所有已经关联用户的角色转换成SET
        Set<Integer> originRoleIdSet = Sets.newHashSet(originRoleIdList);

        roleIdSet.removeAll(originRoleIdSet);

        for (Integer id : roleIdSet) {
            SysRole sysRole = sysRoleMapper.selectByPrimaryKey(id);
            noRoles.add(sysRole);
        }


        return JsonResult.success("查询成功", noRoles);
    }

    @Override
    public JsonResult userBindRole(Integer userId, List<Integer> roleIds) {

        if (userId == null) {
            return JsonResult.fail("请选择用户", roleIds);
        }
       /* if (CollectionUtils.isEmpty(roleIds)) {
            return JsonResult.fail("请选择角色", roleIds);
        }*/

        //取出当前用户分配过的角色ID
        List<Integer> originRoleIdList = sysRoleUserMapper.findByUserId(userId);

        if (originRoleIdList.size() == roleIds.size()) {
            //用set集合进行去重
            Set<Integer> originRoleIdSet = Sets.newHashSet(originRoleIdList);
            Set<Integer> roleIdSet = Sets.newHashSet(roleIds);
            //移除相同的值
            originRoleIdSet.removeAll(roleIdSet);
            if (CollectionUtils.isEmpty(originRoleIdSet)) {
                return JsonResult.success("绑定成功", null);
            }


        }
        return updateUserRole(userId, roleIds);


    }

    public JsonResult updateUserRole(Integer userId, List<Integer> roleIds) {

        //把原来的值删除
        sysRoleUserMapper.deleteByUserId(userId);
        for (Integer roleId : roleIds) {
            //如果进行绑定过 ,结束本次循环  进行下一次循环
            if (checkExist(userId, roleId)) {
                continue;
            }
            SysRoleUser sysRoleUser = SysRoleUser.builder().roleId(roleId).userId(userId).build();
            sysRoleUser.setOperateIp(IpUtil.getUserIP(getRequest()));
            sysRoleUser.setOperateTime(new Date());
            sysRoleUser.setOperator(ShiroUtils.getUserName());
            sysRoleUserMapper.insert(sysRoleUser);
        }
        return JsonResult.success("关联成功", null);
    }

    private boolean checkExist(Integer userId, Integer roleId) {

        return sysRoleUserMapper.countByUserIdAndRoleId(userId, roleId) > 0;

    }


    @Override
    public JsonResult roleBindAcl(Integer roleId, List<Integer> aclIds) {

        if (roleId == null) {
            return JsonResult.fail("请选择角色", roleId);
        }
        /*if (CollectionUtils.isEmpty(aclIds)) {
            return JsonResult.fail("请选择权限", aclIds);
        }*/
        //取出当前角色分配过权限的ID
        List<Integer> originAclIdList = sysRoleAclMapper.findByRoleId(roleId);
        if (originAclIdList.size() == aclIds.size()) {
            //用set集合进行去重
            Set<Integer> aclIdSet = Sets.newHashSet(aclIds);
            Set<Integer> originAclIdSet = Sets.newHashSet(originAclIdList);
            originAclIdSet.removeAll(aclIdSet);
            if (CollectionUtils.isEmpty(originAclIdSet)) {
                return JsonResult.success("绑定成功", null);
            }
        }

        return updateRoleAcl(roleId, aclIds);
    }


    private boolean checkExistRoleUser(Integer roleId, Integer aclId) {

        return sysRoleAclMapper.countByroleIddAndaclId(roleId, aclId) > 0;

    }


    public JsonResult updateRoleAcl(Integer roleId, List<Integer> aclIds) {

        if (roleId == null) {
            return JsonResult.fail("请选择角色", roleId);
        }
       /* if (CollectionUtils.isEmpty(aclIds)) {
            return JsonResult.fail("请选择权限", aclIds);
        }*/

        //把原来的值删除
        sysRoleAclMapper.deleteByRoleId(roleId);

        for (Integer aclId : aclIds) {
            SysRoleAcl sysRoleAcl = SysRoleAcl.builder().aclId(aclId).roleId(roleId).build();
            sysRoleAcl.setOperateTime(new Date());
            sysRoleAcl.setOperateIp(IpUtil.getUserIP(getRequest()));
            sysRoleAcl.setOperator(ShiroUtils.getUserName());
            sysRoleAclMapper.insert(sysRoleAcl);
        }
        return JsonResult.success("绑定成功", null);
    }


    @Override
    public JsonResult userInRole(Integer userId) {
        if (userId == null) {
            return JsonResult.fail("请选择用户");
        }
        List<SysRole> roles = Lists.newArrayList();
        SysRoleUserExample sysRoleUserExample = new SysRoleUserExample();
        SysRoleUserExample.Criteria criteria = sysRoleUserExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<SysRoleUser> sysRoleUsers = sysRoleUserMapper.selectByExample(sysRoleUserExample);

        for (int j = 0; j < sysRoleUsers.size(); j++) {
            int roleId = sysRoleUsers.get(j).getRoleId();
            SysRole sysRole = sysRoleMapper.selectByPrimaryKey(roleId);
            roles.add(sysRole);
        }
        return JsonResult.success("查询成功", roles);
    }

    @Override
    public JsonResult roleNoAcl(Integer roleId) {
        if (roleId == null) {
            return JsonResult.fail("请选择用户", null);
        }

        List<SysAcl> noAcls = Lists.newArrayList();
        //取出所有权限的id
        List<Integer> aclIdList = sysAclMapper.findAllId();
        //取出关联过角色的权限
        List<Integer> originAclIdList = sysRoleAclMapper.findByRoleId(roleId);
        //把所有的角色Id转换成SET
        Set<Integer> aclIdSet = Sets.newHashSet(aclIdList);
        //把所有的已经关联角色的权限id转换成SET
        Set<Integer> originAclIdSet = Sets.newHashSet(originAclIdList);

        boolean f = aclIdSet.removeAll(originAclIdSet);

        for (Integer id : aclIdSet) {
            SysAcl sysAcl = sysAclMapper.selectByPrimaryKey(id);
            noAcls.add(sysAcl);
        }
        return JsonResult.success("查询成功", noAcls);
    }

    @Override
    public JsonResult roleInAcl(Integer roleId) {
        List<SysAcl> sysAcls = Lists.newArrayList();
        SysRoleAclExample sysRoleAclExample = new SysRoleAclExample();
        SysRoleAclExample.Criteria criteria = sysRoleAclExample.createCriteria();
        criteria.andRoleIdEqualTo(roleId);
        List<SysRoleAcl> sysRoleAcls = sysRoleAclMapper.selectByExample(sysRoleAclExample);

        for (int j = 0; j < sysRoleAcls.size(); j++) {
            int aclId = sysRoleAcls.get(j).getAclId();
            SysAcl sysAcl = sysAclMapper.selectByPrimaryKey(aclId);
            sysAcls.add(sysAcl);
        }
        return JsonResult.success("查询成功", sysAcls);
    }

    @Override
    public JsonResult userInAcl(Integer userId) {
        List<SysAcl> result = Lists.newArrayList();
        //通过用户查询所有的角色
        List<SysRole> roles = (List<SysRole>) this.userInRole(userId).getData();
        //通过所有的角色id查询权限
        for (SysRole sysRole : roles) {
            List<SysAcl> acls = (List<SysAcl>) this.roleInAcl(sysRole.getId()).getData();
            for (SysAcl sysAcl : acls) {
                result.add(sysAcl);
            }
        }
        return JsonResult.success("查询成功", result);
    }


    @Override
    public JsonResult roleBindMenu(Integer roleId, List<Integer> menuIds) {

        if (roleId == null) {
            return JsonResult.fail("请选择角色", roleId);
        }
        if (CollectionUtils.isEmpty(menuIds)) {
            return JsonResult.fail("请选择菜单", menuIds);
        }
        //获取当前用角色分配过的菜单ID
        List<Integer> originMenuIdList = sysRoleMenuMapper.findMenuIdByRoleId(roleId);
        if (originMenuIdList.size() == menuIds.size()) {
            //用set集合进行去重
            Set<Integer> originMenuIdSet = Sets.newHashSet(originMenuIdList);
            Set<Integer> menuIdSet = Sets.newHashSet(menuIds);
            //移除相同的值
            originMenuIdSet.removeAll(menuIdSet);
            if (CollectionUtils.isEmpty(originMenuIdSet)) {
                return JsonResult.success("绑定成功", null);
            }
        }

        return updateUserRole(roleId, menuIds);
    }

    public JsonResult updateRoleMenu(Integer roleId, List<Integer> menuIds) {

        sysRoleMenuMapper.deleteByRoleId(roleId);
        for (Integer menuId : menuIds) {
            SysRoleMenu sysRoleMenu = SysRoleMenu.builder().roleId(roleId).munuId(menuId).build();
            sysRoleMenu.setOperateIp(IpUtil.getUserIP(getRequest()));
            sysRoleMenu.setOperateTime(new Date());
            sysRoleMenu.setOperator(ShiroUtils.getUserName());
            sysRoleMenuMapper.insert(sysRoleMenu);
        }
        return JsonResult.success("关联成功", null);
    }

    @Override
    public List<SysMenu> getMenuByRoleId(Integer roleId) {

        List<SysMenu> menuList = Lists.newArrayList();
        List<Integer> menuIds = sysRoleMenuMapper.findMenuIdByRoleId(roleId);
        for (Integer menuId : menuIds) {
            SysMenu sysMenu = sysMenuMapper.selectByPrimaryKey(menuId);
            menuList.add(sysMenu);
        }
        return menuList;
    }

    @Override
    public List<SysMenu> getCurrentUserMenuList() {

        try {
            //获取当前的用户
            int userId = ShiroUtils.getUserId();
            //返回userID
            return getUserMenuList(userId);
        } catch (Exception e) {
            throw new SystemException(ResultEnum.NOLOGIN_ERROR);

        }

    }

    /**
     * 通过用户的id获取菜单
     *
     * @param userId
     * @return
     */
    public List<SysMenu> getUserMenuList(int userId) {
        List<SysMenu> menuList = Lists.newArrayList();
        if (ShiroUtils.supUser()) {
            return sysMenuMapper.getAllMenu();
        }
        List<Integer> menuIdList = Lists.newArrayList();
        List<Integer> roleIds = sysRoleUserMapper.findByUserId(userId);
        //遍历roleId
        for (Integer roleId : roleIds) {
            //通过roleId查询菜单id
            List<Integer> menuIds = sysRoleMenuMapper.findMenuIdByRoleId(roleId);
            for (Integer menuId : menuIds) {
                menuIdList.add(menuId);
            }
        }
        Set<Integer> menuIdSet = Sets.newHashSet(menuIdList);
        for (Integer menuId : menuIdSet) {
            SysMenu sysMenu = sysMenuMapper.selectByPrimaryKey(menuId);
            menuList.add(sysMenu);
        }
        return menuList;
    }


}
