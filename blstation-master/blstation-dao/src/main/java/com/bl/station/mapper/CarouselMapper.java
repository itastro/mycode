package com.bl.station.mapper;

import com.bl.station.entity.Carousel;
import com.bl.station.entity.CarouselExample;
import com.bl.station.param.CarouselSearch;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author itastro
 */

public interface CarouselMapper {
    int countByExample(CarouselExample example);

    int deleteByExample(CarouselExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Carousel record);

    int insertSelective(Carousel record);

    List<Carousel> selectByExampleWithBLOBs(CarouselExample example);

    List<Carousel> selectByExample(CarouselExample example);

    Carousel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Carousel record, @Param("example") CarouselExample example);

    int updateByExampleWithBLOBs(@Param("record") Carousel record, @Param("example") CarouselExample example);

    int updateByExample(@Param("record") Carousel record, @Param("example") CarouselExample example);

    int updateByPrimaryKeySelective(Carousel record);

    int updateByPrimaryKeyWithBLOBs(Carousel record);

    int updateByPrimaryKey(Carousel record);

    Page<Carousel> pageQuery(@Param("search") CarouselSearch carouselSearch);

    List<Carousel> selectAll();
}