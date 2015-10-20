package lesson9;

import java.util.*;

public class SubarraySumClosest {

	public static void main(String[] args) {
		System.out.println(subarraySumClosest(new int[]{-3,1,1,-3,5}));

	}
	
	
	//n^3
    public static ArrayList<Integer> subarraySumClosest(int[] nums) {
        int min=Integer.MAX_VALUE;
        int start=0,end=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                int sum = 0;
                for(int k=i;k<=j;k++){
                    sum+=nums[k];
                }
                if(Math.abs(min)>Math.abs(sum)){
                    start=i;
                    end=j;
                    min=sum;
                }
            }
        }
        
        return new ArrayList<Integer>(Arrays.asList(start,end));
    }
    
    //n^2 + n space
    public ArrayList<Integer> subarraySumClosest2(int[] nums) {
        int min=Integer.MAX_VALUE;
        int start=0,end=0;
        
        int[] sum = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            sum[i] = i>0? sum[i-1] + nums[i] : nums[i];
        }
        
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                int currSum = sum[j] - sum[i] + nums[i]; //avoid sum[i-1]
                
                if(Math.abs(min)>Math.abs(currSum)){
                    start=i;
                    end=j;
                    min=currSum;
                }
            }
        }
        
        return new ArrayList<Integer>(Arrays.asList(start,end));
    }
    
    
    
    //nlogn, by jiuzhang
    class Pair {
        int sum;
        int index;
        public Pair(int s, int i) {
            sum = s;
            index = i;
        }
    }
    public ArrayList<Integer> subarraySumClosest3(int[] nums) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer> ();
        if (nums == null || nums.length == 0) {
            return res;
        } 
        
        int len = nums.length;
        if(len == 1) {
            res.add(0);
            res.add(0);
            return res;
        }
        Pair[] sums = new Pair[len+1];
        int prev = 0;
        sums[0] = new Pair(0, 0);
        for (int i = 1; i <= len; i++) {
            sums[i] = new Pair(prev + nums[i-1], i);
            prev = sums[i].sum;
        }
        Arrays.sort(sums, new Comparator<Pair>() {
           public int compare(Pair a, Pair b) {
               return a.sum - b.sum;
           } 
        });
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= len; i++) {
            
            if (ans > sums[i].sum - sums[i-1].sum) {
                ans = sums[i].sum - sums[i-1].sum;
                res.clear();
                int[] temp = new int[]{sums[i].index - 1, sums[i - 1].index - 1};
                Arrays.sort(temp);
                res.add(temp[0] + 1);
                res.add(temp[1]);
            }
        }
        
        return res;
    }
}
