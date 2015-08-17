package lesson2;

import java.util.*;

/**
 * contains duplicates
 * A=[1,2,3,4]
 * B=[2,4,5,6]
 * return [1,2,2,3,4,4,5,6]
 * 
 * Challenge
 * How can you optimize your algorithm if one array is very large and the other is very small?
 * 
 * @author gjk
 *
 */
public class MergeSortedArray2 {

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
		ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(2,4,5,6));
		
		System.out.println(mergeSortedArray(A,B));

	}
	
	public static ArrayList<Integer> mergeSortedArray(ArrayList<Integer> A, ArrayList<Integer> B) {
		if(A==null){return B;}
		if(B==null){return A;}

		ArrayList<Integer> large=A, small=B;
		if(A.size()<B.size()){large=B;small=A;}
		
		int startPosition = 0;
		for(int i=0; i<small.size(); i++){
			startPosition = insert(large, small.get(i), startPosition);
		}
		
		return large;
    }
	
	private static int insert(ArrayList<Integer> list, int target, int startPostion){
		int start = startPostion;
		int end = list.size()-1;
		
		while(start + 1 < end){
			int middle = start + (end-start)/2;
			
			if(list.get(middle)==target){
				list.add(middle, target);
				return middle;
			}else if(list.get(middle)>target){
				end = middle;
			}else{
				start = middle;
			}
		}
		
		if(list.get(start) > target){
			list.add(start,target);
			return start;
		}
		
		if(list.get(end) < target){
			list.add(end+1,target);
			return end+1;
		}
		
		list.add(end, target);
		return end;
	}

}
