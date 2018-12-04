package com.bl.station.controller.job;

import com.bl.station.entity.Job;
import com.bl.station.page.PageInfo;
import com.bl.station.page.PageParam;
import com.bl.station.param.JobParam;
import com.bl.station.param.JobSearch;
import com.bl.station.service.Job.JobService;
import com.bl.station.utils.StationResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName JobController
 * @Description TODO
 * @Date 2018/8/16 13:17
 * @Author itastro
 * @Version 1.0
 **/
@Api(description = "招聘信息api")
@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    private JobService jobService;


    @PostMapping("/add")
    @ApiOperation(value = "添加招聘信息", notes = "添加招聘信息,其中岗位信息描述,请遵守html页面显示规则")

    public StationResult save(@RequestBody JobParam jobParam) {
        return jobService.save(jobParam);
    }


    @PostMapping("/update")
    @ApiOperation(value = "修改招聘信息", notes = "修改招聘信息,其中岗位信息描述,请遵守html页面显示规则")
    public StationResult update(@RequestBody JobParam jobParam) {
        return jobService.update(jobParam);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "删除招聘信息", notes = "删除招聘信息")
    @ApiImplicitParam(name = "ids",value = "id字符串",dataType = "String",paramType = "query")
    public StationResult delete(String ids) {
        return jobService.delte(ids);
    }

    @ApiOperation(value = "查看单条招聘信息", notes = "删除招聘信息")
    @PostMapping("/findById")
    public Job findOne(Integer id) {
        return jobService.findOne(id);
    }


    @GetMapping("/pageQuery")
    @ApiOperation(value = "后端查询", notes = "后端查询")
    public PageInfo<Job> pagaeQuery(PageParam pageParam, JobSearch jobSearch) {
        return jobService.pageQuery(pageParam, jobSearch);

    }

    @GetMapping("/findAll")
    @ApiOperation(value = "招聘信息前端展示", notes = "招聘信息前端展示")
    public PageInfo<Job> findAll(PageParam pageParam) {
        return jobService.findAll(pageParam);

    }

}
