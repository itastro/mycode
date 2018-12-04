package cn.shengrui.system.mapper;

import cn.shengrui.common.beans.PageQuery;
import cn.shengrui.param.RoleSearch;
import cn.shengrui.system.entity.SysRole;
import cn.shengrui.system.entity.SysRoleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysRoleMapper {
    int countByExample(SysRoleExample example);

    int deleteByExample(SysRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    List<SysRole> selectByExample(SysRoleExample example);

    SysRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysRole record, @Param("example") SysRoleExample example);

    int updateByExample(@Param("record") SysRole record, @Param("example") SysRoleExample example);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);

    List<SysRole> pageQuery(@Param("search") RoleSearch roleSearch);

    List<Integer> findAllId();

    List<SysRole> findAllRole();
}