package com.bl.station.serviceimpl.itemcat;

import com.bl.station.Bean.BeanValidator;
import com.bl.station.dto.ItemCatLeveDto;
import com.bl.station.entity.Itemcat;
import com.bl.station.exception.ParamException;
import com.bl.station.exception.PermissionException;
import com.bl.station.mapper.ItemcatMapper;
import com.bl.station.param.ItemCatParam;
import com.bl.station.service.ItemCat.ItemCatService;
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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * @ClassName ItemCarServiceImpl
 * @Description TODO
 * @Date 2018/8/14 11:17
 * @Author itastro
 * @Version 1.0
 **/
@Service
@Slf4j
public class ItemCatServiceImpl implements ItemCatService {


    @Autowired
    private ItemcatMapper itemcatMapper;

    /**
     * 保存分类书的方法
     *
     * @param itemCatParam
     * @return
     */
    @Override
    public StationResult save(ItemCatParam itemCatParam) {

        log.info("itemCatParam:{}", JsonMapper.obj2String(itemCatParam));
        BeanValidator.check(itemCatParam);
        if (CheckExist(itemCatParam.getParentId(), itemCatParam.getName(), itemCatParam.getId())) {
            throw new ParamException("同一层级下存在相同的菜单");
        }

        //创建分类
        Itemcat itemcat = Itemcat.builder().name(itemCatParam.getName()).parentId(itemCatParam.getParentId()).seq(itemCatParam.getSeq())
                .iconurl(itemCatParam.getIconurl()).build();


        //设置层级
        itemcat.setLevel(LeveUtils.calculateLevel(getLevel(itemCatParam.getParentId()), itemCatParam.getParentId()));

        //设计操作人
        itemcat.setCreatetime(new Date());
        itemcatMapper.insertSelective(itemcat);

        return StationResult.success("产品分类添加成功");
    }


    /**
     * 获取菜单的层级
     *
     * @param menuId
     * @return
     */
    private String getLevel(Integer menuId) {

        //如果部门空的时候显示不存在
        Itemcat itemcat = itemcatMapper.selectByPrimaryKey(menuId);
        if (itemcat == null) {
            return null;
        }
        //如果不是空的时候返回parentid
        return itemcat.getLevel();
    }

    /**
     * 检查分类是否存在
     *
     * @param parentId
     * @param menuName
     * @param menuId
     * @return
     */
    private boolean CheckExist(Integer parentId, String menuName, Integer menuId) {

        return itemcatMapper.countByNameAndParentId(parentId, menuName, menuId) > 0;
    }



    @Override
    public List<ItemCatLeveDto> tree() {
        List<Itemcat> itemcatList = itemcatMapper.getAllItemCat();

        List<ItemCatLeveDto> dtoList = Lists.newArrayList();

        for (Itemcat itemcat : itemcatList) {

            ItemCatLeveDto dto = ItemCatLeveDto.adapt(itemcat);
            dtoList.add(dto);
        }
        return itemcatListToTree(dtoList);
    }

    //组装递归树
    public List<ItemCatLeveDto> itemcatListToTree(List<ItemCatLeveDto> itemcatLeveList) {

        if (CollectionUtils.isEmpty(itemcatLeveList)) {

            return Lists.newArrayList();

        }

        // level ->> [menu1,menu2]
        Multimap<String, ItemCatLeveDto> leveItemCatMap = ArrayListMultimap.create();

        List<ItemCatLeveDto> rootList = Lists.newArrayList();

        for (ItemCatLeveDto dto : itemcatLeveList) {
            leveItemCatMap.put(dto.getLevel(), dto);

            if (LeveUtils.ROOT.equals(dto.getLevel())) {

                rootList.add(dto);
            }

        }

        //按照优先级进行排序
        Collections.sort(rootList, new Comparator<ItemCatLeveDto>() {

            @Override
            public int compare(ItemCatLeveDto o1, ItemCatLeveDto o2) {
                // TODO Auto-generated method stub
                return o1.getSeq() - o2.getSeq();
            }
        });

        //递归生成树
        transformItemCatTree(rootList, LeveUtils.ROOT, leveItemCatMap);
        return rootList;
    }

