package ZCY;

public class Practice_03 {
/**
 *	 给定一个数组arr，返回子数组的最大累加和。
 *	如arr=[1,-2,3,5,-2,6,-1],所有子数组中，[3,5,-2,6]可以累加出最大的和12，所以返回12.
 * @param args
 */
	public static int maxSum(int[] arr) {
		if(arr==null||arr.length==0) {
			return 0;
		}
		int max=Integer.MIN_VALUE;
		int cur=0;
		for(int i=0;i!=arr.length;i++) {
			cur+=arr[i];
			max=Math.max(max, cur);
			cur=cur<0?0:cur;
		}
		return max;
	}
	
	public static void main(String[] args) {
		int arr[]= {1,-2,3,5,-2,6,-1};
		int max=maxSum(arr);
		System.out.print(max);
	}

}
