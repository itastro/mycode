package com.bl.station.controller.News;

import com.bl.station.Bean.BeanValidator;
import com.bl.station.entity.News;
import com.bl.station.page.PageInfo;
import com.bl.station.page.PageParam;
import com.bl.station.param.NewsParam;
import com.bl.station.param.NewsSearch;
import com.bl.station.service.News.NewService;
import com.bl.station.utils.JsonMapper;
import com.bl.station.utils.StationResult;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author itastro
 */


@Api(description = "新闻相关接口")
@RestController
@RequestMapping("/news")
@Slf4j
public class NewsController {


    @Autowired
    private NewService newService;

    @ApiOperation(value = "添加新闻", notes = "添加新闻")

    @PostMapping("/add")
    public StationResult save(NewsParam news) throws  Exception{

        BeanValidator.check(news);

        log.info("news:{}", JsonMapper.obj2String(news));

        return newService.add(news);


    }

    @ApiOperation(value = "后盾查询", notes = "后端查询")

    @GetMapping("/pageQuery")
    public PageInfo<News> pageQury(PageParam pageParam, NewsSearch newsSearch) {
        return newService.pageQuery(pageParam, newsSearch);
    }

    @ApiOperation(value = "删除新闻", notes = "删除新闻")
    @PostMapping("/delete")
    @ApiImplicitParam(name = "ids", value = "新闻id字符串", dataType = "String", paramType = "query")
    public StationResult delete(String ids) {
        log.info("ids:{}", ids);
        return newService.delete(ids);
    }

    @ApiOperation(value = "更新新闻", notes = "更新新闻")

    @PostMapping("/update")
    public StationResult update(NewsParam newsParam) throws Exception{

        return newService.update(newsParam);
    }

    @ApiOperation(value = "前端列表查询", notes = "前端查询")

    @PostMapping("/findAll")
    public PageInfo<News> findAll(PageParam pageParam) {
        return newService.findAll(pageParam);

    }

    @ApiOperation(value = "单条详细信息查询", notes = "单条详细信息查询")
    @PostMapping("findById")
    public News findOne(Integer id) {
        return newService.findOne(id);
    }

}
