package com.bl.station.service.Job;


import com.bl.station.entity.Job;
import com.bl.station.page.PageInfo;
import com.bl.station.page.PageParam;
import com.bl.station.param.JobParam;
import com.bl.station.param.JobSearch;
import com.bl.station.utils.StationResult;

/**
 * @author itastro
 */
public interface JobService {
    /**
     * 招聘信息保存
     * @param jobParam
     * @return
     */
    StationResult save(JobParam jobParam);

    /**
     * 招聘信息删除
     * @param ids
     * @return
     */
    StationResult delte(String ids);

    /**
     * 招聘信息更新
     * @param jobParam
     * @return
     */
    StationResult update(JobParam jobParam);

    /**
     * 招聘信息查询
     * @param pageParam
     * @param jobSearch
     * @return
     */
    PageInfo<Job> pageQuery(PageParam pageParam, JobSearch jobSearch);

    /**
     * 招聘信息查询前端
     * @param pageParam
     * @return
     */
    PageInfo<Job> findAll(PageParam pageParam);

    /**
     * 招聘信息详情查询
     * @param id
     * @return
     */
    Job findOne(Integer id);
}
