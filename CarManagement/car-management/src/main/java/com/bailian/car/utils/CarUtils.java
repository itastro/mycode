package com.bailian.car.utils;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.bailian.car.domain.cars.car.Car;
import com.bailian.car.exception.ParamException;

public class CarUtils {

	public static final String p = "-";

	/**
	 * 
	    * @Title: getVsn
	    * @Description: 生成一个车辆编号
	    * @param  vSn  接受数据库最后一个vSn
	    * @return String   vSn
	    * @throws
	 */
	public static String getVsn(String vSn, boolean flag) {
		String sn = "";
		if (vSn == null) {
			sn = CarUtils.getStart() + CarUtils.p + "001";
			return sn;
		}

		String satrt = CarUtils.getStart();
		Object end = CarUtils.getEnd(vSn);
		String string = end.toString();
		int i = Integer.parseInt(string);

		if (flag) {

			if (i == 9) {
				return sn = satrt + CarUtils.p + "0" + (i + 1);
			}
			if (i < 10) {
				return sn = satrt + CarUtils.p + "00" + (i + 1);
			}
			if (i >= 10 & i < 99) {
				return sn = satrt + CarUtils.p + "0" + (i + 1);
			}
			if (i == 99) {
				return sn = satrt + CarUtils.p + (i + 1);
			}
			if (i >= 100) {
				return sn = satrt + CarUtils.p + (i + 1);
			}
			sn = satrt + CarUtils.p + (i + 1);

		}
		return sn;
	}

	// 获取车辆编号的前四位
	public static String getStart() {
		Date date = new Date();
		String date2String = DateUtils.Date2String(date);
		String string = date2String.substring(0, 4);
		return string;
	}

	// 回去车辆编号的后几位
	public static Object getEnd(String vSn) {
		

		String num = vSn.substring(5, 8);
		int i = Integer.parseInt(num);
		if (i < 100) {
			return num;
		}
		return i;
	}

	// 判断车辆是否有保险
	/**
	 * 
	    * @Title: getFlag
	    * @Description: 判断车联是否有保险
	    * @param @param car
	    * @param @return    参数
	    * @return boolean    返回类型
	    * @throws
	 */
	public static boolean getFlag(Car car) {

		if (car != null) {
			String no = car.getInsNo();
			if (StringUtils.isBlank(no)) {
				return false;
			}
			return true;
		}
		throw new ParamException("车辆不能为空");
	}

	// 判断车辆保险是否过期
	/**
	 * 
	    * @Title: isExpired
	    * @Description: 判断车辆保险是否过期
	    * @param @param car
	    * @param @return    参数
	    * @return boolean    返回类型
	    * @throws
	 */
	public static boolean isExpired(Car car) {

		if (car != null) {
			long endTime = car.getEndTime().getTime();
			long currentTime = new Date().getTime();
			if (currentTime - endTime > 0) {
				return false;
			}
			return true;
		}
		throw new ParamException("车辆不能为空");

	}

	// 判断有没有临时牌照
	/**
	 * 
	    * @Title: isLice
	    * @Description: 判断有没有临牌
	    * @param @param car
	    * @param @return    参数
	    * @return boolean    返回类型
	    * @throws
	 */
	public static boolean isLice(Car car) {
		if (car != null) {
			String licenseNo = car.getLicenseNo();
			if (StringUtils.isBlank(licenseNo)) {
				return false;
			}
			return true;
		}
		throw new ParamException("车辆不能为空");
	}

	// 判断临牌有效期是否超过保险有效期
	/**
	 * 
	    * @Title: isExceed
	    * @Description: 判断临牌有效期是否超过保险有效期
	    * @param @param car
	    * @param @return    参数
	    * @return boolean    返回类型
	    * @throws
	 */
	public static boolean isExceed(Car car) {
		if (car != null) {
			Date licenseEndTime = car.getLicenseEndTime();
			Date endTime = car.getEndTime();
			if (licenseEndTime.getTime() - endTime.getTime() > 0) {
				return false;
			}
			return true;
		}
		throw new ParamException("车辆不能为空");

	}

	public static void main(String[] args) {
	String start = CarUtils.getStart();
	}
}
