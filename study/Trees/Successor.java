package Trees;

public class Successor {
	public static Node findSuccessor(Node curr){
		if(curr == null){
			return null;
		}
		
		if(curr.right != null){
			Node leftmost = curr.right;
			while(leftmost.left != null){
				leftmost = leftmost.left;
			}
			return leftmost;
		}
		else if(curr.parent != null && curr == curr.parent.right){
			return curr.parent.parent;
		}
		
		return curr.parent;
		
	}
	
	public static void main (String[] args){
		Node root = new Node(2);
		root.left = new Node(1);
		root.left.parent = root;
		root.left.left = new Node(3);
		root.left.left.parent = root.left;
		root.left.right = new Node(4);
		root.left.right.parent = root.left;
		root.left.right.left = new Node(7);
		root.left.right.left.parent = root.left.right;
		root.right = new Node(5);
		root.right.parent = root;
		root.right.left = new Node(6);
		root.right.left.parent = root.right;
		
		System.out.println(findSuccessor(root.right));
		
	}
}
