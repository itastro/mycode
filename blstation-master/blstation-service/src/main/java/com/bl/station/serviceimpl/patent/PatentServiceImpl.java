package com.bl.station.serviceimpl.patent;

import com.bl.station.entity.Patent;
import com.bl.station.page.PageInfo;
import com.bl.station.page.PageParam;
import com.bl.station.param.PatentParam;
import com.bl.station.param.PatentSearch;
import com.bl.station.service.patent.PatentService;
import com.bl.station.utils.StationResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName PatentServiceImpl
 * @Description TODO
 * @Date 2018/9/2 21:47
 * @Author itastro
 * @Version 1.0
 **/
@Service
@Transactional
public class PatentServiceImpl implements PatentService {

    @Override
    public StationResult save(PatentParam patentParam) {
        return null;
    }

    @Override
    public StationResult delete(String ids) {
        return null;
    }

    @Override
    public StationResult update(PatentParam patentParam) {
        return null;
    }

    @Override
    public PageInfo<Patent> pageQuery(PageParam pageParam, PatentSearch patentSearch) {
        return null;
    }

    @Override
    public PageInfo<Patent> findAll(PageParam pageParam) {
        return null;
    }

    @Override
    public Patent findOne(Integer id) {
        return null;
    }
}
