package lesson9;

import java.util.Arrays;

public class SortColor {

	public static void main(String[] args) {

		int[] a = new int[]{2,0,0,1,2,0,2};
		int[] b = new int[]{2,0,2,2,1,2,2,1,2,0,0,0,1};
		sortColors(a);
		sortColors(b);
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
	}
    
    public static void sortColors(int[] nums) {
        
        int start=0,end=nums.length-1;
        for(int i=0; i<nums.length; i++){
            while(nums[i]==2 && i<end){
                nums[i]=nums[end];
                nums[end]=2;
                end--;
            }
            while(nums[i]==0 && start<i){
                nums[i]=nums[start];
                nums[start]=0;
                start++;
            }
        }
    }
}
