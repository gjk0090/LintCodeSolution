package lesson8;

public class HashFunction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "Wrong answer or accepted?";
		for(char c : s.toCharArray()){
			System.out.print((int)c+" ");
		}
		
		System.out.println();
		System.out.println(hashCode(s.toCharArray(),1000000007)); //382528955
	}
	
    public static int hashCode(char[] key,int HASH_SIZE) {
        int size = key.length;
        long sum=0;
        for (int i = 0; i < size; i++) {
            sum = sum * 33 + key[i];
            sum = sum % HASH_SIZE; 
            
        }
        
        return (int)sum;
    }
}
