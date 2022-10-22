class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> list = new ArrayList();
        int a = heights.length;
        int b = heights[0].length;
        boolean [][] pacific = new boolean [a][b];
        boolean [][] atlantic = new boolean [a][b];
        for(int k = 0; k < a; k++)
        {
            DFS(heights, k, 0, pacific, a, b, heights[k][0]);
            DFS(heights, k,  b - 1, atlantic, a,b , heights[k][b-1]);
        }
        for(int k  = 0; k < b; k++)
        {
            DFS(heights, 0, k , pacific, a,b , heights[0][k]);
            DFS(heights, a-1, k, atlantic, a,b , heights[a-1][k]);
        }
        
        for(int k = 0; k < a; k++ )
        {
            for(int j = 0; j < b; j++)
            {
                if(pacific[k][j] == true && atlantic [k][j] == true)
                {
                    list.add(Arrays.asList(new Integer [] {k, j}));
                }
            }
        }
        return list;
        
    }
    public void DFS(int [][] heights, int row, int column, boolean [][] ocean, int rows, int columns, int prevValue)
    {
        if(row >= rows || row < 0 || column >= columns || column < 0 || prevValue > heights[row][column] || ocean[row][column] == true)
        {
            return;
        }
        
        ocean[row][column] = true;
        
        DFS(heights, row+1, column, ocean, rows, columns, heights[row][column]);
        DFS(heights, row-1, column, ocean, rows, columns, heights[row][column]);
        DFS(heights, row, column-1, ocean, rows, columns, heights[row][column]);
        DFS(heights, row, column+1, ocean, rows, columns, heights[row][column]);
    }
}