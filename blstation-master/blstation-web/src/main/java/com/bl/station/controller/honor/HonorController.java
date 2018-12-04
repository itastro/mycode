package com.bl.station.controller.honor;

import com.bl.station.entity.Honor;
import com.bl.station.page.PageInfo;
import com.bl.station.page.PageParam;
import com.bl.station.param.HonorParam;
import com.bl.station.param.HonorSearch;
import com.bl.station.service.Honor.HonorService;
import com.bl.station.utils.StationResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName
 * @Description TODO
 * @Date 2018/8/13 14:57
 * @Author itastro
 * @Version 1.0
 **/
@Api(description = "公司荣誉资质api")
@RestController
@RequestMapping("/honor")
public class HonorController {

    @Autowired
    private HonorService honorService;


    @PostMapping("/add")
    @ApiOperation(value = "添加公司荣誉资质", notes = "保存公司荣誉资质")
    public StationResult save(HonorParam honorParam) throws  Exception{
        return honorService.save(honorParam);
    }

    @ApiOperation(value = "删除公司荣誉资质", notes = "删除公司荣誉资质")
    @PostMapping("/delete")
    @ApiImplicitParam(name = "ids",value = "id字符串",dataType = "String",paramType = "query")
    public StationResult delete(String ids) {
        return honorService.delete(ids);
    }

    @ApiOperation(value = "公司荣誉资质更新", notes = "公司荣誉资质更新")
    @PostMapping("/update")
    public StationResult update(HonorParam honorParam) throws Exception{
        return honorService.update(honorParam);
    }

    @ApiOperation(value = "后端管理查询", notes = "后端管理查询")
    @GetMapping("/pageQuery")
    public PageInfo<Honor> pageQuery(PageParam pageParam, HonorSearch honorSearch) {
        return honorService.pageQuery(pageParam, honorSearch);
    }

    @ApiOperation(value = "前端展示查询分页", notes = "前端展示查询分页")
    @GetMapping("/selectAll")
    public PageInfo<Honor> selectAll(PageParam pageParam) {
        return honorService.selectAll(pageParam);
    }


    @ApiOperation(value = "前端展示查询不分页", notes = "前端展示查询不分页")
    @GetMapping("/findAll")
    public List<Honor> findAll() {
        return honorService.findAll();
    }


    @ApiOperation(value = "通过id查询")
    @PostMapping("/findById")
    public Honor findById(Integer id){
        return  honorService.findById(id);
    }
}
