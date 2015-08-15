package lesson4;

public class PalindromePartitioning2 {

	public static void main(String[] args) {
		System.out.println(minCut("aabaa"));
		//System.out.println("abcdefg".substring(0, 3));
	}
	
    public static int minCut(String s) {
    	if(s==null||s.length()==0){return 0;}
    	
    	int n = s.length();
    	int[] cut = new int[n];
    	cut[0] = 0;
    	
    	for(int i=1; i<n; i++){
    		
    		cut[i] = Integer.MAX_VALUE;
    		
    		for(int j=0; j<=i; j++){
    			if(isPal(s.substring(j, i+1))){
    				if(j==0){
    					cut[i] = 0;
    					break;
    				}else{
    					cut[i] = Math.min(cut[i], cut[j-1]+1);
    				}
    			}    			
    		}
    	}
		return cut[n-1];
    }

	private static boolean isPal(String s) {
        for (int i = 0, j = s.length()-1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
	}

}
