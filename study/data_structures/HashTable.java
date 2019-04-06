package data_structures;

import java.util.ArrayList;
import java.util.List;

public class HashTable {
	private class HashNode {
		int key;
		String val;
		
		public HashNode(int key, String val) {
			this.key = key;
			this.val = val;

		}
	}
	
	private int size;
	
	private List<List<HashNode>> hTable;
	public HashTable(int size) {
		this.size = size;
		this.hTable = new ArrayList<List<HashNode>>(size);
		for(int i = 0; i < size; i++){
			hTable.add(new ArrayList<HashNode>());
		}
			 
		
	}
	
	private int hash(int key) {
		return key % this.size;
		 
	}
	
	public void add(int key, String val) {
		int index = hash(key);
		List<HashNode> chain = hTable.get(index);
		chain.add(new HashNode(key,val));
		
		
	}
	
	public boolean exists(int key) {
		int index = hash(key);
		List<HashNode> chain = hTable.get(index);
		if(chain.isEmpty() == true ) {
			return false;
		}
		else {
			for(HashNode node : chain) {
				if(node.key == key) {
					return true;
				}
			}
			return false;
			
		}
	} 
	
	public String get(int key) {
		int index = hash(key);
		List<HashNode> chain =  hTable.get(index);
		for(HashNode node : chain) {
			if(node.key == key) {
				return node.val;
			}
		}
		
		return null;
	}
	
	public String remove(int key) {
		int index = hash(key);
		
		if(exists(key) == false) {
			return null;
		}
		List<HashNode> chain =  hTable.get(index);
		for(HashNode node : chain) {
			if(node.key == key) {
				String rmd = node.val;
				chain.remove(node);
				return rmd;
			}
		}
		
		return null;
	}
	public void print() {
		for(List<HashNode> chain : hTable) {
			for(HashNode node : chain) {
				System.out.print(node.key + "," + node.val + " ");
			}
			System.out.println("");
		}
	}
}
