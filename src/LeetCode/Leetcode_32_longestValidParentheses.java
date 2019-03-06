package LeetCode;

import java.util.Scanner;
import java.util.Stack;

public class Leetcode_32_longestValidParentheses {
/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 * @param args
 */
	
	public static void main(String[] args) {
		System.out.print("请输入只包含 '(' 和 ')' 的字符串：");
		Scanner scanner=new Scanner(System.in);
		String str=scanner.nextLine();
		int n=longestValidParentheses(str);
		System.out.println(n);
	}
	public static int longestValidParentheses(String s) {
		if(s.length()==0)
			return 0;
		int count=0;
		// 用于记录待匹配的左括号和右括号的位置
		Stack<Integer> stack=new Stack<Integer>();//定义为Stack<Character>下标会越界
		
		for(int i=0;i<s.length();i++) {
			//peek()方法 查看栈顶对象而不移除它
			// 如是当前字符是右括号，并且记录栈非空，并且前一个字符是左括号
			if(s.charAt(i)==')'&&!stack.empty()&&s.charAt(stack.peek())=='(') {
				// 左括号出栈
				stack.pop();
				// 求最大值
				//count=Math.max(count, i - ((stack.isEmpty()) ? -1 : stack.peek()));
				count=Math.max(count, i-stack.peek());
			}else {
				// 其它情况就将字符入栈
				stack.push(i);
			}
		}
		return count;
	}
}
