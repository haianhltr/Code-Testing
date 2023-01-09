class Solution {
    public int[] countBits(int n) {
        int [] dp = new int[n + 1];
      
        for(int k = 0; k <= n;k++)
        {
            dp[k] = dp[k >> 1] + (k & 1);
        }
        return dp;
    }
}

