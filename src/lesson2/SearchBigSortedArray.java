package lesson2;

public class SearchBigSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int searchBigSortedArray(int[] A, int target) {
        if(A.length == 0){return -1;}
        int end = 1;
        while(end<A.length && A[end]<target){
            end = end * 2;
        }
        if(end>=A.length){
            end = A.length-1;
        }
        
        int start = end/2;
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if(A[mid] >= target){
                end = mid;
            }else{
                start = mid;
            }
        }
        
        if(A[start]==target){
            return start;
        }else if(A[end]==target){
            return end;
        }else{
            return -1;
        }
    }
}
