class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> list = new ArrayList();
        boolean [][] pacific = new boolean[heights.length][heights[0].length];
        boolean [][] atlantic = new boolean[heights.length][heights[0].length];
        Queue<int []> queue = new LinkedList();
        fill(pacific, queue, 0, 0);
        BFS(pacific, queue, heights);
        fill(atlantic, queue, heights.length-1, heights[0].length-1);
        BFS(atlantic, queue, heights);
        
        for(int k = 0; k < heights.length; k++)
        {
            for(int j = 0; j < heights[0].length; j++)
            {
                if(pacific[k][j] == true && atlantic[k][j] == true)
                {
                    list.add(Arrays.asList(new Integer [] {k,j}));
                }
            }
        }
        return list;
        
    }
    
    public void fill(boolean [][] ocean, Queue<int []> queue, int top, int side)
    {
        for(int k = 0; k < ocean[0].length; k++)
        {
            queue.add(new int [] {top,k});
        }
        for(int k = 0; k < ocean.length; k++)
        {
            queue.add(new int [] {k,side});
        }
    }
    
    public void BFS(boolean[][] ocean, Queue<int []> queue, int [][] heights)
    {
        while(!queue.isEmpty())
        {
            int [] current = queue.poll();
            int x = current[0];
            int y = current[1];
            if(ocean[x][y] == true)
            {continue;}
            ocean[x][y] = true;
            if(x + 1 < heights.length && heights[x+1][y] >= heights[x][y])
            {
                queue.add(new int [] {x+1, y});
            }
            if(x-1 >= 0 && heights[x-1][y] >= heights[x][y])
            {
                queue.add(new int [] {x-1, y});
            }
            if(y+1 < heights[0].length && heights[x][y+1] >= heights[x][y])
            {
                queue.add(new int [] {x,y+1});
            }
            if(y -1 >= 0 && heights[x][y-1] >= heights[x][y])
            {
                queue.add(new int [] {x,y-1});
            }
        }
    }
}