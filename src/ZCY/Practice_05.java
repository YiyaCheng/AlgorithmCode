package ZCY;

public class Practice_05 {

	/**
	 * 	给定一个二维数组，所有位置的值不是0就是1。规定每个位置可以和它上下左右位置上的值相连。
	 * 	有一个叫做岛的概念，定义如下：连成一片的1，如果周围都是0，那么这一片1构成一个岛。
	 * 	求整张图上有多少个岛。
	 * 0 0 0 0 0 0 0 0 0
	 * 0 1 1 0 0 1 1 1 0
	 * 0 1 1 0 0 0 0 1 0
	 * 0 1 1 1 0 0 0 0 0
	 * 0 0 0 0 0 1 1 0 0
	 * 0 0 0 0 1 1 1 0 0
	 * 0 0 0 0 0 0 0 0 0
	 * 	这张图上有3个岛
	 */
	public static void main(String[] args) {
		int[][] m1 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
		        { 0, 1, 1, 1, 0, 1, 1, 1, 0 }, 
		        { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
		        { 0, 1, 1, 0, 0, 0, 0, 0, 0 }, 
		        { 0, 0, 0, 0, 0, 1, 1, 0, 0 }, 
		        { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
		        { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
		System.out.println(countIslands(m1));

		int[][] m2 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
				{ 0, 1, 1, 1, 1, 1, 1, 1, 0 }, 
				{ 0, 1, 1, 1, 0, 0, 0, 1, 0 },
				{ 0, 1, 1, 0, 0, 0, 1, 1, 0 }, 
				{ 0, 0, 0, 0, 0, 1, 1, 0, 0 }, 
				{ 0, 0, 0, 0, 1, 1, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
		System.out.println(countIslands(m2));
	}
	
	public static int countIslands(int[][] m) {
		if (m == null || m[0] == null) {
			return 0;
		}
		int N = m.length;
		int M = m[0].length;
		int res = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (m[i][j] == 1) {
				//如果当前位置是1才可能发生一次大感染，所以已经感染过的点在大过程中不会重复触碰
				//所以计算碰到1的次数就是岛的个数
					res++;
					infect(m, i, j, N, M);
				}
			}
		}
		return res;
	}

	public static void infect(int[][] m, int i, int j, int N, int M) {
		//越界或者遇到的不是1直接返回
		if (i < 0 || i >= N || j < 0 || j >= M || m[i][j] != 1) {
			return;
		}
		//用2标记结点已经访问，避免进行多次无效递归
		m[i][j] = 2;
		infect(m, i + 1, j, N, M);
		infect(m, i - 1, j, N, M);
		infect(m, i, j + 1, N, M);
		infect(m, i, j - 1, N, M);
	}
}
