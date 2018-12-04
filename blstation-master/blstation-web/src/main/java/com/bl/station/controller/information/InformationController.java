package com.bl.station.controller.information;

import com.bl.station.entity.Information;
import com.bl.station.page.PageInfo;
import com.bl.station.page.PageParam;
import com.bl.station.param.InformationParam;
import com.bl.station.service.information.InformationService;
import com.bl.station.utils.StationResult;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author itastro
 */

@Api(value = "公司信息相关API",description = "公司信息")
@RestController
@RequestMapping("/information")


public class InformationController {

    @Autowired
    private InformationService informationService;

    @ApiOperation(value = "添加公司信息", notes = "添加公司信息")
    @PostMapping("/add")
    public StationResult add(InformationParam information) {

        return informationService.add(information);
    }

    @ApiOperation(value = "删除公司信息", notes = "删除公司信息")
    @PostMapping("/delete/{id}")
    public StationResult add(@PathVariable(name = "id") @ApiParam(required = true, name = "id", value = "id") Integer id) {
        return informationService.delete(id);
    }

    @ApiOperation(value = "更新公司信息", notes = "同信息添加，必须传这条数据的id")
    @PostMapping("/update")
    public StationResult update(InformationParam information) {
        return informationService.update(information);
    }

    @ApiOperation(value = "查询公司信息", notes = "查询公司信息")
    @GetMapping("/findAll")
    public PageInfo<Information> findAll(PageParam pageParam) {
        return informationService.findAll(pageParam);
    }

    @ApiOperation(value = "公司信息数据回显", notes = "公司信息数据回显")
    @PostMapping("/findById")
    public Information findOne(Integer id) {
        return informationService.findOne(id);
    }

}
