package lesson6;

import util.ListNode;
import util.ListUtil;

public class InsertionSortList {

	public static void main(String[] args) {
		ListNode head = ListUtil.buildList(new int[]{3,4,1});
		System.out.println(ListUtil.printList(insertionSortList(head)));

	}

    
    public static ListNode insertionSortList(ListNode head) {
    	
    	ListNode dummy = new ListNode(0);
    	
    	while(head != null){
    		
    		//insert head into a new list starts with dummy
    		ListNode comparator = dummy;
    		
    		//find the insertion place
    		while(comparator.next!=null && comparator.next.val<head.val){
    			comparator = comparator.next;
    		}
    		
    		//insert head, head goes to next
    		ListNode temp = head.next;
    		head.next = comparator.next;
    		comparator.next = head;
    		head = temp;
    		
    	}
    	return dummy.next;
    }
}
