package cn.shengrui.management.mapper;

import cn.shengrui.management.entity.TOperationLog;
import cn.shengrui.management.entity.TOperationLogExample;

import java.util.List;

import cn.shengrui.param.OperationLogSearch;
import org.apache.ibatis.annotations.Param;

/**
 * @author itastro
 */
public interface TOperationLogMapper {
    int countByExample(TOperationLogExample example);

    int deleteByExample(TOperationLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TOperationLog record);

    int insertSelective(TOperationLog record);

    List<TOperationLog> selectByExample(TOperationLogExample example);

    TOperationLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TOperationLog record, @Param("example") TOperationLogExample example);

    int updateByExample(@Param("record") TOperationLog record, @Param("example") TOperationLogExample example);

    int updateByPrimaryKeySelective(TOperationLog record);

    int updateByPrimaryKey(TOperationLog record);

    List<TOperationLog> pageQuery(@Param("search") OperationLogSearch operationLogSearch);
}