package com.bailian.car.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import sun.misc.BASE64Encoder;

/**
 * 文件下载工具类
 * 
 * @创建人 bailian
 * @创建时间 2018年1月12日上午11:32:30
 * @修改人 wang
 * @修改时间 2018年1月12日上午11:32:30
 * @since JDK 1.8
 */
@SuppressWarnings("restriction")
public class DownloadUtils {

	public static String getFileName(String fileName, String agent) {
		BASE64Encoder base64Encoder = new BASE64Encoder();
		if (agent.contains("Firefox")) {
			try {
				return "=?UTF-8?B?" + new String(base64Encoder.encode(fileName.getBytes("UTF-8"))) + "?=";
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			// IE或者其他的浏览器
			try {
				fileName = URLEncoder.encode(fileName, "UTF-8");
				fileName = fileName.replace("+", "");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return fileName;
	}
}