package lesson3;

import java.util.*;


import util.TreeBuilder;
import util.TreeNode;

public class SearchRangeInBST {

	public static void main(String[] args) {
		TreeNode root = TreeBuilder.buildTree(new Integer[][] {{4},{2,6},{1,3,5,7}});
		System.out.println(searchRange2(root,2,5));
		System.out.println(searchRange(root,2,5));
	}

    public static ArrayList<Integer> searchRange2(TreeNode root, int k1, int k2) {
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	if(root==null){return result;}
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	stack.push(root);
    	
    	while(!stack.isEmpty()){
    		TreeNode node = stack.pop();
    		if(node.val < k2 && node.right != null){
    			stack.push(node.right);
    		}
    		
    		if(node.val > k1 && node.left != null){
    			stack.push(new TreeNode(node.val));
    			stack.push(node.left);
    		}else if(k1<=node.val && node.val<=k2){
    			result.add(node.val);
    		}
    	}
		return result;
    }
    
    public static ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	if(root==null){return result;}
    	
    	if(root.val > k2){
    		result.addAll(searchRange(root.left,k1,k2));
    	}
    	if(k1 <= root.val && root.val <= k2){
            //ascending order
            result.addAll(searchRange(root.left,k1,k2));
    		result.add(root.val);
    		result.addAll(searchRange(root.right,k1,k2));
    	}
    	if(root.val < k1){
    		result.addAll(searchRange(root.right,k1,k2));
    	}
    	
		return result;
    }
}
