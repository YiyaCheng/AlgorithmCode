package offerCode;

import java.util.Scanner;

public class Offer_NumberOf1 {
	// 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		System.out.println("利用位运算来实现 :"+NumberOf1(num));
		System.out.println("Java内置toBinaryString方法"+NumberOf11(num));
	}
	public static int NumberOf1(int n) {
		/*
	     *	 利用位运算来实现 思路： 将n与n-1做与运算，会把最右边的1去掉。 比如： 1100 & 1011 = 1000 ，即 12 & 11 = 8
	     * 	 再利用计算器count++计算出有多少个 1 即可。
	     */
		int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }
	public static int NumberOf11(int n) {
		int count = 0;
		String str = Integer.toBinaryString(n);
		for (int i = 0; i < str.length(); i++)
		{ 
			if (str.charAt(i) == '1') 
			{
				count++; 
				} 
			} 
		return count;
	
    }
}
