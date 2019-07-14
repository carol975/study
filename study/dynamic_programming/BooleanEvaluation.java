package dynamic_programming;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
public class BooleanEvaluation {
	/*
	public int booleanEvaluation (StringBuilder exp, boolean desiredResult, int startIndex, ScriptEngine engine) throws ScriptException{
		if(exp.length() < 3 || startIndex >= exp.length()){
			return 0;
		}
		int rightExp = 0;
		exp.insert(startIndex, '(');
		System.out.println(exp);
		int i = startIndex+4;
		System.out.println(i);
		System.out.println(i <= exp.length());
		while(i <= exp.length()){
			System.out.println("i"+i);
			exp.insert(i, ')');			
			System.out.println(exp.toString());
			int r = (int)engine.eval(exp.toString());
			System.out.println(r);
			boolean result = false;
			if(r == 1){
				result = true;
			}
			if( result == desiredResult){
				rightExp++;
			}
			System.out.println("length" + exp.length());
			System.out.println("i+2" + (i+2));
			System.out.println(exp.charAt(i+2));
			rightExp+= booleanEvaluation(exp, desiredResult, i+2, engine);
			
			exp.deleteCharAt(i);
			i+=2;
		}
		
		
		for(i = startIndex+4; i <= exp.length(); i+=2){
			System.out.println("i"+i);
			exp.insert(i, ')');			
			System.out.println(exp.toString());
			int r = (int)engine.eval(exp.toString());
			System.out.println(r);
			boolean result = false;
			if(r == 1){
				result = true;
			}
			if( result == desiredResult){
				rightExp++;
			}
			System.out.println("length" + exp.length());
			System.out.println("i+2" + (i+2));
			System.out.println(exp.charAt(i+2));
			rightExp+= booleanEvaluation(exp, desiredResult, i+2, engine);
			
			exp.deleteCharAt(i);
		}
		
		exp.deleteCharAt(startIndex);
		return  rightExp;
	}
	*/
	
	public static int countEval(String exp, boolean result){
		if(exp.length() == 0){
			return 0;
		}
		if(exp.length() ==1 ){
			if(exp.charAt(0) == '1' && result == true){
				return 1;
			}
			else if(exp.charAt(0) == '0' && result == false){
				return 1;
			}
			return 0;
		}
		
		int totalTrue = 0;
		int total = 0;
		for(int i = 1; i < exp.length(); i+=2){
			String left = exp.substring(0, i);
			String right = exp.substring(i+1,exp.length());
			char op = exp.charAt(i);
			int rightTrue = countEval(right, true);
			int leftTrue = countEval(left, true);
			int rightFalse = countEval(right, false);
			int leftFalse = countEval(left, false);
			
			total += (leftTrue + leftFalse) * (rightTrue + rightFalse);
			
			
			if(op == '&'){
				totalTrue += leftTrue * rightTrue;
			}
			else if(op == '|'){
				totalTrue += leftTrue * rightTrue + leftTrue * rightFalse + leftFalse * rightTrue;
			}
			else{
				totalTrue += leftTrue * rightFalse + leftFalse * rightTrue;
			}
			
			
		}
		
		if(result == true){
			return totalTrue;
		}

		return total-totalTrue;
		
		
	}
	
	public static void main(String[] args) throws ScriptException{
		System.out.println(countEval(new String("1^0|0|0|1"), true));
	}
}
