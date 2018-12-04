package com.bl.station.controller.successcase;

import com.bl.station.entity.Cases;
import com.bl.station.page.PageInfo;
import com.bl.station.page.PageParam;
import com.bl.station.param.CaseParam;
import com.bl.station.param.CaseSearch;
import com.bl.station.service.successcase.CaseService;
import com.bl.station.utils.JsonMapper;
import com.bl.station.utils.StationResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName CaseController
 * @Description TODO
 * @Date 2018/9/2 21:41
 * @Author itastro
 * @Version 1.0
 **/
@Slf4j
@Api(description = "成功案例")
@RestController
@RequestMapping("/case")
public class CaseController {

    @Autowired
    private CaseService caseService;

    @ApiOperation(value = "添加成功案例", notes = "添加成功案例")
    @PostMapping("/add")
    StationResult add(CaseParam caseParam) throws Exception {
        return caseService.save(caseParam);
    }

    @ApiOperation(value = "成功案例的更新", notes = "成功案例的更新")
    @PostMapping("/update")
    StationResult update(CaseParam caseParam) throws Exception {
        return caseService.update(caseParam);
    }

    @ApiOperation(value = "成功案例的删除", notes = "成功案例的删除")
    @PostMapping("/delete")
    StationResult delete(String ids) {
        return caseService.delete(ids);
    }

    @ApiOperation(value = "成功案例后台查询", notes = "成功案例后台查询")
    @PostMapping("/pageQuery")
    PageInfo<Cases> pageQuery(PageParam pageParam, CaseSearch caseSearch) {
        return caseService.pageQuery(pageParam, caseSearch);
    }

    @ApiOperation(value = "成案例的前台展示", notes = "成案例的前台展示带分页")
    @GetMapping("/findAll")
    PageInfo<Cases> pageQuery(PageParam pageParam) {
        log.info("进入成功案例查询");
        PageInfo<Cases> casesPageInfo = caseService.findAll(pageParam);

        log.info("casesPageInfo:{}", JsonMapper.obj2String(casesPageInfo));
        return casesPageInfo;
    }

    @ApiOperation(value = "案例详情", notes = "案例详情")
    @PostMapping("/findById")
    public Cases findById(Integer id) {

        return caseService.findById(id);
    }


    @ApiOperation(value = "案例名称关键字查询", notes = "案例名称关键字查询")
    @PostMapping("/search")
    public List<Cases> search(String name) {

        return caseService.search(name);
    }
}
