package other;

public class DigitCount {

	public static void main(String[] args) {

		System.out.println(digitCounts(1,12));
		System.out.println(digitCounts(0,10));
	}
    public static int digitCounts(int k, int n) {

        int sum = 0;
        
        for(int i=0; i<=n; i++){
            int temp = i;//important, do not modify i
            
            while(temp!=0){
                if(temp-temp/10*10 == k){sum++;}
                temp=temp/10;
            }
        }      
        if(k==0){sum++;} //important
        
        return sum;

    }
}
