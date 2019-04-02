
public class Queue {
	private LinkedList q;
	
	public Queue () {
		this.q = new LinkedList();
	}
	
	public void enqueue(int val) {
		LinkedList.push_front(val, this.q);
	}
	
	public int dequeue() {
		return LinkedList.pop_back(this.q);
	}
	
	public boolean empty() {
		return LinkedList.empty(this.q);
	}
	
	public void print() {
		LinkedList.print(this.q);
	}
	
	
}
