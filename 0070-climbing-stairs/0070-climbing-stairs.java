class Solution {
    int [] dp;
    public int climbStairs(int n) {
        dp = new int[n+1];
        dp[0] = 1;
        return dfs(n);
    }
    
    public int dfs(int n)
    {
        if(n < 0)
            return 0;
        if(dp[n] != 0)
            return dp[n];
        else
        {
            return dp[n] = dfs(n-1) + dfs(n-2);
        }
    }
}