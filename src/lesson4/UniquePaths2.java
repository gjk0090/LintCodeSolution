package lesson4;

public class UniquePaths2 {

	public static void main(String[] args) {
		int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
		System.out.println(uniquePathsWithObstacles(obstacleGrid));
	}
	
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	
    	int m = obstacleGrid.length;
    	int n = obstacleGrid[0].length;
    	
    	int[][] grid = new int[m][n];
    	
    	//initialize
    	for(int i=0; i<m; i++){
    		if(obstacleGrid[i][0] == 1){break;}
    		grid[i][0] = 1;
    	}
    	for(int i=0; i<n; i++){
    		if(obstacleGrid[0][i] == 1){break;}
    		grid[0][i] = 1;
    	}
    	
    	
    	
    	for(int i=1; i<m; i++){
    		for(int j=1; j<n; j++){
    			if(obstacleGrid[i][j] == 1){
    				grid[i][j]  = 0;
    			}else{
    				grid[i][j] = grid[i-1][j] + grid[i][j-1];
    			}
    		}
    	}
    	
		return grid[m-1][n-1];

	}

}
