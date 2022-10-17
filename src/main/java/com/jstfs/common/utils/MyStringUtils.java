package com.jstfs.common.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * @createBy	落叶
 * @createTime	2022年9月1日 上午12:25:40
 */
public class MyStringUtils extends StringUtils {
	
	public static boolean isNotEmpty(CharSequence cs) {
		return !isEmpty(cs);
	}
	
	/**
	 * 在原字符串的前面补充指定字符使其达到指定的长度
	 * 
	 * @param source		原字符串
	 * @param targetLength	目标长度
	 * @param c				补充字符
	 * 
	 * @return				补充后的目标字符串
	 */
	public static String frontFill(String source, int targetLength, char c) {
		StringBuilder sb = new StringBuilder();
		
		if(source.length() >= targetLength) {
			return source;
		} else {
			int diff = targetLength - source.length();
			for(int i = 0; i < diff; i++) {
				sb.append(new Character(c).toString());
			}
			sb.append(source);
		}
		
		return sb.toString();
	}
	
	/**
	 * 在原字符串的后面补充指定字符使其达到指定的长度
	 * 
	 * @param source		原字符串
	 * @param targetLength	目标长度
	 * @param c				补充字符
	 * 
	 * @return				补充后的目标字符串
	 */
	public static String backFill(String source, int targetLength, char c) {
		StringBuilder sb = new StringBuilder();
		
		if(source.length() >= targetLength) {
			return source;
		} else {
			sb.append(source);
			int diff = targetLength - source.length();
			for(int i = diff; i > 0; i--) {
				sb.append(new Character(c).toString());
			}
		}
		
		return sb.toString();
	}
}
