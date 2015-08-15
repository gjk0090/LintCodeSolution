package lesson2;

import util.PrintUtil;
/**
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * @author gjk
 *
 */
public class RemoveDuplicatesFromSortedArray2 {

	public static void main(String[] args) {
		int[] a={1,1,1,2,2,3};
		System.out.println(removeDuplicates(a));
		PrintUtil.printArray(a);
	}
    public static int removeDuplicates(int[] nums) {
    	if(nums==null){return 0;}
    	
    	int[] temp = new int[nums.length];
    	int size = 0;
    	
    	for(int i=0; i<nums.length; i++){
    		if(i>1 && nums[i]==nums[i-1] && nums[i]==nums[i-2]){
    			continue;
    		}
    		temp[size] = nums[i];
    		size++;
    	}
    	
    	for(int i=0; i<size; i++){
    		nums[i]=temp[i];
    	}
		return size;
    }
    
    
    //http://www.jiuzhang.com/solutions/remove-duplicates-from-sorted-array-ii/
    public static int removeDuplicates2(int[] nums) {
        // write your code here
        if(nums == null)
            return 0;
        int cur = 0;
        int i ,j;
        for(i = 0; i < nums.length;){
            int now = nums[i];
            for( j = i; j < nums.length; j++){
                if(nums[j] != now)
                    break;
                if(j-i < 2)
                    nums[cur++] = now; 
            }
            i = j;
        }
        return cur;
    }
}
