package dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
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
	
	
	 public static List<String> generateParenthesis(int n) {
	        return genParen(0,0,n);
	    }
    public static List<String> genParen(int open, int used, int max){
        List<String> allParen = new ArrayList<String>();
        if(used == 0){
            String curr = "(";
            List<String> rest = genParen(open+1, used+1, max);
            for(String str : rest){
                allParen.add(curr + str);
            }
            return allParen;
        }
        else{
            if(used >= max){
                String str = "";
                while(open > 0){
                    str += ")";
                    open--;
                }
                allParen.add(str);
                return allParen;
            }
            else{
                String curr = "(";
                List<String> rest = genParen(open+1, used+1, max);
                for(String str : rest){
                    allParen.add(curr + str);
                    System.out.println(curr+str);
                }  
                
                if(open > 0){
                    curr = ")";
                    rest = genParen(open-1, used, max);
                    for(String str : rest){
                        allParen.add(curr + str);
                    } 
                }
                
                
                return allParen;
            }
        }
        
        
    }
	
	public static void main(String[] args){
		//List<String> patterns = parens(0,4,0, new String());
		/*
		String str = "abd, sbs sgs";
		String[] s = str.split("\\,\\s*");
		for(String a : s){
			System.out.println(a);
		}*/
		
		int[] a = {0,1,2,3,4};
		int[] b = {0,1,2,3,4};
		System.out.println(Arrays.toString(a).equals(Arrays.toString(b)));
	}
}
