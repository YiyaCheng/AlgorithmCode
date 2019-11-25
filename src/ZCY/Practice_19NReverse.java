package ZCY;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Practice_19NReverse {
/**
 * 小易有一个长度为n的整数序列, a_1. .., an。然后考虑在一个空序列b上进行n次以下操作:
 * 1、将ai放入b序列的末尾
 * 2、逆置b序列
 * 小易需要你计算输出操作n次之后的b序列。
 * 输入描述:输入包括两行,第一行包括一个整数n(2 第二行包括n个整数ai(1 < a_i < 10~9),即序列a中的每个整数,以空格分割
 * 输入例子1:
		4
		1 2 3 4
	输出例子1:
		4 2 1 3
 * 思路：
 * 	维护一个双端队列
	每次添加都是先添加右边在添加左边
	查看最后一次是添加在右边还是添加在左边，右边，逆序，左边，不逆序
 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			int n = in.nextInt();
			Deque<Integer> deque = new LinkedList<Integer>();//双端队列
			boolean convert = false; //标记是否需要逆序
			for (int i = 0; i < n; i++) {
				if (convert) {
					deque.addLast(in.nextInt());
				} else {// 不需要转换就加入双端队列的尾部
					deque.addFirst(in.nextInt());
				}
				convert = !convert;
			}
			// 查看结果是否需要逆序
			if (convert) {
				while (deque.size() != 1) {
					System.out.print(deque.pollFirst() + " ");
				}
				System.out.println(deque.pollFirst());
			} else {
				while (deque.size() != 1) {
					System.out.print(deque.pollLast() + " ");
				}
				System.out.println(deque.pollLast());
			}
		}
		in.close();
	}

}
