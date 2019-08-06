package arrays_and_strings;

import java.util.Arrays;

public class URLify {
	public void urlify(char[] string, int actualSize){
		int spcs = countSpaces(string,actualSize);
		int oldIndex = actualSize -1;
		int finalIndex = oldIndex + spcs*2;
		
		for(int i = oldIndex; i >= 0; i--){
			if(string[i] == 0x20){  
				string[finalIndex] = '0';
				string[finalIndex-1] = '2';
				string[finalIndex-2] = '%';
				finalIndex = finalIndex-3;
				
			}
			else{
				string[finalIndex] = string[i];
				finalIndex--;
			}
			
		}
		
	}
	public int countSpaces(char[]string,int length){
		int spcs = 0;
		
		for(int i = 0; i<length;i++){
			if(string[i] == ' '){
				spcs++;
			}
		}
		return spcs;
	}
	public static void main(String[] args){
		URLify u = new URLify();
		
		char[] str = {'h','i',' ','m',' ',' ',' ',' ',' ',' ',' ',' ',' '};
		
		u.urlify(str,6);
		System.out.println(Arrays.toString(str));
	}
	
}
