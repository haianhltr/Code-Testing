class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int k = 0; k < grid.length; k++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(grid[k][j] == '1')
                {
                    BFS(grid, k, j);
                    count++;
                }
            }
        }
        return count;
    }
    public void BFS(char [][] grid, int row, int column)
    {
        Queue<int [] > queue = new LinkedList();
        queue.add(new int [] {row, column});
        while(!queue.isEmpty())
        {
            int [] current = queue.poll();
            int a = current[0];
            int b = current[1];
            if(grid[a][b] == '0')
            {
                continue;
            }
            grid[a][b] = '0';
            if(a+1 < grid.length && grid[a+1][b] == '1')
            {
                queue.add(new int [] {a+1, b});
            }
            if(a -1 >= 0 &&  grid[a-1][b] == '1')
            {
                queue.add(new int [] {a-1,b});
            }
            if(b + 1 < grid[0].length && grid[a][b+1] == '1')
            {
                queue.add(new int [] {a, b+1});
            }
            if(b - 1 >= 0 && grid[a][b-1] == '1')
            {
                queue.add(new int [] {a,b-1});
            }
            
        }
    }
}