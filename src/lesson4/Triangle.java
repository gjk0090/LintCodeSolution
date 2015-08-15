package lesson4;

import java.util.*;

import util.CollectionBuilder;

public class Triangle {

	public static void main(String[] args) {

		ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
		triangle.add(CollectionBuilder.buildArrayList(new int[]{1}));
		triangle.add(CollectionBuilder.buildArrayList(new int[]{2,3}));
		triangle.add(CollectionBuilder.buildArrayList(new int[]{4,5,6}));
		triangle.add(CollectionBuilder.buildArrayList(new int[]{7,8,9,10}));
		System.out.println(minimumTotal3(triangle));
	}

	//non recursive, bottom up
    public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
    	
    	if (triangle == null || triangle.size() == 0) {return 0;}

    	int n = triangle.size();
    	
    	int[][] minSum = new int[n][n];
    	
    	for(int i=0; i<n; i++){
    		minSum[n-1][i] = triangle.get(n-1).get(i);
    	}
    	
    	for(int i=n-2; i>=0; i--){
    		for(int j=0; j<=i; j++){
    			minSum[i][j] = Math.min(minSum[i+1][j], minSum[i+1][j+1]) + triangle.get(i).get(j);
    		}
    	}
    	
		return minSum[0][0];

    }
    
    //non recursive, top down
    public static int minimumTotal2(ArrayList<ArrayList<Integer>> triangle) {
    	
    	 if (triangle == null || triangle.size() == 0) {return 0;}
    	 
    	int n = triangle.size();
    	int[][] minSum = new int[n][n];
    	
    	minSum[0][0] = triangle.get(0).get(0);
    	
    	for(int i=1; i<n; i++){
    		for(int j=0; j<=i; j++){
    			if(j==0){
    				minSum[i][j] = minSum[i-1][j] + triangle.get(i).get(j);
    			}else if(j==i){
    				minSum[i][j] = minSum[i-1][j-1] + triangle.get(i).get(j);
    			}else{
    				minSum[i][j] = Math.min(minSum[i-1][j-1],minSum[i-1][j]) + triangle.get(i).get(j);
    			}
    		}
    	}
    	
    	int min = Integer.MAX_VALUE;
    	for(int i=0; i<n; i++){
    		if(min > minSum[n-1][i]){
    			min = minSum[n-1][i];
    		}
    	}
		return min;
    }
    
    //recursive
    static int[][] memorize;
    public static int minimumTotal3(ArrayList<ArrayList<Integer>> triangle) {
   	 
    	if (triangle == null || triangle.size() == 0) {return 0;}
    	
    	int n = triangle.size();
    	memorize = new int[n][n];
    	for(int i=0; i<n; i++){
    		for(int j=0; j<n; j++){
    			memorize[i][j] = -1;
    		}
    	}
    	
		return re(triangle, 0, 0);
    }
    
    private static int re(ArrayList<ArrayList<Integer>> triangle, int i, int j){
    	if(memorize[i][j] != -1){
    		return memorize[i][j];
    	}
    	if(i == triangle.size()-1){
    		return triangle.get(i).get(j);
    	}
    	return memorize[i][j] = Math.min(re(triangle, i+1, j), re(triangle, i+1, j+1)) + triangle.get(i).get(j);
    }
}
