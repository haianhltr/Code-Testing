class Solution {
    
    public int climbStairs(int n) {
        int [] dp = new int[n+ 1];
        DFS(n, dp);
        dp[1] = 1;
        return dp[n];
    }
    
    public int DFS(int n, int [] dp)
    {
        if(n <= 1) return 1;
        if(dp[n] != 0) return dp[n];
        return dp[n] = DFS(n-1, dp) + DFS(n-2, dp);
    
    }

}


