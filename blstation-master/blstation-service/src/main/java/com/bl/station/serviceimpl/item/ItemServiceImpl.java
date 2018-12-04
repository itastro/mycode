package com.bl.station.serviceimpl.item;

import com.bl.station.dto.ItemDto;
import com.bl.station.dto.ItemReturn;
import com.bl.station.entity.Item;
import com.bl.station.entity.ItemdescWithBLOBs;
import com.bl.station.exception.ParamException;
import com.bl.station.mapper.ItemMapper;
import com.bl.station.mapper.ItemdescMapper;
import com.bl.station.page.PageInfo;
import com.bl.station.page.PageParam;
import com.bl.station.param.ItemParam;
import com.bl.station.param.ItemSearch;
import com.bl.station.service.Item.ItemService;
import com.bl.station.service.picture.PictrueService;
import com.bl.station.utils.FTPUtil;
import com.bl.station.utils.StationResult;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @ClassName ItemServiceImpl
 * @Description 产品的实现类
 * @Date 2018/8/14 11:16
 * @Author itastro
 * @Version 1.0
 **/
@Service
@Transactional
@Slf4j
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private ItemdescMapper itemdescMapper;

    @Autowired

    private PictrueService pictrueService;


    @Override
    public StationResult save(ItemParam itemParam) {

        if (itemParam.getPic() == null) {
            return StationResult.fail("照片不能为空");
        }
        saveItem(itemParam);

        return StationResult.success("商品添加成功");
    }

    private void saveItem(ItemParam itemParam) {
        Item item = getItem(itemParam);
        int i = itemMapper.insert(item);

        log.info(i + "");
        log.info("id:{}", item.getId());

        ItemdescWithBLOBs itemdesc = getItemdesc(itemParam, item.getId());

        itemdescMapper.insert(itemdesc);
    }

    private ItemdescWithBLOBs getItemdesc(ItemParam itemParam, int i) {

        ItemdescWithBLOBs itemdescWithBLOBs = itemdescMapper.selectByItemId(itemParam.getId());
        if (itemdescWithBLOBs == null) {
            itemdescWithBLOBs = new ItemdescWithBLOBs();
        }
        itemdescWithBLOBs.setCreatetime(new Date());
        itemdescWithBLOBs.setItemId(i);
        itemdescWithBLOBs.setDescn(itemParam.getDesc());
        itemdescWithBLOBs.setApplication(itemParam.getApplication());
        itemdescWithBLOBs.setFunction(itemParam.getFunction());
        itemdescWithBLOBs.setParam(itemParam.getParam());
        return itemdescWithBLOBs;
    }

    private Item getItem(ItemParam itemParam) {
        String url = "";
        Item item = Item.builder().createtime(new Date()).itemcatId(itemParam.getItemcatId()).name(itemParam.getName()).build();
        item.setStatus((byte) 1);

        if (itemParam.getPic() != null) {
            try {
                //url = pictrueService.upload(itemParam.getPic());

                url = FTPUtil.webUploadLocalFile(itemParam.getPic());

                item.setPicurl(url);
            } catch (Exception e) {

            }
        }


        return item;
    }

    @Override
    public StationResult delete(String ids) {

        if (StringUtils.isNotBlank(ids)) {

            String[] splitids = ids.split(",");

            for (String id : splitids) {
                itemMapper.deleteByPrimaryKey(Integer.parseInt(id));
            }

            return StationResult.success("删除成功");
        }
        return StationResult.success("删除成功");
    }

    @Override
    public StationResult update(ItemParam itemParam) {
        updateItem(itemParam);
        return StationResult.success("更新成功");
    }

    @Override
    public PageInfo<ItemReturn> pageQuery(PageParam pageParam, ItemSearch itemSearch) {

        PageHelper.startPage(pageParam.getPage(), pageParam.getSize());
        List<ItemReturn> list = itemMapper.pageQuery(itemSearch);
        PageInfo<ItemReturn> result = new PageInfo<ItemReturn>(list);
        return result;
    }

    @Override
    public PageInfo<Item> findAll(PageParam pageParam) {
        PageHelper.startPage(pageParam.getPage(), pageParam.getSize());
        List<Item> list = itemMapper.findAll();
        PageInfo<Item> result = new PageInfo<Item>(list);
        return result;
    }

    private void updateItem(ItemParam itemParam) {

        if (itemParam.getId() == null) {
            throw new ParamException("请传入ID");
        }

        Item item = itemMapper.selectByPrimaryKey(itemParam.getId());
        Item item1 = getItem(itemParam);
        item1.setId(itemParam.getId());
        if (StringUtils.isBlank(item1.getPicurl())) {
            item1.setPicurl(item.getPicurl());
        }
        itemMapper.updateByPrimaryKey(item1);


        ItemdescWithBLOBs itemdesc = getItemdesc(itemParam, itemParam.getId());

        itemdescMapper.updateByPrimaryKeyWithBLOBs(itemdesc);
    }

    @Override
    public ItemDto findOne(Integer id) {

        ItemdescWithBLOBs itemdescWithBLOBs = itemdescMapper.selectByItemId(id);

        Item item = itemMapper.selectByPrimaryKey(id);
        ItemDto itemDto = ItemDto.getItemDto(itemdescWithBLOBs, item);
        return itemDto;
    }

    @Override
    public List<Item> findByItemCatId(Integer id) {

        List<Item> list = itemMapper.findByItemCatId(id);

        return list;
    }

    @Override
    public List<Item> search(String name) {

        if (StringUtils.isNotBlank(name)) {

            return itemMapper.likeName(name);
        }
        return itemMapper.findAll();
    }
}
