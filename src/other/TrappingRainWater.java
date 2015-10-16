package other;

public class TrappingRainWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(trap2(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
		System.out.println(trap2(new int[]{4,2,0,3,2,5}));
		System.out.println(trap2(new int[]{5,4,1,2}));
		System.out.println(trap2(new int[]{0,2,0}));
	}
    public static int trap(int[] height) {
        int water = 0;
        
        
        for(int i=0; i<height.length-1; i++){
        	
            int case1Sum = 0; //assume can find higher
            int case2Sum = 0; //assume cant find higher, use highest
            int highest = height[i+1];
            int highestIndex = i+1;
            
            for(int j=i+1; j<height.length; j++){
            	
                if(height[j] >= height[i]){
                	
                    water += case1Sum;
                    i=j-1;
                    break;
                    
                }else{ //[j] < [i]
                	
                    if(highest < height[j]){
                    	
                        highest = height[j];
                        highestIndex = j;
                        case2Sum = case1Sum - (height[i]-highest)*(j-i-1);
                        
                    }
                    
                    case1Sum += height[i] - height[j];
                }
                
                if(j == height.length-1){
                    water += case2Sum;
                    i=highestIndex-1;
                }
                
            }
            
        }
        return water;
    }
    
    public static int trap2(int[] height) {
    	int water = 0;
    	int highestIndex = 0;
    	for(int i=0; i<height.length; i++){
    		highestIndex = (height[i] > height[highestIndex])? i:highestIndex;
    	}
    	
    	for(int i=0; i<highestIndex; i++){
    		for(int j=i+1; j<=highestIndex; j++){
    			if(height[i]>height[j]){
    				water += height[i] - height[j];
    			}else{
    				i = j-1;
    				break;
    			}
    		}
    	}
    	
    	for(int i=height.length-1; i>highestIndex; i--){
    		for(int j = i-1; j>=highestIndex; j--){
    			if(height[i]>height[j]){
    				water += height[i] - height[j];
    			}else{
    				i = j+1;
    				break;
    			}
    		}
    	}
    	return water;
    }
}
