package ZCY;

import java.util.Arrays;

public class Practice_13GetMaxWindow {
/**
 * 	生成窗口最大值数组
 * 	题目描述：有一个整型数组arr和一个大小为w的窗口从数组的最左边滑到最右边，窗口每次向右边滑一个位置。
 *	例如，数组为[4,3,5,4,3,3,6,7]，窗口大小为3时：

    [4 3 5] 4 3 3 6 7 窗口中最大值为5
	4 [3 5 4] 3 3 6 7 窗口中最大值为5
	4 3 [5 4 3] 3 6 7 窗口中最大值为5
	4 3 5 [4 3 3] 6 7 窗口中最大值为4
	4 3 5 4 [3 3 6] 7 窗口中最大值为6
	4 3 5 4 3 [3 6 7] 窗口中最大值为7 
	如果数组长度为n，窗口大小为w，则一共产生n-w+1个窗口的最大值。
	请实现一个函数，给定一个数组arr，窗口大小w。返回一个长度为n-w+1的数组res,res[i]表示每一种窗口状态下的最大值。
	以本题为例，结果应该返回[5,5,5,4,6,7]。 
 */
	public static void main(String[] args) {
		int[] arr = new int[] {4,3,5,4,3,3,6,7}; //定义一个数组
        int w = 3; //定义一个变量n = 3，表示窗口的长度为3
        int[] res = new int[arr.length-w+1]; //定义一个数组，用来获取getArr函数返回的值
       
        res = getArr(arr, w);   
        for(int i = 0;i<arr.length-w+1;i++) {  //遍历打印结果
       	 System.out.print(res[i]+"  ");
        }
	}
	
	public static int[] getArr(int[] arr,int w) {
  	  int n = arr.length;        //定义一个变量n，并赋值数组的长度
  	  int[] res = new int[n-w+1];  //定义一个数组res，用来存取最后的最大值数组
  	  int[] window = new int[w];  //定义一个数组window，用来放每次不同窗口的数值
  	  for(int i = 0;i<n-w+1;i++) {   //外层循环用来控制总窗口数
  		  int m = i; 
  		   for(int j = 0;j<w;j++) {       //内层循环用来控制每一次窗口内获取最大值
  			   window[j] = arr[m++];
  		   }
  		   Arrays.sort(window);        
  		   res[i] = window[w-1];
  	  }
  	  return res;
    }  

}
