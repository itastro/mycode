package cn.shengrui.management.service.impl;
import cn.shengrui.common.beans.JsonResult;
import cn.shengrui.common.constant.SysStatus;
import cn.shengrui.management.entity.*;
import cn.shengrui.management.mapper.TFileMapper;
import cn.shengrui.management.mapper.TProjectMapper;
import cn.shengrui.management.mapper.TProjectTcuFileMapper;
import cn.shengrui.management.mapper.TTcuMapper;
import cn.shengrui.param.ProjectDetails;
import cn.shengrui.param.ProjectTcuFileParam;
import cn.shengrui.management.service.ProjectTcuFileCoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName ProjectTcuFileCoreServiceImpl
 * @Description TODO
 * @Date 2018/10/18 16:48
 * @Author itastro
 * @Version 1.0
 **/

@Service
@Transactional
public class ProjectTcuFileCoreServiceImpl implements ProjectTcuFileCoreService {


    @Autowired
    private TTcuMapper tTcuMapper;

    @Autowired
    private TFileMapper tFileMapper;

    @Autowired
    private TProjectMapper tProjectMapper;

    @Autowired
    private TProjectTcuFileMapper tProjectTcuFileMapper;


    /**
     * 查询项目的TCU详情
     *
     * @param id
     * @return
     */
    @Override
    public JsonResult getProjectDetails(Integer id) {

        if (id == null) {
            return JsonResult.fail("请选择项目", id);
        }
        List<ProjectDetails> list = tProjectTcuFileMapper.getProjectDetails(id);
        return JsonResult.success("查询成功", list);
    }

    @Override
    public JsonResult associate(ProjectTcuFileParam projectTcuFileParam) {

        //检查项目是否存在
        TProject tProject = tProjectMapper.selectByPrimaryKey(projectTcuFileParam.getPId());


        if (tProject == null) {
            return JsonResult.fail("此项目不存在", tProject);
        }
        if (SysStatus.DELETE.equals(tProject.getStatus())) {
            return JsonResult.fail("此项目已经被删除", tProject);
        }
        //查询这个TCU 是否存在
        TTcu tTcu = tTcuMapper.selectByPrimaryKey(projectTcuFileParam.getTId());

        if (tTcu == null) {
            return JsonResult.fail("此TCU不存在", projectTcuFileParam.getTId());
        }
        if (SysStatus.DELETE.equals(tTcu.getStatus())) {
            return JsonResult.success("此TCU被删除", null);
        }
        //查询这个文件是否存在
        TFile tFile = tFileMapper.selectByPrimaryKey(projectTcuFileParam.getFId());

        if (tFile == null) {
            return JsonResult.fail("此标定文件不存在", tFile);
        }
        if (SysStatus.DELETE.equals(tFile.getId())) {
            return JsonResult.fail("此标定文件被删除", tFile);
        }

        if (checkExist(projectTcuFileParam)) {
            return JsonResult.fail("已经存在", null);
        }


      /*  tTcu.setFileId(projectTcuFileParam.getFId());

        tTcuMapper.updateByPrimaryKeySelective(tTcu);*/

        TProjectTcuFile tProjectTcuFile = TProjectTcuFile.builder().fileId(projectTcuFileParam.getFId()).projectId(projectTcuFileParam.getPId()).tcuId(projectTcuFileParam.getTId()).status(projectTcuFileParam.getStatus()).build();

        List<Integer> ptfIds = tProjectTcuFileMapper.findByProjectId(projectTcuFileParam.getPId());
        for (Integer id : ptfIds) {
            tProjectTcuFileMapper.updateStatus(id);
        }
        tProjectMapper.updateTcuId(projectTcuFileParam.getPId());

        tProjectTcuFileMapper.insert(tProjectTcuFile);
        if (projectTcuFileParam.getStatus().equals(SysStatus.USE)) {
            TProject project = tProjectMapper.selectByPrimaryKey(projectTcuFileParam.getPId());
            project.setTcuId(projectTcuFileParam.getTId());
            tProjectMapper.updateByPrimaryKey(project);
        }

        return JsonResult.success("项目分配TCU成功", projectTcuFileParam);
    }


