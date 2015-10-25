package other;

public class WordSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public boolean exist(char[][] board, String word) {
        if(board==null || board.length==0){
            return false;
        }
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == word.charAt(0)){
                    boolean b = search(board, i, j, word, 0); //no direct return!!
                    if(b){return b;}
                }
            }
        }
        return false;
    }
    
    private boolean search(char[][] board, int i, int j, String word, int start){
    	
    	//important : order!!
        if(start>=word.length()){return true;}
        if(i<0 || i>= board.length || j<0 || j>= board[0].length){return false;}
        if(board[i][j] != word.charAt(start)){return false;}
        
        board[i][j] = '#'; //avoid duplicate!!
        boolean b = search(board, i-1, j, word, start+1) || search(board, i+1, j, word, start+1) || search(board, i, j-1, word, start+1) || search(board, i, j+1, word, start+1);
        board[i][j] = word.charAt(start);
        
        return b;
    }
}
