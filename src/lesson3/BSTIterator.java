package lesson3;

import java.util.*;

import util.PrintUtil;
import util.TreeBuilder;
import util.TreeNode;

public class BSTIterator {

	public static void main(String[] args) {
		TreeNode root = TreeBuilder.buildTree(new Integer[][] {{4},{2,6},{1,3,5,7}});
		BSTIterator iterator = new BSTIterator(root);
		
		while (iterator.hasNext()) {
			 TreeNode node = iterator.next();
			 System.out.println(node.val);
		} 
	}
	
	
	
	
	List<TreeNode> list;
	
    public BSTIterator(TreeNode root) {
    	list = inOrder(root);
    }

    private List<TreeNode> inOrder(TreeNode root) {
    	List<TreeNode> list = new ArrayList<TreeNode>();
    	if(root==null){return list;}
    	
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	stack.push(root);
    	
    	while(!stack.isEmpty()){
    		TreeNode node = stack.pop();
    		
    		if(node.right != null){
    			stack.push(node.right);
    		}
    		
    		if(node.left != null){
    			stack.push(new TreeNode(node.val));
    			stack.push(node.left);
    		}else{
    			list.add(node);
    		}
    	}
		return list;
	}

	//@return: True if there has next node, or false
    public boolean hasNext() {
		return !list.isEmpty();
    }
    
    //@return: return next node
    public TreeNode next() {
    	TreeNode node = list.get(0);
    	list.remove(0);
		return node;
    }
}





//http://www.jiuzhang.com/solutions/implement-iterator-of-binary-search-tree
class Solution {
    private Stack<TreeNode> stack = new Stack<>();
    private TreeNode curt;
    
    // @param root: The root of binary tree.
    public Solution(TreeNode root) {
        curt = root;
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        return (curt != null || !stack.isEmpty());
    }
    
    //@return: return next node
    public TreeNode next() {
        while (curt != null) {
            stack.push(curt);
            curt = curt.left;
        }
        
        curt = stack.pop();
        TreeNode node = curt;
        curt = curt.right;
        
        return node;
    }
}