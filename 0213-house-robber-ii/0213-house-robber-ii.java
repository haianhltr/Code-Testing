class Solution {
    public int rob(int[] nums) {
        //top down
        int len = nums.length;
        if(len == 1) return nums[0];
        int [] arr1= new int[len-1];
        int [] arr2= new int[len-1];
        for(int k = 0; k < len-1;k++)
        {
            arr1[k] = nums[k];
            arr2[k] = nums[k+1];
        }
        
     
        
        int [] dp1 = new int[len - 1];
        int [] dp2 = new int[len - 1];
        for(int k = 0; k < dp1.length; k++)
        {
            dp1[k] = -1;
            dp2[k] = -1;
        }
        
        int ans1 = calc(arr1, len - 2, dp1);
        int ans2 = calc(arr2, len -2, dp2);
        return Math.max(ans1, ans2);
    }
    
    public int calc(int [] nums, int index, int [] dp)
    {
        if(index == 0)
        {
            return nums[index];
        }
        if(index < 0)
        {
            return 0;
        }
        
        if(dp[index] != -1)
        {
            return dp[index];
        }
        
        int include =  nums[index] +  calc(nums, index -2, dp);
        int exclude = calc(nums, index -1, dp);
        return dp[index] = Math.max(include ,exclude);
    }
    


    
    
}