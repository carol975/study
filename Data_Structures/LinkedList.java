
public class LinkedList {
	private class Node {
		int val;
		Node next;
		
		public Node(int val) {
			this.val = val;
			this.next = null;
		}
	}
	
	Node head = null;
	
	public static int size(LinkedList list){
		if(list.head == null){
			return 0;
		}
		else {
			Node temp = list.head;
			int size = 0;
			while(temp != null ){
				size++;
				temp = temp.next;
			}
			return size;
		}
	}
	
	public static boolean empty(LinkedList list){
		if(list.head == null){
			return true;
		}
		return false;
	}
	
	public static int value_at(int index, LinkedList list){
		if(index < 0 || index >= LinkedList.size(list)){
			return -1;
		}
		Node temp = list.head;
		for(int i = 0; i < index; i++){
			temp = temp.next;
		}
		return temp.val;
	}
	
	public static int push_front(int val, LinkedList list){
		Node temp = list.head;
		Node newHead = list.new Node(val);
		newHead.next = temp;
		list.head = newHead;
		return list.head.val;
	}
	
	
	public static int pop_front(LinkedList list){
		
		if(list.head == null) {
			return -1;
		}
		int val = list.head.val;
		list.head = list.head.next;
		return val;
	}
	
	public static int push_back(int val, LinkedList list){
		Node newTail = list.new Node(val);
		if(list.head == null){
			list.head = newTail;
			return list.head.val;
		}
		
		else{
			Node temp = list.head;
			while(temp.next != null){
				temp = temp.next;
			}
			temp.next = newTail;
			return temp.next.val;
		}
		
		
	}
	
	public static int pop_back(LinkedList list){
		int val;
		
		if(list.head == null) {
			return -1;
		}
		else if(list.head.next == null) {
			val = list.head.val;
			list.head = null;
			return val;
		}
		
		Node curr = list.head;
		Node prev = curr;
		while(curr.next != null){
			prev = curr;
			curr = curr.next;
		}
		val = curr.val;
		prev.next = null;
		return val;
	}
	
	public static int front(LinkedList list){
		return list.head.val;
	}
	
	public static int back(LinkedList list){
		Node temp = list.head;
		while(temp.next != null){
			temp = temp.next;
		}
		return temp.val;
	}
	
	public static LinkedList insert(int index, int val, LinkedList list){
		if(index < 0 || index >= LinkedList.size(list)){
			return null; 
		}
		Node newNode = list.new Node(val);
		
		if(index == 0){
			LinkedList.push_front(val, list);
		}
		
		else{
			Node curr = list.head;
			Node prev = curr;
			
			
			for(int i = 0; i < index; i++){
				prev = curr;
				curr = curr.next;	
			}
			
			prev.next = newNode;
			newNode.next = curr;
		}
		return list;
		
		
		
		
	}
	

	
	public static LinkedList erase(int index, LinkedList list){

		
		if(index < 0 || index >= LinkedList.size(list)){
			return null;
		}
		
		if(index == 0){
			LinkedList.pop_front(list);
			return list;
		}
		
		Node curr = list.head;
		Node prev = curr;
		
		for(int i = 0; i < index; i++){
			prev = curr;
			curr = curr.next;
		}
		prev.next = curr.next;
		curr = null;
		return list;
	}
	
	//R to indicate counting from the tail(right) to the head(left)
	public static int value_n_from_end(int indexR, LinkedList list){
		if(indexR < 0 || indexR >= LinkedList.size(list)){
			return -1; 
		}
		
		int indexL = LinkedList.size(list) - 1 - indexR;
		Node temp = list.head;
		for(int i = 0; i < indexL; i++){
			temp = temp.next;
		}
		return temp.val;
	}
	
	public static LinkedList reverse(LinkedList list){
		LinkedList reversedList = new LinkedList();
		while(list.head != null){
			int val = LinkedList.pop_front(list);
			LinkedList.push_front(val, reversedList);
		}
		list.head = reversedList.head;
		return list;
	}
	
	
	public static int remove_value(int val, LinkedList list){
		
		int rmd_val = -1;
		if(list.head.val == val){
			rmd_val =  list.head.val;
			list.head = list.head.next;
		}
		else{
			Node curr = list.head;
			Node prev = curr;
			
			while(curr.val != val){
				prev = curr;
				curr = curr.next;
			}
			
			rmd_val = curr.val;
			prev.next = curr.next;
			curr = null;
		}
		
		return rmd_val;
	}
	
	public static void print(LinkedList list){
		Node temp = list.head;
		while(temp != null){
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		System.out.print("\r\n");
	}
	
	public static void main (String[] args){
		LinkedList list = new LinkedList();
		LinkedList.push_front(4,list);
		LinkedList.push_front(0,list);		
		LinkedList.push_front(1,list);
		LinkedList.push_front(2,list);
		LinkedList.push_front(3,list);
		LinkedList.push_front(4,list);
		LinkedList.push_front(4,list);
		LinkedList.push_front(4,list);
		LinkedList.print(list);
		
		LinkedList.remove_value(4,list);
		LinkedList.print(list);
		
	}
	
}
