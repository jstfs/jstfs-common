package com.jstfs.common.utils;

public class MyBinaryUtils {
	/**
	 *	将一个Float数据的二进制格式的String按照[符号 指数 尾数]格式化输出
	 */
	public static String formatPrintFloatBinary(String intStr) {
		String sign = "0";			//符号(正/负)
		String exponent_8 = "";		//指数
		String tail_23 = "";		//尾数
		if(intStr.length() >= 23) {
			tail_23 = intStr.substring(intStr.length() - 23, intStr.length());
			if(intStr.length() >= 31) {
				if(intStr.length() == 32) {
					sign = intStr.substring(0, 1);
					exponent_8 = intStr.substring(1, 8);
				} else {
					exponent_8 = intStr.substring(0, intStr.length() - 23);
				}
			} else {
				exponent_8 = intStr.substring(0, intStr.length() - 23);
				for(int i = 0; i < 8 - exponent_8.length(); i ++) {
					exponent_8 = "0" + exponent_8;
				}
			}
		} else {
			tail_23 = intStr;
		}
		
		
		return sign + " " + exponent_8 + " " + tail_23;
		
	}

	public static String formatPrintDoubleBinary(String longStr) {
		String sign = "0";			//符号(正/负)
		String exponent_11 = "";	//指数
		String tail_52 = "";		//尾数
		if(longStr.length() >= 52) {
			tail_52 = longStr.substring(longStr.length() - 52, longStr.length());
			if(longStr.length() >= 63) {
				if(longStr.length() == 64) {
					sign = longStr.substring(0, 1);
					exponent_11 = longStr.substring(1, 11);
				} else {
					exponent_11 = longStr.substring(0, longStr.length() - 52);
				}
			} else {
				exponent_11 = longStr.substring(0, longStr.length() - 52);
				for(int i = 0; i < 11 - exponent_11.length(); i ++) {
					exponent_11 = "0" + exponent_11;
				}
			}
		} else {
			tail_52 = longStr;
		}
		
		
		return sign + " " + exponent_11 + " " + tail_52;
	}
}
