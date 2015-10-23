package lesson8;

import util.TreeNode;

public class MaxTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
    public TreeNode maxTree(int[] A) {
        return maxTree(A,0,A.length-1);
    }
    
    private TreeNode maxTree(int[] A, int start, int end){
    	
        if(start>end){return null;}//important
        
        if(start == end){
            return new TreeNode(A[start]);
        }
        
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        
        for(int i=start;i<=end;i++){
            if(max<A[i]){
                max = A[i];
                maxIndex = i;
            }
        }
        
        TreeNode root = new TreeNode(A[maxIndex]);
        
        root.left = maxTree(A,start,maxIndex-1);
        root.right = maxTree(A,maxIndex+1,end);
        
        
        return root;
    }
}
