package cn.shengrui.system.service;


import cn.shengrui.common.beans.JsonResult;
import cn.shengrui.param.SysMenuParam;
import org.springframework.stereotype.Service;

/**
 * @author itastro
 */

public interface SysMenuService {

    JsonResult save(SysMenuParam sysMenuParam);

    JsonResult update(SysMenuParam sysMenuParam);

    JsonResult delete(Integer id);

}
