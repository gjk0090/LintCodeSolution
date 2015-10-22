package lesson9;

public class SortLetterByCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public void sortLetters(char[] chars) {
        int start=0,end=chars.length-1;
        while(start<end){
            while(start<end && isLow(chars[start])){
                start++;
            }
            while(start<end && !isLow(chars[end])){
                end--;
            }
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
        }
    }
    
    private boolean isLow(char c){
        return c >= 97 && c <= 122;
    }
}
