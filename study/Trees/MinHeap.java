package Trees;
import java.util.Arrays;

public class MinHeap{
	/*
	public int[] heap;
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
	*/
	public void print(){
		for(int i = 0; i < size; i++){
			System.out.print(heap[i] + " ");
		}
		System.out.println(Arrays.toString(heap));
	}
	
	int[] heap;
	int size = 0;
	public MinHeap(int[] arr){
		heap = arr;
		Arrays.sort(heap);
		this.size = heap.length;
	}
	
	public void expandHeap(){
		int[] newHeap = new int[heap.length *2];
		for(int i = 0; i < heap.length; i++){
			newHeap[i] = heap[i];
		}
		
		heap = newHeap;
	}
	
	public void shrinkHeap(){
		int[] newHeap = new int[heap.length/2];
		for(int i = 0; i < size; i++){
			newHeap[i] = heap[i];
		}
		
		heap = newHeap;
	}
	public int getParentIndex(int currIndex){
		if(currIndex <= 0){
			return -1;
		}
		return (currIndex - 1)/2;
		
	}
	
	public void swap(int index1, int index2){
		int temp = heap[index1];
		heap[index1] = heap[index2];
		heap[index2] = temp;
	}
	public void insert(int val){
		if(this.size == heap.length){
			expandHeap();
		}
		size++;
		int valIndex = size-1;
		heap[valIndex] = val;
		int parentIndex = getParentIndex(valIndex);
		
		while(parentIndex != -1 && heap[valIndex] < heap[parentIndex] ){
			swap(valIndex, parentIndex);
			valIndex = parentIndex;
			parentIndex = getParentIndex(valIndex);
		
		}
	}
	
	public int getRightChildIndex(int parentIndex){
		int index = (parentIndex+1)*2;
		if(index >= size){
			return -1;
		}
		return index;
	}
	
	public int getLeftChildIndex(int parentIndex){
		int index = (parentIndex+1)*2 - 1;
		if(index >= size){
			return -1;
		}
		return index;
	}
	
	public int extract(){
		int min = heap[0];
		heap[0] = heap[size-1];
		size--;
		
		if(size == heap.length/4){
			shrinkHeap();
		}
		if(size != 0){
			int valIndex = 0;
			int lci = 0;
			int rci = 0;
			do{
				lci = getLeftChildIndex(valIndex);
				rci = getRightChildIndex(valIndex);
				if(lci != -1 && rci != -1){
					if(heap[valIndex] <=heap[lci] && heap[valIndex] <= heap[rci]){
						break;
					}
					else if(heap[lci] <= heap[rci]){
						swap(lci,valIndex);
						valIndex = lci;
					}
					else{
						swap(rci, valIndex);
						valIndex = rci;
					}
					
				}
				else if(lci != -1){
					if(heap[valIndex] < heap[lci]){
						swap(lci,valIndex);
						valIndex = lci;
					}
					else{
						break;
					}
				}
				else if(rci != -1){
					
					if(heap[valIndex] < heap[rci]){
						swap(rci,valIndex);
						valIndex = rci;
					}
					else{
						break;
					}
				}
				else{
					break;
				}
				
			}while(valIndex < size);
		}
		
		return min;
	}
	
	
	
	public static void main(String[] args){
		int[] arr = {-1,50,23,89,90,70};
		MinHeap h = new MinHeap(arr);
		h.print();
		h.insert(-5);
		h.insert(-6);
		h.print();
		h.extract();
		h.print();
		h.extract();
		h.print();
		h.insert(9090);
		h.print();
		h.insert(-100);
		h.print();
		h.extract();
		h.print();
		h.extract();
		h.print();
		h.extract();
		h.print();
		h.extract();
		h.print();
		h.extract();
		h.print();
	}
}



