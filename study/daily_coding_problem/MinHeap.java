package daily_coding_problem;
import java.util.Arrays;

import data_structures.BinaryHeap;

public class MinHeap implements BinaryHeap{

	private int[] heap;
	int size = 0;
	@Override
	/***
	 * return boolean whether the insert is successful or not
	 */
	public void insert(int val) {
		 if (size < heap.length){
			size++;
			heap[size-1] = val;
			int siftNodeIndex = size-1;
			while(heap[siftNodeIndex] < heap[get_parent_index(siftNodeIndex)] ){
				System.out.println(siftNodeIndex);
				siftNodeIndex = sift_up(siftNodeIndex);
			}
			
		}
		
	}

	@Override
	public int extract() {
		int extractedVal = heap[0];
		heap[0] = heap[size-1];
		size--;
		int siftNodeIndex = 0;
		//System.out.println(siftNodeIndex);
		//System.out.println(get_left_child_index(siftNodeIndex));
		while(siftNodeIndex != size-1 && (heap[siftNodeIndex] > heap[get_left_child_index(siftNodeIndex)] || heap[siftNodeIndex] > heap[get_right_child_index(siftNodeIndex)])){
			System.out.println(siftNodeIndex);
			siftNodeIndex = sift_down(siftNodeIndex);
		}
		
		return extractedVal;
		
	}

	public MinHeap(int capacity){
		heap = new int[capacity];
	}
	
	
	public int get_size(){
		return size;
	}
	
	public int get_parent_index(int childIndex){
		return childIndex/2;
	}
	
	public int get_left_child_index(int parentIndex){
		return parentIndex*2 +1;
	}
	
	public int get_right_child_index(int parentIndex){
		return parentIndex*2;
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
	
	public int sift_up(int siftNodeIndex){
		int parentIndex = get_parent_index(siftNodeIndex);
		int parentVal = heap[parentIndex];
		heap[parentIndex] = heap[siftNodeIndex];
		heap[siftNodeIndex] = parentVal;
		return parentIndex;
		
	}
	
	/***
	 * 
	 * @param siftNodeIndex
	 * @return new siftNodeIndex after sift
	 */
	public int sift_down(int siftNodeIndex){
		int leftChildIndex = get_left_child_index(siftNodeIndex);
		int rightChildIndex = get_right_child_index(siftNodeIndex);
		
		if(heap[siftNodeIndex] > heap[leftChildIndex] && heap[siftNodeIndex] > heap[rightChildIndex]){
			if(heap[leftChildIndex] >= heap[rightChildIndex]){
				swap(rightChildIndex, siftNodeIndex);
				return rightChildIndex;
			}
			else{
				swap(leftChildIndex,siftNodeIndex);
				return leftChildIndex;
			}
		}
		else if(heap[siftNodeIndex] > heap[rightChildIndex]){
			swap(rightChildIndex, siftNodeIndex);
			return rightChildIndex;
		}
		else if(heap[siftNodeIndex] > heap[leftChildIndex]){
			swap(leftChildIndex,siftNodeIndex);
			return leftChildIndex;
		}
		
		return siftNodeIndex;
		
	}
	
	public void swap(int index1, int index2){
		int index1Val = heap[index1];
		heap[index1] = heap[index2];
		heap[index2] = index1Val;
	}

	public void print(){
		System.out.println(Arrays.toString(heap));
	}
	
	public static void main(String[] args){
		MinHeap h = new MinHeap(6);
		h.print();
		h.insert(5);
		h.insert(10);
		h.insert(15);
		h.insert(30);
		h.print();
		int min = h.extract();
		System.out.println(min);
		h.print();
	}
}



