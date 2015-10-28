package other;

import java.util.Arrays;

public class BackPack2 {
	
	
	public static void main(String[] args) {
		System.out.println(backPackII(10, new int[]{2,3,5,7}, new int[]{1, 5, 2, 4}));
	}

	public static int backPackII(int m, int[] A, int V[]) {
		
		int[][] result= new int[A.length+1][m+1];
		
		//init all 0
		
		for(int i=1; i<=A.length; i++){
			for(int j=1; j<=m; j++){
				if(j>=A[i-1]){ // put this item in or not?
					result[i][j] = Math.max(result[i-1][j-A[i-1]] + V[i-1], result[i-1][j]);
				}else{ // cant put this item in
					result[i][j] = result[i-1][j];
				}
			}
		}
		
		for(int[] a : result){
			System.out.println(Arrays.toString(a));
		}

		return result[A.length][m];
    }
}
