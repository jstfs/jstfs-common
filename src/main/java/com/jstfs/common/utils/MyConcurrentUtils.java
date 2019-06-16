package com.jstfs.common.utils;

public class MyConcurrentUtils {

	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			new RuntimeException(e);
		}
	}
}
