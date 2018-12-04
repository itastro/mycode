package cn.shengrui.management.service;

import cn.shengrui.common.beans.JsonResult;
import cn.shengrui.common.beans.PageQuery;
import cn.shengrui.param.CompanyParam;
import cn.shengrui.param.CompanySearch;

import java.util.List;

public interface CompanyService {

    /**
     * 保存车企
     */
    JsonResult save(CompanyParam companyParam);

    /**
     * 删除车企
     */
    JsonResult delete(List<Integer> id);

    /**
     * 更新车企
     */
    JsonResult update(CompanyParam companyParam);

    /**
     * 查询
     */

    JsonResult pageQuery(PageQuery pageQuery, CompanySearch companySearch);

    /**
     * 查询所有
     *
     * @return
     */
    JsonResult findAll();


}
