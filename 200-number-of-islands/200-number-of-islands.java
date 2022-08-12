class Solution {
    public int numIslands(char[][] grid) {
       int count = 0;
        for(int k = 0; k < grid.length; k++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(grid[k][j] == '1')
                {
                    BFS(k,j,grid);
                    count++;
                }
            }
        }
        return count;
    }
    
    
    private void BFS(int row1, int column1, char[][]grid)
    {
        Queue<int [] > queue = new LinkedList();
        queue.add(new int [] {row1,column1});
        while(!queue.isEmpty())
        {
         int [] pos = queue.poll();
            int row = pos[0];
            int column = pos[1];
            if(grid[row][column] == '0') continue;
            grid[row][column] = '0';
            
             //top
         if(row + 1 < grid.length && grid[row+1][column] == '1')
            {
                queue.add(new int [] {row+1, column});
            }
            if(row - 1 >= 0 && grid[row-1][column] == '1')
            {
                queue.add(new int [] {row-1, column});
            }

              if(column-1 >= 0 && grid[row][column-1] == '1')
            { queue.add(new int [] {row,column-1});}
            
            
            
            
  if(column + 1 < grid[0].length && grid[row][column+1] == '1')
            {
                queue.add(new int [] {row, column+1});
            }

         
      
            
        }
    }
}

