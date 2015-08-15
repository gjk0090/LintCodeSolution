package util;

import java.util.*;

public class CollectionBuilder {

	public static ArrayList<Integer> buildArrayList(int[] array){
		ArrayList<Integer> l = new ArrayList<Integer>();
		if(array == null){System.out.println("input array is null");return l;}
		for(int i : array){l.add(i);}
		return l;
	}

}
