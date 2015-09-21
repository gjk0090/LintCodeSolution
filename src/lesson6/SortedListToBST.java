package lesson6;

import lesson3.DFSInorder;
import util.ListNode;
import util.ListUtil;
import util.TreeNode;

public class SortedListToBST {

	public static void main(String[] args) {
		ListNode head = ListUtil.buildList(new int[]{1,2,3});
		System.out.println(DFSInorder.inorderTraversal(sortedListToBST(head)));
	}
    public static TreeNode sortedListToBST(ListNode head) {
    	
    	//important
    	if(head == null){return null;}
    	if(head.next == null){
    		return new TreeNode(head.val);
    	}
    	
    	ListNode preMiddle = findPreMiddle(head);
    	int val = preMiddle.next.val;
    	TreeNode root = new TreeNode(val);
    	
    	//cut into 2 half
    	ListNode rightHead = null;
    	rightHead = preMiddle.next.next;
    	preMiddle.next = null;
    	
    	TreeNode left = sortedListToBST(head);
    	TreeNode right = sortedListToBST(rightHead);
    	root.left = left;
    	root.right = right;
    	
		return root;  
    }
    
	private static ListNode findPreMiddle(ListNode head) {
		// important
		// 1 return 1
		// 1,2 return 1
		// 1,2,3 return 1
		// 1,2,3,4 return 2
		
		if(head.next == null){return head;}
		
		ListNode fast = head.next;
		ListNode slow = head;
		
		while(fast.next != null && fast.next.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}
		
		return slow;
	}
}
