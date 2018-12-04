package com.bl.station.controller.banner;

import com.bl.station.entity.Banner;
import com.bl.station.exception.PermissionException;
import com.bl.station.page.PageInfo;
import com.bl.station.page.PageParam;
import com.bl.station.param.BannerParam;
import com.bl.station.param.BannerSearch;
import com.bl.station.service.banner.BannerService;
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
 * @ClassName BannerController
 * @Description TODO
 * @Date 2018/9/6 20:39
 * @Author itastro
 * @Version 1.0
 **/
@Slf4j
@Api(description = "banner")
@RestController
@RequestMapping("/banner")
public class BnanerController {


    @Autowired
    private BannerService bannerService;


    @PostMapping("/add")
    @ApiOperation(value = "添加banner", notes = "添加banner")
    public StationResult save(BannerParam bannerParam) throws Exception{
        try {
            return bannerService.save(bannerParam);

        } catch (PermissionException e) {

            log.info("添加失败", e);
            throw new PermissionException("添加失败");
        }
    }

    @PostMapping("/update")
    @ApiOperation(value = "更新banner", notes = "更新banner")
    public StationResult update(BannerParam bannerParam) throws Exception{
        try {
            return bannerService.update(bannerParam);

        } catch (PermissionException e) {

            log.info("更新失败", e);
            throw new PermissionException("更新失败");
        }
    }


    @PostMapping("/delete")
    @ApiOperation(value = "删除banner", notes = "删除banner")
    public StationResult delete(String ids) {
        try {
            return bannerService.delete(ids);

        } catch (PermissionException e) {

            log.info("删除失败", e);
            throw new PermissionException("删除失败");
        }
    }

    @PostMapping("/pageQuery")
    @ApiOperation(value = "后台banner查询", notes = "后台banner查询")
    public PageInfo<Banner> pageQuery(PageParam pageParam, BannerSearch bannerSearch) {
        try {
            return bannerService.pageQuery(pageParam, bannerSearch);
        } catch (PermissionException e) {
            log.info("查询失败", e);
            throw new PermissionException("查询失败");
        }
    }

    @GetMapping("/findAll")
    @ApiOperation(value = "查询所有Banner前端", notes = "查询所欲banner前端")
    public List<Banner> findAll() {
        try {
            return bannerService.findAll();
        } catch (PermissionException e) {
            log.info("查询失败", e);
            throw new PermissionException("查询失败");
        }
    }
}
