package lesson3;

import util.TreeBuilder;
import util.TreeNode;
/**
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest LEAF node.
 * @author gjk
 *
 */
public class MinDepth {

	public static void main(String[] args) {
		TreeNode root = TreeBuilder.buildTree(new Integer[][] {
			{ 1 }, 
			{ null, 2 }, 
			{ null, null, 3, null }, 
		});
		System.out.println(minDepth(root));

	}
    public static int minDepth(TreeNode root) {
    	if(root == null){return 0;}
    	
    	if(root.left == null && root.right == null){
    		return 1;
    	}
    	
    	if(root.left != null && root.right != null){
        	return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    	}
    	
    	if(root.left != null){
    		return minDepth(root.left)+1;
    	}
    	
    	if(root.right != null){
    		return minDepth(root.right)+1;
    	}
    	
    	return 0;
    }
}
