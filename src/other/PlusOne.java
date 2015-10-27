package other;

public class PlusOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int[] plusOne(int[] digits) {
    	
        int carry=1; //initially 1, in order to add 1
        
        for(int i=digits.length-1;i>=0;i--){
            int temp = digits[i];
            temp+=carry;
            carry = temp/10;
            digits[i]=temp%10;
        }
        
        //if carry is still 1, it only can be 999999+1
        if(carry == 1){
            digits = new int[digits.length+1];
            digits[0] = 1;
        }
        
        return digits;

    }
}
