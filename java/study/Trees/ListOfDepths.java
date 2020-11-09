package Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


import Trees.MinimalTree.Node;

public class ListOfDepths {
	
	HashMap<Integer,ArrayList<Integer>> lists;
	public ListOfDepths(MinimalTree tree){
		lists = new HashMap<Integer,ArrayList<Integer>>();
		int depth = 0;
		Node root = tree.root;
		addDepth(root,depth);
	}
	
	public void addDepth(Node curr, int depth){
		if(curr != null){
			if(lists.get(depth) == null){
				lists.put(depth, new ArrayList<Integer>());
			}
			lists.get(depth).add(curr.val);
			addDepth(curr.left,depth+1);
			addDepth(curr.right,depth+1);
		}
		
	}
	public static void main(String[] args){
		int[] arr = {0,1,2,3,4,5,9,10,11};
		MinimalTree tree = new MinimalTree(arr);
		ListOfDepths lists = new ListOfDepths(tree);
		Iterator<Integer> itr = lists.lists.keySet().iterator();
		while(itr.hasNext()){
			int depth = itr.next();
			System.out.println("depth: " + depth);
			ArrayList<Integer> l = lists.lists.get(depth);
			for(Integer num : l){
				System.out.print(num + " ");
			}
			System.out.println(" ");
		}
		
	}
	
	
	
}
