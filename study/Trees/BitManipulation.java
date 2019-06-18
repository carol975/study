package Trees;

public class BitManipulation {
	
	public static int insertion(int n, int m, int i, int j){
		/*
		int maskLeft = ((1 << j) - 1) << j+1;
		int maskRight = (1 << i)-1;
		int mask =  maskLeft | maskRight;
		*/
		int mask = (1 << (j - i + 1)) -1  << i;
		mask = ~mask;
		return (mask & n) | (m << i);
	}
	
	public static String BinaryTToString(double num){
		if(num >= 1.0 || num <= 0.0){
			return "ERROR";
		}
		StringBuilder s = new StringBuilder(".");
		while(num != 0.0 ){
			if(s.length() > 32){
				return "ERROR";
			}
			num = num * 2;
			int newDigit = num >= 1? 1 : 0;
			s.append(String.valueOf(newDigit));
			num = num - newDigit;

		}
		
		return s.toString();
	}
	
	public static String BinaryToString(double num){
		if(num >= 1 || num <=0){
			return "ERROR";
		}
		
		StringBuilder binary = new StringBuilder();
		binary.append(".");
		
		while( num > 0){
			if(binary.length() >= 32){
				return "ERROR";
			}
			
			double r = num *2;
			if(r >= 1){
				binary.append(1);
				num = r -1;
			}
			else{
				binary.append(0);
				num = r;
			}
		}
		return binary.toString();
	}
	
	public static Integer FlipBitToWin(int num){
		String s = Integer.toBinaryString(num);
		int maxLen = CountMaxContinuousOnes(s);
		for(int i = s.length()-1; i >= 0; i--){
			if(s.charAt(i) == '0'){
				StringBuilder str = new StringBuilder(s);
				str.setCharAt(i, '1');
				int currLen = CountMaxContinuousOnes(str.toString());
				maxLen = currLen>= maxLen ? currLen:maxLen;
			}
			
		}
		return maxLen;

	}
	
	public static Integer CountMaxContinuousOnes(String num){
		int maxOnes = 0;
		int currOnes = 0;
		for(int i = 0; i < num.length(); i++){
			if(num.charAt(i) == '1'){
				currOnes++;
				if(currOnes >= maxOnes){
					maxOnes = currOnes;
				}
			}
			else{
				currOnes = 0;
			}
		}
		return maxOnes;
	}
	
	public static int FlipBitToWinSol(int num){
		if(~num == 0){
			return Integer.BYTES * 8;
		}
		int maxLen = 1;
		int currLen = 0;
		int prevLen = 0;
		int tempLen = 0;
		while(num !=0) {
			if((num & 1) == 1){
				currLen++;
			}
			
			else{
				if((num & 2) == 2){
					prevLen = currLen;
				}
				else{
					prevLen = 0;
				}
				currLen = 0;
			}
			
			tempLen = currLen + prevLen + 1;
			if(tempLen> maxLen){
				maxLen = tempLen;
			}  
			num = num >>>1; 
		}
		return maxLen;
	}
	
	public void NextNumber(int num){
		int smallest = 0;
		int largest = 0;
		if(Integer.bitCount(num) ==1){
			largest = num << 2;
			smallest = num >> 1;
		}
		
		if((num & 1) == 0){
			smallest = num >>> 1;
			
		}
		else{
			
		}
	}
	
	public static int getPrev(int num){
		if(num <= 1){
			return -1;
		}
		int c = num;
		int c0 = 0;
		int c1 = 0;
		
		//count trailing 1s
		while((c != 0) && ((c & 1) == 1)){
			c1++;
			c >>= 1;
		}
		
		//count 0s leading to the rightmost non-trailing 1
		while((c & 1) == 0 ){
			c0++;
			c >>= 1;
		}
		
		
		int p = c0 + c1;
		
		int mask = ~(1 << p);
		num = num & mask; //flip rightmost non-trailing 1 to 0
		num = num & (~((1 << p)-1)); //clear all digits to the right of the flipped bit to zero
		mask = ((1<<(c1+1)) -1) << (c0-1) ; // c1 -1 1s
		num = num | mask; //add  c1-1 1s
		return num;
	}
	
	public static int getNext(int num){
		int c = num;
		int c0 = 0;
		int c1 = 0;
		
		//count trailing 0s
		while((c != 0) && ((c & 1) == 0)){
			c0++;
			c >>= 1;
		}
		
		//count 1s leading to the rightmost non-trailing 0
		while((c & 1) == 1){
			c1++;
			c >>= 1;
		}
		
		
		if(c0 + c1 == 31 || c0 + c1 == 0){
			return -1;
		}
		
		int p = c0 + c1;
		
		int mask = (1 << p);
		num = num | mask; //flip right most non-trailing zero to 1
		num = num & (~(mask-1)); //clear all digits to the right of the flipped bit to zero
		mask = (1<<(c1-1)) -1 ; // c1 -1 1s
		num = num | mask; //add  c1-1 1s
		return num;
		
		
		
	}
	public static void NextNumberBruteForce(int val){
		int largest = val+1;
		int smallest = val-1;
		while(largest <= Integer.MAX_VALUE){
			if(Integer.bitCount(largest) == Integer.bitCount(val)){
				break;
			}
			largest++;
		}
		
		while(smallest >= 0){
			if(Integer.bitCount(smallest) == Integer.bitCount(val)){
				break;
			}
			smallest--;
		}
		
		System.out.println(val + "," + Integer.toBinaryString(val) + ">" +largest+ ","  + Integer.toBinaryString(largest) + "," + smallest + "," + Integer.toBinaryString(smallest));
		
	}
	
	public static int pairSwap(int num){
		int oddMask = 0x55555555; //...010101
		int evenMask = 0xAAAAAAAA; //101010...
		
		num = ((num & oddMask) << 1) | ((num & evenMask) >> 1);
		return num;
	}
	
	
	public static void main(String[] args){
		System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
		System.out.println(Integer.toBinaryString(pairSwap(Integer.MAX_VALUE)));
		
	}
}
