package lesson3;

import util.TreeBuilder;
import util.TreeNode;

public class ValidateBalancedBinaryTree {

	public static void main(String[] args) {
		TreeNode root = TreeBuilder.buildTree(new Integer[][] {
			{ 1 }, 
			{ 2, 3 }, 
			{ 4, null, 6, 7 }, 
			{ 8, 9, 10, 11, 12, 13, 14, 15 } 
		});
		System.out.println(isBalanced(root));

	}

    public static boolean isBalanced(TreeNode root) {
    	if(root == null){return true;}
    	
    	//method 1
		//return isBalanced(root.left) && isBalanced(root.right) && Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1;
    	
    	//method 2, better
		return re(root) != -1;
    }
    
    public static int maxDepth(TreeNode root) {
    	int depth = 0;
    	if(root == null){return depth;}
    	depth = Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
		return depth;
    }

    
    
    public static int re(TreeNode node){
    	int depth = 0;
    	if(node == null){return depth;}
    	
    	int left = re(node.left);
    	int right = re(node.right);
    	
    	if(left == -1 || right == -1 || Math.abs(left - right) > 1){
    		return -1;
    	}else{
    		return Math.max(left, right) + 1;
    	}
    	
    }
}
