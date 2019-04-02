
public class QueueArray {
	private DynamicArray q;
	
	public QueueArray () {
		q = new DynamicArray();
	}
	
	public void enqueue (int val) {
		q.prepend(val);
	}
	
	public int dequeue() {
		return q.pop();
	}
	
	public boolean empty() {
		return q.isEmpty();
	}
	
	public boolean full() {
		return q.isFull();
	}
	
	public void print() {
		q.print();
	}
}
