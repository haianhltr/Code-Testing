class Solution {
    public int lengthOfLIS(int[] nums) {
        int [] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for(int k = 1; k < nums.length; k++)
        {
            for(int j = k - 1; j >= 0; j--)
            {
                if(nums[k] > nums[j] && dp[k] < dp[j] + 1)
                {
                    dp[k] = dp[j]  +1; 
                }
            }
        }
        
        
        
        int max = 0;
        for(int a : dp)
        {

            max = Math.max(max, a);
        }
        return max;
    }
}


    // [10,9,2,5,3,7]
    //  1  1 1 2  