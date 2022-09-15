class Solution {
    public boolean exist(char[][] board, String word) {
        for(int k = 0; k < board.length; k++)
        {
            for(int j = 0; j < board[0].length;j++)
            {
                if(word.charAt(0) == board[k][j] && backtrack(board, k,j, word, 0))
                    return true;
            }
        }
        return false;
    }
    public boolean backtrack(char[][] board, int k, int j, String word, int pos)
    {
        if(pos == word.length()) return true;
        if(k < 0 || k >= board.length || j <0 || j >= board[0].length || word.charAt(pos) != board[k][j]) return false;
        
        
        char temp = board[k][j];
        board[k][j]= ' ';
        boolean result = backtrack(board, k+1, j, word, pos+1) || backtrack(board, k-1,j, word, pos+1) || backtrack(board,k, j+1, word, pos+1) || backtrack(board, k, j-1,word, pos+1);
        board[k][j] = temp;
        return result;
        
    }
}

