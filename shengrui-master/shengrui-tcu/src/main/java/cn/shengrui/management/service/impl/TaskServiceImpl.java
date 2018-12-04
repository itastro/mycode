package cn.shengrui.management.service.impl;
import cn.shengrui.common.beans.JsonResult;
import cn.shengrui.common.beans.PageInfo;
import cn.shengrui.common.beans.PageQuery;
import cn.shengrui.common.constant.SysStatus;
import cn.shengrui.common.util.IpUtil;
import cn.shengrui.management.entity.TFile;
import cn.shengrui.management.entity.TTask;
import cn.shengrui.management.entity.TTcu;
import cn.shengrui.management.mapper.TFileMapper;
import cn.shengrui.management.mapper.TTaskMapper;
import cn.shengrui.management.mapper.TTcuMapper;
import cn.shengrui.param.TaskInfo;
import cn.shengrui.param.TaskParam;
import cn.shengrui.param.TaskSearch;
import cn.shengrui.management.service.TaskService;
import cn.shengrui.system.shiro.ShiroUtils;
import com.github.pagehelper.PageHelper;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @ClassName TaskServiceImpl
 * @Description TODO
 * @Date 2018/10/15 17:24
 * @Author itastro
 * @Version 1.0
 **/
@Service
@Transactional
public class TaskServiceImpl implements TaskService {

  private final static Logger LOGGER = LoggerFactory.getLogger(TaskServiceImpl.class);
  @Autowired
  private HttpServletRequest request;

  @Autowired
  private TTaskMapper tTaskMapper;

  @Autowired
  private TFileMapper tFileMapper;

  @Autowired
  private TTcuMapper tcuMapper;

  /**
   * 更新完成数量
   */
  @Override
  public JsonResult updateComplateNumber(Integer id) {

    TTask tTask = tTaskMapper.selectByPrimaryKey(id);
    Integer num = tTask.getFinishNumber();

    if (num.equals(tTask.getBatchNumber())) {
      tTask.setStatus(SysStatus.COMPLATE);
      tTaskMapper.updateByPrimaryKeySelective(tTask);
      return JsonResult.fail("本批次完成", null);
    }
    if (num.equals(tTask.getBatchNumber())) {
      tTaskMapper.updateByPrimaryKeySelective(tTask);
      return JsonResult.fail("本批次完成", null);
    }
    tTask.setFinishNumber(num + 1);

    if (num.equals(tTask.getBatchNumber())) {
      tTask.setStatus(SysStatus.COMPLATE);
      tTaskMapper.updateByPrimaryKeySelective(tTask);
      return JsonResult.fail("本批次完成", null);
    }
    tTaskMapper.updateByPrimaryKeySelective(tTask);
    return JsonResult.success("成功", null);
  }

  /**
   * 更新任务状态为进行
   */
  @Override
  public void updateStatusIng(Integer taskId) {
    tTaskMapper.updateStatusIng(taskId);
  }

  /**
   * 更新任务状态为等待
   */
  @Override
  public void updateAllStatusIngToWait() {
    tTaskMapper.updateAllStatusIngToWait();

  }

  /**
   * 任务创建
   */
  @Override
  public JsonResult save(TaskParam taskParam) {

    //创建任务
    TTask tTask = TTask.builder().projectId(taskParam.getProjectId())
        .producedTime(taskParam.getProducedTime()).batchNo(taskParam.getBatchNo())
        .batchNumber(taskParam.getBatchNumber()).serialNumber(taskParam.getSerialNumber())
        .name(taskParam.getName()).tcuSoftwareNo(taskParam.getTcuSoftwareNo()).build();
    //补全字段
    tTask.setStatus(SysStatus.WAIT);
    tTask.setCateateTime(new Date());
    tTask.setUpdateTime(new Date());
    tTask.setOperateIp(IpUtil.getUserIP(request));
    tTask.setSerialNumber(0);
    tTask.setFinishNumber(0);
    tTask.setStatus(SysStatus.WAIT);
    tTask.setOperator(ShiroUtils.getUserName());
    //保存
    tTaskMapper.insert(tTask);
    return JsonResult.success("任务保存成功", tTask);
  }


  /**
   * 删除任务
   */
  @Override
  public JsonResult delete(List<Integer> ids) {

    if (CollectionUtils.isEmpty(ids)) {
      return JsonResult.fail("请选择任务", null);
    }
    for (Integer id : ids) {
      TTask tTask = tTaskMapper.selectByPrimaryKey(id);
      if (tTask != null) {
        if (tTask.getStatus() == 1 || tTask.getStatus() == 2 || tTask.getStatus() == 3) {
          continue;
        }
        if (isCurrentDayTask(tTask.getId())) {
          continue;
        }
        tTask.setStatus(SysStatus.DELETE);
        tTaskMapper.updateByPrimaryKey(tTask);
        tTaskMapper.deleteByPrimaryKey(id);
      }
    }
    return JsonResult.success("生产任务删除成功", ids);
  }

