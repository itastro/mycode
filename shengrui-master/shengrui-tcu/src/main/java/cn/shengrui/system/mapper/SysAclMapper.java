package cn.shengrui.system.mapper;

import cn.shengrui.param.AclSearch;
import cn.shengrui.system.entity.SysAcl;
import cn.shengrui.system.entity.SysAclExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SysAclMapper {
    int countByExample(SysAclExample example);

    int deleteByExample(SysAclExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysAcl record);

    int insertSelective(SysAcl record);

    List<SysAcl> selectByExample(SysAclExample example);

    SysAcl selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysAcl record, @Param("example") SysAclExample example);

    int updateByExample(@Param("record") SysAcl record, @Param("example") SysAclExample example);

    int updateByPrimaryKeySelective(SysAcl record);

    int updateByPrimaryKey(SysAcl record);

    List<SysAcl> pageQuery(@Param("search") AclSearch aclSearch);

    List<SysAcl> findAll();

    List<Integer> findAllId();

    int countByAclIdAndKeywordAndName(@Param("aclId") Integer aclId, @Param("keyword") String keyWord, @Param("name") String name);

    void updateDelete(@Param("id") Integer id);
}