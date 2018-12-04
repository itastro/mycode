package cn.shengrui.system.service.impl;

import cn.shengrui.common.beans.JsonResult;
import cn.shengrui.common.util.LevelUtil;
import cn.shengrui.dto.SysMenuLeveDto;
import cn.shengrui.system.entity.SysMenu;
import cn.shengrui.system.mapper.SysMenuMapper;
import cn.shengrui.system.service.SysCoreService;
import cn.shengrui.system.service.SysTreeService;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @ClassName SysTreeServiceImpl
 * @Description 系统中树形结构实现
 * @Date 2018/10/22 14:42
 * @Author itastro
 * @Version 1.0
 **/
@Service
public class SysTreeServiceImpl implements SysTreeService {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Autowired
    private SysCoreService sysCoreService;

    @Override
    public JsonResult menuTree() {

        //获取所有的菜单
        List<SysMenu> menuList = sysMenuMapper.getAllMenu();
        //创建 SysMenuLeveDto List
        List<SysMenuLeveDto> dtoList = Lists.newArrayList();
        //进行遍历适配
        for (SysMenu menu : menuList) {
            SysMenuLeveDto dto = SysMenuLeveDto.adapt(menu);
            dtoList.add(dto);
        }
        //menuList  TO Tree
        List<SysMenuLeveDto> menuTree = menuListToTree(dtoList);
        return JsonResult.success("成功", menuTree);
    }

    public List<SysMenuLeveDto> menuListToTree(List<SysMenuLeveDto> menuLeveList) {

        //判断集合是否为空
        if (CollectionUtils.isEmpty(menuLeveList)) {
            //如果是空的话  返回一个空的集合
            return Lists.newArrayList();
        }
        // level -> [menu1,menu2,......] Map<String ,List<Object>>
        Multimap<String, SysMenuLeveDto> levelMenuMap = ArrayListMultimap.create();

        //创建一个部门的根集合
        List<SysMenuLeveDto> rootList = Lists.newArrayList();

        //遍历所有的菜单
        for (SysMenuLeveDto dto : menuLeveList) {
            //层级作为key   菜单作为value  存进Map
            levelMenuMap.put(dto.getLevel(), dto);
            //当节点为根节点的时候 添加到rootList
            if (LevelUtil.ROOT.equals(dto.getLevel())) {
                rootList.add(dto);
            }
        }

        //按照seq从小到大排序
        Collections.sort(rootList, new Comparator<SysMenuLeveDto>() {
            @Override
            public int compare(SysMenuLeveDto o1, SysMenuLeveDto o2) {
                return o1.getSeq() - o2.getSeq();
            }
        });

        //递归生成树
        transformMenuTree(rootList, LevelUtil.ROOT, levelMenuMap);
        return rootList;
    }

    // level:0 ,0 all 0->0.1,0.2
    //level: 0.1
    // level: 0.2

    public void transformMenuTree(List<SysMenuLeveDto> menuLevelList, String level, Multimap<String, SysMenuLeveDto> levelMenuMap) {

        for (int i = 0; i < menuLevelList.size(); i++) {
            //遍历该层的每一个元素
            SysMenuLeveDto menuLeveDto = menuLevelList.get(i);
            //处理当前层级的数据
            String nextLevel = LevelUtil.calculateLevel(level, menuLeveDto.getId());
            //处理下一层的数据
            List<SysMenuLeveDto> tempMenuList = (List<SysMenuLeveDto>) levelMenuMap.get(nextLevel);
            if (CollectionUtils.isNotEmpty(tempMenuList)) {
                //排序
                Collections.sort(tempMenuList, menuSeqComparator);
                //设置下一层部门
                menuLeveDto.setMenuList(tempMenuList);
                // 进入到下一层处理
                transformMenuTree(tempMenuList, nextLevel, levelMenuMap);
            }
        }
    }

    /**
     * 菜单比较器
     */
    public Comparator<SysMenuLeveDto> menuSeqComparator = new Comparator<SysMenuLeveDto>() {
        @Override
        public int compare(SysMenuLeveDto o1, SysMenuLeveDto o2) {
            return o1.getSeq() - o2.getSeq();
        }
    };

    /**
     * 角色菜单树
     *
     * @param roleId
     * @return
     */
    @Override
    public JsonResult roleMenuTree(Integer roleId) {

        List<SysMenuLeveDto> dtoList = Lists.newArrayList();
        //获取当前用户分配的菜单点
        List<SysMenu> userMenuList = sysCoreService.getCurrentUserMenuList();
        //获取当前角色分配的菜单点
        List<SysMenu> roleMenuList = sysCoreService.getMenuByRoleId(roleId);
        //当前系统的所有菜单点
        List<SysMenu> allMenu = sysMenuMapper.getAllMenu();

        //把所有用户的菜单点构成一个set
        Set<Integer> userMenuIdSet = userMenuList.stream().map(sysMenu -> sysMenu.getId()).collect(Collectors.toSet());
        //把角色的菜单点构成一个set
        Set<Integer> roleMenuIdSet = roleMenuList.stream().map(sysMenu -> sysMenu.getId()).collect(Collectors.toSet());

        for (SysMenu sysMenu : allMenu) {
            //判断用户菜单集合是否包含这个
            if (userMenuIdSet.contains(sysMenu.getId())) {
                sysMenu.setChecked(true);
            }
        }
        //进行遍历适配
        for (SysMenu menu : allMenu) {
            SysMenuLeveDto dto = SysMenuLeveDto.adapt(menu);
            dtoList.add(dto);
        }
        List<SysMenuLeveDto> menuTree = menuListToTree(dtoList);
        return JsonResult.success("成功", menuTree);
    }

    @Override
    public JsonResult userMenuTree() {

        List<SysMenu> menuList = sysCoreService.getCurrentUserMenuList();
        //创建 SysMenuLeveDto List
        List<SysMenuLeveDto> dtoList = Lists.newArrayList();
        //进行遍历适配
        for (SysMenu menu : menuList) {
            SysMenuLeveDto dto = SysMenuLeveDto.adapt(menu);
            dtoList.add(dto);
        }

        List<SysMenuLeveDto> menuTree = menuListToTree(dtoList);
        return JsonResult.success("成功", menuTree);
    }
}
