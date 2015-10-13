package lesson3;

import java.util.ArrayList;
import java.util.List;

import util.TreeBuilder;
import util.TreeNode;

public class InorderSuccessorInBST {

	public static void main(String[] args) {
		TreeNode root = TreeBuilder.buildTree("7,2,8,1,6,#,10,#,#,3,#,9,11,#,5,#,#,#,#,4");
		List<ArrayList<Integer>> bfs = BFS.levelOrder(root);
		for(List l : bfs){
			System.out.println(l);
		}
		
		System.out.println(inorderSuccessor(root,new TreeNode(3)).val);
	}

    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        
        while(root != null && root.val != p.val){
        	if(p.val > root.val){//go right
        		root = root.right;
        	}else{//go left
        		successor = root;
        		root = root.left;
        	}
        }
        
        if(root == null){return null;}
        
        if(root.right == null){
        	return successor;
        }else{
        	successor = root.right;
        	while(successor.left != null){
        		successor = successor.left;
        	}
        }
        
        
		return successor;

    }
}
