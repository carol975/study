package dynamic_programming;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	public List<String> permutationNoDups(int start, String str, List<String> permutations ){
		if(start >= str.length()){
			return null;
		}
		for(int i = start; i < str.length(); i++){
			char temp = str.charAt(start);
			StringBuilder newStr = new StringBuilder(str);
			newStr.setCharAt(start,newStr.charAt(i));
			newStr.setCharAt(i, temp);
			if(permutations.contains(newStr.toString()) == false){
				permutations.add(newStr.toString());
			}
			
			List<String> subperms = permutationNoDups(start+1, newStr.toString(), permutations);
			if(subperms != null ){
				for(String subperm : subperms){
					if(permutations.contains(subperm) == false){
						permutations.add(subperm);
					}
				}
			}
			
			
		}
		
		return permutations;
	}
	
	public static void main(String[] args){
		
		Permutations p = new Permutations();
		String str = new String("AAAC");
		List<String> permutations = p.permutationNoDups(0, str, new ArrayList<String>());
		
		for(String perm : permutations){
			System.out.println(perm);
		}
	}
}
