package cn.shengrui.management.service.impl;

import cn.shengrui.common.beans.*;
import cn.shengrui.common.constant.SysStatus;
import cn.shengrui.common.util.IpUtil;
import cn.shengrui.management.entity.TTcu;
import cn.shengrui.management.entity.TTcuExample;
import cn.shengrui.management.mapper.TTcuMapper;
import cn.shengrui.param.TcuInfo;
import cn.shengrui.param.TcuParam;
import cn.shengrui.param.TcuSearch;
import cn.shengrui.management.service.TcuService;
import cn.shengrui.system.shiro.ShiroUtils;
import com.github.pagehelper.PageHelper;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @ClassName TcuServiceImpl
 * @Description TODO
 * @Date 2018/10/14 12:43
 * @Author itastro
 * @Version 1.0
 **/

@Service
@Transactional
public class TcuServiceImpl implements TcuService {

  private final static Logger LOGGER = LoggerFactory.getLogger(TcuServiceImpl.class);
  @Autowired
  private TTcuMapper tTcuMapper;

  @Autowired
  private HttpServletRequest request;

  @Override
  public JsonResult save(TcuParam tcuParam) {
    LOGGER.info("tcuParam:{}", JsonMapper.obj2String(tcuParam));
    if (checkExist(tcuParam.getTcuCode(), tcuParam.getId())) {
      LOGGER.warn("存在形同型号的tcu");
      return JsonResult.fail("存在相同的型号TCU", tcuParam);
    }

    //创建tcu
    TTcu tTcu = TTcu.builder().type(tcuParam.getTcuType()).tcuCode(tcuParam.getTcuCode())
        .supplier(tcuParam.getSupplier()).bootVersion(tcuParam.getBootVersion())
        .supCode(tcuParam.getSupCode()).fileId(tcuParam.getFileId()).build();
    tTcu.setStatus(SysStatus.USE);
    //补全信息
    tTcu.setCreateTime(new Date());
    // TODO:
    tTcu.setOperator(ShiroUtils.getUserName());
    tTcu.setUpdateTime(new Date());
    tTcu.setOperatorIp(IpUtil.getUserIP(request));
    tTcu.setStatus(SysStatus.USE);
    Integer tcuId = tTcuMapper.insert(tTcu);

    LOGGER.info("tcuId:{}", tcuId);
    return JsonResult.success("添加tcu成功", tTcu);
  }

  @Override
  public JsonResult update(TcuParam tcuParam) {

    LOGGER.info("tcuParam:{}", JsonMapper.obj2String(tcuParam));
    if (checkExist(tcuParam.getTcuType(), tcuParam.getId())) {
      LOGGER.warn("存在形同型号的tcu");
      return JsonResult.fail("存在相同的型号TCU", tcuParam);
    }

    TTcu tTcu = tTcuMapper.selectByPrimaryKey(tcuParam.getId());
    if (tTcu == null) {
      return JsonResult.fail("待更新的TCU不要存在", tcuParam.getId());
    }

    //创建tcu
    tTcu = TTcu.builder().type(tcuParam.getTcuType()).tcuCode(tcuParam.getTcuCode())
        .supplier(tcuParam.getSupplier()).bootVersion(tcuParam.getBootVersion())
        .id(tcuParam.getId()).supCode(tcuParam.getSupCode()).fileId(tcuParam.getFileId()).build();
    tTcu.setUpdateTime(new Date());
    tTcu.setOperatorIp(IpUtil.getUserIP(request));
    //更新
    tTcuMapper.updateByPrimaryKeySelective(tTcu);
    return JsonResult.success("tcu更新成功", tTcu);
  }

  @Override
  public JsonResult delete(List<Integer> ids) {

    if (CollectionUtils.isEmpty(ids)) {
      return JsonResult.fail("请选择需要删除的TCU", ids);
    }
    for (Integer id : ids) {
      TTcu tTcu = tTcuMapper.selectByPrimaryKey(id);
      tTcu.setStatus(SysStatus.DELETE);
      tTcuMapper.updateByPrimaryKey(tTcu);
      tTcuMapper.deleteByPrimaryKey(id);
    }
    return JsonResult.success("TCU删除成功", ids);
  }

  @Override
  public JsonResult pageQuery(PageQuery pageQuery, TcuSearch tcuSearch) {

    PageHelper.startPage(pageQuery.getPageNo(), pageQuery.getSize());
    List<TcuInfo> page = tTcuMapper.pageQuery(tcuSearch);
    PageInfo<TcuInfo> result = new PageInfo<TcuInfo>(page);
    return JsonResult.success("查询成功", result);
  }

  @Override
  public boolean checkExist(String tcuCode, Integer id) {
    TTcuExample tTcuExample = new TTcuExample();
    TTcuExample.Criteria criteria = tTcuExample.createCriteria();
    if (id != null) {
      criteria.andIdEqualTo(id);
    }
    if (StringUtils.isNotBlank(tcuCode)) {
      criteria.andTcuCodeEqualTo(tcuCode);
    }
    return tTcuMapper.countByExample(tTcuExample) > 0;
  }

  @Override
  public JsonResult findAll() {

    List<TTcu> list = tTcuMapper.findAll();
    return JsonResult.success("查询成功", list);
  }
}
