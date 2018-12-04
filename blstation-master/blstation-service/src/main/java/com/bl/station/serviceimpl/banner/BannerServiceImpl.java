package com.bl.station.serviceimpl.banner;

import com.bl.station.Bean.BeanValidator;
import com.bl.station.entity.Banner;
import com.bl.station.exception.ParamException;
import com.bl.station.mapper.BannerMapper;
import com.bl.station.page.PageInfo;
import com.bl.station.page.PageParam;
import com.bl.station.param.BannerParam;
import com.bl.station.param.BannerSearch;
import com.bl.station.service.banner.BannerService;
import com.bl.station.service.picture.PictrueService;
import com.bl.station.utils.FastDFSClientWrapper;
import com.bl.station.utils.StationResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName BannerServiceImpl
 * @Description TODO
 * @Date 2018/9/6 20:37
 * @Author itastro
 * @Version 1.0
 **/
@Slf4j
@Transactional
@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    private FastDFSClientWrapper fastDFSClientWrapper;

    @Autowired
    private PictrueService pictrueService;

    @Autowired
    private BannerMapper bannerMapper;

    @Override
    public StationResult save(BannerParam bannerParam) throws Exception {

        BeanValidator.check(bannerParam);
        if (bannerParam.getPic() == null) {

            throw new ParamException("照片不能为空");
        }

        String url = pictrueService.upload(bannerParam.getPic());

        Banner banner = Banner.builder().content(bannerParam.getContent()).moudle(bannerParam.getMoudle()).remark(bannerParam.getRemark()).url(url).build();

        bannerMapper.insert(banner);
        return StationResult.success("添加成功");
    }

    @Override
    public StationResult delete(String ids) {

        if (StringUtils.isBlank(ids)) {

            throw new ParamException("id不能为空");
        }

        String[] splits = ids.split(",");

        for (String id : splits) {
            bannerMapper.deleteByPrimaryKey(Integer.parseInt(id));

        }
        return StationResult.success("删除成功");
    }

    @Override
    public StationResult update(BannerParam bannerParam) throws Exception {
        String url = "";
        BeanValidator.check(bannerParam);

        if (bannerParam.getId() == null) {

            throw new ParamException("请传入需要更新的id");
        }

        Banner banner = bannerMapper.selectByPrimaryKey(bannerParam.getId());


        if (bannerParam.getPic() != null) {

            try {
                fastDFSClientWrapper.deleteFile(banner.getUrl());
            } catch (Exception e) {
                log.info("图片不存在");
            } finally {
                url = pictrueService.upload(bannerParam.getPic());
                banner = Banner.builder().content(bannerParam.getContent()).moudle(bannerParam.getMoudle()).remark(bannerParam.getRemark()).id(bannerParam.getId()).url(url).build();
                bannerMapper.updateByPrimaryKeyWithBLOBs(banner);
                return StationResult.success("更新成功");

            }

        }

        banner = Banner.builder().content(bannerParam.getContent()).moudle(bannerParam.getMoudle()).remark(bannerParam.getRemark()).id(bannerParam.getId()).url(banner.getUrl()).build();

        bannerMapper.updateByPrimaryKeyWithBLOBs(banner);
        return StationResult.success("更新成功");
    }

    @Override
    public PageInfo<Banner> pageQuery(PageParam pageParam, BannerSearch bannerSearch) {
        PageHelper.startPage(pageParam.getPage(), pageParam.getSize());
        Page<Banner> list = bannerMapper.pageQuery(bannerSearch);
        PageInfo<Banner> result = new PageInfo<Banner>(list);
        return result;
    }

    @Override
    public List<Banner> findAll() {
        List<Banner> lists = bannerMapper.selectAll();
        return lists;
    }
}
