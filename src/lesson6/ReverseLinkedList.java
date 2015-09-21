package lesson6;

import util.ListNode;
import util.ListUtil;

public class ReverseLinkedList {

	public static void main(String[] args) {
		ListNode head = ListUtil.buildList(new int[] {1,2,3,4});
		System.out.println(ListUtil.printList(reverse(head)));
	}
    public static ListNode reverse(ListNode head) {
    	
    	ListNode prev = null;
    	
    	while(head != null){
    		ListNode temp = head.next;
    		head.next = prev;
    		prev = head;
    		head  = temp;
    	}
    	
		return prev;
    	
    }
}
