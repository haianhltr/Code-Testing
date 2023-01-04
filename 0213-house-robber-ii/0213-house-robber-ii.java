class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 1) return nums[0];
        int [] arr1 = new int[len-1];
        int []  arr2= new int[len -1];
        for(int k =0; k < len - 1; k++)
        {
            arr1[k] = nums[k];
            arr2[k] = nums[k+1];
            }
            
        
        return Math.max(DP(arr1), DP(arr2));
        
    }
    
    //bottom up
    public int DP(int [] nums)
    {
        int len = nums.length;
        int [] dp = new int[len];
        dp[0]  = nums[0];
        for(int k = 1; k < len; k++)
        {
            int include = nums[k];
            if(k > 1)
            {
                include = include + dp[k-2]; 
            }
            int exclude = dp[k-1];
            dp[k] = Math.max(include, exclude);
        }
        return dp[len-1];
    }
}


// 0 1 2
// 1 2 3

// 1 2 4


//     0 1 2
//     1 2 3
    
// dp  0 1 2
//     1 2
//     k = 1
//     include =2
//     exclude = 1
    
//     k = 2
//     include = 3 => include = 3 + 1 = 4
//     exclude = 2 => exclude = 2
