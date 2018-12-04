package cn.shengrui.management.mapper;

import cn.shengrui.management.entity.TCompany;
import cn.shengrui.management.entity.TCompanyExample;
import cn.shengrui.param.CompanySearch;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TCompanyMapper {
    int countByExample(TCompanyExample example);

    int deleteByExample(TCompanyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TCompany record);

    int insertSelective(TCompany record);

    List<TCompany> selectByExample(TCompanyExample example);

    TCompany selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TCompany record, @Param("example") TCompanyExample example);

    int updateByExample(@Param("record") TCompany record, @Param("example") TCompanyExample example);

    int updateByPrimaryKeySelective(TCompany record);

    int updateByPrimaryKey(TCompany record);

    /**
     * 查询个数
     *
     * @param name
     * @param id
     * @return
     */
    int countByName(@Param("name") String name, @Param("id") Integer id);

    /**
     * 查询
     *
     * @param companySearch
     * @return
     */
    Page<TCompany> pageQuery(@Param("search") CompanySearch companySearch);

    /**
     * 查询所有
     *
     * @return
     */
    List<TCompany> findAll();
}