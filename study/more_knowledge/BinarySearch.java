package more_knowledge;

public class BinarySearch {
	
	public static int searchIndex(int min, int max, int key, int[] arr){
		int middle_index = (min + max)/2;
		int middle_key = arr[middle_index];
		if(middle_key == key){
			return middle_index;
		}
		else if(middle_key > key){
			return searchIndex(min,middle_index-1, key, arr);
		}
		else {
			return searchIndex(middle_index+1, max, key, arr);
			
		}
	}
	
	public static void main(String[] args){
		int[] array = new int[4];
		for(int i = 0; i < array.length; i++){
			array[i] = i+1;
		}
		for(int i = 0; i < array.length; i++){
		}
		int index = searchIndex(0, array.length-1, 4,array);
		System.out.println(index);
	}
	
}
