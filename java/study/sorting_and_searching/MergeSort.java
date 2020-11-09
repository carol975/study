package sorting_and_searching;

public class MergeSort {
	public static void main(String[] args){
		MergeSort ms = new MergeSort();
		int[] arr = {1,3,4,5,0,0,0,0};
		int[] arr2 = {2,7,8,9};
		ms.mergeTwoArrays(arr,3,arr2);
		for(int i = 0; i <arr.length; i++){
			System.out.print(arr[i] + ",");
		}
	}
	public void mergeTwoArrays(int[] a, int aEnd, int[] b){
	    int[] temp = new int[aEnd+1 + b.length];
	    int index = 0;
	    for(int i = 0; i < aEnd+1; i++){
	        temp[index] = a[i];
	        index++;
	    }
	    
	    for(int i = 0; i < b.length; i++){
	        temp[index] = b[i];
	        a[index] = b[i];
	        index++;
	    }
	 
	    
	    
	    index = 0;
	    int i = 0;
	    int j = aEnd+1;

	    while( i <=aEnd && j <= temp.length){
	    	System.out.println(temp[i] + temp[j]);
	        if(temp[i] <= temp[j]){
	            a[index] = temp[i];
	            i++;
	        }
	        else{
	            a[index] = temp[j];
	            j++;
	        }
	        index++;
	    }
	    
	    while(i <= aEnd){
	        a[index] = temp[i];
	        index++;
	        i++;
	    }
	}
	public void mergeSort(int[] array){
		int low = 0;
		int high = array.length-1;
		int[] temp = new int[array.length];
		mergeSort(array,temp,low,high);
	}
	
	public void mergeSort(int[] array, int[] temp,int low, int high){
		if(low < high){
			int mid = (high+low)/2;
			mergeSort(array,temp,low, mid);
			mergeSort(array,temp,mid+1, high);
			merge(array,temp,low,mid,high);
		}
	}
	public void merge(int[] array, int[]temp, int low, int mid, int high){
		//copy array to a temp array
		for(int i = low; i <= high; i++){
			temp[i] = array[i];
		}
		
		
		int i = low;
		int j = mid +1;
		int arrayIndex = low;
		while(i <= mid && j <= high){
			if(temp[i] <= temp[j]){
				array[arrayIndex] = temp[i];
				++i;
			}
			else{
				array[arrayIndex] = temp[j];
				++j;
			}
			
			++arrayIndex;
		}
		
	
		while(i <= mid){
			array[arrayIndex] = temp[i];
			++arrayIndex;
			++i;
		}
		
		
		
	}
}
