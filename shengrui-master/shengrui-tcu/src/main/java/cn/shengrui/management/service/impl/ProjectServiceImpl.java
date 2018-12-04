package cn.shengrui.management.service.impl;

import cn.shengrui.common.beans.JsonMapper;
import cn.shengrui.common.beans.JsonResult;
import cn.shengrui.common.beans.PageInfo;
import cn.shengrui.common.beans.PageQuery;
import cn.shengrui.common.constant.SysStatus;
import cn.shengrui.common.util.IpUtil;
import cn.shengrui.management.entity.TFile;
import cn.shengrui.management.entity.TProject;
import cn.shengrui.management.entity.TProjectExample;
import cn.shengrui.management.mapper.TFileMapper;
import cn.shengrui.management.mapper.TProjectMapper;
import cn.shengrui.param.ProjectParam;
import cn.shengrui.param.ProjectSearch;
import cn.shengrui.management.service.ProjectService;
import cn.shengrui.param.TaskParam;
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
 * @ClassName ProjectServiceImpl
 * @Description TODO
 * @Date 2018/10/14 20:36
 * @Author itastro
 * @Version 1.0
 **/
@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

  private final static Logger LOGGER = LoggerFactory.getLogger(CompanyServiceImpl.class);

  @Autowired
  private HttpServletRequest httpServletRequest;


  @Autowired
  private TProjectMapper tProjectMapper;

  @Autowired
  private TFileMapper tFileMapper;

  @Override
  public JsonResult save(ProjectParam projectParam) {
    LOGGER.info("projectParam:{}", JsonMapper.obj2String(projectParam));

    //判段此项目是否存在
    if (checkExist(projectParam.getName(), projectParam.getCompany_id(), projectParam.getId())) {
      return JsonResult.fail("存在相同的项目", projectParam);
    }

    String shengruiScriptName = "";
    String customerScriptName = "";
    LOGGER.info("projectParam:{}", JsonMapper.obj2String(projectParam));

    //判断这个任务是否存在

    TFile providerScript = tFileMapper.selectByPrimaryKey(projectParam.getCustomerScriptId());

    if (providerScript == null) {
      customerScriptName = projectParam.getCustomerScriptName();

      saveCustomerScriptName(projectParam);
    } else {
      customerScriptName = providerScript.getName();

    }

    TFile shengruiScript = tFileMapper.selectByPrimaryKey(projectParam.getShengruiScriptId());

    if (shengruiScript == null) {
      shengruiScriptName = projectParam.getShengruiScriptName();

      saveShengruiScriptName(projectParam);
    } else {
      shengruiScriptName = shengruiScript.getName();
    }
    //创建项目
    TProject tProject = TProject.builder().name(projectParam.getName())
        .companyId(projectParam.getCompany_id()).labelPartsNo(projectParam.getLabelPartsNo())
        .writePartsNo(projectParam.getWritePartsNo())
        .customerBarcodeType(projectParam.getCustomerBarcodeType())
        .customerBarcodeCount(projectParam.getCustomerBarcodeCount()).build();

    tProject.setStatus(SysStatus.USE);
    tProject.setCreateTime(new Date());
    tProject.setShengruiScript(shengruiScriptName);
    tProject.setCustomerScript(customerScriptName);
    tProject.setOperateIp(IpUtil.getUserIP(httpServletRequest));
    tProject.setUpdateTime(new Date());
    tProject.setOperator(ShiroUtils.getUserName());
    int projectId = tProjectMapper.insert(tProject);
    LOGGER.info("id:{}", projectId);

    return JsonResult.success("项目保存成功", tProject);
  }


  private void saveCustomerScriptName(ProjectParam projectParam) {
    TFile tFile = new TFile();
    tFile.setName(projectParam.getCustomerScriptName());
    tFile.setUrl("no");
    tFile.setType(3);
    tFileMapper.insertSelective(tFile);
  }

  private void saveShengruiScriptName(ProjectParam projectParam) {
    TFile tFile = new TFile();
    tFile.setName(projectParam.getShengruiScriptName());
    tFile.setType(2);
    tFile.setUrl("no");
    tFileMapper.insertSelective(tFile);
  }


  @Override
  public JsonResult update(ProjectParam projectParam) {

    String shengruiScriptName = "";
    String customerScriptName = "";
    //校验是否有相同的项目
    if (checkExist(projectParam.getName(), projectParam.getCompany_id(), projectParam.getId())) {
      return JsonResult.fail("存在相同的项目", projectParam);
    }
    //校验需要更新的项目是否存在
    TProject tProject = tProjectMapper.selectByPrimaryKey(projectParam.getId());
    if (tProject == null) {
      JsonResult.fail("待更新的项目不存在", projectParam);
    }

    //创建项目
    tProject = TProject.builder().name(projectParam.getName())
        .companyId(projectParam.getCompany_id()).labelPartsNo(projectParam.getLabelPartsNo())
        .writePartsNo(projectParam.getWritePartsNo())
        .customerBarcodeType(projectParam.getCustomerBarcodeType())
        .customerBarcodeCount(projectParam.getCustomerBarcodeCount()).id(projectParam.getId())
        .build();

    TFile providerScript = tFileMapper.selectByPrimaryKey(projectParam.getCustomerScriptId());
    if (providerScript == null) {
      customerScriptName = projectParam.getCustomerScriptName();
      saveCustomerScriptName(projectParam);

    } else {
      customerScriptName = providerScript.getName();

    }
    tProject.setCustomerScript(customerScriptName);

    TFile shengruiScript = tFileMapper.selectByPrimaryKey(projectParam.getShengruiScriptId());
    if (shengruiScript == null) {
      shengruiScriptName = projectParam.getShengruiScriptName();
      saveShengruiScriptName(projectParam);
    } else {
      shengruiScriptName = shengruiScript.getName();
    }
    tProject.setShengruiScript(shengruiScriptName);
    tProject.setUpdateTime(new Date());
    tProjectMapper.updateByPrimaryKeySelective(tProject);
    return JsonResult.success("项目更新成功");
  }

  @Override
  public JsonResult delete(List<Integer> ids) {
    //判断是否选中项目
    if (CollectionUtils.isEmpty(ids)) {
      JsonResult.fail("请选择项目", ids);
    }
    for (Integer id : ids) {
      TProject tProject = tProjectMapper.selectByPrimaryKey(id);
      if (tProject != null) {
        //删除项目
        tProject.setStatus(SysStatus.DELETE);
        tProjectMapper.updateByPrimaryKey(tProject);
        tProjectMapper.deleteByPrimaryKey(id);
      }

    }
    return JsonResult.success("项目删除成功", ids);
  }


  @Override
  public JsonResult pageQuery(PageQuery pageQuery, ProjectSearch projectSearch) {

    PageHelper.startPage(pageQuery.getPageNo(), pageQuery.getSize());

    List<TProject> page = tProjectMapper.pageQuery(projectSearch);

    PageInfo<TProject> result = new PageInfo<TProject>(page);

    return JsonResult.success("查询成功", result);
  }

  @Override
  public boolean checkExist(String name, Integer companyId, Integer projectid) {

    //创建查询条件
    TProjectExample tProjectExample = new TProjectExample();
    TProjectExample.Criteria criteria = tProjectExample.createCriteria();
    if (StringUtils.isNotBlank(name)) {
      criteria.andNameEqualTo(name);
    }
    if (companyId != null) {
      criteria.andCompanyIdEqualTo(companyId);
    }
    if (projectid != null) {
      criteria.andIdEqualTo(projectid);
    }
    return tProjectMapper.countByExample(tProjectExample) > 0;
  }

  @Override
  public JsonResult findAll() {

    List<TProject> list = tProjectMapper.findAll();
    return JsonResult.success("查询成功", list);
  }
}
