package lesson4;

public class MinPathSum {

	public static void main(String[] args) {
		
		int[][] grid = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20}};
		int[][] grid2 = {{1,2},{1,1}};
		System.out.println(minPathSum(grid));
		System.out.println(minPathSum(grid2));
	}
    public static int minPathSum(int[][] grid) {
        if(grid==null || grid.length==0){return 0;}

    	int m=grid.length;
    	int n=grid[0].length;
    	
    	for(int i=1;i<m;i++){
    		grid[i][0] += grid[i-1][0];
    	}
    	
    	for(int i=1;i<n;i++){
    		grid[0][i] += grid[0][i-1];
    	}
    	
    	for(int i=1; i<m; i++){
    		for(int j=1; j<n; j++){
    			grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
    		}
    	}
		return grid[m-1][n-1];
    }
}
