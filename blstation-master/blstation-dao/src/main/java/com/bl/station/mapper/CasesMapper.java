package com.bl.station.mapper;

import com.bl.station.entity.Cases;
import com.bl.station.entity.CasesExample;
import com.bl.station.param.CaseSearch;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CasesMapper {
    int countByExample(CasesExample example);

    int deleteByExample(CasesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Cases record);

    int insertSelective(Cases record);

    List<Cases> selectByExampleWithBLOBs(CasesExample example);

    List<Cases> selectByExample(CasesExample example);

    Cases selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Cases record, @Param("example") CasesExample example);

    int updateByExampleWithBLOBs(@Param("record") Cases record, @Param("example") CasesExample example);

    int updateByExample(@Param("record") Cases record, @Param("example") CasesExample example);

    int updateByPrimaryKeySelective(Cases record);

    int updateByPrimaryKeyWithBLOBs(Cases record);

    int updateByPrimaryKey(Cases record);

    Page<Cases> pageQuery(@Param("search") CaseSearch caseSearch);

    Page<Cases> findAll();

    List<Cases> likeName(@Param("name") String name);

}