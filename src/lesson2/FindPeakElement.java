package lesson2;
/**
 * find any
 * There is an integer array which has the following features:
 * The numbers in adjacent positions are different.
 * A[0] < A[1] && A[A.length - 2] > A[A.length - 1].
 * @author gjk
 *
 */
public class FindPeakElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int A[] = {1,2,4,5,6,7,8,6};
		System.out.println(findPeak(A));
	}
	public static int findPeak(int[] A) {

		if(A == null || A.length == 0){
			return -1;
		}
		
		//int start = 0;
		//int end = A.length - 1;
		int start = 1;
		int end = A.length - 2;
		
		while(start + 1 < end){
			
			int middle = start + (end-start)/2;
			
			if(A[middle] > A[middle-1] && A[middle] > A[middle+1]){
				return middle;
			}else if(A[middle] < A[middle-1] && A[middle] < A[middle+1]){
				end = middle;
			}else if(A[middle] > A[middle-1] && A[middle] < A[middle+1]){
				start = middle;
			}else{//A[middle] < A[middle-1] && A[middle] > A[middle+1]
				end = middle;
			}
		}
		
		
		if(A[start] > A[start-1] && A[start] > A[start+1]){
			return start;
		}else{
			return end;
		}
		
	}
}
