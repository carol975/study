package dynamic_programming;

import java.util.ArrayList;
import java.util.List;

public class Parens {
	public static List<String> parens(int opened, int max, int used, String str){
		List<String> patterns = new ArrayList<String>();
		
		if (used >= max){
			StringBuilder newStr = new StringBuilder(str);
			while(opened > 0){
				newStr.append(')');
				opened--;
			}
			
			patterns.add(newStr.toString());

		}
		
		else{
			StringBuilder newStr = new StringBuilder(str);
			newStr.append('(');
			patterns.addAll(parens(opened+1, max,used+1, newStr.toString()));

			if(opened > 0){
				newStr = new StringBuilder(str);
				newStr.append(')');
				patterns.addAll(parens(opened-1, max,used, newStr.toString()));
			}

		}

		return patterns;
	}
	
	public static void main(String[] args){
		List<String> patterns = parens(0,4,0, new String());
		for(String pat:patterns){
			System.out.println(pat);
		}
	}
}
