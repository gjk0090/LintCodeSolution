package lesson3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


import util.TreeBuilder;
import util.TreeNode;

public class BFS2 {

	public static void main(String[] args) {
		TreeNode root = TreeBuilder.buildTree(new Integer[][] {
			{ 1 }, 
			{ 2, 3 }, 
			{ 4, null, 6, 7 }, 
			{ 8, 9, null, null, 12, 13, 14, 15 } ,
			{1,null,null,null,null,null,null,null,null,null,null,null,null,null,null,999}
		});
		
		ArrayList<ArrayList<Integer>> result = levelOrderBottom(root);
		for(ArrayList<Integer> l : result){
			System.out.println(l);
		}
	}

    public static ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
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
    		result.add(0, l);
    	}
		return result;
	}

}
