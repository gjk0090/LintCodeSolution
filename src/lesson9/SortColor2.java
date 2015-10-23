package lesson9;

import java.util.*;

public class SortColor2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public void sortColors2(int[] colors, int k) {
        
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i : colors){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }else{
                map.put(i,1);
            }
        }
        
        for(int i=0;i<colors.length;i++){
            for(int j=1;j<=k;j++){
                if(!map.containsKey(j)){continue;}
                for(int l=0;l<map.get(j);l++){
                    colors[i]=j;
                    i++;
                }
            }
        }
    }
    
    
    
    

    public void sortColors22(int[] colors, int k) {
        int count = 0;
        int start = 0;
        int end = colors.length-1;
        while (count < k) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            
            for (int i = start; i < end; i++) {
                min = Math.min(min, colors[i]);
                max = Math.max(max, colors[i]);
            }
            int left = start;
            int right = end;
            int cur = left;
            while(cur <= right) {
                if (colors[cur] == min) {
                    swap(left, cur, colors);
                    cur++;
                    left++;
                } else if (colors[cur] > min && colors[cur] < max) {
                    cur++;
                } else {
                    int tmp = colors[cur];
                    swap(cur, right, colors);
                    right--;
                }
            }
            count += 2;
            start = left;
            end = right;
        }
    }
    
    void swap(int left, int right, int[] colors) {
        int tmp = colors[left];
        colors[left] = colors[right];
        colors[right] = tmp;
    }
}
