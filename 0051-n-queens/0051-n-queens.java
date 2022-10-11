class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList();
        char [][] grid = new char [n][n];
        for(int k = 0; k < n; k++)
        {
            for(int j = 0; j < n; j++)
            {
                grid[k][j] = '.';
            }
        }
        backtrack(list, n, 0, grid);
        return list;
    }
    
    
    public boolean backtrack(List<List<String>> list, int n, int column, char [][] grid)
    {
        if(column == n)
        {
            List<String> temp  = new ArrayList();
            for(int k = 0; k < n; k++)
            {
                temp.add(String.valueOf(grid[k]));
            }
            list.add(temp);
            return false;
        }
        
        
        for(int k = 0; k < n; k++)
        {
            if(isValid(grid, k, column, n))
            {
                grid[k][column] = 'Q';
                if(backtrack(list, n, column +1, grid))
                {
                    return true;
                }
                else{
                    grid[k][column] = '.';
                }
           
        }
    }
        return false;
    }
    
    public boolean isValid(char [][] grid, int row, int column, int n)
    {
        for(int k = 0; k < n; k++)
        {
            if(grid[k][column] == 'Q') return false;
            if(grid[row][k] == 'Q') return false;
        }
        
        int step = 1;
        
        while(row - step >= 0 && column - step >= 0)
        {
            if(grid[row-step][column - step++] == 'Q') return false; 
        }
        
        step  = 1;
        while(row + step < n && column - step >= 0)
        {
            if(grid[row+step][column-step++] == 'Q') return false;
        }
        
        return true;
    }


}