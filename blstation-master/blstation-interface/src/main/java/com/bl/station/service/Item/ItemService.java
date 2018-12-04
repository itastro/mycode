package com.bl.station.service.Item;

import com.bl.station.dto.ItemDto;
import com.bl.station.dto.ItemReturn;
import com.bl.station.entity.Item;
import com.bl.station.page.PageInfo;
import com.bl.station.page.PageParam;
import com.bl.station.param.ItemParam;
import com.bl.station.param.ItemSearch;
import com.bl.station.utils.StationResult;

import java.util.List;


/**
 * @ClassName ItemService
 * @Description TODO
 * @Date 2018/8/14 11:15
 * @Author itastro
 * @Version 1.0
 **/
public interface ItemService {


    StationResult save(ItemParam itemParam);

    StationResult delete(String ids);

    StationResult update(ItemParam itemParam);

    PageInfo<ItemReturn> pageQuery(PageParam pageParam, ItemSearch itemSearch);

    PageInfo<Item> findAll(PageParam pageParam);

    ItemDto findOne(Integer id);

    List<Item> findByItemCatId(Integer id);

    List<Item> search(String name);

}
