package lesson4;

import java.util.*;

public class WordBreak {

	public static void main(String[] args) {
		Set<String> dict = new HashSet<String>();
		dict.add("lint");
		dict.add("code");
		dict.add("a");
		dict.add("dog");
		dict.add("java");
		dict.add("eclipse");
		dict.add("word");
		dict.add("break");
		dict.add("bilibili");
		
		System.out.println(wordBreak("bilibilibreakadog",dict));
		System.out.println(wordBreak("bilibilibreakacat",dict));
	}
	
    public static boolean wordBreak(String s, Set<String> dict) {
    	
    	if(s==null||dict==null){return false;}
    	if(s.length()==0){return true;}
    	
    	int n = s.length();
    	boolean[] can = new boolean[n];
    	
    	int maxLength = 0;
    	for(String word : dict){
    		maxLength = Math.max(maxLength, word.length());
    	}
    	
    	for(int i=0; i<n; i++){
    		int j = (i>maxLength)? i-maxLength : 0;
    		for(j=j; j<=i; j++){
    			if( (j==0 || can[j-1]) && dict.contains(s.substring(j, i+1))){
    				can[i] = true;
    				break;
    			}
    		}
    	}
		return can[n-1];
    }

}
