package cn.shengrui.management.service.impl;

import cn.shengrui.common.beans.JsonResult;
import cn.shengrui.common.beans.PageInfo;
import cn.shengrui.common.beans.PageQuery;
import cn.shengrui.common.enums.ResultEnum;
import cn.shengrui.common.exception.PermissionException;
import cn.shengrui.management.entity.TaskLog;
import cn.shengrui.management.mapper.TaskLogMapper;
import cn.shengrui.management.service.TaskLogService;
import cn.shengrui.management.service.TaskService;
import cn.shengrui.param.TaskEchartInfo;
import cn.shengrui.param.TaskEchartSearch;
import cn.shengrui.param.TaskLogSearch;
import cn.shengrui.system.shiro.ShiroUtils;
import com.github.pagehelper.PageHelper;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @ClassName TaskLogServiceImpl
 * @Description 生产日志实现类
 * @Date 2018/10/26 17:09
 * @Author itastro
 * @Version 1.0
 **/

@Service
@Transactional
public class TaskLogServiceImpl implements TaskLogService {
    @Autowired
    private HttpServletResponse httpServletResponse;
    @Autowired
    private TaskLogMapper taskLogMapper;

    @Autowired
    private TaskService taskService;


    @Override
    public JsonResult pageQuery(PageQuery pageQuery, TaskLogSearch taskLogSearch) {

        PageHelper.startPage(pageQuery.getPageNo(), pageQuery.getSize());

        List<TaskLog> list = taskLogMapper.pageQuery(taskLogSearch);

        PageInfo<TaskLog> result = new PageInfo<>(list);

        return JsonResult.success("查询成功", result);
    }

    @Override
    public JsonResult save(TaskLog taskLog) {

        if (taskLog.getResult() == 1) {
            JsonResult jsonResult = taskService.updateComplateNumber(taskLog.getTaskId());
            if (jsonResult.getCode() == 0) {
                return jsonResult;
            }
            taskService.updateStatusIng(taskLog.getTaskId());
            taskLog.setOperateTime(new Date());

            taskLog.setOperator(ShiroUtils.getUserName());
            taskLogMapper.insert(taskLog);
        } else {
            taskLog.setOperator(ShiroUtils.getUserName());
            taskLog.setOperateTime(new Date());
            taskLogMapper.insert(taskLog);
        }
        return JsonResult.success("保存成功", taskLog);
    }

    @Override
    public Object getExcel() {

        List<TaskLog> taskLogs = taskLogMapper.findAll();

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("生产日志");
        createTitle(workbook, sheet);
        //设置日期格式
        HSSFCellStyle style = workbook.createCellStyle();
        style.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));

        int rowNum = 1;
        for (TaskLog tasklog : taskLogs) {
            HSSFRow row = sheet.createRow(rowNum);

            row.createCell(0).setCellValue(rowNum);
            HSSFCell cell = row.createCell(1);
            cell.setCellValue(tasklog.getOperateTime());
            cell.setCellStyle(style);

            row.createCell(2).setCellValue(tasklog.getOperator().toString());
            row.createCell(3).setCellValue(tasklog.getProjectName().toString());
            row.createCell(4).setCellValue(tasklog.getTcuType().toString());
            row.createCell(5).setCellValue(tasklog.getTaskName().toString());

            String result = tasklog.getResult() == 1 ? "成功" : "失败";

            String batchNo = tasklog.getBatchNo() == null ? "" : "" + tasklog.getBatchNo().toString();
            row.createCell(6).setCellValue(result.toString());
            row.createCell(7).setCellValue(tasklog.getSerialNumber().toString());
            row.createCell(8).setCellValue(tasklog.getBatchNo());

            row.createCell(9).setCellValue(tasklog.getBatchNumber().toString());
            row.createCell(10).setCellValue(tasklog.getTcuCode().toString());
            row.createCell(11).setCellValue(tasklog.getSupCode().toString());
            row.createCell(12).setCellValue(tasklog.getCustomerBarcodeCount().toString());
            row.createCell(13).setCellValue(tasklog.getLabelPartsNo().toString());
            row.createCell(14).setCellValue(tasklog.getWritePartsNo().toString());
            rowNum++;
        }
        //封装excelName
        String fileName = "生产日志.xls";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String dateTime = dateFormat.format(new Date());

        fileName = dateTime + "/" + UUID.randomUUID().toString().replaceAll("-", "") + "/" + fileName;

        downLoadExcel(fileName, httpServletResponse, workbook);

        return JsonResult.success("导出成功", null);
    }

    private static void downLoadExcel(String fileName, HttpServletResponse response, Workbook workbook) {
        try {
            response.setCharacterEncoding("UTF-8");
            response.setHeader("content-Type", "application/vnd.ms-excel");
            response.setHeader("Content-Disposition",
                    "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));


            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            throw new PermissionException(ResultEnum.UNKONW_ERROR);
        }
    }

    private void createTitle(HSSFWorkbook workbook, HSSFSheet sheet) {
        HSSFRow row = sheet.createRow(0);
        //设置列宽 setColumnWidth 的第二个参数要乘以256 这个参数的单位是1/256个字宽度
        sheet.setColumnWidth(2, 12 * 256);
        sheet.setColumnWidth(3, 17 * 256);

        //设置居中加粗
        HSSFCellStyle style = workbook.createCellStyle();
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style.setFont(font);

        HSSFCell cell;
        cell = row.createCell(0);
        cell.setCellValue("序号");
        cell.setCellStyle(style);

        cell = row.createCell(1);
        cell.setCellValue("操作时间");
        cell.setCellStyle(style);

        cell = row.createCell(2);
        cell.setCellValue("操作人");
        cell.setCellStyle(style);

        cell = row.createCell(3);
        cell.setCellValue("项目名称");
        cell.setCellStyle(style);


        cell = row.createCell(4);
        cell.setCellValue("TCU型号");
        cell.setCellStyle(style);


        cell = row.createCell(5);
        cell.setCellValue("生产任务");
        cell.setCellStyle(style);

        cell = row.createCell(6);
        cell.setCellValue("刷写结果");
        cell.setCellStyle(style);


        cell = row.createCell(7);
        cell.setCellValue("流水号");
        cell.setCellStyle(style);

        cell = row.createCell(9);
        cell.setCellValue("批次数量");
        cell.setCellStyle(style);

        cell = row.createCell(10);
        cell.setCellValue("TCU代码");
        cell.setCellStyle(style);

        cell = row.createCell(11);
        cell.setCellValue("供应商代码");
        cell.setCellStyle(style);

        cell = row.createCell(12);
        cell.setCellValue("标签数量");
        cell.setCellStyle(style);

        cell = row.createCell(13);
        cell.setCellValue("标签物流号");
        cell.setCellStyle(style);

        cell = row.createCell(14);
        cell.setCellValue("写入物流号");
        cell.setCellStyle(style);

    }

    @Override
    public JsonResult flashStatistics(TaskEchartSearch taskEchartSearch) {
        TaskEchartInfo list = taskLogMapper.flashStatistics(taskEchartSearch);

        return JsonResult.success("查询成功", list);
    }
}
