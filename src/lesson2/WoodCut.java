package lesson2;

public class WoodCut {

	public static void main(String[] args) {
		System.out.println(woodCut(new int[]{2147483644,2147483645,2147483646,2147483647}, 4));

	}
    public static int woodCut(int[] L, int k) {
        // get max length then do binary search
    	
    	
        long sum = 0; // important
        for(int i : L){
            sum+=i;
        }
        int maxLength = (int) (sum/k); // cast to int
        if(maxLength == 0){return 0;} // important
        
        int start = 1;
        int end = maxLength;
        
        while(start +1 < end){
            int mid = start + (end-start)/2;
            if(valid(L,k,mid)){
                start = mid;
            }else{
                end = mid;
            }
        }
        
        if(valid(L,k,end)){return end;}
        if(valid(L,k,start)){return start;}
        
        
        return -1;
    }
    
    private static boolean valid(int[] L, int k, int length){
        int sum = 0;
        for(int i : L){
            sum += i/length;
        }
        return sum>=k;
    }
}
