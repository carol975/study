package study;

public class main {
	public static void main(String[] args) {
		HashTable ht = new HashTable(5);
		ht.print();
		ht.add(0,new String("b"));
		ht.add(1,new String("b"));
		ht.add(2,new String("b"));
		ht.add(0,new String("b"));
		ht.print();
	}
}
