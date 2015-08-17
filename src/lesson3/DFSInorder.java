package lesson3;

import java.util.*;


import util.TreeBuilder;
import util.TreeNode;

public class DFSInorder {

	public static void main(String[] args) {
		TreeNode root = TreeBuilder.buildTree(new Integer[][] {
			{ 1 }, 
			{ 2, 3 }, 
			{ 4, null, 6, 7 }, 
			{ 8, 9, 10, 11, 12, 13, 14, 15 } 
		});
		
		System.out.println(inorderTraversal(root));
		System.out.println(inorderTraversal2(root));
		System.out.println(inorderTraversal3(root));
	}



	private static ArrayList<Integer> inorderTraversal(TreeNode root) {
		
		ArrayList<Integer>  l = new ArrayList<Integer> ();
		if(null == root){
			return l;
		}
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		
		while(!stack.isEmpty()){
			TreeNode node = stack.pop();
			
			if(null != node.right){
				stack.push(node.right);
			}
						
			if(null != node.left){ // if has left
				stack.push(new TreeNode(node.val)); // push node (value only)
				stack.push(node.left); // push left
			}else{
				l.add(node.val); // return the value
			}
		}
		
		return l;
	}
	
	private static ArrayList<Integer> inorderTraversal2(TreeNode root) {
		ArrayList<Integer>  l = new ArrayList<Integer> ();
		re(root, l);
		return l;
	}
	
	private static void re(TreeNode node, ArrayList<Integer> l) {
		if(node==null){return;}
		re(node.left,l);
		l.add(node.val);
		re(node.right,l);
	}



	private static ArrayList<Integer> inorderTraversal3(TreeNode root) {
		ArrayList<Integer>  l = new ArrayList<Integer> ();
		if(root==null){return l;}
		l.addAll(inorderTraversal3(root.left));
		l.add(root.val);
		l.addAll(inorderTraversal3(root.right));
		return l;
	}



}
