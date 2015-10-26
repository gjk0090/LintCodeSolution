package lesson5;

import java.util.*;
import java.util.Arrays;

public class MinimumAdjustmentCost {

	public static void main(String[] args) {

		System.out.println(MinAdjustmentCost(Arrays.asList(1,4,2,3),1));
	}
	
	
	
    public static int MinAdjustmentCost(List<Integer> A, int target) {
    	
        int[][] cost = new int[A.size()][101]; // j from 1 to 100
        
        //init
        for(int i=0; i<A.size(); i++){
            for(int j=1; j<=100; j++){
                cost[i][j]=Integer.MAX_VALUE;
            }
        }
        
        //init i=0
        for(int j=1;j<=100;j++){
            cost[0][j] = Math.abs(j-A.get(0));
        }
        
        for(int i=1; i<A.size(); i++){ //traverse A[i]
            for(int j=1; j<=100; j++){ //traverse 1 to 100
            	
            	//calculate range for j-target to j+target
            	int start=(j-target)<1? 1:j-target;
            	int end=(j+target)>100? 100:j+target;
                for(int k=start; k<=end; k++){
                    cost[i][j] = Math.min(cost[i][j],cost[i-1][k]);
                }
                
                cost[i][j] += Math.abs(A.get(i)-j);
            }

        }
        
        //get min when i=last
        int min=Integer.MAX_VALUE;
        for(int j=1;j<=100;j++){
            min = Math.min(min,cost[A.size()-1][j]);
        }
        

        return min;
    }

}
