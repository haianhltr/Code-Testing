class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList();
        int top = 0;
        int bottom = matrix.length-1;
        int left =0;
        int right = matrix[0].length-1;
        
        while(top <= bottom && left <= right )
        {
            
            for(int k = left; k <= right; k++)
            {
                list.add(matrix[top][k]);
            }
            top++;
            for(int k = top; k <= bottom; k++)
            {
                list.add(matrix[k][right]);
            }
            right--;
            
            if(left > right || top > bottom) break;
            for(int k = right; k >= left; k--)
            {
                list.add(matrix[bottom][k]);
            }
            bottom--;
            
            for(int k = bottom; k >= top; k--)
            {
                list.add(matrix[k][left]);
            }
            
            left++;
            
        }
        return list;
    }
}

// 00 01 02 03
// 10 11 12 13
// 20 21 22 23