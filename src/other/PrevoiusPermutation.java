package other;

import java.util.ArrayList;

public class PrevoiusPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public ArrayList<Integer> previousPermuation(ArrayList<Integer> nums) {
		// from right to left find THE fist element which is larger than its right
		int index = -1;
		for(int i=nums.size()-2; i>=0; i--){
		    if(nums.get(i)>nums.get(i+1)){
		        index = i;
		        break;
		    }
		}
		
		// if all ascending, rotate all
		if(index == -1){
		    rotate(nums,0,nums.size()-1);
		    return nums;
		}
		
		// find the largest element smaller than THE element (the last one), swap them
		int smallIndex = index + 1;
		for(int i=index+1; i<nums.size(); i++){
		    if(nums.get(index) > nums.get(i) && nums.get(i) >= nums.get(smallIndex)){
		        smallIndex = i;
		    }
		}
		
		int temp = nums.get(smallIndex);
		nums.set(smallIndex,nums.get(index));
		nums.set(index,temp);
		
		// rotate elements to the right of THE element
		rotate(nums,index+1,nums.size()-1);
		
		return nums;
    }
    
    private void rotate(ArrayList<Integer> nums, int start, int end){
        while(start<end){
            int temp = nums.get(start);
		    nums.set(start,nums.get(end));
		    nums.set(end,temp);
		    start++;
		    end--;
        }
    }

}
