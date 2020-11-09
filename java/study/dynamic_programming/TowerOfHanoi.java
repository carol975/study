package dynamic_programming;

import java.util.Stack;

public class TowerOfHanoi {
	public static void main(String[] args){
		TowerOfHanoi t = new TowerOfHanoi();
		Stack<Integer> start = new Stack<Integer>();
		start.push(5);
		start.push(4);
		start.push(3);
		start.push(2);
		start.push(1);
		Stack<Integer> result = t.towerofhanoi(start.size(), start, new Stack<Integer>(),new Stack<Integer>());
		System.out.println("size" + result.size());
		while(result.isEmpty() == false){
			System.out.println(result.pop());
		}
		
	}
	public Stack<Integer> towerofhanoi (int size, Stack<Integer> start, Stack<Integer> buf, Stack<Integer> dst){
		if(size == 1){
			dst.push(start.pop());
			return dst;
		}
		else if(size == 2){
			
			buf.push(start.pop());
			dst.push(start.pop());
			dst.push(buf.pop());

			return dst;
		}
		
		else{
			buf = towerofhanoi(size-1, start, dst, buf);
			dst.push(start.pop());
			return towerofhanoi(size-1, buf, start, dst);
		}
	}
}