    //递归
    //level : 0 , 0 all 0->0.1,0.2
    //level : 0.1
    //level : 0.2

    public void transformItemCatTree(List<ItemCatLeveDto> itemcatLeveList, String level, Multimap<String, ItemCatLeveDto> leveItemCatMap) {

        for (int i = 0; i < itemcatLeveList.size(); i++) {
            //遍历该层的么一个元素
            ItemCatLeveDto itemCatLeveDto = itemcatLeveList.get(i);
            //处理当前层级的数据
            String nextLeve = LeveUtils.calculateLevel(level, itemCatLeveDto.getId());
            //处理下一层
            List<ItemCatLeveDto> tempItemCatList = (List<ItemCatLeveDto>) leveItemCatMap.get(nextLeve);

            //对当前层级进行排序
            if (CollectionUtils.isNotEmpty(tempItemCatList)) {

                //排序
                Collections.sort(tempItemCatList, menuSeqComparator);
                //设置下一层菜单
                itemCatLeveDto.setChildren(tempItemCatList);
                //进入到下一层处理
                transformItemCatTree(tempItemCatList, nextLeve, leveItemCatMap);

            }
        }
    }

    //排序
    public Comparator<ItemCatLeveDto> menuSeqComparator = new Comparator<ItemCatLeveDto>() {
        @Override
        public int compare(ItemCatLeveDto o1, ItemCatLeveDto o2) {
            // TODO Auto-generated method stub
            return o1.getSeq() - o2.getSeq();
        }
    };


    @Override
    public StationResult delete(Integer id) {
        if (id == null) {
            return StationResult.fail("请选择一个菜单");
        }
        try {
            itemcatMapper.deleteByPrimaryKey(id);
            return StationResult.success("删除成功");
        } catch (Exception e) {
            return StationResult.fail("删除失败");
        }
    }


    @Override
    public StationResult update(ItemCatParam itemCatParam) {
        log.info("itemCatParam:{}", JsonMapper.obj2String(itemCatParam));
        BeanValidator.check(itemCatParam);
        //更新前、
        Itemcat befor = itemcatMapper.selectByPrimaryKey(itemCatParam.getId());
        //进行校验
        Preconditions.checkNotNull(befor, "待更新的产品分类不存在不存在");
        //同意层级下是否存在相同的部门
        if (CheckExist(itemCatParam.getParentId(), itemCatParam.getName(), itemCatParam.getId())) {

            throw new ParamException("同一层级下存在相同的分类");
        }

        //更新
        Itemcat after = Itemcat.builder().name(itemCatParam.getName()).id(itemCatParam.getId()).parentId(itemCatParam.getParentId()).remark(itemCatParam.getRemark()).seq(itemCatParam.getSeq()).build();

        //设置层级
        after.setLevel(LeveUtils.calculateLevel(getLevel(itemCatParam.getParentId()), itemCatParam.getParentId()));

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
    public void updateWithChild(Itemcat befor, Itemcat after) {
        //新的菜单的level
        String newLevePrefix = after.getLevel();
        //旧的菜单的层级
        String oldLevelPrefix = befor.getLevel();

        if (after.getLevel().equals(befor.getLevel())) {
            //处理子菜单
            List<Itemcat> menuList = itemcatMapper.getChildItemCatListByLevel(befor.getLevel());

            if (CollectionUtils.isNotEmpty(menuList)) {
                for (Itemcat menu : menuList) {
                    String level = menu.getLevel();
                    if (level.indexOf(oldLevelPrefix) == 0) {
                        level = newLevePrefix + level.substring(oldLevelPrefix.length());
                        menu.setLevel(level);

                    }

                }
                itemcatMapper.batchUpdateLevel(menuList);
            }
        }
        //更细
        itemcatMapper.updateByPrimaryKey(after);
    }

    @Override
    public Itemcat findItemCatById(Integer id) {


        return itemcatMapper.findItemCatById(id);
    }
}
