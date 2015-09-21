package lesson6;

import util.ListNode;
import util.ListUtil;

public class RemoveFromList {

	public static void main(String[] args) {
		ListNode head = ListUtil.buildList(new int[]{3,1,4,3,2,5,3,3,2,3});
		System.out.println(ListUtil.printList(remove(head,3)));
	}

	public static ListNode remove(ListNode head, int x) {

		ListNode dummy = new ListNode(0);
		dummy.next = head;
		head = dummy;
		
		while(head.next != null){
			if(head.next.val == x){
				head.next = head.next.next;
			}else{
				head = head.next;
			}
		}
		
		return dummy.next;
	}

}
