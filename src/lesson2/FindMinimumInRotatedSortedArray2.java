package lesson2;
/**
 * contains duplicates
 * O(n) only
 * @author gjk
 *
 */
public class FindMinimumInRotatedSortedArray2 {

	public static void main(String[] args){
		
		System.out.println(findMin(new int[] {1,3,3,3,4,5,5,6,7,8,9,-1}));
		System.out.println(findMin(new int[] {1,1,1,1,0,1,1,1}));

	}
	
    public static int findMin(int[] num) {
    	if(num == null || num.length == 0){
    		return -1;
    	}
    	
    	int min = num[0];
    	
    	for(int i=1; i<num.length; i++){
    		if(num[i]<min){
    			min = num[i];
    		}
    	}
    	return min;
    }
}
