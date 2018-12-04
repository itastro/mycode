package com.bl.station.service.patent;

import com.bl.station.entity.Patent;
import com.bl.station.page.PageInfo;
import com.bl.station.page.PageParam;
import com.bl.station.param.PatentParam;
import com.bl.station.param.PatentSearch;
import com.bl.station.utils.StationResult;

public interface PatentService {


    StationResult save(PatentParam patentParam);

    StationResult delete(String ids);

    StationResult update(PatentParam patentParam);

    PageInfo<Patent> pageQuery(PageParam pageParam , PatentSearch patentSearch);

    PageInfo<Patent> findAll(PageParam pageParam);

    Patent findOne(Integer id);


}
