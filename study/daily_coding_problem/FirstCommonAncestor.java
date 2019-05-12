package daily_coding_problem;

import Trees.Node;

public class FirstCommonAncestor {
	
	public static boolean findTarget(Node target, Node curr){
		if(curr == null ){
			return false;
		}
		else if(curr.val == target.val){
			return true;
		}
		else{
			return findTarget(target, curr.left) || findTarget(target,curr.right);
			
		}
		
	}
	
	public static Node findFirstCommonAncestor(Node n1, Node n2, Node root){
		if(root == null || n1 == null || n2 == null){
			return null;
		}
		
		if(findTarget(n1,root) && findTarget(n2,root)){
			Node nextAncestor = findFirstCommonAncestor(n1,n2,root.left); 
			if( nextAncestor != null){
				return nextAncestor;
			}
			nextAncestor = findFirstCommonAncestor(n1,n2, root.right);
			if( nextAncestor != null){
				return nextAncestor;
			}
			return root;
		}
		
		return null;
	}
	
	public static void main(String[] args){
		Node root = new Node(0);
		root.left = new Node(1);
		root.left.right = new Node(5);
		root.right = new Node(2);
		root.right.right = new Node(3);
		root.right.right.left = new Node(2);
		root.right.right.right = new Node(4);
		Node ca = findFirstCommonAncestor(new Node(3), new Node(6),root);
		if(ca == null){
			System.out.println("null");
		}
		//System.out.println(ca.val);
	}
}
