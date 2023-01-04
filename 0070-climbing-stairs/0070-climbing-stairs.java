class Solution {
    public int climbStairs(int n) {
        int [] dp = new int[n+1];
        dp[0] = 1;
        return calc(n,dp);
    }
    
    public int calc(int n, int [] dp)
    {
        if(n < 2)
        {
            return 1;
        }
        
        if(dp[n] != 0)
        {
            return dp[n];
        }
        
        dp[n] = calc(n-1, dp) + calc(n-2,dp);
        return dp[n];
    }
}