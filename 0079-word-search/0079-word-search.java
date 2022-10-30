class Solution {
    public boolean exist(char[][] board, String word) {
        for(int k = 0; k < board.length; k++)
        {
           for(int j = 0; j < board[0].length; j++)
           {
               if(word.charAt(0) == board[k][j] && backtrack(board, word, k, j, 0))
               {
                   return true;
               }
           }
        }
        return false;
    }
    
    private boolean backtrack(char [][] board, String word, int row, int column, int pos)
    {
        if(pos == word.length()) return true;
        if(row >= board.length || row < 0 || column >= board[0].length || column < 0 || board[row][column] != word.charAt(pos))
        {
            return false;
        }
        
        char temp = board[row][column];
        board[row][column] = ' ';
        
        boolean result = backtrack(board, word, row + 1, column, pos + 1) || backtrack(board, word, row-1, column, pos + 1) || backtrack(board, word, row, column + 1, pos + 1) || backtrack(board, word, row, column -1, pos + 1);
        board[row][column] = temp;
        return result;
    }
}