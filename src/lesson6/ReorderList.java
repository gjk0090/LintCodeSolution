package lesson6;

import util.ListNode;
import util.ListUtil;

public class ReorderList {

	public static void main(String[] args) {
		ListNode head = ListUtil.buildList(new int[]{1,2,3,4,5,6,7,8,9});
		reorderList(head);
		System.out.println(ListUtil.printList(head));
	}
	
	
    public static void reorderList(ListNode head) {  
    	
    	if(head == null){return;}
    	    	
    	ListNode middle = findMiddle(head);
    	
    	ListNode rightHead = middle.next;
    	middle.next = null;
    	
    	rightHead = inverse(rightHead);
    	
    	while(rightHead != null){
    		ListNode temp = head.next;
    		head.next = rightHead;
    		rightHead = rightHead.next;
    		head = head.next;
    		head.next = temp;
    		head = head.next;
    	}
    	
    }
    
	private static ListNode inverse(ListNode head) {
		
		ListNode prev = null;
		while(head != null){
			ListNode temp = head.next;
			head.next = prev;
			prev = head;
			head = temp;
		}
		
		return prev;
	}
	private static ListNode findMiddle(ListNode head) {
		ListNode fast = head.next;
		ListNode slow = head;
		
		while(fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
}
