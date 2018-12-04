package cn.shengrui.system.service.impl;

import cn.shengrui.common.beans.JsonResult;
import cn.shengrui.common.beans.PageInfo;
import cn.shengrui.common.beans.PageQuery;
import cn.shengrui.common.constant.SysStatus;
import cn.shengrui.common.constant.SysUserConstant;
import cn.shengrui.common.util.HttpContextUtils;
import cn.shengrui.common.util.IpUtil;
import cn.shengrui.param.SysUserParam;
import cn.shengrui.param.UserSearch;
import cn.shengrui.system.entity.SysUser;
import cn.shengrui.system.entity.SysUserExample;
import cn.shengrui.system.mapper.SysUserMapper;
import cn.shengrui.system.service.SysUserService;
import cn.shengrui.system.shiro.ShiroUtils;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @ClassName SysUserServiceImpl
 * @Description TODO
 * @Date 2018/10/7 23:59
 * @Author itastro
 * @Version 1.0
 **/
@Service
@Transactional
public class SysUserServiceImpl implements SysUserService {

  @Autowired
  private SysUserMapper sysUserMapper;


  public HttpServletRequest getRequest() {
    return HttpContextUtils.getHttpServletRequest();
  }


  @Override
  public JsonResult save(SysUserParam sysUserParam) {

    boolean flag =
        sysUserMapper.selectByUsername(sysUserParam.getUsername()) == null ? true : false;

    if (!flag) {
      return JsonResult.fail("此用户名已经存在", sysUserParam);
    }

    if (checkExist(sysUserParam)) {
      return JsonResult.fail("此用户已经存在", sysUserParam);
    }
    String password = ShiroUtils.sha256(sysUserParam.getUsername(), SysUserConstant.SALT);

    //创建用户
    SysUser sysUser = SysUser.builder().remark(sysUserParam.getRemark())
        .username(sysUserParam.getUsername()).nickname(sysUserParam.getNickname()).build();

    //密码
    sysUser.setPassword(password);
    //补全
    sysUser.setOperateIp(IpUtil.getUserIP(getRequest()));
    sysUser.setOperateTime(new Date());
    sysUser.setOperator(ShiroUtils.getUserName());
    sysUser.setStatus(SysStatus.USE);
    sysUserMapper.insert(sysUser);
    return JsonResult.success("添加用户成功", sysUser);
  }

  @Override
  public JsonResult delete(List<Integer> list) {
    for (Integer id : list) {
      SysUser sysUser = sysUserMapper.selectByPrimaryKey(id);
      if (sysUser.getUsername().equals(SysUserConstant.USERNAME)) {
        continue;
      }
      sysUser.setStatus(SysStatus.DELETE);
      sysUserMapper.updateByPrimaryKey(sysUser);
      sysUserMapper.deleteByPrimaryKey(id);
    }
    return JsonResult.success("用户删除成功", list);
  }

  @Override
  public JsonResult update(SysUserParam sysUserParam) {
    if (checkExist(sysUserParam)) {
      return JsonResult.fail("此用户已经存在", sysUserParam);
    }
    SysUser sysUser = sysUserMapper.selectByPrimaryKey(sysUserParam.getId());
    if (sysUser == null) {
      return JsonResult.fail("待更新的用户不存在");
    }
    if (sysUser.getUsername().equals(SysUserConstant.USERNAME)) {
      sysUser = SysUser.builder().username(sysUserParam.getNickname()).id(sysUserParam.getId())
          .build();
    } else {

      sysUser = SysUser.builder().nickname(sysUserParam.getNickname()).id(sysUserParam.getId())
          .build();
    }

    sysUserMapper.updateByPrimaryKeySelective(sysUser);
    return JsonResult.success("用户信息更新成功", sysUser);
  }

  @Override
  public JsonResult pageQuery(PageQuery pageQuery, UserSearch userSearch) {

    PageHelper.startPage(pageQuery.getPageNo(), pageQuery.getSize());

    List<SysUser> list = sysUserMapper.pageQuery(userSearch);
    PageInfo<SysUser> result = new PageInfo<>(list);
    return JsonResult.success("查询成功", result);
  }


  private boolean checkExist(SysUserParam sysUserParam) {

    SysUserExample sysUserExample = new SysUserExample();

    SysUserExample.Criteria criteria = sysUserExample.createCriteria();

    if (sysUserParam.getId() != null) {
      criteria.andIdEqualTo(sysUserParam.getId());
    }
    if (StringUtils.isNotBlank(sysUserParam.getUsername())) {
      criteria.andUsernameEqualTo(sysUserParam.getUsername());
    }

    if (StringUtils.isNotBlank(sysUserParam.getNickname())) {
      criteria.andNicknameEqualTo(sysUserParam.getNickname());
    }

    return sysUserMapper.countByExample(sysUserExample) > 0;
  }


  @Override
  public JsonResult updatePassword(String username, String srcpass, String targetpass,
      String confirmpass
  ) {

    SysUserExample sysUserExample = new SysUserExample();
    SysUserExample.Criteria criteria = sysUserExample.createCriteria();
    if (StringUtils.isBlank(username)) {
      return JsonResult.fail("请输入登录账号", null);
    }
    criteria.andUsernameEqualTo(username);
    //查询出来是一个lsit
    SysUser sysUser = sysUserMapper.selectByUsername(username);

    if (sysUser == null) {
      return JsonResult.fail("此用户不存在", null);
    }

    srcpass = ShiroUtils.sha256(srcpass, SysUserConstant.SALT);
    if (!sysUser.getPassword().equals(srcpass)) {
      return JsonResult.fail("原密码输入错误", null);
    }
    if (StringUtils.isBlank(targetpass)) {
      return JsonResult.fail("请输入新密码", null);
    }

    if (StringUtils.isBlank(confirmpass)) {
      return JsonResult.fail("请输入确认密码", null);
    }
    if (!targetpass.equals(confirmpass)) {
      return JsonResult.fail("新密码和确认密码不同", null);
    }
    targetpass = ShiroUtils.sha256(targetpass, SysUserConstant.SALT);
    //更新密码
    sysUser.setPassword(targetpass);

    sysUserMapper.updateByPrimaryKeySelective(sysUser);
    return JsonResult.success("密码更新成功", null);
  }
}
