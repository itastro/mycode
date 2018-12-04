package cn.shengrui.system.service;
import cn.shengrui.common.beans.JsonResult;

public interface SysTreeService {

    JsonResult menuTree();

    JsonResult roleMenuTree(Integer roleId);

    JsonResult userMenuTree();
}
