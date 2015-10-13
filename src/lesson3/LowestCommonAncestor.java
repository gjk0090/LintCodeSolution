package lesson3;

import util.TreeBuilder;
import util.TreeNode;
/**
 * self:
 * is one of nodes, stop and return self
 * 
 * left and right:
 * both found(not null), return self
 * found one, return it
 * no found, return null
 * 
 * @author gjk
 *
 */
public class LowestCommonAncestor {

	public static void main(String[] args) {
		TreeNode root = TreeBuilder.buildTree(new Integer[][] {
			{ 4 }, 
			{ 3, 7 }, 
			{ null, null, 5, 6 }
		});
		
		System.out.println(lowestCommonAncestor(root, root.right, root.right.right).val);

	}
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
    	if(root == null){return null;}
    	if(root == A || root == B){return root;}
    	
    	TreeNode left = lowestCommonAncestor(root.left,A,B);
    	TreeNode right = lowestCommonAncestor(root.right,A,B);
    	
    	if(left != null && right != null){
    		return root;
    	}
    	
    	if(left != null){
    		return left;
    	}else{
    		return right; // no matter null or not
    	}
    	
    }
}
