package com.bl.station.controller.ItemCat;

import com.bl.station.Bean.BeanValidator;
import com.bl.station.dto.ItemCatLeveDto;
import com.bl.station.entity.Itemcat;
import com.bl.station.param.ItemCatParam;
import com.bl.station.service.ItemCat.ItemCatService;
import com.bl.station.utils.JsonMapper;
import com.bl.station.utils.StationResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "产品分类api", description = "产品分类api")
/**
 * @ClassName ItemCatController
 * @Description TODO
 * @Date 2018/8/14 11:11
 * @Author itastro
 * @Version 1.0
 **/

@Slf4j
@RestController
@RequestMapping("/itemcat")
public class ItemCatController {

    @Autowired
    private ItemCatService itemCatService;

    @PostMapping("/add")
    @ApiOperation(value = "保存分类", notes = "保存产品分类")
    public StationResult save(ItemCatParam itemCatParam) {
        log.info("itemCatOarams:{}", JsonMapper.obj2String(itemCatParam));
        BeanValidator.check(itemCatParam);

        return itemCatService.save(itemCatParam);
    }


    @PostMapping("/delete")
    @ApiOperation(value = "删除产品分类", notes = "删除产品分类")
    @ApiImplicitParam(name = "id", value = "id字符串", dataType = "String", paramType = "query")
    public StationResult delete(Integer id) {
        return itemCatService.delete(id);
    }


    @PostMapping("/list")
    @ApiOperation(value = "产品分类加载", notes = "产品分类加载")

    public StationResult tree() {


        List<ItemCatLeveDto> itemCatLeveDtos = itemCatService.tree();
        return StationResult.success(itemCatLeveDtos);

    }


    @PostMapping("/update")
    @ApiOperation(value = "修改产品分类", notes = "修改产品分类")

    public StationResult update(ItemCatParam itemCatParam) {

        return itemCatService.update(itemCatParam);
    }


    @PostMapping("/findItemCatById")
    @ApiOperation(value = "通过分类id查分类名称", notes = "通过分类id查分类名称")

    public Itemcat findItemCatById(Integer id) {

        return itemCatService.findItemCatById(id);
    }
}
