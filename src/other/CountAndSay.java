package other;

public class CountAndSay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public String countAndSay(int n) {
        
        if(n==1){return "1";}
        
        String s = countAndSay(n-1);
        char[] array = s.toCharArray();
        
        StringBuilder sb = new StringBuilder();
        
        char currentNumber = array[0];
        int currentCount = 1;
        for(int i=1; i<array.length; i++){
            if(currentNumber == array[i]){
                currentCount++;
            }else{
                sb.append(currentCount);
                sb.append(currentNumber);
                currentNumber = array[i];
                currentCount = 1;
            }
        }
        sb.append(currentCount);
        sb.append(currentNumber);
        
        return sb.toString();
    }
}
