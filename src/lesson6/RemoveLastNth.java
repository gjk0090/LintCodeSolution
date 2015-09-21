package lesson6;

import util.ListNode;
import util.ListUtil;

public class RemoveLastNth {

	public static void main(String[] args) {
		ListNode head = ListUtil.buildList(new int[]{1,2,3,4,5,6,7,8,9});
		System.out.println(ListUtil.printList(removeNthFromEnd(head,3)));
	}
    public static ListNode removeNthFromEnd(ListNode head, int n) {
    	
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	
    	ListNode fast = dummy;
    	ListNode slow = dummy;
    	
    	for(int i=0; i<=n; i++){
    		if(fast != null){
    			fast = fast.next;
    		}else{
    			return null;
    		}
    	}
    	
    	while(fast != null){
			fast = fast.next;
			slow = slow.next;
    	}
    	
    	slow.next = slow.next.next;
    	
		return dummy.next;
    }
}
