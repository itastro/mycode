package com.bl.station.service.News;
import com.bl.station.entity.News;
import com.bl.station.page.PageInfo;
import com.bl.station.page.PageParam;
import com.bl.station.param.NewsParam;
import com.bl.station.param.NewsSearch;
import com.bl.station.utils.StationResult;

public interface NewService {

    StationResult add(NewsParam news) throws Exception;

    StationResult update(NewsParam newsParam) throws Exception;

    StationResult delete(String ids);

    PageInfo<News> pageQuery(PageParam pageParam, NewsSearch newsSearch);

    News findOne(Integer id);

    PageInfo<News> findAll(PageParam pageParam);


}
