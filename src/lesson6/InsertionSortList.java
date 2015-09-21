package lesson6;

import util.ListNode;
import util.ListUtil;

public class InsertionSortList {

	public static void main(String[] args) {
		ListNode head = ListUtil.buildList(new int[]{3,4,1});
		System.out.println(ListUtil.printList(insertionSortList(head)));

	}
    public static ListNode insertionSortList(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode preHead = head;
        head = head.next;//start from second
        
        while(head != null){
        	
            ListNode comparator = dummy;
            while(comparator.next != head){
            	
                if(head.val < comparator.next.val){
                	
                	preHead.next = head.next;
                	head.next = comparator.next;
                	comparator.next = head;
                	head = preHead; // move forward later
                	
                    break;
                }else{
                    comparator = comparator.next;
                }
            }
            preHead = head;
            head = head.next;
        }
        
        return dummy.next;
    }
}
