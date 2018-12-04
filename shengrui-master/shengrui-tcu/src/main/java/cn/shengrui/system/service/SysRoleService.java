package cn.shengrui.system.service;

import cn.shengrui.common.beans.JsonResult;
import cn.shengrui.common.beans.PageQuery;
import cn.shengrui.param.RoleParam;
import cn.shengrui.param.RoleSearch;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;

import java.util.List;

/**
 * @ClassName SysRoleService
 * @Description TODO
 * @Date 2018/10/22 13:54
 * @Author itastro
 * @Version 1.0
 **/
public interface SysRoleService {

    JsonResult save(RoleParam roleParam);

    JsonResult update(RoleParam roleParam);

    JsonResult delete(List<Integer> list);

    JsonResult pageQuery(PageQuery pageQuery, RoleSearch roleSearch);
}
