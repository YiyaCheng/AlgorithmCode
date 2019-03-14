package offerCode;

import java.util.Scanner;

public class Offer_Find {

	/**
	 * 	在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
	 * 	请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
	 */
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("请输入数组行数和列数");
		int x=s.nextInt();
		int y=s.nextInt();
		int [][]awarry=new int[x][y];//初始化数组
		System.out.println("请输入数组元素");
		for(int i=0;i<x;i++)//循环输入
			for(int j=0;j<y;j++)
				awarry[i][j]=s.nextInt();
		System.out.println("你输入的数组为");
		for(int i=0;i<x;i++){//循环输出
			for(int j=0;j<y;j++)
				System.out.print(awarry[i][j]+"\t");
			System.out.println();
		}
		System.out.println("请输入要查找的数组元素");
		int num=s.nextInt();
		boolean isFind=Find(num,awarry);
		System.out.println(isFind);
	}
	
	public static boolean Find(int target, int [][] array) {
		//array.length  行数             array[0].length;列数
        if((array==null||array.length==0)||(array.length==1&&array[0].length==0))
        	return false;
        
        int i=0,j=array[0].length-1;
        while(i<array.length&&j>=0) {//从右下角往左下角走
        	if(array[i][j]==target)
        		return true;
        	if(array[i][j]>target)
        		j--;
        	else i++;
        }
        return false;
    }
}
