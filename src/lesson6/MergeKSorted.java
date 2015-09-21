package lesson6;

import java.util.*;

import util.ListNode;
import util.ListUtil;

public class MergeKSorted {

	public static void main(String[] args) {
		ListNode head1 = ListUtil.buildList(new int[]{5,9,22});
		ListNode head2 = ListUtil.buildList(new int[]{1,24,99});
		ListNode head3 = null;
		ListNode head4 = ListUtil.buildList(new int[]{-1,0,1});
		ListNode head5 = ListUtil.buildList(new int[]{55,111,222,333});
		List<ListNode> lists = new ArrayList<ListNode>();
		lists.add(head1);
		lists.add(head2);
		lists.add(head3);
		lists.add(head4);
		lists.add(head5);		
		
		System.out.println(ListUtil.printList(mergeKLists3(lists)));

	}
	// 1 by 1
    public static ListNode mergeKLists1(List<ListNode> lists) {
    	ListNode dummy = null;
    	
    	for (int i = 0; i < lists.size(); i++) {
    		dummy = merge(dummy,lists.get(i));
		}
    	
		return dummy;  
    }
    
    // DC
    public static ListNode mergeKLists2(List<ListNode> lists) {
    	
    	if(lists.size() == 1){return lists.get(0);}
    	if(lists.size() == 0){return null;}
    	
    	List<ListNode> l1 = new ArrayList<ListNode>();
    	List<ListNode> l2 = new ArrayList<ListNode>();
    	
    	int middle = lists.size()/2;
    	
    	for (int i = 0; i < middle; i++) {
			l1.add(lists.get(i));
		}
    	
    	for (int i = middle; i < lists.size(); i++) {
			l2.add(lists.get(i));
		}
    	
		return merge(mergeKLists2(l1), mergeKLists2(l2));  
    }
    
    // heap
    public static ListNode mergeKLists3(List<ListNode> lists) {
    	if (lists == null || lists.size() == 0){return null;}
    	
    	Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(),(ListNode n1, ListNode n2)->{
    		return n1.val - n2.val;
    	});
    	
    	for (ListNode node : lists) {
    		if(node != null){
    			heap.add(node);
    		}
		}
    	
    	ListNode dummy = new ListNode(0);
    	ListNode head = dummy;
    	
    	while(!heap.isEmpty()){
    		head.next = heap.poll();
    		head = head.next;
    		if(head.next != null){
    			heap.add(head.next);
    		}
    	}
    	
		return dummy.next;  
    }
    
    private static ListNode merge(ListNode l1, ListNode l2){
    	
    	ListNode dummy = new ListNode(0);
    	ListNode head = dummy;
    	
    	while(l1 != null && l2 != null){
    		if(l1.val < l2.val){
    			head.next = l1;
    			l1 = l1.next;
    		}else{
    			head.next = l2;
    			l2 = l2.next;
    		}
    		head = head.next;
    	}
    	
    	if(l1 != null){
    		head.next = l1;
    	}else{
    		head.next = l2;
    	}
    	
    	return dummy.next;
    }
}
