package com.jstfs.common.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;

/**
 * @createBy	落叶
 * @createTime	2022年9月1日 上午2:16:58
 */
public class MyCollectionUtils extends CollectionUtils {
	/**
	 * 将Integer的集合转为int数组 (List<Integer>.toArray()方法只能转为Integer数组)
	 */
	public static int[] toArray(List<Integer> ary) {
		Integer[] tempAry = new Integer[ary.size()];
		ary.toArray(tempAry);
		int[] result = new int[ary.size()];
		
		int index = 0;
		for(Integer i : tempAry) {
			result[index++] = i;
		}
		return result;
	}
	
	/**
	 * 创建一个指定元素类型的List
	 */
	public static <E> List<E> newList(Class<E> e) {
		return new ArrayList<E>();
	}
	
	/**
	 * 创建一个指定<K, V>的Map
	 */
	public static <K, V> Map<K, V> newMap(Class<K> k, Class<V> v) {
		return new HashMap<K, V>();
	}
}
