package lesson5;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		System.out.println(longestCommonSubsequence2("ABCD","EDCA"));
		System.out.println(longestCommonSubsequence2("ABCD","EACB"));
		System.out.println(longestCommonSubsequence2("AC","AC"));
		System.out.println(longestCommonSubsequence2("daabeddbcedeabcbcbec", "daceeaeeaabbabbacedd"));

	}
    public static int longestCommonSubsequence(String A, String B) {
    	if(A==null || B==null || A.length()==0 || B.length()==0){return 0;}
    	int m = A.length();
    	int n = B.length();
    	int[][] res = new int[m][n];
    	
    	for(int i=0; i<m; i++){
    		for(int j=0; j<n; j++){
    			if(A.charAt(i)==B.charAt(j)){
    				res[i][j] = (i==0 || j==0)? 1 : res[i-1][j-1]+1;
    			}else{
    				res[i][j] = Math.max((i==0)? 0 : res[i-1][j], (j==0)? 0 : res[i][j-1]);
    			}
    		}
    	}
    	
		return res[m-1][n-1];
    }
    
    
    
    
    //recursive with memorize
    
    static int[][] record;
    
    public static int longestCommonSubsequence2(String A, String B) {
    	if(A==null || B==null || A.length()==0 || B.length()==0){return 0;}
    	
    	record = new int[A.length()][B.length()];
    	for(int i=0; i<record.length; i++){
    		for(int j=0;j<record[0].length; j++){
    			record[i][j] = -1;
    		}
    	}
    	
		return re(A,B,A.length()-1,B.length()-1);
    }
    
    private static int re(String A, String B, int i, int j){
    	if(i==-1||j==-1){return 0;}
    	
    	if(record[i][j] != -1){return record[i][j];}
    	
    	if(A.charAt(i)==B.charAt(j)){
    		record[i][j] = re(A,B,i-1,j-1)+1;
		}else{
			record[i][j] = Math.max(re(A,B,i-1,j), re(A,B,i,j-1));
		}
    	
    	return record[i][j];
    }
    
}
