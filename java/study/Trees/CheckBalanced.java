package Trees;

public class CheckBalanced {
	public static boolean checkBalanced(Node root){
		if(root == null){
			return true;
		}
		if(Math.abs(maxSubTreeHeight(root.left) - maxSubTreeHeight(root.right)) > 1 ){
			return false;
		}
		
		return checkBalanced(root.left) && checkBalanced(root.right);
	}
	public static int maxSubTreeHeight(Node curr){
		if(curr == null){
			return 0;
		}
		int leftHeight = 0;
		int rightHeight = 0;
		if(curr.left != null){
			leftHeight = 1 + maxSubTreeHeight(curr.left);
		}
		if(curr.right != null){
			rightHeight = 1 + maxSubTreeHeight(curr.right);
		}
		
		return leftHeight>rightHeight?leftHeight:rightHeight;
	}
	
	public void printTree(Node root){
		if(root != null){
			System.out.println(root.val + "");	
		}
		printTree(root.left);
		printTree(root.right);
		System.out.println(" ");
	}
	public static void main(String[] args ){
		Node root = new Node(0);
		//root.left = new Node(1);
		//root.left.left = new Node(7);
		root.right = new Node(2);
		root.right.left = new Node(6);
		root.right.right = new Node(3);
		root.right.right.right = new Node(4);
		//root.right.right.left = new Node(5);
		System.out.println(maxSubTreeHeight(root.right));
		//System.out.println(maxSubTreeHeight(root.right.left));
		//System.out.println(maxSubTreeHeight(root.right.right));
		System.out.println(maxSubTreeHeight(root.left));
		
		System.out.println(checkBalanced(root));
	}
}
