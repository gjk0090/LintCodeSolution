package lesson6;

import util.ListNode;
import util.ListUtil;

public class PartitionList {

	public static void main(String[] args) {
		ListNode head = ListUtil.buildList(new int[]{1,4,3,2,5,2});
		System.out.println(ListUtil.printList(partition(head,3)));
	}
    public static ListNode partition(ListNode head, int x) {
    	
    	ListNode left = new ListNode(), right = new ListNode();
    	ListNode oriLeft = left, oriRight = right;
    	
    	while(head != null){
    		if(head.val < x){
    			left.next = head;
    			left = head;
    		}else{
    			right.next = head;
    			right = head;
    		}
    		head = head.next;
    	}
    	
    	left.next = oriRight.next;
    	right.next = null;
    	
		return oriLeft.next;
    }

}
