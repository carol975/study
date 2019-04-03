package study;

public class main {
	public static void main(String[] args) {
		HashTable ht = new HashTable(5);
		ht.print();
		ht.add(new String("a"),new String("b"));
		ht.add(new String("a"),new String("b"));
		ht.add(new String("c"),new String("b"));
		ht.add(new String("c"),new String("b"));
		ht.print();
	}
}
