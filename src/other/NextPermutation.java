package other;

import java.util.Arrays;

public class NextPermutation {

	public static void main(String[] args) {

		System.out.println(Arrays.toString(nextPermutation(new int[]{1,3,2})));
	}
	
    public static int[] nextPermutation(int[] nums) {
        // from right to left, find the first element smaller than its right
        int index = -1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                index = i;
                break;
            }
        }
        
        // if all descending, return ascending array (turn it over)
        if(index==-1){
            swap(nums,0,nums.length-1);
            return nums;
        }
        
        // swap the element with the smallest element larger than it
        int biggerIndex = index+1;
        for(int i=index+1; i<nums.length; i++){
            if(nums[index]<nums[i] && nums[i]<=nums[biggerIndex]){ //important: <=, for duplicates like 2,4,3,3,1
                biggerIndex = i;
            }
        }
        
        int temp = nums[biggerIndex];
        nums[biggerIndex] = nums[index];
        nums[index] = temp;
        
        // reorder the elements to the right of it in ascending order (just turn it over)
        swap(nums,index+1,nums.length-1);
        
        return nums;
    }
    
    private static void swap(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}
