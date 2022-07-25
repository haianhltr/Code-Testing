class Solution {
    public void setZeroes(int[][] matrix) {
        Set<Integer> column = new HashSet();
        Set<Integer> row = new HashSet();
       for(int k = 0; k < matrix.length; k++)
       {
           for(int j = 0; j < matrix[0].length; j++)
           {
               if(matrix[k][j] == 0)
               {
                   column.add(j);
                   row.add(k);
               }
           }
       }
        
          for(int k = 0; k < matrix.length; k++)
       {
           for(int j = 0; j < matrix[0].length; j++)
           {
               if(column.contains(j) || row.contains(k))
               {
                   matrix[k][j] = 0;
               }
               
               
           }
       }
        
        
        
        
        
    }
}

