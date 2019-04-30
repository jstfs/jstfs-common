package com.jstfs.common.utils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@SuppressWarnings({ "unchecked", "rawtypes" })
public final class ArrayUtils {

	private ArrayUtils() {
	}
	
	public static int indexOf(Object[] array, Object object) {
		for (int i = 0; i < array.length; i++) {
			if(array[i].equals(object))
				return i;
		}
		return -1;
	}

	public static String[] toStringArray(Object[] objects) {
		int length = objects.length;
		String[] result = new String[length];
		for (int i = 0; i < length; i++) {
			result[i] = objects[i].toString();
		}
		return result;
	}

	public static String[] fillArray(String value, int length) {
		String[] result = new String[length];
		Arrays.fill(result, value);
		return result;
	}

	public static int[] fillArray(int value, int length) {
		int[] result = new int[length];
		Arrays.fill(result, value);
		return result;
	}

	public static int[] toIntArray(Collection coll) {
		Iterator iter = coll.iterator();
		int[] arr = new int[coll.size()];
		int i = 0;
		while (iter.hasNext()) {
			arr[i++] = ((Integer) iter.next()).intValue();
		}
		return arr;
	}

	public static boolean[] toBooleanArray(Collection coll) {
		Iterator iter = coll.iterator();
		boolean[] arr = new boolean[coll.size()];
		int i = 0;
		while (iter.hasNext()) {
			arr[i++] = ((Boolean) iter.next()).booleanValue();
		}
		return arr;
	}

	public static Object[] typecast(Object[] array, Object[] to) {
		return java.util.Arrays.asList(array).toArray(to);
	}

	public static <T> List<T> toList(T array) {
		if(array instanceof Object[])
			return toList((T[]) array); // faster?
		int size = Array.getLength(array);
		ArrayList<T> list = new ArrayList<T>(size);
		for (int i = 0; i < size; i++) {
			list.add((T) Array.get(array, i));
		}
		return list;
	}

	public static <T> List<T> toList(T[] array) {
		int size = array.length;
		ArrayList<T> list = new ArrayList<T>(size);
		for (int i = 0; i < size; i++) {
			list.add(array[i]);
		}
		return list;
	}

	public static String[] slice(String[] strings, int begin, int length) {
		String[] result = new String[length];
		for (int i = 0; i < length; i++) {
			result[i] = strings[begin + i];
		}
		return result;
	}

	public static Object[] slice(Object[] objects, int begin, int length) {
		Object[] result = new Object[length];
		for (int i = 0; i < length; i++) {
			result[i] = objects[begin + i];
		}
		return result;
	}

	public static <T> List<T> toList(Iterator<T> iter) {
		List<T> list = new ArrayList<T>();
		while (iter.hasNext()) {
			list.add(iter.next());
		}
		return list;
	}

	public static String[] join(String[] x, String[] y) {
		String[] result = new String[x.length + y.length];
		for (int i = 0; i < x.length; i++)
			result[i] = x[i];
		for (int i = 0; i < y.length; i++)
			result[i + x.length] = y[i];
		return result;
	}

	public static Object[] join(Object[] x, Object[] y) {
		Object[] result = new Object[x.length + y.length];
		for (int i = 0; i < x.length; i++)
			result[i] = x[i];
		for (int i = 0; i < y.length; i++)
			result[i + x.length] = y[i];
		return result;
	}

	public static String[] join(String[] x, String[] y, boolean[] use) {
		String[] result = new String[x.length + countTrue(use)];
		for (int i = 0; i < x.length; i++)
			result[i] = x[i];
		int k = x.length;
		for (int i = 0; i < y.length; i++) {
			if(use[i])
				result[k++] = y[i];
		}
		return result;
	}

	public static int[] join(int[] x, int[] y) {
		int[] result = new int[x.length + y.length];
		for (int i = 0; i < x.length; i++)
			result[i] = x[i];
		for (int i = 0; i < y.length; i++)
			result[i + x.length] = y[i];
		return result;
	}

	public static <T> List<T[]> split(T[] x, int batchSize) {
		List<T[]> list = new ArrayList<T[]>();
		int index = 0;
		while (index < x.length) {
			int arraySize = x.length - index > batchSize ? batchSize : x.length - index;
			T[] temp;
			Class type = x.getClass().getComponentType();
			temp = (T[]) Array.newInstance(type, arraySize);
			for (int i = 0; i < arraySize; i++) {
				temp[i] = x[index++];
			}
			list.add(temp);
		}
		return list;
	}

	

