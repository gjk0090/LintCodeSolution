package lesson9;

import java.util.*;

public class TwoSum {

	public static void main(String[] args) {

		System.out.println(Arrays.toString(twoSum(new int[]{1,0,-1},-1)));
	}
	
	
    public static int[] twoSum(int[] numbers, int target) {

        Arrays.sort(numbers);
        
        for(int i=0;i<numbers.length;i++){
            int index = find(numbers,target-numbers[i]);
            if(index!=-1 && index!=i){
                return new int[]{Math.min(i,index) + 1, Math.max(i,index) + 1};
            }
        }
        
        return null;

    }
    
     private static int find(int[] numbers, int target) {
            
            int start=0, end=numbers.length;
            while(start + 1 < end){
                int middle = start + (end-start)/2;
                if(target == numbers[middle]){
                    return middle;
                }else if(target > numbers[middle]){
                    start  = middle;
                }else{
                    end = middle;
                }
            }
            
            if(numbers[start] == target){
                return start;
            }
            
            if(numbers[end] == target){
                return end;
            }
            
            return -1;
        }
}
