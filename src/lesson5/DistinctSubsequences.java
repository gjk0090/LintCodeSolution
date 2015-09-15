package lesson5;

public class DistinctSubsequences {

	public static void main(String[] args) {
		System.out.println(numDistinct("rabbbit","rabbit"));
	}

    public static int numDistinct(String S, String T) {
    	
    	if(S==null || T==null || S.length()<T.length()){return 0;}
    	
    	int m = S.length();
    	int n = T.length();
    	
    	int[][] result = new int[m+1][n+1];
    	
    	for(int i=0; i<m+1; i++){
    		result[i][0] = 1;
    	}
    	
    	for(int i=1; i<m+1; i++){
    		for(int j=1; j<n+1; j++){
    			if(S.charAt(i-1) == T.charAt(j-1)){
    				result[i][j] = result[i-1][j-1] + result[i-1][j];
    			}else{
    				result[i][j] = result[i-1][j];    				
    			}
    		}
    	}
		return result[m][n];

    }
}

//	/	0	r	a	b	i	t
//	0	1	0	0	0	0	0
//	r	1	1	0	0	0	0
//	a	1	1	1	0	0	0
//	b	1	1	1	1	0	0
//	b	1	1	1	2	0	0
//	b	1	1	1	3	0	0
//	i	1	1	1	3	3	0
//	t	1	1	1	3	3	3

