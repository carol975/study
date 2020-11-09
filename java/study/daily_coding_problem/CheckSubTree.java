package daily_coding_problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import Trees.Node;

public class CheckSubTree {
	public ArrayList<Node> findT2Root(Node T1Root, Node T2Root){
		if(T2Root == null || T1Root == null){
			return null;
		}
		//BFS 
		ArrayList<Node> t2Int1 = new ArrayList<Node>(); 
		Queue<Node> neighbours = new LinkedList<Node>();
		neighbours.add(T1Root);
		while(neighbours.isEmpty() == false){
			Node curr = neighbours.remove();
			if(curr != null){
				if((curr.left != null && curr.left.val == T2Root.val) || (curr.right != null && curr.right.val == T2Root.val)){
					t2Int1.add(curr);
				}
				neighbours.add(curr.left);
				neighbours.add(curr.right);
			}
			
			
		}
		if(t2Int1.isEmpty() == false){
			return t2Int1;
		}
		return null;
	}
	
	public Node isSubTree(Node T1Root, Node T2Root){
		ArrayList<Node> t1Start = findT2Root(T1Root, T2Root);
		if(t1Start == null){
			//return false;
			return null;
		}
		for(Node start : t1Start){
			if(isNodeSame(start.left, T2Root)){
				//return true;
				return start;
			}
			else if(isNodeSame(start.right, T2Root)){
				//return true;
				return start;
			}
		}
		return null;
	}
	
	public boolean isNodeSame(Node t1, Node t2){
		if(t1 == null && t2 == null){
			return true;
		}
		else if((t1 == null && t2 != null) || (t1 != null && t2 == null)){
			return false;
		}
		else if(t1.val != t2.val){
			return false;
		}
		else return isNodeSame(t1.left, t2.left) && isNodeSame(t1.right,t2.right);
	}
	
	public static void main(String[] args){
		Node t1 = new Node(3);
		t1.left = new Node(2);
		t1.left.left = new Node(1);
		t1.right = new Node(4);
		t1.right.left = new Node(5);
		t1.right.right = new Node(6);
		
		Node t2 = new Node (1);
		//t2.left = t1.right.left;
		//t2.right = t1.right.right;
		CheckSubTree ck = new CheckSubTree();
		Node rootOfSub = ck.isSubTree(t1, t2);
		if(rootOfSub == null){
			System.out.println("no");
		}
		else{
			System.out.println(rootOfSub.val);
		}
		
	}
}
