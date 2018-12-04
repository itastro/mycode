package com.bailian.car.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.web.multipart.MultipartFile;

import com.bailian.car.exception.PermissionException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExcelUtils {

	private final static String xls = "xls";
	private final static String xlsx = "xlsx";

	private static boolean flag = false;

	public static boolean getCode(Row row, int i) {

		if ((row.getCell(0) == null || row.getCell(i).toString().equals("")
				|| !Pattern.matches("^[\\u0391-\\uFFE5\\w\\s\\·]+", row.getCell(i).toString().trim()))) {

			return flag;
		}
		return flag = true;

	}

	/**
	 * 
	    * @Title: isExcel
	    * @Description: 判断是是不死excel 文件
	    * @param @param filePath
	    * @param @return    参数
	    * @return boolean    返回类型
	    * @throws
	 */
	public static boolean isExcel(String filePath) {
		if (filePath.matches("^.+\\.(?i)(xls)$") || filePath.matches("^.+\\.(?i)(xlsx)$")) {
			return true;
		}
		return false;
	}

	/** 
	* 检查文件是否存在 
	*/
	public static boolean fileExist(String filePath) {
		if (filePath == null || filePath.trim().equals(""))
			return false;
		File file = new File(filePath);
		if (file == null || !file.exists()) {
			return false;
		}
		return true;
	}

	/**
	* 依据内容判断是否为excel2003及以下
	*/
	public static boolean isExcel2003(String filePath) {
		try {
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));
			if (POIFSFileSystem.hasPOIFSHeader(bis)) {
				System.out.println("Excel版本为excel2003及以下");
				return true;
			}
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	/**
	* 依据内容判断是否为excel2007及以上
	*/
	public static boolean isExcel2007(String filePath) {
		try {
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));
			/*
			 * if (POIXMLDocument.hasOXMLHeader(bis)) {
			 * System.out.println("Excel版本为excel2007及以上"); return true; }
			 */
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	// 判断是不是excel文件
	public static void checkFile(MultipartFile file) {
		// 判断文件是否存在
		if (file == null) {
			log.error("文件不存在");
			throw new PermissionException("文件不存在");
		}
		// 获取文件名
		String filename = file.getOriginalFilename();
		// 判断文件是不是excel文件
		if (!filename.endsWith(xls) && !filename.endsWith(xlsx)) {
			log.error(filename + "不是excel文件");
			throw new PermissionException(filename + "不是excel文件");

		}
	}

	// 创建workbook

	public static Workbook getWorkBook(MultipartFile file)
			throws IOException, IllegalStateException, InvalidFormatException {
		// 获取文件名
		// String filename = file.getOriginalFilename();
		InputStream excel = file.getInputStream();
		// 创建wwrok对象
		Workbook book = WorkbookFactory.create(excel);
		return book;
	}

	// 获取单元格
	@SuppressWarnings("deprecation")
	public static String getCellValue(Cell cell) {

		// DecimalFormat df = new DecimalFormat("#");
		String cellValue = "";
		if (cell == null) {
			return "";
		}
		// 判断数据的类型
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_NUMERIC:

			if (HSSFDateUtil.isCellDateFormatted(cell)) {
				Date d = cell.getDateCellValue();
				DateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				cellValue = formater.format(d);
			} else { // 用于格式化数字，只保留数字的整数部分
				DecimalFormat df = new DecimalFormat("########");
				cellValue = df.format(cell.getNumericCellValue());
			}
			break;

		case Cell.CELL_TYPE_STRING:
			cellValue = cell.getStringCellValue();
			break;

		case Cell.CELL_TYPE_BOOLEAN:
			cellValue = String.valueOf(cell.getBooleanCellValue());

			break;
		case Cell.CELL_TYPE_FORMULA:
			cellValue = String.valueOf(cell.getCellFormula());
			break;
		case Cell.CELL_TYPE_ERROR:
			cellValue = "非法字符";
			break;
		default:
			cellValue = "";
			break;
		}
		return cellValue;
	}

	/**
	 * @throws InvalidFormatException 
	 * @throws IllegalStateException 
	 * @throws IOException 
	 * 
	 * @Title: readExcel
	 * @Description:读入excel 解析后返回
	 * @param @param file
	 * @param @return    参数
	 * @return List<String[]>    返回类型
	 * @throws
	 */
	public static List<String[]> readExcel(MultipartFile file) {

		// 检查文件
		checkFile(file);
		// 获取workBook工作对象
		Workbook workBook = null;
		try {
			workBook = getWorkBook(file);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 创建返回对象
		List<String[]> list = new ArrayList<String[]>();

		if (workBook != null) {
			for (int sheetNum = 0; sheetNum < workBook.getNumberOfSheets(); sheetNum++) {
				// 获取当前的sheet工作表
				Sheet sheet = workBook.getSheetAt(sheetNum);
				if (sheet == null) {
					continue;
				}
				// 获得当前sheet的开始
				int firstRowNum = sheet.getFirstRowNum();
				// 获得sheet的结束行
				int lastRowNum = sheet.getLastRowNum();
				// 循环第一行的所有列
				int firstColum = 0;
				for (int rowNum = firstRowNum; rowNum <= lastRowNum; rowNum++) {
					// 获取当前行
					Row row = sheet.getRow(rowNum);
					if (row == null) {
						continue;
					}
					// 获取当前行的开始列
					int firstCellNum = 0;
					// 获取当前行的列数
					int lastCellNum = row.getPhysicalNumberOfCells();
					if (rowNum == firstRowNum) {
						firstColum = lastCellNum;
					}
					String[] cells = new String[firstColum];
					// 循环当前行
					for (int cellNum = firstCellNum; cellNum < firstColum; cellNum++) {
						Cell cell = row.getCell(cellNum);
						cells[cellNum] = getCellValue(cell);

					}
					list.add(cells);

				}
			}
			try {
				workBook.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return list;

	}

}
