package lesson3;

import java.util.*;


import util.TreeBuilder;
import util.TreeNode;

public class BFSZigzag {

	public static void main(String[] args) {
		TreeNode root = TreeBuilder.buildTree(new Integer[][] {
			{ 1 }, 
			{ 2, 3 }, 
			{ 4, null, 6, 7 }, 
			{ 8, 9, null, null, 12, 13, 14, 15 } ,
			{1,null,null,null,null,null,null,null,null,null,null,null,null,null,null,999}
		});
		
		ArrayList<ArrayList<Integer>> result = zigzagLevelOrder(root);
		for(ArrayList<Integer> l : result){
			System.out.println(l);
		}

	}
	
    public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root == null){return result;}
        boolean zigzag = false;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
        	ArrayList<Integer> l = new ArrayList<Integer>();
        	int size = queue.size();
        	
        	for(int i=0; i<size; i++){
        		TreeNode node = queue.poll();
        		if(zigzag){
        			l.add(0,node.val);
        		}else{
        			l.add(node.val);
        		}
        		if(node.left!=null){queue.offer(node.left);}
        		if(node.right!=null){queue.offer(node.right);}
        	}
        	result.add(l);
        	zigzag = !zigzag;
        }
		return result;

    }

}
