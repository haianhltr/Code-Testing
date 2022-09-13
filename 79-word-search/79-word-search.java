class Solution {
    public boolean exist(char[][] board, String word) {
        for(int k = 0; k < board.length;k++)
        {
            for(int j = 0; j < board[0].length;j++)
            {
                if(board[k][j] == word.charAt(0) && DFS(board, k, j, 0, word))
                {
                    return true;
                }
            }
        }
        return false;
        
    }
    
    public boolean DFS(char [][] board, int k, int j, int pos, String word)
    {
        if(pos == word.length())
        {
            return true;
        }
        
        if(k >= board.length || k < 0 || j >= board[k].length || j< 0 || board[k][j] != word.charAt(pos))
        {
            return false;
        }
        
        
       char temp =  board[k][j];
        board[k][j] = ' ';
        boolean result = DFS(board, k+1, j , pos+1, word) || DFS(board, k-1, j, pos+1, word) || DFS(board, k, j+1, pos+1, word) || DFS(board, k , j-1, pos+1, word);
        board[k][j] = temp;
        return result;
        
    }
}