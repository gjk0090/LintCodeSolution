package other;
import java.util.*;

public class Multiply {


/*
big integer multiplication

121 * 11 = 1331
6542132468732 * 128798237641 = 842615132386646137941212

00000187 -> 187

00000 -> 0

1. numbers can't fit into any pre-defined data type in any programming languages
2. all numbers are non-negative, without +/- signs
3. input and output should be in same type/format

*/

    
    public static void main(String[] args){
        System.out.println(Arrays.toString(multiply(new int[]{6,5,4,2,1,3,2,4,6,8,7,3,2},new int[]{1,2,8,7,9,8,2,3,7,6,4,1})));
        System.out.println(multiply("6542132468732","128798237641"));
    }

    public static String multiply(String num1, String num2) {
        int[] num = new int[num1.length()+num2.length()];
        int len1 = num1.length(), len2 = num2.length();
        for(int i=len1-1;i>=0;i--){
            for(int j=len2-1;j>=0;j--){
                int temp = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                num[i+j] += (temp+num[i+j+1])/10;
                num[i+j+1] = (num[i+j+1]+temp)%10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i: num) if(sb.length()>0||i>0)  sb.append(i);
        return (sb.length()==0)?"0":sb.toString();
    }
    
    public static int[] multiply(int[] num1, int[] num2){
        //reverse numbers
        reverse(num1);
        reverse(num2);
        
        //answer array
        int[] answer = new int[num1.length+num2.length];
        
        //cmpute answer
        for(int i=0; i<num1.length; i++){
            for(int j=0; j<num2.length; j++){
                
                int product = num1[i] * num2[j] + answer[i+j];
                int carry=product/10;
                product = product%10;
                answer[i+j] = product;
                answer[i+j+1] += carry;
            }
        }
        
        //reverse answer
        reverse(answer);
        
        //remove zeros
        int length=answer.length;
        for(int i=0;i<answer.length;i++){
            if(answer[i]==0){
                length--;
            }else{
                break;
            }
        }
        int[] newAnswer = new int[length];
        for(int i=0;i<newAnswer.length;i++){
            newAnswer[i] = answer[i+answer.length-length];
        }
        
        //return
        return newAnswer;
    }   
    
    private static void reverse(int[] array){
        for(int i=0; i<(array.length+1)/2; i++){
            int temp = array[i];
            array[i] = array[array.length-i-1];
            array[array.length-i-1] = temp;
        }
    }
}