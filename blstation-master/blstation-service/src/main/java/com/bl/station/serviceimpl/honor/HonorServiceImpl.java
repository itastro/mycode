package com.bl.station.serviceimpl.honor;

import com.bl.station.Bean.BeanValidator;
import com.bl.station.entity.Honor;
import com.bl.station.exception.ParamException;
import com.bl.station.mapper.HonorMapper;
import com.bl.station.page.PageInfo;
import com.bl.station.page.PageParam;
import com.bl.station.param.HonorParam;
import com.bl.station.param.HonorSearch;
import com.bl.station.service.Honor.HonorService;
import com.bl.station.service.picture.PictrueService;
import com.bl.station.utils.FastDFSClientWrapper;
import com.bl.station.utils.StationResult;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ClassName HonorServiceImpl
 * @Description TODO
 * @Date 2018/8/13 14:58
 * @Author itastro
 * @Version 1.0
 **/
@Slf4j
@Service
public class HonorServiceImpl implements HonorService {

    @Autowired
    private HonorMapper honorMapper;

    @Autowired
    private PictrueService pictrueService;

    @Autowired

    private FastDFSClientWrapper fastDFSClientWrapper;

    @Override
    public StationResult save(HonorParam honorParam) throws Exception {
        BeanValidator.check(honorParam);
        saveHonor(honorParam);
        return StationResult.success("添加成功");
    }

    private void saveHonor(HonorParam honorParam) throws Exception {
        Honor honor = getHonor(honorParam);

        honorMapper.insert(honor);
    }

    private Honor getHonor(HonorParam honorParam) throws Exception {
        String url = "";
        Honor honor = new Honor();
        honor.setCreatetime(new Date());
        BeanUtils.copyProperties(honorParam, honor);
        if (honorParam.getPic() != null) {
            url = pictrueService.upload(honorParam.getPic());
        }

        honor.setPicurl(url);
        return honor;
    }

    @Override
    public StationResult delete(String ids) {

        if (StringUtils.isBlank(ids)) {
            throw new ParamException("请你选择需要删除的资质");
        }
        String[] idss = ids.split(",");

        for (String id : idss) {
            honorMapper.deleteByPrimaryKey(Integer.parseInt(id));
        }
        return StationResult.success("删除成功");
    }

    @Override
    public PageInfo<Honor> pageQuery(PageParam pageParam, HonorSearch honorSearch) {
        PageHelper.startPage(pageParam.getPage(), pageParam.getSize());
        List<Honor> list = honorMapper.pageQuery(honorSearch);
        PageInfo<Honor> result = new PageInfo<Honor>(list);
        return result;
    }

    @Override
    public PageInfo<Honor> selectAll(PageParam pageParam) {
        PageHelper.startPage(pageParam.getPage(), pageParam.getSize());
        List<Honor> list = honorMapper.findAll();
        PageInfo<Honor> result = new PageInfo<Honor>(list);
        return result;
    }

    @Override
    public StationResult update(HonorParam honorParam) throws Exception {

        try {
            Honor honor = honorMapper.selectByPrimaryKey(honorParam.getId());
            fastDFSClientWrapper.deleteFile(honor.getPicurl());
        } catch (Exception e) {
            log.info("文件不存在");
        } finally {
            updateHonor(honorParam);
        }
        return StationResult.success("更新成功");
    }

    private void updateHonor(HonorParam honorParam) throws Exception {
        Honor honor = getHonor(honorParam);

        honorMapper.updateByPrimaryKeyWithBLOBs(honor);


    }

    @Override
    public Honor findById(Integer id) {
        return honorMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Honor> findAll() {
        return honorMapper.findAll();
    }
}
