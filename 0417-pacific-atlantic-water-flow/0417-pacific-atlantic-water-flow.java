class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> list = new ArrayList();
        int rows = heights.length;
        int columns = heights[0].length;
        boolean [][] pacific = new boolean [rows][columns];
        boolean [][] atlantic = new boolean [rows][columns];
        for(int k = 0; k < rows; k++)
        {
            //pacfic
            DFS(pacific, heights, rows, columns, k, 0, heights[k][0]);
            DFS(atlantic, heights, rows, columns, k, columns-1, heights[k][columns-1]);
        }
        for(int k = 0; k < columns; k++)
        {
            DFS(pacific, heights, rows, columns, 0, k, heights[0][k]);
            DFS(atlantic, heights, rows, columns, rows-1, k, heights[rows-1][k]);
        }
        
        for(int k = 0; k < rows; k++)
        {
            for(int j = 0; j < columns; j++)
            {
                if(pacific[k][j] == true && atlantic [k][j] == true)
                {
                    list.add(Arrays.asList(new Integer [] {k,j}));
                }
            }
        }
        return list;
    }
    
    public void DFS(boolean [][] ocean, int [][] heights, int rows, int columns, int row, int column, int prevValue)
    {
        if(row < 0 || row >= rows || column < 0 || column >= columns || prevValue > heights[row][column] || ocean[row][column] == true)
            return;
        ocean[row][column] = true;
        DFS(ocean, heights, rows, columns, row + 1, column, heights[row][column]);
        DFS(ocean, heights, rows, columns, row - 1, column,heights[row][column]);
        DFS(ocean, heights, rows, columns, row, column + 1,heights[row][column]);
        DFS(ocean, heights, rows, columns, row, column -1,heights[row][column]);
    }
    
}