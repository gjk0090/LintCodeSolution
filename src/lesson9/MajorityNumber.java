package lesson9;

import java.util.*;

public class MajorityNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int majorityNumber(ArrayList<Integer> nums) {
        int result = -1, count = 0; 
        for(int i : nums){
            if(count == 0){
                result = i;
                count++;
                continue;
            }
            if(i == result){
                count++;
            }else{
                count--;
            }
        }
        return result;
    }
}
