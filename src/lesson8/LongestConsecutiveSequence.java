package lesson8;
import java.util.*;
public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int longestConsecutive(int[] num) {
    	
        Map<Integer,Boolean> map = new HashMap<Integer,Boolean>(); //boolean:visited
        
        for(int i : num){
            map.put(i,false);
        }
        
        int max = 0;
        
        for(int i : num){
            if(map.get(i)){continue;}
            
            int currMax = 1;
            int temp = i;
            while(map.containsKey(++temp)){
                currMax++;
                map.put(temp,true);
            }
            temp=i;
            while(map.containsKey(--temp)){
                currMax++;
                map.put(temp,true);
            }
            
            max = Math.max(max,currMax);
        }
        
        return max;
    }

}
