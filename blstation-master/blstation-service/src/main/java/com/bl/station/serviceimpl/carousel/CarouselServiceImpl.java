package com.bl.station.serviceimpl.carousel;

import com.bl.station.Bean.BeanValidator;
import com.bl.station.entity.Carousel;
import com.bl.station.exception.ParamException;
import com.bl.station.mapper.CarouselMapper;
import com.bl.station.page.PageInfo;
import com.bl.station.page.PageParam;
import com.bl.station.param.CarouselParam;
import com.bl.station.param.CarouselSearch;
import com.bl.station.service.carousel.CarouselService;
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
 * @ClassName CarouselServiceImpl
 * @Description TODO
 * @Date 2018/9/6 20:36
 * @Author itastro
 * @Version 1.0
 **/
@Slf4j
@Transactional
@Service
public class CarouselServiceImpl implements CarouselService {

    @Autowired
    private PictrueService pictrueService;

    @Autowired
    private CarouselMapper carouselMapper;

    @Autowired
    private FastDFSClientWrapper fastDFSClientWrapper;

    @Override
    public StationResult save(CarouselParam carouselParam) throws Exception {


        BeanValidator.check(carouselParam);

        String url = "";

        if (carouselParam.getPic() == null) {

            throw new ParamException("照片不能为空");
        }
        url = pictrueService.upload(carouselParam.getPic());

        Carousel carousel = Carousel.builder().picurl(url).title(carouselParam.getTitle()).content(carouselParam.getContent()).remark(carouselParam.getRemark()).build();
        carouselMapper.insert(carousel);
        return StationResult.success("添加成功");
    }

    @Override
    public StationResult update(CarouselParam carouselParam) throws Exception {
        String url = "";
        BeanValidator.check(carouselParam);

        if (carouselParam.getId() == null) {

            throw new ParamException("请传入需要更新的id");
        }

        Carousel carousel = carouselMapper.selectByPrimaryKey(carouselParam.getId());


        if (carousel.getPicurl() != null) {
            try {
                fastDFSClientWrapper.deleteFile(carousel.getPicurl());
            } catch (Exception e) {
                log.info("图片被删除");
            } finally {
                url = pictrueService.upload(carouselParam.getPic());
                carousel = Carousel.builder().content(carouselParam.getContent()).remark(carouselParam.getRemark()).id(carouselParam.getId()).id(carouselParam.getId()).picurl(url).build();
                carouselMapper.updateByPrimaryKeyWithBLOBs(carousel);
                return StationResult.success("更新成功");
            }


        }

        carousel = Carousel.builder().content(carouselParam.getContent()).title(carouselParam.getTitle()).remark(carouselParam.getRemark()).id(carouselParam.getId()).picurl(carousel.getPicurl()).build();

        carouselMapper.updateByPrimaryKeyWithBLOBs(carousel);
        return StationResult.success("更新成功");
    }

    @Override
    public StationResult delete(String ids) {
        if (StringUtils.isBlank(ids)) {

            throw new ParamException("id不能为空");
        }

        String[] splits = ids.split(",");

        for (String id : splits) {
            carouselMapper.deleteByPrimaryKey(Integer.parseInt(id));

        }
        return StationResult.success("删除成功");
    }

    @Override
    public PageInfo<Carousel> pageQuery(PageParam pageParam, CarouselSearch carouselSearch) {

        PageHelper.startPage(pageParam.getPage(), pageParam.getSize());

        Page<Carousel> page = carouselMapper.pageQuery(carouselSearch);

        PageInfo<Carousel> result = new PageInfo<Carousel>(page);
        return result;
    }

    @Override
    public List<Carousel> findAll() {
        return carouselMapper.selectAll();
    }
}
