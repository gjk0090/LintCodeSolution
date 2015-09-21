package util;

public class ListUtil {

	public static ListNode buildList(int[] array){
		
		ListNode head = new ListNode(array[0]);
		
		ListNode temp = head;
		
		for(int i=1; i<array.length; i++){
			ListNode node = new ListNode(array[i]);
			temp.next = node;
			temp = node;
		}
		
		return head;
	}
	
	public static String printList(ListNode head){
		StringBuilder sb = new StringBuilder();
		
		while(head != null){
			sb.append(head.val+" ");
			head = head.next;
		}
		
		return sb.toString();
	}
}
