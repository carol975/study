package study;

public class ArrayHashTable {
	int size;
	private int[][] hTable;
	
	public ArrayHashTable(int size) {
		this.size = size;
		hTable = new int[size][];
	}
	
	private int hash(int key) {
		int index = key % this.size;
		return index;
	}
	
	public void add(int key, int val) {
		int index = hash(key);
		hTable[index] = new int[size];
		
		
	}
	
	
}
