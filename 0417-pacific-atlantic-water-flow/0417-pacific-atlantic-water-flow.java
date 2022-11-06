class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> list = new ArrayList();
        int rows = heights.length;
        int columns = heights[0].length;
        boolean [][] pacific = new boolean [rows][columns];
        boolean [][] atlantic = new boolean [rows][columns];
        for(int k = 0; k < rows; k++)
        {
            DFS(pacific, heights, k, 0, rows, columns, heights[k][0]);
            DFS(atlantic, heights, k, columns -1, rows, columns, heights[k][columns-1]);
        }
        for(int k = 0; k < columns; k++)
        {
            DFS(pacific, heights, 0, k , rows, columns, heights[0][k]);
            DFS(atlantic, heights, rows-1, k, rows, columns, heights[rows-1][k]);
        }
        
        for(int k = 0; k < rows; k++)
        {
            for(int j = 0; j < columns; j++)
            {
                if(pacific[k][j] == true && atlantic[k][j] == true)
                {
                    list.add(Arrays.asList(new Integer [] {k,j}));
                }
            }
        }
        return list;
        
    }
    
    public void DFS(boolean [][] ocean, int [][] heights, int row, int column, int rows, int columns, int prev)
    {
        if(row < 0 || row >= rows || column < 0 || column >= columns || ocean[row][column] == true || prev > heights[row][column])
            return;
        
        ocean[row][column] = true;
        DFS(ocean, heights, row + 1, column, rows, columns, heights[row][column]);
        DFS(ocean, heights, row - 1, column, rows, columns,  heights[row][column]);
        DFS(ocean, heights, row, column - 1, rows, columns, heights[row][column]);
        DFS(ocean, heights, row, column + 1, rows, columns, heights[row][column]);
    }
}