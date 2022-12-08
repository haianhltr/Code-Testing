class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int k = 0; k < grid.length; k++)
        {
            for(int j =0 ; j < grid[0].length; j++)
            {
                if(grid[k][j] == '1')
                {
                    DFS(grid, k, j);
                    count++;
                }
            }
        }
        return count;
    }
    
    public void DFS(char [][] grid, int k, int j)
    {
        if(k < 0 || k >= grid.length || j < 0 || j >= grid[0].length || grid[k][j] == '0') return;
        grid[k][j] = '0';
        DFS(grid, k + 1, j);
        DFS(grid, k - 1, j);
        DFS(grid, k, j + 1);
        DFS(grid, k, j -1);
    }
}