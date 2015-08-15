package lesson2;

public class FirstBadVersion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findFirstBadVersion(13));
	}

	public static int findFirstBadVersion(int n) {

		if(n < 1){
			return -1;
		}
		
		int start = 1;
		int end = n;
		
		while(start + 1 < end){
			int middle = start + (end - start)/2;
			
			if(VersionControl.isBadVersion(middle)){
				end = middle;
			}else{
				start = middle;
			}
		}
		
		if(VersionControl.isBadVersion(start)){
			return start;
		}else{
			return end;
		}
		
	}
	
	private static class VersionControl{
		static int versions[] = {1,1,1,1,1,1,0,0,0,0,0,0,0,};
		private static boolean isBadVersion(int version){
			return versions[version-1] == 0;
		}
	}
	
}
