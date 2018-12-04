package cn.shengrui.system.mapper;

import cn.shengrui.system.entity.SysMenu;
import cn.shengrui.system.entity.SysMenuExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysMenuMapper {
    int countByExample(SysMenuExample example);

    int deleteByExample(SysMenuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    List<SysMenu> selectByExample(SysMenuExample example);

    SysMenu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysMenu record, @Param("example") SysMenuExample example);

    int updateByExample(@Param("record") SysMenu record, @Param("example") SysMenuExample example);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);

    List<SysMenu> getAllMenu();

    int countByNameAndParentId(Integer parentId, String name, Integer id);

    List<SysMenu> getChildMenuListByLevel(@Param("level") String level);


    void batchUpdateLevel(@Param("menuList") List<SysMenu> menuList);


    int countByParentId(@Param("parentId") Integer parentId);

}