class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if(original.length != m*n) return new int [0][0];
        int [][]result = new int [m][n];
        int length = 0;
        for(int k = 0; k < m ; k++)
        {
            for(int j = 0; j < n; j ++)
            {
                result[k][j] = original[length++];
            }
        }
        return result;
    }
}