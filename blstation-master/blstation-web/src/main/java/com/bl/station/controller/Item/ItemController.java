package com.bl.station.controller.Item;

import com.bl.station.dto.ItemDto;
import com.bl.station.dto.ItemReturn;
import com.bl.station.entity.Item;
import com.bl.station.page.PageInfo;
import com.bl.station.page.PageParam;
import com.bl.station.param.ItemParam;
import com.bl.station.param.ItemSearch;
import com.bl.station.service.Item.ItemService;
import com.bl.station.utils.StationResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName ItemController
 * @Description 产品控制层
 * @Date 2018/8/14 11:12
 * @Author itastro
 * @Version 1.0
 **/
@Api(description = "产品api")
@Slf4j
@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @ApiOperation(value = "添加产品", notes = "添加产品")
    @PostMapping("/add")
    public StationResult save(ItemParam itemParam) {


        return itemService.save(itemParam);

    }

    @ApiOperation(value = "产品的删除", notes = "产品的删除")
    @PostMapping("/delete")
    @ApiImplicitParam(name = "ids", value = "id字符串", dataType = "String", paramType = "query")
    public StationResult delete(String ids) {
        log.info("ids:{}", ids);
        return itemService.delete(ids);
    }

    @ApiOperation(value = "产品的更新", notes = "产品的更新")
    @PostMapping("/update")
    public StationResult update(ItemParam itemParam) {
        //log.info("itemParam:{}", JsonMapper.obj2String(itemParam));
        // BeanValidator.check(itemParam);
        return itemService.update(itemParam);
    }

    @ApiOperation(value = "后端查询", notes = "后端查询管理")
    @PostMapping("/pageQuery")
    public PageInfo<ItemReturn> pageQuery(PageParam pageParam, ItemSearch itemSearch) {
        return itemService.pageQuery(pageParam, itemSearch);

    }

    @ApiOperation(value = "前端产品列表", notes = "前端产品列表")
    @GetMapping("/findAll")
    public PageInfo<Item> findAll(PageParam pageParam) {
        return itemService.findAll(pageParam);
    }


    @ApiOperation(value = "产品名称关键字查询", notes = "产品名称关键字查询")
    @PostMapping("/search")
    public List<Item> search(String name) {

        return itemService.search(name);
    }


    @PostMapping("/findById")
    @ApiOperation(value = "单个产品的详情", notes = "单个产品的详情")
    public ItemDto findOne(Integer id) {

        return itemService.findOne(id);
    }

    @PostMapping("/findByItemCatId")
    @ApiOperation(value = "通过产品分类id查询产品", notes = "通过产品分类id查询产品")
    public List<Item> findByItemCatId(Integer id) {

        return itemService.findByItemCatId(id);
    }
}
