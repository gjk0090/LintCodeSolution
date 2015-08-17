package lesson3;

import java.util.*;


import util.TreeBuilder;
import util.TreeNode;

public class BinaryTreeSerialization {

	public static void main(String[] args) {
		TreeNode root = TreeBuilder.buildTree(new Integer[][] {
			{ 1 }, 
			{ 2, 3 }, 
			{ 4, null, 6, 7 }, 
			{ 8, 9, null, null, 12, 13, 14, 15 } ,
			{1,null,null,null,null,888,null,null,null,null,null,null,null,null,null,99}
		});
		
		System.out.println(serialize(root));
		root = deserialize(serialize(root));
		System.out.println(serialize(root));

	}

    /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public static String serialize(TreeNode root) {
    	if(root == null){return "";}
    	
    	StringBuilder result = new StringBuilder();
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	
    	queue.offer(root);
    	while(!queue.isEmpty()){

    		TreeNode node = queue.poll();
    		if(node != null){
    			result.append(node.val+",");
    			queue.offer(node.left);
    			queue.offer(node.right);
    		}else{
    			result.append("#,");
    		}
    		
    	}
    	result.deleteCharAt(result.length()-1); //remove the last ","
		return result.toString();
    }
    
    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public static TreeNode deserialize(String data) {
    	if(data==null || data.length()==0){return null;}
    	
    	String[] input = data.split(",");
    	
    	int index = 0;
    	
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	TreeNode root = new TreeNode(Integer.valueOf(input[index++]));
    	queue.offer(root);
    	
    	while(!queue.isEmpty()){

    			TreeNode node = queue.poll();
    			if(node != null){
    				String leftString = input[index++];
    				String rightString = input[index++];
    				TreeNode left = null;
    				TreeNode right = null;
    				if(!leftString.equals("#")){
    					left = new TreeNode(Integer.valueOf(leftString));
    				}
    				if(!rightString.equals("#")){
    					right = new TreeNode(Integer.valueOf(rightString));
    				}
    				node.left = left;
    				node.right = right;
    				queue.offer(left);
    				queue.offer(right);
    			}
    		
    	}
		return root;
    }
    
}
