package lesson6;

import util.ListNode;

public class AddTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public ListNode addLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        
        int carry = 0;
        
        while(l1 != null || l2 != null){
            int val1 = (l1 != null)? l1.val:0;
            int val2 = (l2 != null)? l2.val:0;
            int sum = val1 + val2 + carry; //important
            
            carry = (sum>=10)? 1:0;    
            head.next = new ListNode(sum%10);

            l1 = (l1 != null)? l1.next:null;
            l2 = (l2 != null)? l2.next:null;
            head = head.next;
        }
        
        if(carry != 0){
            head.next = new ListNode(carry);
        }
        
        return dummy.next;
    }

}
