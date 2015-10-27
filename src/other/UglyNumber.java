package other;

import java.util.TreeSet;

//kth prime number
public class UglyNumber {

	public static void main(String[] args) {

		System.out.println(kthPrimeNumber(1111));
	}
	
    public static long kthPrimeNumber(int k) {

        TreeSet<Long> set = new TreeSet<Long>();
        
        set.add(1l); // important
        long temp = 0;
        
        for(int i=0;i<=k;i++){
            temp = set.pollFirst();
            set.add(temp*3l);
            set.add(temp*5l);
            set.add(temp*7l);
        }
        
        return temp;
    }
}
