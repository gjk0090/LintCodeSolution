package other;

import java.util.*;

public class KthLargestElement {

	public static void main(String[] args) {

		System.out.println(kthLargestElement(3,new ArrayList<Integer>(Arrays.asList(9,3,2,4,8))));
	}
    public static int kthLargestElement(int k, ArrayList<Integer> numbers) {
        if(numbers == null || numbers.size() == 0){return -1;}
        int pivot = numbers.get(0);
        
        ArrayList<Integer> small = new ArrayList<Integer>();
        ArrayList<Integer> large = new ArrayList<Integer>();
        
        //no == !!!!
        for(Integer i : numbers){
            if(i>pivot){
                large.add(i);
            }else if(i<pivot){
                small.add(i);
            }
        }
        
        //important
        if(large.size() >= k){
            return kthLargestElement(k,large);
        }else if((numbers.size()-small.size()) >= k){
            return pivot;
        }else{
            return kthLargestElement(k-(numbers.size()-small.size()), small);
        }
    }
}
