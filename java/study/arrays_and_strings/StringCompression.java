package arrays_and_strings;

public class StringCompression {
	public static void main(String[] args){
		StringCompression o = new StringCompression();
		System.out.println(o.strComp("aabcccccaaa"));
	}
	public String strComp(String str){
		char prev = ' ';
		int prevCount = 0;
		StringBuilder compStr = new StringBuilder();
		for(int i = 0; i < str.length(); i++){
			if(str.charAt(i) != prev){
				if(prev != ' '){
					compStr.append(prev + Integer.toString(prevCount));
				}
				prev = str.charAt(i);
				prevCount = 0;
				
			}
			prevCount++;
		}
		if(prev != ' '){
			compStr.append(prev + Integer.toString(prevCount));
		}
		if(compStr.length() > str.length()){
			return str;
		}
		return compStr.toString();
		
		
		
	}
}
