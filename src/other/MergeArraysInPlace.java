package other;

import java.util.Arrays;

public class MergeArraysInPlace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array1 = new int[15];
		array1[0]=3;
		array1[1]=5;
		array1[2]=7;
		array1[3]=9;
		array1[4]=11;
		int[] array2 = new int[]{1,2,4,6,8,10,12,14,16,18};
		merge(array1,array2);
		System.out.println(Arrays.toString(array1));
	}

	private static void merge(int[] array1, int[] array2) {
		int index1 = array1.length-array2.length-1;
		int index2 = array2.length-1;
		
		while(index1>=0 && index2>=0){
			if(array1[index1] > array2[index2]){
				array1[index1+index2+1] = array1[index1];
				index1--;
			}else{
				array1[index1+index2+1] = array2[index2];
				index2--;
			}
		}
		
		if(index2>0){
			while(index2 >= 0){
				array1[index2] = array2[index2];
				index2--;
			}
		}

	}

}
