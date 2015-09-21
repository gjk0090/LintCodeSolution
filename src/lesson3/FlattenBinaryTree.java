package lesson3;

import util.TreeBuilder;
import util.TreeNode;

public class FlattenBinaryTree {

	public static void main(String[] args) {
		TreeNode root = TreeBuilder.buildTree("1,2,5,3,4,#,6");
		flatten(root);
		System.out.println(DFSInorder.inorderTraversal(root));
	}

	/**
	 * Definition for a binary tree node. public class TreeNode { int val;
	 * TreeNode left; TreeNode right; TreeNode(int x) { val = x; } }
	 */
	public static void flatten(TreeNode root) {

		while (root != null) {
			if (root.left != null) {
				TreeNode left = root.left;
				TreeNode firstNullRight = left;
				while (firstNullRight.right != null) {
					firstNullRight = firstNullRight.right;
				}
				firstNullRight.right = root.right;
				root.right = left;
				root.left = null;
			}
			root = root.right;
		}
	}

}
