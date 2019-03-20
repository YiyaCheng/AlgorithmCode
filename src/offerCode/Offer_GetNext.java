package offerCode;

public class Offer_GetNext {
	/**
	 * 	二叉树的下一个结点
	 * @description 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
	 * 	注意，树中的结点不仅包含左右子结点， 同时包含指向父结点的指针。
	 *
	 */
	
	// 测试用例使用的树
    //            1
    //          // \\
    //         2     3
    //       // \\
    //      4     5
    //    inorder : 42513
	public static void main(String[] args) {
		TreeLinkNode root=new TreeLinkNode(1);
		root.left = new TreeLinkNode(2);
        root.left.next = root;
        root.right = new TreeLinkNode(3);
        root.right.next = root;
        root.left.left = new TreeLinkNode(4);
        root.left.left.next = root.left;
        root.left.right = new TreeLinkNode(5);
        root.left.right.next = root.left;

        System.out.println(GetNext(root.left.left).val);
        System.out.println(GetNext(root.left).val);
        System.out.println(GetNext(root.left.right).val);
        System.out.println(GetNext(root).val);
        System.out.println(GetNext(root.right));
	}
	
	public static TreeLinkNode GetNext(TreeLinkNode pNode)
    {
		if(pNode==null)
            return null;
		//如果当前节点有右儿子，则它的下一个节点即为该右子树中最左侧的节点。
		else if(pNode.right!=null) {
			pNode=pNode.right;
			while(pNode.left!=null)
				pNode=pNode.left;
			return pNode;
		}
		/*如果当前节点没有右儿子，且该节点是它父节点的右子节点，
		 * 这种情况比较复杂，我们可以沿着该节点的父节点一直向上遍历，直到找到一个
		 * 节点是它父节点的左子节点，若该节点存在，则该节点的父节点就是我们要找的
		 * 下一个节点， 否则，该节点就没有下一个节点。*/
		while(pNode.next!=null&&pNode.next.right==pNode) {
				pNode=pNode.next;
		}
		return pNode.next;
    }

}
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;//父节点

    TreeLinkNode(int val) {
        this.val = val;
    }
}
