package lesson6;

import util.ListNode;
import util.ListUtil;

public class SortList {

	public static void main(String[] args) {
		ListNode head = ListUtil.buildList(new int[]{3,1,4});
		System.out.println(ListUtil.printList(sortList(head)));
	}
	
    public static ListNode sortList(ListNode head) {
    	
    	if(head == null || head.next == null){return head;}
    	
    	ListNode middle = findMiddle(head);
    	
    	// cut the list in middle
    	ListNode rightHead = middle.next;
    	middle.next = null;
    	
    	ListNode left = sortList(head);
		ListNode right = sortList(rightHead);
		
		return merge(left,right);
    }
    
	private static ListNode merge(ListNode left, ListNode right) {

		ListNode head = new ListNode(0);
		ListNode dummy = head;
		
		while(left != null && right != null){
			if(left.val > right.val){
				head.next = right;
				right = right.next;
			}else{
				head.next = left;
				left = left.next;
			}
			head = head.next;
		}
		
		if(left == null){
			head.next = right;
		}else{
			head.next = left;
		}
		
		return dummy.next;
	}

	private static ListNode findMiddle(ListNode head) {

		// if only 2 node left, must separate them
		if(head.next.next == null){ //head.next is not null
			return head;
		}
		
		ListNode fast = head;
		ListNode slow = head;
		
		while(fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}
		
		return slow;
	}
}
