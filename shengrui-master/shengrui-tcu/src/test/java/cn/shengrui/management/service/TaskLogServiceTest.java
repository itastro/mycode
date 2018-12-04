package cn.shengrui.management.service;

import cn.shengrui.common.beans.JsonMapper;
import cn.shengrui.common.beans.JsonResult;
import cn.shengrui.management.entity.TaskLog;
import cn.shengrui.param.TaskEchartInfo;
import cn.shengrui.param.TaskEchartSearch;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName
 * @Description TODO
 * @Date 2018/11/15 13:07
 * @Author itastro
 * @Version 1.0
 **/

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class TaskLogServiceTest {


    @Autowired
    private TaskLogService taskLogService;

    @Test
    public void test() {

        TaskLog taskLog = new TaskLog();
        taskLog.setTaskId(42);
        taskLog.setOperateTime(new Date());
        taskLog.setProjectName("ssss");
        taskLog.setTcuType("1111");
        taskLog.setTaskName("aaa");
        taskLog.setResult(1);
        taskLog.setSerialNumber("111111");
        taskLog.setBatchNumber(111);
        taskLog.setSupCode("111");
        taskLog.setReason("www");
        taskLog.setCalibrationFileName("1111");
        taskLog.setSrPrintScript("1111");
        taskLog.setAutomakerPrintScript("1111");
        taskLog.setBatchNo("11111");
        taskLog.setTcuCode("111111");
        for (int i = 0; i < 3; i++) {
            JsonResult jsonResult = taskLogService.save(taskLog);
            log.info("jsonResult:{}", JsonMapper.obj2String(jsonResult.getMsg()) + "" + i);
        }

    }

    @Test
    public void test2() throws Exception {


        TaskEchartSearch taskEchartSearch = new TaskEchartSearch();

        String s = "2018-10-23 12:12:12";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse(s);
        taskEchartSearch.setStartTime(date);
        taskEchartSearch.setEndTime(new Date());
        JsonResult jsonResult = taskLogService.flashStatistics(taskEchartSearch);

        log.info("jsonResult:{}", JsonMapper.obj2String(jsonResult));

    }
}
