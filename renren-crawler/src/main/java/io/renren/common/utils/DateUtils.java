package io.renren.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	public static Date parse(String strDate,String pattan) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattan);
		Date parse = null;
		try {
			parse = sdf.parse(strDate);
		} catch (ParseException e) {
		}
		return parse;
	}
}
