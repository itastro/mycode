package com.bl.station.mapper;

import com.bl.station.entity.Patent;
import com.bl.station.entity.PatentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PatentMapper {
    int countByExample(PatentExample example);

    int deleteByExample(PatentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Patent record);

    int insertSelective(Patent record);

    List<Patent> selectByExampleWithBLOBs(PatentExample example);

    List<Patent> selectByExample(PatentExample example);

    Patent selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Patent record, @Param("example") PatentExample example);

    int updateByExampleWithBLOBs(@Param("record") Patent record, @Param("example") PatentExample example);

    int updateByExample(@Param("record") Patent record, @Param("example") PatentExample example);

    int updateByPrimaryKeySelective(Patent record);

    int updateByPrimaryKeyWithBLOBs(Patent record);

    int updateByPrimaryKey(Patent record);
}