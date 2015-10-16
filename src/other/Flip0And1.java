package other;

public class Flip0And1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(flip("1110001001010001101010101101000011101011011110001"));
		System.out.println(flip(new int[]{1,1,1,0,0,0,1,0,0,1,0,1,0,0,0,1,1,0,1,0,1,0,1,0,1,1,0,1,0,0,0,0,1,1,1,0,1,0,1,1,0,1,1,1,1,0,0,0,1}));
		System.out.println(flip("1111111111"));
		System.out.println(flip("0000000000"));
		System.out.println(flip("0011100"));

	}
	
	private static int flip(String s){
		
		int oriNumOfOne = 0; //7
		int max = 0; //5
		int[] result = new int[s.length()]; //1
		result[0] = (s.charAt(0)=='1')? 0:1; //2
		oriNumOfOne += (s.charAt(0)=='1')? 1:0; //8
		
		for(int i=1; i<result.length; i++){ //3
			result[i] = (s.charAt(i)=='1')? Math.max(result[i-1]-1,0):result[i-1]+1; //4
			max = Math.max(result[i], max); //6
			oriNumOfOne += (s.charAt(i)=='1')? 1:0; //9
		}
		return max+oriNumOfOne;
	}
	
	private static int flip(int[] num){
		int numOfOne = 0;
		int[] result = new int[num.length];
		int max = 0;
		result[0] = (num[0] == 1)? 0 : 1;
		numOfOne += (num[0]==1)? 1:0;
		
		for(int i=1; i<num.length; i++){
			result[i] = (num[i] == 1)? Math.max(0, result[i-1]-1) : result[i-1]+1;
			max = Math.max(max, result[i]);
			numOfOne += (num[i] == 1)? 1:0;
		}
		
		return numOfOne + max;
	}

}
