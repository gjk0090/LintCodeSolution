package other;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] A = new int[]{333,2,1,4,2,45,6,7,78,8,3,2,5,6,7,7,3,4,5};
		sort(A,0,A.length-1);
		System.out.println(Arrays.toString(A));
	}

	private static void sort(int[] A, int start, int end) {

		if (start == end) {
			return;
		}

		int middle = A[start];

		int pointer1 = start, pointer2 = end;

		while (pointer1 < pointer2) {
			while (A[pointer1] < middle && pointer1 < pointer2) {
				pointer1++;
			}
			while (A[pointer2] >= middle && pointer1 < pointer2) { //imprtant : >=
				pointer2--;
			}
			int temp = A[pointer1];
			A[pointer1] = A[pointer2];
			A[pointer2] = temp;
		}
		
		//System.out.println(Arrays.toString(A)+" "+start+" "+end+" "+pointer1+" "+pointer2+"; "+middle+" "+A[pointer1]);

		//important!!!
		if(pointer1 == start){
			sort(A,pointer1+1,end);
		}else{
			sort(A, start, pointer1 - 1);
			sort(A, pointer1, end);
		}
	}
}
