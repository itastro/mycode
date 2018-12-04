package cn.shengrui.management.mapper;

import cn.shengrui.management.entity.TTcu;
import cn.shengrui.management.entity.TTcuExample;

import java.util.List;

import cn.shengrui.param.TcuInfo;
import cn.shengrui.param.TcuSearch;
import org.apache.ibatis.annotations.Param;

public interface TTcuMapper {
    int countByExample(TTcuExample example);

    int deleteByExample(TTcuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TTcu record);

    int insertSelective(TTcu record);

    List<TTcu> selectByExample(TTcuExample example);

    TTcu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TTcu record, @Param("example") TTcuExample example);

    int updateByExample(@Param("record") TTcu record, @Param("example") TTcuExample example);

    int updateByPrimaryKeySelective(TTcu record);

    int updateByPrimaryKey(TTcu record);

    List<TcuInfo> pageQuery(@Param("search") TcuSearch tcuSearch);

    /*List<TTcu> pageQuery(@Param("page") PageQuery pageQuery);*/

    List<TTcu> findAll();

    int  countNum();
}