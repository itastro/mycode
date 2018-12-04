package cn.shengrui.management.service;

import cn.shengrui.common.beans.JsonResult;
import cn.shengrui.common.beans.PageQuery;
import cn.shengrui.param.TcuParam;
import cn.shengrui.param.TcuSearch;

import java.util.List;

/**
 * tcu相关接口
 *
 * @author itastro
 * @date 2016/10/31
 */
public interface TcuService {


    /**
     * 保存TCU
     *
     * @param tcuParam
     * @return
     */
    JsonResult save(TcuParam tcuParam);

    /**
     * 更新TCU
     *
     * @param tcuParam
     * @return
     */
    JsonResult update(TcuParam tcuParam);

    /**
     * 删除TCU
     *
     * @param id
     * @return
     */
    JsonResult delete(List<Integer> id);

    /**
     * 查询TCU
     *
     * @param pageQuery
     * @param tcuSearch
     * @return
     */
    JsonResult pageQuery(PageQuery pageQuery, TcuSearch tcuSearch);

    /**
     * 校验TCU是否存在
     *
     * @param name
     * @param id
     * @return
     */
    boolean checkExist(String name, Integer id);


    JsonResult findAll();


}
