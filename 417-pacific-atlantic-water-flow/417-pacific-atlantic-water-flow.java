class Solution {
        int [][] heights;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        List<List<Integer>> list = new ArrayList();
        Queue<int []> queue = new LinkedList();
        //declare a queue
        //pacific, addtop and addside, do bsf
        
        int m = heights.length;
        int n = heights[0].length;
     
        addTop(queue,0,n);
        addSide(queue,0,m);
        
        //create a function that return a boolean array after doing BFS and 
        //return it back to pacific
        boolean [][] pacific = BFS(queue,m,n);
        
        //atlantic
        addTop(queue,m-1,n);
        addSide(queue,n-1,m);
        boolean [][] atlantic = BFS(queue,m,n);
        
        for(int k = 0; k < m; k++)
        {
            for(int j = 0; j < n; j++)
            {
                if((pacific[k][j] == true) && (atlantic[k][j] == true))
                {
                    list.add(Arrays.asList(new Integer [] {k,j}));
                }
            }
        }
        return list;
      

    }
                                           
    private boolean [][] BFS(Queue <int [] > queue, int m, int n)
    {
        boolean [][] result = new boolean[m][n];
        while(!queue.isEmpty())
        {
            //dequeue the first one and got temp [0,0]
            int [] temp = queue.poll();
            int row = temp[0];
            int column = temp[1];
            int currentNum = heights[row][column];
            
            if(result[row][column] == true) continue;
            result[row][column] = true;
            
            if(row +1 < m && currentNum <= heights[row+1][column])
            {
                queue.add(new int [] {row+1,column});
            }
            
             if(row - 1 >= 0 && currentNum <= heights[row-1][column])
            {
                queue.add(new int [] {row-1,column});
            }
            
            
             if(column +1 < n && currentNum <= heights[row][column+1])
            {
                queue.add(new int [] {row,column+1});
            }
            
             if(column -1 >= 0 && currentNum <= heights[row][column-1])
            {
                queue.add(new int [] {row,column-1});
            }
            
        }
                          return result;
        
    }
    
    private void addTop(Queue<int []> queue,int rowstart, int end)
    {
        for(int k = 0; k < end; k++)
        {
            queue.add(new int [] {rowstart,k});
        }
    }
    
      private void addSide(Queue<int []> queue,int columnstart, int end)
    {
        for(int k = 0; k < end; k++)
        {
            queue.add(new int [] {k,columnstart});
        }
    }
}