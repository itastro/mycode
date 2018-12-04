package com.bl.station.service.Honor;

import com.bl.station.entity.Honor;
import com.bl.station.page.PageInfo;
import com.bl.station.page.PageParam;
import com.bl.station.param.HonorParam;
import com.bl.station.param.HonorSearch;
import com.bl.station.utils.StationResult;

import java.util.List;

/**
 * @author itastro
 */
public interface HonorService {

    /**
     * 保存
     * @param honorParam
     * @return
     * @throws Exception
     */
    StationResult save(HonorParam honorParam) throws Exception;

    /**
     * 删除
     * @param ids
     * @return
     */
    StationResult delete(String ids);

    /**
     * 查询
     * @param pageParam
     * @param honorSearch
     * @return
     */
    PageInfo<Honor> pageQuery(PageParam pageParam, HonorSearch honorSearch);

    /**
     * 更新
     * @param honorParam
     * @return
     * @throws Exception
     */
    StationResult update(HonorParam honorParam) throws  Exception;

    /**
     * 查询所有
     * @param
     * @return
     */
    List<Honor> findAll();


    /**
     * 查询所有
     * @param pageParam
     * @return
     */
    PageInfo<Honor> selectAll(PageParam pageParam);

    /**
     * 通过id查询
     * @param id
     * @return
     */
    Honor findById(Integer id);

}
