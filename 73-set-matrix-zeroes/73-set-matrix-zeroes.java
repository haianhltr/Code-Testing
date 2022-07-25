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
               if(column.contains(j))
               {
                   matrix[k][j] = 0;
               }
               
                if(row.contains(k))
               {
                   matrix[k][j] = 0;
               }
           }
       }
        
        
        
        
        
    }
}

// 0 1
// 2 1
// 1 1

// 1 
    
    
// 0 0
// 0 1 
// 0 2


// 0 0 
// 0 1 *
// 0 2
// 1 0 **
// 1 1 *
// 1 2 **
// 2 0 
// 2 1 *
// 2 2