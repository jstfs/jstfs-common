package com.jstfs.common.utils;

import java.util.Arrays;
import java.util.Random;

public class MyRandomUtils extends org.apache.commons.lang3.RandomUtils {
	private static Random ran = new Random(47);
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(generatePhoneNo(30, 11)));
	}
	
	/**
	 * 生成一个指定大小(size)的int数组
	 * 最小值: 1
	 * 最大值: size
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
	 * 生成一个指定大小(size)的Integer数组
	 * 最小值: 1
	 * 最大值: size
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
	 * 生成一个指定大小(size)和指定最小值和最大值的int数组
	 */
	public static int[] generateIntAry(int size, int min, int max) {
		int[] ary = new int[size];
		for (int i = 0; i < size; i++) {
			int r = 0;
			do {
				r = nextInteger(max);
			} while(r < min);
			ary[i] = r;
		}
		return ary;
	}
	
	/**
	 * 生成一个指定大小(size)和指定最小值和最大值的Integer数组
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
	 */
	public static String[] generatePhoneNo(int size, int dataLength) {
		String[] phoneNos = new String[size];
		for(int i = 0; i < size; i++) {
			StringBuffer phoneNo = new StringBuffer("1");	//第一位都是1
			for(int j = 0; j < dataLength - 1; j++) {
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
		return ran.nextInt(max) + 1;
	}
	
	/**
	 * 重新设置种子
	 */
	public static void setSeed(long newSeed) {
		ran.setSeed(newSeed);
	}
}
