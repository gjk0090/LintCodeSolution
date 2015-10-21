package lesson9;

public class Sqrt {

	public static void main(String[] args) {
		System.out.println(sqrt(999999999));
	}
    public static int sqrt(int x) {

        int start=0, end=x;
        while(start+1<end){
            int middle = start+(end-start)/2;
            long sq = (long)middle*(long)middle; //important
            if(sq == x){
                return middle;
            }else if(sq > x){
                end = middle;
            }else{ //sq < x
                if((sq+middle+middle+1) > x){
                    return middle;
                }else{
                    start = middle;
                }
            }
        }
        
        if(end * end <= x){
            return end;
        }
        
        return start;
    }
}
