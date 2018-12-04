package cn.shengrui.system.service;

import cn.shengrui.common.beans.JsonResult;
import cn.shengrui.common.beans.PageQuery;
import cn.shengrui.param.SysUserParam;
import cn.shengrui.param.UserSearch;

import java.util.List;

/**
 * @author itastro
 */
public interface SysUserService {

  /**
   * 保存用户
   */
  JsonResult save(SysUserParam sysUserParam);

  /**
   * 删除用户
   */
  JsonResult delete(List<Integer> list);


  /**
   * 修改用户信息
   */
  JsonResult update(SysUserParam sysUserParam);


  /**
   * 查询用户信息
   */

  JsonResult pageQuery(PageQuery pageQuery, UserSearch userSearch);


  /**
  * @Description: update password
  * @params [telphone, srcpasswd, targetpasswd, confirmpass]
  * @Return: cn.shengrui.common.beans.JsonResult
  * @Author: itastro
  * @Date: 2018/11/30 9:49
  */

  JsonResult updatePassword(String username, String srcpasswd, String targetpasswd,
      String confirmpass);
}
