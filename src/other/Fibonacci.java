package other;

public class Fibonacci {

	public static void main(String[] args) {

		//define : f[0] = 0;
	}
    public int fibonacci(int n) {
        if(n==1 || n==2){return n-1;}
        
        //return fibonacci(n-1)+fibonacci(n-2);
        
        int n1=0, n2=1, answer=0;
        for(int i=3;i<=n;i++){
            answer=n1+n2;
            n1=n2;
            n2=answer;
        }
        return answer;
    }
}
