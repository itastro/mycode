package com.bl.station.serviceimpl.menu;

import com.bl.station.Bean.BeanValidator;
import com.bl.station.dto.MenuLeveDto;
import com.bl.station.entity.Menu;
import com.bl.station.exception.ParamException;
import com.bl.station.exception.PermissionException;
import com.bl.station.mapper.MenuMapper;
import com.bl.station.param.MenuParam;
import com.bl.station.service.menu.MenuService;
import com.bl.station.utils.JsonMapper;
import com.bl.station.utils.LeveUtils;
import com.bl.station.utils.StationResult;
import com.google.common.base.Preconditions;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Slf4j
@Component
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    /**
     * 保存部门树的方法
     *
     * @param menuParam
     * @return StationResult
     */
    @Override
    public StationResult add(MenuParam menuParam) {
        log.info("menuParam:{}", JsonMapper.obj2String(menuParam));
        BeanValidator.check(menuParam);
        if (CheckExist(menuParam.getParentId(), menuParam.getName(), menuParam.getId())) {
            throw new ParamException("同一层级下存在相同的菜单");
        }
        //创建菜单
        Menu menu = Menu.builder().name(menuParam.getName()).parentId(menuParam.getParentId()).seq(menuParam.getSeq())
                .url(menuParam.getUrl()).icon(menuParam.getIcon()).build();
        //设置层级
        menu.setLevel(LeveUtils.calculateLevel(getLevel(menuParam.getParentId()), menuParam.getParentId()));
        //设计操作人
        menu.setOperator("SYS");
        menu.setCreatetime(new Date());
        menuMapper.insertSelective(menu);

        return StationResult.success("添加成功");
    }

    /**
     * 检查菜单是否存在
     * @param parentId
     * @param menuName
     * @param menuId
     * @return
     */
    private boolean CheckExist(Integer parentId, String menuName, Integer menuId) {

        return menuMapper.countByNameAndParentId(parentId, menuName, menuId) > 0;
    }

    /**
     * 获取层级
     * @param menuId
     * @return
     */
    private String getLevel(Integer menuId) {

        //如果部门空的时候显示不存在
        Menu menu = menuMapper.selectByPrimaryKey(menuId);
        if (menu == null) {
            return null;
        }
        //如果不是空的时候返回parentid
        return menu.getLevel();
    }

    @Override
    public List<MenuLeveDto> menuTree() {
        List<Menu> menuList = menuMapper.getAllMenu();

        List<MenuLeveDto> dtoList = Lists.newArrayList();

        for (Menu menu : menuList) {

            MenuLeveDto dto = MenuLeveDto.adapt(menu);
            dtoList.add(dto);
        }
        return menuListToTree(dtoList);
    }

    //组装递归树
    public List<MenuLeveDto> menuListToTree(List<MenuLeveDto> menuLeveList) {

        if (CollectionUtils.isEmpty(menuLeveList)) {

            return Lists.newArrayList();

        }

        // level ->> [menu1,menu2]
        Multimap<String, MenuLeveDto> leveMenuMap = ArrayListMultimap.create();

        List<MenuLeveDto> rootList = Lists.newArrayList();

        for (MenuLeveDto dto : menuLeveList) {
            leveMenuMap.put(dto.getLevel(), dto);

            if (LeveUtils.ROOT.equals(dto.getLevel())) {

                rootList.add(dto);
            }

        }

        //按照优先级进行排序
        Collections.sort(rootList, new Comparator<MenuLeveDto>() {

            @Override
            public int compare(MenuLeveDto o1, MenuLeveDto o2) {
                // TODO Auto-generated method stub
                return o1.getSeq() - o2.getSeq();
            }
        });

        //递归生成树
        transformMenuTree(menuLeveList, LeveUtils.ROOT, leveMenuMap);
        return rootList;
    }


    //递归
    //level : 0 , 0 all 0->0.1,0.2
    //level : 0.1
    //level : 0.2

    public void transformMenuTree(List<MenuLeveDto> menuLeveList, String level, Multimap<String, MenuLeveDto> leveMenuMap) {

        for (int i = 0; i < menuLeveList.size(); i++) {
            //遍历该层的么一个元素
            MenuLeveDto menuLeveDto = menuLeveList.get(i);
            //处理当前层级的数据
            String nextLeve = LeveUtils.calculateLevel(level, menuLeveDto.getId());
            //处理下一层
            List<MenuLeveDto> tempMenuList = (List<MenuLeveDto>) leveMenuMap.get(nextLeve);

            //对当前层级进行排序
            if (CollectionUtils.isNotEmpty(tempMenuList)) {

                //排序
                Collections.sort(tempMenuList, menuSeqComparator);
                //设置下一层菜单
                menuLeveDto.setChildren(tempMenuList);
                //进入到下一层处理
                transformMenuTree(tempMenuList, level, leveMenuMap);

            }
        }
    }

    //排序
    public Comparator<MenuLeveDto> menuSeqComparator = new Comparator<MenuLeveDto>() {
        @Override
        public int compare(MenuLeveDto o1, MenuLeveDto o2) {
            // TODO Auto-generated method stub
            return o1.getSeq() - o2.getSeq();
        }
    };

    /**
     * 更新菜单
     * @param menuParam
     * @return
     */
    @Override
    public StationResult update(MenuParam menuParam) {
        log.info("menuParm:{}", menuParam);
        BeanValidator.check(menuParam);
        //更新前、
        Menu befor = menuMapper.selectByPrimaryKey(menuParam.getId());
        //进行校验
        Preconditions.checkNotNull(befor, "待更新的菜单不存在");
        //同意层级下是否存在相同的部门
        if (CheckExist(menuParam.getParentId(), menuParam.getName(), menuParam.getId())) {

            throw new ParamException("同一层级下存在相同的菜单");
        }

        //更新
        Menu after = Menu.builder().name(menuParam.getName()).id(menuParam.getId()).parentId(menuParam.getParentId()).url(menuParam.getUrl()).remark(menuParam.getRemark()).seq(menuParam.getSeq()).build();

        //设置层级
        after.setLevel(LeveUtils.calculateLevel(getLevel(menuParam.getParentId()), menuParam.getParentId()));
        //TODD
        after.setOperator("SYS");
        after.setCreatetime(new Date());
        updateWithChild(befor, after);
        return StationResult.success("菜单更新成功");
    }

    /**
     * 更新
     * @param befor
     * @param after
     */
    @Transactional(rollbackFor = PermissionException.class)
    public void updateWithChild(Menu befor, Menu after) {
        //新的菜单的level
        String newLevePrefix = after.getLevel();
        //旧的菜单的层级
        String oldLevelPrefix = befor.getLevel();

        if (after.getLevel().equals(befor.getLevel())) {
            //处理子菜单
            List<Menu> menuList = menuMapper.getChildMenuListByLevel(befor.getLevel());

            if (CollectionUtils.isNotEmpty(menuList)) {
                for (Menu menu : menuList) {
                    String level = menu.getLevel();
                    if (level.indexOf(oldLevelPrefix) == 0) {
                        level = newLevePrefix + level.substring(oldLevelPrefix.length());
                        menu.setLevel(level);
                    }

                }
                menuMapper.batchUpdateLevel(menuList);
            }
        }
        //更细
        menuMapper.updateByPrimaryKey(after);
    }


    /**
     * 删除菜单
     * @param id
     * @return
     */
    @Override
    public StationResult delete(Integer id) {

        if (id == null) {
            return StationResult.fail("请选择一个菜单");
        }
        try {
            menuMapper.deleteByPrimaryKey(id);
            return StationResult.success("删除成功");
        } catch (Exception e) {
            return StationResult.fail("删除失败");
        }
    }
}