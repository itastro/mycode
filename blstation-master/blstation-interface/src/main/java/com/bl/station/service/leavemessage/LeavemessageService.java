package com.bl.station.service.leavemessage;

import com.bl.station.page.PageInfo;
import com.bl.station.entity.Leavemessage;
import com.bl.station.page.PageParam;
import com.bl.station.utils.StationResult;

public interface LeavemessageService {


    StationResult delete(String ids);

    StationResult add(Leavemessage leavemessage);

    PageInfo<Leavemessage> pageQuery(PageParam pageParam);

    Leavemessage findById(Integer id);


}
