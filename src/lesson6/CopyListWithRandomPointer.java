package lesson6;

import java.util.HashMap;
import java.util.Map;

import util.RandomListNode;

public class CopyListWithRandomPointer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public RandomListNode copyRandomList(RandomListNode head) {
    	if(head == null){return null;}
    	
    	Map<RandomListNode,RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();
    	
    	RandomListNode oriHead = head;
    	
    	RandomListNode dummy = new RandomListNode(0);
    	RandomListNode tail = dummy;
    	
    	while(head != null){
    		RandomListNode temp = new RandomListNode(head.label);
    		tail.next = temp;
    		tail = tail.next;
    		map.put(head, tail);
    		head = head.next;
    	}
    	
    	head = oriHead;
    	tail = dummy.next;
    	while(head != null){
    		tail.random = map.get(head.random);
    		tail = tail.next;
    		head = head.next;
    	}
    	
		return dummy.next;
    }
}
