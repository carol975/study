package Trees;


public class Node {
	public int val;
	public Node left;
	public Node right;
	public Node parent;
	public Node dep;
	public Node(int val){
		this.val = val;
		this.left = null;
		this.right = null;
		this.parent = null;
	}
}
