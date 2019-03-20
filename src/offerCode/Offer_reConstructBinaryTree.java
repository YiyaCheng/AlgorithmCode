package offerCode;

import java.util.Arrays;

public class Offer_reConstructBinaryTree {
/**
 * 	输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 *	 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 	例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */

	
	public static void main(String[] args) {
		int[] preOrder={1,2,4,7,3,5,6,8};
		int[] inOrder={4,7,2,1,5,3,8,6};
		TreeNode node=buildTree(preOrder,inOrder);
		printTree(node);
		System.out.println();
		TreeNode node1=reConstructBinaryTree(preOrder,inOrder);
		printTree(node1);
	}
	
	public static TreeNode buildTree(int[] preOrder,int[] inOrder) {
		if(preOrder.length==0||inOrder.length==0)
			return null;
		
		
		TreeNode node=new TreeNode(preOrder[0]);
		//前序遍历第一个数字为当前的根节点
		
		for(int i=0;i<preOrder.length;i++) {
			if(preOrder[0]==inOrder[i]) {
				//copyOfRange(int[] original, int from, int to)
				//第一个参数表示源数组
				//第二个参数表示开始位置(取得到)
				//第三个参数表示结束位置(取不到)
				node.left=buildTree(Arrays.copyOfRange(preOrder,1,i+1),Arrays.copyOfRange(inOrder,0,i));
				node.right=buildTree(Arrays.copyOfRange(preOrder,i+1,preOrder.length),Arrays.copyOfRange(inOrder,i+1,inOrder.length));
			}
		}
		return node;
	}
	
	
	//方法二：
	public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		 
		if (pre == null || in == null || pre.length == 0 || in.length == 0 || pre.length != in.length) {
			return null;
		}
 
		int startPre = 0;
		int endPre = pre.length - 1;
		int startIn = 0;
		int endIn = in.length - 1;
 
		return reConstructBinaryTreeCore(pre, in, startPre, endPre, startIn, endIn);
 
	}
	
	/**
	 * @param pre
	 *            前序序列
	 * @param in
	 *            中序序列
	 * @param startPre
	 *            前序序列起始位置
	 * @param endPre
	 *            前序序列结束位置
	 * @param startIn
	 *            中序序列起始位置
	 * @param endIn
	 *            中序序列结束位置
	 * @return 前序序列范围代表一棵树或者是某棵子树 中序序列范围代表对应的那一棵树或者是某棵子树
	 */
	private static TreeNode reConstructBinaryTreeCore(int[] pre, int[] in, int startPre, int endPre, int startIn, int endIn) {
 
		// 前序序列的第一个节点就是根节点
		TreeNode root = new TreeNode(pre[startPre]);
		// 递归终止的结束条件
		if (startPre == endPre) {
			if (startIn == endIn && pre[startPre] == in[startIn]) {
				return root;
 
			}
		}
 
		// 在中序序列中找到值为startPre的索引
		int indexOfRoot;
		for (indexOfRoot = startIn; indexOfRoot <= endIn; indexOfRoot++) {
			if (in[indexOfRoot] == pre[startPre]) {
				break;
			}
		}
 
		if (indexOfRoot == endIn - startIn + 1) {
			System.out.println("输入不合法");
 
		}
		// 此时的indexOfRoot指向中序遍历中根节点的位置
		// 接下来求出左子树的前序范围、中序范围，右子树的前序范围、中序范围
		// 求出左、右子树的长度
		// 左子树的长度
		int leftTreeLength = indexOfRoot - startIn;
		int rightTreeLength = endIn - indexOfRoot;
 
		if (leftTreeLength > 0) {
			// 对左子树进行一次建树操作
			root.left = reConstructBinaryTreeCore(pre, in, startPre + 1, startPre + leftTreeLength, startIn,indexOfRoot - 1);
		}
 
		if (leftTreeLength < endPre - startPre) {
			// 如果有右子树，对右子树进行一次建树操作
			root.right = reConstructBinaryTreeCore(pre, in, endPre - rightTreeLength + 1, endPre, indexOfRoot + 1,endIn);
		}
		return root;
	}
	
	public static void printTree(TreeNode node) {
		if(node!=null) {
			printTree(node.left);
			System.out.print(node.val+" ");
			printTree(node.right);
		}
	}

}
class TreeNode {
	int val;
    TreeNode left;
    TreeNode right;
	TreeNode(int x) { val = x; }
}