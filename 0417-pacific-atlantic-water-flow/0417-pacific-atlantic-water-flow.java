class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> list = new ArrayList();
        boolean [][] atlantic = new boolean[heights.length][heights[0].length];
        boolean [][] pacific = new boolean[heights.length][heights[0].length];
        Queue<int []> queue = new LinkedList();
        //fill pacific
        fill(queue, heights, 0, 0);
        DFS(queue, heights, pacific);
        //fill atlantic
        fill(queue, heights, heights.length-1, heights[0].length-1);
        DFS(queue, heights, atlantic);
        
        for(int k = 0; k < heights.length; k++)
        {
            for(int j = 0; j < heights[0].length; j++)
            {
                if(atlantic[k][j] == true && pacific[k][j] == true)
                {
                    list.add(Arrays.asList(new Integer [] {k,j}));
                }
            }
        }
        return list;
        
        
    }
    
    public void fill(Queue<int []> queue, int [][] heights, int startRow, int startColumn)
    {
        for(int k = 0; k < heights.length; k++)
        {
                  queue.add(new int [] {k, startColumn});
         
           
        }
        for(int k = 0; k < heights[0].length; k ++)
        {
          queue.add(new int [] {startRow, k});
        }
    }
    
    public void DFS(Queue<int []> queue, int [][] heights, boolean [][] ocean)
    {
        while(!queue.isEmpty())
        {
            int [] temp =  queue.poll();
            int a = temp[0];
            int b = temp[1];
            if(ocean[a][b] == true)
            {
                continue;
            }
            ocean[a][b] = true;
            
            if(a+1 < heights.length && heights[a+1][b] >= heights[a][b])
            {
                queue.add(new int [] {a+1,b});
            }
            if(a-1 >= 0 &&  heights[a-1][b] >= heights[a][b])
            {
                queue.add(new int [] {a-1,b});
            }
            if(b+1 < heights[0].length && heights[a][b+1] >= heights[a][b])
            {
                queue.add(new int [] {a,b+1});
            }
            if(b-1 >= 0 && heights[a][b-1] >= heights[a][b])
            {
                queue.add(new int [] {a,b-1});
            }
        }
    }
    
    
}