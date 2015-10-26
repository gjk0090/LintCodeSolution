package lesson3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Stack;


import util.TreeBuilder;
import util.TreeNode;

public class DFSPreorder {

	public static void main(String[] args) {

		TreeNode root = TreeBuilder.buildTree(new Integer[][] {
			{ 1 }, 
			{ 2, 3 }, 
			{ 4, null, 6, 7 }, 
			{ 8, 9, 10, 11, 12, 13, 14, 15 } 
		});
		
		System.out.println(preorderTraversal(root));
		System.out.println(preorderTraversal2(root));
	}
	
    public static ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root==null){return result;}
        
        Stack<TreeNode> stack = new Stack<TreeNode>();//no null in stack
        stack.push(root);
        
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(node.val);
            if(node.right!=null){stack.push(node.right);}
            if(node.left!=null){stack.push(node.left);}
        }
        
        return result;
    }
    
    public static ArrayList<Integer> preorderTraversal2(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root==null){return result;}
        result.add(root.val);
        result.addAll(preorderTraversal(root.left));
        result.addAll(preorderTraversal(root.right));
        return result;        
    }
}