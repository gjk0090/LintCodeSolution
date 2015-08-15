package lesson2;
/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * You may assume NO duplicates in the array.
 * Example
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 * Challenge
 * O(log(n)) time
 * @author gjk
 *
 */
public class SearchInsertPosition {

	public static void main(String[] args) {

		int a[] = {1,2,3,4,5,6,7,8,9,10};
		int b[] = {1,2,3,4,6,7,8,9,10};
		int c[] = {};
		int d[] = null;
		System.out.println( searchInsert(a,5) );
		System.out.println( searchInsert(b,5) );
		System.out.println( searchInsert(c,5) );
		System.out.println( searchInsert(d,5) );
	}
	
    public static int searchInsert(int[] A, int target) {
		if(A == null || A.length == 0){
			return 0;
		}
		
		int start = 0;
		int end = A.length-1;
		
		while(start + 1 < end){
			int middle = start + (end-start)/2;
			
			if(A[middle] == target){
				//end = middle;
				return middle; // no duplicate
			}else if(A[middle] > target){
				end = middle;
			}else{
				start = middle;
			}
		}
		
		if(target > A[end]){
			return end + 1;
		}else if(target <= A[start]){
			return start;
		}else{ //A[start] < target <= A[end]
			return end;
		}
	
    }

}
