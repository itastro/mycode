package cn.shengrui.management.service;

import cn.shengrui.common.beans.JsonMapper;
import cn.shengrui.common.beans.JsonResult;
import cn.shengrui.common.beans.PageQuery;
import cn.shengrui.management.entity.TTask;
import cn.shengrui.management.entity.TaskLog;
import cn.shengrui.param.TaskParam;
import cn.shengrui.param.TaskSearch;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class TaskServiceTest {


    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskLogService taskLogService;

    @Test
    public void save() throws Exception {
        TaskParam taskParam = new TaskParam();

        taskParam.setName("哈哈");
        taskParam.setProjectId(11);
        taskParam.setBatchNo("11");
        taskParam.setBatchNumber(1000);
        taskParam.setProducedTime(new Date());
        taskParam.setSerialNumber(0);

        JsonResult jsonResult = taskService.save(taskParam);
        log.info("jsonResult:{}", JsonMapper.obj2String(taskParam));
    }

    @Test
    public void delete() throws Exception {
    }

    @Test
    public void pageQuery() throws Exception {

        PageQuery pageQuery = new PageQuery();
        TaskSearch search = new TaskSearch();

        JsonResult jsonResult = taskService.getCurrentTask();
        log.info("jsonResult:{}", JsonMapper.obj2String(jsonResult));

    }

    @Test
    public void cancleTask() throws Exception {
    }

    @Test
    public void regainTask() throws Exception {
    }

    @Test
    public void update() throws Exception {

      JsonResult jsonResult= taskService.getCurrentTask();
      log.info("jsonResult",JsonMapper.obj2String(jsonResult.getData()));


    }

    @Test
    public void checkExist() throws Exception {
    }

}