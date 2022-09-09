class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> list = new ArrayList();
        boolean [][] pacific = new boolean[heights.length][heights[0].length];
        boolean [][] atlantic = new boolean[heights.length][heights[0].length];
        Queue<int []> queue = new LinkedList();
        fill(pacific, queue, 0, 0);
        BFS(pacific, queue, heights);
        fill(atlantic, queue,heights.length-1, heights[0].length-1);
        BFS(atlantic, queue, heights);
        
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
    public void fill(boolean [][] ocean, Queue<int[]> queue, int topStart, int sideStart)
    {
        for(int k = 0; k < ocean.length; k++)
        {
            queue.add(new int [] {k, sideStart});
        }
        for(int k = 0; k < ocean[0].length; k++)
        {
            queue.add(new int [] {topStart,k});
        }
        
    }
    public void BFS(boolean [][] ocean, Queue<int []> queue, int[][] heights)
    {
        while(!queue.isEmpty())
        {
            int [] current = queue.poll();
            int a = current[0];
            int b = current[1];
            if(ocean[a][b] == true)
            {
                continue;
            }
            ocean[a][b] = true;
            if(a+1 < heights.length && heights[a+1][b] >= heights[a][b])
            {
                queue.add(new int [] {a+1,b});
            }
            if(a-1 >= 0 && heights[a-1][b] >= heights[a][b])
            {
                queue.add(new int [] {a-1,b});
            }
            if(b+1 < heights[0].length && heights[a][b+1] >= heights[a][b])
            {
                queue.add(new int [] {a, b+1});
            }
            if(b-1 >= 0 && heights[a][b-1] >= heights[a][b])
            {
                queue.add(new int [] {a,b-1});
            }
        }
    }
}