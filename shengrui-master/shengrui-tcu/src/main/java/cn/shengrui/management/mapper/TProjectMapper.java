package cn.shengrui.management.mapper;

import cn.shengrui.management.entity.TProject;
import cn.shengrui.management.entity.TProjectExample;

import java.util.List;

import cn.shengrui.param.ProjectSearch;
import org.apache.ibatis.annotations.Param;

public interface TProjectMapper {
    int countByExample(TProjectExample example);

    int deleteByExample(TProjectExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TProject record);

    int insertSelective(TProject record);

    List<TProject> selectByExample(TProjectExample example);

    TProject selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TProject record, @Param("example") TProjectExample example);

    int updateByExample(@Param("record") TProject record, @Param("example") TProjectExample example);

    int updateByPrimaryKeySelective(TProject record);

    int updateByPrimaryKey(TProject record);

    List<TProject> pageQuery(@Param("search") ProjectSearch projectSearch);

    int countNum(@Param("search") ProjectSearch projectSearch);

    List<TProject> findAll();

    void updateTcuId(@Param("pId") Integer pId);
}