    /**
     * 校验是否存在
     *
     * @param projectTcuFileParam
     * @return
     */
    public boolean checkExist(ProjectTcuFileParam projectTcuFileParam) {

        TProjectTcuFileExample tProjectTcuFileExample = new TProjectTcuFileExample();

        TProjectTcuFileExample.Criteria criteria = tProjectTcuFileExample.createCriteria();

        if (projectTcuFileParam.getPtfId() != null) {
            criteria.andIdEqualTo(projectTcuFileParam.getPtfId());
        }

        if (projectTcuFileParam.getTId() != null) {

            criteria.andTcuIdEqualTo(projectTcuFileParam.getTId());
        }

        if (projectTcuFileParam.getFId() != null) {
            criteria.andFileIdEqualTo(projectTcuFileParam.getFId());
        }

        if (projectTcuFileParam.getPId() != null) {
            criteria.andProjectIdEqualTo(projectTcuFileParam.getPId());
        }
        return tProjectTcuFileMapper.countByExample(tProjectTcuFileExample) > 0;
    }

    @Override
    public JsonResult disable(Integer pid, Integer ptfId) {

        TProject project = tProjectMapper.selectByPrimaryKey(pid);
        TProjectTcuFile tProjectTcuFile = tProjectTcuFileMapper.selectByPrimaryKey(ptfId);
        if (tProjectTcuFile.getTcuId().equals(project.getTcuId())) {
            project.setTcuId(null);
            tProjectMapper.updateByPrimaryKey(project);
        }
        tProjectTcuFile.setStatus(SysStatus.DELETE);
        tProjectTcuFileMapper.updateByPrimaryKey(tProjectTcuFile);
        return JsonResult.success("禁用成功", tProjectTcuFile);
    }

    @Override
    public JsonResult enable(Integer pid, Integer ptfId) {

        //查询这个项目的所有关联
        List<Integer> ptfIds = tProjectTcuFileMapper.findByProjectId(pid);
        //装填置为禁用
        for (Integer id : ptfIds) {
            tProjectTcuFileMapper.updateStatus(id);
        }
        //查询项目
        TProject project = tProjectMapper.selectByPrimaryKey(pid);
        TProjectTcuFile tProjectTcuFile = tProjectTcuFileMapper.selectByPrimaryKey(ptfId);

        //判断TCU id是否一样
        if (tProjectTcuFile.getTcuId().equals(project.getTcuId())) {
            project.setTcuId(tProjectTcuFile.getTcuId());
            tProjectMapper.updateByPrimaryKey(project);
        }

        //状态置为使用
        tProjectTcuFile.setStatus(SysStatus.USE);
        tProjectTcuFileMapper.updateByPrimaryKey(tProjectTcuFile);
       /* 把 文件id更新到tcu上面
        TTcu tTcu = tTcuMapper.selectByPrimaryKey(tProjectTcuFile.getTcuId());
        tTcu.setFileId(tProjectTcuFile.getFileId());
        tTcuMapper.updateByPrimaryKeySelective(tTcu);*/

        project.setTcuId(tProjectTcuFile.getTcuId());
        tProjectMapper.updateByPrimaryKey(project);
        return JsonResult.success("启用成功", tProjectTcuFile);
    }

    @Override
    public JsonResult delete(List<Integer> list) {
        for (Integer id : list) {
            TProjectTcuFile tProjectTcuFile = tProjectTcuFileMapper.selectByPrimaryKey(id);
            TProject project = tProjectMapper.selectByPrimaryKey(tProjectTcuFile.getProjectId());
            if (tProjectTcuFile.getTcuId().equals(project.getTcuId())) {
                project.setTcuId(null);
                tProjectMapper.updateByPrimaryKey(project);
            }
            tProjectTcuFileMapper.deleteByPrimaryKey(id);
        }
        return JsonResult.success("删除成功", null);
    }
}
