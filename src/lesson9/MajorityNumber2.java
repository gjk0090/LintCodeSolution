package lesson9;

import java.util.*;
import java.util.Arrays;

public class MajorityNumber2 {

	public static void main(String[] args) {

		System.out.println(majorityNumber(Arrays.asList(new Integer[]{1,1,1,1,2,2,3,3,4,4,4})));
	}

    public static int majorityNumber(List<Integer> nums) {

        int candidate1=-1,candidate2=-1,count1=0,count2=0;
        
        for(int i : nums){
            if(count1==0){
                candidate1=i;
                count1++;
                continue;
            }else if(count2==0 && candidate1!=i){ // important
                candidate2=i;
                count2++;
                continue;
            }
            
            if(candidate1==i){
                count1++;
            }else if(candidate2==i){
                count2++;
            }else{
                count1--;
                count2--;
            }
        }
        
        count1=count2=0;
        for(int i : nums){
            if(candidate1==i){
                count1++;
            }else if(candidate2==i){
                count2++;
            }
        }
        
        return count1>count2? candidate1: candidate2;
    }
}
