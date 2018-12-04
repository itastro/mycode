package cn.shengrui.system.service.impl;

import cn.shengrui.common.beans.JsonMapper;
import cn.shengrui.common.beans.JsonResult;
import cn.shengrui.common.beans.PageInfo;
import cn.shengrui.common.beans.PageQuery;
import cn.shengrui.common.constant.SysStatus;
import cn.shengrui.common.util.HttpContextUtils;
import cn.shengrui.common.util.IpUtil;
import cn.shengrui.param.AclParam;
import cn.shengrui.param.AclSearch;
import cn.shengrui.system.entity.SysAcl;
import cn.shengrui.system.mapper.SysAclMapper;
import cn.shengrui.system.service.SysAclService;
import cn.shengrui.system.shiro.ShiroUtils;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @ClassName SysAclServiceImpl
 * @Description TODO
 * @Date 2018/10/22 13:53
 * @Author itastro
 * @Version 1.0
 **/
@Slf4j
@Service
@Transactional
public class SysAclServiceImpl implements SysAclService {

    @Autowired
    private SysAclMapper sysAclMapper;

    public HttpServletRequest getRequest() {
        return HttpContextUtils.getHttpServletRequest();
    }

    @Override
    public JsonResult save(AclParam aclParam) {
        log.info("aclParam:{}", JsonMapper.obj2String(aclParam));

        if (checkExist(aclParam.getId(), aclParam.getKeyword(), aclParam.getRemark())) {
            return JsonResult.fail("此权限已经存在", null);
        }
        SysAcl sysAcl = SysAcl.builder().keyword(aclParam.getKeyword()).name(aclParam.getName()).remark(aclParam.getRemark()).build();

        sysAcl.setOperateIp(IpUtil.getUserIP(getRequest()));
        sysAcl.setOperateTime(new Date());
        sysAcl.setOperator(ShiroUtils.getUserName());
        sysAcl.setSeq(1);
        sysAcl.setType(1);
        sysAcl.setStatus(SysStatus.USE);

        sysAclMapper.insert(sysAcl);

        return JsonResult.success("添加成功", sysAcl);
    }

    @Override
    public JsonResult update(AclParam aclParam) {

        if (checkExist(aclParam.getId(), aclParam.getKeyword(), aclParam.getRemark())) {
            return JsonResult.fail("此权限已经存在", null);
        }
        SysAcl sysAcl = sysAclMapper.selectByPrimaryKey(aclParam.getId());
        if (sysAcl == null) {
            return JsonResult.fail("待更新的不存在", null);
        }
        sysAcl = SysAcl.builder().keyword(aclParam.getKeyword()).name(aclParam.getName()).remark(aclParam.getRemark()).build();
        sysAclMapper.updateByPrimaryKey(sysAcl);
        return JsonResult.success("更新成功", null);
    }

    @Override
    public JsonResult delete(List<Integer> list) {

        for (Integer id : list) {
            sysAclMapper.updateDelete(id);
        }
        return JsonResult.success("更新成功", null);
    }

    @Override
    public JsonResult pageQuery(PageQuery pageQuery, AclSearch aclSearch) {

        PageHelper.startPage(pageQuery.getPageNo(), pageQuery.getSize());
        List<SysAcl> list = sysAclMapper.pageQuery(aclSearch);

        PageInfo<SysAcl> result = new PageInfo<>(list);

        return JsonResult.success("查询成功", result);
    }

    private boolean checkExist(Integer aclId, String keyWord, String name) {

        return sysAclMapper.countByAclIdAndKeywordAndName(aclId, keyWord, name) > 0;

    }
}
