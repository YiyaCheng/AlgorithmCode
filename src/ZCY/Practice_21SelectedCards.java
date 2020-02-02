package ZCY;

public class Practice_21SelectedCards {
	/**
	 * 给定一个整形数组arr，代表数值不同的纸牌排成一条线，玩家A和玩家B依次拿走每张纸牌，
	 * 规定玩家A先拿，但每个玩家每次只能拿走最左或最右的纸牌，玩家A和玩家B都是绝顶聪明。
	 * 请返回最后获胜者的分数。
	 * 
	 * 举例：arr=[1,2,100,4]，开始时，玩家A只能拿1或4，如果玩家A拿走1，则玩家B可
	 * 以拿2或4，然后继续A拿，如果开始时A拿走4，则B可以拿100。因为A绝顶聪明，不会让B
	 * 拿100，因为B拿了100，不论B在拿什么都是胜者，所以A会拿1。
	 */
	
	// 暴力尝试
    public static int win1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        return Math.max(f(arr, 0, arr.length - 1), s(arr, 0, arr.length - 1));
    }
    
    /**
     * i==j时，就一张牌，直接返回arr[i]；否则该人只能拿arr[i]或arr[j]：
               *     拿arr[i],剩下的arr[i+1...j]他变成后拿的人；拿arr[j],剩下的arr[i...j-1]他变成后拿的人；
               *     所以函数返回max(arr[i]+s[i+1][j], arr[j]+s[i][j-1])
     */
    //在数组arr的i到j上先拿
    public static int f(int[] arr, int i, int j) {
    	//如果只有一个元素，先拿就别无选择
        if (i == j) {
            return arr[i];
        }
        return Math.max(arr[i] + s(arr, i + 1, j), arr[j] + s(arr, i, j - 1));
    }
    
    /**
     * i==j时，先拿的拿走，后拿的没有，返回0；否则
	     * 先拿的人可能拿走arr[i]或arr[j].由于先拿的也是绝顶聪明
	     * 所以函数返回min(f[i+1][j],f[i][j-1])
     */
    //在数组arr的i到j上后拿
    public static int s(int[] arr, int i, int j) {
        //如果只剩一个元素，后那肯定什么都拿不到了
    	if (i == j) {
            return 0;
        }
        return Math.min(f(arr, i + 1, j), f(arr, i, j - 1));
    }

    // 单独调用自己的暴力尝试
    public static int process(int[] arr, int i, int j) {
        if (i == j) {
            return arr[i];
        }
        if (i == j - 1) {
            return Math.max(arr[i], arr[j]);
        }
        return Math.max(arr[i] + Math.min(process(arr, i + 2, j), process(arr, i + 1, j - 1)),
                arr[j] + Math.min(process(arr, i + 1, j - 1), process(arr, i, j - 2))
        );
    }
    
    // 动态规划
    public static int win2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[][] f = new int[arr.length][arr.length];
        int[][] s = new int[arr.length][arr.length];
        for (int j = 0; j < arr.length; j++) {
            f[j][j] = arr[j];
            for (int i = j - 1; i >= 0; i--) {
                f[i][j] = Math.max(arr[i] + s[i + 1][j], arr[j] + s[i][j - 1]);
                s[i][j] = Math.min(f[i + 1][j], f[i][j - 1]);
            }
        }
        return Math.max(f[0][arr.length - 1], s[0][arr.length - 1]);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 9, 1 };
        System.out.println(win1(arr));
        System.out.println(win2(arr));

    }

}
