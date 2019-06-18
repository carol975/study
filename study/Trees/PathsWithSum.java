package Trees;

public class PathsWithSum {
	public static int pathSum (Node node, int target, int prevSum){
		int totalPath = 0;
		if(node == null){
			return 0;
		}
		if(node.val == target){
			totalPath++;
			System.out.println(node.val);
		}
		
		
		if(prevSum != Integer.MAX_VALUE){
			if(prevSum + node.val == target){
				totalPath++;
				System.out.println(prevSum + " " + node.val);
			}
			totalPath += pathSum(node.left, target, prevSum + node.val);
			totalPath += pathSum(node.right, target, prevSum + node.val);
			
		}
		
		totalPath += pathSum(node.left, target, node.val);
		totalPath += pathSum(node.right, target, node.val);
		
		totalPath += pathSum(node.left, target, Integer.MAX_VALUE);
		totalPath += pathSum(node.right, target, Integer.MAX_VALUE);

		return totalPath;
	}
	
	public static int findPathSum(Node node, int target){
		return pathSum(node,target, Integer.MAX_VALUE);
	}
	
	
	public static int countPathsWithSum(Node root, int target){
		if(root == null){
			return 0;
		}
		int pathsFromRoot = countPathsWithSumFromNode(root, target, 0);
		
		int pathsOnLeft = countPathsWithSum(root.left, target);
		int pathsOnRight = countPathsWithSum(root.right, target);
		
		return pathsFromRoot + pathsOnLeft + pathsOnRight;
	}
	
	public static int countPathsWithSumFromNode(Node node, int target, int currentSum){
		if(node == null){
			return 0;
		}
		currentSum += node.val;
		int totalPaths = 0;
		
		if(currentSum == target){
			totalPaths++;
		}
		totalPaths += countPathsWithSumFromNode(node.left, target, currentSum);
		totalPaths += countPathsWithSumFromNode(node.right, target, currentSum);
		return totalPaths;
		
	}
	
	public static void main(String[] args){
		Node root = new Node(3);
		root.right = new Node(4);
		root.left = new Node(2);
		root.left.right = new Node(2);
		root.left.left = new Node(1);
		System.out.println(findPathSum(root,3));
	}
}
