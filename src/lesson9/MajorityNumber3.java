package lesson9;
import java.util.*;
public class MajorityNumber3 {

	public static void main(String[] args) {
		System.out.println(majorityNumber(Arrays.asList(new Integer[]{1,1,1,1,2,2,2,3,3,3,4,4,4,5,5,5}),5));
	}
    public static int majorityNumber(List<Integer> nums, int k) {
    	
    	Map<Integer,Integer> counters = new HashMap<Integer,Integer>();
    	
    	//find k-1 candidates
    	//important
    	for(int i : nums){
    		if(counters.containsKey(i)){
    			counters.put(i,counters.get(i)+1);
    		}else if(counters.size()>k-1){
    			subtract(counters);
    		}else{
    			counters.put(i, 1);
    		}
    	}
    	
    	//compare k-1 candidates
    	for(int i : counters.keySet()){
    		counters.put(i, 0);
    	}
    	for(int i : nums){
    		if(counters.containsKey(i)){
    			counters.put(i,counters.get(i)+1);
    		}
    	}
    	int maxCount=0, result=-1;
    	for(int i : counters.keySet()){
    		if(counters.get(i)>maxCount){
    			maxCount = counters.get(i);
    			result = i;
    		}
    	}
    	
    	
    	
		return result;

    }
	private static void subtract(Map<Integer, Integer> counters) {
		List<Integer> removeList = new ArrayList<Integer>(); //record key to be removed!!

		for(int i : counters.keySet()){
			counters.put(i, counters.get(i)-1);
			if(counters.get(i)==0){
				removeList.add(i);
			}
		}
		
		for(int i : removeList){
			counters.remove(i);
		}
	}
}
