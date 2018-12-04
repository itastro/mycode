package cn.shengrui.management.mapper;

import cn.shengrui.management.entity.TProductionLog;
import cn.shengrui.management.entity.TProductionLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TProductionLogMapper {
    int countByExample(TProductionLogExample example);

    int deleteByExample(TProductionLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TProductionLog record);

    int insertSelective(TProductionLog record);

    List<TProductionLog> selectByExample(TProductionLogExample example);

    TProductionLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TProductionLog record, @Param("example") TProductionLogExample example);

    int updateByExample(@Param("record") TProductionLog record, @Param("example") TProductionLogExample example);

    int updateByPrimaryKeySelective(TProductionLog record);

    int updateByPrimaryKey(TProductionLog record);
}