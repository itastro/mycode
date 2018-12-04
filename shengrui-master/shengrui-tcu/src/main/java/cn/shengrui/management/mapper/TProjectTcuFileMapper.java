package cn.shengrui.management.mapper;

import cn.shengrui.management.entity.TProjectTcuFile;
import cn.shengrui.management.entity.TProjectTcuFileExample;

import java.util.List;

import cn.shengrui.param.ProjectDetails;
import org.apache.ibatis.annotations.Param;

public interface TProjectTcuFileMapper {
    int countByExample(TProjectTcuFileExample example);

    int deleteByExample(TProjectTcuFileExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TProjectTcuFile record);

    int insertSelective(TProjectTcuFile record);

    List<TProjectTcuFile> selectByExample(TProjectTcuFileExample example);

    TProjectTcuFile selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TProjectTcuFile record, @Param("example") TProjectTcuFileExample example);

    int updateByExample(@Param("record") TProjectTcuFile record, @Param("example") TProjectTcuFileExample example);

    int updateByPrimaryKeySelective(TProjectTcuFile record);

    int updateByPrimaryKey(TProjectTcuFile record);

    List<ProjectDetails> getProjectDetails(Integer id);

    List<Integer> findByProjectId(@Param("pId") Integer pid);


    void  updateStatus(@Param("id") Integer id);
}