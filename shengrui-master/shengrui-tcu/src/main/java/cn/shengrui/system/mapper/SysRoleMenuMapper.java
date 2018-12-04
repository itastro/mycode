package cn.shengrui.system.mapper;
import cn.shengrui.system.entity.SysRoleMenu;
import cn.shengrui.system.entity.SysRoleMenuExample;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface SysRoleMenuMapper {
    int countByExample(SysRoleMenuExample example);

    int deleteByExample(SysRoleMenuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysRoleMenu record);

    int insertSelective(SysRoleMenu record);

    List<SysRoleMenu> selectByExample(SysRoleMenuExample example);

    SysRoleMenu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysRoleMenu record, @Param("example") SysRoleMenuExample example);

    int updateByExample(@Param("record") SysRoleMenu record, @Param("example") SysRoleMenuExample example);

    int updateByPrimaryKeySelective(SysRoleMenu record);

    int updateByPrimaryKey(SysRoleMenu record);

    void deleteByMenuId(@Param("id") Integer id);

    List<Integer> findMenuIdByRoleId(@Param("roleId") Integer roleId);

    void deleteByRoleId(@Param("roleId") Integer roleId);
}