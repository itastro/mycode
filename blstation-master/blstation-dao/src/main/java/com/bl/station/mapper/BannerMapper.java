package com.bl.station.mapper;

import com.bl.station.entity.Banner;
import com.bl.station.entity.BannerExample;
import com.bl.station.param.BannerSearch;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BannerMapper {
    int countByExample(BannerExample example);

    int deleteByExample(BannerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Banner record);

    int insertSelective(Banner record);

    List<Banner> selectByExampleWithBLOBs(BannerExample example);

    List<Banner> selectByExample(BannerExample example);

    Banner selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Banner record, @Param("example") BannerExample example);

    int updateByExampleWithBLOBs(@Param("record") Banner record, @Param("example") BannerExample example);

    int updateByExample(@Param("record") Banner record, @Param("example") BannerExample example);

    int updateByPrimaryKeySelective(Banner record);

    int updateByPrimaryKeyWithBLOBs(Banner record);

    int updateByPrimaryKey(Banner record);

    List<Banner> selectAll();

    Page<Banner>  pageQuery(@Param("search") BannerSearch bannerSearch);
}