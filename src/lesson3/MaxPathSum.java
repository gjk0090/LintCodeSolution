package lesson3;

import util.TreeBuilder;
import util.TreeNode;

/**
 * max = 
 * Max(
 * left.maxPath, 
 * right.maxPath, 
 * left.singlePath + right.singlePath + root.val
 * )
 * 
 * singlePath =
 * Max(
 * left.singlePath  + root.val,
 * right.singlePath + root.val,
 * 0
 * )
 * 
 * @author gjk
 *
 */
public class MaxPathSum {

	public static void main(String[] args) {
		TreeNode root = TreeBuilder.buildTree(new Integer[][] {
			{ 1 }, 
			{ 2, 3 }, 
			{ 4, 5, 6, 7 }, 
			{ 8, 9, 10, 11, 12, 13, 14, 15 } 
		});

		System.out.println(maxPathSum(root));
		System.out.println(maxPathSum2(root));
	}
	
    public static int maxPathSum(TreeNode root) {
    	if(root == null){return Integer.MIN_VALUE;} // important
    	
    	int max = Math.max(maxPathSum(root.left), maxPathSum(root.right));
    	max = Math.max(max, maxSinglePath(root.left)+maxSinglePath(root.right)+root.val);
		return max;

    }

	private static int maxSinglePath(TreeNode node) {
    	if(node == null){return 0;}
    	
    	int max = node.val + Math.max(maxSinglePath(node.left), maxSinglePath(node.right));
    	max = Math.max(max, 0);
		return max;
	}

	
	
	
	
	
		//standard answer, combining 2 recursion into 1
	   private static class ResultType {
	        // singlePath: 从root往下走到任意点的最大路径，这条路径可以不包含任何点
	        // maxPath: 从树中任意到任意点的最大路径，这条路径至少包含一个点
	        int singlePath, maxPath; 
	        ResultType(int singlePath, int maxPath) {
	            this.singlePath = singlePath;
	            this.maxPath = maxPath;
	        }
	    }

	    private static ResultType helper(TreeNode root) {
	        if (root == null) {
	            return new ResultType(0, Integer.MIN_VALUE);
	        }
	        // Divide
	        ResultType left = helper(root.left);
	        ResultType right = helper(root.right);

	        // Conquer
	        int singlePath = Math.max(left.singlePath, right.singlePath) + root.val;
	        singlePath = Math.max(singlePath, 0);

	        int maxPath = Math.max(left.maxPath, right.maxPath);
	        maxPath = Math.max(maxPath, left.singlePath + right.singlePath + root.val);

	        return new ResultType(singlePath, maxPath);
	    }

	    public static int maxPathSum2(TreeNode root) {
	        ResultType result = helper(root);
	        return result.maxPath;
	    }
}