  @Override
  public JsonResult pageQuery(PageQuery pageQuery, TaskSearch taskSearch) {

    PageHelper.startPage(pageQuery.getPageNo(), pageQuery.getSize());

    List<TaskInfo> page = tTaskMapper.pageQuery(taskSearch);
    PageInfo<TaskInfo> result = new PageInfo<TaskInfo>(page);
    return JsonResult.success("查询成功", result);
  }


  /**
   * 获取当前的任务
   */
  @Override
  public JsonResult getCurrentTask() {
    TaskInfo taskInfo = tTaskMapper.getCurrentTask();
    updateAllStatusIngToWait();
    Integer taskId = tTaskMapper.getCurrentTaskOne();
    tTaskMapper.updateStatusIng(taskId);
    Integer tcuid = taskInfo.getTcuId();
    TTcu tTcu = tcuMapper.selectByPrimaryKey(tcuid);

    TFile tFile = tFileMapper.selectByPrimaryKey(tTcu.getFileId());

    taskInfo.setBfcUrl(tFile.getUrl());
    List<TaskInfo> list = new ArrayList<TaskInfo>(10);
    list.add(taskInfo);
    return JsonResult.success("查询成功", list);
  }


  /***
   * 任务挂起
   * @param ids
   * @return
   */
  @Override
  public JsonResult CancleTask(List<Integer> ids) {
    if (CollectionUtils.isEmpty(ids)) {
      return JsonResult.fail("请选择任务", null);
    }
    for (Integer id : ids) {
      TTask tTask = tTaskMapper.selectByPrimaryKey(id);
      if (tTask != null) {
        if (tTask.getStatus() != 1) {
          continue;
        }
        tTask.setStatus(SysStatus.CANCLE);
        tTaskMapper.updateByPrimaryKey(tTask);
      }
    }
    return JsonResult.success("生产任务挂起成功", ids);
  }

  /**
   * 任务重置
   */
  @Override
  public JsonResult restTask(List<Integer> ids) {
    if (CollectionUtils.isEmpty(ids)) {
      return JsonResult.fail("请选择任务", null);
    }
    for (Integer id : ids) {
      TTask tTask = tTaskMapper.selectByPrimaryKey(id);
      if (tTask != null) {
        tTask.setStatus(SysStatus.WAIT);
        tTaskMapper.updateByPrimaryKeySelective(tTask);
      }
    }
    return JsonResult.success("生产任务恢复成功", ids);
  }

  /**
   * 任务更新
   */
  @Override
  public JsonResult update(TaskParam taskParam) {

    String sherngruiname = "";
    String customername = "";
    //判断这个任务是否存在
    //判断待更新的任务是否存在

    TTask tTask = tTaskMapper.selectByPrimaryKey(taskParam.getId());

    if (tTask == null) {
      return JsonResult.fail("你需要更新的任务不存在", taskParam);
    }
    if (tTask.getStatus() != 4) {
      return JsonResult.fail("此任务不允许修改", taskParam);
    }

    if (isCurrentDayTask(taskParam.getId())) {
      return JsonResult.fail("当天的任务不允许修改", taskParam);
    }

    //创建任务
    tTask = TTask.builder().projectId(taskParam.getProjectId())
        .producedTime(taskParam.getProducedTime()).batchNo(taskParam.getBatchNo())
        .batchNumber(taskParam.getBatchNumber()).serialNumber(taskParam.getSerialNumber())
        .id(taskParam.getId()).tcuSoftwareNo(taskParam.getTcuSoftwareNo()).build();

    //补全字段
    tTask.setUpdateTime(new Date());
    tTask.setOperateIp(IpUtil.getUserIP(request));
    //TODO
    tTask.setOperator(ShiroUtils.getUserName());
    //保存
    tTaskMapper.updateByPrimaryKeySelective(tTask);
    return JsonResult.success("任务保存成功", tTask);

  }

  /**
   * 判断此任务是不是当天的
   */
  public boolean isCurrentDayTask(Integer id) {

    List<Integer> ids = tTaskMapper.selectCurrentDayTask();
    if (ids.contains(id)) {
      return true;
    }
    return false;
  }

  @Override
  public boolean checkExist(String name, Integer companyid, Integer projectid) {
    return false;
  }


}
