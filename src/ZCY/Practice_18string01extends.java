package ZCY;

import java.util.HashMap;

public class Practice_18string01extends {
	/**
	 * 如果一个01串任意两个相邻位置的字符都是不一样的,我们就叫这个01串为交错01串。例如: “1”,”10101”,”0101010”都是交错01串。
	 * 小易现在有一个01串s,小易想找出一个最长的连续子串,并且这个子串是0和1数量相等的。
	 * 
	 * 思路：以某个位置为结尾的子数组，累加和为定值 k
	 * 	        将题目中的0全部置为 -1 ，那么原问题就变成了求 满足子数组累加和为0 的最长子数组。 
	 */
	
	public static int maxLength(int[] arr, int k) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, -1); // 处理第一位等于 k 的情况
		/*
		 6 1 2 3  k = 6
                           上来 sum = 6
         sum - k = 0;
         len = i - map.get(0) 但是现在不存在map.get(0) 这样len返回的结果是0，而不是 1
	    */	
		int len = 0;
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (map.containsKey(sum - k)) {
				len = Math.max(i - map.get(sum - k), len);
			}
			if (!map.containsKey(sum)) {//不存在就添加
				map.put(sum, i);
			}
		}
		return len;
	}

	public static int[] generateArray(int size) {
		int[] result = new int[size];
		for (int i = 0; i != size; i++) {
			result[i] = (int) (Math.random() * 11) - 5;
		}
		return result;
	}

	public static void printArray(int[] arr) {
		for (int i = 0; i != arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] arr = generateArray(20);
		printArray(arr);
		System.out.println(maxLength(arr, 10));
	}

}
