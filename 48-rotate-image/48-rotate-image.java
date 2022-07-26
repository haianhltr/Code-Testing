class Solution {
    public void rotate(int[][] matrix) {
        for(int k = 0; k < matrix.length; k++)
        {
            for(int j = k; j < matrix[0].length; j++)
            {
                int temp = matrix[k][j];
                matrix[k][j] = matrix[j][k];
                matrix[j][k] = temp;
            }
        }
        
        
        
        for(int k = 0 ; k < matrix.length; k++)
        {
            
            int start = 0;
            int end = matrix[0].length-1;
            while(start<end)
            {
            int temp = matrix[k][start];
            matrix[k][start] = matrix[k][end];
            matrix[k][end] = temp;
            start++;
            end--;
            }
         
      
            
        }
        
    }
}