package cn.shengrui.system.service.impl;

import cn.shengrui.common.beans.JsonResult;
import cn.shengrui.common.beans.PageInfo;
import cn.shengrui.common.beans.PageQuery;
import cn.shengrui.common.constant.SysStatus;
import cn.shengrui.common.util.HttpContextUtils;
import cn.shengrui.common.util.IpUtil;
import cn.shengrui.common.util.StringUtil;
import cn.shengrui.param.RoleParam;
import cn.shengrui.param.RoleSearch;
import cn.shengrui.param.SysUserParam;
import cn.shengrui.system.entity.SysRole;
import cn.shengrui.system.entity.SysRoleExample;
import cn.shengrui.system.entity.SysUserExample;
import cn.shengrui.system.mapper.SysRoleMapper;
import cn.shengrui.system.service.SysRoleService;
import cn.shengrui.system.shiro.ShiroUtils;
import com.github.pagehelper.PageHelper;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.relation.Role;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @ClassName AclServiceIMPL
 * @Description TODO
 * @Date 2018/10/22 13:54
 * @Author itastro
 * @Version 1.0
 **/

@Service
@Transactional
public class SysRoleServiceImpl implements SysRoleService {


  @Autowired
  private SysRoleMapper sysRoleMapper;


  public HttpServletRequest getRequest() {
    return HttpContextUtils.getHttpServletRequest();
  }

  @Override
  public JsonResult save(RoleParam roleParam) {
    if (checkExist(roleParam)) {
      return JsonResult.fail("此角色已经存", roleParam);
    }
    SysRole sysRole = SysRole.builder().name(roleParam.getName()).keyword(roleParam.getKeyword())
        .remark(roleParam.getRemark()).build();
    //补全信息
    sysRole.setOperateIp(IpUtil.getUserIP(getRequest()));
    sysRole.setOperateTime(new Date());
    sysRole.setOperator(ShiroUtils.getUserName());
    sysRole.setStatus(SysStatus.USE);
    sysRole.setType(1);
    sysRoleMapper.insert(sysRole);
    return JsonResult.success("角色添加成功", sysRole);
  }

  @Override
  public JsonResult update(RoleParam roleParam) {
    if (checkExist(roleParam)) {
      return JsonResult.fail("此角色已经存", roleParam);
    }
    SysRole sysRole = sysRoleMapper.selectByPrimaryKey(roleParam.getId());
    if (sysRole == null) {
      return JsonResult.fail("待更新的角色不存在", sysRole);
    }

    sysRole = SysRole.builder().name(roleParam.getName()).keyword(roleParam.getKeyword())
        .id(roleParam.getId()).remark(roleParam.getRemark()).build();
    sysRole.setType(1);
    sysRole.setStatus(SysStatus.USE);
    sysRoleMapper.updateByPrimaryKeySelective(sysRole);
    return JsonResult.success("角色更新成功", sysRole);
  }

  @Override
  public JsonResult delete(List<Integer> list) {

    for (Integer id : list) {
      SysRole sysRole = sysRoleMapper.selectByPrimaryKey(id);
      sysRole.setStatus(SysStatus.DELETE);
      sysRoleMapper.updateByPrimaryKey(sysRole);
      sysRoleMapper.deleteByPrimaryKey(id);
    }
    return JsonResult.success("角色删除成功", list);
  }

  @Override
  public JsonResult pageQuery(PageQuery pageQuery, RoleSearch roleSearch) {

    PageHelper.startPage(pageQuery.getPageNo(), pageQuery.getSize());

    List<SysRole> list = sysRoleMapper.pageQuery(roleSearch);

    PageInfo<SysRole> result = new PageInfo<>(list);

    return JsonResult.success("查询成功", result);
  }

  private boolean checkExist(RoleParam roleParam) {

    SysRoleExample sysRoleExample = new SysRoleExample();
    SysRoleExample.Criteria criteria = sysRoleExample.createCriteria();

    if (roleParam.getId() != null) {
      criteria.andIdEqualTo(roleParam.getId());
    }

    if (StringUtils.isNotBlank(roleParam.getKeyword())) {
      criteria.andKeywordEqualTo(roleParam.getKeyword());
    }

    if (StringUtils.isNotBlank(roleParam.getName())) {
      criteria.andNameEqualTo(roleParam.getName());
    }
    return sysRoleMapper.countByExample(sysRoleExample) > 0;
  }
}
