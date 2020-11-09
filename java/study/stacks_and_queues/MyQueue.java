package stacks_and_queues;

import java.util.Stack;

public class MyQueue {
	
	Stack<Integer> reversedStack;
	Stack<Integer> stack;

	
	public MyQueue(){
		this.reversedStack = new Stack<Integer>();
		this.stack = new Stack<Integer>();
	}
	
	public Integer peek(){
		if(reversedStack.isEmpty()){
			if(stack.isEmpty()){
				return null;
			}
			while(stack.isEmpty() == false){
				reversedStack.push(stack.pop());
			}
			
		}
		return reversedStack.peek();
	}
	
	public void push(Integer val){
		this.stack.push(val);
	}
	
	public Integer pop(){
		if(reversedStack.isEmpty()){
			if(stack.isEmpty()){
				return null;
			}
			while(stack.isEmpty() == false){
				reversedStack.push(stack.pop());
			}
			
		}
		return reversedStack.pop();
	}
	
	public void sortStack(){
		Integer min = stack.pop();
		Stack<Integer> temp = new Stack<Integer>();
		while(stack.isEmpty() == false){
			if(stack.peek() < min){
				temp.push(min);
				min = stack.pop();
			}
			else{
				temp.push(stack.pop());
			}
		}
		
		temp.push(min);
		
		this.stack = temp;
	}
	
	public static void main(String[] args){
		
		MyQueue q = new MyQueue();
		q.stack.push(1);
		q.stack.push(5);
		q.stack.push(-1);
		q.stack.push(-2);
		q.sortStack();
		q.stack.pop();
		q.sortStack();
		
		System.out.println(q.stack.peek());
	}
}
