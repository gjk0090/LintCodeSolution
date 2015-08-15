package lesson4;

public class JumpGame2 {

	public static void main(String[] args) {
		int[] A = {2,3,1,1,4};
		System.out.println(jump(A));

	}
    public static int jump(int[] A) {
    	if(A==null || A.length==0){return 0;}
    	
    	int n = A.length;
    	int[] step = new int[n];
    	//step[0] = 0;
    	
    	for(int i=1; i<n; i++){
    		int min = Integer.MAX_VALUE;
    		for(int j=0; j<i; j++){
    			if(A[j] >= (i-j)){
    				min = Math.min(min, step[j]);
    			}
    		}
    		step[i] = (min == Integer.MAX_VALUE)? -1:min+1;
    	}

		return step[n-1];
    }
}
