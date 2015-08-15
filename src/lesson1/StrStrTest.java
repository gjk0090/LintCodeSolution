package lesson1;

public class StrStrTest {

	public static void main(String[] args){
		System.out.println(strStr("",""));
		System.out.println(strStr("aaa","aa"));
		System.out.println(strStr("aaaa","aaaaaa"));
		System.out.println(strStr("qwertyuio","rtyu"));
		System.out.println(strStr("qwertyuio","rtyua"));
		System.out.println(strStr("012345asdasdf","asdf"));
	}
	
	private static int strStr(String source, String target){
		
		if(source == null || target == null){
			return -1;
		}
		
		if(target.equals("")){
			return 0;
		}
		
		for(int i = 0; i < source.length() - target.length() + 1; i++){
			
			for(int j = 0; j < target.length(); j++){
				if(source.charAt(i+j) != target.charAt(j)){
					break;
				}
				if(j == target.length() - 1){
					return i;
				}
			}
			
		}
		return -1;
		
	}
}
