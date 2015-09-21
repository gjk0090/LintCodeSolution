package lesson6;

import util.*;

public class RemoveDuplicates {

	public static void main(String[] args) {
		ListNode head = ListUtil.buildList(new int[] {1,1,1,2,3,3});
		System.out.println(ListUtil.printList(deleteDuplicates(head)));
	}
    public static ListNode deleteDuplicates(ListNode head) {
    	
    	if(head == null){return null;}
    	
    	ListNode temp = head;
    	
    	while(temp.next != null){
    		if(temp.val == temp.next.val){
    			temp.next = temp.next.next;
    		}else{
    			temp = temp.next;
    		}
    	}
		return head; 
    }
}
