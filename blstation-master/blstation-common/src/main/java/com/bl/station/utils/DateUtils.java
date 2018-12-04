package com.bl.station.utils;

import com.bl.station.exception.CustomException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	/*
	 * 将时间转换为时间戳
	 */
	public static String dateToStamp(String s) throws ParseException {
		String res;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = simpleDateFormat.parse(s);
		long ts = date.getTime();
		res = String.valueOf(ts);
		return res;
	}

	/*
	 * 将时间戳转换为时间
	 */
	public static String stampToDate(String s) {
		String res;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long lt = new Long(s);
		Date date = new Date(lt);
		res = simpleDateFormat.format(date);
		return res;
	}

	// 输入日期转换为毫秒值
	public static double haomiao(Date starDate, Date endDate) {

		long time = starDate.getTime();

		long time2 = endDate.getTime();

		double d = (time2 - time) / 1000 / 60;
		return d;

	}

	// 日期转化Date
	public static String Date2String(Date date) {
		String date1 = null;
		if (date != null) {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			date1 = simpleDateFormat.format(date);
		}

		return date1;
	}

	// String 转换为日期

	public static Date String2date(String date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String rexp1 = "((\\d{2}(([02468][048])|([13579][26]))[\\-]((((0?[13578])|(1[02]))[\\-]((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-]((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-]((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-]((((0?[13578])|(1[02]))[\\-]((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-]((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-]((0?[1-9])|(1[0-9])|(2[0-8]))))))";
		String rexp2 = "((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s((([0-1][0-9])|(2?[0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))";
		String rexp3 = "\\s*"; // 匹配空白 但不限于空格
		Date date1 = null;
		try {
			if (date != null) {
				if (date.matches(rexp1)) {
					date1 = simpleDateFormat.parse(date + " 00:00:00");
					return date1;
				} else if (date.matches(rexp2)) {
					return simpleDateFormat.parse(date);
				} else if (date.matches(rexp3)) {
					return null;
				} else {
					return null;
				}
			}
			return date1;
		} catch (Exception e) {
			throw new CustomException("时间格式化异常");
		}

	}

	// add one year
	// 给当前时间加一年
	public static Date addOneYear(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.YEAR, 1);
		date = calendar.getTime();
		return date;
	}

	public static Date addOneWeek(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, 7);
		date = calendar.getTime();
		return date;
	}

	public static Date addOneDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.HOUR_OF_DAY, 24);
		date = calendar.getTime();
		return date;
	}

	public static Date addOneHours(Date date, int i) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.HOUR_OF_DAY, i);
		date = calendar.getTime();
		return date;
	}

	public static Date lessOneSecond(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.SECOND, -1);
		date = calendar.getTime();
		return date;
	}

	// 获取当年最后一天
	public static Date getLastDayThisYear() {
		Calendar currCal = Calendar.getInstance();
		int currentYear = currCal.get(Calendar.YEAR);
		return getYearLast(currentYear);
	}

	// 获取某年最后一天
	public static Date getYearLast(int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		// calendar.set(Calendar.YEAR, year);
		// calendar.roll(Calendar.DAY_OF_YEAR, -1);
		calendar.set(year, 11, 31, 23, 59, 59);
		Date currYearLast = calendar.getTime();

		return currYearLast;
	}

	// 获取当年第一天的日期
	public static Date getFirstDayThisYear() {
		Calendar currCal = Calendar.getInstance();
		int currentYear = currCal.get(Calendar.YEAR);
		return getYearFirst(currentYear);
	}

	public static Date getYearFirst(int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		Date currYearFirst = calendar.getTime();
		return currYearFirst;
	}

	// 获取指定时间的毫秒值

	@SuppressWarnings("deprecation")
	public static long getTimeInMillis(Date date) {

		long millis = date.getTime();
		return millis;

	}

	public static void main(String[] args) {
		// Date date = DateUtils.getFirstDayThisYear();
		Date date = DateUtils.getLastDayThisYear();
		System.err.println(new Date());
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String string = simpleDateFormat.format(date);
		System.out.println(string);

		long millis = DateUtils.getTimeInMillis(new Date());
		System.out.println(millis);

	}
}
