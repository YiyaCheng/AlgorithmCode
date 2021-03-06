package ZCY;

import java.util.Scanner;

public class Practice_17strings01 {
/**
 * 如果一个01串任意两个相邻位置的字符都是不一样的,我们就叫这个01串为交错01串。例如: “1”,”10101”,”0101010”都是交错01串。
 * 小易现在有一个01串s,小易想找出一个最长的连续子串,并且这个子串是一个交错01串。小易需要你帮帮忙求出最长的这样的子串的长度是多少。
 * 输入描述:
 * 	输入包括字符串s,s的长度length(1 ≤ length ≤ 50),字符串中只包含’0’和’1’
 * 输出描述:
 *  输出一个整数,表示最长的满足要求的子串长度。
 * 
 * 输入例子1:
 * 	111101111
 * 输出例子1:
 * 	3
 * 
 * 思路：遍历一遍数组记录最长的01交错子串长度
 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		//max记录最大长度，count记录当前01串长度
		int max = 1;
		int count = 1;
		//比较 i 位置和 i-1位置，相同 len=0，不同len++
		for (int i = 1; i < str.length(); i++) {
			count++;
			if (str.charAt(i) == str.charAt(i - 1)) {
				count = 1;
			}
			max = Math.max(max, count);
		}
		System.out.println(max);
		sc.close();
	}

}
