package lesson7;

import java.util.*;

public class NQueens2 {

	public static void main(String[] args) {
		System.out.println(totalNQueens(5));
	}
    public static int totalNQueens(int n) {
    	int result = 0;
    	List<Integer> solution = new ArrayList<>();
    	boolean[] visited = new boolean[n];
    	result += re(n, solution, visited);
		return result;
    }
	private static int re(int n, List<Integer> solution, boolean[] visited) {
		int result = 0;
		
		if(solution.size() == n){
			result++;
		}
		
		for(int i=0; i<n; i++){
			if(!visited[i] && isValid(solution, i)){
				solution.add(i);
				visited[i] = true;
				result += re(n, solution, visited);
				solution.remove(solution.size()-1);
				visited[i] = false;
			}
		}
		
		return result;
	}
	private static boolean isValid(List<Integer> solution, int col) {

		for(int i=0; i<solution.size(); i++){
			if(i - solution.get(i) == solution.size() - col){
				return false;
			}
			
			if(i + solution.get(i) == solution.size() + col){
				return false;
			}
		}
		return true;
	}

}
