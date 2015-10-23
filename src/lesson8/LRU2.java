package lesson8;

import java.util.*;

public class LRU2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private final LinkedHashMap<Integer, Integer> map;

    public LRU2(int capacity) { 
        map = new LinkedHashMap<Integer, Integer>() { 
            @Override protected boolean removeEldestEntry(Map.Entry eldest) {
                return this.size() > capacity; 
            } 
        }; 
    }

    public int get(int key) { 
        Integer val = map.get(key); 
        if (val != null) { 
            map.remove(key); 
            map.put(key, val); 
            return val; 
            
        } else { 
            return -1; 
        } 
    }

    public void set(int key, int val) {
        if (map.containsKey(key)) map.remove(key);
        map.put(key, val); 
    } 
}
