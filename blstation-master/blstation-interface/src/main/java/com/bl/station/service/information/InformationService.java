package com.bl.station.service.information;

import com.bl.station.entity.Information;
import com.bl.station.page.PageInfo;
import com.bl.station.page.PageParam;
import com.bl.station.param.InformationParam;
import com.bl.station.utils.StationResult;

public interface InformationService {

    StationResult add (InformationParam Information);

    StationResult delete(Integer id);

    StationResult update(InformationParam information);

    PageInfo<Information> pageQuery();

    Information findById(Integer id);

    PageInfo<Information> findAll(PageParam pageParam);

    Information findOne(Integer id);



}
