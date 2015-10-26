package lesson5;

import java.util.Arrays;

public class EditDistance {

	public static void main(String[] args) {
		System.out.println(minDistance("mart","karma"));
		System.out.println(minDistance("sea", "ate"));
		System.out.println(minDistance("dinitrophenylhydrazine", "acetylphenylhydrazine"));
	}
	
    public static int minDistance(String word1, String word2) {
    	
    	if(word1==null || word2==null){return -1;}
    	if(word1.length()==0){return word2.length();}
    	if(word2.length()==0){return word1.length();}
    	
    	int[][] result = new int[word1.length()+1][word2.length()+1]; //important!!
    	
    	//init
    	for(int i=0; i<word1.length()+1; i++){
    		result[i][0] = i;
    	}
    	
    	for(int j=0; j<word2.length()+1; j++){
    		result[0][j] = j;
    	}    	
    	
    	for(int i=1; i<word1.length()+1; i++){
    		for(int j=1; j<word2.length()+1; j++){
    			if(word1.charAt(i-1) == word2.charAt(j-1)){
    				result[i][j] = result[i-1][j-1]; //important!!!
    			}else{
    				int temp = Math.min(result[i-1][j], result[i][j-1]);
    				result[i][j] = Math.min(result[i-1][j-1], temp) + 1;
    			}
    		}
    	}
    	
    	for(int i=0; i<result.length; i++){
    		System.out.println(Arrays.toString(result[i]));
    	}
		return result[word1.length()][word2.length()];
    }
}
