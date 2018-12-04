package cn.shengrui.management.mapper;

import cn.shengrui.management.entity.TaskLog;
import cn.shengrui.management.entity.TaskLogExample;

import java.util.List;

import cn.shengrui.param.TaskEchartInfo;
import cn.shengrui.param.TaskEchartSearch;
import cn.shengrui.param.TaskLogSearch;
import org.apache.ibatis.annotations.Param;

public interface TaskLogMapper {
    int countByExample(TaskLogExample example);

    int deleteByExample(TaskLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TaskLog record);

    int insertSelective(TaskLog record);

    List<TaskLog> selectByExample(TaskLogExample example);

    TaskLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TaskLog record, @Param("example") TaskLogExample example);

    int updateByExample(@Param("record") TaskLog record, @Param("example") TaskLogExample example);

    int updateByPrimaryKeySelective(TaskLog record);

    int updateByPrimaryKey(TaskLog record);

    List<TaskLog> pageQuery(@Param("search") TaskLogSearch taskLogSearch);

    List<TaskLog> findAll();

    TaskEchartInfo flashStatistics(@Param("fsearch") TaskEchartSearch taskEchartSearch);
}