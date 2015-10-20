package lesson9;

import java.util.*;

public class SubarraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public ArrayList<Integer> subarraySum(int[] nums) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        map.put(0,-1); //important
        
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(map.containsKey(sum)){
                return new ArrayList<Integer>(Arrays.asList(map.get(sum)+1,i));
            }
            map.put(sum,i);
        }
        
        return null;
    }
}
