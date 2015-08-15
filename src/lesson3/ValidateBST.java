package lesson3;

import util.TreeBuilder;
import util.TreeNode;

public class ValidateBST {

	public static void main(String[] args) {
		TreeNode root = TreeBuilder.buildTree(new Integer[][] {{4},{2,6},{1,3,5,7}});
		TreeNode root2 = TreeBuilder.buildTree(new Integer[][] {{1},{Integer.MIN_VALUE, Integer.MAX_VALUE}});
		TreeNode root3 = TreeBuilder.buildTree(new Integer[][] {{1},{1,1}});
		System.out.println(isValidBST(root));
		System.out.println(isValidBST(root2));
		System.out.println(isValidBST2(root2));
		System.out.println(isValidBST(root3));
	}
	
    public static boolean isValidBST(TreeNode root) {
		return re(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private static boolean re(TreeNode node, long min, long max){
    	if(null == node){return true;}
		return re(node.left, min, node.val) && re(node.right, node.val, max) && min<node.val && node.val<max;
    }
    
    
    
    
    

    //http://www.jiuzhang.com/solutions/validate-binary-search-tree
    private static int lastVal = Integer.MIN_VALUE;
    private static boolean firstNode = true;
    public static boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST2(root.left)) {
            return false;
        }
        if (!firstNode && lastVal >= root.val) {
            return false;
        }
        firstNode = false;
        lastVal = root.val;
        if (!isValidBST2(root.right)) {
            return false;
        }
        return true;
    }
}