	public static String toString(Object[] array) {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for (int i = 0; i < array.length; i++) {
			sb.append(array[i]);
			if(i < array.length - 1)
				sb.append(",");
		}
		sb.append("]");
		return sb.toString();
	}

	public static String toString(Object[] array, String split) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < array.length; i++) {
			sb.append(array[i]);
			if(i < array.length - 1)
				sb.append(split);
		}
		return sb.toString();
	}

	public static boolean isAllNegative(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if(array[i] >= 0)
				return false;
		}
		return true;
	}

	public static boolean isAllTrue(boolean[] array) {
		for (int i = 0; i < array.length; i++) {
			if(!array[i])
				return false;
		}
		return true;
	}

	public static int countTrue(boolean[] array) {
		int result = 0;
		for (int i = 0; i < array.length; i++) {
			if(array[i])
				result++;
		}
		return result;
	}

	public static boolean isAllFalse(boolean[] array) {
		for (int i = 0; i < array.length; i++) {
			if(array[i])
				return false;
		}
		return true;
	}

	public static <T> void addAll(Collection<T> collection, T[] array) {
		for (int i = 0; i < array.length; i++) {
			collection.add(array[i]);
		}
	}

	public static int[] getBatchSizes(int maxBatchSize) {
		int batchSize = maxBatchSize;
		int n = 1;
		while (batchSize > 1) {
			batchSize = getNextBatchSize(batchSize);
			n++;
		}
		int[] result = new int[n];
		batchSize = maxBatchSize;
		for (int i = 0; i < n; i++) {
			result[i] = batchSize;
			batchSize = getNextBatchSize(batchSize);
		}
		return result;
	}

	private static int getNextBatchSize(int batchSize) {
		if(batchSize <= 10) {
			return batchSize - 1; // allow 9,8,7,6,5,4,3,2,1
		} else if(batchSize / 2 < 10) {
			return 10;
		} else {
			return batchSize / 2;
		}
	}

	private static int SEED = 23;
	private static int PRIME_NUMER = 37;

	public static int hash(Object[] array) {
		int length = array.length;
		int seed = SEED;
		for (int index = 0; index < length; index++) {
			seed = hash(seed, array[index] == null ? 0 : array[index].hashCode());
		}
		return seed;
	}

	public static int hash(char[] array) {
		int length = array.length;
		int seed = SEED;
		for (int index = 0; index < length; index++) {
			seed = hash(seed, (int) array[index]);
		}
		return seed;
	}

	public static int hash(byte[] bytes) {
		int length = bytes.length;
		int seed = SEED;
		for (int index = 0; index < length; index++) {
			seed = hash(seed, (int) bytes[index]);
		}
		return seed;
	}

	private static int hash(int seed, int i) {
		return PRIME_NUMER * seed + i;
	}

	public static boolean isEquals(Object[] o1, Object[] o2) {
		if(o1 == o2)
			return true;
		if(o1 == null || o2 == null)
			return false;
		int length = o1.length;
		if(length != o2.length)
			return false;
		for (int index = 0; index < length; index++) {
			if(!o1[index].equals(o2[index]))
				return false;
		}
		return true;
	}

	public static boolean isEquals(char[] o1, char[] o2) {
		if(o1 == o2)
			return true;
		if(o1 == null || o2 == null)
			return false;
		int length = o1.length;
		if(length != o2.length)
			return false;
		for (int index = 0; index < length; index++) {
			if(!(o1[index] == o2[index]))
				return false;
		}
		return true;
	}

	public static boolean isEquals(byte[] b1, byte[] b2) {
		if(b1 == b2)
			return true;
		if(b1 == null || b2 == null)
			return false;
		int length = b1.length;
		if(length != b2.length)
			return false;
		for (int index = 0; index < length; index++) {
			if(!(b1[index] == b2[index]))
				return false;
		}
		return true;
	}

	public static <T> Object[] getColsArray(List<T[]> data, int colsIndex) {
		Object[] colsArray = new Object[data.size()];
		int i = 0;
		Iterator<T[]> it = data.iterator();
		while (it.hasNext() && i < colsArray.length) {
			T[] t = it.next();
			if(t.length > colsIndex) {
				colsArray[i++] = t[colsIndex];
			} else {
				colsArray[i++] = null;
			}
		}
		return colsArray;
	}

	public static boolean isEmpty(Object[] array) {
		return array == null || array.length <= 0 ? true : false;
	}

}
