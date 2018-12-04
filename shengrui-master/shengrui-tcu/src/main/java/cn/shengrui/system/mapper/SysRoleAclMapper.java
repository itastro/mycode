package cn.shengrui.system.mapper;

import cn.shengrui.system.entity.SysRoleAcl;
import cn.shengrui.system.entity.SysRoleAclExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysRoleAclMapper {
    int countByExample(SysRoleAclExample example);

    int deleteByExample(SysRoleAclExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysRoleAcl record);

    int insertSelective(SysRoleAcl record);

    List<SysRoleAcl> selectByExample(SysRoleAclExample example);

    SysRoleAcl selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysRoleAcl record, @Param("example") SysRoleAclExample example);

    int updateByExample(@Param("record") SysRoleAcl record, @Param("example") SysRoleAclExample example);

    int updateByPrimaryKeySelective(SysRoleAcl record);

    int updateByPrimaryKey(SysRoleAcl record);

    int countByroleIddAndaclId(@Param("roleId") Integer roleId, @Param("aclId") Integer aclId);

    List<Integer> findByRoleId(@Param("roleId") Integer roleId);

    void deleteByRoleId(@Param("roleId") Integer roleId);

}