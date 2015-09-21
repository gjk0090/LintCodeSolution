package lesson6;

import util.ListNode;

public class LinkedListCycle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public boolean hasCycle(ListNode head) {  
        
        if(head==null){return false;}
        
        ListNode fast = head.next;
        ListNode slow = head;
        
        while(fast != null && fast.next != null){
            if(fast == slow){
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
            
        }
        
        return false;
    }

}
