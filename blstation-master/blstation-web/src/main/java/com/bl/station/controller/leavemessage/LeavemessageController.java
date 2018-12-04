package com.bl.station.controller.leavemessage;

import com.bl.station.Bean.BeanValidator;
import com.bl.station.entity.Leavemessage;
import com.bl.station.page.PageInfo;
import com.bl.station.page.PageParam;
import com.bl.station.service.leavemessage.LeavemessageService;
import com.bl.station.utils.JsonMapper;
import com.bl.station.utils.StationResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author itastro
 */
@Api(description = "留言相关api")
@Slf4j
@RestController
@RequestMapping("/leavemessage")
public class LeavemessageController {


    @Autowired
    private LeavemessageService leavemessageService;


    @ApiOperation(notes = "留言", value = "l留言")
    @PostMapping("/add")
    public StationResult add(@RequestBody Leavemessage leavemessage) {
        log.info("leavemessage:{}", JsonMapper.obj2String(leavemessage));
        BeanValidator.check(leavemessage);
        return leavemessageService.add(leavemessage);
    }

    @ApiOperation(notes = "留言删除", value = "删除留言")
    @PostMapping("/delete")
    @ApiImplicitParam(name = "ids",value = "id字符串",dataType = "String",paramType = "query")
    public StationResult delete(String ids) {
        log.info("ids:{}", ids);
        return leavemessageService.delete(ids);
    }

    @ApiOperation(notes = "留言查询", value = "留言查询")
    @PostMapping("/findAll")
    public PageInfo<Leavemessage> pageQuery(PageParam pageParam) {

        log.info("pageParam:{}", JsonMapper.obj2String(pageParam));
        return leavemessageService.pageQuery(pageParam);
    }

    @ApiOperation(notes = "查看单条留言的相信信息", value = "查看单条留言的相信信息")
    @PostMapping("/findById")

    public Leavemessage findById(Integer id) {

        return leavemessageService.findById(id);
    }

}
