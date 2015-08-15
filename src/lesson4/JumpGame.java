package lesson4;

public class JumpGame {

	public static void main(String[] args) {

		int[] A1 = {2,3,1,1,4};
		int[] A2 = {3,2,1,0,4};
		
		System.out.println(canJump(A1) + " " + canJump(A2));
	}
    public static boolean canJump(int[] A) {
    	
    	if(A==null || A.length==0){return false;}
    	
    	int n = A.length;
    	boolean[] can = new boolean[n];
    	can[0] = true;
    	
    	for(int i=1; i<n; i++){
    		for(int j=0; j<i; j++){
    			if(can[j] == true && A[j]>=(i-j)){
    				can[i] = true;
    				break;
    			}
    		}
    	}
    	
		return can[n-1];
    }
}
