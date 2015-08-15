package lesson2;

import java.util.ArrayList;
import java.util.Arrays;

public class RecoverRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> nums = new ArrayList<Integer>(Arrays.asList(new Integer[] {4, 5, 1, 2, 3}));
		recoverRotatedSortedArray(nums);
    	System.out.println(nums);

	}
	

    //3 step inverse method
    private static void reverse(ArrayList<Integer> nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int temp = nums.get(i);
            nums.set(i, nums.get(j));
            nums.set(j, temp);
        }
    }

    public static void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        for (int index = 0; index < nums.size() - 1; index++) {
            if (nums.get(index) > nums.get(index + 1)) {
                reverse(nums, 0, index);
                reverse(nums, index + 1, nums.size() - 1);
                reverse(nums, 0, nums.size() - 1);
                return;
            }
        }
    }

    
    
    
    public static void recoverRotatedSortedArray2(ArrayList<Integer> nums) {
        if(nums == null || nums.size() == 0){
        	return;
        }
        
        for(int i=0; i<nums.size(); i++ ){
        	if(nums.get(0) >= nums.get(nums.size()-1)){
        		Integer num = nums.remove(0);
        		nums.add(num);
        	}else{
        		return;
        	}
        }

    }
}
