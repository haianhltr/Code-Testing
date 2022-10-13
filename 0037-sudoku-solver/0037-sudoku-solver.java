class Solution {
    public void solveSudoku(char[][] board) {
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
                    for(char c = '1'; c <= '9'; c++)
                    {
                        if(check(c, board, k, j) == true)
                        {
                            board[k][j] = c;
                            if(backtrack(board))
                            {
                                return true;
                            }
                            else{
                                board[k][j] = '.';
                            }
                            
                        }
                      
                    }
                      return false;
                }
            }
        }
        return true;
        
    }
    
    

    
    public boolean check(char c, char [][] board, int row, int column)
    {
        for(int k = 0; k < board.length; k++)
        {
            if(board[k][column] != '.' && board[k][column] == c) return false;
            if(board[row][k] != '.' && board[row][k] == c) return false;
            if(board[3 * (row/3) + (k/3)][3 * (column/3) + (k%3)] != '.' && board[3 * (row/3) + (k/3)][3 * (column/3) + (k%3)] ==  c) return false;
        }
        
        return true;
    }
}