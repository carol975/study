package data_structures;

public class main {
	public static void main(String[] args) {
		int a = 15;
		System.out.println(a);
		System.out.println(Integer.toBinaryString(a));
		a = ~a + 1;
		System.out.println(a);
		System.out.println(Integer.toBinaryString(a));
		a = ~a;
		System.out.println(a);
		System.out.println(Integer.toBinaryString(a));
	
	}
}
