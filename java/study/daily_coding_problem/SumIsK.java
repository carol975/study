package daily_coding_problem;

import java.util.Arrays;
import java.util.HashSet;

public class SumIsK {
	/*
	 * Given a list of numbers and a number k, return whether any two numbers from the list add up to k.

		For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

		Bonus: Can you do this in one pass?
	 */
	//opt1: brute force O(n^2)
	
	//opt2: use set O(n)
	
	public static boolean sumIsK(Integer[] arr, int k){
		HashSet<Integer> set = new HashSet<Integer>();
		set.addAll(Arrays.asList(arr));
		if(set.contains(k)){
			return true;
		}
		else{
			for(int i = 0; i < arr.length; i++){
				if(set.contains(k-arr[i]) && k-arr[i] != arr[i]){ //can't use itself
					return true;
				}
			}
			return false;
		}
		
	}
	
	public static boolean sumIsK2(Integer[] arr, int k){
		HashSet<Integer> bag = new HashSet<Integer>();
		for(int i = 0; i < arr.length; i++){
			if(arr[i]==k){
				return true;
			}
			else if(bag.contains(k-arr[i])){
				return true;
			}
			else{
				bag.add(arr[i]);
			}
		}
		return false;
	}
	public static void main(String[] args){
		
		Integer[] arr = new Integer[]{0,4,4,7,10};
		int k = 8;
		System.out.println(sumIsK(arr,k));
		
		System.out.println(sumIsK2(arr,k));
		//k = 9;
		//System.out.println(sumIsK2(arr,k));
		
		
	}
}
