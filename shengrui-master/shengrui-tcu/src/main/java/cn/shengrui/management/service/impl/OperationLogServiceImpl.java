package cn.shengrui.management.service.impl;

import cn.shengrui.common.beans.JsonResult;
import cn.shengrui.common.beans.PageInfo;
import cn.shengrui.common.beans.PageQuery;
import cn.shengrui.common.enums.ResultEnum;
import cn.shengrui.common.exception.PermissionException;
import cn.shengrui.management.entity.TOperationLog;
import cn.shengrui.management.mapper.TOperationLogMapper;
import cn.shengrui.param.OperationLogSearch;
import cn.shengrui.management.service.OperationLogService;
import com.github.pagehelper.PageHelper;
import org.apache.commons.collections.CollectionUtils;
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
 * @ClassName OperationLogServiceImpl
 * @Description TODO
 * @Date 2018/10/16 13:24
 * @Author itastro
 * @Version 1.0
 **/
@Service
@Transactional
public class OperationLogServiceImpl implements OperationLogService {

    @Autowired
    private TOperationLogMapper operationLogMapper;


    @Autowired
    private HttpServletResponse httpServletResponse;

    @Override
    public void save(TOperationLog operationLog) {

        operationLogMapper.insert(operationLog);

    }

    @Override
    public JsonResult delete(List<Integer> list) {

        if (CollectionUtils.isEmpty(list)) {
            return JsonResult.fail("请选择需要删除的操作日志");
        }
        for (Integer id : list) {

            operationLogMapper.deleteByPrimaryKey(id);
        }
        return JsonResult.success("删除成功", list);
    }

    @Override
    public JsonResult pageQuery(PageQuery pageQuery, OperationLogSearch operationLogSearch) {

        PageHelper.startPage(pageQuery.getPageNo(), pageQuery.getSize());

        List<TOperationLog> list = operationLogMapper.pageQuery(operationLogSearch);

        PageInfo<TOperationLog> result = new PageInfo<>(list);
        return JsonResult.success("查询成功", result);
    }

    @Override
    public Object getExcel() {

        PageQuery pageQuery = new PageQuery();
        OperationLogSearch operationLogSearch = new OperationLogSearch();
        HSSFWorkbook workbook = new HSSFWorkbook();

        HSSFSheet sheet = workbook.createSheet("操作日期表");
        createTitle(workbook, sheet);

        List<TOperationLog> list = operationLogMapper.pageQuery(operationLogSearch);


        //设置日期格式
        HSSFCellStyle style = workbook.createCellStyle();
        style.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));
        //新增单元格 并且设置单元格数据
        int rowNum = 1;
        for (TOperationLog tOperationLog : list) {

            HSSFRow row = sheet.createRow(rowNum);
            row.createCell(0).setCellValue(rowNum);
            row.createCell(1).setCellValue(tOperationLog.getOperator().toString());
            row.createCell(2).setCellValue(tOperationLog.getAction().toString());
            HSSFCell cell = row.createCell(3);
            cell.setCellValue(tOperationLog.getOperateTime());
            cell.setCellStyle(style);
            rowNum++;
        }
        //封装excelName
        String fileName = "操作日志.xls";
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
        cell.setCellValue("操作人");
        cell.setCellStyle(style);

        cell = row.createCell(2);
        cell.setCellValue("执行动作");
        cell.setCellStyle(style);

        cell = row.createCell(3);
        cell.setCellValue("操作日期");
        cell.setCellStyle(style);

    }


}
