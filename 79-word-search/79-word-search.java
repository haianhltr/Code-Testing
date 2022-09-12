class Solution {
    public boolean exist(char[][] board, String word) {
        for(int k = 0; k < board.length; k++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                if(board[k][j] == word.charAt(0) && DFS(board, k, j, 0, word))
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean DFS(char[][] board, int k, int j, int count, String word)
    {
        if(count == word.length())
            return true;
        if(k < 0 || k >= board.length || j < 0 || j >= board[k].length || board[k][j] != word.charAt(count) )
            return false;
        
         char temp = board[k][j];
         board[k][j] = ' ';
          boolean found = DFS(board,k+1, j, count+1, word) || DFS(board,k-1, j , count+1, word)
        || DFS(board,k, j+1, count+1, word) || DFS(board,k, j-1, count+1, word);
              
             board[k][j] = temp;
        
        return found;
    }
}