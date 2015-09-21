package lesson6;

import util.ListNode;

public class Merge2Sorted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        
        while(l1 != null && l2 != null){
            if(l1.val>l2.val){
                dummy.next = l2;
                l2 = l2.next;
            }else{
                dummy.next = l1;
                l1 = l1.next;
            }
            dummy = dummy.next;
        }
        
        if(l2==null){
            dummy.next = l1;
        }else{
            dummy.next = l2;
        }
        
        return head.next;
    }
}
