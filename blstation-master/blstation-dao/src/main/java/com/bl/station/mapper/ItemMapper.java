package com.bl.station.mapper;

import com.bl.station.dto.ItemReturn;
import com.bl.station.entity.Item;
import com.bl.station.entity.ItemExample;
import com.bl.station.param.ItemSearch;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ItemMapper {
    int countByExample(ItemExample example);

    int deleteByExample(ItemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Item record);

    int insertSelective(Item record);

    List<Item> selectByExample(ItemExample example);

    Item selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Item record, @Param("example") ItemExample example);

    int updateByExample(@Param("record") Item record, @Param("example") ItemExample example);

    int updateByPrimaryKeySelective(Item record);

    int updateByPrimaryKey(Item record);

    List<ItemReturn> pageQuery(@Param("search") ItemSearch itemSearch);


    List<Item> findAll();

    List<Item> findByItemCatId(Integer id);

    List<Item> likeName(@Param("name") String name);


}