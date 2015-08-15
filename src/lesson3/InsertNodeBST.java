package lesson3;

import util.TreeBuilder;
import util.TreeNode;

public class InsertNodeBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = TreeBuilder.buildTree(new Integer[][] {{2},{1,4},{null,null,3,null}});
		TreeNode root2 = TreeBuilder.buildTree(new Integer[][] {{1},{Integer.MIN_VALUE, Integer.MAX_VALUE}});

		System.out.println(insertNode2(root,new TreeNode(6)).val);
		System.out.println(insertNode2(root2,new TreeNode(8)).val);
	}
	
	
    /**
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public static TreeNode insertNode(TreeNode root, TreeNode node) {
    	if(root == null){return node;}
    	
    	if(node.val>root.val){
    		if(root.right != null){
    			insertNode(root.right,node);
    		}else{
    			root.right = node;
    		}
    	}else{
    		if(root.left != null){
    			insertNode(root.left,node);
    		}else{
    			root.left = node;
    		}
    	}
		return root;

    }

    
    // non recur
    public static TreeNode insertNode2(TreeNode root, TreeNode node) {
    	if(root == null){return node;}

    	TreeNode temp = root;
    	while(temp != null){
        	if(node.val>temp.val){
        		if(temp.right != null){
        			temp = temp.right;
        		}else{
        			temp.right = node;
        			temp = null;
        		}
        	}else{
        		if(temp.left != null){
        			temp = temp.left;
        		}else{
        			temp.left = node;
        			temp = null;
        		}
        	}
    	}
    	
    	return root;
    }
}
