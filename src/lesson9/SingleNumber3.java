package lesson9;

import java.util.Arrays;
import java.util.List;

public class SingleNumber3 {

	public static void main(String[] args) {
		System.out.println(singleNumberIII(new int[]{1,1,2,2,3,3,4,4,5,5,126,7}));

	}

	private static List<Integer> singleNumberIII(int[] A) {
		
		int xor = 0;
		for(int i : A){
			xor = xor^i;
		}
		System.out.println(xor);
		
		int lastBit = xor - (xor & (xor - 1)); //??????????????????????
		System.out.println(lastBit);
		
		int group1=0,group2=0;
		for(int i : A){
			if((lastBit&i) == 0){ //????????????????????
				group1 = group1^i;
			}else{
				group2 = group2^i;
			}
		}

		return Arrays.asList(new Integer[]{group1,group2});
	}

}
