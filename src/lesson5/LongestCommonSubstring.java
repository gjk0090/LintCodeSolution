package lesson5;

public class LongestCommonSubstring {

	public static void main(String[] args) {

		System.out.println(longestCommonSubstring("ABCD","CBCE"));
	}
	
    public static int longestCommonSubstring(String A, String B) {
    	if(A==null || B==null || A.length()==0 || B.length()==0){return 0;}

    	
    	int m = A.length();
    	int n = B.length();
    	int[][] res = new int[m][n];
    	
    	int max =0;
    	
    	for(int i=0; i<m; i++){
    		for(int j=0; j<n; j++){
    			if(A.charAt(i) == B.charAt(j)){
    				res[i][j] = (i==0 || j==0)? 1 : res[i-1][j-1] + 1;
    				max = Math.max(max, res[i][j]);
    			}else{
    				res[i][j] = 0;
    			}
    		}
    	}
		return max;

    }

}
