package other;

public class NumberOfIslands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int numIslands(boolean[][] grid) {
        // Write your code here
        int n = grid.length;
        if (n == 0) {
            return 0;
        }
        
        int m = grid[0].length;
        if (m == 0) {
            return 0;
        }
        
        int count = 0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]){
                    remove(grid,i,j);
                    count++;
                }
            }
        }
        return count;
        
    }
    
    private void remove(boolean[][] grid, int i, int j){
        if(grid[i][j]){
            grid[i][j] = false;
        }else{
            return; //important
        }
        if(i>0){
            remove(grid,i-1,j);
        }
        if(j>0){
            remove(grid,i,j-1);
        }
        if(i<grid.length-1){
            remove(grid,i+1,j);
        }
        if(j<grid[0].length-1){
            remove(grid,i,j+1);
        }
    }
}
