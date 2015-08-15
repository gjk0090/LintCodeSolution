package lesson2;
/**
 * no duplicates
 * @author gjk
 *
 */
public class FindMinimumInRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findMin(new int[] {10,1,3,4,5,6,7,8,9}));
	}

    public static int findMin(int[] num) {
    	if(num == null || num.length == 0){
    		return -1;
    	}
    	
    	if(num[0] < num[num.length-1]){
    		return num[0];
    	}
    	
    	int start = 0;
    	int end = num.length - 1;
    	
    	while(start + 1 < end){
    		
    		int middle = start + (end - start)/2;
    		
    		
    		if(num[middle] < num[middle - 1]){
    			return num[middle];
    		}else if(num[middle] > num[start]){
    			start = middle;
    		}else{//num[middle] < num[start]
    			end = middle;
    		}	
    	}
    	
    	if(num[start] < num[end]){
    		return num[start];
    	}else{
    		return num[end];
    	}
    }
    
}
