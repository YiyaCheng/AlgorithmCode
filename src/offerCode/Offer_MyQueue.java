package offerCode;

import java.util.Stack;

public class Offer_MyQueue {
	//用两个栈实现队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
	static Stack<Integer> stack1 = new Stack<Integer>();//作为进队的端口
    static Stack<Integer> stack2 = new Stack<Integer>();//作为出队的端口
    
	public static void main(String[] args) {
		push(1);
        push(2);
        push(3);
        push(4);
        System.out.println(pop());
	}
	
    
    public static void push(int node) {
    	//将stack2的全部内容放入stack1中
        while(!stack2.isEmpty()) {
        	stack1.push(stack2.pop());
        }
        
        stack1.push(node);
        while(!stack1.isEmpty()) {
        	stack2.push(stack1.pop());
        }
    }
    
    public static int pop() {
    	return stack2.pop();
    }
}
