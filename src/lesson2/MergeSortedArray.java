package lesson2;

import util.PrintUtil;

public class MergeSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,3,5,7,9,0,0,0,0};
		int[] B = {2,4,6,8};
		mergeSortedArray(A,5,B,4);
		PrintUtil.printArray(A);
	}
	
    public static void mergeSortedArray(int[] A, int m, int[] B, int n) {
    	
    	if(A == null || m == 0){
    		A = B;
    		return;
    	}

    	if(B == null || n == 0){
    		return;
    	}
    	
    	while(m>0 || n>0){
    		if(m==0){
    			A[m+n-1] = B[n-1];
    			n--;
    			continue;
    		}
    		
    		if(n==0){
    			A[m+n-1] = A[m-1];
    			m--;
    			continue;
    		}
    		
    		if(A[m-1] > B[n-1]){
    			A[m+n-1] = A[m-1];
    			m--;
    		}else{
    			A[m+n-1] = B[n-1];
    			n--;
    		}    		
    	}
    }

}
