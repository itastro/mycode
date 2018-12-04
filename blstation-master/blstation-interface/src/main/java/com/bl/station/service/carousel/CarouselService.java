package com.bl.station.service.carousel;

import com.bl.station.entity.Carousel;
import com.bl.station.page.PageInfo;
import com.bl.station.page.PageParam;
import com.bl.station.param.CarouselParam;
import com.bl.station.param.CarouselSearch;
import com.bl.station.utils.StationResult;

import java.util.List;

public interface CarouselService {


    StationResult save(CarouselParam carouselParam) throws  Exception ;

    StationResult update(CarouselParam carouselParam)throws  Exception;

    StationResult delete(String ids);

    PageInfo<Carousel> pageQuery(PageParam  pageParam,CarouselSearch carouselSearch);

    List<Carousel> findAll();
}
