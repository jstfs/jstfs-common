package com.jstfs.common.utils;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

/**
 * @createBy	落叶
 * @createTime	2022年9月1日 上午2:16:58
 */
public class MyCollectionUtils extends CollectionUtils {
	/**
	 * 将Integer的集合转为int数组 (List<Integer>.toArray()方法只能转为Integer数组)
	 */
	public static int[] intListToAry(List<Integer> ary) {
		Integer[] tempAry = new Integer[ary.size()];
		ary.toArray(tempAry);
		int[] result = new int[ary.size()];
		
		int index = 0;
		for(Integer i : tempAry) {
			result[index++] = i;
		}
		return result;
	}
}
