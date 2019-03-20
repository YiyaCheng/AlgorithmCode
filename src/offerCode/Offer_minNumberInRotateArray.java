package offerCode;

public class Offer_minNumberInRotateArray {
	/**
	 * 题目描述：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 
	 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。 
	 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
	 *NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
	 */
	public static void main(String[] args) {
		int[] array1 = null;
        System.out.println("test1:" + minNumberInRotateArray(array1));
        
        int[] array2 = {1};
        System.out.println("test2:" + minNumberInRotateArray(array2));
        
        int[] array3 = {};
        System.out.println("test3:" + minNumberInRotateArray(array3));
        
        int[] array4 = {1,2,3,4,5,6};
        System.out.println("test4:" + minNumberInRotateArray(array4));
        
        int[] array5 = {2,1,2,2,2,2};
        System.out.println("test5:" + minNumberInRotateArray(array5));
        
        int[] array = { 6, 6, 8, 9, 10, 1, 2, 2, 3, 3, 4, 5, 6 };
        System.out.println("test6:" + minNumberInRotateArray(array));
	}
	
	public static int minNumberInRotateArray(int [] array) {
	    if(array==null||array.length==0)
	    	return 0;
	    int low=0;
	    int high=array.length-1;
	    int mid=(low+high)/2;
	    //升序数组
	    if(array[low]<array[high])
	    	return array[low];
	    //中间数字与首尾数字相等
        if (array[mid] == array[high] && array[mid] == array[low]) {
            for (int i = 1; i <= high; i++) {
                if (array[i] < array[i - 1])
                    return array[i];
            }
            return array[low];
        }
        //正常情况
        while(low<high) {
        	if(high-low==1)
        		break;
        	mid=(low+high)/2;
        	if(array[mid]<=array[high])
        		high=mid;
        	if(array[mid]>array[high])
        		low=mid;
        }
        return array[high];
    }

}
