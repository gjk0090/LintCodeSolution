package lesson3;

import java.util.*;


import util.TreeBuilder;
import util.TreeNode;

public class BFS {

	public static void main(String[] args) {
		TreeNode root = TreeBuilder.buildTree(new Integer[][] {
			{ 1 }, 
			{ 2, 3 }, 
			{ 4, null, 6, 7 }, 
			{ 8, 9, null, null, 12, 13, 14, 15 } ,
			{1,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null}
		});

		System.out.println(levelOrderSimple(root));
		ArrayList result = levelOrder(root);
		for(Object l : result){
			System.out.println((List<Integer>) l);
		}
	}
	
	
    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root == null){return result;}
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.offer(root);
    	while(!queue.isEmpty()){
            ArrayList<Integer> l = new ArrayList<Integer>();
            int size = queue.size();
            for(int i = 0; i < size; i++){
	    		TreeNode node = queue.poll();
	    		l.add(node.val);
	    		if(node.left != null){
	    			queue.offer(node.left);
	    		}
	    		if(node.right != null){
	    			queue.offer(node.right);
	    		}
            }
            result.add(l);
    	}
		return result;

    }

    
    public static ArrayList<Integer> levelOrderSimple(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();

    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	
    	queue.offer(root);
    	while(!queue.isEmpty()){
    		TreeNode node = queue.poll();
    		if(node != null){
    			result.add(node.val);
    			queue.offer(node.left);
    			queue.offer(node.right);
    		}else{
    			result.add(null);
    		}
    	}
		return result;
    }
}
