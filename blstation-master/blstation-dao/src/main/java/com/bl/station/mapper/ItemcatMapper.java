package com.bl.station.mapper;

import com.bl.station.entity.Itemcat;
import com.bl.station.entity.ItemcatExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ItemcatMapper {
    int countByExample(ItemcatExample example);

    int deleteByExample(ItemcatExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Itemcat record);

    int insertSelective(Itemcat record);

    List<Itemcat> selectByExample(ItemcatExample example);

    Itemcat selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Itemcat record, @Param("example") ItemcatExample example);

    int updateByExample(@Param("record") Itemcat record, @Param("example") ItemcatExample example);

    int updateByPrimaryKeySelective(Itemcat record);

    int updateByPrimaryKey(Itemcat record);

    int countByNameAndParentId(@Param("parentId") Integer parentId,@Param("name") String itemCatName,@Param("id") Integer itemCatId);

    List<Itemcat> getAllItemCat();

    List<Itemcat> getChildItemCatListByLevel(@Param("level") String level);

    void  batchUpdateLevel(@Param("itemcatListList") List<Itemcat> itemcatListList);

    Itemcat findItemCatById(Integer id);
}