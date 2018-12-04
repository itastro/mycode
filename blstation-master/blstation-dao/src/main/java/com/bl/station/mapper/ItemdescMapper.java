package com.bl.station.mapper;

import com.bl.station.entity.Itemdesc;
import com.bl.station.entity.ItemdescExample;
import com.bl.station.entity.ItemdescWithBLOBs;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ItemdescMapper {
    int countByExample(ItemdescExample example);

    int deleteByExample(ItemdescExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ItemdescWithBLOBs record);

    int insertSelective(ItemdescWithBLOBs record);


    List<ItemdescWithBLOBs> selectByExampleWithBLOBs(ItemdescExample example);

    List<Itemdesc> selectByExample(ItemdescExample example);

    ItemdescWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ItemdescWithBLOBs record, @Param("example") ItemdescExample example);

    int updateByExampleWithBLOBs(@Param("record") ItemdescWithBLOBs record, @Param("example") ItemdescExample example);

    int updateByExample(@Param("record") Itemdesc record, @Param("example") ItemdescExample example);

    int updateByPrimaryKeySelective(ItemdescWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ItemdescWithBLOBs record);

    int updateByPrimaryKey(Itemdesc record);

    ItemdescWithBLOBs  selectByItemId(Integer id);
}