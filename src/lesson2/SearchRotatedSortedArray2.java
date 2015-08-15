package lesson2;

public class SearchRotatedSortedArray2 {

	public static void main(String[] args) {
		System.out.println(search(new int[] {1,1,1,1,0,1,1,1,2}, 2));

	}
	
    public static boolean search(int[] A, int target) {
		if(A == null || A.length == 0){
    		return false;
    	}
    	    	
    	for(int i=0; i<A.length; i++){
    		if(A[i] == target){
    			return true;
    		}
    	}
    	
    	return false;
    }

}
