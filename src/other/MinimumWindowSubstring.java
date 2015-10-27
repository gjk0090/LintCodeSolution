package other;

import java.util.*;

public class MinimumWindowSubstring {

	public static void main(String[] args) {

		System.out.println(minWindow("abcd", "ac"));
	}
    public static String minWindow(String source, String target) {

    	//a list to store all chars
        List<Character> targetList = new ArrayList<Character>();
        for(char c : target.toCharArray()){
            targetList.add(c);
        }
        
        String min = source+source; // for validating changed or not
        
        for(int i=0;i<source.length();i++){
        	
            char c = source.charAt(i);
            int index = target.indexOf(c);
            if(index==-1){continue;} //validating contains
            List<Character> copyList = new ArrayList<Character>(targetList);
            copyList.remove(new Character(c));
            if(copyList.size()==0){return source.substring(i,i+1);}
            
            for(int j=i+1;j<source.length();j++){
                char c2 = source.charAt(j);
                int index2 = target.indexOf(c2);
                if(index2==-1){continue;}
                copyList.remove(new Character(c2));
                if(copyList.size()==0  && min.length()>(j-i+1)){
                	min = source.substring(i,j+1);
                }
            }
        }
        
        if(min.length()>source.length()){min="";}
        
        return min;

    }

}
