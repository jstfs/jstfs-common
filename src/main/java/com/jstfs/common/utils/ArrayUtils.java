package com.jstfs.common.utils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@SuppressWarnings({"unchecked", "rawtypes"})
public final class ArrayUtils {

	// TODO 应该要移到CollectionUtils中
	public static int[] toIntArray(Collection coll) {
		Iterator iter = coll.iterator();
		int[] arr = new int[coll.size()];
		int i = 0;
		while(iter.hasNext()) {
			arr[i++] = ((Integer) iter.next()).intValue();
		}
		return arr;
	}

	private ArrayUtils() {
	}

	public static String toString(Object[] array) {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for(int i = 0; i < array.length; i++) {
			sb.append(array[i]);
			if(i < array.length - 1){
				sb.append(",");
			}
		}
		sb.append("]");
		return sb.toString();
	}

	public static String toString(Object[] array, String split) {
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < array.length; i++) {
			sb.append(array[i]);
			if(i < array.length - 1) {
				sb.append(split);
			}
		}
		return sb.toString();
	}
	
	public static String[] toStringArray(Object[] source) {
		int length = source.length;
		String[] result = new String[length];
		for(int i = 0; i < length; i++) {
			result[i] = source[i].toString();
		}
		return result;
	}

	/**
	 * 获得某个对象在数组中的下标
	 */
	public static int indexOf(Object[] source, Object target) {
		for(int i = 0; i < source.length; i++) {
			if(source[i].equals(target)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * 填充String数组
	 */
	public static String[] fillStringArray(String value, int length) {
		String[] result = new String[length];
		Arrays.fill(result, value);
		return result;
	}

	/**
	 * 填充整型数组
	 */
	public static int[] fillIntArray(int value, int length) {
		int[] result = new int[length];
		Arrays.fill(result, value);
		return result;
	}

	public static <T> List<T> toList(T array) {
		if(array instanceof Object[]) {
			return Arrays.asList(array);
		}
		int size = Array.getLength(array);
		List<T> list = new ArrayList<T>(size);
		for(int i = 0; i < size; i++) {
			list.add((T) Array.get(array, i));
		}
		Arrays.asList(array);
		return list;
	}

	public static <T> List<T> toList(Iterator<T> ite) {
		List<T> list = new ArrayList<T>();
		while(ite.hasNext()) {
			list.add(ite.next());
		}
		return list;
	}

	/**
	 * 返回子数组
	 */
	public static Object[] subArray(Object[] source, int begin, int length) {
		Object[] result = new Object[length];
		for(int i = 0; i < length; i++) {
			result[i] = source[begin + i];
		}
		return result;
	}

	/**
	 * 返回子数组
	 */
	public static int[] subIntArray(int[] source, int begin, int length) {
		int[] result = new int[length];
		for(int i = 0; i < length; i++) {
			result[i] = source[begin + i];
		}
		return result;
	}

	/**
	 * 合并整型数组
	 */
	public static int[] mergeIntArray(int[] x, int[] y) {
		int[] result = new int[x.length + y.length];
		for(int i = 0; i < x.length; i++) {
			result[i] = x[i];
		}
		for(int i = 0; i < y.length; i++) {
			result[i + x.length] = y[i];
		}
		return result;
	}

	/**
	 * 将一个数组按指定大小切分成多个子数组
	 */
	public static <T> List<T[]> split(T[] source, int batchSize) {
		List<T[]> list = new ArrayList<T[]>();
		int index = 0;
		while(index < source.length) {
			int arraySize = source.length - index > batchSize ? batchSize : source.length - index;
			T[] temp;
			Class type = source.getClass().getComponentType();
			temp = (T[]) Array.newInstance(type, arraySize);
			for(int i = 0; i < arraySize; i++) {
				temp[i] = source[index++];
			}
			list.add(temp);
		}
		return list;
	}

	public static <T> void addAll(Collection<T> collection, T[] array) {
		for(int i = 0; i < array.length; i++) {
			collection.add(array[i]);
		}
	}

	private static int SEED = 23;
	private static int PRIME_NUMER = 37;

	public static int hash(Object[] array) {
		int length = array.length;
		int seed = SEED;
		for(int index = 0; index < length; index++) {
			seed = hash(seed, array[index] == null ? 0 : array[index].hashCode());
		}
		return seed;
	}

	public static int hash(char[] array) {
		int length = array.length;
		int seed = SEED;
		for(int index = 0; index < length; index++) {
			seed = hash(seed, (int) array[index]);
		}
		return seed;
	}

	public static int hash(byte[] bytes) {
		int length = bytes.length;
		int seed = SEED;
		for(int index = 0; index < length; index++) {
			seed = hash(seed, (int) bytes[index]);
		}
		return seed;
	}

	private static int hash(int seed, int i) {
		return PRIME_NUMER * seed + i;
	}

	public static boolean isEquals(Object[] array1, Object[] array2) {
		if(array1 == array2) {
			return true;
		}
		if(array1 == null || array2 == null) {
			return false;
		}
		int length = array1.length;
		if(length != array2.length) {
			return false;
		}
		for(int index = 0; index < length; index++) {
			if(!array1[index].equals(array2[index])) {
				return false;
			}
		}
		return true;
	}

	public static boolean isEquals(char[] array1, char[] array2) {
		if(array1 == array2) {
			return true;
		}
		if(array1 == null || array2 == null) {
			return false;
		}
		int length = array1.length;
		if(length != array2.length) {
			return false;
		}
		for(int index = 0; index < length; index++) {
			if(!(array1[index] == array2[index])) {
				return false;
			}
		}
		return true;
	}

	public static boolean isEquals(byte[] array1, byte[] array2) {
		if(array1 == array2) {
			return true;
		}
		if(array1 == null || array2 == null) {
			return false;
		}
		int length = array1.length;
		if(length != array2.length) {
			return false;
		}
		for(int index = 0; index < length; index++) {
			if(!(array1[index] == array2[index])) {
				return false;
			}
		}
		return true;
	}

	public static <T> boolean isEmpty(int[] ary) {
		if(ary == null || ary.length == 0) {
			return true;
		}
		return false;
	}

	public static <T> boolean isEmpty(long[] ary) {
		if(ary == null || ary.length == 0){
			return true;
		}
		return false;
	}

	public static <T> boolean isEmpty(float[] ary) {
		if(ary == null || ary.length == 0){
			return true;
		}
		return false;
	}

	public static <T> boolean isEmpty(double[] ary) {
		if(ary == null || ary.length == 0){
			return true;
		}
		return false;
	}

	public static <T> boolean isEmpty(boolean[] ary) {
		if(ary == null || ary.length == 0){
			return true;
		}
		return false;
	}

	public static <T> boolean isEmpty(Object[] ary) {
		if(ary == null || ary.length == 0){
			return true;
		}
		return false;
	}
}