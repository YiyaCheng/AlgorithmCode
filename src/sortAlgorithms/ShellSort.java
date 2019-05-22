package sortAlgorithms;

import java.util.Arrays;

/**
 * 希尔排序
 *
 * 1. 选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；（注意此算法的gap取值）
 * 2. 按增量序列个数k，对序列进行k 趟排序；
 * 3. 每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。
 *    仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
 * 平均时间复杂度 	      最好情况 	    	最坏情况 	 	空间复杂度
 * O(nlog2 n) 	O(nlog2 n) 	  O(nlog2 n) 	 O(1)
 */
public class ShellSort {

	//（Wiki官方版）
	public static void shellSort(int[] arr) {
	    int gap = 1, i, j, len = arr.length;
	    int temp;
	    while (gap < len / 3)	//计算首次步长
	        gap = gap * 3 + 1;      // <O(n^(3/2)) by Knuth,1973>: 1, 4, 13, 40, 121, ...
	    for (; gap > 0; gap /= 3) {
	        for (i = gap; i < len; i++) {
	            temp = arr[i];//当前元素
	            for (j = i - gap; j >= 0 && arr[j] > temp; j -= gap) //左边的比当前大，则左边的往右边挪动
	                arr[j + gap] = arr[j];
	            arr[j + gap] = temp;//挪动完了之后把当前元素放进去
	        }
	        for( int k = 0 ; k < arr.length ; k++ ){
	            System.out.print(arr[k]+" ");
	        }
	    }
	}
	
	public static void shell_Sort(int[] arr){
	    int gap = arr.length / 2;
	    for (; gap > 0; gap /= 2) {      //不断缩小gap，直到1为止
	        for (int j = 0; (j+gap) < arr.length; j++){     //使用当前gap进行组内插入排序
	            for(int k = 0; (k+gap)< arr.length; k += gap){
	                if(arr[k] > arr[k+gap]) {
	                    int temp = arr[k+gap];      //交换操作
	                    arr[k+gap] = arr[k];
	                    arr[k] = temp;
	                    System.out.println("    Sorting:  " + Arrays.toString(arr));
	                }
	            }
	        }
	    }
	}
	
	public static void main(String[] args) {
		int[] array = {23, 11, 7, 29, 33, 59, 8, 20, 9, 3, 2, 6, 10, 44, 83, 28, 5, 1, 0, 36};
		shell_Sort(array);
	}

}
