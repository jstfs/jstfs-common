package com.jstfs.common.utils;

import java.util.Random;

public class MyRandomUtils extends org.apache.commons.lang3.RandomUtils {
	private static Random ran = new Random(47);
	
	/**
	 * 生成一个指定大小的int数组,最小值为1,最大值为size
	 * 
	 * @param size	数组大小
	 */
	public static int[] generateIntAry(int size) {
		int[] ary = new int[size];
		int index = 0;
		do {
			int r = nextInteger(size);
			ary[index++] = r;
		} while(index < size);
		
		return ary;
	}
	
	/**
	 * 生成一个指定大小的int数组,最小值为1,最大值可以指定
	 * 
	 * @param size	数组大小
	 * @param max	最大值
	 */
	public static int[] generateIntAry(int size, int max) {
		int[] ary = new int[size];
		int index = 0;
		do {
			int r = nextInteger(max);
			ary[index++] = r;
		} while(index < size);
		
		return ary;
	}
	
	/**
	 * 生成一个指定大小的int数组,最小值为和最大值可以指定
	 * 
	 * @param size	数组大小
	 * @param min	最小值
	 * @param max	最大值
	 */
	public static int[] generateIntAry(int size, int min, int max) {
		int[] ary = new int[size];
		for (int i = 0; i < size; i++) {
			ary[i] = nextInteger(min, max);
		}
		return ary;
	}
	
	/**
	 * 生成一个指定大小的Integer数组,最小值为1,最大值为size
	 * 
	 * @param size	数组大小
	 */
	public static Integer[] generateIntegerAry(int size) {
		Integer[] ary = new Integer[size];
		int[] intAry = generateIntAry(size);
		for(int i = 0; i < intAry.length; i++) {
			ary[i] = intAry[i];
		}
		return ary;
	}
	
	/**
	 * 生成一个指定大小的Integer数组,最小值为和最大值可以指定
	 * 
	 * @param size	数组大小
	 * @param min	最小值
	 * @param max	最大值
	 */
	public static Integer[] generateIntegerAry(int size, int min, int max) {
		Integer[] ary = new Integer[size];
		int[] intAry = generateIntAry(size, min, max);
		for(int i = 0; i < intAry.length; i++) {
			ary[i] = intAry[i];
		}
		return ary;
	}
	
	/**
	 * 生成指定大小的指定长度手机号数组
	 * 
	 * @param size			数组大小
	 * @param phoneNoLength	手机号长度
	 */
	public static String[] generatePhoneNo(int size, int phoneNoLength) {
		String[] phoneNos = new String[size];
		for(int i = 0; i < size; i++) {
			StringBuffer phoneNo = new StringBuffer("1");	//第一位都是1
			for(int j = 0; j < phoneNoLength - 1; j++) {
				int bit = nextInteger(9);
				phoneNo.append(bit);
			}
			phoneNos[i] = phoneNo.toString();
		}
		
		return phoneNos;
	}
	
	/**
	 * 生成一个[1, max]之间的整数
	 * 
	 * @param max	最大值	
	 */
	public static Integer nextInteger(int max) {
		return nextInteger(1, max);
	}
	
	/**
	 * 生成一个[min, max]之间的整数
	 * 
	 * @param min	最小值
	 * @param max	最大值
	 */
	public static Integer nextInteger(int min, int max) {
		if(min > max) {
			throw new RuntimeException("min必须大于等于max");
		}
		
		return ran.nextInt(max) %(max - min + 1) + min;
	}

	/**
	 * 重新设置种子
	 */
	public static void setSeed(long newSeed) {
		ran.setSeed(newSeed);
	}
}
