package lesson2;

import java.util.Arrays;



public class RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {
		int[] a={1,1,2,2,3,4,4,5,6};
		System.out.println(removeDuplicates(a));
		System.out.println(Arrays.toString(a));
	}
    public static int removeDuplicates(int[] nums) {
    	if(nums==null){return 0;}
    	int size = 0;
    	for(int i=0; i<nums.length; i++){
    		if(i>0 && nums[i] == nums[i-1]){
    			continue;
    		}
    		nums[size] = nums[i];
    		size++;
    	}
		return size;
    }

}
