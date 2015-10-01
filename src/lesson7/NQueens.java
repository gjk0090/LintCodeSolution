package lesson7;

import java.util.*;

/**
 * N Queens problem is a problem of permutation of 0 to N-1 with a restriction (diagonal).
 * use a list to represent one solution:
 * solution 0-3-1-2 means
 * O X X X		0
 * X X X O		3
 * X O X X		1
 * X X O X		2
 * @author gjk
 *
 */
public class NQueens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<String>> a = solveNQueens(5);
		for (ArrayList<String> l : a) {
			System.out.println(l);
		}
	}
	
	
    public static ArrayList<ArrayList<String>> solveNQueens(int n) {
    	ArrayList<ArrayList<String>> answer = new ArrayList<>();
    	
    	ArrayList<Integer> solution = new ArrayList<>();
    	
    	boolean[] visited = new boolean[n];
    	
    	answer.addAll(re(n, solution, visited));
    	
		return answer;

    }
    
    private static ArrayList<ArrayList<String>> re(int n, ArrayList<Integer> solution, boolean[] visited){
    	ArrayList<ArrayList<String>> answer = new ArrayList<>();
    	
    	if(solution.size() == n){
    		System.out.println(solution);
    		answer.add(translate(solution));
    	}
    	
    	for(int i=0; i<n; i++){
    		if(!visited[i] && diagonalValid(solution, i)){ 
	    		solution.add(i);
	    		visited[i] = true;
	    		
	    		answer.addAll(re(n, solution, visited));
	    		
	    		solution.remove(solution.size()-1);
	    		visited[i] = false;
    		}
    	}
    	
		return answer;
    	
    }


	private static boolean diagonalValid(ArrayList<Integer> solution, int next) {
		for(int i=0; i<solution.size(); i++){
			if(solution.get(i) - i  == next - solution.size()){
				return false;
			}
			if(solution.get(i) + i  == next + solution.size()){
				return false;
			}
		}
		return true;
	}


	private static ArrayList<String> translate(ArrayList<Integer> solution) {
		ArrayList<String> translated = new ArrayList<String>();
		
		
		for(int i=0; i<solution.size(); i++){
			StringBuilder sb = new StringBuilder();
			for(int j=0; j<solution.get(i); j++){
				sb.append(".");
			}
			sb.append("Q");
			for(int j=solution.get(i)+1; j<solution.size(); j++){
				sb.append(".");
			}
			translated.add(sb.toString());
		}
		return translated;
	}
}
