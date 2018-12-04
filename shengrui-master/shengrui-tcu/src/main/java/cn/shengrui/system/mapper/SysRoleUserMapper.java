package cn.shengrui.system.mapper;

import cn.shengrui.system.entity.SysRoleUser;
import cn.shengrui.system.entity.SysRoleUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysRoleUserMapper {
    int countByExample(SysRoleUserExample example);

    int deleteByExample(SysRoleUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysRoleUser record);

    int insertSelective(SysRoleUser record);

    List<SysRoleUser> selectByExample(SysRoleUserExample example);

    SysRoleUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysRoleUser record, @Param("example") SysRoleUserExample example);

    int updateByExample(@Param("record") SysRoleUser record, @Param("example") SysRoleUserExample example);

    int updateByPrimaryKeySelective(SysRoleUser record);

    int updateByPrimaryKey(SysRoleUser record);

    int countByUserIdAndRoleId(@Param("userId") Integer userId, @Param("roleId") Integer roleId);

    List<Integer> findByUserId(@Param("userId") Integer userId);

    void deleteByUserId(@Param("userId") Integer userId);
}