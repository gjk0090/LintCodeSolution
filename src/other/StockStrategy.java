package other;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class StockStrategy {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<int[]> l = new ArrayList<int []>();
        for(int i=0; i<n; i++){
            int m = sc.nextInt();
            int[] array = new int[m];
            for(int j=0; j<m; j++){
                array[j] = sc.nextInt();
            }
            l.add(array);
        }
        
        for(int [] array : l){
            System.out.println(max(array));
        }
    }
    
    private static long max(int[] array){
        long result = 0;
        int n = array.length;
        int maxPrice = array[n-1];
        for(int i=n-2; i>=0; i--){
            if(array[i]>maxPrice){
                maxPrice = array[i];
            }else{
                result += maxPrice;
                result -= array[i];
            }
        }
        return result;
    }
}