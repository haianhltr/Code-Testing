class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int [] result = new int [nums.length];
        
        int store = 1;
        for(int k = 0; k < nums.length; k++){
            result[k] = store;
            store *= nums[k]; 
        }
        
        store = 1;
        
        for(int k = nums.length-1; k >= 0; k--)
        {
            
            result[k] *= store;
            store *= nums[k];
        }
        
        return result;
    }
}

// 1
// 1 2 3 4
// 1 1 2 6


// 1 2 3 4
// 1 1 2 6
// 24 12 8 6