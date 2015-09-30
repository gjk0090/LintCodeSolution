package lesson6;

import util.ListNode;
import util.ListUtil;

// https://leetcode.com/problems/reverse-nodes-in-k-group/
public class ReverseNodesInKGroup {

	public static void main(String[] args) {
		ListNode head = ListUtil.buildList(new int[]{1,2,3,4,5});
		//System.out.println(ListUtil.printList(reverseKGroup(head,2)));
		System.out.println(ListUtil.printList(reverseKGroup(head,3)));
	}

	public static ListNode reverseKGroup(ListNode head, int k) {
		// check if length< k
		ListNode runner = head;
		int counter = 0;
		while(runner != null){
			runner = runner.next;
			counter++;
		}
		if(counter < k){return head;}
		
		// reverse first k nodes
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		
		ListNode oriHead = head;
		ListNode prev = null;
		
		for(int i=0; i<k; i++){
			ListNode temp = head.next;
			head.next = prev;
			prev = head;
			head = temp;
		}
		
		// append rest nodes by recur
		dummy.next = prev;
		oriHead.next = reverseKGroup(head, k);
		
		return dummy.next;
	
	}
}
