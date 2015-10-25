package lesson7;

import java.util.*;

public class WordLadder {

	public static void main(String[] args) {

		Set<String> set = new HashSet<>(Arrays.asList(new String[]{"hot","dot","dog","lot","log"}));
		System.out.println(ladderLength("hit", "cog", set ));
	}
	
    public static int ladderLength(String start, String end, Set<String> dict) {
    	
    	Set<String> used = new HashSet<String>();
    	Queue<String> bfs = new LinkedList<String>();
    	
    	
    	dict.add(end); //important
    	bfs.offer(start);
    	
    	int length = 1;
    	
    	while(!bfs.isEmpty()){
    		length++;
    		int size = bfs.size();
    		for(int i=0;i<size;i++){ //important
    			
    			String currentWord = bfs.poll();
    			
    			for(String s : findNextWord(currentWord,dict,used)){
    				if(s.equals(end)){
    					return length;
    				}
    				bfs.offer(s);
    				used.add(s);
    			}
    		}
    	}
    	
		return 0;

    }

	private static Set<String> findNextWord(String currentWord, Set<String> dict, Set<String> used) {

		
		Set<String> nextWords = new HashSet<String>();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < currentWord.length(); i++) {
                if (c == currentWord.charAt(i)) {
                    continue;
                }
                String nextWord = replace(currentWord, i, c);
                if (dict.contains(nextWord)) {
                    nextWords.add(nextWord);
                }
            }
        }
        nextWords.removeAll(used); //important
        return 	nextWords;
    }
	
    private static String replace(String s, int index, char c) {
        char[] chars = s.toCharArray();
        chars[index] = c;
        return new String(chars);
    }
}
