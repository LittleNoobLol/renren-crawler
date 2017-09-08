package io.renren.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期处理
 * 
 */
public class DateUtils {
	/** 时间格式(yyyy-MM-dd) */
	public final static String DATE_PATTERN = "yyyy-MM-dd";
	/** 时间格式(yyyy-MM-dd HH:mm:ss) */
	public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

	public static String format(Date date) {
		return format(date, DATE_PATTERN);
	}

	public static String format(Date date, String pattern) {
		if (date != null) {
			SimpleDateFormat df = new SimpleDateFormat(pattern);
			return df.format(date);
		}
		return null;
	}

	/**
	 * 使用预设格式将字符串转为Date
	 */
	public static Date parse(String strDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date parse = null;
		try {
			parse = sdf.parse(strDate);
		} catch (ParseException e) {
		}
		return parse;
	}

	/**
	 * 使用预设格式将字符串转为Date
	 */
	public static Date parse(String strDate, String pattan) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattan);
		Date parse = null;
		try {
			parse = sdf.parse(strDate);
		} catch (ParseException e) {
		}
		return parse;
	}

	public static Date getHoursAgoTime(int hour) {
		Calendar cal = Calendar.getInstance();
		// 减去hour个小时
		cal.add(Calendar.HOUR, hour);
		return cal.getTime();
	}

	public static void main(String[] args) {
		String date="5小时前";
		// 截取 小时前
		String substring = date.substring(0, date.indexOf("小时前"));
		// 转换
		int hour = Integer.valueOf(substring);
		// 获取他的相反数
		Date hoursAgoTime = DateUtils.getHoursAgoTime(0 - hour);
		System.out.println(hoursAgoTime);
		// 保存
		//entity.setDate(hoursAgoTime);
	}
}
