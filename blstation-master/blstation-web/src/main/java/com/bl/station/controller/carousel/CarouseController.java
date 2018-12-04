package com.bl.station.controller.carousel;

import com.bl.station.entity.Carousel;
import com.bl.station.page.PageInfo;
import com.bl.station.page.PageParam;
import com.bl.station.param.CarouselParam;
import com.bl.station.param.CarouselSearch;
import com.bl.station.service.carousel.CarouselService;
import com.bl.station.utils.StationResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName CarouseController
 * @Description TODO
 * @Date 2018/9/6 20:38
 * @Author itastro
 * @Version 1.0
 **/
@Api(description = "轮播图")
@RestController
@RequestMapping("/carouse")
public class CarouseController {

    @Autowired
    private CarouselService carouselService;


    @ApiOperation(value = "添加轮播图",notes = "添加轮播图")
    @PostMapping("/add")

    public StationResult save (CarouselParam carouselParam) throws  Exception{
        return  carouselService.save(carouselParam);
    }


    @ApiOperation(value = "更新",notes = "更新轮播图")
    @PostMapping("/update")
    StationResult update(CarouselParam carouselParam) throws Exception{
        return  carouselService.update(carouselParam);
    }

    @ApiOperation(value = "删除",notes = "删除轮播图")
    @PostMapping("/delete")
    StationResult delete(String ids){
        return  carouselService.delete(ids);
    }

    @ApiOperation(value = "后端查询",notes = "后端查询")
    @PostMapping("/pageQuery")
    PageInfo<Carousel> pageQuery(PageParam pageParam, CarouselSearch carouselSearch){
        return  carouselService.pageQuery(pageParam,carouselSearch);
    }


    @ApiOperation(value = "前端查询",notes = "前端查询")
    @GetMapping("/findAll")
    List<Carousel> findAll(){
        return  carouselService.findAll();
    }
}
