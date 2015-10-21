package other;

import java.util.*;

public class MatrixRoute {

	public static void main(String[] args) {
        int x=10,y=10;
        int[][] m = new int[x][y];
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                if(i==0||j==0){
                    m[i][j]=1;
                }else{
                    m[i][j] = m[i-1][j]+m[i][j-1];
                }
            }
        }
        for(int[] a : m){
            System.out.println(Arrays.toString(a));
        }
	}

}
