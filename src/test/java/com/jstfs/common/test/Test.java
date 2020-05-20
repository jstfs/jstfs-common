package com.jstfs.common.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
	public static void main(String[] args) {
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd'测试'HH:mm:ss.S"); 
		String str = df1.format(new Date());
		System.out.println(str);
	}
}
