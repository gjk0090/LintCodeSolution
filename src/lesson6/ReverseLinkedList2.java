package lesson6;

import util.ListNode;
import util.ListUtil;

public class ReverseLinkedList2 {

	public static void main(String[] args) {
		ListNode head = ListUtil.buildList(new int[] {1,2,3,4,5});
		System.out.println(ListUtil.printList(reverseBetween(head,2,4)));
	}
    public static ListNode reverseBetween(ListNode head, int m , int n) {
    	
    	ListNode M = null,N,preM = null,postN = null;
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	head = dummy;
    	
    	for(int i=0; i<=n; i++){
    		if(i == m-1){
    			preM = head;
    			M = head.next;
    		}
    		if(i == n){
    			N = head;
    			postN = head.next;
    		}
    		
    		head = head.next;
    	}
    	
    	ListNode prev = postN;
    	while(M != postN){
    		ListNode temp = M.next;
    		M.next = prev;
    		prev = M;
    		M = temp;
    	}
    	
    	preM.next = prev;
    	
		return dummy.next;

    }
}
