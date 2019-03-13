package offerCode;

import java.util.Scanner;

public class Offer_RectCover {
	//矩形覆盖-斐波那契数列问题
	//问题描述： 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
	/*当n=1时，只有一种横向排列的方式。当n等于二时，2*2有两种选择，横向或者是竖向。当n等于3的时候对于2*3来说,如果选择的是竖向排列，
	 * 则剩下的就是2*2排列，如果选择的是横向,则对于2*n剩下的则只有1*n的一种选择。所以依次类推，找到迭代RectCover(target-1)+RectCover(target-2)。
	 */

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int target=Integer.parseInt(sc.nextLine());
		System.out.println("共有"+RectCover(target)+"种方法");
		
	}
	public static int RectCover(int target) {
		if(target <=0){
            return 0;
        }else if(target ==1|| target == 2){
             return target;
         }
        return(RectCover(target-1)+RectCover(target-2));
    }
}
