package Trees;

import java.util.ArrayList;
import java.util.Iterator;

public class BSTSequences {
	public ArrayList<ArrayList<Integer>> getAllSequences(Node root){
		if(root == null){
			return null;
		}
		ArrayList<ArrayList<Integer>> allSequences = new ArrayList<ArrayList<Integer>>();
		if(root.left == null && root.right == null){
			ArrayList<Integer> seq = new ArrayList<Integer>();
			seq.add(root.val);
			allSequences.add(seq);
			return allSequences;
		}
		
		else{
			ArrayList<ArrayList<Integer>> allLeftSubSequences = getAllSequences(root.left);
			ArrayList<ArrayList<Integer>> allRightSubSequences = getAllSequences(root.right);

			if(allLeftSubSequences != null){
				for(ArrayList<Integer> leftSeq : allLeftSubSequences){
					if(allRightSubSequences != null){
						for(ArrayList<Integer> rightSeq : allRightSubSequences){
							ArrayList<Integer> combined = new ArrayList<Integer>();
							combined.addAll(leftSeq);
							combined.addAll(rightSeq);
							combined.add(0,root.val);
							allSequences.add(combined);
						}

					}
					else{
						ArrayList<Integer> combined = new ArrayList<Integer>();
						combined.addAll(leftSeq);
						combined.add(0,root.val);
						allSequences.add(combined);
					}
					
				}
			}
			
			if(allRightSubSequences != null){
				for(ArrayList<Integer> rightSeq : allRightSubSequences){
					if(allLeftSubSequences != null){
						for(ArrayList<Integer> leftSeq : allLeftSubSequences){
							ArrayList<Integer> combined = new ArrayList<Integer>();
							combined.addAll(rightSeq);
							combined.addAll(leftSeq);
							combined.add(0,root.val);
							allSequences.add(combined);
						}
					}
					else{
						ArrayList<Integer> combined = new ArrayList<Integer>();
						combined.addAll(rightSeq);
						combined.add(0,root.val);
						allSequences.add(combined);
					}
					

				}
			}
			
			return allSequences;
			
		}
		
		
		
	}
	
	
	public static void main (String[] args){
		BSTSequences s = new BSTSequences();
		Node root = new Node(2);
		root.left = new Node(1);
		root.right = new Node(3);
		//root.right.left = new Node(4);
		//root.right.right = new Node(5);
		ArrayList<ArrayList<Integer>> allSeq = s.getAllSequences(root);
		
		Iterator<ArrayList<Integer>> itr = allSeq.iterator();
		while(itr.hasNext()){
			ArrayList<Integer> arr = itr.next();
			System.out.print("{");
			for(int i=0; i<arr.size();i++){
				System.out.print(arr.get(i) + " ");
			}
			System.out.println("}");
			
		}
	}
}
