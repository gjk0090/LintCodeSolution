package lesson3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Stack;

import util.PrintUtil;
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
		
		PrintUtil.printList(preorderTraversal(root));
		PrintUtil.printList(preorderTraversal2(root));
		PrintUtil.printList(preorderTraversal3(root));
	}
	
	
	
	//non recursive
	public static ArrayList<Integer> preorderTraversal(TreeNode root) {
		
			ArrayList<Integer> preorder = new ArrayList<Integer>();
			if(null == root){
				return preorder;
			}
			Stack<TreeNode> stack = new Stack<TreeNode>();
			stack.push(root);
			
			while(!stack.isEmpty()){
				TreeNode node = stack.pop();
				preorder.add(node.val);
				if(null != node.right){
					stack.push(node.right);
				}
				if(null != node.left){
					stack.push(node.left);
				}
			}
	        return preorder;
	 }

	
	
	//recursive
	public static ArrayList<Integer> preorderTraversal2(TreeNode root) {
		ArrayList<Integer> preorder = new ArrayList<Integer>();

		re(root,preorder);
		return preorder;
	}
	
	private static void re(TreeNode node, ArrayList<Integer> preorder) {
		if(null == node){
			return;
		}
		preorder.add(node.val);
		re(node.left,preorder);
		re(node.right,preorder);
	}

	
	
	//divide and conquer
	public static ArrayList<Integer> preorderTraversal3(TreeNode root) {
		ArrayList<Integer> preorder = new ArrayList<Integer>();

		if(null == root){
			return preorder;
		}
		preorder.add(root.val);
		preorder.addAll(preorderTraversal3(root.left));
		preorder.addAll(preorderTraversal3(root.right));
		return preorder;
	}

}
