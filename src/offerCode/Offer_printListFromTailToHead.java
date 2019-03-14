package offerCode;

import java.util.*;

public class Offer_printListFromTailToHead {
	/**
	 * 	题目描述：输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
	 */
	public static void main(String[] args) {
		ListNode node1=new ListNode(1);
		ListNode node2=new ListNode(2);
		ListNode node3=new ListNode(3);
		node1.next=node2;
        node2.next=node3;
        System.out.println(printListFromTailToHead1(node1));
        System.out.println(printListFromTailToHead2(node1));
	}
	
	static ArrayList<Integer> arrayList = new ArrayList<Integer>();
	public static ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
		//递归实现的思路
		if(listNode!=null) {
			printListFromTailToHead1(listNode.next);
			//到最后一个节点的时候开始存储数据到list中，从尾到头储存
			arrayList.add(listNode.val);
        }
		return arrayList;
    }
	
	//先把全部节点进栈存储，然后再弹栈遍历
	public static ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
		Stack<Integer> temp = new Stack<>(); //建立一个栈
        ArrayList<Integer> newList = new ArrayList<>(); 
        ListNode t = listNode;
             //将数据都先存入栈中
            while( t != null ){
                
                temp.push(t.val);
                t = t.next;
            }
            //遍历栈
            while( !temp.empty() ){
                newList.add(temp.pop());
            }
            return newList;
    }
	
}
 class ListNode {
	int val;
	ListNode next = null;
	ListNode(int val) {
		this.val = val;
	}
}
 
 
/*
 *	 第一次编译时出现：Java解决No enclosing instance of type PrintListFromTailToHead is accessible问题
 *	有两种解决办法：
 *	第一种：
 *	将内部类ListNode定义成静态static的类。
 *	第二种：
 *	将内部类ListNode在PrintListFromTailToHead类外边定义。
 */