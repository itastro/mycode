package com.bl.station.mapper;

import com.bl.station.entity.Honor;
import com.bl.station.entity.HonorExample;

import java.util.List;

import com.bl.station.param.HonorSearch;
import org.apache.ibatis.annotations.Param;

public interface HonorMapper {
    int countByExample(HonorExample example);

    int deleteByExample(HonorExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Honor record);

    int insertSelective(Honor record);

    List<Honor> selectByExampleWithBLOBs(HonorExample example);

    List<Honor> selectByExample(HonorExample example);

    Honor selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Honor record, @Param("example") HonorExample example);

    int updateByExampleWithBLOBs(@Param("record") Honor record, @Param("example") HonorExample example);

    int updateByExample(@Param("record") Honor record, @Param("example") HonorExample example);

    int updateByPrimaryKeySelective(Honor record);

    int updateByPrimaryKeyWithBLOBs(Honor record);

    int updateByPrimaryKey(Honor record);

    List<Honor> findAll();

    List<Honor> pageQuery(@Param("search") HonorSearch honorSearch);
}