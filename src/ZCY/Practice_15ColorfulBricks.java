package ZCY;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Practice_15ColorfulBricks {
/**
 * 小易有一些彩色的砖块。每种颜色由一个大写字母表示。各个颜色砖块看起来都完全一样。现在有一个给定的字符串s,s中每个字符代表小易的某个砖块的颜色。小易想把他所有的砖块排成一行。
 * 如果最多存在一对不同颜色的相邻砖块,那么这行砖块就很漂亮的。请你帮助小易计算有多少种方式将他所有砖块排成漂亮的一行。(如果两种方式所对应的砖块颜色序列是相同的,那么认为这两种方式是一样的。)
 * 例如: s = "ABAB",那么小易有六种排列的结果:"AABB","ABAB","ABBA","BAAB","BABA","BBAA"
 * 其中只有"AABB"和"BBAA"满足最多只有一对不同颜色的相邻砖块。
 * 
 * 输入描述:
 * 		输入包括一个字符串s,字符串s的长度length(1 ≤ length ≤ 50),s中的每一个字符都为一个大写字母(A到Z)。
 * 输出描述:
 * 		输出一个整数,表示小易可以有多少种方式。
 * 
 * 示例1
 * 输入
 * ABAB
 * 输出
 * 2 
 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		// 输入一个字符串
		String s = sc.nextLine();
		Set<Character> set = new HashSet<Character>();
		int count = 0;
		for (char c : s.toCharArray()) {
			if (!set.contains(c)) {
				set.add(c);
				count++;
			}
		}
		/**
		 * 题目中字符串由几种形式：
		 * 1.字符串的字符种类为1时，结果为1。
		 * 2.字符串的字符种类为2时，结果为2。
		 * 3.字符串的字符种类大于2时，结果为0。
		 */
		if (count > 2)
			System.out.println(0);
		else if (count == 2)
			System.out.println(2);
		else
			System.out.println(count);
		sc.close();
	}
}
