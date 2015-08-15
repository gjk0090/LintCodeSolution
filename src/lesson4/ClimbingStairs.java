package lesson4;

public class ClimbingStairs {

	public static void main(String[] args) {

		System.out.println(climbStairs(20));
		System.out.println(climbStairs2(20));
	}
	
    public static int climbStairs(int n) {
    	if(n<2){return 1;}
    	
    	int[] result = new int[n+1];
    	
    	result[0] = result[1] = 1;
    	 for(int i=2; i<n+1; i++){
    		 result[i] = result[i-1] + result[i-2];
    	 }
		return result[n];
    }
    
    public static int climbStairs2(int n) {
    	if(n<2){return 1;}

    	int now = 0;
    	int last = 1;
    	int lastlast = 1;
    	
   	 	for(int i=2; i<n+1; i++){
   	 		now = last + lastlast;
   	 		lastlast = last;
   	 		last = now;
   	 	}
   	 	return now;
    }
}
