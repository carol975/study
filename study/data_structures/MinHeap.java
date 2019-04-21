package data_structures;
import java.util.Arrays;

public class MinHeap implements BinaryHeap{

	private int[] heap;
	int size = 0;
	@Override
	public void insert(int val) {
		 if (size < heap.length){
			
			heap[size] = val;
			int siftNodeIndex = size;
			size++;
	        sift_up(siftNodeIndex);
		}
		
	}

	@Override
	public int extract() {
		
		int extractedVal = heap[0];
		heap[0] = heap[size-1];
		size--;
		int siftNodeIndex = 0;
		sift_down(siftNodeIndex);
		return extractedVal;
		
	}

	public MinHeap(int capacity){
		heap = new int[capacity];
	}
	
	
	public int get_size(){
		return size;
	}
	
	public int get_parent_index(int childIndex){
		return (childIndex-1 )/2;
	}
	
	public int get_left_child_index(int parentIndex){
		return parentIndex*2 +1;
	}
	
	public int get_right_child_index(int parentIndex){
		return parentIndex*2+2;
	}
	
	public boolean isEmpty(){
		return size == 0? true:false;
	}
	
	public int get_max(){
		if(!isEmpty()){
			return heap[0];
		}
		else{
			return Integer.MIN_VALUE;
		}
	}
	
	public void sift_up(int siftNodeIndex){
		
		if(siftNodeIndex !=0 &&  heap[siftNodeIndex] < heap[get_parent_index(siftNodeIndex)] ){
			int parentIndex = get_parent_index(siftNodeIndex);
			swap(parentIndex, siftNodeIndex);
			sift_up(parentIndex);
		}
		
		
		
	}
	
	public void sift_down(int siftNodeIndex){
		
		if(siftNodeIndex < size/2){ //check if not leaf node
			int leftChildIndex = get_left_child_index(siftNodeIndex);
			int rightChildIndex = get_right_child_index(siftNodeIndex);
			
			
			if(heap[siftNodeIndex] > heap[leftChildIndex] || heap[siftNodeIndex] > heap[rightChildIndex]){
				if(heap[leftChildIndex] >= heap[rightChildIndex]){
					swap(rightChildIndex, siftNodeIndex);
					sift_down(rightChildIndex);
				}
				else{
					swap(leftChildIndex,siftNodeIndex);
					sift_down(leftChildIndex);
				}
			}
		}

		
		
		
	}
	
	public void swap(int index1, int index2){
		int index1Val = heap[index1];
		heap[index1] = heap[index2];
		heap[index2] = index1Val;
	}

	public void print(){
		for(int i = 0; i < size; i++){
			System.out.print(heap[i] + " ");
		}
		System.out.println(Arrays.toString(heap));
	}
	
	public static MinHeap heapify(int[] arr){
		MinHeap h = new MinHeap(arr.length);
		for(int i = 0; i < arr.length;i++){
			h.insert(arr[i]);
		}
		return h;
	}
	
	public static void main(String[] args){
		int[] arr = {-1,50,23,89,90,70,8000,9000};
		MinHeap h = MinHeap.heapify(arr);
		h.print();
		h.extract();
		h.print();
		//h.extract();
		//h.print();
		//h.insert(9090);
		//h.print();
		//h.insert(-100);
		//h.print();
	}
}



