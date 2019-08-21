package ZCY;

import java.util.LinkedList;

public class Practice_14AllLessNumSubArray {
/** 最大值减去最小值小于或等于num的子数组数量
    *        题目描述：给定数组arr和整数num，返回有多少个子数组满足如下情况:
 *		   max(arr[i..j]) - min(arr[i..j]) <= num
 *         max(arr[i..j])表示子数组arr[i..j]中的最大值，min(arr[i..j])表示子数组arr[i..j]中的最小值。
    *                           如果数组长度为 N，请实现时间复杂度为 O(N)的解法。
 *	解法：
 *        1、如果一个子数组从L->R中，arr[max] - arr[min] <= num，那么在L->R范围内的子数组都符合要求
 *        2、如果一个子数组从L->R中，arr[max] - arr[min] > num，那么以L->R为基础向外扩的子数组都不符合要求
 *	做两个双端队列，一个是窗口内最大值，另外一个是窗口内最小值
 *	（1）开始时L在数组最左端 0 位置，R从最左端开始向右扩，直到再扩充一个值就不符合要求时，R停止，设此时为 x 位置
 *	 则以0位置开始的子数组有 x + 1个（0,0~1,……0~x）  这些子数组是以0为起始位置符合要求的所有子数组个数
 *	（2）L向右边移动一个位置，更新两个窗口内的结构，然后R试着继续向右扩，重复上面的，然后就能得到以1为起始位置符合要求的所有子数组个数
 *	 L每次向右移动一个位置，R就开始向右扩
 */
	public static void main(String[] args) {
		int[] arr = getRandomArray(30);
		int num = 5;
		printArray(arr);
		System.out.println(getNum(arr, num));
	}
	
	
	
	
	public static int getNum(int[] arr, int num) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		LinkedList<Integer> qmin = new LinkedList<Integer>();
		LinkedList<Integer> qmax = new LinkedList<Integer>();
		int i = 0;
		int j = 0;
		int res = 0;
		
		/**
		 * 从当前位置 i 开始 采用双重循环， j 向后面开始扩充，采用两个队列，分别记录当前 i - j 的最大值和最小值
 		当 arrays[qmax.peekLast()] - arrays[qmin.peekLast()] > num 时不满足题意，
 		则 j 停止扩充，然后计算从 i 到 j 共有多少个子数组  j - i 记录，
 		并且判断当前位置 i 是否还在最大或最小队列中，如果存在，则弹出，因为 i 马上要过期了
 		然后 i++ 继续扩充
		 */
		while (i < arr.length) {
			while (j < arr.length) {
				while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[j]) {
					qmin.pollLast();
				}
				qmin.addLast(j);
				while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[j]) {
					qmax.pollLast();
				}
				qmax.addLast(j);
				if (arr[qmax.getFirst()] - arr[qmin.getFirst()] > num) {
					break;
				}
				j++;
			}
			
			//判断是否超过了边值条件
			if (qmin.peekFirst() == i) {
				qmin.pollFirst();
			}
			if (qmax.peekFirst() == i) {
				qmax.pollFirst();
			}
			res += j - i;
			i++;
		}
		return res;
	}

	// for test
	public static int[] getRandomArray(int len) {
		if (len < 0) {
			return null;
		}
		int[] arr = new int[len];
		for (int i = 0; i < len; i++) {
			arr[i] = (int) (Math.random() * 10);
		}
		return arr;
	}

	// for test
	public static void printArray(int[] arr) {
		if (arr != null) {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}
	} 
}
