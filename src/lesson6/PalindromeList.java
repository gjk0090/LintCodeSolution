package lesson6;

import util.ListNode;

public class PalindromeList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public boolean isPalindrome(ListNode head) {
        
        if(head==null || head.next==null){return true;}
        
        ListNode middle = findMiddle(head);
        
        middle.next = reverse(middle.next);
        
        ListNode pointer = middle.next;
        while(pointer!=null){
            if(head.val!=pointer.val){
                return false;
            }
            head=head.next;
            pointer=pointer.next;
        }
        
        return true;
    }
    
    //middle or left
    private ListNode findMiddle(ListNode head){
        ListNode fast = head.next;
        ListNode slow = head;
        
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow;
    }
    
    private ListNode reverse(ListNode head){
        
        ListNode prev=null;
        
        while(head!=null){
            ListNode temp = head.next;
            head.next=prev;
            prev=head;
            head = temp;
        }
        
        return prev;
    }
}
