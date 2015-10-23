package lesson8;

import util.ListNode;

public class ReHashing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public ListNode[] rehashing(ListNode[] hashTable) {

        int size = hashTable.length*2;
        ListNode[] result = new ListNode[size];
        
        for(ListNode node : hashTable){
            while(node != null){
                int hash = (node.val % size + size) % size; //negative number cannot use val%size
                ListNode temp = result[hash];
                if(temp == null){
                    result[hash] = new ListNode(node.val);
                }else{
                    while(temp.next != null){
                        temp = temp.next;
                    }
                    temp.next = new ListNode(node.val);
                }
                
                node = node.next;
                
                 
            }
        }
        
        return result;
    }
}
