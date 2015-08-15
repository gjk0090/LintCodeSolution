package lesson3;

import java.util.ArrayList;
import java.util.List;

import util.PrintUtil;
import util.TreeBuilder;
import util.TreeNode;

public class RemoveNodeBST {

	/**
	 * find the node
	 * if no child --> node = null
	 * if only one child --> node = child
	 * if two child -->
	 * 		find max child of left
	 * 		copy child value to node
	 * 		if child has left --> child = left
	 * 		if no left --> child = null
	 * 
	 * important:
	 * 		to delete a node, parent is necessary
	 * 		always think about target is root
	 */
	public static void main(String[] args) {
		TreeNode root = TreeBuilder.buildTree(new Integer[][] {{15},{13,16},{2,14,null,null},{1,4,null,null,null,null,null,null},{null,null,3,null,null,null,null,null,null,null,null,null,null,null,null,null}});
		TreeNode root2 = TreeBuilder.buildTree(new Integer[][] {{5},{1,null}});
		
		root = removeNode(root, 2); 
		root2 = removeNode(root2, 5); 
		
		//BFS print for testing
		ArrayList result = BFS.levelOrder(root);
		for(Object l : result){
			PrintUtil.printList((List<Integer>) l);
		}	
	}
	
	
    public static TreeNode removeNode(TreeNode root, int value) {
    	
    	if(root == null){return null;}
    	
    	TreeNode parentOfTarget = findParentOfTarget(root, value);
    	if(parentOfTarget == null){return root;} // target not found

    	TreeNode target;
    	if(parentOfTarget.val == value){ // target is root
    		target = parentOfTarget;
    	}else if(parentOfTarget.val > value){ // target on left
    		target = parentOfTarget.left;
    	}else{// target on right
    		target = parentOfTarget.right;
    	}
    	
    	
    	//no child, remove target
    	if(target.left == null && target.right == null){
    		if(parentOfTarget.val == value){
        		root = null;
        	}else if(parentOfTarget.val > value){
        		parentOfTarget.left = null;
        	}else{
        		parentOfTarget.right = null;
        	}
    		return root;
    	}
    	
    	//2 children
    	if(target.left != null && target.right != null){
    		
    		TreeNode parentOfLeftMax = target;
    		TreeNode leftMax = target.left;
    		
    		while(leftMax.right != null){
    			parentOfLeftMax = leftMax;
    			leftMax = leftMax.right;
    		}
    		
    		//delete left max
    		if(parentOfLeftMax.val == value){ //parent is target, leftMax is left child
    			parentOfLeftMax.left = leftMax.left; //no matter left is null or not
    		}else{
    			parentOfLeftMax.right = leftMax.left;
    		}
    		
    		target.val = leftMax.val;

    		return root;
        }
    	
    	//move up left child of target
    	if(target.left != null){
        	if(parentOfTarget.val == value){ //root node
        		root = target.left;
        	}else if(parentOfTarget.val > value){
        		parentOfTarget.left = target.left;
        	}else{
        		parentOfTarget.right = target.left;
        	}
    	}
    	
    	//move up right child of target
    	if(target.right != null){
        	if(parentOfTarget.val == value){ //root node
        		root = target.right;
        	}else if(parentOfTarget.val > value){
        		parentOfTarget.left = target.right;
        	}else{
        		parentOfTarget.right = target.right;
        	}
    	}
    	
    	
		return root;
    	
    }
	private static TreeNode findParentOfTarget(TreeNode node, int value) {
		TreeNode parent = node;
		
		while(node != null){
			if(node.val == value){
				return parent;
			}
			if(node.val > value){
				parent = node;
				node = node.left;
			}else{
				parent = node;
				node = node.right;
			}
		}
		return null;
	}

}
