package other;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public String longestCommonPrefix(String[] strs) {

        if(strs==null || strs.length==0){return "";}
        
        int minLength = Integer.MAX_VALUE;
        String minLengthString = "";
        
        for(String s : strs){
            if(minLength > s.length()){
                minLength = s.length();
                minLengthString = s;
            }
        }        
        
        for(int i=0; i<minLength; i++){
            char c = strs[0].charAt(i);
            for(String s : strs){
                if(s.charAt(i) != c){
                    return strs[0].substring(0,i);
                }
            }
        }
        
        return minLengthString;
    }
}
