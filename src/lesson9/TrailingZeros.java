package lesson9;

public class TrailingZeros {

	public static void main(String[] args) {

		System.out.println(trailingZeros(11));
	}
    public static long trailingZeros(long n) {
    	int sum=0;
    	while(n>5){
    		n=n/5;
    		sum+=n;
    	}
    	return sum;
    }
}
