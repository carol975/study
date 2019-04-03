package study;

import java.util.ArrayList;
import java.util.List;

public class HashTable {
	private class HashNode {
		String key;
		String val;
		
		public HashNode(String key, String val) {
			this.key = key;
			this.val = val;

		}
	}
	
	private int size;
	
	private ArrayList<ArrayList<HashNode>> hTable;
	public HashTable(int size) {
		this.size = size;
		this.hTable = new ArrayList<ArrayList<HashNode>>(size);
	}
	
	private int hash(String key) {
		return key.hashCode() % this.size;
		 
	}
	
	public void add(String key, String val) {
		int index = hash(key);
		System.out.println(index);
		List<HashNode> chain = hTable.get(index);
		if(chain != null) {
			chain.add(new HashNode(key,val));
		}
		else {
			chain = new ArrayList<HashNode>();
			chain.add(new HashNode(key,val));
			hTable.add(index,(ArrayList<HashNode>) chain);
		}
	}
	
	public boolean exists(String key) {
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
	
	public String get(String key) {
		int index = hash(key);
		List<HashNode> chain =  hTable.get(index);
		for(HashNode node : chain) {
			if(node.key == key) {
				return node.val;
			}
		}
		
		return null;
	}
	
	public String remove(String key) {
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
		}
	}
}
