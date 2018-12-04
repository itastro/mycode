package com.bl.station.mapper;

import com.bl.station.entity.Menu;
import com.bl.station.entity.MenuExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuMapper {
    int countByExample(MenuExample example);

    int deleteByExample(MenuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    List<Menu> selectByExample(MenuExample example);

    Menu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Menu record, @Param("example") MenuExample example);

    int updateByExample(@Param("record") Menu record, @Param("example") MenuExample example);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    List<Menu> getAllMenu();

    int countByNameAndParentId(@Param("parentId") Integer parentId,@Param("name") String menuName,@Param("id") Integer menuId);

    List<Menu> getChildMenuListByLevel(@Param("level") String level);

    void  batchUpdateLevel(@Param("menuList") List<Menu> menuList);
}