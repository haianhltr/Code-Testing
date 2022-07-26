class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList();
        int top = 0;
        int bottom = matrix.length;
        int left = 0;
        int right = matrix[0].length;
        
        while(top < bottom && left < right){
        for(int k = left ; k  < right; k++)
        {
            list.add(matrix[top][k]);
        }
        
       top++;
        
        for(int k = top; k < bottom; k++)
        {
            list.add(matrix[k][right-1]);
        }
        
        right--;
            
        if(left >= right || top >= bottom) break;
        
        for(int k = right-1; k >= left; k-- )
        {
            list.add(matrix[bottom-1][k]);
        }
        
        bottom--;
        
        
        for(int k  = bottom-1; k >= top; k--)
        {
               list.add(matrix[k][left]);
        }
        
        left++;
        
        
        }
        
        return list;
        
    }
}


// 00 01 02
// 10 11 12
// 20 21 22