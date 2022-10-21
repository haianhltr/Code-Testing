class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> list  = new ArrayList();
        boolean [][] pacific = new boolean[heights.length][heights[0].length];
        boolean [][] atlantic = new boolean[heights.length][heights[0].length];
        //fill pacific boolean array
        for(int k = 0; k < heights.length; k++)
        {
            //fill horizontal
            DFS(pacific, heights, k ,0, heights[k][0]);
            DFS(atlantic, heights, k, heights[0].length-1, heights[k][heights[0].length-1]);
        }
        for(int j = 0; j < heights[0].length; j++)
        {
            DFS(pacific, heights, 0, j, heights[0][j]);
            DFS(atlantic, heights, heights.length-1, j , heights[heights.length-1][j]);
        }
        
        for(int k = 0; k < heights.length; k++)
        {
            for(int j = 0; j < heights[0].length;j++)
            {
                if(pacific[k][j] == true && atlantic[k][j] == true)
                {
                    list.add(Arrays.asList(new Integer [] {k,j}));
                }
            }
        }
        return list;
        
    }
    
  
    
    public void DFS(boolean [][] ocean, int [][] heights, int row, int column, int prevValue)
    {
        if(row >= heights.length || row < 0 || column >= heights[0].length || column < 0 || prevValue > heights[row][column] || ocean[row][column] == true)
        {
            return;
        }
        ocean[row][column] = true;
        
        DFS(ocean, heights, row+1, column, heights[row][column]);
        DFS(ocean, heights, row-1, column, heights[row][column]);
        DFS(ocean, heights, row, column + 1, heights[row][column]);
        DFS(ocean, heights, row, column - 1, heights[row][column]);
    }
}