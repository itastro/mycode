package com.bl.station.serviceimpl.information;

import com.bl.station.entity.Information;
import com.bl.station.mapper.BaseDao;
import com.bl.station.mapper.InformationMapper;
import com.bl.station.page.PageInfo;
import com.bl.station.page.PageParam;
import com.bl.station.param.InformationParam;
import com.bl.station.service.information.InformationService;
import com.bl.station.service.picture.PictrueService;
import com.bl.station.utils.FastDFSClientWrapper;
import com.bl.station.utils.JsonMapper;
import com.bl.station.utils.StationResult;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Slf4j
@Component
public class InformationImpl extends BaseDao<Information> implements InformationService {


    @Autowired
    private InformationMapper informationMapper;

    @Autowired
    private PictrueService pictrueService;


    @Autowired
    private FastDFSClientWrapper clientConfig;


    @Override
    public StationResult add(InformationParam information) {
        log.info("information:{}", JsonMapper.obj2String(information));

        Information information1 = getInformation(information);

        int i = informationMapper.insert(information1);

        if (i > 0) {

            return StationResult.success("添加成功");
        }
        return StationResult.fail("添加失败");
    }

    private Information getInformation(InformationParam informationParam) {
        Information information = new Information();
        information.setAddress(informationParam.getAddress());
        information.setContent(informationParam.getContent());
        information.setEmail(informationParam.getEmail());
        information.setName(informationParam.getName());
        information.setPhone(informationParam.getPhone());
        information.setTel(informationParam.getTel());

        information.setFirstpatents(informationParam.getFirstpatents());
        information.setCooperation(informationParam.getCooperation());
        information.setPatents(informationParam.getPatents());
        try {
            String picurl = pictrueService.upload(informationParam.getPic());

            information.setPicurl(picurl);

            String qrurl = pictrueService.upload(informationParam.getQrpic());

            information.setQrcode(qrurl);
        } catch (Exception e) {

        }


        return information;
    }

    @Override
    public StationResult delete(Integer id) {
        int i = informationMapper.deleteByPrimaryKey(id);

        if (i > 0) {
            return StationResult.success("删除成功");
        }
        return StationResult.fail("删除失败");
    }

    @Override
    public StationResult update(InformationParam information) {
        if (information.getId() == null) {
            StationResult.fail("请传入数据id");
        }
        Information information1 = getInformation(information);
        information1.setId(information.getId());

        informationMapper.updateByPrimaryKeyWithBLOBs(information1);
        return StationResult.success("更新成功");

    }

    @Override
    public PageInfo<Information> pageQuery() {
        return null;
    }

    @Override
    public Information findById(Integer id) {


        return informationMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<Information> findAll(PageParam pageParam) {
        PageHelper.startPage(pageParam.getPage(), pageParam.getSize());
        List<Information> list = informationMapper.findAll();
        PageInfo<Information> result = new PageInfo<Information>(list);
        return result;
    }

    @Override
    public Information findOne(Integer id) {
        return informationMapper.selectByPrimaryKey(id);
    }


}