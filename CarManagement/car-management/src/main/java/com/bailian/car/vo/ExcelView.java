package com.bailian.car.vo;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.bailian.car.exception.CustomException;
import com.bailian.car.interfaces.ExcelExportService;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExcelView extends AbstractXlsView {
	// 文件名
	private String fileName = null;
	// 导出视图自定义接口
	private ExcelExportService excelExportService = null;

	// 构造方法一
	public ExcelView(ExcelExportService excelExportService) {
		super();
		this.excelExportService = excelExportService;
	}

	// 构造方法2
	public ExcelView(String fileName, ExcelExportService excelExportService) {
		super();
		this.fileName = fileName;
		this.excelExportService = excelExportService;
	}

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		// 没有自定义接口
		if (excelExportService == null) {
			throw new CustomException("导出服务名不能为null");
		}
		// 文件名不能为空，为空则使用请求路径中的字符串作为中文名
		if (!StringUtils.isEmpty(fileName)) {
			// 进行字符串转换
			String characterEncoding = request.getCharacterEncoding();
			characterEncoding = characterEncoding == null ? "UTF-8" : characterEncoding;
			fileName = new String(fileName.getBytes(characterEncoding), "ISO8859-1");
			// 设置下面文件名
			response.setHeader("Content-disposition", "attachment:filename" + fileName);
		}
		// 回到接口方法，使用自定义excel文档
		excelExportService.makeWorkBook(model, workbook);

	}

}
