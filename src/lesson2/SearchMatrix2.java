package lesson2;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix, return the number of occurrence of it.
 * This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * Integers in each column are sorted from up to bottom.
 * No duplicate integers in each row or column.
 * 
 *   [1, 3, 5, 7],
 *   [2, 4, 7, 8],
 *   [3, 5, 9, 10]
 *   Given target = 3, return 2.
 *   
 * O(m+n) time and O(1) extra space
 *   
 * @author gjk
 *
 */

public class SearchMatrix2 {

	public static void main(String[] args) {
		int matrix[][] = {{1,3,5,7},{2,4,7,8},{3,5,9,10}};
		System.out.println(searchMatrix(matrix, 7));
	}

	public static int searchMatrix(int[][] matrix, int target) {

		if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0){
			return 0;
		}
		
		int count = 0;
		int row = matrix.length-1;
		int column = 0;
		
		while(row >= 0 && column < matrix[0].length){
			if(matrix[row][column] > target){
				row--;
			}else if(matrix[row][column] < target){
				column++;
			}else{//matrix[row][column] == target)
				count ++;
				row--;
				column++;
			}
		}
		
		return count;
	}
}
