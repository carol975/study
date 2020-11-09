package daily_coding_problem;

import java.util.LinkedList;

public class LongSubstr {	
	public int lengthOfLongestSubstring(String s){
		LinkedList<Character> substr = new LinkedList<Character>();
		int length = 0;
		for(int i=0; i<s.length(); i++){
			char c = s.charAt(i);
			if(substr.contains(c)){
				for(int j=0;j<substr.size(); j++){
					if(substr.equals(c)){
						substr.remove(j);
						break;
					}
					else {
						substr.remove(j);
					}
					
				}
				
				substr.add(c);
				length = maxLength(length,substr.size());
			}
			else {
				substr.add(c);
				length++;
			}
			
		}
		return length;
	}
	
	public int maxLength(int l1, int l2){
		if(l1>=l2){
			return l1;
		}
		return l2;
	}
}
