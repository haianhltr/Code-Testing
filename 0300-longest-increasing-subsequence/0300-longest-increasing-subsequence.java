class Solution {
    public int lengthOfLIS(int[] nums) {
        int [] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        int length = 1;
        for(int k = 0; k < nums.length; k++)
        {
            length = Math.max(length, LIS(nums, k, dp));
        }
        
        return length;
        
    }
    
    public int LIS(int [] nums, int len, int [] dp)
    {
        if(len == 0)
            return 1;
        if(dp[len] != -1)
        {
            return dp[len];
        }
        int length = 1;
        for(int k = len -1; k >= 0; k--)
        {
            if(nums[len] > nums[k])
            length = Math.max(length, LIS(nums, k, dp) + 1);
        }
        
        dp[len] = length;
        return dp[len];
        
    }
}