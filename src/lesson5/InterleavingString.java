package lesson5;

import java.util.Arrays;

public class InterleavingString {

	public static void main(String[] args) {

		System.out.println(isInterleave("aabcc", "dbbca","aadbbcbcac"));
		System.out.println(isInterleave("aabcc", "dbbca","aadbbbaccc"));
	}
	
    public static boolean isInterleave(String s1, String s2, String s3) {

    	int m = s1.length();
    	int n = s2.length();
    	
    	if(m+n!= s3.length()){return false;}
    	
    	boolean[][] result = new boolean[m+1][n+1];
    	
    	result[0][0] = true;
    	
    	for(int i=1; i<m+1; i++){
    		result[i][0] = result[i-1][0] && s1.charAt(i-1) == s3.charAt(i-1);
    	}

    	for(int i=1; i<n+1; i++){
    		result[0][i] = result[0][i-1] && s2.charAt(i-1) == s3.charAt(i-1);
    	}
    	
    	for(int i=1; i<m+1; i++){
    		for(int j=1; j<n+1; j++){
    			boolean b1 = result[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1);
    			boolean b2 = result[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1);
    			result[i][j] = b1 || b2;
    		}
    	}
    	for(int i=0; i<result.length; i++){
    		System.out.println(Arrays.toString(result[i]));
    	}
        return result[m][n];
    }
}
