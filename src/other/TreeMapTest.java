package other;

import java.util.*;

public class TreeMapTest {

	public static void main(String[] args) {

		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		
		map.put(5,2);
		map.put(6,2);
		map.put(7,2);
		
		int sum = 6;
		int q = 3;
		

		for(int k=1;k<q;k++){
			int index = (int) Math.ceil(sum*k/q); System.out.println(index);
			System.out.println(findNum(map,index));
		}
		
		
	}

	private static int findNum(TreeMap<Integer, Integer> map, int index) {
		
		for(int i : map.keySet()){
			if(map.get(i) < index){
				index -= map.get(i);
				continue;
			}else{ // >=
				return i;
			}
		}
		
		return 0;
	}

}
