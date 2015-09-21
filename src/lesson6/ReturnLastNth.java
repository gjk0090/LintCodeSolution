package lesson6;

import util.ListNode;

public class ReturnLastNth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public ListNode nthToLast(ListNode head, int n) {

        ListNode fast = head;
        ListNode slow = head;
        
        for(int i=0; i<n; i++){
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
        
        return slow;
    }
}
