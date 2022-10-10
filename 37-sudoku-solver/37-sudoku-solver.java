class Solution {
    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0)
        {return;}
        
        backtrack(board);
    }
    public boolean backtrack(char [][] board)
    {
        for(int k = 0; k < board.length; k++)
        {
            for(int j = 0; j < board[0].length;j++)
            {
                if(board[k][j] == '.')
                {
                    for(char c= '1'; c<= '9'; c++)
                    {
                        if(isValid(board, k,j, c))
                        {
                            board[k][j] = c;
                            if(backtrack(board))
                                return true;
                            else
                                board[k][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean isValid(char[][] board, int row, int column, char c)
    {
        for(int i = 0 ; i < 9; i++)
        {
            if(board[i][column] != '.' && board[i][column] == c) return false;
            if(board[row][i] != '.' && board[row][i] == c) return false;
            if(board[3* (row/3) +i/3][3* (column/3) +i % 3] != '.' && 
              board[3 * (row/3) + i / 3][3* (column/3) + i % 3] == c) return false; 
                
        }
        
        return true;
    }
}