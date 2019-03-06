package ZCY;

import java.util.Scanner;
import java.util.Stack;

public class Practice_04 {
/**
 * 保卫方案（京东笔试题）
 * 题目：战争游戏的至关重要环节就要到来了，这次的结果将决定王国的生死存亡，小 B 负责首都的防卫工作。首都位于一个四面环山的盆地中，周围的 n 个小山构成一个环，
 * 	        作为预警措施，小 B 计划在每个小山上设置一个观察哨，日夜不停的瞭望周围发生的情况。 一旦发生外地入侵事件，山顶上的岗哨将点燃烽烟，若两个岗哨所在的山峰之
 *     间没有更高的山峰遮挡且两者之间有相连通路，则岗哨可以观察到另一个山峰上的烽烟是否点燃。由于小山处于环上，任意两个小山之间存在两个不同的连接通路。满足上
 *     述不遮挡的条件下，一座山峰上岗哨点燃的烽烟至少可以通过一条通路被另一端观察到。对于任意相邻的岗哨，一端的岗哨一定可以发现一端点燃的烽烟。 小 B 设计的这
 *     种保卫方案的一个重要特性是能够观测到对方烽烟的岗哨对的数量，她希望你能够帮她解决这个问题。
 * 输入描述
 * 输入中有多组测试数据，每一组测试数据的第一行为一个整数 n(3≤n≤10^6^), 为首都周围的小山数量，第二行为 n 个整数，依次表示为小山的高度 h（1≤h≤10^9^）.
 * 输出描述
 * 对每组测试数据，在单独的一行中输出能相互观察到的岗哨的对数。
 * https://blog.csdn.net/qq_35314344/article/details/76083170
 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			int size = in.nextInt();
			int[] arr = new int[size];
			for (int i = 0; i < size; i++) {
				arr[i] = in.nextInt();
			}
		System.out.println(communications(arr));
		}
	}
	public static int nextIndex(int size, int i) {
		return i < (size - 1) ? (i + 1):0;
	}
		//相邻相同山峰之间的对数，若只有一个，则没有成对，若有两个以上计算内部成对数
	public static long getInternalSum(int n) {
		return n == 1L ? 0L : (long) n * (long) (n - 1) / 2L;
	}
	public static class Pair {
		public int value;
		public int times;

		public Pair(int value) {
			this.value = value;
			this.times = 1;
		}
	}


	public static long communications(int[] arr) {
		if (arr == null || arr.length < 2) {
			return 0;
		}
		int size = arr.length;
		int maxIndex = 0;
		for (int i = 0; i < size; i++) {
			maxIndex = arr[maxIndex] < arr[i] ? i : maxIndex;//找到最高山峰的位置
		}
		int value = arr[maxIndex];//最高山峰的高度
		int index = nextIndex(size, maxIndex);//最高山峰的下一个位置
		long res = 0L;
		Stack<Pair> stack = new Stack<>();
		stack.push(new Pair(value));
		while (index != maxIndex) {
			value = arr[index];
			while (!stack.isEmpty() && stack.peek().value < value) {
				int times = stack.pop().times;
				res += getInternalSum(times) + times*2;//因为栈底是最大元素，所以在此阶段不可能跳出
		}
		if (!stack.isEmpty() && stack.peek().value == value) {
			stack.peek().times++;
		} else {
			stack.push(new Pair(value));
		}
		index = nextIndex(size, index);
		}
		while (!stack.isEmpty()) {
			int times = stack.pop().times;
			res += getInternalSum(times);
			if (!stack.isEmpty()) {
				res += times;
				if (stack.size() > 1) {//当栈底还剩大于1个的时候，弹出的那个数还可以与栈底的数称为对数
					res += times;
				} else {
					res += stack.peek().times > 1 ? times : 0;
				}
			}
		}
		return res;
		}
}
