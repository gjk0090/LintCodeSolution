package lesson9;

import java.util.*;

public class TwoSum {

	public static void main(String[] args) {

		System.out.println(Arrays.toString(twoSum(new int[]{1,0,-1},-1)));
	}
	
	
    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<numbers.length;i++){
            if(map.containsKey(target-numbers[i])){
                return new int[]{Math.min(i+1,map.get(target-numbers[i])),Math.max(i+1,map.get(target-numbers[i]))};
            }else{
                map.put(numbers[i],i+1);
            }
        }
        return null;
    }
}
