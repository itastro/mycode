package cn.shengrui.management.mapper;

import cn.shengrui.management.entity.TTask;
import cn.shengrui.management.entity.TTaskExample;

import java.util.List;

import cn.shengrui.param.TaskInfo;
import cn.shengrui.param.TaskSearch;
import org.apache.ibatis.annotations.Param;

public interface TTaskMapper {
    int countByExample(TTaskExample example);

    int deleteByExample(TTaskExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TTask record);

    int insertSelective(TTask record);

    List<TTask> selectByExample(TTaskExample example);

    TTask selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TTask record, @Param("example") TTaskExample example);

    int updateByExample(@Param("record") TTask record, @Param("example") TTaskExample example);

    int updateByPrimaryKeySelective(TTask record);

    int updateByPrimaryKey(TTask record);

    List<TaskInfo> pageQuery(@Param("search") TaskSearch taskSearch);

    TaskInfo getCurrentTask();

    List<Integer> selectCurrentDayTask();

    int updateStatusIng(Integer taskId);

    int updateAllStatusIngToWait();

    Integer getCurrentTaskOne();
}