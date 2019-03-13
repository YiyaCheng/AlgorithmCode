package offerCode;

import java.util.Scanner;

public class Offer_JumpFloor2 {
//变态跳台阶：一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int target=Integer.parseInt(sc.nextLine());
		if(target<=0) {
			System.out.println("请输入大于0的数！");
		}else {
			System.out.println("共有"+JumpFloor(target)+"种跳法");
		}
	}
	public static int JumpFloor(int target) {
		if(target<=0||target==1||target==2)
			return target;
		return 2*JumpFloor(target-1);
	}
}
