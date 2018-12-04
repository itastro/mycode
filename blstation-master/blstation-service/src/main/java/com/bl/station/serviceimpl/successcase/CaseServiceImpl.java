package com.bl.station.serviceimpl.successcase;

import com.bl.station.Bean.BeanValidator;
import com.bl.station.entity.Cases;
import com.bl.station.exception.ParamException;
import com.bl.station.mapper.CasesMapper;
import com.bl.station.page.PageInfo;
import com.bl.station.page.PageParam;
import com.bl.station.param.CaseParam;
import com.bl.station.param.CaseSearch;
import com.bl.station.service.picture.PictrueService;
import com.bl.station.service.successcase.CaseService;
import com.bl.station.utils.FastDFSClientWrapper;
import com.bl.station.utils.StationResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @ClassName CaseServiceImpl
 * @Description TODO
 * @Date 2018/9/2 21:40
 * @Author itastro
 * @Version 1.0
 **/

@Slf4j
@Service
@Transactional
public class CaseServiceImpl implements CaseService {
    @Autowired
    private PictrueService pictrueService;

    @Autowired
    private FastDFSClientWrapper fastDFSClientWrapper;

    @Autowired
    private CasesMapper casesMapper;


    @Override
    public StationResult save(CaseParam caseParam) throws Exception {

        BeanValidator.check(caseParam);
        String url = "";
        if (caseParam.getPic() == null) {
            throw new ParamException("照片不能为空");
        }
        url = pictrueService.upload(caseParam.getPic());
        Cases cases = Cases.builder().name(caseParam.getName()).createtime(caseParam.getCreatetime()).descn(caseParam.getDescn()).updatetime(new Date()).remark(caseParam.getRemark()).picurl(url).remark(caseParam.getRemark()).updatetime(new Date()).build();

        casesMapper.insert(cases);
        return StationResult.success("成功案例添加成功");
    }

    @Override
    public StationResult update(CaseParam caseParam) throws Exception {

        String url = "";
        BeanValidator.check(caseParam);

        if (caseParam.getId() == null) {

            throw new ParamException("请传入需要更新的id");
        }

        Cases aCase = casesMapper.selectByPrimaryKey(caseParam.getId());


        if (caseParam.getPic() != null) {
            url = pictrueService.upload(caseParam.getPic());
            aCase = Cases.builder().descn(caseParam.getDescn()).id(caseParam.getId()).id(caseParam.getId()).picurl(url).createtime(caseParam.getCreatetime()).remark(caseParam.getRemark()).updatetime(new Date()).name(caseParam.getName()).build();
        }

        aCase = Cases.builder().descn(caseParam.getDescn()).id(caseParam.getId()).picurl(aCase.getPicurl()).createtime(caseParam.getCreatetime()).remark(caseParam.getRemark()).updatetime(new Date()).name(caseParam.getName()).build();
        casesMapper.updateByPrimaryKeyWithBLOBs(aCase);
        return StationResult.success("更新成功");
    }


    @Override
    public StationResult delete(String ids) {

        if (StringUtils.isBlank(ids)) {

            throw new ParamException("id不能为空");
        }

        String[] splits = ids.split(",");

        for (String id : splits) {
            casesMapper.deleteByPrimaryKey(Integer.parseInt(id));

        }
        return StationResult.success("删除成功");

    }

    @Override
    public PageInfo<Cases> pageQuery(PageParam pageParam, CaseSearch caseSearch) {
        PageHelper.startPage(pageParam.getPage(), pageParam.getSize());

        Page<Cases> page = casesMapper.pageQuery(caseSearch);

        PageInfo<Cases> result = new PageInfo<Cases>(page);
        return result;
    }

    @Override
    public PageInfo<Cases> findAll(PageParam pageParam) {
        PageHelper.startPage(pageParam.getPage(), pageParam.getSize());

        Page<Cases> page = casesMapper.findAll();

        PageInfo<Cases> result = new PageInfo<Cases>(page);
        return result;
    }

    @Override
    public List<Cases> selectAll() {
        return casesMapper.findAll();
    }

    @Override
    public Cases findById(Integer id) {
        return casesMapper.selectByPrimaryKey(id);
    }


    @Override
    public List<Cases> search(String name) {


        if (StringUtils.isNotBlank(name)) {

            return casesMapper.likeName(name);
        }

        return casesMapper.findAll();
    }
}
