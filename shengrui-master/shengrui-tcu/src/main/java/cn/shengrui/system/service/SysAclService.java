package cn.shengrui.system.service;


import cn.shengrui.common.beans.JsonResult;
import cn.shengrui.common.beans.PageQuery;
import cn.shengrui.param.AclParam;
import cn.shengrui.param.AclSearch;

import java.util.List;

/**
 * 权限接口
 *
 * @author itastro
 */
public interface SysAclService {

    JsonResult save(AclParam aclParam);

    JsonResult update(AclParam aclParam);

    JsonResult delete(List<Integer> list);

    JsonResult pageQuery(PageQuery pageQuery, AclSearch aclSearch);


}
