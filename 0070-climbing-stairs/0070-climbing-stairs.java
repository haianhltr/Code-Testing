class Solution {
    public int climbStairs(int n) {
        int [] dp = new int[n+1];
        return dfs(n, dp);
        
    }
    
    public int dfs(int n, int [] dp)
    {
        if(n < 2) return 1;
        if(dp[n] != 0) return dp[n];
        dp[n] = dfs(n-1, dp) + dfs(n-2, dp);
        return dp[n];
    }
}