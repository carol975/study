package Trees;

import java.util.ArrayList;
import java.util.Random;

public class TreeNode {
	int val;
	int size;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(int val){
		this.val = val;
		this.left = null;
		this.right = null;
		this.size = 1; //size of itself + subtree
		
	}
	
	public void insert(int val){
		if(val >= this.val){
			if(this.right == null){
				this.right = new TreeNode(val);
			}
			else{
				this.right.insert(val);
			}
		}
		else{
			if(this.left == null){
				this.left = new TreeNode(val);
			}
			else{
				this.left.insert(val);
			}
			
		}
		this.size++;
	}
	
	
	
	public void insert(TreeNode n){
		if(n.val >= this.val){
			if(this.right == null){
				this.right = n;
			}
			else{
				this.right.insert(n);
			}
		}
		else{
			if(this.left == null){
				this.left = n;
			}
			else{
				this.left.insert(n);
			}
			
		}
		this.size += n.size;
	}
	
	
	public boolean find(int val){ //assuming BST
		if(this.val == val){
			return true;
		}
		else if(this.left != null && this.left.find(val)){
			return true;
		}
		else if(this.right != null && this.right.find(val)){
			return true;
		}
		return false;
	}
	
	public TreeNode remove(int val){ //return root
		if(this.val == val){
			this.right.insert(this.left);
			return this.right;
		}
		else{
			if(val < this.val && this.left != null){				
				return this.left.remove(val);
			}
			else if(val > this.val && this.right != null){
				return this.right.remove(val);
			}
		}
		
		return null;
	}
	
	public TreeNode getRandomNode(){
		if(this.left == null && this.right == null){
			return this;
		}
		ArrayList<Integer> allDistributions = new ArrayList<Integer>();
		allDistributions.add(this.val);
		if(this.left != null){
			for(int i = 0; i < this.left.size; i++){
				allDistributions.add(this.left.val);
			}
		}
		if(this.right != null){
			for(int i = 0; i < this.right.size; i++){
				allDistributions.add(this.right.val);
			}
		}
		
		System.out.println(allDistributions.size());
		
		int randomIndex = new Random().nextInt(allDistributions.size());
		int randomVal = allDistributions.get(randomIndex);
		
		if(this.right != null && randomVal == this.right.val){
			return this.right.getRandomNode();
		}
		else if(this.left != null && randomVal == this.left.val){
			return this.left.getRandomNode();
		}
		
		return this;
		
		
	}
	
	public TreeNode getRandomNodeSimple(){ //according to the book's solution
		int rightSize = this.right == null? 0 : this.right.size;
		int randomIndex = new Random().nextInt(this.size);
		System.out.println(randomIndex);
		if(randomIndex < rightSize){
			return this.right.getRandomNodeSimple();
		}
		else if(randomIndex == rightSize){
			return this;
		}
		else{
			return this.left.getRandomNode();
		}
	}
	
	
	public static void main(String[] args){
		/*
		TreeNode root = new TreeNode(0);
		root.insert(1);
		root.insert(-1);
		root.insert(-2);
		root.insert(0);
		root.insert(3);
		root.insert(4);
		root.insert(7);
		System.out.println(root.size);
		System.out.println(root.left.size);
		System.out.println(root.right.size);
		System.out.println(root.getRandomNode().val);*/
		
		//System.out.println(new Random().nextInt(0));
		
		TreeNode root = new TreeNode(0);
		root.insert(1);
		root.insert(-1);
		root.insert(-2);
		root.insert(0);
		root.insert(3);
		root.insert(4);
		root.insert(7);
		/*
		System.out.println(root.size);
		System.out.println(root.left.size);
		System.out.println(root.right.size);*/
		System.out.println(root.getRandomNodeSimple().val);
	
	}
	
	

}
