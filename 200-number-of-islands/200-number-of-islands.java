class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int k = 0; k < grid.length; k++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(grid[k][j] == '1')
                {
                    BFS(k, j,grid);
                    count++;
                }
            }
        }
        return count;
    }
    
    public void BFS(int k, int j, char [][] grid){
        Queue<int []> queue = new LinkedList();
        queue.add(new int [] {k,j});
        while(!queue.isEmpty())
        {
            int [] current = queue.poll();
            int x = current[0];
            int y = current[1];
            if(grid[x][y] == '0') continue;
            grid[x][y] = '0';
            if(x+1 < grid.length && grid[x+1][y] == '1')
            {
                queue.add(new int [] {x+1,y});
            }
            if(x-1 >= 0 && grid[x-1][y] == '1')
            {
                queue.add(new int [] {x-1,y});
            }
             if(y+1 < grid[0].length && grid[x][y+1] == '1')
            {
                queue.add(new int [] {x,y+1});
            }
            if(y-1 >= 0 && grid[x][y-1] == '1')
            {
                queue.add(new int [] {x,y-1});
            }
            
        }
    }
}