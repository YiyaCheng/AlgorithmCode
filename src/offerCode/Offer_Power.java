package offerCode;

import java.util.Scanner;

public class Offer_Power {

	/**
	 * 	题目描述：给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
	 */
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		double base=sc.nextDouble();
		int exponent=sc.nextInt();
		System.out.println(base+"的"+exponent+"次方为："+Power(base,exponent));
	}
	public static double Power(double base, int exponent) {
        double result=1.0;
        if(exponent==0.0){
            result=1.0;
        }else if(exponent>0){
            for(int i=exponent;i>0;i--)
                result*=base;
        }else{
            for(int j = 1; j <= -exponent; j++){
            	result *= 1/base;
        	}
        }
        return result;
	}
}
