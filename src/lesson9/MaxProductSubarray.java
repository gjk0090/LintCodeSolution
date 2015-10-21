package lesson9;

public class MaxProductSubarray {

	public static void main(String[] args) {

		System.out.println(maxProduct(new int[]{9,0,6,3,-10,0,2}));
		System.out.println(maxProduct(new int[]{0,-1,4,-4,5,-2,-1,-1,-2,-3,0,-3,0,1,-1,-4,4,6,2,3,0,-5,2,1,-4,-2,-1,3,-4,-6,0,2,2,-1,-5,1,1,5,-6,2,1,-3,-6,-6,-3,4,0,-2,0,2}));//388800
	}

	public static int maxProduct(int[] nums) {
		int product = 1, max = Integer.MIN_VALUE;
		
		int maxNegative = 0; //important
				
		for (int i = 0; i < nums.length; i++) {

			product = product * nums[i];
			if (product > 0) {
				max = Math.max(max, product); // product/minPositive, minPositive is 1
			} else if (product < 0) {
				if(maxNegative!=0){
					max = Math.max(max, product/maxNegative); // product/maxNegative
					maxNegative = Math.max(maxNegative, product);
				}else{
					max = Math.max(max, product);
					maxNegative = product;					
				}
				
			} else {// product=0, nums[i]=0, reset everything except max, then move on
				max = Math.max(max, 0);
				product = 1;
				maxNegative = 0;
			}
		}

		return max;
	}
}
