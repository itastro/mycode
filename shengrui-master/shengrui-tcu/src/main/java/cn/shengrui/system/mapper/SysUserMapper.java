package cn.shengrui.system.mapper;

import cn.shengrui.param.UserSearch;
import cn.shengrui.system.entity.SysUser;
import cn.shengrui.system.entity.SysUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wangchunsen
 */
public interface SysUserMapper {

  int countByExample(SysUserExample example);

  int deleteByExample(SysUserExample example);

  int deleteByPrimaryKey(Integer id);

  int insert(SysUser record);

  int insertSelective(SysUser record);

  List<SysUser> selectByExample(SysUserExample example);

  SysUser selectByPrimaryKey(Integer id);

  int updateByExampleSelective(@Param("record") SysUser record,
      @Param("example") SysUserExample example);

  int updateByExample(@Param("record") SysUser record, @Param("example") SysUserExample example);

  int updateByPrimaryKeySelective(SysUser record);

  int updateByPrimaryKey(SysUser record);

  SysUser selectByUsername(@Param("username") String username);

  List<SysUser> pageQuery(@Param("search") UserSearch userSearch);
}