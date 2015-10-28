package other;

public class BackPack {

	public static void main(String[] args) {

		System.out.println(backPack(10, new int[]{3,4,8,5}));
		System.out.println(backPack(5000, new int[]{828,125,740,724,983,321,773,678,841,842,875,377,674,144,340,467,625,916,463,922,255,662,692,123,778,766,254,559,480,483,904,60,305,966,872,935,626,691,832,998,508,657,215,162,858,179,869,674,452,158,520,138,847,452,764,995,600,568,92,496,533,404,186,345,304,420,181,73,547,281,374,376,454,438,553,929,140,298,451,674,91,531,685,862,446,262,477,573,627,624,814,103,294,388}));
	}
	
    public static int backPack(int m, int[] A) {
        
        //can be filled
        boolean[][] result = new boolean[A.length+1][m+1];
        
        //init, m=0 always true
        for(int i=0;i<=A.length;i++){
            result[i][0] = true;
        }
        
        //DP
        for(int i=1;i<=A.length;i++){
            for(int j=1;j<=m;j++){
                if(j>=A[i-1]){ // put this item in
                    result[i][j]=result[i-1][j-A[i-1]] || result[i-1][j];
                }else{ // cant put this item in, same with without this item
                    result[i][j]=result[i-1][j];
                }
            }
        }
        
        for(int i=m;i>=0;i--){
            if(result[A.length][i]){return i;}
        }
        
        return 0;
    }

}
