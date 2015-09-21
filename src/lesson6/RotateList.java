package lesson6;

import util.ListNode;
import util.ListUtil;

public class RotateList {

	public static void main(String[] args) {
		ListNode head = ListUtil.buildList(new int[]{1,2,3,4,5});
		System.out.println(ListUtil.printList(rotateRight(head,0)));
	}
    public static ListNode rotateRight(ListNode head, int k) {
    	if(head == null){return head;}
    	
    	int size = 1;
    	
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	
    	ListNode oriHead = head;
    	
    	while(head.next != null){
			head = head.next;
			size++;
		}
    	ListNode oriEnd = head;
    	
    	int realK = k%size;
    	if(realK == 0){
    		return dummy.next;
    	}
    	
    	ListNode preK = findPreK(oriHead, realK);
    	ListNode K = preK.next;
    	
    	dummy.next = K;
		oriEnd.next = oriHead;
    	preK.next = null;
    	
    	
		return dummy.next;
    }

	
	private static ListNode findPreK(ListNode head, int k) {
		ListNode fast = head;
		ListNode slow = head;
		
		for (int i = 0; i < k; i++) {
			fast = fast.next;
		}
		
		while(fast.next != null){
			fast = fast.next;
			slow = slow.next;
		}
		
		return slow;
	}

}
