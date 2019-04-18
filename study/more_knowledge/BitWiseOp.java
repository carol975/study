package more_knowledge;

public class BitWiseOp {
	public static int abs(int n){
		if(n < 0){
			n = ~n + 1;
		}
		return n;
	}
	public static void main(String[] args){
		//2's complement: two binary nums that add up to 2^N
		//binary representation of a positive num to -(num)
		//pos => neg
		
		int n = 15; //0b1111
		n = ~n; //(1)0000 negate each bit
		n += 1; //(1)0001+1 => 2's complement representation
		
		// & bitwise-AND
		n = 15;
		int a = n & (~n + 1);
		System.out.println(a);
		System.out.println(Integer.toBinaryString(a));
				
		// | bitwise-OR
		int b = n | (~n + 1);
		System.out.println(b);
		System.out.println(Integer.toBinaryString(0));
		System.out.println(Integer.toBinaryString(b));
		System.out.println(Integer.toBinaryString(-2));
		System.out.println(Integer.toBinaryString(-3));
		
		// ^ bitwise- XOR
		// 1 if only one of the bit is 1
		
		int c = 0b1000^0b0001;
		System.out.println(Integer.toBinaryString(c));
		
		// signed shift << multiply by 2 (sign bit preserved)
		// signed shift >> divide by 2 
		// operands is reduced to modulo 32, so 5 << 35 == 5 <<3
	
		// unsigned shift >>> or <<< sign bit not preserved
		
		/* other compound assignment operators
		 * x |= 5 // x = x|5
		 * x ^= // x= x^5
		 * &=
		 * <<=
		 * >>>=
		 */
		
		System.out.println(abs(-1));
		System.out.println(abs(-5));
		System.out.println(abs(5));
		
	}
}
