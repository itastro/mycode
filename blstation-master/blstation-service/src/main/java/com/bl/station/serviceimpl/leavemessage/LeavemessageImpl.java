package com.bl.station.serviceimpl.leavemessage;

import com.bl.station.page.PageInfo;
import com.bl.station.entity.Leavemessage;
import com.bl.station.mapper.BaseDao;
import com.bl.station.mapper.LeavemessageMapper;
import com.bl.station.page.PageParam;
import com.bl.station.service.leavemessage.LeavemessageService;
import com.bl.station.utils.StationResult;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Slf4j
@Component
public class LeavemessageImpl extends BaseDao<Leavemessage> implements LeavemessageService {

    @Autowired
    private LeavemessageMapper leavemessageMapper;

    @Transient
    @Override
    public StationResult delete(String ids) {

        int i = 0;
        if (StringUtils.isBlank(ids)) {
            return StationResult.fail("请选择");
        }
        String[] strings = ids.split(",");

        for (String id : strings) {
            i = leavemessageMapper.deleteByPrimaryKey(Integer.parseInt(id));
            i++;
        }
        if (i < 1) {

            return StationResult.fail("删除失败");
        }
        return StationResult.success("删除成功");
    }

    @Override
    public StationResult add(Leavemessage leavemessage) {
        leavemessage.setCreatetime(new Date());
        int i = leavemessageMapper.insert(leavemessage);

        if (i > 0) {
            return StationResult.success("留言成功，我们会尽快联系你");
        }
        return StationResult.fail("站点正在维护");
    }

    @Override
    public PageInfo<Leavemessage> pageQuery(PageParam pageParam) {
        PageHelper.startPage(pageParam.getPage(), pageParam.getSize());

        List<Leavemessage> list = leavemessageMapper.pageQuery();
        PageInfo result = new PageInfo<Leavemessage>(list);

        return result;
    }

    @Override
    public Leavemessage findById(Integer id) {
        return leavemessageMapper.selectByPrimaryKey(id);
    }
}
