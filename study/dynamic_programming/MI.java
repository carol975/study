package dynamic_programming;

public class MI {
	public static int[] modArray(int[] arr){
		for(int i = 0; i < arr.length-1; i++){
			if(arr[i] == arr[i+1]){
				arr[i] *=2;
				arr[i+1] = 0;
				i++; //skip the next one
			}
			
		}
		
		int i = 0;
		int j = arr.length-1;
		//System.out.println(j);
		while(i != j && i < arr.length && j>=0){
			if(arr[i] != 0){
				i++;
			}
			else{
				int temp = arr[i];
				//System.out.println(temp);
				arr[i] = arr[j];
				arr[j] = temp;
				j--;
			}
		}
		
		return arr;
		
	}
	
	public static void main(String[] args){
		int[] arr = {2,2,0,4,0,8};
		arr = modArray(arr);
		for(int i =0; i < arr.length; i++){
			System.out.println(arr[i]);
		}
	}
}
