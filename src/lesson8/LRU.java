package lesson8;
import java.util.*;
public class LRU {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRU lru = new LRU(2);
		lru.set(2,1);
		lru.set(1,1);
		System.out.println(lru.get(2));
		lru.set(4,1);
		System.out.println(lru.get(1));
		System.out.println(lru.get(2));
	}
	
	int capacity;
	List<Integer> list;
	Map<Integer,Integer> map;
	
    // @param capacity, an integer
    public LRU(int capacity) {
    	this.capacity = capacity;
    	list = new LinkedList<Integer>();
    	map = new HashMap<Integer,Integer>();
    
    }

    // @return an integer
    public int get(int key) {
    	if(map.containsKey(key)){
    		list.remove(new Integer(key));
    		list.add(key);
    		return map.get(key);
    	}else{
    		return -1;
    	}
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
    	
    	if(map.containsKey(key)){
    		list.remove(new Integer(key));
    		list.add(key);
    	}else if(list.size()>=capacity){
    		int oldKey = list.remove(0);
    		map.remove(oldKey);
    		list.add(key);
    	}else{
    		list.add(key);
    	}
    	map.put(key, value);
    }
    
}
