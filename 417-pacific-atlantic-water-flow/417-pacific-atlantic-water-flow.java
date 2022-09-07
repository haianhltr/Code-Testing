class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> list = new ArrayList();
        boolean [][] pacific = new boolean[heights.length][heights[0].length];
        boolean [][] atlantic = new boolean [heights.length][heights[0].length];
        Queue<int []> pacificQ = new LinkedList();
        Queue<int []> atlanticQ = new LinkedList();
        fill(pacificQ, pacific, 0,0);
        BFS(pacificQ, pacific, heights);
        fill(atlanticQ, atlantic,heights.length-1,heights[0].length-1);
        BFS(atlanticQ,atlantic, heights);
        
        for(int k = 0; k < heights.length; k++)
        {
            for(int j = 0; j < heights[0].length; j++)
            {
                if((pacific[k][j] == true) && (atlantic[k][j] == true))
                {
                    list.add(Arrays.asList(new Integer [] {k,j}));
                }
            }
        }
     
        return list;
    }
    
    public void fill(Queue<int []> queue, boolean [][] ocean, int maxTop, int maxSide)
    {
        for(int k = 0; k < ocean[0].length; k++)
        {
            
            queue.add(new int [] {maxTop,k});
      
        }
        for(int k =0 ; k < ocean.length;k++)
        {
      
            queue.add(new int [] {k, maxSide});
   
        }
    }
    public void BFS(Queue<int []> queue, boolean[][] oceanB,int [][] ocean)
    {
        while(!queue.isEmpty()){
        int [] current = queue.poll();
        int a= current[0];
        int b = current[1];
        if(oceanB[a][b] == true)
        {
            continue;
        }
        oceanB[a][b] = true;
            
        if(a+1 < ocean.length && ocean[a+1][b] >= ocean[a][b])
        {
            queue.add(new int [] {a+1, b});
        }
        if(a-1 >= 0 && ocean[a-1][b] >= ocean[a][b])
        {
            queue.add(new int []{a-1,b});
        }
        if(b-1 >= 0 && ocean[a][b-1] >= ocean[a][b])
        {
            queue.add(new int [] {a, b-1});
        }
        if(b+1 < ocean[0].length && ocean[a][b+1] >= ocean [a][b])
        {
            queue.add(new int [] {a, b+1});
        }
        }
    }
}