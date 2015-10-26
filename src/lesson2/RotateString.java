package lesson2;

public class RotateString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		rotateString(null,2);
	}
	
    public static void rotateString(char[] str, int offset) {
        if(str==null||str.length==0){return;}
        offset=offset%str.length;
        reverse(str,0,str.length-1);
        reverse(str,0,offset-1);
        reverse(str,offset,str.length-1);
        
    }
    
    private static void reverse(char[] str, int start, int end){
        for(;start<end;start++,end--){ // important
            char temp = str[start];
            str[start]=str[end];
            str[end]=temp;
        }
    }
}
