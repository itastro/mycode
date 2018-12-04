package com.bl.station.service.banner;

import com.bl.station.entity.Banner;
import com.bl.station.page.PageInfo;
import com.bl.station.page.PageParam;
import com.bl.station.param.BannerParam;
import com.bl.station.param.BannerSearch;
import com.bl.station.utils.StationResult;

import java.util.List;

public interface BannerService {


    StationResult save(BannerParam bannerParam) throws  Exception;

    StationResult delete(String ids);

    StationResult update(BannerParam bannerParam) throws  Exception;

    PageInfo<Banner> pageQuery(PageParam pageParam,BannerSearch bannerSearch);

    List<Banner> findAll();
}
