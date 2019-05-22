package sortAlgorithms;

import java.util.Arrays;
import java.util.Stack;

/**
 * 快速排序（非递归）
 *
 * ①. 从数列中挑出一个元素，称为"基准"（pivot）。
 * ②. 重新排序数列，所有比基准值小的元素摆放在基准前面，所有比基准值大的元素摆在基准后面（相同的数可以到任一边）。在这个分区结束之后，该基准就处于数列的中间位置。这个称为分区（partition）操作。
 * ③. 把分区之后两个区间的边界（low和high）压入栈保存，并循环①、②步骤
 * @param arr   待排序数组
 */
public class QuickSort2 {

	public static void quickSortByStack(int[] arr){
	    if(arr.length <= 0) return;
	    Stack<Integer> stack = new Stack<Integer>();

	    //初始状态的左右指针入栈
	    stack.push(0);
	    stack.push(arr.length - 1);
	    while(!stack.isEmpty()){
	        int high = stack.pop();     //出栈进行划分
	        int low = stack.pop();

	        int pivotIdx = partition(arr, low, high);

	        //保存中间变量
	        if(pivotIdx > low) {
	            stack.push(low);
	            stack.push(pivotIdx - 1);
	        }
	        if(pivotIdx < high && pivotIdx >= 0){
	            stack.push(pivotIdx + 1);
	            stack.push(high);
	        }
	        System.out.println("Sorting:  " + Arrays.toString(arr));
	    }
	}

	private static int partition(int[] arr, int low, int high){
	    if(arr.length <= 0) return -1;
	    if(low >= high) return -1;
	    int l = low;
	    int r = high;

	    int pivot = arr[l];    //挖坑1：保存基准的值
	    while(l < r){
	        while(l < r && arr[r] >= pivot){  //坑2：从后向前找到比基准小的元素，插入到基准位置坑1中
	            r--;
	        }
	        arr[l] = arr[r];
	        while(l < r && arr[l] <= pivot){   //坑3：从前往后找到比基准大的元素，放到刚才挖的坑2中
	            l++;
	        }
	        arr[r] = arr[l];
	    }
	    arr[l] = pivot;   //基准值填补到坑3中，准备分治递归快排
	    return l;
	}
	
	public static void main(String[] args) {
		int[] array = {23, 11, 7, 29, 33, 59, 8, 20, 9, 3, 2, 6, 10, 44, 83, 28, 5, 1, 0, 36};
		quickSortByStack(array);
	}

}
