package sorting_and_searching;

public class QuickSort {
	public static void main(String[] args){
		QuickSort ms = new QuickSort();
		int[] arr = {9,3,8,4,-92};
		ms.quicksort(arr);
		for(int i = 0; i <arr.length; i++){
			System.out.println(arr[i]);
		}
	}
	public void quicksort(int[] array){
		int low = 0;
		int high = array.length-1;
		quicksort(array,low,high);
	}
	
	public void quicksort(int[] arr, int low, int high){
		if(low < high){
			int pi = partition(arr,low,high);
			quicksort(arr,low,pi-1);
			quicksort(arr,pi+1,high);
		}
	}
	public int partition(int[] arr,int low, int high){
		int partitionIndex = low-1;
		int pivot = arr[high];
		
		int i = low;
		while(i < high){
			if(arr[i] <= pivot){
				++partitionIndex;
				int temp = arr[partitionIndex];
				arr[partitionIndex] = arr[i];
				arr[i] = temp;
				
			}
			i++;
		}
		
		++partitionIndex;
		int temp = arr[partitionIndex];
		arr[partitionIndex] = pivot;
		arr[high] = temp;
		
		return partitionIndex;
		
		
	}
}
