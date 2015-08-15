package lesson4;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {

		int[] a = {5, 4, 1, 2, 3};
		int[] b = {4, 2, 4, 5, 3, 7};
		int[] c = {88,4,24,82,86,1,56,74,71,9,8,18,26,53,77,87,60,27,69,17,76,23,67,14,98,13,10,83,20,43,39,29,92,31,0,30,90,70,37,59};
		System.out.println(longestIncreasingSubsequence(a));
		System.out.println(longestIncreasingSubsequence(b));
		System.out.println(longestIncreasingSubsequence(c));
	}
    public static int longestIncreasingSubsequence(int[] nums) {
    	if(nums==null || nums.length==0){return 0;}
    	int n = nums.length;
    	int[] sub = new int[n];
    	
    	sub[0] = 1; //sub[i] : lis that ends with i !!!
    	int max = 1;
    	
    	for(int i=1; i<n; i++){
    		sub[i]=1;
    		for(int j=0; j<i; j++){
    			if(nums[i]>=nums[j]){
    				sub[i] = Math.max(sub[j]+1, sub[i]);
    			}
    		}
    		
    		if(sub[i]>max){max = sub[i];}
    	}
    	
		return max;
    }
}
