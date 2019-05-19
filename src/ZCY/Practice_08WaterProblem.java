package ZCY;

import java.util.HashMap;
import java.util.Map.Entry;

/**
 * 给定一个数组，每个位置的值代表一个高度。那么整个数组可以看作是一个直方图。如果把这个直方图当作容器的话，求这个容器能装多少水
 * 例如：3，1，2，4代表第一个位置高度为3，第二个位置高度为1，第三个位置高度为2，第四个位置高度为4
 * 这个数组代表的容器可以装3格水
 */
public class Practice_08WaterProblem {
	//暴力方法
	public static int getWater1(int[] arr) {
		if (arr == null || arr.length < 3) {
			return 0;
		}
		int value = 0;
		for (int i = 1; i < arr.length - 1; i++) {
			int leftMax = 0;
			int rightMax = 0;
			for (int l = 0; l < i; l++) {
				leftMax = Math.max(arr[l], leftMax);
			}
			for (int r = i + 1; r < arr.length; r++) {
				rightMax = Math.max(arr[r], rightMax);
			}
			value += Math.max(0, Math.min(leftMax, rightMax) - arr[i]);
		}
		return value;
	}
	//预处理方法
	public static int getWater2(int[] arr) {
		if (arr == null || arr.length < 3) {
			return 0;
		}
		int n = arr.length - 2;
		int[] leftMaxs = new int[n];
		leftMaxs[0] = arr[0];
		for (int i = 1; i < n; i++) {
			leftMaxs[i] = Math.max(leftMaxs[i - 1], arr[i]);
		}
		int[] rightMaxs = new int[n];
		rightMaxs[n - 1] = arr[n + 1];
		for (int i = n - 2; i >= 0; i--) {
			rightMaxs[i] = Math.max(rightMaxs[i + 1], arr[i + 2]);
		}
		int value = 0;
		for (int i = 1; i <= n; i++) {
			value += Math.max(0, Math.min(leftMaxs[i - 1], rightMaxs[i - 1]) - arr[i]);
		}
		return value;
	}

	public static int getWater3(int[] arr) {
		if (arr == null || arr.length < 3) {
			return 0;
		}
		int n = arr.length - 2;
		int[] rightMaxs = new int[n];
		rightMaxs[n - 1] = arr[n + 1];
		for (int i = n - 2; i >= 0; i--) {
			rightMaxs[i] = Math.max(rightMaxs[i + 1], arr[i + 2]);
		}
		int leftMax = arr[0];
		int value = 0;
		for (int i = 1; i <= n; i++) {
			value += Math.max(0, Math.min(leftMax, rightMaxs[i - 1]) - arr[i]);
			leftMax = Math.max(leftMax, arr[i]);
		}
		return value;
	}

	public static int getWater4(int[] arr) {
		if (arr == null || arr.length < 3) {
			return 0;
		}
		int value = 0;
		int leftMax = arr[0];
		int rightMax = arr[arr.length - 1];
		int l = 1;
		int r = arr.length - 2;
		while (l <= r) {
			if (leftMax <= rightMax) {
				value += Math.max(0, leftMax - arr[l]);
				leftMax = Math.max(leftMax, arr[l++]);
			} else {
				value += Math.max(0, rightMax - arr[r]);
				rightMax = Math.max(rightMax, arr[r--]);
			}
		}
		return value;
	}

	public static int[] generateRandomArray() {
		int[] arr = new int[(int) (Math.random() * 98) + 2];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 200) + 2;
		}
		return arr;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 1000000; i++) {
			int[] arr = generateRandomArray();
			int r1 = getWater1(arr);
			int r2 = getWater2(arr);
			int r3 = getWater3(arr);
			int r4 = getWater4(arr);
			if (r1 != r2 || r3 != r4 || r1 != r3) {
				System.out.println("What a fucking day! fuck that! man!");
			}
		}
		
		HashMap<String,String> map = new HashMap<String,String>();
		
        for(Entry<String,String> entry : map.entrySet()){
            System.out.println(entry.getKey()+" , "+ entry.getValue());
        }
		
	}

}
