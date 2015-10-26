package lesson9;

import java.util.*;

public class SortColor2 {

	public static void main(String[] args) {

		int[] colors=  new int[]{3, 2, 2, 4, 4};
		sortColors2(colors,4);
		System.out.println(Arrays.toString(colors));
	}
	
	//counting sort
    public static void sortColors2(int[] colors, int k) {
        
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i : colors){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }else{
                map.put(i,1);
            }
        }
        
        int index=0;
        
        for(int i=1;i<=k;i++){
        	
        	if(map.get(i)==null){continue;} //important
        	
        	for(int j=0;j<map.get(i);j++){
        		colors[index] = i;
        		index++;
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
