package lesson2;
/**
 * For a given sorted array (ascending order) and a target number, find the FIRST index of this number in O(log n) time complexity.
 * If the target number does not exist in the array, return -1.
 * @author gjk
 *
 */

/**
 * key to binary search!!!
 * 1. start + 1 < end; 
 * 2. start/end = middle, no + - 1
 * 3. A[start] A[end] ? target
 * 4. start + (end - start) / 2 
 */
public class BinarySearchFirstOccur {

	public static void main(String[] args) {
		int a[] = {1,2,3,4,5,6,7,8,9,10};
		int b[] = {};
		int c[] = null;
		System.out.println( binarySearch(a,5) );
		System.out.println( binarySearch(b,5) );
		System.out.println( binarySearch(c,5) );
	}
	
	public static int binarySearch(int[] nums, int target) {
		
		if(nums == null || nums.length == 0){
			return -1;
		}
		
		int start = 0;
		int end = nums.length;
		
		while(start + 1 < end){
			
			int middle = start + (end-start)/2;
			
			if(nums[middle] == target){
				end = middle;
			}else if(nums[middle] > target){
				end = middle;
			}else{
				start = middle;
			}
		}
		
		if(nums[start] == target){
			return start;
		}else if(nums[end] == target){
			return end;
		}else{
			return -1;
		}
	}

}
