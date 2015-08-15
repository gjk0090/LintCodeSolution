package util;

import java.util.List;

public class PrintUtil {
    public static void printList(List<? extends Object> l){
    	if(l == null){System.out.println("list is null");return;}
		System.out.println("size of list : "+l.size());
    	for(Object i : l){
    		if(i==null){i="null";}
			System.out.print(i+" ");
		}
		System.out.println("");
    }
    public static void printArray(Object[] array){
    	if(array == null){System.out.println("array is null");return;}
		System.out.println("size of array : "+array.length);
		for(Object i : array){
    		System.out.print(i+" ");
    	}
    	System.out.println();
    }
	public static void printArray(int[] array) {
    	if(array == null){System.out.println("array is null");return;}
		System.out.println("size of array : "+array.length);
		for(int i : array){
    		System.out.print(i+" ");
    	}
    	System.out.println();		
	}

}
