package cn.shengrui.system.service.impl;

import cn.shengrui.common.beans.JsonResult;
import cn.shengrui.common.constant.SysStatus;
import cn.shengrui.common.util.HttpContextUtils;
import cn.shengrui.common.util.IpUtil;
import cn.shengrui.common.util.LevelUtil;
import cn.shengrui.param.SysMenuParam;
import cn.shengrui.system.entity.SysMenu;
import cn.shengrui.system.mapper.SysMenuMapper;
import cn.shengrui.system.mapper.SysRoleMenuMapper;
import cn.shengrui.system.service.SysMenuService;
import cn.shengrui.system.shiro.ShiroUtils;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @ClassName SysMenuServiceImpl
 * @Description TODO
 * @Date 2018/10/22 13:55
 * @Author itastro
 * @Version 1.0
 **/
@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;

    public HttpServletRequest getRequest() {
        return HttpContextUtils.getHttpServletRequest();
    }

    @Override
    public JsonResult save(SysMenuParam sysMenuParam) {
        if (checkExist(sysMenuParam.getParentId(), sysMenuParam.getName(), sysMenuParam.getId())) {
            return JsonResult.fail("此菜单已经存在", sysMenuParam);
        }
        SysMenu sysMenu = SysMenu.builder().name(sysMenuParam.getName()).parentId(sysMenuParam.getParentId()).seq(sysMenuParam.getSeq()).remark(sysMenuParam.getRemark()).type(sysMenuParam.getType()).url(sysMenuParam.getUrl()).build();
        sysMenu.setLevel(LevelUtil.calculateLevel(getLevel(sysMenuParam.getId()), sysMenuParam.getParentId()));
        sysMenu.setOperateIp(IpUtil.getUserIP(getRequest()));
        sysMenu.setOperateTime(new Date());
        sysMenu.setStatus(SysStatus.USE);
        sysMenu.setOperator(ShiroUtils.getUserName());

        sysMenuMapper.insert(sysMenu);
        return JsonResult.success("菜单添加成功", sysMenu);
    }

    private String getLevel(Integer menuId) {

        SysMenu sysMenu = sysMenuMapper.selectByPrimaryKey(menuId);
        if (sysMenu == null) {
            return null;
        }
        return sysMenu.getLevel();
    }


    @Override
    public JsonResult update(SysMenuParam sysMenuParam) {
        if (checkExist(sysMenuParam.getParentId(), sysMenuParam.getName(), sysMenuParam.getId())) {
            return JsonResult.fail("此菜单已经存在", sysMenuParam);
        }
        SysMenu beforSysMenu = sysMenuMapper.selectByPrimaryKey(sysMenuParam.getId());
        if (beforSysMenu == null) {
            return JsonResult.fail("待更新的菜单不存在", beforSysMenu);
        }
        SysMenu afterSysMenu = SysMenu.builder().name(sysMenuParam.getName()).url(sysMenuParam.getUrl()).type(sysMenuParam.getType()).seq(sysMenuParam.getSeq()).parentId(sysMenuParam.getParentId()).remark(sysMenuParam.getRemark()).id(sysMenuParam.getId()).build();
        afterSysMenu.setLevel(LevelUtil.calculateLevel(getLevel(sysMenuParam.getId()), sysMenuParam.getParentId()));
        sysMenuMapper.updateByPrimaryKey(afterSysMenu);
        return updateWithChild(beforSysMenu, afterSysMenu);
    }


    private JsonResult updateWithChild(SysMenu before, SysMenu after) {
        String newLevelPrefix = after.getLevel();
        String oldLevelPrefix = before.getLevel();
        if (!after.getLevel().equals(before.getLevel())) {
            List<SysMenu> menuList = sysMenuMapper.getChildMenuListByLevel(before.getLevel());
            if (CollectionUtils.isNotEmpty(menuList)) {
                for (SysMenu menu : menuList) {
                    String level = menu.getLevel();
                    if (level.indexOf(oldLevelPrefix) == 0) {
                        level = newLevelPrefix + level.substring(oldLevelPrefix.length());
                        menu.setLevel(level);
                    }
                }
                sysMenuMapper.batchUpdateLevel(menuList);
            }
        }
        sysMenuMapper.updateByPrimaryKey(after);

        return JsonResult.success("更新成功", after);
    }


    private boolean checkExist(Integer parentId, String menuName, Integer menuId) {
        return sysMenuMapper.countByNameAndParentId(parentId, menuName, menuId) > 0;
    }


    @Override
    public JsonResult delete(Integer id) {
        SysMenu sysMenu = sysMenuMapper.selectByPrimaryKey(id);
        if (sysMenu == null) {
            return JsonResult.fail("待删除的菜单不存在");
        }
        if (sysMenuMapper.countByParentId(sysMenu.getId()) > 0) {
            return JsonResult.fail("当前菜单下面有子菜单，无法删除");
        }


        //解除菜单与角色之间的关系
        sysRoleMenuMapper.deleteByMenuId(sysMenu.getId());

        sysMenuMapper.deleteByPrimaryKey(sysMenu.getId());

        return JsonResult.success("菜单删除成功", null);

    }
}
