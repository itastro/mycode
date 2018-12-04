package com.bl.station.serviceimpl.job;

import com.bl.station.Bean.BeanValidator;
import com.bl.station.entity.Job;
import com.bl.station.exception.ParamException;
import com.bl.station.mapper.JobMapper;
import com.bl.station.page.PageInfo;
import com.bl.station.page.PageParam;
import com.bl.station.param.JobParam;
import com.bl.station.param.JobSearch;
import com.bl.station.service.Job.JobService;
import com.bl.station.utils.JsonMapper;
import com.bl.station.utils.StationResult;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @ClassName JobServiceImpl
 * @Description TODO
 * @Date 2018/8/16 13:19
 * @Author itastro
 * @Version 1.0
 **/

@Slf4j
@Component
public class JobServiceImpl implements JobService {


    @Autowired
    private JobMapper jobMapper;

    @Override
    public StationResult save(JobParam jobParam) {

        log.info("job:{}", JsonMapper.obj2String(jobParam));
        BeanValidator.check(jobParam);

        Job job = JobParamCopyJob(jobParam);
        job.setCreatetime(new Date());
        job.setStatus("招聘中");
        jobMapper.insert(job);
        return StationResult.success("招聘信息添加成功");
    }

    private Job JobParamCopyJob(JobParam jobParam) {
        Job job = new Job();
        BeanUtils.copyProperties(jobParam, job);
        return job;
    }

    @Override
    public StationResult delte(String ids) {

        if (StringUtils.isBlank(ids)) {
            return StationResult.fail("请选择要删的招聘信息");
        }

        String[] splits = ids.split(",");

        for (String id : splits) {
            jobMapper.deleteByPrimaryKey(Integer.parseInt(id));

        }
        return StationResult.success("删除招聘信息成功");
    }

    @Override
    public StationResult update(JobParam jobParam) {
        if (jobParam.getId() == null) {
            return StationResult.fail("请传入需要修改记录的id");
        }
        Job job = JobParamCopyJob(jobParam);
        job.setCreatetime(new Date());
        jobMapper.updateByPrimaryKeyWithBLOBs(job);
        return StationResult.success("招聘信息修改成功");
    }

    @Override
    public PageInfo<Job> pageQuery(PageParam pageParam, JobSearch jobSearch) {

        PageHelper.startPage(pageParam.getPage(), pageParam.getSize());
        List<Job> jobs = jobMapper.pageQuery(jobSearch);
        PageInfo<Job> result = new PageInfo<Job>(jobs);
        return result;
    }

    @Override
    public PageInfo<Job> findAll(PageParam pageParam) {
        PageHelper.startPage(pageParam.getPage(), pageParam.getSize());
        List<Job> jobs = jobMapper.findAll();
        PageInfo<Job> result = new PageInfo<Job>(jobs);
        return result;
    }


    @Override
    public Job findOne(Integer id) {

        if (id == null) {
            throw new ParamException("请你选择一条信息");
        }

        Job job = jobMapper.selectByPrimaryKey(id);
        return job;
    }
}
