package com.jstfs.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;

/**
 * @createBy	落叶
 * @createTime	2022年9月3日 下午3:19:57
 */
public class MyDateUtils extends DateUtils {
	public static final String yyyyMMdd 			= "yyyyMMdd";
	public static final String yyyyMMdd_ 			= "yyyy-MM-dd";
	public static final String HHmmss 				= "HHmmss";
	public static final String HHmmss_ 				= "HH:mm:ss";
	public static final String yyyyMMdd_HHmmss 		= "yyyyMMdd HHmmss";
	public static final String yyyyMMdd_HHmmss_ 	= "yyyy-MM-dd HH:mm:ss";
	public static final String yyyyMMdd_HHmmssSSS 	= "yyyyMMdd HHmmssSSS";
	public static final String yyyyMMdd_HHmmssSSS_ 	= "yyyy-MM-dd HH:mm:ss SSS";
	
	private static SimpleDateFormat sdf = new SimpleDateFormat(yyyyMMdd_HHmmss_);
	
	/**
	 * 当前日期
	 */
	public static Date now() {
		return new Date();
	}
	
	/**
	 * 重置格式化模式
	 */
	public static void resetPattern() {
		sdf.applyPattern(yyyyMMdd_HHmmss_);
	}
	
	/**
	 * 获得当前时间默认格式(yyyy-MM-dd HH:mm:ss)的字符串
	 */
	public static String getNowStr() {
		return sdf.format(now());
	}

	/**
	 * 获得当前时间的指定格式的字符串
	 * 
	 * @param pattern	指定pattern格式
	 */
	public static String getNowStr(String pattern) {
		sdf.applyPattern(pattern);
		return sdf.format(now());
	}
	
}
