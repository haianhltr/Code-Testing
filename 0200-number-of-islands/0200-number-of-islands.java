class Solution {
    public int numIslands(char[][] grid) {
        int count = 0 ;
        for(int k = 0; k < grid.length; k++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(grid[k][j] == '1')
                {
                    DFS(grid,k,j);
                    count++;
                }
            }
        }
        return count;
        
    }
    public void DFS(char [][] grid, int row, int column)
    {
        if(row >= grid.length  || row < 0 || column >= grid[0].length || column < 0 || grid[row][column] == '0')
        {
            return;
        }
        grid[row][column] = '0';
        DFS(grid, row+1, column);
        DFS(grid, row-1, column);
        DFS(grid, row, column+1);
        DFS(grid, row, column - 1);
    }
}