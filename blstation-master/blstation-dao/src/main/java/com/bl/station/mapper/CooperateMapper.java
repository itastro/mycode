package com.bl.station.mapper;

import com.bl.station.entity.Cooperate;
import com.bl.station.entity.CooperateExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CooperateMapper {
    int countByExample(CooperateExample example);

    int deleteByExample(CooperateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Cooperate record);

    int insertSelective(Cooperate record);

    List<Cooperate> selectByExample(CooperateExample example);

    Cooperate selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Cooperate record, @Param("example") CooperateExample example);

    int updateByExample(@Param("record") Cooperate record, @Param("example") CooperateExample example);

    int updateByPrimaryKeySelective(Cooperate record);

    int updateByPrimaryKey(Cooperate record);
}