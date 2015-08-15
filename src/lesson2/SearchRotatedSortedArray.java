package lesson2;

public class SearchRotatedSortedArray {

	public static void main(String[] args) {
		int a[] = {4,5,6,7,8,9,10,1,2,3};

		System.out.println( search(a,10) );
	}

	public static int search(int[] A, int target) {
		
		if(A == null || A.length==0){
			return -1;
		}
		
		int start = 0;
		int end = A.length - 1;
		
		while(start + 1 < end){
			int middle = start + (end - start)/2;
			
			if(A[middle] < target){
				if(A[middle] < A[start]&& target > A[start]){
					end = middle;
				}else{
					start = middle;
				}
			}else if(A[middle] > target){
				if(A[middle] > A[start] && target < A[start]){
					start = middle;
				}else{
					end = middle;
				}
			}else{
				return middle;
			}
		}
		
		if(A[start] == target){
			return start;
		}else if(A[end] == target){
			return end;
		}else{
			return -1;
		}
		
    }
	
}
