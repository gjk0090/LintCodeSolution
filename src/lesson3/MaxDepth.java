package lesson3;

import util.TreeBuilder;
import util.TreeNode;

public class MaxDepth {

	public static void main(String[] args) {
		TreeNode root = TreeBuilder.buildTree(new Integer[][] {
			{ 1 }, 
			{ 2, 3 }, 
			{ 4, null, 6, 7 }, 
			{ 8, 9, 10, 11, 12, 13, 14, 15 } 
		});
		System.out.println(maxDepth(root));
	}

    public static int maxDepth(TreeNode root) {
    	int depth = 0;
    	if(root == null){return 0;}
    	depth = Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
		return depth;
    }
}
