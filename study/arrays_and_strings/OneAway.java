package arrays_and_strings;

public class OneAway {
	public static void main(String[] args){
		OneAway o = new OneAway();
		System.out.println(o.oneEditAway("bake", "bak"));
	}
	public boolean oneEditAway(String a, String b){
		if(a.length() == b.length()){
			return checkReplace(a,b);
		}
		else if(Math.abs(a.length() - b.length()) == 1){
			return checkInsertion(a,b);
		}
		return false;
	}
	
	public boolean checkReplace(String a, String b){
		boolean replChar = false;
		for(int i =0; i <a.length(); i++){
			if(a.charAt(i) != b.charAt(i)){
				if(replChar == true){
					return false;
				}
				replChar = true;
			}
		}
		return true;
	}
	
	public boolean checkInsertion(String a, String b){
		if(a.length() > b.length()){
			return checkInsertion(b,a);
		}
		
		int i = 0;
		int j = 0;
		boolean insertNeeded = false;
		while( i < a.length()){
			if(a.charAt(i)!= b.charAt(j)){
				if(insertNeeded == true){
					return false;
				}
				insertNeeded = true;
				j++;
			}
			else{
				i++;
				j++;
			}
		}
		return true;
		
	}
	
}
