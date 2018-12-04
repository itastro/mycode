package cn.shengrui.management.service.impl;

import cn.shengrui.common.beans.JsonMapper;
import cn.shengrui.common.beans.JsonResult;
import cn.shengrui.common.beans.PageInfo;
import cn.shengrui.common.beans.PageQuery;
import cn.shengrui.common.constant.SysStatus;
import cn.shengrui.common.util.IpUtil;
import cn.shengrui.management.entity.TCompany;
import cn.shengrui.management.mapper.TCompanyMapper;
import cn.shengrui.param.CompanyParam;
import cn.shengrui.param.CompanySearch;
import cn.shengrui.management.service.CompanyService;
import cn.shengrui.system.shiro.ShiroUtils;
import com.github.pagehelper.PageHelper;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @ClassName CompanyServiceImpl
 * @Description 车企实现类
 * @Date 2018/10/12 13:12
 * @Author itastro
 * @Version 1.0
 **/
@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {

  private final static Logger LOGGER = LoggerFactory.getLogger(CompanyServiceImpl.class);

  @Autowired
  private HttpServletRequest httpServletRequest;
  @Autowired
  private TCompanyMapper tCompanyMapper;

  @Override
  public JsonResult save(CompanyParam companyParam) {
    LOGGER.info("companyParam:{}", JsonMapper.obj2String(companyParam));

    //判断当前公司是否存在
    if (checkExist(companyParam.getName(), companyParam.getId())) {
      return JsonResult.fail("存在相同的公司名称", companyParam);
    }
    //创建公司
    TCompany company = TCompany.builder().name(companyParam.getName())
        .remark(companyParam.getRemark()).companyCode(companyParam.getCompanyCode()).build();
    company.setStatus(SysStatus.USE);
    setCompanyParam(company);
    tCompanyMapper.insert(company);
    return JsonResult.success("车企添加成功", company);
  }

  /**
   * 设置创建时间  更新时间 操作ip  操作人
   */
  private void setCompanyParam(TCompany company) {
    company.setCreateTime(new Date());
    company.setOperateIp(IpUtil.getUserIP(httpServletRequest));
    company.setUpdateTime(new Date());
    //TODO:
    company.setOperator(ShiroUtils.getUserName());
  }

  @Override
  public JsonResult delete(List<Integer> idList) {

    if (CollectionUtils.isEmpty(idList)) {
      return JsonResult.fail("请选择需要删除的车企", idList);
    }

    for (Integer id : idList) {
      TCompany tCompany = tCompanyMapper.selectByPrimaryKey(id);
      tCompany.setStatus(SysStatus.DELETE);
      tCompanyMapper.updateByPrimaryKey(tCompany);

      tCompanyMapper.deleteByPrimaryKey(id);
    }
    return JsonResult.success("删除车企成功", idList);
  }

  @Override
  public JsonResult update(CompanyParam companyParam) {

    //判断当前公司是否存在
    if (checkExist(companyParam.getName(), companyParam.getId())) {
      return JsonResult.fail("存在相同的公司名称", companyParam);
    }
    //判断待更新的公司是否存在
    TCompany tCompany = tCompanyMapper.selectByPrimaryKey(companyParam.getId());

    if (tCompany == null) {
      return JsonResult.fail("待更新的公司不存在", tCompany);
    }
    //更新
    TCompany updateCompany = TCompany.builder().name(companyParam.getName())
        .remark(companyParam.getRemark()).id(companyParam.getId())
        .companyCode(companyParam.getCompanyCode()).build();
    updateCompany.setStatus(SysStatus.USE);
    setCompanyParam(updateCompany);

    tCompanyMapper.updateByPrimaryKeySelective(updateCompany);

    return JsonResult.success("车企信息更新成功", updateCompany);
  }

  @Override
  public JsonResult pageQuery(PageQuery pageQuery, CompanySearch companySearch) {

    PageHelper.startPage(pageQuery.getPageNo(), pageQuery.getSize());

    List<TCompany> page = tCompanyMapper.pageQuery(companySearch);

    PageInfo<TCompany> result = new PageInfo<TCompany>(page);
    result.setList(page);
    return JsonResult.success("查询成功", result);
  }

  /**
   * 校验当前车企是否存在
   */
  private boolean checkExist(String name, Integer id) {

    return tCompanyMapper.countByName(name, id) > 0;
  }

  /**
   * 查询所有
   */
  @Override
  public JsonResult findAll() {
    List<TCompany> list = tCompanyMapper.findAll();
    return JsonResult.success("查询成功", list);
  }
}
