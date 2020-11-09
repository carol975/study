package Trees;

public class ValidateBST {
	public static boolean validateBST(Node root, int max, int min){
		if(root == null){
			return true;
		}
		if(root.left != null && (root.left.val > root.val || root.left.val < min)){
			return false;
		}
		if(root.right != null && (root.right.val < root.val || root.right.val > max)){
			return false;
		}
		
		return validateBST(root.left, root.val, min) && validateBST(root.right, max, root.val);
	}
	public static void main(String[] args){
		Node root = new Node(3);
		root.left = new Node(2);
		//root.left.right = new Node(7);
		root.right = new Node(4);
		root.right.left = new Node(2);
		//root.right.right = new Node(3);
		//root.right.right.right = new Node(4);
		//root.right.right.left = new Node(1);
		System.out.println(validateBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE));
	}
}
