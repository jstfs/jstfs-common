package com.jstfs.common.utils;

import org.apache.commons.lang3.ArrayUtils;

public final class MyArrayUtils extends ArrayUtils {

	private MyArrayUtils() {
		
	}

	/**
	 * 打印数组,使用默认的逗号分隔元素
	 */
	public static String toString(Object[] array) {
		return toString(array, ", ");
	}

	/**
	 * 打印数组,使用指定的分隔符
	 */
	public static String toString(Object[] array, String split) {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for(int i = 0; i < array.length; i++) {
			sb.append(array[i]);
			if(i < array.length - 1) {
				sb.append(split);
			}
		}
		
		sb.append("]");
		return sb.toString();
	}
	
	/**
	 * 返回子数组
	 */
	public static int[] subIntArray(int[] source, int begin, int end) {
		if(begin == end) {
			return new int[] {source[begin]};
		}
		int[] result = new int[end - begin + 1];
		for(int i = 0; begin <= end; i++, begin++) {
			result[i] = source[begin];
		}
		return result;
	}
}