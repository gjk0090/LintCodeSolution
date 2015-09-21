package util;
import java.util.LinkedList;
import java.util.Queue;

import util.TreeNode;

public class TreeBuilder {
	
	/**
	 * 		How To Use :
	 * 	   	TreeNode root = TreeBuilder.buildTree(new Integer[][] {
	 * 			{ 1 }, 
	 * 			{ 2, 3 }, 
	 * 			{ 4, null, 6, 7 }, 
	 * 			{ 8, 9, 10, 11, 12, 13, 14, 15 } // 10 and 11 will be ignored because parent is null
	 * 		});
	 */
	
	public static TreeNode buildTree(Integer[][] treeMatrix){
		
		if(treeMatrix == null || treeMatrix.length == 0){return null;}
		
		TreeNode root = getNode(treeMatrix,0,0);
				
		return root;
	}
	
	private static TreeNode getNode(Integer[][] treeMatrix, int row, int column){
		
		if(row > treeMatrix.length-1 || column > treeMatrix[row].length-1){
			return null;
		}
		
		TreeNode node = null;
		
		if(null != treeMatrix[row][column]){
			node = new TreeNode(treeMatrix[row][column]);
			node.left = getNode(treeMatrix,row+1,column*2);
			node.right = getNode(treeMatrix,row+1,column*2+1);
		}
		
		return node;
	}
	
	
	
	
	/**
	 * How To Use:
	 * TreeNode root = TreeBuilder.buildTree("1,2,3,4,#,6,7,8,9,12,13,14,15,1,#,#,#,#,#,#,#,#,#,#,99");
	 * @param data
	 * @return
	 */
    public static TreeNode buildTree(String data) {
    	if(data==null || data.length()==0){return null;}

    	String[] input = data.split(",");
    	int index = 0;
    	
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	TreeNode root = new TreeNode(Integer.valueOf(input[index++]));
    	queue.offer(root);
    	
    	while(!queue.isEmpty()){
    			if(index >= input.length){break;}
    			
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
