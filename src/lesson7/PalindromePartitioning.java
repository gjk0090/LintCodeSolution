package lesson7;

import java.util.*;

import javax.net.ssl.SSLContext;
/**
 * HARD
 * 
 * this is a subset problem
 * n characters --> subset of 0 to n-2
 * a a b b
 *  0 1 2
 * @author gjk
 *
 */
public class PalindromePartitioning {

	public static void main(String[] args) {
		PalindromePartitioning p = new PalindromePartitioning();
		List<List<String>> result = p.partition("seeslaveidemonstrateyetartsnomedievalsees");
		for(List<String> l : result){
			System.out.println(l);
		}
		System.out.println(result.size());
	}
	
    public List<List<String>> partition(String s) {
    	int n = s.length()-1;
    	List<List<String>> result = new ArrayList<>();
    	List<Integer> solution = new ArrayList<>();
    	result.addAll(re(n, solution, 0, s));
		return result;
    }

	private List<List<String>> re(int n, List<Integer> solution, int startPos, String s) {
    	List<List<String>> result = new ArrayList<>();
    	
    	if(isValid(solution, s)){
    		result.add(transalte(solution, s));
    	}
    	
    	for(int i=startPos; i<n; i++){
    		if(solution.size()>0 && !isPal(s.substring(solution.get(solution.size()-1)+1, i+1))){continue;} //very important
    		solution.add(i);
    		result.addAll(re(n, solution, i+1, s));
    		solution.remove(solution.size()-1);
    	}
		return result;
	}

	private List<String> transalte(List<Integer> solution, String s) {
		List<String> translated = new ArrayList<>();
		if(solution.size()==0){
			translated.add(s);
			return translated;
		}
		translated.add(s.substring(0,solution.get(0)+1));
		for(int i=0; i<solution.size()-1; i++){
			translated.add(s.substring(solution.get(i)+1,solution.get(i+1)+1));
		}
		translated.add(s.substring(solution.get(solution.size()-1)+1, s.length()));
		//System.out.println(translated);
		return translated;
	}

	private boolean isValid(List<Integer> solution, String s) {
		
		//subString(0,3) = 0,1,2
		
		if(solution.size()==0){
			return isPal(s);
		}
		
		if(!isPal(s.substring(0,solution.get(0)+1))){
			return false;
		}
		
		
		for(int i=0; i<solution.size()-1; i++){
			if(!isPal(s.substring(solution.get(i)+1,solution.get(i+1)+1))){
				return false;
			}
		}
		
		if(!isPal(s.substring(solution.get(solution.size()-1)+1, s.length()))){
			return false;
		}
		
		return true;
	}

	private boolean isPal(String s) {
		for(int i=0; i<s.length()/2; i++){
			if(s.charAt(i) != s.charAt(s.length()-1-i)){
				return false;
			}
		}
		return true;
	}

}
