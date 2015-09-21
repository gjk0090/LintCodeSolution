package lesson6;

import util.ListNode;
import util.ListUtil;

public class InsertSortedList {

	public static void main(String[] args) {
		ListNode head = ListUtil.buildList(new int[]{1,2,3,4,5,7});
		//amazing result, why?
		System.out.println(ListUtil.printList(insert(head,0)));
		System.out.println(ListUtil.printList(head));
		System.out.println(ListUtil.printList(insert(head,6)));
		System.out.println(ListUtil.printList(head));
		System.out.println(ListUtil.printList(insert(head,9)));
		System.out.println(ListUtil.printList(head));
	}

	public static ListNode insert(ListNode head, int x) {

		ListNode dummy = new ListNode(0);
		dummy.next = head;
		head = dummy;
		
		while(head.next != null){
			if(head.next.val > x){
				ListNode temp = new ListNode(x);
				temp.next = head.next;
				head.next = temp;
				return dummy.next;
			}
			head = head.next;
		}

		ListNode temp = new ListNode(x);
		head.next = temp;
		
		return dummy.next;
	}

}
