package com.bailian.car.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.bailian.car.exception.PermissionException;

public class GpsUtil {

	public static void main(String[] args) throws Throwable {
		long start = System.currentTimeMillis();
		GpsUtil.read();
		long end = System.currentTimeMillis();
		System.out.println((end - start) / 1000);

	}

	public static void read() throws IOException, ParseException {
		File[] files = null;
		ArrayList<String> list = new ArrayList<>();
		Date date = null;
		Date date2 = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		date = simpleDateFormat.parse("2018-07-13 09:11:03");
		date2 = simpleDateFormat.parse("2018-08-18 09:12:35");

		Date newDate = new Date();
		long start = date.getTime();
		long end = date2.getTime();
		String format = "2018-07-13 09:11:03";

		File f = new File("d:/gpsdata/CASH0000000000001/way");
		// 读文件夹 判断是文件还是文件夹
		if (!f.exists() && f.isDirectory()) {
			throw new PermissionException("不是文件夹/文件不存在");
		}
		// 判断文件夹是否存在
		if (f.exists()) {
			// 判断文件夹是否为空
			if (!f.equals(null)) {
				// 判断是否是文件夹 是就打开
				if (f.isDirectory()) {
					files = f.listFiles();
					for (File file : files) {
						String name = file.getName();
						String string = GpsUtil.getFileName(new Date(), "CASHDH00000000007");
						if (name.contains(string)) {
							BufferedReader br = new BufferedReader(new FileReader(file));
							String tempString = null;
							int line = 1;
							// 一次读入一行，直到读入null为文件结束
							while ((tempString = br.readLine()) != null) {

								// System.out.println("line " + line + ": " + tempString);
								// 显示行号
								if (tempString.contains(format)) {
									System.out.println("line " + line + ": " + tempString);
									list.add(tempString);
									start = start + 1000;
									newDate.setTime(start);
									format = simpleDateFormat.format(newDate);

									if (end - start < 0) {
										break;
									}
								}
								line++;
							}
							br.close();
						}
					}
				}
			}
		}

		if (end - start > 0) {
			files = f.listFiles();
			for (File file : files) {
				String name = file.getName();
				String string = GpsUtil.getFileName(date2, "CASHDH00000000007");
				if (name.contains(string)) {
					BufferedReader br = new BufferedReader(new FileReader(file));
					String tempString = null;
					int line = 1;
					// 一次读入一行，直到读入null为文件结束
					while ((tempString = br.readLine()) != null) {

						// System.out.println("line " + line + ": " + tempString);
						// 显示行号
						if (tempString.contains(format)) {
							System.out.println("line " + line + ": " + tempString);
							list.add(tempString);
							start = start + 1000;
							newDate.setTime(start);
							format = simpleDateFormat.format(newDate);
						} else {
							while (!tempString.contains(format)) {
								start = start + 1000;
								newDate.setTime(start);
								format = simpleDateFormat.format(newDate);
								if (format.equals("2018-08-12 20:57:26")) {
									break;
								}
								System.err.println(format);
							}
						}
						line++;
					}
					br.close();
				}
			}
		}
	}

	// 根据时间以及终端号拼接一个字符串
	public static String getFileName(Date date, String gps) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		String s = sdf.format(date);

		String fname = s + "-" + gps;
		return fname;

	}

}
