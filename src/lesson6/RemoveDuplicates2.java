package lesson6;

import util.ListNode;
import util.ListUtil;

public class RemoveDuplicates2 {

	public static void main(String[] args) {
		ListNode head = ListUtil.buildList(new int[] {1,1,1,2,3,3,4,4,5,5,6,6});
		System.out.println(ListUtil.printList(deleteDuplicates(head)));
	}
	
	
	
	
	private static ListNode deleteDuplicates(ListNode head) {

		if(head == null){return null;}
		
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		
		ListNode temp = dummy;
		
		while(temp.next != null && temp.next.next != null){
			if(temp.next.val == temp.next.next.val){
				int val = temp.next.val;
				while(temp.next != null && temp.next.val == val){
					temp.next = temp.next.next;
				}
			}else{
				temp = temp.next;
			}
		}
		
		return dummy.next;
	}




	//wrong, can't delete the last duplicated node
    public static ListNode deleteDuplicates2(ListNode head) {
    	
    	if(head == null){return null;}
    	
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	
    	int valToDelete = -1;
    	
    	while(head.next != null){
    		
    		if(head.val == head.next.val){
    			valToDelete = head.val;
    			head.next = head.next.next;
    		}else if(head.val == valToDelete){
    			head.val = head.next.val;
    			head.next = head.next.next;
    		}else{
    			head = head.next;
    		}
    	}
		return dummy.next; 
    }

}
