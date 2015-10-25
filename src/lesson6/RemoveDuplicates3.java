package lesson6;

import java.util.*;

import util.ListNode;

public class RemoveDuplicates3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public ListNode removeDuplicates(ListNode head) { 

        ListNode dummy = new ListNode(-1);
        dummy.next=head;
        head=dummy;
        
        Set<Integer> set = new HashSet<Integer>();
        
        while(head.next != null){
            if(set.contains(head.next.val)){
                head.next=head.next.next;
            }else{
                set.add(head.next.val);
                head=head.next;
            }
        }
        
        return dummy.next;
    }  
}
