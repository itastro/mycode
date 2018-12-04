package com.bl.station.service.successcase;

import com.bl.station.entity.Cases;
import com.bl.station.page.PageInfo;
import com.bl.station.page.PageParam;
import com.bl.station.param.CaseParam;
import com.bl.station.param.CaseSearch;
import com.bl.station.utils.StationResult;

import java.util.List;

/**
 * @author itastro
 */
public interface CaseService {



    /**
     * 添加成功案例
     */

     StationResult save(CaseParam  caseParam) throws  Exception;

    /**
     * 更新成功案例
     */

    StationResult update(CaseParam caseParam) throws Exception;


    /**
     * 删除成功案例
     */

    StationResult delete (String ids);


    /**
     * 查询成功案例
     */

    PageInfo<Cases> pageQuery(PageParam pageParam, CaseSearch caseSearch);

    /**
     * 前台展示成功案例
     */

    PageInfo<Cases> findAll(PageParam pageParam);


    /**
     * 前台展示不分页
     */

    List<Cases> selectAll();

    /**
     * 单个案例详情
     */

    Cases findById(Integer id);


    List<Cases>  search(String name);

}
