package lesson3;

import java.util.ArrayList;
import java.util.Stack;

import util.PrintUtil;
import util.TreeBuilder;
import util.TreeNode;

public class DFSPostorder {

	public static void main(String[] args) {
		TreeNode root = TreeBuilder.buildTree(new Integer[][] {
			{ 1 }, 
			{ 2, 3 }, 
			{ 4, null, 6, 7 }, 
			{ 8, 9, 10, 11, 12, 13, 14, 15 } 
		});
		
		PrintUtil.printList(postorderTraversal(root));
		PrintUtil.printList(postorderTraversal2(root));
		PrintUtil.printList(postorderTraversal3(root));
	}



	private static ArrayList<Integer> postorderTraversal(TreeNode root) {
		
		ArrayList<Integer>  l = new ArrayList<Integer> ();
		if(null == root){
			return l;
		}
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		
		while(!stack.isEmpty()){
			TreeNode node = stack.pop();
			
			if(null != node.right || null != node.left){ // has 1 or more child
				stack.push(new TreeNode(node.val)); // push node (value only)
			}else{
				l.add(node.val); // return the value
			}
			
			if(null != node.right){
				stack.push(node.right);
			}
						
			if(null != node.left){
				stack.push(node.left);
			}
			
		}
		
		
		return l;
	}
	
	private static ArrayList<Integer> postorderTraversal2(TreeNode root) {

		ArrayList<Integer>  l = new ArrayList<Integer> ();
		re(root, l);
		return l;
	}
	private static void re(TreeNode node, ArrayList<Integer> l) {
		if(node==null){return;}
		re(node.left,l);
		re(node.right,l);
		l.add(node.val);
	}

	
	private static ArrayList<Integer> postorderTraversal3(TreeNode root) {
		ArrayList<Integer>  l = new ArrayList<Integer> ();
		if(root==null){return l;}
		l.addAll(postorderTraversal3(root.left));
		l.addAll(postorderTraversal3(root.right));
		l.add(root.val);

		return l;
	}

}
