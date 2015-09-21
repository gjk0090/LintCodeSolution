package lesson6;

import util.ListNode;

public class LinkedListCycle2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public ListNode detectCycle(ListNode head) {  
        if(head==null){return null;}
        
        ListNode fast = head.next;
        ListNode slow = head;
        
        while(fast != null && fast.next != null){
            if(fast == slow){
                while(true){
                	if(head == slow.next){
                		return head;
                	}
                	head = head.next;
                	slow = slow.next;
                }
            }
            fast = fast.next.next;
            slow = slow.next;
            
        }
        
        return null;
    }
}
