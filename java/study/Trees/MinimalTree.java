package Trees;

import java.util.Arrays;

public class MinimalTree {
	class Node {
		int val;
		Node left;
		Node right;
		
		public Node (int val){
			this.val = val;
			left = null;
			right = null;
		}
		
	}
	
	Node root;
	public MinimalTree(int[] arr){
		root = insertNode(arr);
	}
	
	public Node insertNode(int[] arr){
		if(arr.length == 0){
			return null;
		}
		int middle_index = (arr.length-1)/2;
		Node root = new Node(arr[middle_index]);
		root.left = middle_index > 0? insertNode(Arrays.copyOfRange(arr, 0, middle_index)) : null;
		root.right = middle_index+1 < arr.length? insertNode(Arrays.copyOfRange(arr, middle_index+1, arr.length)): null;
		return root;
		
	}
	
	public static void main(String[] args){
		int[] arr = {0,1,2};
		MinimalTree tree = new MinimalTree(arr);
		Node t = tree.root;
	
	}
}
