package sortAlgorithms;

import java.util.Arrays;

/**
 * 归并排序（递归）
 *
 * ①. 将序列每相邻两个数字进行归并操作，形成 floor(n/2)个序列，排序后每个序列包含两个元素；
 * ②. 将上述序列再次归并，形成 floor(n/4)个序列，每个序列包含四个元素；
 * ③. 重复步骤②，直到所有元素排序完毕。
 * 平均时间复杂度 	    最好情况 	  	     最坏情况 	        空间复杂度
 * O(nlog₂n) 	O(nlog₂n) 	O(nlog₂n) 	O(n)
 */
public class MergeSort {

	public static void main(String[] args) {
		int[] array = {23, 11, 7, 29, 33, 59, 8, 20, 9, 3, 2, 6, 10, 44, 83, 28, 5, 1, 0, 36};
		mergeSort(array);
	}
	public static int[] mergeSort(int[] arr){
	    if(arr.length <= 1) return arr;

	    int num = arr.length >> 1;
	    int[] leftArr = Arrays.copyOfRange(arr, 0, num);
	    int[] rightArr = Arrays.copyOfRange(arr, num, arr.length);
	    System.out.println("split two array: " + Arrays.toString(leftArr) + " And " + Arrays.toString(rightArr));
	    return mergeTwoArray(mergeSort(leftArr), mergeSort(rightArr));      //不断拆分为最小单元，再排序合并
	}

	private static int[] mergeTwoArray(int[] arr1, int[] arr2){
	    int i = 0, j = 0, k = 0;
	    int[] result = new int[arr1.length + arr2.length];  //申请额外的空间存储合并之后的数组
	    while(i < arr1.length && j < arr2.length){      //选取两个序列中的较小值放入新数组
	        if(arr1[i] <= arr2[j]){
	            result[k++] = arr1[i++];
	        }else{
	            result[k++] = arr2[j++];
	        }
	    }
	    while(i < arr1.length){     //序列1中多余的元素移入新数组
	        result[k++] = arr1[i++];
	    }
	    while(j < arr2.length){     //序列2中多余的元素移入新数组
	        result[k++] = arr2[j++];
	    }
	    System.out.println("Merging: " + Arrays.toString(result));
	    return result;
	}
}
