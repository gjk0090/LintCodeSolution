package lesson6;

import util.ListNode;

public class RemoveElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public ListNode removeElements(ListNode head, int val) {
        
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        head = dummy;

        while(head.next!=null){
            if(head.next.val==val){
                head.next = head.next.next;
            }else{
                head = head.next;
            }
        }        
        
        return dummy.next;
    }
}
