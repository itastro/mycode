package cn.shengrui.management.mapper;

import cn.shengrui.common.beans.JsonResult;
import cn.shengrui.management.entity.TFile;
import cn.shengrui.management.entity.TFileExample;

import java.util.List;

import cn.shengrui.management.entity.TTcu;
import cn.shengrui.management.entity.TTcuFile;
import cn.shengrui.param.FileSearch;
import cn.shengrui.param.SelectFileType;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

public interface TFileMapper {
    int countByExample(TFileExample example);

    int deleteByExample(TFileExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TFile record);

    int insertSelective(TFile record);

    List<TFile> selectByExample(TFileExample example);

    TFile selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TFile record, @Param("example") TFileExample example);

    int updateByExample(@Param("record") TFile record, @Param("example") TFileExample example);

    int updateByPrimaryKeySelective(TFile record);

    int updateByPrimaryKey(TFile record);

    List<TFile> pageQuery(@Param("search") FileSearch fileSearch);

    List<TFile> findFileByType(Integer type);

    List<TFile> findByShengruiScript();

    List<TFile> providerByShengruiScript();
}