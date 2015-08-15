package lesson2;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * Given target = 3, return true.
 * 
 * This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * 
 * O(log(n) + log(m)) time
 * 
 * @author gjk
 *
 */
public class SearchMatrix {

	public static void main(String[] args) {

		int matrix[][] = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20}};
		
		System.out.println(searchMatrix(matrix, 12));
		System.out.println(matrix[0].length);
	}

	public static boolean searchMatrix(int[][] matrix, int target) {
		
		if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0){
			return false;
		}

		// find row
		int start = 0;
		int end = matrix.length - 1;
		
		while(start + 1 < end){
			int middle = start + (end - start)/2;
			if(matrix[middle][0] == target){
				return true;
			}else if(matrix[middle][0] > target){
				end = middle;
			}else{//matrix[middle][0] < target
				start = middle;
			}
		}
		
		int targetRow = 0;
		
		if(target < matrix[start][0]){
			return false;
		}else if(target > matrix[end][0]){
			targetRow = end;
		}else{
			targetRow = start;
		}
		
		// find column
		start = 0;
		end = matrix[targetRow].length - 1;
		
		while(start + 1 < end){
			int middle = start + (end - start)/2;
			if(matrix[targetRow][middle] == target){
				return true;
			}else if(matrix[targetRow][middle] > target){
				end = middle;
			}else{//matrix[targetRow][middle] < target
				start = middle;
			}
		}
		
		if(matrix[targetRow][start] == target || matrix[targetRow][end] == target){
			return true;
		}else{
			return false;
		}
    }
}
