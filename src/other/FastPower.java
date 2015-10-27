package other;

public class FastPower {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int fastPower(int a, int b, int n) {
        
        if(b==0){return 0;}
        if(n==0){return 1%b;}
        if(n==1){return a%b;}
        
        long product = fastPower(a,b,n/2);
        product = product * product;
        product = product % b;
        
        if(n%2==1){
            product = product * a;
            product = product % b;
        }
        
        return (int)product;
        
    }

}
