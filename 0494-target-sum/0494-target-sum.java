class Solution {
    int total;
    public int findTargetSumWays(int[] nums, int target) {
        total = Arrays.stream(nums).sum();
        int [][] dp = new int[nums.length][2 * total + 1];
        for(int [] rows : dp)
        {
            Arrays.fill(rows, Integer.MIN_VALUE);
        }
        
        return calc(nums, target, 0, 0, dp);
    }
    
    public int calc(int [] nums, int target, int sum, int index, int [][] dp)
    {
        if(index == nums.length)
        {
            if(sum == target)
            {
                return 1;
            }
            else{
                return 0;
            }
        }
        
        int add = calc(nums, target, sum + nums[index], index + 1,dp);
        int sub = calc(nums,target, sum - nums[index], index + 1, dp);
        dp[index][sum + total] = add + sub;
        return dp[index][sum + total];
    }
}